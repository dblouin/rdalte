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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import fr.labsticc.framework.ide.util.PluginUtil;
import fr.openpeople.rdal.ide.view.IEditorHandler;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditor;

public class RdalDiagramEditorHandler implements IEditorHandler {
	
	private final String diagramExtension;
	
	public RdalDiagramEditorHandler() {
		final Collection<String> extensions = PluginUtil.getEditorExtensions( RdalDiagramEditor.class );
		
		if ( extensions != null && !extensions.isEmpty() ) {
			diagramExtension = extensions.iterator().next();
		}
		else {
			diagramExtension = null;
		}
	}

	@Override
	public void openEditor( final EObject p_element )
	throws PartInitException {
 		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
		if ( diagramExtension != null && window != null && window.getActivePage() != null ) {
			final Resource resource = p_element.eResource();
			
			if ( resource != null ) {
				final URI uri = resource.getURI();
				final String uriStr = uri.toPlatformString( true );
				final int indexExt = uriStr.lastIndexOf( uri.fileExtension() );
				final Path path = new Path( uriStr.substring( 0, indexExt ) + diagramExtension );
				final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile( path );
				final RdalDiagramEditor editor = (RdalDiagramEditor) IDE.openEditor( window.getActivePage(), file );
				final IDiagramGraphicalViewer viewer = editor.getDiagramGraphicalViewer(); 
				final List<?> editParts = viewer.findEditPartsForElement( EMFCoreUtil.getProxyID( p_element ), ShapeNodeEditPart.class );
				viewer.setSelection( new StructuredSelection( editParts ) );
			}
		}
	}

	@Override
	public boolean isEditorFor(EObject p_element) {
		return p_element instanceof IdentifiedElement;
	}
}
