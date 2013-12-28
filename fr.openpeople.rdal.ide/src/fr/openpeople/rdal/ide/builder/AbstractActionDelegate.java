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
package fr.openpeople.rdal.ide.builder;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.openpeople.rdal.ide.RdalIdePlugin;

public abstract class AbstractActionDelegate implements IObjectActionDelegate {

	private ISelection selection;
	
	private final IExceptionHandler exceptionHandler;

	protected AbstractActionDelegate() {
		exceptionHandler = RdalIdePlugin.getDefault().getExceptionHandler();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	protected IProject getProject() {
		IProject project = null;

		if ( selection instanceof IStructuredSelection ) {
			for ( final Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext(); ) {
				final Object element = it.next();

				if ( element instanceof IProject ) {
					project = (IProject) element;
				}
				else if ( element instanceof IAdaptable ) {
					project = (IProject) ( (IAdaptable) element ).getAdapter( IProject.class );
				}
				
			}
		}

		return project;
	}
	
	protected IExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}
}
