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
package fr.openpeople.rdal.ide.osate.view.traceability;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.part.IPage;

import fr.openpeople.rdal.ide.view.traceability.navigator.AbstractShowHideOutlineCoverageActionDelegate;

public class ShowHideAADLOutlineCoverageActionDelegate extends AbstractShowHideOutlineCoverageActionDelegate {

	@Override
	public void selectionChanged( 	final IAction p_action, 
									final ISelection p_selection ) {
		//p_action.setEnabled( isAaxlOutlinePage() );
	}

	@Override
	protected TreeViewer getTreeViewer( final IPage p_page ) {
//		if ( isAaxlOutlinePage() ) {
//			return ( (CoreEditor.MyContentOutlinePage) p_page ).getTreeViewer();
//		}
		
		return null;
	}
	
//	private boolean isAaxlOutlinePage() {
//		return getOutlineView().getCurrentPage() instanceof CoreEditor.MyContentOutlinePage;
//	}
}
