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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.util.RDALModelUtil;

public class ModelElementReferenceModelElementPropertyDescriptor extends SettingsRefPropertyDescriptor {

    public ModelElementReferenceModelElementPropertyDescriptor( final AdapterFactory p_adapterFactory,
			    	      										final ResourceLocator p_resourceLocator,
			    	      										final String p_displayName,
			    	      										final String p_description ) {
    	super( 	p_adapterFactory, 
    			p_resourceLocator, 
    			p_displayName, 
    			p_description,
    			CorePackage.Literals.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT );
    }
    
	@Override
	public Collection<?> getChoiceOfValues( final Object p_object ) {
		return getChoiceOfValues( (Specification) EcoreUtil.getRootContainer( (EObject) p_object ) );
	}
	
	public List<EObject> getChoiceOfValues( final Specification p_specification ) {
		final List<EObject> choiceFilteredList = new ArrayList<EObject>();
		choiceFilteredList.addAll( RDALModelUtil.allowedModelElements( p_specification ) );
		
		return choiceFilteredList;
	}
}
