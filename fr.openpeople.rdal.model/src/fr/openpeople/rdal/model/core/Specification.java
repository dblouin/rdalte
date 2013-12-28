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

import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguagesSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getSpecifies <em>Specifies</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getActors <em>Actors</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getVerificationActivities <em>Verification Activities</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getRequirementGroups <em>Requirement Groups</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getConstraintLanguagesSpecification <em>Constraint Languages Specification</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getVersion <em>Version</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getSystOverview <em>Syst Overview</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Specification#getConflicts <em>Conflicts</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends VerifiableElement {
	/**
	 * Returns the value of the '<em><b>Specifies</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specifies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specifies</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_Specifies()
	 * @model required="true"
	 * @generated
	 */
	EList<EObject> getSpecifies();

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_Actors()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Verification Activities</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.VerificationActivity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verification Activities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verification Activities</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_VerificationActivities()
	 * @model containment="true"
	 * @generated
	 */
	EList<VerificationActivity> getVerificationActivities();

	/**
	 * Returns the value of the '<em><b>Requirement Groups</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.RequirementsGroup}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.RequirementsGroup#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Groups</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_RequirementGroups()
	 * @see fr.openpeople.rdal.model.core.RequirementsGroup#getSpecification
	 * @model opposite="specification" containment="true" required="true"
	 * @generated
	 */
	EList<RequirementsGroup> getRequirementGroups();

	/**
	 * Returns the value of the '<em><b>Constraint Languages Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Languages Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Languages Specification</em>' reference.
	 * @see #setConstraintLanguagesSpecification(ConstraintLanguagesSpecification)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_ConstraintLanguagesSpecification()
	 * @model required="true"
	 * @generated
	 */
	ConstraintLanguagesSpecification getConstraintLanguagesSpecification();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Specification#getConstraintLanguagesSpecification <em>Constraint Languages Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Languages Specification</em>' reference.
	 * @see #getConstraintLanguagesSpecification()
	 * @generated
	 */
	void setConstraintLanguagesSpecification(ConstraintLanguagesSpecification value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Specification#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Syst Overview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syst Overview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syst Overview</em>' containment reference.
	 * @see #setSystOverview(SystemOverview)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_SystOverview()
	 * @model containment="true"
	 * @generated
	 */
	SystemOverview getSystOverview();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Specification#getSystOverview <em>Syst Overview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syst Overview</em>' containment reference.
	 * @see #getSystOverview()
	 * @generated
	 */
	void setSystOverview(SystemOverview value);

	/**
	 * Returns the value of the '<em><b>Conflicts</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Conflict}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflicts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflicts</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSpecification_Conflicts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Conflict> getConflicts();

} // Specification
