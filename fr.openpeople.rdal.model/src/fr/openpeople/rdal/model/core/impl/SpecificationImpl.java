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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguagesSpecification;
import fr.openpeople.rdal.model.core.Actor;
import fr.openpeople.rdal.model.core.Conflict;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.SystemOverview;
import fr.openpeople.rdal.model.core.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getSpecifies <em>Specifies</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getVerificationActivities <em>Verification Activities</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getRequirementGroups <em>Requirement Groups</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getConstraintLanguagesSpecification <em>Constraint Languages Specification</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getSystOverview <em>Syst Overview</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.SpecificationImpl#getConflicts <em>Conflicts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationImpl extends VerifiableElementImpl implements Specification {
	/**
	 * The cached value of the '{@link #getSpecifies() <em>Specifies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifies()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> specifies;

	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The cached value of the '{@link #getVerificationActivities() <em>Verification Activities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationActivities()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationActivity> verificationActivities;

	/**
	 * The cached value of the '{@link #getRequirementGroups() <em>Requirement Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementsGroup> requirementGroups;

	/**
	 * The cached value of the '{@link #getConstraintLanguagesSpecification() <em>Constraint Languages Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintLanguagesSpecification()
	 * @generated
	 * @ordered
	 */
	protected ConstraintLanguagesSpecification constraintLanguagesSpecification;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSystOverview() <em>Syst Overview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystOverview()
	 * @generated
	 * @ordered
	 */
	protected SystemOverview systOverview;

	/**
	 * The cached value of the '{@link #getConflicts() <em>Conflicts</em>}' containment reference list.
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
	protected SpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getSpecifies() {
		if (specifies == null) {
			specifies = new EObjectResolvingEList<EObject>(EObject.class, this, CorePackage.SPECIFICATION__SPECIFIES);
		}
		return specifies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectContainmentEList<Actor>(Actor.class, this, CorePackage.SPECIFICATION__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VerificationActivity> getVerificationActivities() {
		if (verificationActivities == null) {
			verificationActivities = new EObjectContainmentEList<VerificationActivity>(VerificationActivity.class, this, CorePackage.SPECIFICATION__VERIFICATION_ACTIVITIES);
		}
		return verificationActivities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequirementsGroup> getRequirementGroups() {
		if (requirementGroups == null) {
			requirementGroups = new EObjectContainmentWithInverseEList<RequirementsGroup>(RequirementsGroup.class, this, CorePackage.SPECIFICATION__REQUIREMENT_GROUPS, CorePackage.REQUIREMENTS_GROUP__SPECIFICATION);
		}
		return requirementGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintLanguagesSpecification getConstraintLanguagesSpecification() {
		if (constraintLanguagesSpecification != null && constraintLanguagesSpecification.eIsProxy()) {
			InternalEObject oldConstraintLanguagesSpecification = (InternalEObject)constraintLanguagesSpecification;
			constraintLanguagesSpecification = (ConstraintLanguagesSpecification)eResolveProxy(oldConstraintLanguagesSpecification);
			if (constraintLanguagesSpecification != oldConstraintLanguagesSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.SPECIFICATION__CONSTRAINT_LANGUAGES_SPECIFICATION, oldConstraintLanguagesSpecification, constraintLanguagesSpecification));
			}
		}
		return constraintLanguagesSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintLanguagesSpecification basicGetConstraintLanguagesSpecification() {
		return constraintLanguagesSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintLanguagesSpecification(ConstraintLanguagesSpecification newConstraintLanguagesSpecification) {
		ConstraintLanguagesSpecification oldConstraintLanguagesSpecification = constraintLanguagesSpecification;
		constraintLanguagesSpecification = newConstraintLanguagesSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__CONSTRAINT_LANGUAGES_SPECIFICATION, oldConstraintLanguagesSpecification, constraintLanguagesSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemOverview getSystOverview() {
		return systOverview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystOverview(SystemOverview newSystOverview, NotificationChain msgs) {
		SystemOverview oldSystOverview = systOverview;
		systOverview = newSystOverview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__SYST_OVERVIEW, oldSystOverview, newSystOverview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystOverview(SystemOverview newSystOverview) {
		if (newSystOverview != systOverview) {
			NotificationChain msgs = null;
			if (systOverview != null)
				msgs = ((InternalEObject)systOverview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.SPECIFICATION__SYST_OVERVIEW, null, msgs);
			if (newSystOverview != null)
				msgs = ((InternalEObject)newSystOverview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.SPECIFICATION__SYST_OVERVIEW, null, msgs);
			msgs = basicSetSystOverview(newSystOverview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__SYST_OVERVIEW, newSystOverview, newSystOverview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Conflict> getConflicts() {
		if (conflicts == null) {
			conflicts = new EObjectContainmentEList<Conflict>(Conflict.class, this, CorePackage.SPECIFICATION__CONFLICTS);
		}
		return conflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Float getSatisfactionLevel() {
		double total = 0.0;
		
		for ( final RequirementsGroup requirementGroup : getRequirementGroups() ) {
			total += requirementGroup.getSatisfactionLevel() == null ? 0.0 : requirementGroup.getSatisfactionLevel();
		}
		
		return (float) total / getRequirementGroups().size();
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
	 * @generated NOT
	 */
	public ConstraintLanguage constraintLanguage( final String p_languageId ) {
		final ConstraintLanguagesSpecification langSpec = getConstraintLanguagesSpecification();
		
		if ( langSpec == null ) {
			return null;
		}
		
		for ( final ConstraintLanguage language : langSpec.getLanguages() ) {
			if ( p_languageId.equals( language.getId() ) ) {
				return language;
			}
		}
		
		return null;
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
			case CorePackage.SPECIFICATION__REQUIREMENT_GROUPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirementGroups()).basicAdd(otherEnd, msgs);
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
			case CorePackage.SPECIFICATION__ACTORS:
				return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
			case CorePackage.SPECIFICATION__VERIFICATION_ACTIVITIES:
				return ((InternalEList<?>)getVerificationActivities()).basicRemove(otherEnd, msgs);
			case CorePackage.SPECIFICATION__REQUIREMENT_GROUPS:
				return ((InternalEList<?>)getRequirementGroups()).basicRemove(otherEnd, msgs);
			case CorePackage.SPECIFICATION__SYST_OVERVIEW:
				return basicSetSystOverview(null, msgs);
			case CorePackage.SPECIFICATION__CONFLICTS:
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
			case CorePackage.SPECIFICATION__SPECIFIES:
				return getSpecifies();
			case CorePackage.SPECIFICATION__ACTORS:
				return getActors();
			case CorePackage.SPECIFICATION__VERIFICATION_ACTIVITIES:
				return getVerificationActivities();
			case CorePackage.SPECIFICATION__REQUIREMENT_GROUPS:
				return getRequirementGroups();
			case CorePackage.SPECIFICATION__CONSTRAINT_LANGUAGES_SPECIFICATION:
				if (resolve) return getConstraintLanguagesSpecification();
				return basicGetConstraintLanguagesSpecification();
			case CorePackage.SPECIFICATION__VERSION:
				return getVersion();
			case CorePackage.SPECIFICATION__SYST_OVERVIEW:
				return getSystOverview();
			case CorePackage.SPECIFICATION__CONFLICTS:
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
			case CorePackage.SPECIFICATION__SPECIFIES:
				getSpecifies().clear();
				getSpecifies().addAll((Collection<? extends EObject>)newValue);
				return;
			case CorePackage.SPECIFICATION__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case CorePackage.SPECIFICATION__VERIFICATION_ACTIVITIES:
				getVerificationActivities().clear();
				getVerificationActivities().addAll((Collection<? extends VerificationActivity>)newValue);
				return;
			case CorePackage.SPECIFICATION__REQUIREMENT_GROUPS:
				getRequirementGroups().clear();
				getRequirementGroups().addAll((Collection<? extends RequirementsGroup>)newValue);
				return;
			case CorePackage.SPECIFICATION__CONSTRAINT_LANGUAGES_SPECIFICATION:
				setConstraintLanguagesSpecification((ConstraintLanguagesSpecification)newValue);
				return;
			case CorePackage.SPECIFICATION__VERSION:
				setVersion((String)newValue);
				return;
			case CorePackage.SPECIFICATION__SYST_OVERVIEW:
				setSystOverview((SystemOverview)newValue);
				return;
			case CorePackage.SPECIFICATION__CONFLICTS:
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
			case CorePackage.SPECIFICATION__SPECIFIES:
				getSpecifies().clear();
				return;
			case CorePackage.SPECIFICATION__ACTORS:
				getActors().clear();
				return;
			case CorePackage.SPECIFICATION__VERIFICATION_ACTIVITIES:
				getVerificationActivities().clear();
				return;
			case CorePackage.SPECIFICATION__REQUIREMENT_GROUPS:
				getRequirementGroups().clear();
				return;
			case CorePackage.SPECIFICATION__CONSTRAINT_LANGUAGES_SPECIFICATION:
				setConstraintLanguagesSpecification((ConstraintLanguagesSpecification)null);
				return;
			case CorePackage.SPECIFICATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CorePackage.SPECIFICATION__SYST_OVERVIEW:
				setSystOverview((SystemOverview)null);
				return;
			case CorePackage.SPECIFICATION__CONFLICTS:
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
			case CorePackage.SPECIFICATION__SPECIFIES:
				return specifies != null && !specifies.isEmpty();
			case CorePackage.SPECIFICATION__ACTORS:
				return actors != null && !actors.isEmpty();
			case CorePackage.SPECIFICATION__VERIFICATION_ACTIVITIES:
				return verificationActivities != null && !verificationActivities.isEmpty();
			case CorePackage.SPECIFICATION__REQUIREMENT_GROUPS:
				return requirementGroups != null && !requirementGroups.isEmpty();
			case CorePackage.SPECIFICATION__CONSTRAINT_LANGUAGES_SPECIFICATION:
				return constraintLanguagesSpecification != null;
			case CorePackage.SPECIFICATION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CorePackage.SPECIFICATION__SYST_OVERVIEW:
				return systOverview != null;
			case CorePackage.SPECIFICATION__CONFLICTS:
				return conflicts != null && !conflicts.isEmpty();
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
		result.append(" (version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //SpecificationImpl
