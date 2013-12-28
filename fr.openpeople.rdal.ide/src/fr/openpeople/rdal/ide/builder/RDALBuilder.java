/*******************************************************************************
 * Copyright (c) 2011 Lab-STICC Universite de Bretagne Sud, Lorient.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the CeCILL-B license available
 * at :
 * en : http://www.cecill.info/licences/Licence_CeCILL-B_V1-en.html
 * fr : http://www.cecill.info/licences/Licence_CeCILL-B_V1-fr.html
 * 
 * Contributors:
 * Dominique BLOUIN (Lab-STICC UBS), dominique.blouin@univ-ubs.fr
 ******************************************************************************/
package fr.openpeople.rdal.ide.builder;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.core.exception.SystemException;
import fr.labsticc.framework.emf.core.util.EMFUtil;
import fr.labsticc.framework.emf.view.EmfFwIdePlugin;
import fr.labsticc.framework.ide.resource.ExtensionsResourcesVisitor;
import fr.openpeople.rdal.ide.RadlBusinessDelegateFactory;
import fr.openpeople.rdal.ide.RdalIdePlugin;
import fr.openpeople.rdal.ide.view.traceability.navigator.ICoverageLister;
import fr.openpeople.rdal.ide.view.traceability.navigator.ParentExcludingResourcesVisitor;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RequirementsCoverageData;
import fr.openpeople.rdal.model.core.Trace;
import fr.openpeople.rdal.model.core.TraceModelElementReference;
import fr.openpeople.rdal.service.IRequirementsTraceabilityBusinessDelegate;

public class RDALBuilder extends IncrementalProjectBuilder {
	
	public static final String BUILDER_ID = "fr.openpeople.rdal.ide.rdalBuilder";

	private static final String MARKER_TYPE = EValidator.MARKER;//"fr.openpeople.rdal.ide.rdalSatisfactionProblem";
	
	//private final IRequirementsTraceabilityBusinessDelegate delegate;
	private final IExceptionHandler exceptionHandler;
	private final Collection<ICoverageLister> coverageListers;

	public RDALBuilder() {
		// Only instantiate as needed to ensure the Settings plugin has started.
	//	try {
			//delegate = RadlBusinessDelegateFactory.getInstance().getTraceabilityBusinessDelegate();
			exceptionHandler = RdalIdePlugin.getDefault().getExceptionHandler();
			coverageListers = RdalIdePlugin.getDefault().getDefinedCoverageListers();
//		}
//		catch ( final ResourceAccessException p_ex ) {
//			throw new RuntimeException( p_ex );
//		}
	}
	
	private IRequirementsTraceabilityBusinessDelegate getTraceabilityDelegate() 
	throws CoreException {
		try {
			return RadlBusinessDelegateFactory.getInstance().getTraceabilityBusinessDelegate();
		}
		catch ( final ResourceAccessException p_ex ) {
			throw new CoreException( new Status( IStatus.ERROR, RdalIdePlugin.getDefault().getBundle().getSymbolicName(), p_ex.getLocalizedMessage(), p_ex ) );
		}
	}

	private class DesignSpecResourceDeltaVisitor extends DesignSpecificationsVisitor implements IResourceDeltaVisitor {

		public DesignSpecResourceDeltaVisitor( 	final Collection<EClass> supportedDesignSpecificationTypes,
												final Collection<String> supportedDesignSpecificationFileTypes ) {
			super( 	supportedDesignSpecificationTypes, 
					supportedDesignSpecificationFileTypes,
					EmfFwIdePlugin.getDefault().getResourceHandlers() );
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		public boolean visit( final IResourceDelta p_delta )
		throws CoreException {
			final IResource resource = p_delta.getResource();
			
			switch ( p_delta.getKind() ) {
				case IResourceDelta.ADDED:
				case IResourceDelta.CHANGED:
					return super.visit( resource );
			}

			//return true to continue visiting children.
			return true;
		}
	}

