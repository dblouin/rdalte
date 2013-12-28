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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Overview</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.SystemOverview#getContexts <em>Contexts</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.SystemOverview#getActors <em>Actors</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.SystemOverview#getSystemToBe <em>System To Be</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.SystemOverview#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.SystemOverview#getGoals <em>Goals</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.SystemOverview#getCapabilities <em>Capabilities</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getSystemOverview()
 * @model
 * @generated
 */
public interface SystemOverview extends IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.SystemContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSystemOverview_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<SystemContext> getContexts();

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSystemOverview_Actors()
	 * @model
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>System To Be</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System To Be</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System To Be</em>' reference.
	 * @see #setSystemToBe(EObject)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSystemOverview_SystemToBe()
	 * @model required="true"
	 * @generated
	 */
	EObject getSystemToBe();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.SystemOverview#getSystemToBe <em>System To Be</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System To Be</em>' reference.
	 * @see #getSystemToBe()
	 * @generated
	 */
	void setSystemToBe(EObject value);

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see #setPurpose(String)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSystemOverview_Purpose()
	 * @model required="true"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.SystemOverview#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(String value);

	/**
	 * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Goal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSystemOverview_Goals()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Goal> getGoals();

	/**
	 * Returns the value of the '<em><b>Capabilities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capabilities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capabilities</em>' attribute list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getSystemOverview_Capabilities()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getCapabilities();

} // SystemOverview
