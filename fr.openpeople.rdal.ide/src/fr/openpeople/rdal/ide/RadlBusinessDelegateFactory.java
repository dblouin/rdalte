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
package fr.openpeople.rdal.ide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;

import fr.labsticc.framework.constraints.ide.ConstraintsIDEPlugin;
import fr.labsticc.framework.constraints.service.IConstraintInterpretationAS;
import fr.labsticc.framework.constraints.service.IConstraintPersistenceAS;
import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.ide.viewpart.IViewPageBusinessDelegate;
import fr.openpeople.rdal.ide.view.requirement.RequirementViewBusinessDelegate;
import fr.openpeople.rdal.ide.view.traceability.IDEReqTraceabilityBusinessDelegate;
import fr.openpeople.rdal.service.IRequirementBusinessDelegate;
import fr.openpeople.rdal.service.IRequirementsTraceabilityBusinessDelegate;

public class RadlBusinessDelegateFactory {

	private static final RadlBusinessDelegateFactory instance = new RadlBusinessDelegateFactory();
	
	private final Collection<IViewPageBusinessDelegate> businessDelegates;
	
	private RadlBusinessDelegateFactory() {
		businessDelegates = new ArrayList<IViewPageBusinessDelegate>();
	}
	
	public static RadlBusinessDelegateFactory getInstance() {
		return instance;
	}
	
	public IRequirementBusinessDelegate getRequirementBusinessDelegate()
	throws ResourceAccessException {
		for ( final IViewPageBusinessDelegate delegate : businessDelegates ) {
			if ( delegate instanceof IRequirementBusinessDelegate ) {
				return (IRequirementBusinessDelegate) delegate;
			}
		}
		
		try {
			final IRequirementBusinessDelegate delegate = createRequirementBusinessDelegate();
	 		businessDelegates.add( (IViewPageBusinessDelegate) delegate );
	 		
	 		return delegate;
		}
		catch ( final CoreException p_ex ) {
			throw new ResourceAccessException( p_ex );
		}
	}
	
	public IRequirementsTraceabilityBusinessDelegate getTraceabilityBusinessDelegate()
	throws ResourceAccessException {
		for ( final IViewPageBusinessDelegate delegate : businessDelegates ) {
			if ( delegate instanceof IRequirementsTraceabilityBusinessDelegate ) {
				return (IRequirementsTraceabilityBusinessDelegate) delegate;
			}
		}

		final IRequirementsTraceabilityBusinessDelegate delegate = createRequirementTraceabilityBusinessDelegate();
	 	businessDelegates.add( (IViewPageBusinessDelegate) delegate );
	 		
	 	return delegate;
	}
	
	private IRequirementsTraceabilityBusinessDelegate createRequirementTraceabilityBusinessDelegate() 
	throws ResourceAccessException { 
		return new IDEReqTraceabilityBusinessDelegate( getRequirementBusinessDelegate() );
	}
	
	private static IRequirementBusinessDelegate createRequirementBusinessDelegate() 
	throws CoreException {
		final ConstraintsIDEPlugin cstPlugin = ConstraintsIDEPlugin.getDefault();
		
		final Map<String, IConstraintInterpretationAS> reqInterpreters = cstPlugin.getConstraintInterpretationServicesByLanguageId();//new HashMap<String, IConstraintInterpretationAS>();
		final Map<String, IConstraintPersistenceAS> reqPersistenceServices = cstPlugin.getConstraintPersistenceServicesByLanguageId();//new HashMap<String, IConstraintPersistenceAS>();
//		
//		final Map<FormalConstraintLanguage, IConstraintInterpretationAS> interpreters = cstPlugin.getDefinedConstraintInterpretationServices();
//		final Map<ConstraintLanguage, IConstraintPersistenceAS> persistenceServices = cstPlugin.getDefinedConstraintPersistenceServices();
//		
//		for ( final ConstraintLanguage cstLanguage : cstPlugin.getDefinedConstraintLanguages() ) {
//			final IConstraintInterpretationAS interpreter = interpreters.get( cstLanguage );
//			
//			assert 	!( cstLanguage instanceof FormalConstraintLanguage ) || 
//					( cstLanguage instanceof FormalConstraintLanguage && interpreter != null ): 
//						"No constraint interpreter service defined for language " + cstLanguage.getName();
//			
//			if ( interpreter != null ) {
//				reqInterpreters.put( cstLanguage.getId(), interpreter );
//			}
//			
//			final IConstraintPersistenceAS persistenceAS = persistenceServices.get( cstLanguage );
//			
//			assert 	!( cstLanguage instanceof FormalConstraintLanguage ) || 
//					( cstLanguage instanceof FormalConstraintLanguage && persistenceAS != null ): 
//						"No constraint persistence service defined for language " + cstLanguage.getName();
//			
//			if ( persistenceAS != null ) {
//				reqPersistenceServices.put( cstLanguage.getId(), persistenceAS );
//			}
//		}
		
		return new RequirementViewBusinessDelegate( reqInterpreters, reqPersistenceServices );
	}
}
