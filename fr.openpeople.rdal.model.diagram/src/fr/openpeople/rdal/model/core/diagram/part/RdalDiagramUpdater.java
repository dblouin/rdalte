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
package fr.openpeople.rdal.model.core.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.Actor;
import fr.openpeople.rdal.model.core.Assumption;
import fr.openpeople.rdal.model.core.ContractualElement;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Requirement;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.StakeHolder;
import fr.openpeople.rdal.model.core.VerificationActivity;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementContainedRequirementsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementVerifiedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AssumptionEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.ContractualElementStakeHoldersEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementAssumptionsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementDerivedFromEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementRefinedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupRequirementsCompartmentEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.SpecificationEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.StakeHolderEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.VerificationActivityEditPart;
import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;

/**
 * @generated
 */
public class RdalDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<RdalNodeDescriptor> getSemanticChildren(View view) {
		switch (RdalVisualIDRegistry.getVisualID(view)) {
		case SpecificationEditPart.VISUAL_ID:
			return getSpecification_1000SemanticChildren(view);
		case RequirementsGroupRequirementsCompartmentEditPart.VISUAL_ID:
			return getRequirementsGroupRequirementsCompartment_7003SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalNodeDescriptor> getSpecification_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Specification modelElement = (Specification) view.getElement();
		LinkedList<RdalNodeDescriptor> result = new LinkedList<RdalNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRequirementGroups().iterator(); it
				.hasNext();) {
			RequirementsGroup childElement = (RequirementsGroup) it.next();
			int visualID = RdalVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RequirementsGroupEditPart.VISUAL_ID) {
				result.add(new RdalNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getActors().iterator(); it.hasNext();) {
			Actor childElement = (Actor) it.next();
			int visualID = RdalVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StakeHolderEditPart.VISUAL_ID) {
				result.add(new RdalNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getVerificationActivities()
				.iterator(); it.hasNext();) {
			VerificationActivity childElement = (VerificationActivity) it
					.next();
			int visualID = RdalVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == VerificationActivityEditPart.VISUAL_ID) {
				result.add(new RdalNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalNodeDescriptor> getRequirementsGroupRequirementsCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RequirementsGroup modelElement = (RequirementsGroup) containerView
				.getElement();
		LinkedList<RdalNodeDescriptor> result = new LinkedList<RdalNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRequirements().iterator(); it
				.hasNext();) {
			AbstractRequirement childElement = (AbstractRequirement) it.next();
			int visualID = RdalVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RequirementEditPart.VISUAL_ID) {
				result.add(new RdalNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AssumptionEditPart.VISUAL_ID) {
				result.add(new RdalNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getContainedLinks(View view) {
		switch (RdalVisualIDRegistry.getVisualID(view)) {
		case SpecificationEditPart.VISUAL_ID:
			return getSpecification_1000ContainedLinks(view);
		case RequirementsGroupEditPart.VISUAL_ID:
			return getRequirementsGroup_2007ContainedLinks(view);
		case StakeHolderEditPart.VISUAL_ID:
			return getStakeHolder_2011ContainedLinks(view);
		case VerificationActivityEditPart.VISUAL_ID:
			return getVerificationActivity_2010ContainedLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_3003ContainedLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_3004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getIncomingLinks(View view) {
		switch (RdalVisualIDRegistry.getVisualID(view)) {
		case RequirementsGroupEditPart.VISUAL_ID:
			return getRequirementsGroup_2007IncomingLinks(view);
		case StakeHolderEditPart.VISUAL_ID:
			return getStakeHolder_2011IncomingLinks(view);
		case VerificationActivityEditPart.VISUAL_ID:
			return getVerificationActivity_2010IncomingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_3003IncomingLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_3004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getOutgoingLinks(View view) {
		switch (RdalVisualIDRegistry.getVisualID(view)) {
		case RequirementsGroupEditPart.VISUAL_ID:
			return getRequirementsGroup_2007OutgoingLinks(view);
		case StakeHolderEditPart.VISUAL_ID:
			return getStakeHolder_2011OutgoingLinks(view);
		case VerificationActivityEditPart.VISUAL_ID:
			return getVerificationActivity_2010OutgoingLinks(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_3003OutgoingLinks(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_3004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getSpecification_1000ContainedLinks(
			View view) {
		Specification modelElement = (Specification) view.getElement();
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getRequirementsGroup_2007ContainedLinks(
			View view) {
		RequirementsGroup modelElement = (RequirementsGroup) view.getElement();
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getStakeHolder_2011ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getVerificationActivity_2010ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getRequirement_3003ContainedLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_VerifiedBy_4019(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DerivedFrom_4014(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedBy_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_Assumptions_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getAssumption_3004ContainedLinks(
			View view) {
		Assumption modelElement = (Assumption) view.getElement();
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_VerifiedBy_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getRequirementsGroup_2007IncomingLinks(
			View view) {
		RequirementsGroup modelElement = (RequirementsGroup) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedBy_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getStakeHolder_2011IncomingLinks(
			View view) {
		StakeHolder modelElement = (StakeHolder) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedBy_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getVerificationActivity_2010IncomingLinks(
			View view) {
		VerificationActivity modelElement = (VerificationActivity) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractRequirement_VerifiedBy_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedBy_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getRequirement_3003IncomingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_DerivedFrom_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedBy_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getAssumption_3004IncomingLinks(
			View view) {
		Assumption modelElement = (Assumption) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_RefinedBy_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_Assumptions_4017(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getRequirementsGroup_2007OutgoingLinks(
			View view) {
		RequirementsGroup modelElement = (RequirementsGroup) view.getElement();
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getStakeHolder_2011OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getVerificationActivity_2010OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getRequirement_3003OutgoingLinks(
			View view) {
		Requirement modelElement = (Requirement) view.getElement();
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_VerifiedBy_4019(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DerivedFrom_4014(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_RefinedBy_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_Assumptions_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RdalLinkDescriptor> getAssumption_3004OutgoingLinks(
			View view) {
		Assumption modelElement = (Assumption) view.getElement();
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_AbstractRequirement_VerifiedBy_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getIncomingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(
			AbstractRequirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getAbstractRequirement_ContainedRequirements()) {
				result.add(new RdalLinkDescriptor(
						setting.getEObject(),
						target,
						RdalElementTypes.AbstractRequirementContainedRequirements_4016,
						AbstractRequirementContainedRequirementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getIncomingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(
			StakeHolder target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getContractualElement_StakeHolders()) {
				result.add(new RdalLinkDescriptor(setting.getEObject(), target,
						RdalElementTypes.ContractualElementStakeHolders_4020,
						ContractualElementStakeHoldersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getIncomingFeatureModelFacetLinks_AbstractRequirement_VerifiedBy_4019(
			VerificationActivity target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getAbstractRequirement_VerifiedBy()) {
				result.add(new RdalLinkDescriptor(setting.getEObject(), target,
						RdalElementTypes.AbstractRequirementVerifiedBy_4019,
						AbstractRequirementVerifiedByEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_DerivedFrom_4014(
			Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getRequirement_DerivedFrom()) {
				result.add(new RdalLinkDescriptor(setting.getEObject(), target,
						RdalElementTypes.RequirementDerivedFrom_4014,
						RequirementDerivedFromEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_RefinedBy_4015(
			EObject target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getRequirement_RefinedBy()) {
				result.add(new RdalLinkDescriptor(setting.getEObject(),
						(EObject) target,
						RdalElementTypes.RequirementRefinedBy_4015,
						RequirementRefinedByEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_Assumptions_4017(
			Assumption target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getRequirement_Assumptions()) {
				result.add(new RdalLinkDescriptor(setting.getEObject(), target,
						RdalElementTypes.RequirementAssumptions_4017,
						RequirementAssumptionsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getOutgoingFeatureModelFacetLinks_AbstractRequirement_ContainedRequirements_4016(
			AbstractRequirement source) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		for (Iterator<?> destinations = source.getContainedRequirements()
				.iterator(); destinations.hasNext();) {
			AbstractRequirement destination = (AbstractRequirement) destinations
					.next();
			result.add(new RdalLinkDescriptor(
					source,
					destination,
					RdalElementTypes.AbstractRequirementContainedRequirements_4016,
					AbstractRequirementContainedRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getOutgoingFeatureModelFacetLinks_ContractualElement_StakeHolders_4020(
			ContractualElement source) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		for (Iterator<?> destinations = source.getStakeHolders().iterator(); destinations
				.hasNext();) {
			StakeHolder destination = (StakeHolder) destinations.next();
			result.add(new RdalLinkDescriptor(source, destination,
					RdalElementTypes.ContractualElementStakeHolders_4020,
					ContractualElementStakeHoldersEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getOutgoingFeatureModelFacetLinks_AbstractRequirement_VerifiedBy_4019(
			AbstractRequirement source) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		for (Iterator<?> destinations = source.getVerifiedBy().iterator(); destinations
				.hasNext();) {
			VerificationActivity destination = (VerificationActivity) destinations
					.next();
			result.add(new RdalLinkDescriptor(source, destination,
					RdalElementTypes.AbstractRequirementVerifiedBy_4019,
					AbstractRequirementVerifiedByEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_DerivedFrom_4014(
			Requirement source) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		for (Iterator<?> destinations = source.getDerivedFrom().iterator(); destinations
				.hasNext();) {
			Requirement destination = (Requirement) destinations.next();
			result.add(new RdalLinkDescriptor(source, destination,
					RdalElementTypes.RequirementDerivedFrom_4014,
					RequirementDerivedFromEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_RefinedBy_4015(
			Requirement source) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		for (Iterator<?> destinations = source.getRefinedBy().iterator(); destinations
				.hasNext();) {
			EObject destination = (EObject) destinations.next();
			result.add(new RdalLinkDescriptor(source, (EObject) destination,
					RdalElementTypes.RequirementRefinedBy_4015,
					RequirementRefinedByEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RdalLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_Assumptions_4017(
			Requirement source) {
		LinkedList<RdalLinkDescriptor> result = new LinkedList<RdalLinkDescriptor>();
		for (Iterator<?> destinations = source.getAssumptions().iterator(); destinations
				.hasNext();) {
			Assumption destination = (Assumption) destinations.next();
			result.add(new RdalLinkDescriptor(source, destination,
					RdalElementTypes.RequirementAssumptions_4017,
					RequirementAssumptionsEditPart.VISUAL_ID));
		}
		return result;
	}

}
