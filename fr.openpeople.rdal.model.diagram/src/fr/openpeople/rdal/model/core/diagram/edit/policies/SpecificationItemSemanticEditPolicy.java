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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementsGroupCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.StakeHolderCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.VerificationActivityCreateCommand;
import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;

/**
 * @generated
 */
public class SpecificationItemSemanticEditPolicy extends
		RdalBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SpecificationItemSemanticEditPolicy() {
		super(RdalElementTypes.Specification_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (RdalElementTypes.RequirementsGroup_2007 == req.getElementType()) {
			return getGEFWrapper(new RequirementsGroupCreateCommand(req));
		}
		if (RdalElementTypes.StakeHolder_2011 == req.getElementType()) {
			return getGEFWrapper(new StakeHolderCreateCommand(req));
		}
		if (RdalElementTypes.VerificationActivity_2010 == req.getElementType()) {
			return getGEFWrapper(new VerificationActivityCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
