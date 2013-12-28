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
package fr.openpeople.rdal.ide.view;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

import fr.labsticc.framework.constraints.ide.ConstraintsIDEPlugin;
import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.ide.viewpart.EmptyPage;
import fr.labsticc.framework.ide.viewpart.IPageFactory;
import fr.labsticc.framework.ide.viewpart.IViewPartPage;
import fr.openpeople.rdal.ide.RadlBusinessDelegateFactory;
import fr.openpeople.rdal.ide.view.requirement.RequirementViewPage;
import fr.openpeople.rdal.ide.view.traceability.RequirementTraceabilityViewPage;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.CorePackage;

public class RequirementsEditorPageFactory implements IPageFactory<EObject> {
	
	private static final RequirementsEditorPageFactory instance = new RequirementsEditorPageFactory();
	
	public static RequirementsEditorPageFactory getInstance() {
		return instance;
	}
	
	private final RadlBusinessDelegateFactory delegateFactory;
	
	private final Object traceabilityKey;
	
	private RequirementsEditorPageFactory() {
		delegateFactory = RadlBusinessDelegateFactory.getInstance();
		traceabilityKey = "satisfyTraceability";
//		
//		try {
//			traceabilityKey = delegateFactory.getTraceabilityBusinessDelegate().supportedSatisfiableDesignTypes().iterator().next();
//		}
//		catch ( final ResourceAccessException p_ex ) {
//			throw new RuntimeException( p_ex );
//		}
	}
	
	private IViewPartPage<EObject> createEmptyPage( final Composite p_parent,
													final IExceptionHandler p_exceptionHandler ) {
		return new EmptyPage<EObject>(p_parent, p_exceptionHandler);
	}
	
	@Override
	public Object getPageKey( final EObject p_modelObject ) 
	throws ResourceAccessException {
		if ( p_modelObject == null ) {
			return "EMPTY_PAGE";
		}
		
		// We want the same page for any element that can satisfy a requirement or can contain elements that can satisfy requirements.
		if ( delegateFactory.getTraceabilityBusinessDelegate().isDesignElementSatisfiableInclContainers( p_modelObject ) ) {
			return traceabilityKey;
		}

		return  p_modelObject.eClass();
	}
	
	@Override
	public IViewPartPage<? extends EObject> createPage( final Composite p_parent,
														final Object p_pageId,
														final IExceptionHandler p_exceptionHandler ) 
	throws ResourceAccessException {
		if ( 	p_pageId instanceof EClass &&
				CorePackage.eINSTANCE.getAbstractRequirement().isSuperTypeOf( (EClass) p_pageId ) ) {
			return createRequirementViewPage( p_parent, p_exceptionHandler );
		}
		
		if ( p_pageId == traceabilityKey ) {
			return createRequirementTracabilityViewPage( p_parent, p_exceptionHandler );
		}
		
		return createEmptyPage( p_parent, p_exceptionHandler );
	}
	
	private  IViewPartPage<EObject> createRequirementTracabilityViewPage( 	final Composite p_parent,
																			final IExceptionHandler p_exceptionHandler ) 
	throws ResourceAccessException {
		return new RequirementTraceabilityViewPage( p_parent, 
													delegateFactory.getTraceabilityBusinessDelegate(),
													p_exceptionHandler );
	}
	
	private IViewPartPage<AbstractRequirement> createRequirementViewPage(	final Composite p_parent,
																			final IExceptionHandler p_exceptionHandler ) 
	throws ResourceAccessException {
		return new RequirementViewPage( p_parent, 
										delegateFactory.getRequirementBusinessDelegate(),
										ConstraintsIDEPlugin.getDefault().getViewersConfiguration(),
										p_exceptionHandler );
	}
}
