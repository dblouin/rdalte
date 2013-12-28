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

import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.SystemContext;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SystemContextImpl#getGlobalSystem <em>Global System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemContextImpl extends IdentifiedElementImpl implements SystemContext {
	/**
	 * The cached value of the '{@link #getGlobalSystem() <em>Global System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalSystem()
	 * @generated
	 * @ordered
	 */
	protected EObject globalSystem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.SYSTEM_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getGlobalSystem() {
		if (globalSystem != null && globalSystem.eIsProxy()) {
			InternalEObject oldGlobalSystem = (InternalEObject)globalSystem;
			globalSystem = eResolveProxy(oldGlobalSystem);
			if (globalSystem != oldGlobalSystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.SYSTEM_CONTEXT__GLOBAL_SYSTEM, oldGlobalSystem, globalSystem));
			}
		}
		return globalSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetGlobalSystem() {
		return globalSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalSystem(EObject newGlobalSystem) {
		EObject oldGlobalSystem = globalSystem;
		globalSystem = newGlobalSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SYSTEM_CONTEXT__GLOBAL_SYSTEM, oldGlobalSystem, globalSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.SYSTEM_CONTEXT__GLOBAL_SYSTEM:
				if (resolve) return getGlobalSystem();
				return basicGetGlobalSystem();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.SYSTEM_CONTEXT__GLOBAL_SYSTEM:
				setGlobalSystem((EObject)newValue);
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
			case CorePackage.SYSTEM_CONTEXT__GLOBAL_SYSTEM:
				setGlobalSystem((EObject)null);
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
			case CorePackage.SYSTEM_CONTEXT__GLOBAL_SYSTEM:
				return globalSystem != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemContextImpl
