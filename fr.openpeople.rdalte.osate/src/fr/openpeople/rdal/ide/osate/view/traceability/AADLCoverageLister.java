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

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import fr.openpeople.rdal.ide.view.traceability.navigator.AbstractCoverageLister;

public class AADLCoverageLister extends AbstractCoverageLister {

	public AADLCoverageLister() {
	}
	
	@Override
	protected String elementName( final EObject p_element ) {
		if ( p_element instanceof NamedElement ) {
			return ( (NamedElement) p_element ).getName() == null ? p_element.toString() : ( (NamedElement) p_element ).getName();
		}
		
		return p_element.toString();
	}
	
	@Override
	protected IResource getElementResource( final EObject p_element ) {
		return OsateResourceUtil.convertToIResource( p_element.eResource() );
	}
}
