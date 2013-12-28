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
 * A representation of the model object '<em><b>Verifiable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.VerifiableElement#getVerified <em>Verified</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getVerifiableElement()
 * @model
 * @generated
 */
public interface VerifiableElement extends ContractualElement {
	/**
	 * Returns the value of the '<em><b>Verified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verified</em>' attribute.
	 * @see #setVerified(Boolean)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getVerifiableElement_Verified()
	 * @model
	 * @generated
	 */
	Boolean getVerified();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.VerifiableElement#getVerified <em>Verified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verified</em>' attribute.
	 * @see #getVerified()
	 * @generated
	 */
	void setVerified(Boolean value);

} // VerifiableElement
