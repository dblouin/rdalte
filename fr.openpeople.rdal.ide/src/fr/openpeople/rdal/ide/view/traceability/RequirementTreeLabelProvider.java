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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import fr.labsticc.framework.ide.viewpart.TreeCellLabelProvider;
import fr.labsticc.framework.settings.model.settings.Category;
import fr.openpeople.rdal.ide.IRDALConstants;
import fr.openpeople.rdal.model.core.EnumRiskKind;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.Requirement;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorPlugin;

public class RequirementTreeLabelProvider extends TreeCellLabelProvider {

	private static final AdapterFactory defaultAdapterFactory = RdalDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory();
	private static final ExtendedImageRegistry imageRegistry = ExtendedImageRegistry.getInstance(); 
	
	private final ILabelProvider labelProvider = new LabelProvider() {

		@Override
		public String getText( final Object p_object ) {
			if ( p_object == null ) {
				return null;
			}
			
			if ( p_object instanceof ModelElementReference ) {
				return getText( ( (ModelElementReference) p_object ).getModelElement() );
			}
			
			final IItemLabelProvider lblProvider = itemLabelProvider( p_object );
			
			return lblProvider == null ? String.valueOf( p_object ) : lblProvider.getText( p_object );
		}

		@Override
		public Image getImage( final Object p_object ) {
			if ( p_object == null ) {
				return null;
			}

			if ( p_object instanceof ModelElementReference ) {
				return getImage( ( (ModelElementReference) p_object ).getModelElement() );
			}

			final IItemLabelProvider lblProvider = itemLabelProvider( p_object );
			
			return lblProvider == null ? null : imageRegistry.getImage( lblProvider.getImage( p_object ) );
		}
		
		private IItemLabelProvider itemLabelProvider( final Object p_object ) {
			return (IItemLabelProvider) defaultAdapterFactory.adapt( p_object, IItemLabelProvider.class );
		}
	};
	
	private final Image imgVerifOk;
	private final Image imgVerifUnknown;
	private final Image imgVerifError;
	
	private final Image imgRiskLow;
	private final Image imgRiskMedium;
	private final Image imgRiskHigh;
	
	public RequirementTreeLabelProvider( 	final Image p_imgVerifOk,
											final Image p_imgVerifUnknown,
											final Image p_imgVerifError,
											final Image p_imgRiskLow,
											final Image p_imgRiskMedium,
											final Image p_imgRiskHigh ) {
		imgVerifOk = p_imgVerifOk;
		imgVerifUnknown = p_imgVerifUnknown;
		imgVerifError = p_imgVerifError;

		imgRiskLow = p_imgRiskLow;
		imgRiskMedium = p_imgRiskMedium;
		imgRiskHigh = p_imgRiskHigh;
	}
	
	@Override
	protected Image getColumnImage(	final Object p_element,
									final int pi_columnIndex ) {
		switch ( pi_columnIndex ) {
			case 0:
				return labelProvider.getImage( p_element );
			case 1:
	        	if ( p_element instanceof ModelElementReference ) {
	        		return verifiedImage( ( (ModelElementReference) p_element ).getVerifies() );
	        	}
	        	else if ( p_element instanceof Requirement ) {
	        		return verifiedImage( ( (Requirement) p_element ).getVerified() ); 
	        	}
	        	else if ( p_element instanceof RequirementsGroup ) {
	        		return verifiedImage( ( (RequirementsGroup) p_element ).getVerified() ); 
	        	}
	        	else if ( p_element instanceof Specification ) {
	        		return verifiedImage( ( (Specification) p_element ).getVerified() ); 
	        	}
	        		
	        	return null;

			case 3:
	        	if ( p_element instanceof Requirement ) {
	        		final EnumRiskKind riskKind =  ( (Requirement) p_element ).getRisk();
	        		
	        		switch ( riskKind ) {
	        			case LOW:
	        				return imgRiskLow;
						case MEDIUM:
							return imgRiskMedium;
						case HIGH:
							return imgRiskHigh;
					}
	        	}
		}
		
		return null;
	}
	
	private Image verifiedImage( final Boolean verified ) {
    	if ( verified == null ) {
    		return imgVerifUnknown;
    	}
    		
    	return verified ? imgVerifOk : imgVerifError;
	}

	@Override
	protected String getColumnText(	final Object p_element, 
									final int pi_columnIndex ) {
    	if ( p_element instanceof IdentifiedElement ) {
    		final IdentifiedElement idElement = (IdentifiedElement) p_element;

			switch ( pi_columnIndex ){
		        case 0: 
		        	return labelProvider.getText( p_element );
		        case 1:
		        	// Only show an icon for verified field
		        	return null;
		        case 2:
		        	final Float value;
		        	
		        	if ( p_element instanceof Requirement ) {
		        		value = ( (Requirement) p_element ).getSatisfactionLevel();
		        	}
		        	else if ( p_element instanceof RequirementsGroup ) {
		        		value = ( (RequirementsGroup) p_element ).getSatisfactionLevel();
		        	}
		        	else if ( p_element instanceof Specification ) {
		        		value = ( (Specification) p_element ).getSatisfactionLevel();
		        	}
		        	else {
		        		value = null;
		        	}
	        		
		        	final Float normalizedValue;
		        	
		        	if ( value == null ) {
		        		normalizedValue = null;
		        	}
		        	else {
		        		normalizedValue = value * IRDALConstants.NORMALIZATION_FACTOR;
		        	}
	        		
		        	return labelProvider.getText( normalizedValue );
		        case 3: 
		        	return null;
		        case 4: 
		        	if ( p_element instanceof Requirement ) {
		        		final Category reqType =  ( (Requirement) p_element ).getCategory();
		        		
			        	return labelProvider.getText( reqType );
		        	}
		        	
		        	return null;
		        case 5: 
		        	return idElement.getDescription();
			}
    	}

		return String.valueOf( p_element );
	}

	@Override
	public void dispose() {
		if ( imgVerifOk != null ) {
			imgVerifOk.dispose();
		}
		
		if ( imgVerifUnknown != null ) {
			imgVerifUnknown.dispose();
		}
		
		if ( imgVerifError != null ) {
			imgVerifError.dispose();
		}
		
		if ( imgRiskLow != null ) {
			imgRiskLow.dispose();
		}
		
		if ( imgRiskMedium != null ) {
			imgRiskMedium.dispose();
		}
		
		if ( imgRiskHigh != null ) {
			imgRiskHigh.dispose();
		}
	}

	@Override
	public String getToolTipText(Object element) {
	 	return "Double-click element to open it.";
	}
//
//	@Override
//	public void update( final ViewerCell p_cell ) {
//		p_cell.setText( getColumnText( p_cell.getElement(), p_cell.getColumnIndex() ) );
//		p_cell.setImage( getColumnImage( p_cell.getElement(), p_cell.getColumnIndex() ) );
//	}
}
