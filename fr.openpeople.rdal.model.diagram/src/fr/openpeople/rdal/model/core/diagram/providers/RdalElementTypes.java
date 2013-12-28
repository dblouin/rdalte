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
package fr.openpeople.rdal.model.core.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementContainedRequirementsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementVerifiedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AssumptionEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.ContractualElementStakeHoldersEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementAssumptionsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementDerivedFromEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementRefinedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.SpecificationEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.StakeHolderEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.VerificationActivityEditPart;
import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorPlugin;

/**
 * @generated
 */
public class RdalElementTypes {

	/**
	 * @generated
	 */
	private RdalElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Specification_1000 = getElementType("fr.openpeople.rdal.model.diagram.Specification_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementsGroup_2007 = getElementType("fr.openpeople.rdal.model.diagram.RequirementsGroup_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StakeHolder_2011 = getElementType("fr.openpeople.rdal.model.diagram.StakeHolder_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VerificationActivity_2010 = getElementType("fr.openpeople.rdal.model.diagram.VerificationActivity_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Requirement_3003 = getElementType("fr.openpeople.rdal.model.diagram.Requirement_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Assumption_3004 = getElementType("fr.openpeople.rdal.model.diagram.Assumption_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AbstractRequirementContainedRequirements_4016 = getElementType("fr.openpeople.rdal.model.diagram.AbstractRequirementContainedRequirements_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ContractualElementStakeHolders_4020 = getElementType("fr.openpeople.rdal.model.diagram.ContractualElementStakeHolders_4020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AbstractRequirementVerifiedBy_4019 = getElementType("fr.openpeople.rdal.model.diagram.AbstractRequirementVerifiedBy_4019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequirementDerivedFrom_4014 = getElementType("fr.openpeople.rdal.model.diagram.RequirementDerivedFrom_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequirementRefinedBy_4015 = getElementType("fr.openpeople.rdal.model.diagram.RequirementRefinedBy_4015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RequirementAssumptions_4017 = getElementType("fr.openpeople.rdal.model.diagram.RequirementAssumptions_4017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return RdalDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Specification_1000,
					CorePackage.eINSTANCE.getSpecification());

			elements.put(RequirementsGroup_2007,
					CorePackage.eINSTANCE.getRequirementsGroup());

			elements.put(StakeHolder_2011,
					CorePackage.eINSTANCE.getStakeHolder());

			elements.put(VerificationActivity_2010,
					CorePackage.eINSTANCE.getVerificationActivity());

			elements.put(Requirement_3003,
					CorePackage.eINSTANCE.getRequirement());

			elements.put(Assumption_3004, CorePackage.eINSTANCE.getAssumption());

			elements.put(AbstractRequirementContainedRequirements_4016,
					CorePackage.eINSTANCE
							.getAbstractRequirement_ContainedRequirements());

			elements.put(ContractualElementStakeHolders_4020,
					CorePackage.eINSTANCE.getContractualElement_StakeHolders());

			elements.put(AbstractRequirementVerifiedBy_4019,
					CorePackage.eINSTANCE.getAbstractRequirement_VerifiedBy());

			elements.put(RequirementDerivedFrom_4014,
					CorePackage.eINSTANCE.getRequirement_DerivedFrom());

			elements.put(RequirementRefinedBy_4015,
					CorePackage.eINSTANCE.getRequirement_RefinedBy());

			elements.put(RequirementAssumptions_4017,
					CorePackage.eINSTANCE.getRequirement_Assumptions());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Specification_1000);
			KNOWN_ELEMENT_TYPES.add(RequirementsGroup_2007);
			KNOWN_ELEMENT_TYPES.add(StakeHolder_2011);
			KNOWN_ELEMENT_TYPES.add(VerificationActivity_2010);
			KNOWN_ELEMENT_TYPES.add(Requirement_3003);
			KNOWN_ELEMENT_TYPES.add(Assumption_3004);
			KNOWN_ELEMENT_TYPES
					.add(AbstractRequirementContainedRequirements_4016);
			KNOWN_ELEMENT_TYPES.add(ContractualElementStakeHolders_4020);
			KNOWN_ELEMENT_TYPES.add(AbstractRequirementVerifiedBy_4019);
			KNOWN_ELEMENT_TYPES.add(RequirementDerivedFrom_4014);
			KNOWN_ELEMENT_TYPES.add(RequirementRefinedBy_4015);
			KNOWN_ELEMENT_TYPES.add(RequirementAssumptions_4017);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case SpecificationEditPart.VISUAL_ID:
			return Specification_1000;
		case RequirementsGroupEditPart.VISUAL_ID:
			return RequirementsGroup_2007;
		case StakeHolderEditPart.VISUAL_ID:
			return StakeHolder_2011;
		case VerificationActivityEditPart.VISUAL_ID:
			return VerificationActivity_2010;
		case RequirementEditPart.VISUAL_ID:
			return Requirement_3003;
		case AssumptionEditPart.VISUAL_ID:
			return Assumption_3004;
		case AbstractRequirementContainedRequirementsEditPart.VISUAL_ID:
			return AbstractRequirementContainedRequirements_4016;
		case ContractualElementStakeHoldersEditPart.VISUAL_ID:
			return ContractualElementStakeHolders_4020;
		case AbstractRequirementVerifiedByEditPart.VISUAL_ID:
			return AbstractRequirementVerifiedBy_4019;
		case RequirementDerivedFromEditPart.VISUAL_ID:
			return RequirementDerivedFrom_4014;
		case RequirementRefinedByEditPart.VISUAL_ID:
			return RequirementRefinedBy_4015;
		case RequirementAssumptionsEditPart.VISUAL_ID:
			return RequirementAssumptions_4017;
		}
		return null;
	}

}
