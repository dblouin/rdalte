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
package fr.openpeople.rdal.ide.view.traceability.navigator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

import fr.openpeople.rdal.ide.IRDALConstants;

public abstract class AbstractCoverageLister implements ICoverageLister {

	private static final String SELF = "self";
	
	private static final String COVERED_MARKER_ID = "covered";
	private static final String UNCOVERED_MARKER_ID = "uncovered";
	
	private static final String QUALIFIER_PREFIX = "Coverage:";
	private static final String PERCENT = "Percent";
	private static final String TOTAL_NB_LINES = "TotalNbLines";

	private final int offset;
	private final RGB coveredColor;
	private final RGB uncoveredColor;
	
	public AbstractCoverageLister() {
		offset = 2;
		
		coveredColor = markerColor( COVERED_MARKER_ID );
		uncoveredColor = markerColor( UNCOVERED_MARKER_ID );
	}

	private static RGB markerColor( final String p_markerId ) {
		// TODO: Define as preferences
//		final AnnotationPreferenceLookup lookup = EditorsUI.getAnnotationPreferenceLookup();
//		final AnnotationPreference preference = lookup.getAnnotationPreference( p_markerId );
//		
//		return preference.getColorPreferenceValue();
		if ( COVERED_MARKER_ID.equals( p_markerId ) ) {
			return new RGB( 207,255,180 );
		}
		
		return new RGB( 255,155,155 );
	}

	@Override
	public void storeCoverageData( 	EObject p_modelElement,
									Float p_ratio,
									Integer p_base )
	throws CoreException {
		final IResource resource = getElementResource( p_modelElement );
		final String elementName = elementName( p_modelElement );
		
		if ( resource != null && elementName != null ) {
			storeCoverageData( resource, elementName, p_ratio, p_base );
		}
	}
	
	protected abstract String elementName( final EObject p_element );
	
	private void setCoverageRatioProperty( 	final IResource p_resource,
											final String p_elementName,
											final float pf_ratio ) 
	throws CoreException {
		setPersistentProperty( p_resource, p_elementName, PERCENT, pf_ratio );
	}
	
	private void setNbRequirementsProperty( final IResource p_resource,
											final String p_elementName,
											final int pi_nbRequirements ) 
	throws CoreException {
		setPersistentProperty( p_resource, p_elementName, TOTAL_NB_LINES, pi_nbRequirements );
	}
	
	private static void setPersistentProperty( 	final IResource p_resource,
												final String p_qualifier,
												final String p_localName,
												final Number p_propValue ) 
	throws CoreException {
		if ( p_propValue != null ) {
			p_resource.setPersistentProperty( 	createQualifiedName( p_qualifier, p_localName ),
												p_propValue.toString() );
		}
	}
	
	private static QualifiedName createQualifiedName( 	final String p_qualifier,
														final String p_localName ) {
		return new QualifiedName( QUALIFIER_PREFIX + p_qualifier, p_localName );
	}

	protected void storeCoverageData( 	final IResource p_resource,
										final String p_elementName,
										final Float p_ratio,
										final Integer p_base ) 
	throws CoreException {
		if ( p_elementName != null ) {
			setCoverageRatioProperty( p_resource, p_elementName, p_ratio );
			setNbRequirementsProperty( p_resource, p_elementName, p_base );
		}
	}
	
	@Override
	public void storeCoverageData( 	final IResource p_resource,
									final Float p_ratio,
									final Integer p_base ) 
	throws CoreException {
		storeCoverageData( p_resource, SELF, p_ratio, p_base );
	}

	@Override
	public void drawCoverageData(	final Object p_element,
									final Display p_display,
									final GC p_graphics,
									final Rectangle p_place ) 
	throws CoreException {
		final IResource resource;
		final String elementName;

		if ( p_element instanceof IResource ) {
			resource = (IResource) p_element;
			elementName = SELF;
		}
		else {
			final Object unwrappedElement = AdapterFactoryEditingDomain.unwrap( p_element );
			
			if ( unwrappedElement instanceof EObject ) {
				final EObject eObject = (EObject) unwrappedElement;
				resource = getElementResource( eObject );
				elementName = elementName( eObject );
			}
			else {
				resource = null;
				elementName = null;
			}
		}
		
		if ( elementName != null && resource != null && resource.isAccessible() ) {
			drawCoverageData( 	totalNbRequirements( resource, elementName ),
								coverageRatio( resource, elementName ),
								p_display,
								p_graphics,
								p_place );
		}
	}
	
