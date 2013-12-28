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
package fr.openpeople.rdal.model.core.util;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.emf.core.object.EMFURIEqualsSet;
import fr.labsticc.framework.emf.core.util.EMFUtil;
import fr.labsticc.framework.settings.ide.SettingsPlugin;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Specification;

public class RDALModelUtil {

	public static Set<EObject> allowedModelElements( final Specification p_specification ) {
		final Set<EObject> allowedElements = new EMFURIEqualsSet<EObject>();
		final SettingsPlugin settingsPlugin = SettingsPlugin.getDefault();
		
		// When the workbench closes, OSGI does not bother starting the plugin which causes a null pointer exception. 
		if ( settingsPlugin != null ) {
			final Collection<EClass> supportedTypes = settingsPlugin.getPropertyToTypeAssClasses( CorePackage.eINSTANCE.getModelElementReference_ModelElement() );
			
			for ( final EObject specifiedObj : p_specification.getSpecifies() ) {
				
				// Avoids null pointer exceptions when unresolved proxies.
				if ( specifiedObj.eResource() != null ) {
					EMFUtil.fillContentOfTypes( specifiedObj.eResource(), supportedTypes, allowedElements );
				}
			}
		}
		
		return allowedElements;
	}
}
