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
package fr.openpeople.rdal.model.core.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementContainedRequirementsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AbstractRequirementVerifiedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AssumptionEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.AssumptionNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.ContractualElementStakeHoldersEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementAssumptionsEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementDerivedFromEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementRefinedByEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementTypeEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.RequirementsGroupNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.SpecificationEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.StakeHolderEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.StakeHolderNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.VerificationActivityEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.VerificationActivityNameEditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabel2EditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabel3EditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabel4EditPart;
import fr.openpeople.rdal.model.core.diagram.edit.parts.WrappingLabelEditPart;
import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorPlugin;
import fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry;
import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;
import fr.openpeople.rdal.model.core.diagram.providers.RdalParserProvider;

/**
 * @generated
 */
public class RdalNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		RdalDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		RdalDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof RdalNavigatorItem
				&& !isOwnView(((RdalNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof RdalNavigatorGroup) {
			RdalNavigatorGroup group = (RdalNavigatorGroup) element;
			return RdalDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof RdalNavigatorItem) {
			RdalNavigatorItem navigatorItem = (RdalNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (RdalVisualIDRegistry.getVisualID(view)) {
		case RequirementDerivedFromEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///www.open-people.fr/rdal/core?Requirement?derivedFrom", RdalElementTypes.RequirementDerivedFrom_4014); //$NON-NLS-1$
		case RequirementRefinedByEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///www.open-people.fr/rdal/core?Requirement?refinedBy", RdalElementTypes.RequirementRefinedBy_4015); //$NON-NLS-1$
		case RequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///www.open-people.fr/rdal/core?Requirement", RdalElementTypes.Requirement_3003); //$NON-NLS-1$
		case RequirementAssumptionsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///www.open-people.fr/rdal/core?Requirement?assumptions", RdalElementTypes.RequirementAssumptions_4017); //$NON-NLS-1$
		case AbstractRequirementVerifiedByEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///www.open-people.fr/rdal/core?AbstractRequirement?verifiedBy", RdalElementTypes.AbstractRequirementVerifiedBy_4019); //$NON-NLS-1$
		case SpecificationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///www.open-people.fr/rdal/core?Specification", RdalElementTypes.Specification_1000); //$NON-NLS-1$
		case VerificationActivityEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///www.open-people.fr/rdal/core?VerificationActivity", RdalElementTypes.VerificationActivity_2010); //$NON-NLS-1$
		case RequirementsGroupEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///www.open-people.fr/rdal/core?RequirementsGroup", RdalElementTypes.RequirementsGroup_2007); //$NON-NLS-1$
		case AbstractRequirementContainedRequirementsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///www.open-people.fr/rdal/core?AbstractRequirement?containedRequirements", RdalElementTypes.AbstractRequirementContainedRequirements_4016); //$NON-NLS-1$
		case AssumptionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///www.open-people.fr/rdal/core?Assumption", RdalElementTypes.Assumption_3004); //$NON-NLS-1$
		case ContractualElementStakeHoldersEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///www.open-people.fr/rdal/core?ContractualElement?stakeHolders", RdalElementTypes.ContractualElementStakeHolders_4020); //$NON-NLS-1$
		case StakeHolderEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///www.open-people.fr/rdal/core?StakeHolder", RdalElementTypes.StakeHolder_2011); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = RdalDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& RdalElementTypes.isKnownElementType(elementType)) {
			image = RdalElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof RdalNavigatorGroup) {
			RdalNavigatorGroup group = (RdalNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof RdalNavigatorItem) {
			RdalNavigatorItem navigatorItem = (RdalNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (RdalVisualIDRegistry.getVisualID(view)) {
		case RequirementDerivedFromEditPart.VISUAL_ID:
			return getRequirementDerivedFrom_4014Text(view);
		case RequirementRefinedByEditPart.VISUAL_ID:
			return getRequirementRefinedBy_4015Text(view);
		case RequirementEditPart.VISUAL_ID:
			return getRequirement_3003Text(view);
		case RequirementAssumptionsEditPart.VISUAL_ID:
			return getRequirementAssumptions_4017Text(view);
		case AbstractRequirementVerifiedByEditPart.VISUAL_ID:
			return getAbstractRequirementVerifiedBy_4019Text(view);
		case SpecificationEditPart.VISUAL_ID:
			return getSpecification_1000Text(view);
		case VerificationActivityEditPart.VISUAL_ID:
			return getVerificationActivity_2010Text(view);
		case RequirementsGroupEditPart.VISUAL_ID:
			return getRequirementsGroup_2007Text(view);
		case AbstractRequirementContainedRequirementsEditPart.VISUAL_ID:
			return getAbstractRequirementContainedRequirements_4016Text(view);
		case AssumptionEditPart.VISUAL_ID:
			return getAssumption_3004Text(view);
		case ContractualElementStakeHoldersEditPart.VISUAL_ID:
			return getContractualElementStakeHolders_4020Text(view);
		case StakeHolderEditPart.VISUAL_ID:
			return getStakeHolder_2011Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getRequirementRefinedBy_4015Text(View view) {
		IParser parser = RdalParserProvider.getParser(
				RdalElementTypes.RequirementRefinedBy_4015,
				view.getElement() != null ? view.getElement() : view,
				RdalVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementDerivedFrom_4014Text(View view) {
		IParser parser = RdalParserProvider.getParser(
				RdalElementTypes.RequirementDerivedFrom_4014,
				view.getElement() != null ? view.getElement() : view,
				RdalVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVerificationActivity_2010Text(View view) {
		IParser parser = RdalParserProvider.getParser(
				RdalElementTypes.VerificationActivity_2010,
				view.getElement() != null ? view.getElement() : view,
				RdalVisualIDRegistry
						.getType(VerificationActivityNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssumption_3004Text(View view) {
		IParser parser = RdalParserProvider.getParser(
				RdalElementTypes.Assumption_3004,
				view.getElement() != null ? view.getElement() : view,
				RdalVisualIDRegistry.getType(AssumptionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirement_3003Text(View view) {
		IParser parser = RdalParserProvider
				.getParser(RdalElementTypes.Requirement_3003,
						view.getElement() != null ? view.getElement() : view,
						RdalVisualIDRegistry
								.getType(RequirementTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementAssumptions_4017Text(View view) {
		IParser parser = RdalParserProvider.getParser(
				RdalElementTypes.RequirementAssumptions_4017,
				view.getElement() != null ? view.getElement() : view,
				RdalVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementsGroup_2007Text(View view) {
		IParser parser = RdalParserProvider.getParser(
				RdalElementTypes.RequirementsGroup_2007,
				view.getElement() != null ? view.getElement() : view,
				RdalVisualIDRegistry
						.getType(RequirementsGroupNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStakeHolder_2011Text(View view) {
		IParser parser = RdalParserProvider
				.getParser(RdalElementTypes.StakeHolder_2011,
						view.getElement() != null ? view.getElement() : view,
						RdalVisualIDRegistry
								.getType(StakeHolderNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSpecification_1000Text(View view) {
		Specification domainModelElement = (Specification) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAbstractRequirementContainedRequirements_4016Text(
			View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getContractualElementStakeHolders_4020Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAbstractRequirementVerifiedBy_4019Text(View view) {
		IParser parser = RdalParserProvider.getParser(
				RdalElementTypes.AbstractRequirementVerifiedBy_4019,
				view.getElement() != null ? view.getElement() : view,
				RdalVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return SpecificationEditPart.MODEL_ID.equals(RdalVisualIDRegistry
				.getModelID(view));
	}

}
