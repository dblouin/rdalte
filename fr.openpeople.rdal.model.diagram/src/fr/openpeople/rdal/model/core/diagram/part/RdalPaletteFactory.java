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

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;

/**
 * @generated
 */
public class RdalPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createLinksbetweenRequirements2Group());
		paletteRoot.add(createOtherLinks3Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createRequirement1CreationTool());
		paletteContainer.add(createRequirementsGroup2CreationTool());
		paletteContainer.add(createStakeholder3CreationTool());
		paletteContainer.add(createVerificationActivity4CreationTool());
		paletteContainer.add(createAssumption5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links between Requirements" palette tool group
	 * @generated NOT
	 */
	private PaletteContainer createLinksbetweenRequirements2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.LinksbetweenRequirements2Group_title);
		paletteContainer.setId("createLinksbetweenRequirements2Group"); //$NON-NLS-1$
		paletteContainer.add(createReqDecomposedTo1CreationTool());
		paletteContainer.add(createReqDerivedFrom2CreationTool());
		paletteContainer.add(createReqRefinedBy3CreationTool());
		// Req assumption link is decomposition.
		//paletteContainer.add(createReqAssumes4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Other Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createOtherLinks3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.OtherLinks3Group_title);
		paletteContainer.setId("createOtherLinks3Group"); //$NON-NLS-1$
		paletteContainer.add(createLinkToStakeHolder1CreationTool());
		paletteContainer.add(createLinkToVerificationActivity2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequirement1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Requirement1CreationTool_title,
				Messages.Requirement1CreationTool_desc,
				Collections.singletonList(RdalElementTypes.Requirement_3003));
		entry.setId("createRequirement1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/requirement.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequirementsGroup2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RequirementsGroup2CreationTool_title,
				Messages.RequirementsGroup2CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.RequirementsGroup_2007));
		entry.setId("createRequirementsGroup2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/requirementGroup.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStakeholder3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Stakeholder3CreationTool_title,
				Messages.Stakeholder3CreationTool_desc,
				Collections.singletonList(RdalElementTypes.StakeHolder_2011));
		entry.setId("createStakeholder3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/stakeHolder.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVerificationActivity4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VerificationActivity4CreationTool_title,
				Messages.VerificationActivity4CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.VerificationActivity_2010));
		entry.setId("createVerificationActivity4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/verificationActivity.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssumption5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Assumption5CreationTool_title,
				Messages.Assumption5CreationTool_desc,
				Collections.singletonList(RdalElementTypes.Assumption_3004));
		entry.setId("createAssumption5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/assumption.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReqDecomposedTo1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ReqDecomposedTo1CreationTool_title,
				Messages.ReqDecomposedTo1CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.AbstractRequirementContainedRequirements_4016));
		entry.setId("createReqDecomposedTo1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/decomposition.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReqDerivedFrom2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ReqDerivedFrom2CreationTool_title,
				Messages.ReqDerivedFrom2CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.RequirementDerivedFrom_4014));
		entry.setId("createReqDerivedFrom2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/derived.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReqRefinedBy3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ReqRefinedBy3CreationTool_title,
				Messages.ReqRefinedBy3CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.RequirementRefinedBy_4015));
		entry.setId("createReqRefinedBy3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/refined.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReqAssumes4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ReqAssumes4CreationTool_title,
				Messages.ReqAssumes4CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.RequirementAssumptions_4017));
		entry.setId("createReqAssumes4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/assumes.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLinkToStakeHolder1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.LinkToStakeHolder1CreationTool_title,
				Messages.LinkToStakeHolder1CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.ContractualElementStakeHolders_4020));
		entry.setId("createLinkToStakeHolder1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/linkStakeholder.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLinkToVerificationActivity2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.LinkToVerificationActivity2CreationTool_title,
				Messages.LinkToVerificationActivity2CreationTool_desc,
				Collections
						.singletonList(RdalElementTypes.AbstractRequirementVerifiedBy_4019));
		entry.setId("createLinkToVerificationActivity2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RdalDiagramEditorPlugin
				.findImageDescriptor("/fr.openpeople.rdal.model.diagram/icons/obj16/linkTestcase.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
