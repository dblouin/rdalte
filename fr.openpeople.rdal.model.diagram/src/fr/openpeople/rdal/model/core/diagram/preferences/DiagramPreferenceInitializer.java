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
package fr.openpeople.rdal.model.core.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated NOT
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		DiagramGeneralPreferencePage.initDefaults(store);
		DiagramAppearancePreferencePage.initDefaults(store);
		DiagramConnectionsPreferencePage.initDefaults(store);
		DiagramPrintingPreferencePage.initDefaults(store);
		DiagramRulersAndGridPreferencePage.initDefaults(store);

		// TODO: Remove this after library management is fixed.
		RdalDiagramEditorPlugin
				.getInstance()
				.getPreferenceStore()
				.setDefault(
						IRdalPreferenceConstants.DEFAULT_LIBRARIES_LOCATION,
						IRdalPreferenceConstants.DEFAULT_LIBRARIES_LOCATION_VALUE);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return RdalDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
