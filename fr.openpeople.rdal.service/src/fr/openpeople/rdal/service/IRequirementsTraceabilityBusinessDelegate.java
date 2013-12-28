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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.core.exception.SystemException;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.model.core.Trace;

public interface IRequirementsTraceabilityBusinessDelegate {

	<T extends IdentifiedElement> Collection<? extends EObject> satisfiableNodes( 	EObject p_designElement,
																					T p_reqNode,
																					boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException;

	<T extends IdentifiedElement> Collection<T> satisfiableNodes( 	EObject p_designElement,
																	Class<T> p_reqNodeType,
																	boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException;
	
	Trace evaluateConstraints( EObject p_designElement )
	throws ConstraintException, SystemException, InterruptedException;
	
	Trace evaluateConstraints( 	Collection<EObject> p_designSpecifications,
								Object p_progressMonitor )
	throws ConstraintException, SystemException, InterruptedException;

	/**
	 * Returns the ecore classes of the design to which a requirement can be attached 
	 * ('{@link fr.openpeople.rdal.model.core.Requirement#getSatisfiedBy() <em>satisfiedBy</em>}' relation).
	 * @return
	 */
	Collection<EClass> supportedSatisfiableDesignTypes();
	
	/**
	 * Returns the ecore classes of the design to which a requirement can be attached 
	 * ('{@link fr.openpeople.rdal.model.core.Requirement#getSatisfiedBy() <em>satisfiedBy</em>}' relation), including
	 * the classes of components that may contain satisfiable elements.
	 * @return
	 */
	Collection<EClass> supportedSatisfiableDesignTypesInclContainers();
	
	boolean isDesignElementSatisfiable( final EObject p_designElement );

	boolean isDesignElementSatisfiableInclContainers( final EObject p_designElement );

	/**
	 * Returns the ecore classes of the supported design specification objects. Those are objects to which a requirements 
	 * specification can be	attached ('{@link fr.openpeople.rdal.model.core.Specification#getSpecifies() <em>specifies</em>}' 
	 * relation).
	 * @return
	 */
	Collection<EClass> supportedDesignSpecificationTypes();

	/**
	 * Returns the type of the files of the design to which requirements sepcifications can be attached.
	 * @return
	 */
	Collection<String> supportedDesignSpecificationFileTypes();
}
