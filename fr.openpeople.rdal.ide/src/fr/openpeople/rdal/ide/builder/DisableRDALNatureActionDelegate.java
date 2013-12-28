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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;

import fr.labsticc.framework.ide.util.PluginUtil;

public class DisableRDALNatureActionDelegate extends AbstractActionDelegate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run( final IAction p_action ) {
		try {
			PluginUtil.removeNature( getProject(), RDALNature.NATURE_ID );
		}
		catch ( final CoreException p_ex ) {
			getExceptionHandler().handleException( p_ex, getProject() );
		}
	}
}
