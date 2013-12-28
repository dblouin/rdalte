package fr.openpeople.ide.settings;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.NamedElement;
import org.osate.workspace.WorkspacePlugin;
import org.osate.xtext.aadl2.ui.contentassist.Aadl2ProposalProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.labsticc.framework.emf.core.resource.IEMFResourceHandler;
import fr.labsticc.framework.emf.core.util.EMFUtil;
import fr.labsticc.framework.emf.view.EmfFwIdePlugin;
import fr.labsticc.framework.settings.modelinterface.osate.AbstractAadlModelInterface;

/**
 * This is a default model interface for AADL for applications integrated with the IDE. 
 * It does not know how to set the property values in an AADL model.
 * 
 * @author dblouin
 */
public class BasicIdeAadlModelInterface extends AbstractAadlModelInterface /*implements IResourceChangeListener*/ {

	private final Logger logger;

	private final EObjectAtOffsetHelper eObjectOffsetHelper;

	private static final String AADL_EXT = WorkspacePlugin.SOURCE_FILE_EXT;
	private static final String AAXL_EXT = WorkspacePlugin.MODEL_FILE_EXT;
	
	private final OSATEResourceHandler osateResHandler;
	
	public BasicIdeAadlModelInterface() {
		super( new String[] { AADL_EXT, AAXL_EXT } );
		
		final OSATEResourceHandler foundHandler = findOsateResourceHandler();
		
		if ( foundHandler == null ) {
			osateResHandler = new OSATEResourceHandler();
		}
		else {
			osateResHandler = foundHandler;
		}
		
		logger = LoggerFactory.getLogger( getClass() );
		
		// Ensure the xtext resource set is created before it is needed by this model interface. This is important when a
		// workspace is opened with a RDAL model file open and shown as default. The xtext resource set is only created when
		// needed (when an AADL file is opened for example). Instantiating this class will force starting the
		// org.osate.xtext.aadl2.ui plugin that will then create the resource set. Using the MyAadl2Activator class instead of
		// the Aadl2ProposalProvider class would make more sens but it is not exported by the plugin. Any class will start
		// the plugin anyway.
		@SuppressWarnings("unused")
		final Object dummyObject = Aadl2ProposalProvider.class;

		eObjectOffsetHelper = new EObjectAtOffsetHelper();
		
		//try {
			// Ticket #239. No need to load all AADL resources anymore since we are not using allInstances to get the properties and units
			// in OCL.
			//loadAllAADLResources();
		//ResourcesPlugin.getWorkspace().addResourceChangeListener( this, IResourceChangeEvent.POST_CHANGE );
//		}
//		catch( final CoreException p_ex ) {
//			throw new IllegalStateException( p_ex );
//		}
//		catch( final ResourceAccessException p_ex ) {
//			throw new IllegalStateException( p_ex );
//		}
	}
	
	private OSATEResourceHandler findOsateResourceHandler() {
		for ( final IEMFResourceHandler resHandler : EmfFwIdePlugin.getDefault().getResourceHandlers() ) {
			if ( resHandler instanceof OSATEResourceHandler ) {
				return (OSATEResourceHandler) resHandler;
			}
		}
		
		return null;
	}
	
	/**
	 * Ensure that all AADL resources are loaded into the AADL resource set. This is needed because we need OCL allInstances
	 * query to see all elements in the workspace.
	 * @throws CoreException
	 */
//	private void loadAllAADLResources()
//	throws CoreException, ResourceAccessException {
//		final EMFResourcesVisitor visitor = new EMFResourcesVisitor( 	aadlExtensions, 
//																		getProjectNatures(), 
//																		null, 
//																		getCustomResourcet() );
//		ResourcesPlugin.getWorkspace().getRoot().accept( visitor );
//		
//		// Triggers load of the resources in the resource set.
//		visitor.getFoundEMFResources();
//	}

	public Set<String> getProjectNatures() {
		// DB: No use to thes the AADL nature to consider the files. Doing this may lead to problems in OSATE2 as the AADL
		// projects do not always have the AADL nature by default such as the Plugin_Resources project.
		return null; // Collections.singleton( AadlNature.ID );
	}
//	
//	@Override
//	public void finalize() 
//	throws Throwable {
//		ResourcesPlugin.getWorkspace().removeResourceChangeListener( this );
//		
//		super.finalize();
//	}

