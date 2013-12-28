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
 * A representation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.Assumption#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Assumption#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getAssumption()
 * @model
 * @generated
 */
public interface Assumption extends AbstractRequirement {
	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.Requirement#getAssumptions <em>Assumptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' reference.
	 * @see #setRequirements(Requirement)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAssumption_Requirements()
	 * @see fr.openpeople.rdal.model.core.Requirement#getAssumptions
	 * @model opposite="assumptions"
	 * @generated
	 */
	Requirement getRequirements();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Assumption#getRequirements <em>Requirements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirements</em>' reference.
	 * @see #getRequirements()
	 * @generated
	 */
	void setRequirements(Requirement value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.openpeople.rdal.model.core.EnumAssumptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see fr.openpeople.rdal.model.core.EnumAssumptionType
	 * @see #setType(EnumAssumptionType)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAssumption_Type()
	 * @model
	 * @generated
	 */
	EnumAssumptionType getType();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Assumption#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see fr.openpeople.rdal.model.core.EnumAssumptionType
	 * @see #getType()
	 * @generated
	 */
	void setType(EnumAssumptionType value);

} // Assumption
