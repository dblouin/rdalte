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

import java.util.Collection;

import javax.activation.UnsupportedDataTypeException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import fr.labsticc.framework.core.IResourceHandler;
import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.emf.core.resource.BundleEMFResourceHandler;
import fr.openpeople.rdal.ide.RdalIdePlugin;

/**
 * TODO: Move this to FW
 * @author dblouin
 *
 */
public class EditorUtil {

	private static final IResourceHandler resourceHandler = new BundleEMFResourceHandler();

	public static void openEditor( EObject p_element ) 
	throws PartInitException, UnsupportedDataTypeException {
		for ( final IEditorHandler handler : RdalIdePlugin.getDefault().getEditorHandlers() ) {
			if ( handler.isEditorFor( p_element ) ) {
				handler.openEditor( p_element );
			}
		}
// 		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//		
//		if ( window != null && window.getActivePage() != null ) {
//			final Resource resource = p_element.eResource();
//			
//			if ( resource != null ) {
//				final URI uri = resource.getURI();
//				final String uriStr = uri.toPlatformString( true );
//				
//				if ( p_element instanceof AObject ) {
//					final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile( new Path( uriStr ) );
//					final CoreEditor editor = (CoreEditor) IDE.openEditor( window.getActivePage(), file );
//					editor.gotoAObject( (AObject) p_element );
//				}
//				else if ( p_element instanceof IdentifiedElement ) {
//				}
//				else {
//					throw new UnsupportedDataTypeException(); 
//				}
//			}
//		}
	}

	public static void openEditors( final Collection<String> p_fileIds ) 
	throws PartInitException, ResourceAccessException {
		for ( final String fileId : p_fileIds) {
			openEditor( fileId );
		}
	}

	public static void openEditor( final String p_fileId ) 
	throws PartInitException, ResourceAccessException {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
		if ( window != null && window.getActivePage() != null ) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation( new Path( p_fileId ) );
			
			if ( file == null ) {
				// The file may be outside the workspace
				IFileStore fileStore = EFS.getLocalFileSystem().getStore( new Path( p_fileId ) );
				
				if ( !fileStore.fetchInfo().exists() ) {
					final String location = resourceHandler.locateResource( p_fileId );
					
					if ( location == null ) {
						throw new PartInitException( "Unable to find file " + p_fileId );
					}
					
					fileStore = EFS.getLocalFileSystem().getStore( new Path( location ) );

					if ( !fileStore.fetchInfo().exists() ) {
						throw new PartInitException( "Unable to find file " + p_fileId );
					}
				}

				IDE.openEditorOnFileStore( window.getActivePage(), fileStore );
			}
			else {
				IDE.openEditor( window.getActivePage(), file );
			}
		}
	}
}
