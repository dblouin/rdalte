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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirements Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementsGroupImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementsGroupImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementsGroupImpl#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.RequirementsGroupImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementsGroupImpl extends VerifiableElementImpl implements RequirementsGroup {
	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRequirement> requirements;

	/**
	 * The cached value of the '{@link #getSubGroups() <em>Sub Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementsGroup> subGroups;
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected RequirementsGroup parent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementsGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.REQUIREMENTS_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentWithInverseEList<AbstractRequirement>(AbstractRequirement.class, this, CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS, CorePackage.ABSTRACT_REQUIREMENT__GROUP);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getSpecification() {
		if (eContainerFeatureID() != CorePackage.REQUIREMENTS_GROUP__SPECIFICATION) return null;
		return (Specification)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(Specification newSpecification, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecification, CorePackage.REQUIREMENTS_GROUP__SPECIFICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(Specification newSpecification) {
		if (newSpecification != eInternalContainer() || (eContainerFeatureID() != CorePackage.REQUIREMENTS_GROUP__SPECIFICATION && newSpecification != null)) {
			if (EcoreUtil.isAncestor(this, newSpecification))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, CorePackage.SPECIFICATION__REQUIREMENT_GROUPS, Specification.class, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENTS_GROUP__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequirementsGroup> getSubGroups() {
		if (subGroups == null) {
			subGroups = new EObjectWithInverseResolvingEList<RequirementsGroup>(RequirementsGroup.class, this, CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS, CorePackage.REQUIREMENTS_GROUP__PARENT);
		}
		return subGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsGroup getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (RequirementsGroup)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.REQUIREMENTS_GROUP__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsGroup basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(RequirementsGroup newParent, NotificationChain msgs) {
		RequirementsGroup oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENTS_GROUP__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(RequirementsGroup newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS, RequirementsGroup.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS, RequirementsGroup.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENTS_GROUP__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Float getSatisfactionLevel() {
		double total = 0.0;
		
		for ( final AbstractRequirement requirement : getRequirements() ) {
			total += requirement.getSatisfactionLevel() == null ? 0.0 : requirement.getSatisfactionLevel();
		}
		
		return (float) total / getRequirements().size();
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirements()).basicAdd(otherEnd, msgs);
			case CorePackage.REQUIREMENTS_GROUP__SPECIFICATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecification((Specification)otherEnd, msgs);
			case CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubGroups()).basicAdd(otherEnd, msgs);
			case CorePackage.REQUIREMENTS_GROUP__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS, RequirementsGroup.class, msgs);
				return basicSetParent((RequirementsGroup)otherEnd, msgs);
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
			case CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case CorePackage.REQUIREMENTS_GROUP__SPECIFICATION:
				return basicSetSpecification(null, msgs);
			case CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS:
				return ((InternalEList<?>)getSubGroups()).basicRemove(otherEnd, msgs);
			case CorePackage.REQUIREMENTS_GROUP__PARENT:
				return basicSetParent(null, msgs);
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
			case CorePackage.REQUIREMENTS_GROUP__SPECIFICATION:
				return eInternalContainer().eInverseRemove(this, CorePackage.SPECIFICATION__REQUIREMENT_GROUPS, Specification.class, msgs);
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
			case CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS:
				return getRequirements();
			case CorePackage.REQUIREMENTS_GROUP__SPECIFICATION:
				return getSpecification();
			case CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS:
				return getSubGroups();
			case CorePackage.REQUIREMENTS_GROUP__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
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
			case CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends AbstractRequirement>)newValue);
				return;
			case CorePackage.REQUIREMENTS_GROUP__SPECIFICATION:
				setSpecification((Specification)newValue);
				return;
			case CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS:
				getSubGroups().clear();
				getSubGroups().addAll((Collection<? extends RequirementsGroup>)newValue);
				return;
			case CorePackage.REQUIREMENTS_GROUP__PARENT:
				setParent((RequirementsGroup)newValue);
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
			case CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS:
				getRequirements().clear();
				return;
			case CorePackage.REQUIREMENTS_GROUP__SPECIFICATION:
				setSpecification((Specification)null);
				return;
			case CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS:
				getSubGroups().clear();
				return;
			case CorePackage.REQUIREMENTS_GROUP__PARENT:
				setParent((RequirementsGroup)null);
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
			case CorePackage.REQUIREMENTS_GROUP__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case CorePackage.REQUIREMENTS_GROUP__SPECIFICATION:
				return getSpecification() != null;
			case CorePackage.REQUIREMENTS_GROUP__SUB_GROUPS:
				return subGroups != null && !subGroups.isEmpty();
			case CorePackage.REQUIREMENTS_GROUP__PARENT:
				return parent != null;
		}
		return super.eIsSet(featureID);
	}

} //RequirementsGroupImpl
