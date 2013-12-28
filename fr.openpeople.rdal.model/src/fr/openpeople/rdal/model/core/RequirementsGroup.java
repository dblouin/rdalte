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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirements Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.RequirementsGroup#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.RequirementsGroup#getSpecification <em>Specification</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.RequirementsGroup#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.RequirementsGroup#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsGroup()
 * @model
 * @generated
 */
public interface RequirementsGroup extends VerifiableElement {
	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.AbstractRequirement}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.AbstractRequirement#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsGroup_Requirements()
	 * @see fr.openpeople.rdal.model.core.AbstractRequirement#getGroup
	 * @model opposite="group" containment="true" required="true"
	 * @generated
	 */
	EList<AbstractRequirement> getRequirements();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.Specification#getRequirementGroups <em>Requirement Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' container reference.
	 * @see #setSpecification(Specification)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsGroup_Specification()
	 * @see fr.openpeople.rdal.model.core.Specification#getRequirementGroups
	 * @model opposite="requirementGroups" required="true" transient="false"
	 * @generated
	 */
	Specification getSpecification();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.RequirementsGroup#getSpecification <em>Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' container reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(Specification value);

	/**
	 * Returns the value of the '<em><b>Sub Groups</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.RequirementsGroup}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.RequirementsGroup#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Groups</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsGroup_SubGroups()
	 * @see fr.openpeople.rdal.model.core.RequirementsGroup#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<RequirementsGroup> getSubGroups();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.RequirementsGroup#getSubGroups <em>Sub Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(RequirementsGroup)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRequirementsGroup_Parent()
	 * @see fr.openpeople.rdal.model.core.RequirementsGroup#getSubGroups
	 * @model opposite="subGroups"
	 * @generated
	 */
	RequirementsGroup getParent();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.RequirementsGroup#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(RequirementsGroup value);

} // RequirementsGroup
