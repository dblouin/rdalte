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
package fr.openpeople.rdal.model.core.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import fr.openpeople.rdal.model.core.diagram.edit.commands.AbstractRequirementContainedRequirementsCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.AbstractRequirementContainedRequirementsReorientCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.AbstractRequirementVerifiedByCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.AbstractRequirementVerifiedByReorientCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.ContractualElementStakeHoldersCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.ContractualElementStakeHoldersReorientCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementAssumptionsCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementAssumptionsReorientCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementDerivedFromCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementDerivedFromReorientCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementRefinedByCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementRefinedByReorientCommand;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementContainedRequirementsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementVerifiedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.ContractualElementStakeHoldersEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementAssumptionsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementDerivedFromEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementRefinedByEditPart;
import fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry;
import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;

/**
 * @generated
 */
public class RequirementItemSemanticEditPolicy extends
		RdalBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementItemSemanticEditPolicy() {
		super(RdalElementTypes.Requirement_3003);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (RdalVisualIDRegistry.getVisualID(incomingLink) == AbstractRequirementContainedRequirementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (RdalVisualIDRegistry.getVisualID(incomingLink) == RequirementDerivedFromEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (RdalVisualIDRegistry.getVisualID(incomingLink) == RequirementRefinedByEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (RdalVisualIDRegistry.getVisualID(outgoingLink) == AbstractRequirementContainedRequirementsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RdalVisualIDRegistry.getVisualID(outgoingLink) == ContractualElementStakeHoldersEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RdalVisualIDRegistry.getVisualID(outgoingLink) == AbstractRequirementVerifiedByEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RdalVisualIDRegistry.getVisualID(outgoingLink) == RequirementDerivedFromEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RdalVisualIDRegistry.getVisualID(outgoingLink) == RequirementRefinedByEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RdalVisualIDRegistry.getVisualID(outgoingLink) == RequirementAssumptionsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (RdalElementTypes.AbstractRequirementContainedRequirements_4016 == req
				.getElementType()) {
			return getGEFWrapper(new AbstractRequirementContainedRequirementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.ContractualElementStakeHolders_4020 == req
				.getElementType()) {
			return getGEFWrapper(new ContractualElementStakeHoldersCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.AbstractRequirementVerifiedBy_4019 == req
				.getElementType()) {
			return getGEFWrapper(new AbstractRequirementVerifiedByCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.RequirementDerivedFrom_4014 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementDerivedFromCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.RequirementRefinedBy_4015 == req.getElementType()) {
			return getGEFWrapper(new RequirementRefinedByCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.RequirementAssumptions_4017 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementAssumptionsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (RdalElementTypes.AbstractRequirementContainedRequirements_4016 == req
				.getElementType()) {
			return getGEFWrapper(new AbstractRequirementContainedRequirementsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.ContractualElementStakeHolders_4020 == req
				.getElementType()) {
			return null;
		}
		if (RdalElementTypes.AbstractRequirementVerifiedBy_4019 == req
				.getElementType()) {
			return null;
		}
		if (RdalElementTypes.RequirementDerivedFrom_4014 == req
				.getElementType()) {
			return getGEFWrapper(new RequirementDerivedFromCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.RequirementRefinedBy_4015 == req.getElementType()) {
			return getGEFWrapper(new RequirementRefinedByCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (RdalElementTypes.RequirementAssumptions_4017 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case AbstractRequirementContainedRequirementsEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractRequirementContainedRequirementsReorientCommand(
					req));
		case ContractualElementStakeHoldersEditPart.VISUAL_ID:
			return getGEFWrapper(new ContractualElementStakeHoldersReorientCommand(
					req));
		case AbstractRequirementVerifiedByEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractRequirementVerifiedByReorientCommand(
					req));
		case RequirementDerivedFromEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementDerivedFromReorientCommand(req));
		case RequirementRefinedByEditPart.VISUAL_ID:
			return getGEFWrapper(new RequirementRefinedByReorientCommand(req));
//		case RequirementAssumptionsEditPart.VISUAL_ID:
//			return getGEFWrapper(new RequirementAssumptionsReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
