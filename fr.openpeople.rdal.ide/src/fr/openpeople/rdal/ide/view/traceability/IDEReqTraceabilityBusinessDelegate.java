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
package fr.openpeople.rdal.ide.view.traceability;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.core.exception.SystemException;
import fr.labsticc.framework.core.util.ObjectReturnRunnable;
import fr.labsticc.framework.emf.core.resource.EMFResourcesVisitor;
import fr.labsticc.framework.settings.ide.SettingsPlugin;
import fr.labsticc.framework.settings.model.settings.ModelInterface;
import fr.openpeople.rdal.ide.IRDALConstants;
import fr.openpeople.rdal.ide.view.AbstractViewPageBusinessDelegate;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.Trace;
import fr.openpeople.rdal.model.core.TraceModelElementReference;
import fr.openpeople.rdal.service.IRequirementBusinessDelegate;
import fr.openpeople.rdal.service.IRequirementsTraceabilityBusinessDelegate;
import fr.openpeople.rdal.service.RequirementsTracabilityServicesFacade;

public class IDEReqTraceabilityBusinessDelegate extends AbstractViewPageBusinessDelegate implements IRequirementsTraceabilityBusinessDelegate {

	private static final Collection<EClass> SUPPORTED_SATISFIABLE_DESIGN_TYPES = SettingsPlugin.getDefault().getPropertyToTypeAssClasses( CorePackage.eINSTANCE.getModelElementReference_ModelElement() );

	private static final Collection<EClass> SUPPORTED_SATISFIABLE_DESIGN_TYPES_INCL_CONTAINERS = SettingsPlugin.getDefault().getPropertyToTypeAssClassesInclContainers( CorePackage.eINSTANCE.getModelElementReference_ModelElement() );

	private static final Collection<EClass> SUPPORTED_DESIGN_SPECIFICATION_TYPES = SettingsPlugin.getDefault().getPropertyToTypeAssClasses( CorePackage.eINSTANCE.getSpecification_Specifies() );
	
	private static final Collection<String> SUPPORTED_DESIGN_SPECIFICATION_FILE_TYPES = SettingsPlugin.getDefault().getSupportedLanguagesFileTypes();//Collections.singletonList( WorkspacePlugin.MODEL_FILE_EXT );

	private final RequirementsTracabilityServicesFacade tracabilityFacade;
	
	final Collection<? extends ModelInterface> systemArchitectureInterfaces; 

	public IDEReqTraceabilityBusinessDelegate( final IRequirementBusinessDelegate p_requirementDelegate ) {
		tracabilityFacade = new RequirementsTracabilityServicesFacade( 	p_requirementDelegate, 
																		SUPPORTED_SATISFIABLE_DESIGN_TYPES, 
																		SUPPORTED_SATISFIABLE_DESIGN_TYPES_INCL_CONTAINERS );
																		
		systemArchitectureInterfaces = SettingsPlugin.getDefault().allModelInterfaces();
	}
	
	// TODO: Move this to list?
	private String designSpecificationId( final EObject p_designSpecification ) {
//		if ( p_designSpecification instanceof SystemInstance ) {
//			return ( (SystemInstance) p_designSpecification ).getComponentInstancePath();
//		}
//		
//		if ( p_designSpecification instanceof AadlSpec ) {
		return EcoreUtil.getURI( p_designSpecification ).toString();
//		}
		
//		return null;
	}
	