	private void addMarker( final EObject p_modelObject,
							final String p_message )
	throws CoreException {
		assert p_modelObject.eResource() != null : "EObject should have a resource.";
		
		final IResource resource = EMFUtil.convertToIDEResource( p_modelObject.eResource() );
		final IMarker marker = resource.createMarker( MARKER_TYPE );
		marker.setAttribute( IMarker.MESSAGE, p_message == null ? "Model object is not satisfying all its requirements." : p_message );
		marker.setAttribute( IMarker.SEVERITY, IMarker.SEVERITY_ERROR );
		marker.setAttribute( EValidator.URI_ATTRIBUTE, EcoreUtil.getURI( p_modelObject ).toString() );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IProject[] build(	final int pi_kind, 
								@SuppressWarnings("rawtypes") final Map p_args, 
								final IProgressMonitor p_monitor )
	throws CoreException {
		if ( pi_kind == FULL_BUILD ) {
			fullBuild( p_monitor );
		}
		else {
			final IResourceDelta delta = getDelta( getProject() );
			
			if ( delta == null ) {
				fullBuild( p_monitor );
			}
			else {
				// Always perform a full build because it may happen that only the RDAL specs changed.
				// The requirements still need to be evaluated against the design.
				// TODO: Implement a dependency manager lik that of QAML
				// FIXME: Problem with requirements shared across several projects.
				fullBuild( p_monitor );
//				incrementalBuild( delta, p_monitor );
			}
		}
		
		return null;
	}

	private void deleteMarkers( final IResource p_resource )
	throws CoreException {
		p_resource.deleteMarkers( MARKER_TYPE, false, IResource.DEPTH_INFINITE );
		
		for ( final ICoverageLister lister : getCoverageListers() ) {
			lister.deleteCoverageData( p_resource );
		}
	}

	protected void fullBuild( final IProgressMonitor p_monitor )
	throws CoreException {
		final IRequirementsTraceabilityBusinessDelegate delegate = getTraceabilityDelegate();
		final DesignSpecificationsVisitor visitor = new DesignSpecificationsVisitor( 	delegate.supportedDesignSpecificationTypes(),
																						delegate.supportedDesignSpecificationFileTypes(),
																						EmfFwIdePlugin.getDefault().getResourceHandlers() );
		
		try {
			getProject().accept( visitor );
			
			build( visitor, p_monitor );
			
			//deleteMarkers( getProject() );
			//processSpecifications( visitor.getDesignSpecifications(), p_monitor );
		}
		catch ( final CoreException p_ex ) {
			exceptionHandler.handleException( p_ex, null );
		}
		catch ( final ResourceAccessException p_ex ) {
			exceptionHandler.handleException( p_ex, null );
		}
	}

	@Override
	protected void clean( final IProgressMonitor p_monitor )
	throws CoreException {
		final ExtensionsResourcesVisitor visitor = new ExtensionsResourcesVisitor( getTraceabilityDelegate().supportedDesignSpecificationFileTypes() );
		getProject().accept( visitor );

		deleteMarkers( getProject() );
	}
	
	private void processSpecifications( final Collection<EObject> p_designSpecifications,
			 							final IProgressMonitor p_monitor ) 
	throws CoreException {
		final IProject project = getProject();
		final ParentExcludingResourcesVisitor visitor = new ParentExcludingResourcesVisitor( project, null );
		project.accept( visitor, IResource.DEPTH_ONE, false );
		
		p_monitor.beginTask( "Requirements analysis", p_designSpecifications.size() + visitor.getFoundResources().size() );
			
		try {
			final Trace trace = getTraceabilityDelegate().evaluateConstraints( p_designSpecifications, p_monitor );
			
			for ( final ModelElementReference modelRef : trace.getModelElementReferences() ) {
				final TraceModelElementReference traceRef = (TraceModelElementReference) modelRef;
				final EObject modelElement = traceRef.getModelElement();
				final Float verificationLevel = traceRef.getVerificationLevel();
				final int nbRequirements = traceRef.getNbRequirements();
				
				if ( !traceRef.isContainer() && getTraceabilityDelegate().isDesignElementSatisfiable( modelElement ) ) {
					if ( traceRef.getVerifies() == null || !traceRef.getVerifies() ) {
						addMarker( modelElement, traceRef.getReason() );
					}
				}
				
				for ( final ICoverageLister lister : getCoverageListers() ) {
					lister.storeCoverageData( modelElement, verificationLevel, nbRequirements );
				}
			}
			
			storeCoverageData( project, storeCoverageData( trace, project, p_monitor ) );
		}
		catch ( final InterruptedException p_ex ) {
			p_monitor.setCanceled( true );
		}
		catch ( final SystemException p_ex ) {
			exceptionHandler.handleException( p_ex, null );
		}
		catch ( final ConstraintException p_ex ) {
			exceptionHandler.handleException( p_ex, null );
		}
		catch ( final CoreException p_ex ) {
			exceptionHandler.handleException( p_ex, null );
		}
		finally {
			p_monitor.done();
		}
	}
	
	private RequirementsCoverageData storeCoverageData( final Trace p_trace,
														final IResource p_resource,
														final IProgressMonitor p_monitor ) 
	throws CoreException {
		final ParentExcludingResourcesVisitor visitor = new ParentExcludingResourcesVisitor( p_resource, null );
		
		p_resource.accept( visitor, IResource.DEPTH_ONE, false );
		
		int totalNbReq = 0;
		int totalNbVerifiedReq = 0;

		for ( final IResource childResource : visitor.getFoundResources() ) {
			final RequirementsCoverageData coverageData;
			
			if ( childResource instanceof IFile && EMFUtil.isEMFResource( childResource ) ) {
				coverageData = findCoverageData( p_trace, (IFile) childResource );
			}
			else {
				coverageData = storeCoverageData( p_trace, childResource, null );
			}
			
			if ( coverageData != null ) {
				storeCoverageData( childResource, coverageData );

				final Integer nbReq = coverageData.getNbRequirements();
				totalNbReq += nbReq;
				totalNbVerifiedReq += coverageData.getVerificationLevel() * nbReq;
			}
			
			if ( p_monitor != null ) {
				p_monitor.worked( 1 );
			}
		}
		
		if ( totalNbReq != 0 ) {
			final RequirementsCoverageData newCoverageData = CoreFactory.eINSTANCE.createRequirementsCoverageData();
			newCoverageData.setNbRequirements( totalNbReq );
			newCoverageData.setVerificationLevel( (float) totalNbVerifiedReq / totalNbReq );

			return newCoverageData;
		}
		
		return null;
	}
	
	private void storeCoverageData( final IResource p_resource,
									final RequirementsCoverageData p_data ) 
	throws CoreException {
		if ( p_data != null ) {
			for ( final ICoverageLister lister : getCoverageListers() ) {
				lister.storeCoverageData( p_resource, p_data.getVerificationLevel(), p_data.getNbRequirements() );
			}
		}
	}
	
	private RequirementsCoverageData findCoverageData( 	final Trace p_trace,
														final IFile p_file ) 
	throws CoreException {
		Resource eResource = EMFUtil.convertToEMFResource( p_file );
			
		if ( eResource == null || eResource.getContents().isEmpty() ) {
			return null;
		}
		
		final EObject rootElement = eResource.getContents().get( 0 );
		final URI uri = EcoreUtil.getURI( rootElement ); 
		
		for ( final ModelElementReference modelRef : p_trace.getModelElementReferences() ) {
			if ( uri.equals( EcoreUtil.getURI( modelRef.getModelElement() ) ) ) {
				return (TraceModelElementReference) modelRef;
			}
		}
		
		return null;
	}
	
	protected void incrementalBuild( 	final IResourceDelta p_delta,
										final IProgressMonitor p_monitor )
	throws CoreException, ResourceAccessException {
		final IRequirementsTraceabilityBusinessDelegate delegate = getTraceabilityDelegate();
		final DesignSpecResourceDeltaVisitor visitor = new DesignSpecResourceDeltaVisitor( 	delegate.supportedDesignSpecificationTypes(),
																							delegate.supportedDesignSpecificationFileTypes());
		p_delta.accept( visitor );
		build( visitor, p_monitor );
	}
	
	private void build( final DesignSpecificationsVisitor p_visitor,
						final IProgressMonitor p_monitor ) 
	throws ResourceAccessException, CoreException {
		// Must be called before processing because this call updates the changed resources. 
		final Collection<EObject> designSpecifications = p_visitor.getDesignSpecifications();
		
//		final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
//
//			@Override
//			protected void execute(IProgressMonitor monitor)
//					throws CoreException, InvocationTargetException,
//					InterruptedException {

				for ( final IResource designRes : p_visitor.getFoundResources() ) {
					deleteMarkers( designRes );
				}
				
				processSpecifications( designSpecifications, p_monitor );
//			}
//		};
//		
//		try {
//			operation.run( p_monitor );
//		}
//		catch ( final InvocationTargetException p_ex ) {
//			throw new ResourceAccessException( p_ex );
//		}
//		catch ( final InterruptedException p_ex ) {
//		}
	}
	
	protected Collection<ICoverageLister> getCoverageListers() {
		return coverageListers;
	}
}