	private void drawCoverageData( 	final Integer p_nbRequirements,
									final Float p_coverageRatio,
									final Display p_display,
									final GC p_graphics,
									final Rectangle p_place ) {
		if ( p_nbRequirements != null && p_coverageRatio != null ) {
			final int nbVerifiedReq = (int) ( p_nbRequirements * p_coverageRatio );

			final String message = String.format( "%6.2f %% [ %3d / %3d ]", p_coverageRatio * IRDALConstants.NORMALIZATION_FACTOR, nbVerifiedReq, p_nbRequirements );
	
			Rectangle rect = new Rectangle( p_place.x,
											p_place.y + 1 + p_graphics.textExtent( message ).y,
											p_place.width,
											p_place.height );
			rect = drawBevelRect( 	p_graphics, 
									rect,
									p_display.getSystemColor( SWT.COLOR_WIDGET_NORMAL_SHADOW ),
									p_display.getSystemColor( SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW ) );
			
			//final int intRatio = p_coverageRatio.intValue();
			Color color = new Color( p_display, coveredColor.red, coveredColor.green, coveredColor.blue );
			drawCoveredRect( 	p_graphics,
								rect,
								p_coverageRatio,
								color );
			color.dispose();
			
			color = new Color( p_display, uncoveredColor.red, uncoveredColor.green, uncoveredColor.blue );
			drawUncoveredRect( 	p_graphics, 
								rect,
								p_coverageRatio,
								color );
			color.dispose();
		
			p_graphics.drawText( message, p_place.x + 1, p_place.y + offset, true );
		}
	}
	
	private Integer totalNbRequirements( 	final IResource p_resource,
											final String p_elementName ) 
	throws CoreException {
		final String totNbLinesStr = getPersistentProperty( p_resource, createQualifiedName( p_elementName, TOTAL_NB_LINES ) );
		
		if ( totNbLinesStr != null ) {
			return Integer.parseInt( totNbLinesStr );
		}
		
		return null;
	}
	
	private String getPersistentProperty( 	final IResource p_resource,
											final QualifiedName p_qualName ) {
		if ( p_resource.isAccessible() ) {
			try {
				return p_resource.getPersistentProperty( p_qualName );
			}
			catch( final CoreException p_ex ) {
			}
		}

		return null;
	}
	
	private Float coverageRatio( 	final IResource p_resource,
									final String p_elementName ) 
	throws CoreException {
		final String coverageRatioStr = getPersistentProperty( p_resource, createQualifiedName( p_elementName, PERCENT ) );
		
		if ( coverageRatioStr != null ) {
			return Float.parseFloat( coverageRatioStr );
		}
		
		return null;
	}
	
	protected abstract IResource getElementResource( final EObject p_element );
	
	private Rectangle drawBevelRect(	final GC p_graphics, 
										final Rectangle p_rectangle, 
										final Color p_normalShadow,
										final Color p_highlightShadow ) {
		final Color foregroundMemo = p_graphics.getForeground();
		
		final Rectangle insideRect = new Rectangle( p_rectangle.x + 1,
													p_rectangle.y + 1,
													p_rectangle.width - 2,
													p_rectangle.height - 2 );
		p_graphics.setForeground( p_normalShadow );
		p_graphics.drawLine(	p_rectangle.x, 
								p_rectangle.y, 
								p_rectangle.x + p_rectangle.width - 1,
								p_rectangle.y );
		p_graphics.drawLine(	p_rectangle.x,
								p_rectangle.y,
								p_rectangle.x,
								p_rectangle.y + p_rectangle.height - 1 );
		
		p_graphics.setForeground( p_highlightShadow );
		p_graphics.drawLine(	p_rectangle.x + p_rectangle.width,
								p_rectangle.y,
								p_rectangle.x + p_rectangle.width,
								p_rectangle.y + p_rectangle.height );
		p_graphics.drawLine(	p_rectangle.x, 
								p_rectangle.y + p_rectangle.height, 
								p_rectangle.x + p_rectangle.width, 
								p_rectangle.y + p_rectangle.height );
		
		p_graphics.setForeground( foregroundMemo );
		
		return insideRect;
	}

	private void drawUncoveredRect(	final GC p_graphics,
									final Rectangle p_area, 
									final float p_coverage,
									final Color p_color ) {
		final Color bgColor = p_graphics.getBackground();
		
		p_graphics.setBackground( p_color );
		final int width = (int) (p_area.width * p_coverage);
		p_graphics.fillRectangle( p_area.x + width, p_area.y, p_area.width - width, p_area.height );
		
		p_graphics.setBackground( bgColor );
	}
	
	private void drawCoveredRect(	final GC p_graphics, 
									final Rectangle p_rectangle, 
									final float p_coverage, 
									final Color p_color ) {
		final Color bgColor = p_graphics.getBackground();
		p_graphics.setBackground( p_color );
		final int width = (int) (p_rectangle.width * p_coverage);
		p_graphics.fillRectangle( p_rectangle.x, p_rectangle.y, width, p_rectangle.height );
		p_graphics.setBackground( bgColor );
	}

	@Override
	public void deleteCoverageData( final IResource p_resource )
	throws CoreException {
		p_resource.accept( new IResourceVisitor() {
			
			@Override
			public boolean visit( final IResource p_resource )
			throws CoreException {
				if ( p_resource.isAccessible() ) {
					try {
						for ( final Object key : p_resource.getPersistentProperties().keySet() ) {
							if ( key instanceof QualifiedName ) {
								final QualifiedName qualName = (QualifiedName) key;
		
								if ( qualName.getQualifier().startsWith( QUALIFIER_PREFIX ) ) {
									p_resource.setPersistentProperty( qualName, null );
								}
							}
						}
					}
					catch( final CoreException p_ex ) {
						// Thrown for some reason on resources created by OSATE analyses saying the resource is not local.
					}
				}

				return true;
			}
		} );
	}
}
