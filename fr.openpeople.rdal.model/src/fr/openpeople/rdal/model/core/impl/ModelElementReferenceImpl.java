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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.ReferencedModelElements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ModelElementReferenceImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ModelElementReferenceImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ModelElementReferenceImpl#getVerifies <em>Verifies</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.impl.ModelElementReferenceImpl#getReason <em>Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementReferenceImpl extends IdentifiedElementImpl implements ModelElementReference {
	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected EObject modelElement;

	/**
	 * The default value of the '{@link #getVerifies() <em>Verifies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifies()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean VERIFIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerifies() <em>Verifies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifies()
	 * @generated
	 * @ordered
	 */
	protected Boolean verifies = VERIFIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected static final String REASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected String reason = REASON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.MODEL_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElement(EObject newModelElement) {
		EObject oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT, oldModelElement, modelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getVerifies() {
		return verifies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerifies(Boolean newVerifies) {
		Boolean oldVerifies = verifies;
		verifies = newVerifies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.MODEL_ELEMENT_REFERENCE__VERIFIES, oldVerifies, verifies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReason(String newReason) {
		String oldReason = reason;
		reason = newReason;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.MODEL_ELEMENT_REFERENCE__REASON, oldReason, reason));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencedModelElements getParent() {
		if (eContainerFeatureID() != CorePackage.MODEL_ELEMENT_REFERENCE__PARENT) return null;
		return (ReferencedModelElements)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(ReferencedModelElements newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, CorePackage.MODEL_ELEMENT_REFERENCE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(ReferencedModelElements newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != CorePackage.MODEL_ELEMENT_REFERENCE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, CorePackage.REFERENCED_MODEL_ELEMENTS__MODEL_ELEMENT_REFERENCES, ReferencedModelElements.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.MODEL_ELEMENT_REFERENCE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.MODEL_ELEMENT_REFERENCE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((ReferencedModelElements)otherEnd, msgs);
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
			case CorePackage.MODEL_ELEMENT_REFERENCE__PARENT:
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
			case CorePackage.MODEL_ELEMENT_REFERENCE__PARENT:
				return eInternalContainer().eInverseRemove(this, CorePackage.REFERENCED_MODEL_ELEMENTS__MODEL_ELEMENT_REFERENCES, ReferencedModelElements.class, msgs);
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
			case CorePackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
			case CorePackage.MODEL_ELEMENT_REFERENCE__PARENT:
				return getParent();
			case CorePackage.MODEL_ELEMENT_REFERENCE__VERIFIES:
				return getVerifies();
			case CorePackage.MODEL_ELEMENT_REFERENCE__REASON:
				return getReason();
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
			case CorePackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT:
				setModelElement((EObject)newValue);
				return;
			case CorePackage.MODEL_ELEMENT_REFERENCE__PARENT:
				setParent((ReferencedModelElements)newValue);
				return;
			case CorePackage.MODEL_ELEMENT_REFERENCE__VERIFIES:
				setVerifies((Boolean)newValue);
				return;
			case CorePackage.MODEL_ELEMENT_REFERENCE__REASON:
				setReason((String)newValue);
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
			case CorePackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT:
				setModelElement((EObject)null);
				return;
			case CorePackage.MODEL_ELEMENT_REFERENCE__PARENT:
				setParent((ReferencedModelElements)null);
				return;
			case CorePackage.MODEL_ELEMENT_REFERENCE__VERIFIES:
				setVerifies(VERIFIES_EDEFAULT);
				return;
			case CorePackage.MODEL_ELEMENT_REFERENCE__REASON:
				setReason(REASON_EDEFAULT);
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
			case CorePackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT:
				return modelElement != null;
			case CorePackage.MODEL_ELEMENT_REFERENCE__PARENT:
				return getParent() != null;
			case CorePackage.MODEL_ELEMENT_REFERENCE__VERIFIES:
				return VERIFIES_EDEFAULT == null ? verifies != null : !VERIFIES_EDEFAULT.equals(verifies);
			case CorePackage.MODEL_ELEMENT_REFERENCE__REASON:
				return REASON_EDEFAULT == null ? reason != null : !REASON_EDEFAULT.equals(reason);
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
		result.append(" (verifies: ");
		result.append(verifies);
		result.append(", reason: ");
		result.append(reason);
		result.append(')');
		return result.toString();
	}

} //ModelElementReferenceImpl
