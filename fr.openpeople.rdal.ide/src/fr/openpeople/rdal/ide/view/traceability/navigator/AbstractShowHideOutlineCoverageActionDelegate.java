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
package fr.openpeople.rdal.ide.view.traceability.navigator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.contentoutline.ContentOutline;

import fr.openpeople.rdal.ide.RdalIdePlugin;

public abstract class AbstractShowHideOutlineCoverageActionDelegate implements IViewActionDelegate {

	private ContentOutline outlineView;
	
	private Layout parentLayout;

	public AbstractShowHideOutlineCoverageActionDelegate() {
		outlineView = null;
		parentLayout = null;
	}
	
	@Override
	public void init( final IViewPart p_view ) {
		outlineView = (ContentOutline) p_view;
	}
	
	@Override
	public void run( final IAction p_action ) {
		setCoverageColumnVisible( p_action.isChecked() );
	}
	
	protected void setCoverageColumnVisible( final boolean pb_value ) {
		final TreeViewer viewer = getTreeViewer( outlineView.getCurrentPage() );

		if ( viewer != null ) {
			final Tree tree = viewer.getTree();

			if ( pb_value ) {
				if ( tree.getColumnCount() != 2 ) {
					parentLayout = tree.getParent().getLayout();
					final TreeColumnLayout colLayout = new TreeColumnLayoutFixed();
					tree.getParent().setLayout( colLayout );
					final TreeColumn resourceColumn = new TreeColumn( tree, SWT.NONE );
					resourceColumn.setText( "Resources" );
					resourceColumn.setWidth( 150 );
					final ColumnWeightData colDataRes = new ColumnWeightData( 50, 200 );
					colLayout.setColumnData( resourceColumn, colDataRes );
					resourceColumn.setWidth( colDataRes.minimumWidth );
		
					final TreeViewerColumn coverageViewerColumn = new TreeViewerColumn( viewer, SWT.NONE );
					coverageViewerColumn.setLabelProvider( new CoverageLabelProvider( 	coverageViewerColumn, 
																						viewer, 
																						RdalIdePlugin.getDefault().getDefinedCoverageListers(),
																						RdalIdePlugin.getDefault().getExceptionHandler() ) );
			
					final TreeColumn coverageColumn = coverageViewerColumn.getColumn();
					coverageColumn.setText( "Verif. Rate" );
					final ColumnWeightData colDataCov = new ColumnWeightData( 50, 80 );
					colLayout.setColumnData( coverageColumn, colDataCov );
					// DB 30/05/2011 Set width now seems necessary. Change in JFace?
					coverageColumn.setWidth( colDataCov.minimumWidth );
				}
			}
			else {
				for ( final TreeColumn column : tree.getColumns() ) {
					column.dispose();
				}
				
				tree.getParent().setLayout( parentLayout );
			}
			
			tree.setHeaderVisible( pb_value );
			tree.getParent().layout();
			viewer.refresh();
		}
	}
	
	protected abstract TreeViewer getTreeViewer( final IPage p_page );
	
	protected ContentOutline getOutlineView() {
		return outlineView;
	}
	
	/**
	 * A layout to fix the class cast exception thrown when the parent is a page book (see comment below).
	 * @author dblouin
	 *
	 */
	private static class TreeColumnLayoutFixed extends TreeColumnLayout {
		private boolean relayout = true;
		private boolean inupdateMode = false;
		private Listener resizeListener = new Listener() {

			public void handleEvent(Event event) {
				if (!inupdateMode) {
					updateColumnData(event.widget);
				}
			}

		};

