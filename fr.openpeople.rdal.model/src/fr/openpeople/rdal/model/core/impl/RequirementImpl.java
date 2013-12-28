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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.labsticc.framework.settings.model.settings.Category;
import fr.openpeople.rdal.model.core.Assumption;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementImpl#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementImpl#getRefinedBy <em>Refined By</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementImpl#getDerivations <em>Derivations</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementImpl#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementImpl#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends AbstractRequirementImpl implements Requirement {
	/**
	 * The cached value of the '{@link #getDerivedFrom() <em>Derived From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> derivedFrom;

	/**
	 * The cached value of the '{@link #getRefinedBy() <em>Refined By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> refinedBy;

	/**
	 * The cached value of the '{@link #getDerivations() <em>Derivations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivations()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> derivations;

	/**
	 * The cached value of the '{@link #getAssumptions() <em>Assumptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssumptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Assumption> assumptions;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected Category category;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getDerivedFrom() {
		if (derivedFrom == null) {
			derivedFrom = new EObjectWithInverseResolvingEList.ManyInverse<Requirement>(Requirement.class, this, CorePackage.REQUIREMENT__DERIVED_FROM, CorePackage.REQUIREMENT__DERIVATIONS);
		}
		return derivedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getRefinedBy() {
		if (refinedBy == null) {
			refinedBy = new EObjectResolvingEList<EObject>(EObject.class, this, CorePackage.REQUIREMENT__REFINED_BY);
		}
		return refinedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean getVerified() {
		return getSatisfactionLevel() == null ? null : getSatisfactionLevel() == 1.0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assumption> getAssumptions() {
		if (assumptions == null) {
			assumptions = new EObjectWithInverseResolvingEList<Assumption>(Assumption.class, this, CorePackage.REQUIREMENT__ASSUMPTIONS, CorePackage.ASSUMPTION__REQUIREMENTS);
		}
		return assumptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category getCategory() {
		if (category != null && category.eIsProxy()) {
			InternalEObject oldCategory = (InternalEObject)category;
			category = (Category)eResolveProxy(oldCategory);
			if (category != oldCategory) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.REQUIREMENT__CATEGORY, oldCategory, category));
			}
		}
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category basicGetCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(Category newCategory) {
		Category oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getDerivations() {
		if (derivations == null) {
			derivations = new EObjectWithInverseResolvingEList.ManyInverse<Requirement>(Requirement.class, this, CorePackage.REQUIREMENT__DERIVATIONS, CorePackage.REQUIREMENT__DERIVED_FROM);
		}
		return derivations;
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
			case CorePackage.REQUIREMENT__DERIVED_FROM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDerivedFrom()).basicAdd(otherEnd, msgs);
			case CorePackage.REQUIREMENT__DERIVATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDerivations()).basicAdd(otherEnd, msgs);
			case CorePackage.REQUIREMENT__ASSUMPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssumptions()).basicAdd(otherEnd, msgs);
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
			case CorePackage.REQUIREMENT__DERIVED_FROM:
				return ((InternalEList<?>)getDerivedFrom()).basicRemove(otherEnd, msgs);
			case CorePackage.REQUIREMENT__DERIVATIONS:
				return ((InternalEList<?>)getDerivations()).basicRemove(otherEnd, msgs);
			case CorePackage.REQUIREMENT__ASSUMPTIONS:
				return ((InternalEList<?>)getAssumptions()).basicRemove(otherEnd, msgs);
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
			case CorePackage.REQUIREMENT__DERIVED_FROM:
				return getDerivedFrom();
			case CorePackage.REQUIREMENT__REFINED_BY:
				return getRefinedBy();
			case CorePackage.REQUIREMENT__DERIVATIONS:
				return getDerivations();
			case CorePackage.REQUIREMENT__ASSUMPTIONS:
				return getAssumptions();
			case CorePackage.REQUIREMENT__CATEGORY:
				if (resolve) return getCategory();
				return basicGetCategory();
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
			case CorePackage.REQUIREMENT__DERIVED_FROM:
				getDerivedFrom().clear();
				getDerivedFrom().addAll((Collection<? extends Requirement>)newValue);
				return;
			case CorePackage.REQUIREMENT__REFINED_BY:
				getRefinedBy().clear();
				getRefinedBy().addAll((Collection<? extends EObject>)newValue);
				return;
			case CorePackage.REQUIREMENT__DERIVATIONS:
				getDerivations().clear();
				getDerivations().addAll((Collection<? extends Requirement>)newValue);
				return;
			case CorePackage.REQUIREMENT__ASSUMPTIONS:
				getAssumptions().clear();
				getAssumptions().addAll((Collection<? extends Assumption>)newValue);
				return;
			case CorePackage.REQUIREMENT__CATEGORY:
				setCategory((Category)newValue);
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
			case CorePackage.REQUIREMENT__DERIVED_FROM:
				getDerivedFrom().clear();
				return;
			case CorePackage.REQUIREMENT__REFINED_BY:
				getRefinedBy().clear();
				return;
			case CorePackage.REQUIREMENT__DERIVATIONS:
				getDerivations().clear();
				return;
			case CorePackage.REQUIREMENT__ASSUMPTIONS:
				getAssumptions().clear();
				return;
			case CorePackage.REQUIREMENT__CATEGORY:
				setCategory((Category)null);
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
			case CorePackage.REQUIREMENT__DERIVED_FROM:
				return derivedFrom != null && !derivedFrom.isEmpty();
			case CorePackage.REQUIREMENT__REFINED_BY:
				return refinedBy != null && !refinedBy.isEmpty();
			case CorePackage.REQUIREMENT__DERIVATIONS:
				return derivations != null && !derivations.isEmpty();
			case CorePackage.REQUIREMENT__ASSUMPTIONS:
				return assumptions != null && !assumptions.isEmpty();
			case CorePackage.REQUIREMENT__CATEGORY:
				return category != null;
		}
		return super.eIsSet(featureID);
	}

} //RequirementImpl
