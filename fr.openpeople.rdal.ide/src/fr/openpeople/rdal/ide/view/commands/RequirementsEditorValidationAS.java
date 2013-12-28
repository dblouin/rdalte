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
package fr.openpeople.rdal.ide.view.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil;

import fr.labsticc.framework.constraints.core.exception.ConstraintValidationException;
import fr.labsticc.framework.constraints.service.EMFConstraintValidationAS;
import fr.labsticc.framework.core.exception.SystemException;

public class RequirementsEditorValidationAS extends EMFConstraintValidationAS {
	private final EclipseResourcesUtil eclipseResourcesUtil;
	
	public RequirementsEditorValidationAS() {
		super();
		
		eclipseResourcesUtil = EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE ? new EclipseResourcesUtil() : null;
	}
	
	@Override
	public void validate( final EObject... p_objects ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		deleteMarkers( p_objects );
		
		try {
			super.validate( p_objects );
		}
		catch ( final ConstraintValidationException p_ex ) {
			handleValidationException( p_ex );
		}
	}

	@Override
	public void validate( 	final int pi_featureId,
							final boolean pb_validateFeatureValue,
							final EObject... p_objects )
	throws ConstraintValidationException, SystemException, InterruptedException {
		deleteMarkers( p_objects );
		
		try {
			super.validate( pi_featureId, pb_validateFeatureValue, p_objects );
		}
		catch ( final ConstraintValidationException p_ex ) {
			handleValidationException( p_ex );
		}
	}
	
	private void deleteMarkers( final EObject... p_objects ) {
		for ( final EObject object : p_objects ) {
			eclipseResourcesUtil.deleteMarkers( object );
		}
	}
	
	private void handleValidationException( final ConstraintValidationException p_ex ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		if ( p_ex.getDiagnostic() instanceof Diagnostic ) {
			final Diagnostic diag = (Diagnostic) p_ex.getDiagnostic();
			
			switch ( diag.getSeverity() ) {
				case Diagnostic.CANCEL:
					throw new InterruptedException( diag.getMessage() );

				default:
					try {
						eclipseResourcesUtil.createMarkers( diag );
					}
					catch ( final CoreException p_coreEx ) {
						throw new SystemException( p_ex );
					}
			}
			
			if ( diag.getSeverity() == Diagnostic.ERROR ) {
				throw p_ex;
			}
		}
	}
}
