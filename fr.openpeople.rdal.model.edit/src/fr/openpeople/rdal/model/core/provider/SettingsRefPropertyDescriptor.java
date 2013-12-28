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
package fr.openpeople.rdal.model.core.provider;

import java.util.Collection;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.emf.core.object.EMFURIEqualsList;
import fr.labsticc.framework.emf.core.resource.EMFResourcesVisitor;
import fr.labsticc.framework.emf.core.util.EMFUtil;
import fr.labsticc.framework.settings.ide.SettingsPlugin;

public class SettingsRefPropertyDescriptor extends ItemPropertyDescriptor {

    public SettingsRefPropertyDescriptor( 	final AdapterFactory p_adapterFactory,
    	      								final ResourceLocator p_resourceLocator,
	      									final String p_displayName,
	      									final String p_description,
	      									final EReference p_reference ) {
    	super( 	p_adapterFactory, 
    			p_resourceLocator, 
    			p_displayName, 
    			p_description,
    			p_reference,
				true,
				false,
				true,
				null,
				null,
				null );
    }

	@SuppressWarnings("unchecked")
	@Override
	public Collection<?> getChoiceOfValues( final Object p_object ) {
		final Collection<EObject> elementsChoice = new EMFURIEqualsList<EObject>();
		final Collection<EObject> currentElements = new EMFURIEqualsList<EObject>();
		final PropertyValueWrapper wrapper = (PropertyValueWrapper) getPropertyValue( p_object );
		final Object value = wrapper.getEditableValue( p_object );
		
		// Test so that it works also for single cardinality features
		if ( value instanceof Collection<?> )  {
			currentElements.addAll( (Collection<EObject>) value );
		}
		
		try {
			final Collection<EClass> supportedTypes = SettingsPlugin.getDefault().getPropertyToTypeAssClasses( (EReference) getFeature( null ) );
			
			if ( supportedTypes != null && !supportedTypes.isEmpty() ) {
				final EMFResourcesVisitor resVisitor = new EMFResourcesVisitor( SettingsPlugin.getDefault().getSupportedLanguagesFileTypes(), 
																				null,
																				null,
																				//( (EObject) p_object ).eResource().getResourceSet() );
																				// Using the object's resource's resource set seems to be causing problems
																				// (cf bug found by BL on Mac). So use a new resource set.
																				new ResourceSetImpl() );
				ResourcesPlugin.getWorkspace().getRoot().accept( resVisitor );

				for ( final Resource res : resVisitor.getFoundEMFResources() ) {
					EMFUtil.fillContentOfTypes( res, supportedTypes, elementsChoice );
				}
			}
			
			elementsChoice.removeAll( currentElements );
			
			return elementsChoice;
		}
		catch ( final CoreException p_ex ) {
			// TODO Check this
			throw new RuntimeException( p_ex );
		}
		catch ( final ResourceAccessException p_ex ) {
			// TODO Check this
			throw new RuntimeException( p_ex );
		}
	}
}
