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


import fr.labsticc.framework.constraints.model.constraints.Expression;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.AbstractRequirement#getContainedRequirements <em>Contained Requirements</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.AbstractRequirement#getExpression <em>Expression</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.AbstractRequirement#getGroup <em>Group</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.AbstractRequirement#getRisk <em>Risk</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.AbstractRequirement#getCompositionCoverage <em>Composition Coverage</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.AbstractRequirement#getVerifiedBy <em>Verified By</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getAbstractRequirement()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRequirement extends VerifiableElement {
	/**
	 * Returns the value of the '<em><b>Contained Requirements</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.AbstractRequirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Requirements</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAbstractRequirement_ContainedRequirements()
	 * @model
	 * @generated
	 */
	EList<AbstractRequirement> getContainedRequirements();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #setExpression(Expression)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAbstractRequirement_Expression()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.AbstractRequirement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Unsets the value of the '{@link fr.openpeople.rdal.model.core.AbstractRequirement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpression()
	 * @see #getExpression()
	 * @see #setExpression(Expression)
	 * @generated
	 */
	void unsetExpression();

	/**
	 * Returns whether the value of the '{@link fr.openpeople.rdal.model.core.AbstractRequirement#getExpression <em>Expression</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression</em>' containment reference is set.
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @see #setExpression(Expression)
	 * @generated
	 */
	boolean isSetExpression();

	/**
	 * Returns the value of the '<em><b>Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.RequirementsGroup#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' container reference.
	 * @see #setGroup(RequirementsGroup)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAbstractRequirement_Group()
	 * @see fr.openpeople.rdal.model.core.RequirementsGroup#getRequirements
	 * @model opposite="requirements" required="true" transient="false"
	 * @generated
	 */
	RequirementsGroup getGroup();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.AbstractRequirement#getGroup <em>Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' container reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(RequirementsGroup value);

	/**
	 * Returns the value of the '<em><b>Risk</b></em>' attribute.
	 * The default value is <code>"medium"</code>.
	 * The literals are from the enumeration {@link fr.openpeople.rdal.model.core.EnumRiskKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Risk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risk</em>' attribute.
	 * @see fr.openpeople.rdal.model.core.EnumRiskKind
	 * @see #setRisk(EnumRiskKind)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAbstractRequirement_Risk()
	 * @model default="medium"
	 * @generated
	 */
	EnumRiskKind getRisk();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.AbstractRequirement#getRisk <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risk</em>' attribute.
	 * @see fr.openpeople.rdal.model.core.EnumRiskKind
	 * @see #getRisk()
	 * @generated
	 */
	void setRisk(EnumRiskKind value);

	/**
	 * Returns the value of the '<em><b>Composition Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Coverage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Coverage</em>' attribute.
	 * @see #setCompositionCoverage(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAbstractRequirement_CompositionCoverage()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getCompositionCoverage();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.AbstractRequirement#getCompositionCoverage <em>Composition Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Coverage</em>' attribute.
	 * @see #getCompositionCoverage()
	 * @generated
	 */
	void setCompositionCoverage(Float value);

	/**
	 * Returns the value of the '<em><b>Verified By</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.VerificationActivity}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.VerificationActivity#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verified By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verified By</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getAbstractRequirement_VerifiedBy()
	 * @see fr.openpeople.rdal.model.core.VerificationActivity#getRequirement
	 * @model opposite="requirement"
	 * @generated
	 */
	EList<VerificationActivity> getVerifiedBy();

} // AbstractRequirement
