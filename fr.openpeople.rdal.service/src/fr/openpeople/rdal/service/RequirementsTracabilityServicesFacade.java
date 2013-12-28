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
package fr.openpeople.rdal.service;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.core.exception.SystemException;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.Trace;

public class RequirementsTracabilityServicesFacade {
	
	private final RequirementsTracabilityAS tracabilityAs;
	
	public RequirementsTracabilityServicesFacade( 	final IRequirementBusinessDelegate p_requirementDelegate,
													final Collection<? extends EClassifier> p_supportedSatisfyingTypes,
													final Collection<? extends EClassifier> p_supportedSatisfyingTypesInclContainers ) {
		tracabilityAs = new RequirementsTracabilityAS( 	p_requirementDelegate, 
														p_supportedSatisfyingTypes, 
														p_supportedSatisfyingTypesInclContainers );
	}

	public <T extends IdentifiedElement> Collection<T> satisfiableNodes( 	final EObject p_designElement,
																			final Collection<Specification> p_availableSpecs,
																			final Class<T> p_nodeType,
																			boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException {
		return tracabilityAs.satisfiableNodes( 	p_designElement,
												p_availableSpecs,
												p_nodeType, 
												pb_recursive );
	}

	public <T extends IdentifiedElement> Collection<? extends EObject> satisfiableNodes(	final EObject p_designElement, 
																							final T p_reqNode, 
																							final boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException {
		return tracabilityAs.satisfiableNodes( p_designElement, p_reqNode, pb_recursive );
	}

	public Trace evaluateConstraints( 	final EObject p_designSpecification,
										final Collection<Specification> p_availableSpecs ) 
	throws ConstraintException, SystemException, InterruptedException {
		return tracabilityAs.evaluateConstraints( p_designSpecification, p_availableSpecs );
	}
}
