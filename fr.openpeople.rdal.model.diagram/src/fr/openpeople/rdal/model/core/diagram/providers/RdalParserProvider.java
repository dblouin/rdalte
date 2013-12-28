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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AssumptionNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementTypeEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.StakeHolderNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.VerificationActivityNameEditPart;
import fr.openpeople.rdal.model.core.diagram.parsers.MessageFormatParser;
import fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry;

/**
 * @generated
 */
public class RdalParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser requirementsGroupName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementsGroupName_5013Parser() {
		if (requirementsGroupName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getIdentifiedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			requirementsGroupName_5013Parser = parser;
		}
		return requirementsGroupName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser stakeHolderName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getStakeHolderName_5018Parser() {
		if (stakeHolderName_5018Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getIdentifiedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stakeHolderName_5018Parser = parser;
		}
		return stakeHolderName_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser verificationActivityName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getVerificationActivityName_5017Parser() {
		if (verificationActivityName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getIdentifiedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			verificationActivityName_5017Parser = parser;
		}
		return verificationActivityName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementName_5011Parser() {
		if (requirementName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getIdentifiedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			requirementName_5011Parser = parser;
		}
		return requirementName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser assumptionName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getAssumptionName_5016Parser() {
		if (assumptionName_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { CorePackage.eINSTANCE
					.getIdentifiedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			assumptionName_5016Parser = parser;
		}
		return assumptionName_5016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case RequirementsGroupNameEditPart.VISUAL_ID:
			return getRequirementsGroupName_5013Parser();
		case StakeHolderNameEditPart.VISUAL_ID:
			return getStakeHolderName_5018Parser();
		case VerificationActivityNameEditPart.VISUAL_ID:
			return getVerificationActivityName_5017Parser();
		case RequirementTypeEditPart.VISUAL_ID:
			return getRequirementName_5011Parser();
		case AssumptionNameEditPart.VISUAL_ID:
			return getAssumptionName_5016Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(RdalVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(RdalVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (RdalElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
