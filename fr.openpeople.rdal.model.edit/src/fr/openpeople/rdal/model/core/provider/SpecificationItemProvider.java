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

import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Specification;

/**
 * This is the item provider adapter for a {@link fr.openpeople.rdal.model.core.Specification} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificationItemProvider
	extends VerifiableElementItemProvider
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
	public SpecificationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSpecifiesPropertyDescriptor(object);
			addConstraintLanguagesSpecificationPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Specifies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSpecifiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add( new SettingsRefPropertyDescriptor(	( (ComposeableAdapterFactory) adapterFactory ).getRootAdapterFactory(),
																		getResourceLocator(),
																		getString("_UI_Specification_specifies_feature"),
																		getString("_UI_PropertyDescriptor_description", "_UI_Specification_specifies_feature", "_UI_Specification_type"),
																		CorePackage.Literals.SPECIFICATION__SPECIFIES ) );
//		itemPropertyDescriptors.add
//		(createItemPropertyDescriptor
//			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//			 getResourceLocator(),
//			 getString("_UI_Specification_specifies_feature"),
//			 getString("_UI_PropertyDescriptor_description", "_UI_Specification_specifies_feature", "_UI_Specification_type"),
//			 RdalPackage.Literals.SPECIFICATION__SPECIFIES,
//			 true,
//			 false,
//			 true,
//			 null,
//			 null,
//			 null));
	}

	/**
	 * This adds a property descriptor for the Constraint Languages Specification feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstraintLanguagesSpecificationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Specification_constraintLanguagesSpecification_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Specification_constraintLanguagesSpecification_feature", "_UI_Specification_type"),
				 CorePackage.Literals.SPECIFICATION__CONSTRAINT_LANGUAGES_SPECIFICATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Specification_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Specification_version_feature", "_UI_Specification_type"),
				 CorePackage.Literals.SPECIFICATION__VERSION,
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
			childrenFeatures.add(CorePackage.Literals.SPECIFICATION__ACTORS);
			childrenFeatures.add(CorePackage.Literals.SPECIFICATION__VERIFICATION_ACTIVITIES);
			childrenFeatures.add(CorePackage.Literals.SPECIFICATION__REQUIREMENT_GROUPS);
			childrenFeatures.add(CorePackage.Literals.SPECIFICATION__SYST_OVERVIEW);
			childrenFeatures.add(CorePackage.Literals.SPECIFICATION__CONFLICTS);
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
	 * This returns Specification.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Specification"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Specification)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Specification_type") :
			getString("_UI_Specification_type") + " " + label;
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

		switch (notification.getFeatureID(Specification.class)) {
			case CorePackage.SPECIFICATION__VERSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.SPECIFICATION__ACTORS:
			case CorePackage.SPECIFICATION__VERIFICATION_ACTIVITIES:
			case CorePackage.SPECIFICATION__REQUIREMENT_GROUPS:
			case CorePackage.SPECIFICATION__SYST_OVERVIEW:
			case CorePackage.SPECIFICATION__CONFLICTS:
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
				(CorePackage.Literals.SPECIFICATION__ACTORS,
				 CoreFactory.eINSTANCE.createActor()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.SPECIFICATION__ACTORS,
				 CoreFactory.eINSTANCE.createStakeHolder()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.SPECIFICATION__VERIFICATION_ACTIVITIES,
				 CoreFactory.eINSTANCE.createVerificationActivity()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.SPECIFICATION__REQUIREMENT_GROUPS,
				 CoreFactory.eINSTANCE.createRequirementsGroup()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.SPECIFICATION__SYST_OVERVIEW,
				 CoreFactory.eINSTANCE.createSystemOverview()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.SPECIFICATION__CONFLICTS,
				 CoreFactory.eINSTANCE.createConflict()));
	}

}
