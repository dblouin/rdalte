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
package fr.openpeople.rdal.model.core.provider;


import fr.openpeople.rdal.model.core.ContractualElement;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.CorePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.openpeople.rdal.model.core.ContractualElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ContractualElementItemProvider
	extends IdentifiedElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContractualElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSatisfactionLevelPropertyDescriptor(object);
			addContactInformationPropertyDescriptor(object);
			addOriginDatePropertyDescriptor(object);
			addScheduleDatePropertyDescriptor(object);
			addStakeHoldersPropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addEvolvedToPropertyDescriptor(object);
			addDroppedPropertyDescriptor(object);
			addTracedToPropertyDescriptor(object);

			// DB added because needed to set the feature 
			addSatisfiedByPropertyDescriptor(object);
//			addRationalePropertyDescriptor(object);
//			addSourcePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Satisfaction Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSatisfactionLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_satisfactionLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_satisfactionLevel_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__SATISFACTION_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Contact Information feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContactInformationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_contactInformation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_contactInformation_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__CONTACT_INFORMATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Origin Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOriginDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_originDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_originDate_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__ORIGIN_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Schedule Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScheduleDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_scheduleDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_scheduleDate_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__SCHEDULE_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}


	/**
	 * This adds a property descriptor for the Satisfied By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSatisfiedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_satisfiedBy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_satisfiedBy_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__SATISFIED_BY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stake Holders feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStakeHoldersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_stakeHolders_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_stakeHolders_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__STAKE_HOLDERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_priority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_priority_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Evolved To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEvolvedToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_evolvedTo_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_evolvedTo_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__EVOLVED_TO,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dropped feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDroppedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_dropped_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_dropped_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__DROPPED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Traced To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTracedToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add( new SettingsRefPropertyDescriptor( ( (ComposeableAdapterFactory) adapterFactory ).getRootAdapterFactory(),
																		 getResourceLocator(),
																		 getString("_UI_ContractualElement_tracedTo_feature"),
																		 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_tracedTo_feature", "_UI_ContractualElement_type" ),
																		 CorePackage.Literals.CONTRACTUAL_ELEMENT__TRACED_TO ) );
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_ContractualElement_tracedTo_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_tracedTo_feature", "_UI_ContractualElement_type"),
//				 CorePackage.Literals.CONTRACTUAL_ELEMENT__TRACED_TO,
//				 true,
//				 false,
//				 true,
//				 null,
//				 null,
//				 null));
	}

	/**
	 * This adds a property descriptor for the Sources feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ContractualElement_sources_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ContractualElement_sources_feature", "_UI_ContractualElement_type"),
				 CorePackage.Literals.CONTRACTUAL_ELEMENT__SOURCES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CorePackage.Literals.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY);
			childrenFeatures.add(CorePackage.Literals.CONTRACTUAL_ELEMENT__SATISFIED_BY);
			childrenFeatures.add(CorePackage.Literals.CONTRACTUAL_ELEMENT__RATIONALE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ContractualElement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ContractualElement_type") :
			getString("_UI_ContractualElement_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ContractualElement.class)) {
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFACTION_LEVEL:
			case CorePackage.CONTRACTUAL_ELEMENT__CONTACT_INFORMATION:
			case CorePackage.CONTRACTUAL_ELEMENT__ORIGIN_DATE:
			case CorePackage.CONTRACTUAL_ELEMENT__SCHEDULE_DATE:
			case CorePackage.CONTRACTUAL_ELEMENT__PRIORITY:
			case CorePackage.CONTRACTUAL_ELEMENT__DROPPED:
			case CorePackage.CONTRACTUAL_ELEMENT__SOURCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
			case CorePackage.CONTRACTUAL_ELEMENT__SATISFIED_BY:
			case CorePackage.CONTRACTUAL_ELEMENT__RATIONALE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY,
				 CoreFactory.eINSTANCE.createUncertainty()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.CONTRACTUAL_ELEMENT__SATISFIED_BY,
				 CoreFactory.eINSTANCE.createRefExpressionCollectedModelElements()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.CONTRACTUAL_ELEMENT__SATISFIED_BY,
				 CoreFactory.eINSTANCE.createRefUserSelectedModelElements()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.CONTRACTUAL_ELEMENT__RATIONALE,
				 ""));
	}

}
