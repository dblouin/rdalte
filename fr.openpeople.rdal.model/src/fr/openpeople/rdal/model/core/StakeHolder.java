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
 * A representation of the model object '<em><b>Stake Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.StakeHolder#getContractualElements <em>Contractual Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getStakeHolder()
 * @model
 * @generated
 */
public interface StakeHolder extends Actor {

	/**
	 * Returns the value of the '<em><b>Contractual Elements</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.ContractualElement}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.ContractualElement#getStakeHolders <em>Stake Holders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contractual Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contractual Elements</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getStakeHolder_ContractualElements()
	 * @see fr.openpeople.rdal.model.core.ContractualElement#getStakeHolders
	 * @model opposite="stakeHolders"
	 * @generated
	 */
	EList<ContractualElement> getContractualElements();
} // StakeHolder
