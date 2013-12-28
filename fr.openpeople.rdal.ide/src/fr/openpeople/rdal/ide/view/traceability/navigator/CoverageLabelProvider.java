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

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.TreeColumn;

import fr.labsticc.framework.core.exception.IExceptionHandler;

public class CoverageLabelProvider extends OwnerDrawLabelProvider {

	private final TreeColumn column;
	private final TreeViewer viewer;
	private final Collection<ICoverageLister> coverageListers;
	private final IExceptionHandler exceptionHandler;

	public CoverageLabelProvider(	final TreeViewerColumn p_column2, 
									final TreeViewer p_commonViewer,
									final Collection<ICoverageLister> p_coverageListers,
									final IExceptionHandler p_exceptionHandler ) {
		column = p_column2.getColumn();
		viewer = p_commonViewer;
		coverageListers = p_coverageListers;
		exceptionHandler = p_exceptionHandler;
	}

	@Override
	protected void measure(	final Event p_event, 
							final Object p_element ) {
	}

	@Override
	protected void paint(	final Event p_event, 
							final Object p_element ) {
		final int colWidth = column.getWidth();
		
		if ( colWidth != 0 ) {
			
			// Nothing to paint when the column is hidden.
			final Display display = viewer.getControl().getDisplay();
			final Rectangle place = new Rectangle( 	p_event.x, 
													p_event.y, 
													colWidth, 
													p_event.height );
			
			for ( final ICoverageLister coverageLister : coverageListers ) {
				try {
					coverageLister.drawCoverageData( p_element, display, p_event.gc, place );
				}
				catch ( final CoreException p_ex ) {
					exceptionHandler.handleException( p_ex, p_element );
				}
			}
		}
	}
}