	/**
	 * Performed in the delegate because it knows it is in the platform. Services are kept independent
	 * of this context.
	 * @param p_aadlElement
	 * @return
	 * @throws CoreException
	 */
	private Collection<Specification> workspaceSpecifications( 	final EObject p_designElement,
																final boolean pb_useEditingDomainResSet ) 
	throws CoreException, ResourceAccessException {
		final ResourceSet resSet;
		
		if ( pb_useEditingDomainResSet ) {
			final EditingDomain editingDomain = DiagramEditingDomainFactory.getInstance().createEditingDomain();
			resSet = editingDomain.getResourceSet();
		}
		else {
			final ModelInterface systArchInt = getSystArchModelInterface( p_designElement );
			
			if ( systArchInt != null && systArchInt.getCustomResourcet() != null ) {
				resSet = systArchInt.getCustomResourcet();
			}
			else {
				resSet = new ResourceSetImpl();
			}
		}

		final EMFResourcesVisitor visitor = new EMFResourcesVisitor( 	Collections.singleton( IRDALConstants.RDAL_EXTENSION ), 
																		null, 
																		null, 
																		resSet );
//		final IResourceVisitor visitor = new IResourceVisitor() {
//			
//			@Override
//			public boolean visit( final IResource p_resource )
//			throws CoreException {
//				if ( IRDALConstants.RDAL_EXTENSION.equals( p_resource.getFileExtension() ) ) {
//					final IPath path = p_resource.getFullPath();
//					final URI uri = URI.createPlatformResourceURI( path.toString(), false );
//					final Resource res = resSet.getResource( uri, true );
//					
//					if ( !res.getContents().isEmpty() ) {
//						final Specification reqSpec = (Specification) res.getContents().get( 0 );
//						
//						for ( final EObject designSpec : reqSpec.getSpecifies() ) {
//							// Only consider architecture specifications specified by the requirements specification.
//							if ( rootContainerId.equals( designSpecificationId( designSpec ) ) ) {
//								specs.add( reqSpec );
//								
//								break;
//							}
//						}
//					}
//					
//					return false;
//				}
//				
//				return true;
//			}
//		};
		
		for ( final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects() ) {
			if ( project.isOpen() ) {
				project.accept( visitor );
			}
		}

		final EObject rootContainer = EcoreUtil.getRootContainer( p_designElement );
		final String rootContainerId = designSpecificationId( rootContainer );
		final Collection<Specification> specs = new ArrayList<Specification>();

		for ( final Resource res : visitor.getFoundEMFResources() ) {
			for ( final EObject content : res.getContents() ) {
				if ( content instanceof Specification ) {
					final Specification reqSpec = (Specification) content;
					
					for ( final EObject designSpec : reqSpec.getSpecifies() ) {
						// Only consider architecture specifications specified by the requirements specification.
						if ( rootContainerId.equals( designSpecificationId( designSpec ) ) ) {
							specs.add( reqSpec );
							
							break;
						}
					}
				}
			}
		}
		
		return specs;
	}

