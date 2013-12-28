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
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.openpeople.rdal.model.core.ContractReferencedModelElements;
import fr.openpeople.rdal.model.core.ContractualElement;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.StakeHolder;
import fr.openpeople.rdal.model.core.Uncertainty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contractual Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getSatisfactionLevel <em>Satisfaction Level</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getChangeUncertainty <em>Change Uncertainty</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getContactInformation <em>Contact Information</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getOriginDate <em>Origin Date</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getScheduleDate <em>Schedule Date</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getStakeHolders <em>Stake Holders</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getSatisfiedBy <em>Satisfied By</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getEvolvedTo <em>Evolved To</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#isDropped <em>Dropped</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getTracedTo <em>Traced To</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ContractualElementImpl#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ContractualElementImpl extends IdentifiedElementImpl implements ContractualElement {
	/**
	 * The default value of the '{@link #getSatisfactionLevel() <em>Satisfaction Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatisfactionLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Float SATISFACTION_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSatisfactionLevel() <em>Satisfaction Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatisfactionLevel()
	 * @generated
	 * @ordered
	 */
	protected Float satisfactionLevel = SATISFACTION_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChangeUncertainty() <em>Change Uncertainty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeUncertainty()
	 * @generated
	 * @ordered
	 */
	protected Uncertainty changeUncertainty;

	/**
	 * The cached value of the '{@link #getContactInformation() <em>Contact Information</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContactInformation()
	 * @generated
	 * @ordered
	 */
	protected EList<String> contactInformation;

	/**
	 * The default value of the '{@link #getOriginDate() <em>Origin Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ORIGIN_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginDate() <em>Origin Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginDate()
	 * @generated
	 * @ordered
	 */
	protected Date originDate = ORIGIN_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScheduleDate() <em>Schedule Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduleDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date SCHEDULE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScheduleDate() <em>Schedule Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduleDate()
	 * @generated
	 * @ordered
	 */
	protected Date scheduleDate = SCHEDULE_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStakeHolders() <em>Stake Holders</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeHolders()
	 * @generated
	 * @ordered
	 */
	protected EList<StakeHolder> stakeHolders;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Float PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected Float priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSatisfiedBy() <em>Satisfied By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatisfiedBy()
	 * @generated
	 * @ordered
	 */
	protected ContractReferencedModelElements satisfiedBy;

	/**
	 * The cached value of the '{@link #getEvolvedTo() <em>Evolved To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvolvedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<ContractualElement> evolvedTo;

	/**
	 * The default value of the '{@link #isDropped() <em>Dropped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDropped()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DROPPED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDropped() <em>Dropped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDropped()
	 * @generated
	 * @ordered
	 */
	protected boolean dropped = DROPPED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTracedTo() <em>Traced To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTracedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> tracedTo;

	/**
	 * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationale()
	 * @generated
	 * @ordered
	 */
	protected static final String RATIONALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRationale()
	 * @generated
	 * @ordered
	 */
	protected String rationale = RATIONALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<String> sources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContractualElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONTRACTUAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getSatisfactionLevel() {
		return satisfactionLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSatisfactionLevel(Float newSatisfactionLevel) {
		Float oldSatisfactionLevel = satisfactionLevel;
		satisfactionLevel = newSatisfactionLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__SATISFACTION_LEVEL, oldSatisfactionLevel, satisfactionLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Uncertainty getChangeUncertainty() {
		return changeUncertainty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChangeUncertainty(Uncertainty newChangeUncertainty, NotificationChain msgs) {
		Uncertainty oldChangeUncertainty = changeUncertainty;
		changeUncertainty = newChangeUncertainty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, oldChangeUncertainty, newChangeUncertainty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeUncertainty(Uncertainty newChangeUncertainty) {
		if (newChangeUncertainty != changeUncertainty) {
			NotificationChain msgs = null;
			if (changeUncertainty != null)
				msgs = ((InternalEObject)changeUncertainty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, null, msgs);
			if (newChangeUncertainty != null)
				msgs = ((InternalEObject)newChangeUncertainty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, null, msgs);
			msgs = basicSetChangeUncertainty(newChangeUncertainty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, newChangeUncertainty, newChangeUncertainty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContactInformation() {
		if (contactInformation == null) {
			contactInformation = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.CONTRACTUAL_ELEMENT__CONTACT_INFORMATION);
		}
		return contactInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getOriginDate() {
		return originDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginDate(Date newOriginDate) {
		Date oldOriginDate = originDate;
		originDate = newOriginDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__ORIGIN_DATE, oldOriginDate, originDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getScheduleDate() {
		return scheduleDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleDate(Date newScheduleDate) {
		Date oldScheduleDate = scheduleDate;
		scheduleDate = newScheduleDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__SCHEDULE_DATE, oldScheduleDate, scheduleDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRationale() {
		return rationale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRationale(String newRationale) {
		String oldRationale = rationale;
		rationale = newRationale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__RATIONALE, oldRationale, rationale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSources() {
		if (sources == null) {
			sources = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.CONTRACTUAL_ELEMENT__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StakeHolder> getStakeHolders() {
		if (stakeHolders == null) {
			stakeHolders = new EObjectWithInverseResolvingEList.ManyInverse<StakeHolder>(StakeHolder.class, this, CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS, CorePackage.STAKE_HOLDER__CONTRACTUAL_ELEMENTS);
		}
		return stakeHolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(Float newPriority) {
		Float oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContractReferencedModelElements getSatisfiedBy() {
		return satisfiedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSatisfiedBy(ContractReferencedModelElements newSatisfiedBy, NotificationChain msgs) {
		ContractReferencedModelElements oldSatisfiedBy = satisfiedBy;
		satisfiedBy = newSatisfiedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY, oldSatisfiedBy, newSatisfiedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSatisfiedBy(ContractReferencedModelElements newSatisfiedBy) {
		if (newSatisfiedBy != satisfiedBy) {
			NotificationChain msgs = null;
			if (satisfiedBy != null)
				msgs = ((InternalEObject)satisfiedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY, null, msgs);
			if (newSatisfiedBy != null)
				msgs = ((InternalEObject)newSatisfiedBy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY, null, msgs);
			msgs = basicSetSatisfiedBy(newSatisfiedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY, newSatisfiedBy, newSatisfiedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContractualElement> getEvolvedTo() {
		if (evolvedTo == null) {
			evolvedTo = new EObjectResolvingEList<ContractualElement>(ContractualElement.class, this, CorePackage.CONTRACTUAL_ELEMENT__EVOLVED_TO);
		}
		return evolvedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public ContractualElement basicGetEvolvedTo() {
//		return evolvedTo;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public void setEvolvedTo(ContractualElement newEvolvedTo) {
//		ContractualElement oldEvolvedTo = evolvedTo;
//		evolvedTo = newEvolvedTo;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__EVOLVED_TO, oldEvolvedTo, evolvedTo));
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDropped() {
		return dropped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDropped(boolean newDropped) {
		boolean oldDropped = dropped;
		dropped = newDropped;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONTRACTUAL_ELEMENT__DROPPED, oldDropped, dropped));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTracedTo() {
		if (tracedTo == null) {
			tracedTo = new EObjectResolvingEList<EObject>(EObject.class, this, CorePackage.CONTRACTUAL_ELEMENT__TRACED_TO);
		}
		return tracedTo;
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
			case CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStakeHolders()).basicAdd(otherEnd, msgs);
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
			case CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
				return basicSetChangeUncertainty(null, msgs);
			case CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS:
				return ((InternalEList<?>)getStakeHolders()).basicRemove(otherEnd, msgs);
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY:
				return basicSetSatisfiedBy(null, msgs);
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
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFACTION_LEVEL:
				return getSatisfactionLevel();
			case CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
				return getChangeUncertainty();
			case CorePackage.CONTRACTUAL_ELEMENT__CONTACT_INFORMATION:
				return getContactInformation();
			case CorePackage.CONTRACTUAL_ELEMENT__ORIGIN_DATE:
				return getOriginDate();
			case CorePackage.CONTRACTUAL_ELEMENT__SCHEDULE_DATE:
				return getScheduleDate();
			case CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS:
				return getStakeHolders();
			case CorePackage.CONTRACTUAL_ELEMENT__PRIORITY:
				return getPriority();
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY:
				return getSatisfiedBy();
			case CorePackage.CONTRACTUAL_ELEMENT__EVOLVED_TO:
				//if (resolve) return getEvolvedTo();
				return getEvolvedTo();
			case CorePackage.CONTRACTUAL_ELEMENT__DROPPED:
				return isDropped();
			case CorePackage.CONTRACTUAL_ELEMENT__TRACED_TO:
				return getTracedTo();
			case CorePackage.CONTRACTUAL_ELEMENT__RATIONALE:
				return getRationale();
			case CorePackage.CONTRACTUAL_ELEMENT__SOURCES:
				return getSources();
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
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFACTION_LEVEL:
				setSatisfactionLevel((Float)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
				setChangeUncertainty((Uncertainty)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__CONTACT_INFORMATION:
				getContactInformation().clear();
				getContactInformation().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__ORIGIN_DATE:
				setOriginDate((Date)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__SCHEDULE_DATE:
				setScheduleDate((Date)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS:
				getStakeHolders().clear();
				getStakeHolders().addAll((Collection<? extends StakeHolder>)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__PRIORITY:
				setPriority((Float)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY:
				setSatisfiedBy((ContractReferencedModelElements)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__EVOLVED_TO:
//				setEvolvedTo((ContractualElement)newValue);
				getEvolvedTo().clear();
				getEvolvedTo().addAll((Collection<? extends ContractualElement>)newValue);
				//return;
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__DROPPED:
				setDropped((Boolean)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__TRACED_TO:
				getTracedTo().clear();
				getTracedTo().addAll((Collection<? extends EObject>)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__RATIONALE:
				setRationale((String)newValue);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends String>)newValue);
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
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFACTION_LEVEL:
				setSatisfactionLevel(SATISFACTION_LEVEL_EDEFAULT);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
				setChangeUncertainty((Uncertainty)null);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__CONTACT_INFORMATION:
				getContactInformation().clear();
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__ORIGIN_DATE:
				setOriginDate(ORIGIN_DATE_EDEFAULT);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__SCHEDULE_DATE:
				setScheduleDate(SCHEDULE_DATE_EDEFAULT);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS:
				getStakeHolders().clear();
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY:
				setSatisfiedBy((ContractReferencedModelElements)null);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__EVOLVED_TO:
				getEvolvedTo().clear();
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__DROPPED:
				setDropped(DROPPED_EDEFAULT);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__TRACED_TO:
				getTracedTo().clear();
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__RATIONALE:
				setRationale(RATIONALE_EDEFAULT);
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__SOURCES:
				getSources().clear();
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
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFACTION_LEVEL:
				return SATISFACTION_LEVEL_EDEFAULT == null ? satisfactionLevel != null : !SATISFACTION_LEVEL_EDEFAULT.equals(satisfactionLevel);
			case CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
				return changeUncertainty != null;
			case CorePackage.CONTRACTUAL_ELEMENT__CONTACT_INFORMATION:
				return contactInformation != null && !contactInformation.isEmpty();
			case CorePackage.CONTRACTUAL_ELEMENT__ORIGIN_DATE:
				return ORIGIN_DATE_EDEFAULT == null ? originDate != null : !ORIGIN_DATE_EDEFAULT.equals(originDate);
			case CorePackage.CONTRACTUAL_ELEMENT__SCHEDULE_DATE:
				return SCHEDULE_DATE_EDEFAULT == null ? scheduleDate != null : !SCHEDULE_DATE_EDEFAULT.equals(scheduleDate);
			case CorePackage.CONTRACTUAL_ELEMENT__STAKE_HOLDERS:
				return stakeHolders != null && !stakeHolders.isEmpty();
			case CorePackage.CONTRACTUAL_ELEMENT__PRIORITY:
				return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY:
				return satisfiedBy != null;
			case CorePackage.CONTRACTUAL_ELEMENT__EVOLVED_TO:
				return evolvedTo != null;
			case CorePackage.CONTRACTUAL_ELEMENT__DROPPED:
				return dropped != DROPPED_EDEFAULT;
			case CorePackage.CONTRACTUAL_ELEMENT__TRACED_TO:
				return tracedTo != null && !tracedTo.isEmpty();
			case CorePackage.CONTRACTUAL_ELEMENT__RATIONALE:
				return RATIONALE_EDEFAULT == null ? rationale != null : !RATIONALE_EDEFAULT.equals(rationale);
			case CorePackage.CONTRACTUAL_ELEMENT__SOURCES:
				return sources != null && !sources.isEmpty();
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
		result.append(" (satisfactionLevel: ");
		result.append(satisfactionLevel);
		result.append(", contactInformation: ");
		result.append(contactInformation);
		result.append(", originDate: ");
		result.append(originDate);
		result.append(", scheduleDate: ");
		result.append(scheduleDate);
		result.append(", priority: ");
		result.append(priority);
		result.append(", dropped: ");
		result.append(dropped);
		result.append(", rationale: ");
		result.append(rationale);
		result.append(", sources: ");
		result.append(sources);
		result.append(')');
		return result.toString();
	}

} //ContractualElementImpl
