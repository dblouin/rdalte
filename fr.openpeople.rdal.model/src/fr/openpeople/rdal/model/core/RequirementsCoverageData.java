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
 * A representation of the model object '<em><b>Requirements Coverage Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.RequirementsCoverageData#getNbRequirements <em>Nb Requirements</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.RequirementsCoverageData#getVerificationLevel <em>Verification Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsCoverageData()
 * @model
 * @generated
 */
public interface RequirementsCoverageData extends IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Nb Requirements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Requirements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Requirements</em>' attribute.
	 * @see #setNbRequirements(int)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsCoverageData_NbRequirements()
	 * @model
	 * @generated
	 */
	int getNbRequirements();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.RequirementsCoverageData#getNbRequirements <em>Nb Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Requirements</em>' attribute.
	 * @see #getNbRequirements()
	 * @generated
	 */
	void setNbRequirements(int value);

	/**
	 * Returns the value of the '<em><b>Verification Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verification Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verification Level</em>' attribute.
	 * @see #setVerificationLevel(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsCoverageData_VerificationLevel()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getVerificationLevel();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.RequirementsCoverageData#getVerificationLevel <em>Verification Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verification Level</em>' attribute.
	 * @see #getVerificationLevel()
	 * @generated
	 */
	void setVerificationLevel(Float value);

} // RequirementsCoverageData