	// Moved to OSATE Resource Handler
	/* Ticket #209: This is needed finally to update the resources in the OSATE resource set so that changes made by other editors
	 * with other resource sets are seen.
	 *  (non-Javadoc)
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
//	@Override
//	public void resourceChanged( final IResourceChangeEvent p_event ) {
//		//if ( getCustomResourcet() != null ) {
//			processDelta( p_event.getDelta() );
//		//}
//	}
//
//	private void processDelta( final IResourceDelta p_delta ) {
//		final IResourceDelta[] children = p_delta.getAffectedChildren();
//
//		try {
//			processChanged( p_delta );
//		}
//		catch ( final WrappedException e ) {
//			logger.error( toString(), e );
//		}
//
//		for ( final IResourceDelta childDelta : children ) {
//			processDelta( childDelta );
//		}
//	}
//
//	private void processChanged( final IResourceDelta p_delta ) {
//		//final ResourceSet resourceSet = getCustomResourcet();
//		
//		if ( ( p_delta.getKind() & IResourceDelta.REMOVED ) != 0 ) {
//			final IResource deleted = p_delta.getResource();
//
//			// DB: Added a test on the resource type to only handle EMF resources
//			if ( shouldProcessChange( deleted ) ) {
//				final URI uri = URI.createPlatformResourceURI( deleted.getFullPath().toString(), false );
//				//final Resource resource = resourceSet.getResource( uri, false );
//
//				//if ( resource != null ) {
//					deletedResources.add( uri );
////					resource.unload();
////					resourceSet.getResources().remove( resource );
//				//}
//			}
//		} 
////		else if ( ( p_delta.getKind() & IResourceDelta.ADDED ) != 0 ) {
////			final IResource added = p_delta.getResource();
////			
////			// DB: Added a test on the resource type to only handle EMF resources
////			if ( shouldProcessChange( added ) ) {
////				final URI uri = URI.createPlatformResourceURI( added.getFullPath().toString(), false );
////				
////				// Need to load the new resource so that its elements are visible in OCL
////				resourceSet.getResource( uri, true );
////			}
////		}
//		else if ( ( p_delta.getKind() & IResourceDelta.CHANGED ) != 0 &&
//				( p_delta.getFlags() & IResourceDelta.CONTENT ) != 0 ) {
//			final IResource changed = p_delta.getResource();
//
//			// DB: Added a test on the resource type to only handle EMF resources
//			if ( shouldProcessChange( changed ) ) {
//				final URI uri = URI.createPlatformResourceURI( changed.getFullPath().toString(), false );
//				//final Resource resource = resourceSet.getResource( uri, false );
//
//				//if ( resource != null && resource.isLoaded() ) {
//					changedResources.add( uri );
////					resource.unload();
////
////					try {
////						resource.load( Collections.EMPTY_MAP );
////					}
////					catch ( final IOException p_exception ) {
////						logger.error( toString(), p_exception );
////					}
//				//}
//			}
//		}
//	}
//	
//	private boolean shouldProcessChange( final IResource p_resource ) {
//		return p_resource instanceof IFile && /*!isModelResourceExtension( p_resource.getFileExtension() ) &&*/ EMFUtil.isEMFResource( p_resource ); 
//	}

	@Override
	public void setPropertyValue(Object p_component, Object p_property,
			Object p_value, Object p_unit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object selectedModelObject(	final Object p_editor,
										final Object p_selection ) {
    	final NamedElement selPropHolder = EMFUtil.selectedObject( (ISelection) p_selection, NamedElement.class );
    	
    	if ( isComponent( selPropHolder ) ) {
    		return selPropHolder;
    	}

		if ( p_selection instanceof TextSelection && p_editor instanceof XtextEditor ) {
			final ITextSelection selection = (ITextSelection) p_selection;
			final XtextEditor editor = (XtextEditor) p_editor;
			
			try {
				final XtextResource resource = (XtextResource) EMFUtil.convertToEMFResource( editor.getResource(), getCustomResourcet() );
				
				return eObjectOffsetHelper.resolveElementAt( resource, selection.getOffset() );
			}
			catch ( final CoreException p_ex ) {
				// TODO
			}
		}
		
		return null;
	}

	@Override
	public ResourceSet getCustomResourcet() {
		return osateResHandler.getResourceSet();
	}
}
