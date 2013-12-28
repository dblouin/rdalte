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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.ModelElementReference#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ModelElementReference#getParent <em>Parent</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ModelElementReference#getVerifies <em>Verifies</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ModelElementReference#getReason <em>Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getModelElementReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='modelElementsContainedInSpecifedArchSpecs'"
 * @generated
 */
public interface ModelElementReference extends IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(EObject)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getModelElementReference_ModelElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ModelElementReference#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Verifies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verifies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verifies</em>' attribute.
	 * @see #setVerifies(Boolean)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getModelElementReference_Verifies()
	 * @model
	 * @generated
	 */
	Boolean getVerifies();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ModelElementReference#getVerifies <em>Verifies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verifies</em>' attribute.
	 * @see #getVerifies()
	 * @generated
	 */
	void setVerifies(Boolean value);

	/**
	 * Returns the value of the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reason</em>' attribute.
	 * @see #setReason(String)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getModelElementReference_Reason()
	 * @model
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ModelElementReference#getReason <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reason</em>' attribute.
	 * @see #getReason()
	 * @generated
	 */
	void setReason(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.ReferencedModelElements#getModelElementReferences <em>Model Element References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ReferencedModelElements)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getModelElementReference_Parent()
	 * @see fr.openpeople.rdal.model.core.ReferencedModelElements#getModelElementReferences
	 * @model opposite="modelElementReferences" required="true" transient="false"
	 * @generated
	 */
	ReferencedModelElements getParent();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ModelElementReference#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ReferencedModelElements value);

} // ModelElementReference
