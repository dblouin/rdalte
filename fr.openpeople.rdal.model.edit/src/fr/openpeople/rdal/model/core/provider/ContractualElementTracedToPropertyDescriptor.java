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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;

import fr.openpeople.rdal.model.core.CorePackage;

public class ContractualElementTracedToPropertyDescriptor extends SettingsRefPropertyDescriptor {

    public ContractualElementTracedToPropertyDescriptor( 	final AdapterFactory p_adapterFactory,
    	      												final ResourceLocator p_resourceLocator,
		    	      										final String p_displayName,
		    	      										final String p_description ) {
    	super( 	p_adapterFactory, 
    			p_resourceLocator, 
    			p_displayName, 
    			p_description,
    			CorePackage.Literals.CONTRACTUAL_ELEMENT__TRACED_TO );
    }
//
//	@Override
//	public AadlProcessingSwitch getSwitch( 	final Collection<PropertyHolder> p_currentElements, 
//											final Collection<PropertyHolder> p_elementsChoice ) {
//		return new PredefResExcludingAadlProcessingSwitch( p_currentElements, p_elementsChoice ) {
//			@Override
//			protected void initSwitches() {
//				coreSwitch = new CoreSwitch() {
//					
//					@Override
//					public Object casePropertyHolder( final PropertyHolder p_element ) {
//						return addElement( p_element );
//					}
//				};
//			}
//		};
//	}
}
