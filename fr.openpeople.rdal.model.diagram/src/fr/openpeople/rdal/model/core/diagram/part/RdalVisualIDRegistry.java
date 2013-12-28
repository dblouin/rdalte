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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementVerifiedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AssumptionEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AssumptionNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementAssumptionsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementDerivedFromEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementRefinedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementTypeEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupRequirementsCompartmentEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.SpecificationEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.StakeHolderEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.StakeHolderNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.VerificationActivityEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.VerificationActivityNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabel2EditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabel3EditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabel4EditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class RdalVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "fr.openpeople.rdal.model.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (SpecificationEditPart.MODEL_ID.equals(view.getType())) {
				return SpecificationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				RdalDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (CorePackage.eINSTANCE.getSpecification().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Specification) domainElement)) {
			return SpecificationEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry
				.getModelID(containerView);
		if (!SpecificationEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (SpecificationEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SpecificationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case SpecificationEditPart.VISUAL_ID:
			if (CorePackage.eINSTANCE.getRequirementsGroup().isSuperTypeOf(
					domainElement.eClass())) {
				return RequirementsGroupEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getStakeHolder().isSuperTypeOf(
					domainElement.eClass())) {
				return StakeHolderEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getVerificationActivity().isSuperTypeOf(
					domainElement.eClass())) {
				return VerificationActivityEditPart.VISUAL_ID;
			}
			break;
		case RequirementsGroupRequirementsCompartmentEditPart.VISUAL_ID:
			if (CorePackage.eINSTANCE.getRequirement().isSuperTypeOf(
					domainElement.eClass())) {
				return RequirementEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getAssumption().isSuperTypeOf(
					domainElement.eClass())) {
				return AssumptionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry
				.getModelID(containerView);
		if (!SpecificationEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (SpecificationEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SpecificationEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case SpecificationEditPart.VISUAL_ID:
			if (RequirementsGroupEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StakeHolderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VerificationActivityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementsGroupEditPart.VISUAL_ID:
			if (RequirementsGroupNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RequirementsGroupRequirementsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StakeHolderEditPart.VISUAL_ID:
			if (StakeHolderNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VerificationActivityEditPart.VISUAL_ID:
			if (VerificationActivityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementEditPart.VISUAL_ID:
			if (RequirementTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssumptionEditPart.VISUAL_ID:
			if (AssumptionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementsGroupRequirementsCompartmentEditPart.VISUAL_ID:
			if (RequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssumptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractRequirementVerifiedByEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementDerivedFromEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementRefinedByEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RequirementAssumptionsEditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Specification element) {
		return true;
	}

}
