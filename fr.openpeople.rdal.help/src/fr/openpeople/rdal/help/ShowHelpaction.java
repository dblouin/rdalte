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
package fr.openpeople.rdal.help;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;


import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;








import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import fr.openpeople.rdal.model.core.diagram.part.RdalCreationWizard;

public class ShowHelpaction extends Action{
	 public void run(){
	
			 IWorkbench workbench = PlatformUI.getWorkbench();
			 Shell shell = workbench.getActiveWorkbenchWindow().getShell();
			 RdalCreationWizard wizard= new RdalCreationWizard();
			 wizard.init(workbench,new StructuredSelection());
			 WizardDialog dialog= new WizardDialog(shell, wizard);
			 dialog.create();
			 dialog.open();
			 //did the wizard succeed?
			 notifyResult(dialog.getReturnCode()==Dialog.OK);
	 }
}
