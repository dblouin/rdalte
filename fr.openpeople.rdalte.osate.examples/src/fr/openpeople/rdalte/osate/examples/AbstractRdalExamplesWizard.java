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
package fr.openpeople.rdalte.osate.examples;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.labsticc.framework.ide.wizard.AbstractExampleWizard;

/**
 * Create the example projects.
 * @author <a href="mailto:dominique.blouin@univ-ubs.fr">Dominique BLOUIN</a>
 */
public abstract class AbstractRdalExamplesWizard extends AbstractExampleWizard {
	
	// The plug-in ID
	protected static final String PLUGIN_ID = "fr.openpeople.rdalte.osate.examples"; //$NON-NLS-1$
	protected static final String EX_SRC_DIR = "examples_src/"; //$NON-NLS-1$

	private final Logger logger;
	
	protected AbstractRdalExamplesWizard() {
		logger = LoggerFactory.getLogger( getClass() );
	}

	/*
	 * (non-Javadoc)
	 * @see fr.labsticc.framework.ide.wizard.AbstractExampleWizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// this block calls the initialization of OSATEP.
		// In case the user is working on a fresh workspace, 
		// some necessary projects and configuration files will be created.
		try {
			getContainer().run(true, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) 
				throws InvocationTargetException, InterruptedException {
					final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
						@Override
						protected void execute( final IProgressMonitor p_monitor )
								throws CoreException, InvocationTargetException, InterruptedException {
							p_monitor.beginTask( "Preparing workspace...", 1 ); //$NON-NLS-1$

							// initialize OSATE contribution
							PredeclaredProperties.initPluginContributedAadl();
							p_monitor.worked(1);
						}
					};
					operation.run(monitor);
				}
			} );
		}
		catch ( final InvocationTargetException p_ex ) {
			logger.error( toString(), p_ex );
			
			return false;
		}
		catch (final InterruptedException e) {
			// We cannot be interrupted, just proceed as normal.
		}
		
		return super.performFinish();
	}
}
