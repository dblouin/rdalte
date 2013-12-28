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

import fr.openpeople.rdal.model.core.Actor;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Goal;
import fr.openpeople.rdal.model.core.SystemContext;
import fr.openpeople.rdal.model.core.SystemOverview;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Overview</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SystemOverviewImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SystemOverviewImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SystemOverviewImpl#getSystemToBe <em>System To Be</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SystemOverviewImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SystemOverviewImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SystemOverviewImpl#getCapabilities <em>Capabilities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemOverviewImpl extends IdentifiedElementImpl implements SystemOverview {
	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemContext> contexts;

	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The cached value of the '{@link #getSystemToBe() <em>System To Be</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemToBe()
	 * @generated
	 * @ordered
	 */
	protected EObject systemToBe;

	/**
	 * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final String PURPOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected String purpose = PURPOSE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> goals;

	/**
	 * The cached value of the '{@link #getCapabilities() <em>Capabilities</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilities()
	 * @generated
	 * @ordered
	 */
	protected EList<String> capabilities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOverviewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.SYSTEM_OVERVIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemContext> getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentEList<SystemContext>(SystemContext.class, this, CorePackage.SYSTEM_OVERVIEW__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectResolvingEList<Actor>(Actor.class, this, CorePackage.SYSTEM_OVERVIEW__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSystemToBe() {
		if (systemToBe != null && systemToBe.eIsProxy()) {
			InternalEObject oldSystemToBe = (InternalEObject)systemToBe;
			systemToBe = eResolveProxy(oldSystemToBe);
			if (systemToBe != oldSystemToBe) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.SYSTEM_OVERVIEW__SYSTEM_TO_BE, oldSystemToBe, systemToBe));
			}
		}
		return systemToBe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSystemToBe() {
		return systemToBe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemToBe(EObject newSystemToBe) {
		EObject oldSystemToBe = systemToBe;
		systemToBe = newSystemToBe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SYSTEM_OVERVIEW__SYSTEM_TO_BE, oldSystemToBe, systemToBe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		String oldPurpose = purpose;
		purpose = newPurpose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SYSTEM_OVERVIEW__PURPOSE, oldPurpose, purpose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getGoals() {
		if (goals == null) {
			goals = new EObjectContainmentEList<Goal>(Goal.class, this, CorePackage.SYSTEM_OVERVIEW__GOALS);
		}
		return goals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCapabilities() {
		if (capabilities == null) {
			capabilities = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.SYSTEM_OVERVIEW__CAPABILITIES);
		}
		return capabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.SYSTEM_OVERVIEW__CONTEXTS:
				return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
			case CorePackage.SYSTEM_OVERVIEW__GOALS:
				return ((InternalEList<?>)getGoals()).basicRemove(otherEnd, msgs);
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
			case CorePackage.SYSTEM_OVERVIEW__CONTEXTS:
				return getContexts();
			case CorePackage.SYSTEM_OVERVIEW__ACTORS:
				return getActors();
			case CorePackage.SYSTEM_OVERVIEW__SYSTEM_TO_BE:
				if (resolve) return getSystemToBe();
				return basicGetSystemToBe();
			case CorePackage.SYSTEM_OVERVIEW__PURPOSE:
				return getPurpose();
			case CorePackage.SYSTEM_OVERVIEW__GOALS:
				return getGoals();
			case CorePackage.SYSTEM_OVERVIEW__CAPABILITIES:
				return getCapabilities();
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
			case CorePackage.SYSTEM_OVERVIEW__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends SystemContext>)newValue);
				return;
			case CorePackage.SYSTEM_OVERVIEW__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case CorePackage.SYSTEM_OVERVIEW__SYSTEM_TO_BE:
				setSystemToBe((EObject)newValue);
				return;
			case CorePackage.SYSTEM_OVERVIEW__PURPOSE:
				setPurpose((String)newValue);
				return;
			case CorePackage.SYSTEM_OVERVIEW__GOALS:
				getGoals().clear();
				getGoals().addAll((Collection<? extends Goal>)newValue);
				return;
			case CorePackage.SYSTEM_OVERVIEW__CAPABILITIES:
				getCapabilities().clear();
				getCapabilities().addAll((Collection<? extends String>)newValue);
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
			case CorePackage.SYSTEM_OVERVIEW__CONTEXTS:
				getContexts().clear();
				return;
			case CorePackage.SYSTEM_OVERVIEW__ACTORS:
				getActors().clear();
				return;
			case CorePackage.SYSTEM_OVERVIEW__SYSTEM_TO_BE:
				setSystemToBe((EObject)null);
				return;
			case CorePackage.SYSTEM_OVERVIEW__PURPOSE:
				setPurpose(PURPOSE_EDEFAULT);
				return;
			case CorePackage.SYSTEM_OVERVIEW__GOALS:
				getGoals().clear();
				return;
			case CorePackage.SYSTEM_OVERVIEW__CAPABILITIES:
				getCapabilities().clear();
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
			case CorePackage.SYSTEM_OVERVIEW__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case CorePackage.SYSTEM_OVERVIEW__ACTORS:
				return actors != null && !actors.isEmpty();
			case CorePackage.SYSTEM_OVERVIEW__SYSTEM_TO_BE:
				return systemToBe != null;
			case CorePackage.SYSTEM_OVERVIEW__PURPOSE:
				return PURPOSE_EDEFAULT == null ? purpose != null : !PURPOSE_EDEFAULT.equals(purpose);
			case CorePackage.SYSTEM_OVERVIEW__GOALS:
				return goals != null && !goals.isEmpty();
			case CorePackage.SYSTEM_OVERVIEW__CAPABILITIES:
				return capabilities != null && !capabilities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (purpose: ");
		result.append(purpose);
		result.append(", capabilities: ");
		result.append(capabilities);
		result.append(')');
		return result.toString();
	}

} //SystemOverviewImpl
