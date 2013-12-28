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
package fr.openpeople.rdal.ide.view.requirement;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;

import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.RefUserSelectedModelElements;

public class RefModelElementsSelectionDialog extends FeatureEditorDialog {

	public RefModelElementsSelectionDialog( final Shell p_parent,
											final ILabelProvider p_labelProvider,
											final RefUserSelectedModelElements p_refModelElement,
											final List<EObject> p_currentValues,
											final List<EObject> p_refElementsChoice ) {
		super( 	p_parent, 
				p_labelProvider, 
				p_refModelElement, 
				CorePackage.eINSTANCE.getModelElementReference_ModelElement().getEType(),
				p_currentValues,
				"Select Referenced Model Elements",
				p_refElementsChoice,
				true,
				true,
				true );
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public EList<EObject> getResult() {
	    return (EList<EObject>) super.getResult();
	}
}
