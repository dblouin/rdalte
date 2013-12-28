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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.emf.core.resource.EMFResourcesVisitor;
import fr.labsticc.framework.emf.core.resource.IEMFResourceHandler;

public class DesignSpecificationsVisitor extends EMFResourcesVisitor {
	
	private final Collection<EClass> supportedDesignSpecificationTypes;
	
	public DesignSpecificationsVisitor( final Collection<EClass> p_supportedDesignSpecificationTypes,
										final Collection<String> p_supportedDesignSpecificationFileTypes,
										final Collection<IEMFResourceHandler> p_resourceHandlers ) {
		super( p_supportedDesignSpecificationFileTypes, p_resourceHandlers );
		
		supportedDesignSpecificationTypes = p_supportedDesignSpecificationTypes;
	}

	public Collection<EObject> getDesignSpecifications() 
	throws ResourceAccessException {
		final Collection<EObject> designSpecifications = new ArrayList<EObject>();
		
		for ( final Resource resource : getFoundEMFResources() ) {
//			final Resource eResource;
			
//			if ( OsateResourceManager.isAadlXMLResource( resource ) ) {
//				eResource = OsateResourceManager.getResource( resource );
//			}
//			else {
//				final IPath path = resource.getFullPath();
//				final URI uri = URI.createPlatformResourceURI( path.toString(), false );
//				eResource = resourceSet.getResource( uri, true );
//			}
			
			if ( !resource.getContents().isEmpty() ) {
				final EObject element = resource.getContents().get( 0 );
				
				if ( supportedDesignSpecificationTypes.contains( element.eClass() ) ) {
					designSpecifications.add( element );
				}
			}
		}
		
		return designSpecifications;
	}
}