	@Override
	public Trace evaluateConstraints( final EObject p_designSpecification )
	throws ConstraintException, SystemException, InterruptedException {
		try {
			final Trace trace = tracabilityFacade.evaluateConstraints( 	p_designSpecification, 
																		workspaceSpecifications( p_designSpecification, false ) ); 

			// We must save the specifications to save the calculated coverage information.
			for ( final Specification spec : trace.getSpecifications() ) {
				final Resource res = spec.eResource();
				res.save( getSaveOptions() );
			}
			
			return trace;
		}
		catch( final CoreException p_ex ) {
			throw new ResourceAccessException( p_ex );
		}
		catch ( final IOException p_ex ) {
			throw new ResourceAccessException( p_ex );
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdentifiedElement> Collection<T> satisfiableNodes(	final EObject p_designElement, 
																			final Class<T> p_class, 
																			final boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException {
		final ObjectReturnRunnableWithProgress runnable = new ObjectReturnRunnableWithProgress() {

			@Override
			public void run( final IProgressMonitor p_monitor ) {
				p_monitor.beginTask( "Searching Requirements...", 1 );
				
				try {
					result = tracabilityFacade.satisfiableNodes( 	p_designElement,
																	workspaceSpecifications( p_designElement, false ),
																	p_class, 
																	pb_recursive );
					p_monitor.worked( 1 );
				}
				catch ( final Throwable p_th ) {
					exception = p_th;
				}
				finally {
					p_monitor.done();
				}
			}
		};

		try {
			new ProgressMonitorDialog( Display.getCurrent().getActiveShell() ).run( false, false, runnable );
			
			if ( runnable.exception == null ) {
				return (Collection<T>) runnable.result;
			}

			if ( runnable.exception instanceof ConstraintException ) {
				throw (ConstraintException) runnable.exception;
			}
			if ( runnable.exception instanceof SystemException ) {
				throw (SystemException) runnable.exception;
			}
			if ( runnable.exception instanceof InterruptedException ) {
				throw (InterruptedException) runnable.exception;
			}

			throw new SystemException( runnable.exception );
		}
		catch ( final InvocationTargetException p_ex ) {
			throw new SystemException( p_ex );
		}
	}
	
	private static abstract class ObjectReturnRunnableWithProgress extends ObjectReturnRunnable implements IRunnableWithProgress {

		@Override
		public void run() {
			try {
				run( new NullProgressMonitor() );
			}
			catch ( final Throwable p_th ) {
				exception = p_th;
			}
		}
	}

	@Override
	public <T extends IdentifiedElement> Collection<? extends EObject> satisfiableNodes(	final EObject p_designElement, 
																							final T p_reqNode, 
																							final boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException {
		return tracabilityFacade.satisfiableNodes( 	p_designElement, 
													p_reqNode,
													pb_recursive );
	}

	@Override
	public Collection<EClass> supportedDesignSpecificationTypes() {
		return SUPPORTED_DESIGN_SPECIFICATION_TYPES;
	}

	@Override
	public Collection<String> supportedDesignSpecificationFileTypes() {
		return SUPPORTED_DESIGN_SPECIFICATION_FILE_TYPES;
	}

	@Override
	public Collection<EClass> supportedSatisfiableDesignTypes() {
		return SUPPORTED_SATISFIABLE_DESIGN_TYPES;
	}

	@Override
	public Collection<EClass> supportedSatisfiableDesignTypesInclContainers() {
		return SUPPORTED_SATISFIABLE_DESIGN_TYPES_INCL_CONTAINERS;
	}

	@Override
	public Trace evaluateConstraints( 	final Collection<EObject> p_designSpecifications,
										final Object p_progressModitor )
	throws ConstraintException, SystemException, InterruptedException {
		final IProgressMonitor monitor = (IProgressMonitor) p_progressModitor;
		final Trace report = CoreFactory.eINSTANCE.createTrace();
		
		for ( final EObject designSpec : p_designSpecifications ) {
			final Trace trace = evaluateConstraints( designSpec );
			
			// Use another list so that adding the elements does not corrupt the iterator
			final Collection<ModelElementReference> refElements = new ArrayList<ModelElementReference>( trace.getModelElementReferences() );

			for ( final ModelElementReference ref : refElements ) {
				final TraceModelElementReference existingRef = report.modelElementReference( ref.getModelElement() );
				
				if ( existingRef == null ) {
					report.getModelElementReferences().add( ref );
				}
				else {
					existingRef.merge( (TraceModelElementReference) ref  );
				}
			}

			monitor.worked( 1 );
		}
		
		return report;
	}

	@Override
	public boolean isDesignElementSatisfiable( final EObject p_designElement ) {
		for ( final EClass satClass : SUPPORTED_SATISFIABLE_DESIGN_TYPES ) {
			if ( satClass.isInstance( p_designElement ) ) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean isDesignElementSatisfiableInclContainers( final EObject p_designElement ) {
		for ( final EClass satClass : SUPPORTED_SATISFIABLE_DESIGN_TYPES_INCL_CONTAINERS ) {
			if ( satClass.isInstance( p_designElement ) ) {
				return true;
			}
		}
		
		return false;
	}
	
	private ModelInterface getSystArchModelInterface( final Object p_component ) {
		for ( final ModelInterface systArchInterface : systemArchitectureInterfaces ) {
			if ( systArchInterface.isModelElement( p_component ) ) {
				return systArchInterface;
			}
		}
		
		throw new IllegalStateException( "No system architecture interface defined for component " + p_component );
	}
}
