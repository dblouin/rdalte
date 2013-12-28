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
 * A representation of the model object '<em><b>Referenced Model Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.ReferencedModelElements#getModelElementReferences <em>Model Element References</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getReferencedModelElements()
 * @model abstract="true"
 * @generated
 */
public interface ReferencedModelElements extends IdentifiedElement {

	/**
	 * Returns the value of the '<em><b>Model Element References</b></em>' containment reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.ModelElementReference}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.ModelElementReference#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element References</em>' containment reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getReferencedModelElements_ModelElementReferences()
	 * @see fr.openpeople.rdal.model.core.ModelElementReference#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<ModelElementReference> getModelElementReferences();
} // ReferencedModelElements
