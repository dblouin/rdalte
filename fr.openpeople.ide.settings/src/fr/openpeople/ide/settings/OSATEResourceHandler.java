package fr.openpeople.ide.settings;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.workspace.WorkspacePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.emf.core.resource.IEMFResourceHandler;
import fr.labsticc.framework.emf.core.util.EMFUtil;

public class OSATEResourceHandler implements IEMFResourceHandler, IResourceChangeListener {
	
	protected Set<String> aadlExtensions;
	
	private Set<URI> changedResources;
	private Set<URI> deletedResources;
	private final Logger logger;
	
	private final boolean listeningForChanges;
	
	public OSATEResourceHandler() {
		logger = LoggerFactory.getLogger( getClass() );
		aadlExtensions = new HashSet<String>();
		aadlExtensions.add( WorkspacePlugin.SOURCE_FILE_EXT );
		aadlExtensions.add( WorkspacePlugin.MODEL_FILE_EXT );
		
		changedResources = new HashSet<URI>();
		deletedResources = new HashSet<URI>();
		ResourcesPlugin.getWorkspace().addResourceChangeListener( this, IResourceChangeEvent.POST_CHANGE );
		listeningForChanges = true;
	}
	
	@Override
	public void finalize() 
	throws Throwable {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener( this );
		
		super.finalize();
	}
	
	/* Ticket #209: This is needed finally to update the resources in the OSATE resource set so that changes made by other editors
	 * with other resource sets are seen.
	 *  (non-Javadoc)
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	@Override
	public void resourceChanged( final IResourceChangeEvent p_event ) {
		processDelta( p_event.getDelta() );
		refreshResources();
	}

	private void processDelta( final IResourceDelta p_delta ) {
		final IResourceDelta[] children = p_delta.getAffectedChildren();

		try {
			processChanged( p_delta );
		}
		catch ( final WrappedException e ) {
			logger.error( toString(), e );
		}

		for ( final IResourceDelta childDelta : children ) {
			processDelta( childDelta );
		}
	}

	private void processChanged( final IResourceDelta p_delta ) {
		//final ResourceSet resourceSet = getCustomResourcet();
		
		if ( ( p_delta.getKind() & IResourceDelta.REMOVED ) != 0 ) {
			final IResource deleted = p_delta.getResource();

			// DB: Added a test on the resource type to only handle EMF resources
			if ( shouldProcessChange( deleted ) ) {
				final URI uri = URI.createPlatformResourceURI( deleted.getFullPath().toString(), false );
				//final Resource resource = resourceSet.getResource( uri, false );

				//if ( resource != null ) {
					deletedResources.add( uri );
//					resource.unload();
//					resourceSet.getResources().remove( resource );
				//}
			}
		} 
//		else if ( ( p_delta.getKind() & IResourceDelta.ADDED ) != 0 ) {
//			final IResource added = p_delta.getResource();
//			
//			// DB: Added a test on the resource type to only handle EMF resources
//			if ( shouldProcessChange( added ) ) {
//				final URI uri = URI.createPlatformResourceURI( added.getFullPath().toString(), false );
//				
//				// Need to load the new resource so that its elements are visible in OCL
//				resourceSet.getResource( uri, true );
//			}
//		}
		else if ( ( p_delta.getKind() & IResourceDelta.CHANGED ) != 0 &&
				( p_delta.getFlags() & IResourceDelta.CONTENT ) != 0 ) {
			final IResource changed = p_delta.getResource();

			// DB: Added a test on the resource type to only handle EMF resources
			if ( shouldProcessChange( changed ) ) {
				final URI uri = URI.createPlatformResourceURI( changed.getFullPath().toString(), false );
				//final Resource resource = resourceSet.getResource( uri, false );

				//if ( resource != null && resource.isLoaded() ) {
					changedResources.add( uri );
//					resource.unload();
//
//					try {
//						resource.load( Collections.EMPTY_MAP );
//					}
//					catch ( final IOException p_exception ) {
//						logger.error( toString(), p_exception );
//					}
				//}
			}
		}
	}
	
	private boolean shouldProcessChange( final IResource p_resource ) {
		return p_resource instanceof IFile && !isModelResourceExtension( p_resource.getFileExtension() ) && EMFUtil.isEMFResource( p_resource ); 
	}
	
	protected boolean isModelResourceExtension( final String p_ext ) {
		return p_ext == null ? false : aadlExtensions.contains( p_ext );
	}

	@Override
	public boolean handlesResource( final IResource p_resource ) {
		return aadlExtensions.contains( p_resource.getFileExtension() );
	}

	@Override
	public Resource loadResource( final IResource p_resource )
	throws ResourceAccessException {
		
		return getResourceSet().getResource( OsateResourceUtil.getResourceURI( p_resource ), true );
	}
	
	private void refreshResources() {
		if ( listeningForChanges ) {
			final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
			
			for ( final URI resourceUri : deletedResources ) {
				final Resource resource = resourceSet.getResource( resourceUri, false );
				
				if ( resource != null && resource.isLoaded() ) {
					resource.unload();
					resourceSet.getResources().remove( resource );
				}
			}
			
			deletedResources.clear();
			
			for ( final URI resourceUri : changedResources ) {
				final Resource resource = resourceSet.getResource( resourceUri, false );
	
				if ( resource != null && resource.isLoaded() ) {
					logger.info( "Refreshing resource " + resource.getURI() );
					resource.unload();
				
					try {
						resource.load( Collections.EMPTY_MAP );
					}
					catch ( final IOException p_exception ) {
						logger.error( toString(), p_exception );
					}
				}
			}
			
			changedResources.clear();
		}
	}

	public ResourceSet getResourceSet() {
		return OsateResourceUtil.getResourceSet();
	}
}
