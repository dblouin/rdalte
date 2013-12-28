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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

public class ParentExcludingResourcesVisitor implements IResourceVisitor {

	private final IResource parent;
	private final Collection<String> allowedFileExtensions;
	private final Collection<IResource> foundResources;

	public ParentExcludingResourcesVisitor( final IResource p_parent,
											final Collection<String> p_allowedFileExtensions ) {
		parent = p_parent;
		allowedFileExtensions = p_allowedFileExtensions;
		foundResources = new ArrayList<IResource>();
	}

	@Override
	public boolean visit( final IResource p_resource )
	throws CoreException {
		if ( p_resource != parent ) {
			if ( p_resource instanceof IFile ) {
				if ( allowedFileExtensions == null || allowedFileExtensions.contains( p_resource.getFileExtension() ) ) {
					foundResources.add( p_resource );
				}
			}
			else if ( p_resource instanceof IContainer ) { 
				foundResources.add( p_resource );
			}
		}

		return true;
	}
	
	public Collection<IResource> getFoundResources() {
		return foundResources;
	}
}
