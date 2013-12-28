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
package fr.openpeople.rdal.model.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.openpeople.rdal.model.core.ContractualElement;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.StakeHolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stake Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.StakeHolderImpl#getContractualElements <em>Contractual Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StakeHolderImpl extends ActorImpl implements StakeHolder {
	/**
	 * The cached value of the '{@link #getContractualElements() <em>Contractual Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContractualElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ContractualElement> contractualElements;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeHolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.STAKE_HOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContractualElement> getContractualElements() {
		if (contractualElements == null) {
			contractualElements = new EObjectWithInverseResolvingEList.ManyInverse<ContractualElement>(ContractualElement.class, this, CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS, CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS);
		}
		return contractualElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContractualElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS:
				return ((InternalEList<?>)getContractualElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS:
				return getContractualElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS:
				getContractualElements().clear();
				getContractualElements().addAll((Collection<? extends ContractualElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS:
				getContractualElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS:
				return contractualElements != null && !contractualElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StakeHolderImpl
