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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.labsticc.framework.ide.wizard.AbstractExampleWizard;

/**
 * Create the example projects.
 * @author <a href="mailto:dominique.blouin@univ-ubs.fr">Dominique BLOUIN</a>
 */
public class FPGAExamplesWizard extends AbstractRdalExamplesWizard {

	/**
	 * {@inheritDoc}
	 * 
	 * @see AbstractExampleWizard#getProjectDescriptors()
	 */
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		final List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>( 1 );
		projects.add( new ProjectDescriptor( 	PLUGIN_ID, 
												EX_SRC_DIR + "ex_xc5vfx100t.zip", 
												"xc5vfx100t" ) );
		projects.add( new ProjectDescriptor( 	PLUGIN_ID, 
												EX_SRC_DIR + "/ex_xc5vfx100t_conf1.zip", 
												"xc5vfx100t_conf1" ) );
		projects.add( new ProjectDescriptor( 	PLUGIN_ID, 
												EX_SRC_DIR + "ex_basic_application.zip", 
												"basic_application" ) );
		projects.add( new ProjectDescriptor( 	PLUGIN_ID, 
												EX_SRC_DIR + "ex_basic_application_xc5vfx100t_conf1.zip", 
												"basic_application_xc5vfx100t_conf1" ) );

		return projects;
	}
}
