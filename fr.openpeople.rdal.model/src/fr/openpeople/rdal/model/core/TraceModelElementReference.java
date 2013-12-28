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
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.openpeople.rdal.model.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.TraceModelElementReference#isContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getTraceModelElementReference()
 * @model
 * @generated
 */
public interface TraceModelElementReference extends ModelElementReference, RequirementsCoverageData {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(boolean)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getTraceModelElementReference_Container()
	 * @model required="true"
	 * @generated
	 */
	boolean isContainer();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.TraceModelElementReference#isContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #isContainer()
	 * @generated
	 */
	void setContainer(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void merge(TraceModelElementReference modelElementReference);

} // TraceModelElementReference
