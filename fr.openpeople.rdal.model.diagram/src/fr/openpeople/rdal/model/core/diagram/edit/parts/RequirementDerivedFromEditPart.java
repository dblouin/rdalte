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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import fr.openpeople.rdal.model.core.diagram.edit.policies.RequirementDerivedFromItemSemanticEditPolicy;

/**
 * @generated
 */
public class RequirementDerivedFromEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4014;

	/**
	 * @generated
	 */
	public RequirementDerivedFromEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RequirementDerivedFromItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel2EditPart) {
			((WrappingLabel2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureDerivedFromLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel2EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new RequirementDerivationLink();
	}

	/**
	 * @generated
	 */
	public RequirementDerivationLink getPrimaryShape() {
		return (RequirementDerivationLink) getFigure();
	}

	/**
	 * @generated
	 */
	public class RequirementDerivationLink extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDerivedFromLabel;

		/**
		 * @generated
		 */
		public RequirementDerivationLink() {
			this.setFillXOR(true);
			this.setBackgroundColor(THIS_BACK);

			createContents();
			setSourceDecoration(createSourceDecoration());
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureDerivedFromLabel = new WrappingLabel();
			fFigureDerivedFromLabel.setText("<<derivedFrom>>");

			this.add(fFigureDerivedFromLabel);

		}

		/**
		 * @generated NOT
		 * TODO Investigate why we need to modify the scale!
		 */
		private RotatableDecoration createSourceDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			df.setFill(true);
			df.setLineWidth(1);
			df.setForegroundColor(DF_FORE);
			df.setBackgroundColor(DF_BACK);
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(1), getMapMode().DPtoLP(6));
			pl.addPoint(getMapMode().DPtoLP(3), getMapMode().DPtoLP(4));
			pl.addPoint(getMapMode().DPtoLP(4), getMapMode().DPtoLP(3));
			pl.addPoint(getMapMode().DPtoLP(6), getMapMode().DPtoLP(1));
			pl.addPoint(getMapMode().DPtoLP(6), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(6), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(4), getMapMode().DPtoLP(-3));
			pl.addPoint(getMapMode().DPtoLP(3), getMapMode().DPtoLP(-4));
			pl.addPoint(getMapMode().DPtoLP(1), getMapMode().DPtoLP(-6));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(-6));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-6));
			pl.addPoint(getMapMode().DPtoLP(-3), getMapMode().DPtoLP(-4));
			pl.addPoint(getMapMode().DPtoLP(-4), getMapMode().DPtoLP(-3));
			pl.addPoint(getMapMode().DPtoLP(-6), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(-6), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-6), getMapMode().DPtoLP(1));
			pl.addPoint(getMapMode().DPtoLP(-4), getMapMode().DPtoLP(3));
			pl.addPoint(getMapMode().DPtoLP(-3), getMapMode().DPtoLP(4));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(6));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(6));
			pl.addPoint(getMapMode().DPtoLP(1), getMapMode().DPtoLP(6));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(1), getMapMode().DPtoLP(1));
			return df;
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDerivedFromLabel() {
			return fFigureDerivedFromLabel;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 0, 0, 0);

	/**
	 * @generated
	 */
	static final Color DF_FORE = new Color(null, 0, 0, 0);

	/**
	 * @generated
	 */
	static final Color DF_BACK = new Color(null, 255, 255, 255);

}
