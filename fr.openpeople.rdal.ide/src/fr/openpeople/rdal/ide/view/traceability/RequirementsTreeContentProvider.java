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
package fr.openpeople.rdal.ide.view.traceability;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.labsticc.framework.core.exception.SystemException;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.service.IRequirementsTraceabilityBusinessDelegate;

public class RequirementsTreeContentProvider implements ITreeContentProvider {
	
	private static final Logger logger = LoggerFactory.getLogger( RequirementsTreeContentProvider.class );

	private final IRequirementsTraceabilityBusinessDelegate businessDelegate;
	
	private final IExceptionHandler exceptionHandler;

	private List<IdentifiedElement> dataElements;

	private EObject designElement;
	
	private Class<? extends IdentifiedElement> rootElementType;
	
	private boolean recursive;
	
	private boolean flatLayout;
	
	public RequirementsTreeContentProvider( final IRequirementsTraceabilityBusinessDelegate p_businessDelegate,
											final Class<? extends IdentifiedElement> p_initialRootElementType,
											final boolean pb_flatLayout,
											final IExceptionHandler p_exceptionHandler ) {
		businessDelegate = p_businessDelegate;
		exceptionHandler = p_exceptionHandler;
		dataElements = new ArrayList<IdentifiedElement>();
		recursive = true;
		flatLayout =  pb_flatLayout;
		rootElementType = p_initialRootElementType;
	}
	
	@Override
	public Object[] getChildren( final Object p_parentElement ) {
		try {
			return getChildrenElements( p_parentElement ).toArray();
		}
		catch ( final Throwable p_th ) {
			exceptionHandler.handleException( p_th, p_parentElement );
			
			return null;
		}
	}

	private Collection<?> getChildrenElements( final Object p_parentElement )
	throws ConstraintException, SystemException, InterruptedException {
		if ( p_parentElement instanceof Collection<?> ) {
            return (Collection<?>) p_parentElement;
		}
		
		if ( !flatLayout && p_parentElement instanceof IdentifiedElement ) {
			return businessDelegate.satisfiableNodes( designElement, (IdentifiedElement) p_parentElement, recursive );
		}
		
		return Collections.emptyList();
	}

	@Override
	public Object getParent( final Object p_element ) {
		if ( p_element instanceof EObject ) {
			return ( (EObject) p_element ).eContainer();
		}

		return null;
	}

	@Override
	public boolean hasChildren( final Object p_parentElement ) {
		try {
			return !getChildrenElements( p_parentElement ).isEmpty();
		}
		catch ( final Throwable p_th ) {
			exceptionHandler.handleException( p_th, p_parentElement );
			
			return false;
		}
	}

	@Override
	public Object[] getElements( final Object p_inputElement ) {
        return getChildren( p_inputElement );
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged( 	final Viewer p_viewer, 
								final Object p_oldInput, 
								final Object p_newInput ) {
	}
	
	public void setDesignElement( final EObject p_designElement ) {
		designElement = p_designElement;
		update();
	}
	
	private void update() {
		logger.debug( "Updating tree content..." );
		dataElements.clear();

		try {
			dataElements.addAll( businessDelegate.satisfiableNodes( designElement, 
																	rootElementType,
																	recursive ) );
		}
		catch ( final Throwable p_th ) {
			exceptionHandler.handleException( p_th, designElement );
		}
	}
	
	public void setRootElementType( final Class<? extends IdentifiedElement> p_rootElementType ) {
		rootElementType = p_rootElementType;
		
		update();
	}
	
	public Class<? extends IdentifiedElement> getRootElementType() {
		return rootElementType;
	}
	
	public List<IdentifiedElement> getDataElements() {
		return dataElements;
	}

	public void setFlatLayout( final boolean pb_flat ) {
		flatLayout = pb_flat;
	}
}
