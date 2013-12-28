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
package fr.openpeople.rdal.ide.view;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.labsticc.framework.ide.viewpart.AbstractCompositeEditorViewPage;

public abstract class AbstractRdalEditorViewPage<T> extends AbstractCompositeEditorViewPage<T> {

	private static final String BASE_IMG_DIR = "icons/";

	public AbstractRdalEditorViewPage( 	final Composite p_parent, 
										final int pi_style,
										final IExceptionHandler p_exceptionHandler ) {
		super( p_parent, pi_style, p_exceptionHandler );
	}
	
	protected Image createImage( final String p_imagePath ) {
		return new Image( 	getDisplay(), 
							Thread.currentThread().getContextClassLoader().getResourceAsStream( BASE_IMG_DIR + p_imagePath ) );
	}
}
