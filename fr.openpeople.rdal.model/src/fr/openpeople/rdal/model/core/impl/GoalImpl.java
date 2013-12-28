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

import fr.openpeople.rdal.model.core.Conflict;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Goal;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.GoalImpl#getAchievedBy <em>Achieved By</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.GoalImpl#getConflicts <em>Conflicts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GoalImpl extends ContractualElementImpl implements Goal {
	/**
	 * The cached value of the '{@link #getAchievedBy() <em>Achieved By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAchievedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> achievedBy;

	/**
	 * The cached value of the '{@link #getConflicts() <em>Conflicts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflicts()
	 * @generated
	 * @ordered
	 */
	protected EList<Conflict> conflicts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getAchievedBy() {
		if (achievedBy == null) {
			achievedBy = new EObjectResolvingEList<EObject>(EObject.class, this, CorePackage.GOAL__ACHIEVED_BY);
		}
		return achievedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Conflict> getConflicts() {
		if (conflicts == null) {
			conflicts = new EObjectWithInverseResolvingEList.ManyInverse<Conflict>(Conflict.class, this, CorePackage.GOAL__CONFLICTS, CorePackage.CONFLICT__GOALS);
		}
		return conflicts;
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
			case CorePackage.GOAL__CONFLICTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConflicts()).basicAdd(otherEnd, msgs);
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
			case CorePackage.GOAL__CONFLICTS:
				return ((InternalEList<?>)getConflicts()).basicRemove(otherEnd, msgs);
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
			case CorePackage.GOAL__ACHIEVED_BY:
				return getAchievedBy();
			case CorePackage.GOAL__CONFLICTS:
				return getConflicts();
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
			case CorePackage.GOAL__ACHIEVED_BY:
				getAchievedBy().clear();
				getAchievedBy().addAll((Collection<? extends EObject>)newValue);
				return;
			case CorePackage.GOAL__CONFLICTS:
				getConflicts().clear();
				getConflicts().addAll((Collection<? extends Conflict>)newValue);
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
			case CorePackage.GOAL__ACHIEVED_BY:
				getAchievedBy().clear();
				return;
			case CorePackage.GOAL__CONFLICTS:
				getConflicts().clear();
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
			case CorePackage.GOAL__ACHIEVED_BY:
				return achievedBy != null && !achievedBy.isEmpty();
			case CorePackage.GOAL__CONFLICTS:
				return conflicts != null && !conflicts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GoalImpl
