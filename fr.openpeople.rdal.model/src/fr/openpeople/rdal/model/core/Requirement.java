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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.settings.model.settings.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.Requirement#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Requirement#getRefinedBy <em>Refined By</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Requirement#getDerivations <em>Derivations</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Requirement#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Requirement#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends AbstractRequirement {
	/**
	 * Returns the value of the '<em><b>Derived From</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Requirement}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.Requirement#getDerivations <em>Derivations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived From</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirement_DerivedFrom()
	 * @see fr.openpeople.rdal.model.core.Requirement#getDerivations
	 * @model opposite="derivations"
	 * @generated
	 */
	EList<Requirement> getDerivedFrom();

	/**
	 * Returns the value of the '<em><b>Refined By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined By</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirement_RefinedBy()
	 * @model
	 * @generated
	 */
	EList<EObject> getRefinedBy();

	/**
	 * Returns the value of the '<em><b>Assumptions</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Assumption}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.Assumption#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assumptions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assumptions</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirement_Assumptions()
	 * @see fr.openpeople.rdal.model.core.Assumption#getRequirements
	 * @model opposite="requirements"
	 * @generated
	 */
	EList<Assumption> getAssumptions();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' reference.
	 * @see #setCategory(Category)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirement_Category()
	 * @model
	 * @generated
	 */
	Category getCategory();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Requirement#getCategory <em>Category</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' reference.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(Category value);

	/**
	 * Returns the value of the '<em><b>Derivations</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Requirement}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.Requirement#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivations</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirement_Derivations()
	 * @see fr.openpeople.rdal.model.core.Requirement#getDerivedFrom
	 * @model opposite="derivedFrom"
	 * @generated
	 */
	EList<Requirement> getDerivations();

} // Requirement