		/* 
		 * Patch to fix the class cast exception thrown when the parent is a page book (see comment below).
		 * (non-Javadoc)
		 * @see org.eclipse.jface.layout.TreeColumnLayout#layout(org.eclipse.swt.widgets.Composite, boolean)
		 */
		@Override
		protected void layout(Composite composite, boolean flushCache) {
			Rectangle area = composite.getClientArea();
			
			Scrollable table = null;

			// DB: The tree is the second and not the first children element.
			for ( final Control children : composite.getChildren() ) {
				if ( children instanceof Tree ) {
					table = (Scrollable) children;
					
					break;
				}
			}
			
//			Scrollable table = (Scrollable) composite.getChildren()[ 0 ];

			if ( table == null ) {
				return;
			}
			else {
				int tableWidth = table.getSize().x;
//						int trim = computeTrim(area, table, tableWidth);
				int trim;

				if ( tableWidth > 1) {
					trim = tableWidth - table.getClientArea().width;
				}
				else {
					// initially, the table has no extend and no client area - use the
					// border with
					// plus some padding as educated guess
					trim = 2 * table.getBorderWidth() + 1;
				}
				
				int width = Math.max(0, area.width - trim);

				if ( width > 1 ) {
					layoutTableTree(table, width, area, tableWidth < area.width);
				}

				// For the first time we need to relayout because Scrollbars are not
				// calculate appropriately
				if ( relayout ) {
					relayout = false;
					composite.layout();
				}
			}
		}
		
		private void layoutTableTree(final Scrollable scrollable, final int width,
				final Rectangle area, final boolean increase) {
			final int numberOfColumns = getColumnCount(scrollable);
			final int[] widths = new int[numberOfColumns];

			final int[] weightColumnIndices = new int[numberOfColumns];
			int numberOfWeightColumns = 0;

			int fixedWidth = 0;
			int totalWeight = 0;

			// First calc space occupied by fixed columns
			for (int i = 0; i < numberOfColumns; i++) {
				ColumnLayoutData col = getLayoutData(scrollable, i);
				if (col instanceof ColumnPixelData) {
					ColumnPixelData cpd = (ColumnPixelData) col;
					int pixels = cpd.width;
					if (cpd.addTrim) {
						pixels += getColumnTrim();
					}
					widths[i] = pixels;
					fixedWidth += pixels;
				} else if (col instanceof ColumnWeightData) {
					ColumnWeightData cw = (ColumnWeightData) col;
					weightColumnIndices[numberOfWeightColumns] = i;
					numberOfWeightColumns++;
					totalWeight += cw.weight;
				} else {
					Assert.isTrue(false, "Unknown column layout data"); //$NON-NLS-1$
				}
			}

			boolean recalculate;
			
			do {
				recalculate = false;
				for (int i = 0; i < numberOfWeightColumns; i++) {
					int colIndex = weightColumnIndices[i];
					ColumnWeightData cw = (ColumnWeightData) getLayoutData(
							scrollable, colIndex);
					final int minWidth = cw.minimumWidth;
					final int allowedWidth = totalWeight == 0 ? 0
							: (width - fixedWidth) * cw.weight / totalWeight;
					if (allowedWidth < minWidth) {
						/*
						 * if the width assigned by weight is less than the minimum,
						 * then treat this column as fixed, remove it from weight
						 * calculations, and recalculate other weights.
						 */
						numberOfWeightColumns--;
						totalWeight -= cw.weight;
						fixedWidth += minWidth;
						widths[colIndex] = minWidth;
						System.arraycopy(weightColumnIndices, i + 1,
								weightColumnIndices, i, numberOfWeightColumns - i);
						recalculate = true;
						break;
					}
					widths[colIndex] = allowedWidth;
				}
			} while (recalculate);

			if (increase) {
				scrollable.setSize(area.width, area.height);
			}

			inupdateMode = true;
			setColumnWidths(scrollable, widths);
			scrollable.update();
			inupdateMode = false;

			if (!increase) {
				scrollable.setSize(area.width, area.height);
			}
		}

		/**
		 * Adds a new column of data to this table layout.
		 * 
		 * @param column
		 *            the column
		 * 
		 * @param data
		 *            the column layout data
		 */
		@Override
		public void setColumnData(Widget column, ColumnLayoutData data) {

			if (column.getData(LAYOUT_DATA) == null) {
				column.addListener(SWT.Resize, resizeListener);
			}

			column.setData(LAYOUT_DATA, data);
		}
	}
}
