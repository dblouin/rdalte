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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import fr.openpeople.rdal.model.core.diagram.edit.commands.AssumptionCreateCommand;
import fr.openpeople.rdal.model.core.diagram.edit.commands.RequirementCreateCommand;
import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;

/**
 * @generated
 */
public class RequirementsGroupRequirementsCompartmentItemSemanticEditPolicy
		extends RdalBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementsGroupRequirementsCompartmentItemSemanticEditPolicy() {
		super(RdalElementTypes.RequirementsGroup_2007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (RdalElementTypes.Requirement_3003 == req.getElementType()) {
			return getGEFWrapper(new RequirementCreateCommand(req));
		}
		if (RdalElementTypes.Assumption_3004 == req.getElementType()) {
			return getGEFWrapper(new AssumptionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
