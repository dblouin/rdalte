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
 * A representation of the model object '<em><b>Conflict</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.Conflict#getDegree <em>Degree</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Conflict#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getConflict()
 * @model
 * @generated
 */
public interface Conflict extends EObject {
	/**
	 * Returns the value of the '<em><b>Degree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degree</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degree</em>' attribute.
	 * @see #setDegree(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getConflict_Degree()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getDegree();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Conflict#getDegree <em>Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degree</em>' attribute.
	 * @see #getDegree()
	 * @generated
	 */
	void setDegree(Float value);

	/**
	 * Returns the value of the '<em><b>Goals</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.Goal}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.Goal#getConflicts <em>Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getConflict_Goals()
	 * @see fr.openpeople.rdal.model.core.Goal#getConflicts
	 * @model opposite="conflicts" lower="2" upper="2"
	 * @generated
	 */
	EList<Goal> getGoals();

} // Conflict
