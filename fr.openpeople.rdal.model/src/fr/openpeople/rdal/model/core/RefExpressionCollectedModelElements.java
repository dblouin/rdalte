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

import fr.labsticc.framework.constraints.model.constraints.FormalLanguageExpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Expression Collected Model Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements#getQueryExpression <em>Query Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getRefExpressionCollectedModelElements()
 * @model
 * @generated
 */
public interface RefExpressionCollectedModelElements extends ContractReferencedModelElements {
	/**
	 * Returns the value of the '<em><b>Query Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Expression</em>' containment reference.
	 * @see #setQueryExpression(FormalLanguageExpression)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getRefExpressionCollectedModelElements_QueryExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FormalLanguageExpression getQueryExpression();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements#getQueryExpression <em>Query Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Expression</em>' containment reference.
	 * @see #getQueryExpression()
	 * @generated
	 */
	void setQueryExpression(FormalLanguageExpression value);

} // RefExpressionCollectedModelElements
