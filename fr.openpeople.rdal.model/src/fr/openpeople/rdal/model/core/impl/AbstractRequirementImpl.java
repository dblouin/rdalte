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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.labsticc.framework.constraints.model.constraints.Expression;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.EnumRiskKind;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.AbstractRequirementImpl#getContainedRequirements <em>Contained Requirements</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.AbstractRequirementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.AbstractRequirementImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.AbstractRequirementImpl#getRisk <em>Risk</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.AbstractRequirementImpl#getCompositionCoverage <em>Composition Coverage</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.AbstractRequirementImpl#getVerifiedBy <em>Verified By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractRequirementImpl extends VerifiableElementImpl implements AbstractRequirement {
	/**
	 * The cached value of the '{@link #getContainedRequirements() <em>Contained Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRequirement> containedRequirements;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * This is true if the Expression containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean expressionESet;

	/**
	 * The default value of the '{@link #getRisk() <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRisk()
	 * @generated
	 * @ordered
	 */
	protected static final EnumRiskKind RISK_EDEFAULT = EnumRiskKind.HIGH;

	/**
	 * The cached value of the '{@link #getRisk() <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRisk()
	 * @generated
	 * @ordered
	 */
	protected EnumRiskKind risk = RISK_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompositionCoverage() <em>Composition Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionCoverage()
	 * @generated
	 * @ordered
	 */
	protected static final Float COMPOSITION_COVERAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompositionCoverage() <em>Composition Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionCoverage()
	 * @generated
	 * @ordered
	 */
	protected Float compositionCoverage = COMPOSITION_COVERAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVerifiedBy() <em>Verified By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifiedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationActivity> verifiedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ABSTRACT_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRequirement> getContainedRequirements() {
		if (containedRequirements == null) {
			containedRequirements = new EObjectResolvingEList<AbstractRequirement>(AbstractRequirement.class, this, CorePackage.ABSTRACT_REQUIREMENT__CONTAINED_REQUIREMENTS);
		}
		return containedRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		boolean oldExpressionESet = expressionESet;
		expressionESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION, oldExpression, newExpression, !oldExpressionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldExpressionESet = expressionESet;
			expressionESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION, newExpression, newExpression, !oldExpressionESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetExpression(NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = null;
		boolean oldExpressionESet = expressionESet;
		expressionESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION, oldExpression, null, oldExpressionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExpression() {
		if (expression != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION, null, msgs);
			msgs = basicUnsetExpression(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldExpressionESet = expressionESet;
			expressionESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION, null, null, oldExpressionESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpression() {
		return expressionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsGroup getGroup() {
		if (eContainerFeatureID() != CorePackage.ABSTRACT_REQUIREMENT__GROUP) return null;
		return (RequirementsGroup)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroup(RequirementsGroup newGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGroup, CorePackage.ABSTRACT_REQUIREMENT__GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(RequirementsGroup newGroup) {
		if (newGroup != eInternalContainer() || (eContainerFeatureID() != CorePackage.ABSTRACT_REQUIREMENT__GROUP && newGroup != null)) {
			if (EcoreUtil.isAncestor(this, newGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGroup != null)
				msgs = ((InternalEObject)newGroup).eInverseAdd(this, CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS, RequirementsGroup.class, msgs);
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ABSTRACT_REQUIREMENT__GROUP, newGroup, newGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumRiskKind getRisk() {
		return risk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRisk(EnumRiskKind newRisk) {
		EnumRiskKind oldRisk = risk;
		risk = newRisk == null ? RISK_EDEFAULT : newRisk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ABSTRACT_REQUIREMENT__RISK, oldRisk, risk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getCompositionCoverage() {
		return compositionCoverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionCoverage(Float newCompositionCoverage) {
		Float oldCompositionCoverage = compositionCoverage;
		compositionCoverage = newCompositionCoverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ABSTRACT_REQUIREMENT__COMPOSITION_COVERAGE, oldCompositionCoverage, compositionCoverage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VerificationActivity> getVerifiedBy() {
		if (verifiedBy == null) {
			verifiedBy = new EObjectWithInverseResolvingEList<VerificationActivity>(VerificationActivity.class, this, CorePackage.ABSTRACT_REQUIREMENT__VERIFIED_BY, CorePackage.VERIFICATION_ACTIVITY__REQUIREMENT);
		}
		return verifiedBy;
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
			case CorePackage.ABSTRACT_REQUIREMENT__GROUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGroup((RequirementsGroup)otherEnd, msgs);
			case CorePackage.ABSTRACT_REQUIREMENT__VERIFIED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVerifiedBy()).basicAdd(otherEnd, msgs);
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
			case CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION:
				return basicUnsetExpression(msgs);
			case CorePackage.ABSTRACT_REQUIREMENT__GROUP:
				return basicSetGroup(null, msgs);
			case CorePackage.ABSTRACT_REQUIREMENT__VERIFIED_BY:
				return ((InternalEList<?>)getVerifiedBy()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CorePackage.ABSTRACT_REQUIREMENT__GROUP:
				return eInternalContainer().eInverseRemove(this, CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS, RequirementsGroup.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ABSTRACT_REQUIREMENT__CONTAINED_REQUIREMENTS:
				return getContainedRequirements();
			case CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION:
				return getExpression();
			case CorePackage.ABSTRACT_REQUIREMENT__GROUP:
				return getGroup();
			case CorePackage.ABSTRACT_REQUIREMENT__RISK:
				return getRisk();
			case CorePackage.ABSTRACT_REQUIREMENT__COMPOSITION_COVERAGE:
				return getCompositionCoverage();
			case CorePackage.ABSTRACT_REQUIREMENT__VERIFIED_BY:
				return getVerifiedBy();
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
			case CorePackage.ABSTRACT_REQUIREMENT__CONTAINED_REQUIREMENTS:
				getContainedRequirements().clear();
				getContainedRequirements().addAll((Collection<? extends AbstractRequirement>)newValue);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__GROUP:
				setGroup((RequirementsGroup)newValue);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__RISK:
				setRisk((EnumRiskKind)newValue);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__COMPOSITION_COVERAGE:
				setCompositionCoverage((Float)newValue);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__VERIFIED_BY:
				getVerifiedBy().clear();
				getVerifiedBy().addAll((Collection<? extends VerificationActivity>)newValue);
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
			case CorePackage.ABSTRACT_REQUIREMENT__CONTAINED_REQUIREMENTS:
				getContainedRequirements().clear();
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION:
				unsetExpression();
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__GROUP:
				setGroup((RequirementsGroup)null);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__RISK:
				setRisk(RISK_EDEFAULT);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__COMPOSITION_COVERAGE:
				setCompositionCoverage(COMPOSITION_COVERAGE_EDEFAULT);
				return;
			case CorePackage.ABSTRACT_REQUIREMENT__VERIFIED_BY:
				getVerifiedBy().clear();
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
			case CorePackage.ABSTRACT_REQUIREMENT__CONTAINED_REQUIREMENTS:
				return containedRequirements != null && !containedRequirements.isEmpty();
			case CorePackage.ABSTRACT_REQUIREMENT__EXPRESSION:
				return isSetExpression();
			case CorePackage.ABSTRACT_REQUIREMENT__GROUP:
				return getGroup() != null;
			case CorePackage.ABSTRACT_REQUIREMENT__RISK:
				return risk != RISK_EDEFAULT;
			case CorePackage.ABSTRACT_REQUIREMENT__COMPOSITION_COVERAGE:
				return COMPOSITION_COVERAGE_EDEFAULT == null ? compositionCoverage != null : !COMPOSITION_COVERAGE_EDEFAULT.equals(compositionCoverage);
			case CorePackage.ABSTRACT_REQUIREMENT__VERIFIED_BY:
				return verifiedBy != null && !verifiedBy.isEmpty();
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
		result.append(" (risk: ");
		result.append(risk);
		result.append(", compositionCoverage: ");
		result.append(compositionCoverage);
		result.append(')');
		return result.toString();
	}

} //AbstractRequirementImpl
