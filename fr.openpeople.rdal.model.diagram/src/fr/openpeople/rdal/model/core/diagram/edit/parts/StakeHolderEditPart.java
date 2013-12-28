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
package fr.openpeople.rdal.model.core.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonShape;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import fr.openpeople.rdal.model.core.diagram.edit.policies.StakeHolderItemSemanticEditPolicy;
import fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry;
import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;

/**
 * @generated
 */
public class StakeHolderEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2011;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public StakeHolderEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StakeHolderItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (RdalVisualIDRegistry.getVisualID(childView)) {
				case StakeHolderNameEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle(
									(GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new StakeHolderFigure();
	}

	/**
	 * @generated
	 */
	public StakeHolderFigure getPrimaryShape() {
		return (StakeHolderFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof StakeHolderNameEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(35, 50);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.SOUTH);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(RdalVisualIDRegistry
				.getType(StakeHolderNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(RdalElementTypes.ContractualElementStakeHolders_4020);
		types.add(RdalElementTypes.RequirementRefinedBy_4015);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == RdalElementTypes.ContractualElementStakeHolders_4020) {
			types.add(RdalElementTypes.RequirementsGroup_2007);
			types.add(RdalElementTypes.Requirement_3003);
			types.add(RdalElementTypes.Assumption_3004);
		} else if (relationshipType == RdalElementTypes.RequirementRefinedBy_4015) {
			types.add(RdalElementTypes.Requirement_3003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class StakeHolderFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		public StakeHolderFigure() {
			this.setLayoutManager(new StackLayout());
			this.setFill(false);
			this.setOutline(false);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(56)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			PolygonShape stakeHolderBody0 = new PolygonShape();
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(19)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(24)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(39),
					getMapMode().DPtoLP(24)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(39),
					getMapMode().DPtoLP(29)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(29)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(36)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(39),
					getMapMode().DPtoLP(48)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(39),
					getMapMode().DPtoLP(53)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(42)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(1),
					getMapMode().DPtoLP(53)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(1),
					getMapMode().DPtoLP(48)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(17),
					getMapMode().DPtoLP(36)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(17),
					getMapMode().DPtoLP(29)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(1),
					getMapMode().DPtoLP(29)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(1),
					getMapMode().DPtoLP(24)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(17),
					getMapMode().DPtoLP(24)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(17),
					getMapMode().DPtoLP(19)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(19)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(26),
					getMapMode().DPtoLP(16)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(28),
					getMapMode().DPtoLP(12)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(28),
					getMapMode().DPtoLP(8)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(26),
					getMapMode().DPtoLP(4)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(21),
					getMapMode().DPtoLP(3)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(4)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(8)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(12)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(14),
					getMapMode().DPtoLP(16)));
			stakeHolderBody0.addPoint(new Point(getMapMode().DPtoLP(17),
					getMapMode().DPtoLP(19)));
			stakeHolderBody0.setFill(true);
			stakeHolderBody0.setForegroundColor(STAKEHOLDERBODY0_FORE);
			stakeHolderBody0.setBackgroundColor(STAKEHOLDERBODY0_BACK);

			this.add(stakeHolderBody0);

		}

	}

	/**
	 * @generated
	 */
	static final Color STAKEHOLDERBODY0_FORE = new Color(null, 120, 120, 90);

	/**
	 * @generated
	 */
	static final Color STAKEHOLDERBODY0_BACK = new Color(null, 230, 230, 250);

}
