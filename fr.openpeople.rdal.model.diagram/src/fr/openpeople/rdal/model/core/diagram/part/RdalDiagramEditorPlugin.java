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
package fr.openpeople.rdal.model.core.diagram.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import fr.openpeople.rdal.model.core.diagram.edit.policies.RdalBaseItemSemanticEditPolicy;
import fr.openpeople.rdal.model.core.diagram.expressions.RdalOCLFactory;
import fr.openpeople.rdal.model.core.diagram.providers.ElementInitializers;
import fr.openpeople.rdal.model.core.provider.CoreItemProviderAdapterFactory;

/**
 * @generated
 */
public class RdalDiagramEditorPlugin extends AbstractUIPlugin {

	private static final String ADDITIONAL_ADAPTER_FACT_EXT_ID = ".additionalAdapterFactories";
	private static final String ADDITIONAL_ADAPTER_FACT_EXT_FACTORY_ELEM = "factory";
	private static final String ADDITIONAL_ADAPTER_FACT_EXT_FACTORY_ELEM_CLASS_ATT = "class";

	/**
	 * @generated
	 */
	public static final String ID = "fr.openpeople.rdal.model.diagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(
			ID);

	/**
	 * @generated
	 */
	private static RdalDiagramEditorPlugin instance;

	/**
	 * @generated
	 */
	private ComposedAdapterFactory adapterFactory;

	/**
	 * @generated
	 */
	private RdalDocumentProvider documentProvider;

	/**
	 * @generated
	 */
	private RdalBaseItemSemanticEditPolicy.LinkConstraints linkConstraints;

	/**
	 * @generated
	 */
	private ElementInitializers initializers;

	/**
	 * @generated
	 */
	private RdalOCLFactory oclFactory;

	/**
	 * @generated
	 */
	public RdalDiagramEditorPlugin() {
	}

	/**
	 * @generated
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT,
				getPreferenceStore());
		logInfo( getBundle().getSymbolicName() + " starting..." );
		adapterFactory = createAdapterFactory();
	}

	/**
	 * @generated
	 */
	public void stop(BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		linkConstraints = null;
		initializers = null;
		oclFactory = null;
		instance = null;
		super.stop(context);
	}

	/**
	 * @generated
	 */
	public static RdalDiagramEditorPlugin getInstance() {
		return instance;
	}

	/**
	 * @generated
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		fillItemProviderFactories(factories);
		return new ComposedAdapterFactory(factories);
	}

	/**
	 * @generated NOT
	 */
	protected void fillItemProviderFactories(
			final List<AdapterFactory> p_factories) {
		p_factories.add(new CoreItemProviderAdapterFactory());
		p_factories.add(new ResourceItemProviderAdapterFactory());

		// DB Add adapter from extension point.
		try {
			p_factories.addAll(getExternalAdapterFactories());
		} catch (final CoreException p_ex) {
			logError( "Unable to add external facories.", p_ex);
		}
		//		factories.add(new ConnectionItemProviderAdapterFactory());
		//		factories.add(new PropertyItemProviderAdapterFactory());
		//		factories.add(new FeatureItemProviderAdapterFactory());
		//		factories.add(new FlowItemProviderAdapterFactory());
		//		factories.add(new ComponentItemProviderAdapterFactory());
		//		factories
		//				.add(new edu.cmu.sei.aadl.model.core.provider.CoreItemProviderAdapterFactory());
		//		factories.add(new InstanceItemProviderAdapterFactory());

		p_factories.add(new ReflectiveItemProviderAdapterFactory());
	}

	private Collection<AdapterFactory> getExternalAdapterFactories()
			throws CoreException {
		final Collection<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		final IExtensionPoint point = Platform.getExtensionRegistry()
				.getExtensionPoint(
						getBundle().getSymbolicName()
								+ ADDITIONAL_ADAPTER_FACT_EXT_ID);

		for (final IExtension extension : point.getExtensions()) {
			final IConfigurationElement[] elements = extension
					.getConfigurationElements();

			for (final IConfigurationElement element : elements) {
				if (ADDITIONAL_ADAPTER_FACT_EXT_FACTORY_ELEM.equals(element
						.getName())) {
					logInfo( "Adding adapter " + element.getAttribute( ADDITIONAL_ADAPTER_FACT_EXT_FACTORY_ELEM_CLASS_ATT ) );
					factories
							.add((AdapterFactory) element
									.createExecutableExtension(ADDITIONAL_ADAPTER_FACT_EXT_FACTORY_ELEM_CLASS_ATT));
				}
			}
		}

		return factories;
	}

	/**
	 * @generated
	 */
	public AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @generated
	 */
	public ImageDescriptor getItemImageDescriptor(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory
				.adapt(item, IItemLabelProvider.class);
		if (labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImageDescriptor(
					labelProvider.getImage(item));
		}
		return null;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @generated
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

	/**
	 * Respects images residing in any plug-in. If path is relative,
	 * then this bundle is looked up for the image, otherwise, for absolute 
	 * path, first segment is taken as id of plug-in with image
	 *
	 * @generated
	 * @param path the path to image, either absolute (with plug-in id as first segment), or relative for bundled images
	 * @return the image descriptor
	 */
	public static ImageDescriptor findImageDescriptor(String path) {
		final IPath p = new Path(path);
		if (p.isAbsolute() && p.segmentCount() > 1) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(p.segment(0), p
					.removeFirstSegments(1).makeAbsolute().toString());
		} else {
			return getBundledImageDescriptor(p.makeAbsolute().toString());
		}
	}

	/**
	 * Returns an image for the image file at the given plug-in relative path.
	 * Client do not need to dispose this image. Images will be disposed automatically.
	 *
	 * @generated
	 * @param path the path
	 * @return image instance
	 */
	public Image getBundledImage(String path) {
		Image image = getImageRegistry().get(path);
		if (image == null) {
			getImageRegistry().put(path, getBundledImageDescriptor(path));
			image = getImageRegistry().get(path);
		}
		return image;
	}

	/**
	 * Returns string from plug-in's resource bundle
	 *
	 * @generated
	 */
	public static String getString(String key) {
		return Platform.getResourceString(getInstance().getBundle(), "%" + key); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public RdalDocumentProvider getDocumentProvider() {
		if (documentProvider == null) {
			documentProvider = new RdalDocumentProvider();
		}
		return documentProvider;
	}

	/**
	 * @generated
	 */
	public RdalBaseItemSemanticEditPolicy.LinkConstraints getLinkConstraints() {
		return linkConstraints;
	}

	/**
	 * @generated
	 */
	public void setLinkConstraints(
			RdalBaseItemSemanticEditPolicy.LinkConstraints lc) {
		this.linkConstraints = lc;
	}

	/**
	 * @generated
	 */
	public ElementInitializers getElementInitializers() {
		return initializers;
	}

	/**
	 * @generated
	 */
	public void setElementInitializers(ElementInitializers i) {
		this.initializers = i;
	}

	/**
	 * @generated
	 */
	public RdalOCLFactory getRdalOCLFactory() {
		return oclFactory;
	}

	/**
	 * @generated
	 */
	public void setRdalOCLFactory(RdalOCLFactory f) {
		this.oclFactory = f;
	}

	/**
	 * @generated
	 */
	public void logError(String error) {
		logError(error, null);
	}

	/**
	 * @generated
	 */
	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.ERROR, RdalDiagramEditorPlugin.ID,
						IStatus.OK, error, throwable));
		debug(error, throwable);
		System.out.println( error );
	}

	/**
	 * @generated
	 */
	public void logInfo(String message) {
		logInfo(message, null);
	}

	/**
	 * @generated
	 */
	public void logInfo(String message, Throwable throwable) {
		if (message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.INFO, RdalDiagramEditorPlugin.ID,
						IStatus.OK, message, throwable));
		debug(message, throwable);
		
		System.out.println( message );
	}

	/**
	 * @generated
	 */
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
}
