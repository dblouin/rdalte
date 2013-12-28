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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.RequirementsCoverageData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirements Coverage Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementsCoverageDataImpl#getNbRequirements <em>Nb Requirements</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementsCoverageDataImpl#getVerificationLevel <em>Verification Level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementsCoverageDataImpl extends IdentifiedElementImpl implements RequirementsCoverageData {
	/**
	 * The default value of the '{@link #getNbRequirements() <em>Nb Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbRequirements()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_REQUIREMENTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbRequirements() <em>Nb Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbRequirements()
	 * @generated
	 * @ordered
	 */
	protected int nbRequirements = NB_REQUIREMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerificationLevel() <em>Verification Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Float VERIFICATION_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerificationLevel() <em>Verification Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationLevel()
	 * @generated
	 * @ordered
	 */
	protected Float verificationLevel = VERIFICATION_LEVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementsCoverageDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.REQUIREMENTS_COVERAGE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbRequirements() {
		return nbRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbRequirements(int newNbRequirements) {
		int oldNbRequirements = nbRequirements;
		nbRequirements = newNbRequirements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENTS_COVERAGE_DATA__NB_REQUIREMENTS, oldNbRequirements, nbRequirements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getVerificationLevel() {
		return verificationLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerificationLevel(Float newVerificationLevel) {
		Float oldVerificationLevel = verificationLevel;
		verificationLevel = newVerificationLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENTS_COVERAGE_DATA__VERIFICATION_LEVEL, oldVerificationLevel, verificationLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__NB_REQUIREMENTS:
				return getNbRequirements();
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__VERIFICATION_LEVEL:
				return getVerificationLevel();
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
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__NB_REQUIREMENTS:
				setNbRequirements((Integer)newValue);
				return;
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__VERIFICATION_LEVEL:
				setVerificationLevel((Float)newValue);
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
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__NB_REQUIREMENTS:
				setNbRequirements(NB_REQUIREMENTS_EDEFAULT);
				return;
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__VERIFICATION_LEVEL:
				setVerificationLevel(VERIFICATION_LEVEL_EDEFAULT);
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
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__NB_REQUIREMENTS:
				return nbRequirements != NB_REQUIREMENTS_EDEFAULT;
			case CorePackage.REQUIREMENTS_COVERAGE_DATA__VERIFICATION_LEVEL:
				return VERIFICATION_LEVEL_EDEFAULT == null ? verificationLevel != null : !VERIFICATION_LEVEL_EDEFAULT.equals(verificationLevel);
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
		result.append(" (nbRequirements: ");
		result.append(nbRequirements);
		result.append(", verificationLevel: ");
		result.append(verificationLevel);
		result.append(')');
		return result.toString();
	}

} //RequirementsCoverageDataImpl
