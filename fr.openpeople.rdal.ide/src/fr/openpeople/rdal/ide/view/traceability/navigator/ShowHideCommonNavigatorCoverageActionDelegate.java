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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.navigator.ResourceNavigator;

import fr.openpeople.rdal.ide.RdalIdePlugin;

@SuppressWarnings("deprecation")
public class ShowHideCommonNavigatorCoverageActionDelegate implements IViewActionDelegate {

	private CommonNavigator commonNavigator;
	private ResourceNavigator resourceNavigator;
	
	private Layout parentLayout;
	
	public ShowHideCommonNavigatorCoverageActionDelegate() {
		commonNavigator = null;
		resourceNavigator = null;
		parentLayout = null;
	}
	
	@Override
	public void init( final IViewPart p_view ) {
		if ( p_view instanceof CommonNavigator ) {
			commonNavigator = (CommonNavigator) p_view;
		}
		else if ( p_view instanceof ResourceNavigator ) {
			resourceNavigator = (ResourceNavigator) p_view;
		}
	}

	@Override
	public void run( final IAction p_action ) {
		setCoverageColumnVisible( p_action.isChecked() );
	}
	
	private TreeViewer getTreeVIewer() {
		if ( commonNavigator != null ) {
			return commonNavigator.getCommonViewer();
		}

		if ( resourceNavigator != null ) {
			return resourceNavigator.getTreeViewer();
		}
		
		throw new IllegalStateException( "Unknowned type of navigator." );
	}
	
	private void setCoverageColumnVisible( final boolean pb_value ) {
		final TreeViewer viewer = getTreeVIewer();
		final Tree tree = viewer.getTree();
		
		if ( pb_value ) {
			parentLayout = tree.getParent().getLayout();
			final TreeColumnLayout colLayout = new TreeColumnLayout();
			tree.getParent().setLayout( colLayout );
			final TreeColumn resourceColumn = new TreeColumn( tree, SWT.NONE );
			resourceColumn.setText( "Resources" );
			final ColumnWeightData colDataRes = new ColumnWeightData( 70, 200 );
			colLayout.setColumnData( resourceColumn, colDataRes );

			final TreeViewerColumn coverageViewerColumn = new TreeViewerColumn( viewer, SWT.NONE );
			coverageViewerColumn.setLabelProvider( new CoverageLabelProvider( 	coverageViewerColumn, 
																				viewer, 
																				RdalIdePlugin.getDefault().getDefinedCoverageListers(),
																				RdalIdePlugin.getDefault().getExceptionHandler() ) );

			final TreeColumn coverageColumn = coverageViewerColumn.getColumn();
			coverageColumn.setText( "Verif. Rate" );
			final ColumnWeightData colDataCov = new ColumnWeightData( 30, 40 );
			colLayout.setColumnData( coverageColumn, colDataCov );
		}
		else {
			for ( final TreeColumn column : tree.getColumns() ) {
				column.dispose();
			}
			
			tree.getParent().setLayout( parentLayout );
		}

		// This works for both Windows and Linux
		tree.setHeaderVisible( pb_value );
		tree.getParent().layout();
		viewer.refresh();
		
//		final TreeColumn coverageColumn = tree.getColumn( 1 );
		
//		coverageColumn.setResizable( pb_value );
		// Set width does not work for Linux platforms
//		coverageColumn.setWidth( pb_value ? 150 : 0 );
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
