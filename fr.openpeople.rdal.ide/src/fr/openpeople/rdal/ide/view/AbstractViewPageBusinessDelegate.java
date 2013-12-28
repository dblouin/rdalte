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

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.core.exception.SystemException;
import fr.labsticc.framework.emf.view.editor.AbstractEditorCommand;
import fr.labsticc.framework.ide.viewpart.IViewPageBusinessDelegate;

public abstract class AbstractViewPageBusinessDelegate implements IViewPageBusinessDelegate {
	
	private static final Logger logger = LoggerFactory.getLogger( AbstractViewPageBusinessDelegate.class );
	
	protected AbstractViewPageBusinessDelegate() {
	}
	
	protected <T> T executeConstraintCommand( final AbstractEditorCommand<T> p_command )
	throws ConstraintException, SystemException, InterruptedException {
		return executeConstraintCommand( p_command, false );
	}
	
	protected <T> T executeConstraintCommand( 	final AbstractEditorCommand<T> p_command,
												final boolean pb_save ) 
	throws ConstraintException, SystemException, InterruptedException {
		Throwable exception = null;
		final EditingDomain editingDomain = p_command.getEditingDomain();
		
		if ( editingDomain == null ) {
			p_command.execute();
		}
		else {
			editingDomain.getCommandStack().execute( p_command );
		}

		exception = p_command.getException();
		
		if ( exception == null ) {
			if ( pb_save ) {
				try {
					save( p_command, editingDomain );
				}
				catch ( final IOException p_ex ) {
					exception = p_ex;
				}
			}
		}

		if ( exception == null ) {
			return p_command.getExecResult();
		}

		if ( exception instanceof SystemException ) {
			throw (SystemException) exception;
		}

		if ( exception instanceof InterruptedException ) {
			throw (InterruptedException) exception;
		}
		
		if ( exception instanceof ConstraintException ) {
			throw (ConstraintException) exception;
		}

		throw new SystemException( exception );
	}
	
	private <T> void save( 	final AbstractEditorCommand<T> p_command,
							final EditingDomain p_editingDomain ) 
	throws IOException {
		final Resource res = p_command.getResource();
		
		if ( res == null ) {
			logger.error( "Resource of object " + p_command.getContext() + " should not be null." );
		}
		else {
			res.save( getSaveOptions() );
			
			if ( p_editingDomain != null && p_editingDomain.getCommandStack() instanceof BasicCommandStack ) {
				( (BasicCommandStack) p_editingDomain.getCommandStack() ).saveIsDone();
			}
		}
	}

	protected <T> T executeCommand( final AbstractEditorCommand<T> p_command,
									final boolean pb_save ) 
	throws SystemException, InterruptedException {
		Throwable exception = null;
		final EditingDomain editingDomain = p_command.getEditingDomain();
		
		if ( editingDomain == null ) {
			p_command.execute();
		}
		else {
			editingDomain.getCommandStack().execute( p_command );
		}

		exception = p_command.getException();
		
		if ( exception == null ) {
			if ( pb_save ) {
				try {
					save( p_command, editingDomain );
				}
				catch ( final IOException p_ex ) {
					exception = p_ex;
				}
			}
		}
		
		if ( exception == null ) {
			return p_command.getExecResult();
		}

		if ( exception instanceof SystemException ) {
			throw (SystemException) exception;
		}

		if ( exception instanceof InterruptedException ) {
			throw (InterruptedException) exception;
		}

		throw new SystemException( exception );
	}
	
	protected Map<?, ?> getSaveOptions() {
		return null;
	}
}
