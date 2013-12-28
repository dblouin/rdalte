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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public interface ICoverageLister {

	void storeCoverageData(	IResource p_resource,
							Float p_ratio,
							Integer p_base )
	throws CoreException;

	void storeCoverageData(	EObject p_modelElement,
							Float p_ratio,
							Integer p_base )
	throws CoreException;
	
	void drawCoverageData( 	Object p_element,
							Display p_display,
							GC p_graphics,
							Rectangle p_place )
	throws CoreException;

	void deleteCoverageData( IResource p_resource )
	throws CoreException;
}
