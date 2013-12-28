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
package fr.openpeople.rdal.ide.view.specification;

import org.eclipse.swt.widgets.Composite;

import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.openpeople.rdal.ide.view.AbstractRdalEditorViewPage;
import fr.openpeople.rdal.model.core.Specification;

public class SpecificationViewPage extends AbstractRdalEditorViewPage<Specification> {
	
//	private TableViewer tblElements;
//	private List<EObject> dataElements;
//	private ToolBar tbrActions;
//	private ToolItem tbiSelectElements;
//	private ToolItem tbiOpenElements;
//	
//	private final ILabelProvider labelProvider = new LabelProvider() {
//
//		@Override
//		public String getText( final Object p_object ) {
//			return businessDelegate.getText( p_object );
//		}
//
//		@Override
//		public Image getImage( final Object p_object ) {
//			return (Image) businessDelegate.getImage( p_object );
//		}
//	};
//	
//	private ConstraintLibraryPanel pnlConstraintLibrary;
//	
//	private final ISpecificationBusinessDelegate businessDelegate;
//	private final IExceptionHandler exceptionHandler;
//	
	public SpecificationViewPage(	final Composite p_parent, 
									final int pi_style,
									//final ISpecificationBusinessDelegate p_businessDelegate,
									final IExceptionHandler p_exceptionHandler ) {
		super( p_parent, pi_style, p_exceptionHandler );
//		
//		businessDelegate = p_businessDelegate;
//		exceptionHandler = p_exceptionHandler;
//		dataElements = new ArrayList<EObject>();
//		
//		createControls();
	}
//
//	private void createControls() {
//		setLayout( new FillLayout() );
//		final SashForm sashForm = new SashForm( this, SWT.VERTICAL | SWT.LEFT_TO_RIGHT );
//		sashForm.setLayout( new GridLayout() );
//		
//		createElementsTable( sashForm );
//		createLibraryPanel( sashForm );
//
//		sashForm.setWeights( new int[] { 1, 2 } );
//	}
//	
//	private void createElementsTable( final Composite p_parent ) {
//		final Composite pnlElements = new Composite( p_parent, SWT.NULL );
//		pnlElements.setLayout( new GridLayout() );
//		
//		tbrActions = new ToolBar( pnlElements, SWT.FLAT | SWT.WRAP | SWT.RIGHT );
//		
//		tbiOpenElements = createToolBarItem( 	"/icons/openElements.gif", 
//												"Open referenced element(s)",
//												SWT.PUSH,
//												new SelectionAdapter() {
//								
//													@Override
//													public void widgetSelected( final SelectionEvent p_evt ) {
//														openEditors();
//													}
//												} );
//		tbiOpenElements.setEnabled( false );
//
//		tbiSelectElements = createToolBarItem( 	"/icons/selectElements.gif", 
//												"Select referenced element(s)",
//												SWT.PUSH,
//												new SelectionAdapter() {
//					
//													@Override
//													public void widgetSelected( final SelectionEvent p_evt ) {
//														selectReferencedElements();
//													}
//												} );
//
//		createTblElements( pnlElements );
//	}
//	
//	private void createTblElements(  final Composite p_parent ) {
//		tblElements = new TableViewer( p_parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER );
//		final Table table = tblElements.getTable();
//		table.setHeaderVisible( true );
//		table.setLinesVisible( true );
//		table.addMouseListener( new MouseAdapter() {
//			
//			@Override
//			public void mouseDoubleClick( MouseEvent p_evt ) {
//				final Object source = p_evt.getSource();
//				
//				if ( source instanceof Table ) {
//					final Table tbl = (Table) source;
//					
//					if ( tbl.getSelectionCount() == 1 ) {
//						openEditors();
//					}
//				}
//			}
//		} );
//
//		final GridData gridData = new GridData();
//		gridData.verticalAlignment = GridData.FILL;
//		gridData.grabExcessHorizontalSpace = true;
//		gridData.grabExcessVerticalSpace = true;
//		gridData.horizontalAlignment = GridData.FILL;
//		tblElements.getControl().setLayoutData( gridData );
//
//		tblElements.setContentProvider( new IStructuredContentProvider() {
//			
//			@Override
//			public void inputChanged( 	final Viewer p_viewer, 
//										final Object p_oldInput, 
//										final Object p_newInput ) {
//			}
//			
//			@Override
//			public void dispose() {
//			}
//			
//			@Override
//			public Object[] getElements( final Object p_inputElement ) {
//				return ( (Collection<?>) p_inputElement ).toArray();
//			}
//		} );
//		
//		tblElements.setInput( dataElements );
//		tblElements.setSorter( new TableColumnSorter() );
//		tblElements.addPostSelectionChangedListener( new ISelectionChangedListener() {
//			
//			@Override
//			public void selectionChanged( final SelectionChangedEvent p_event ) {
//				if ( p_event.getSelection() instanceof IStructuredSelection ) {
//					final IStructuredSelection structSel = (IStructuredSelection) p_event.getSelection();
//					tbiOpenElements.setEnabled( structSel.size() > 0 );
//				}
//				else {
//					tbiOpenElements.setEnabled( false );
//				}
//			}
//		} );
//
//		buildColumns();
//	}
//	
//	private void openEditors() {
//		try {
//			for ( final EObject designSpecification : selectedDesignSpecifications() ) {
//				EditorUtil.openEditor( designSpecification );
//			}
//		}
//		catch ( final Throwable p_th ) {
//			getExceptionHandler().handleException( p_th, null );
//		}
//	}
//	
//	private List<EObject> selectedDesignSpecifications() {
//		final List<EObject> elements = new ArrayList<EObject>();
//		final Table table = tblElements.getTable();
//		
//		for ( final TableItem item : table.getSelection() ) {
//			elements.add( (EObject) item.getData() );
//		}
//
//		return elements;
//	}
//
//	private void buildColumns() {
//		final TableColumnSortSelectionListener sortListener = new TableColumnSortSelectionListener( tblElements );
//		
//		ColumnLabelProvider colLabelProvider = new ColumnLabelProvider() {
//			@Override
//			public String getText( final Object p_element ) {
//				return businessDelegate.getText( p_element );
//			}
//
//			@Override
//			public Image getImage( final Object p_element ) {
//				return businessDelegate.getImage( p_element );
//			}
//		};
//		
//		TableViewerColumn viewerColumn = new TableViewerColumn( tblElements, SWT.NONE );
//		viewerColumn.setLabelProvider( colLabelProvider );
//		TableColumn column = viewerColumn.getColumn();
//		column.setText( "Design Specification" );
//		column.setWidth( 250 );
//		column.setResizable( true );
//		column.setMoveable(true);
//		column.addSelectionListener( sortListener );
//		
//		colLabelProvider  = new ColumnLabelProvider() {
//			@Override
//			public String getText( final Object p_element ) {
//				final ModelElementReference ref =  (ModelElementReference) p_element;
//				final EObject modelElement = ref.getModelElement();
//				final Resource resource = modelElement.eResource(); 
//				
//				return resource == null ? "Unsaved" : String.valueOf( resource.getURI() );
//			}
//		};
//		viewerColumn = new TableViewerColumn( tblElements,	SWT.NONE );
//		
//		viewerColumn.setLabelProvider( colLabelProvider  );
//		column = viewerColumn.getColumn();
//		column.setText( "Location" );
//		column.setWidth( 500 );
//		column.setResizable( true );
//		column.setMoveable(true);
//		column.addSelectionListener( sortListener );		
//	}
//	
//	private void selectDesignSpecifications() {
//		final Specification specification = getSelectedObject();
//		
//		final FeatureEditorDialog dialog = new FeatureEditorDialog( getShell(),
//																	labelProvider,
//																	specification,
//																	businessDelegate.designSpecificationsChoice( specification ) );
//		if ( dialog.open() == Window.OK ) {
//			final Collection<EObject> selectedElements = (Collection<EObject>) dialog.getResult();
//	
//			if ( selectedElements != null ) {
//				try {
//					displayData( businessDelegate.setSeqignSpecifications( specification, selectedElements ) );
//				}
//				catch( final Throwable p_th ) {
//					getExceptionHandler().handleException( p_th, specification );
//				}
//			}
//		}
//	}
//	
//	private void createLibraryPanel( final Composite p_parent ) {
//		final IConstraintPanelActionHandler actionHandler = new IConstraintPanelActionHandler() {
//			
//			@Override
//			public void completionProposalRequested( 	final String p_languageId,
//														final String p_constraintText, 
//														final ModelingLevel p_modelingLevel ) {
//			}
//
//			@Override
//			public void constraintEvaluationRequested(	final String p_languageId,
//														final String p_constraintText, 
//														final ModelingLevel p_modelingLevel ) {
//			}
//
//			@Override
//			public void constraintLoadingRequested( final String p_languageId ) {
//			}
//
//			@Override
//			public void constraintSavingRequested( 	final String p_languageId,
//													final String p_constraintText ) {
//			}
//
//			@Override
//			public void languageChangeRequested( final String p_newLanguageId ) {
//			}
//
//			@Override
//			public Collection<String> addLibrariesRequested() {
//				final FileDialog fileDialog = new FileDialog( getShell(), SWT.OPEN | SWT.MULTI );
//				
//				try {
//					fileDialog.setFilterExtensions( new String[] { businessDelegate.languageFileExtension( 	requirement, 
//																											pnlConstraint.getLanguageId() ) } );
//					fileDialog.setText( "Add Constraint Libraries" );
//					final Collection<String> resourceIds = new ArrayList<String>();
//					
//					if ( fileDialog.open() != null ) {
//						final String path = fileDialog.getFilterPath() + File.separatorChar;
//	
//						for ( final String resourceId : fileDialog.getFileNames() ) {
//							resourceIds.add( path + resourceId );
//							displayData( businessDelegate.importRefModelElementsLibraries( requirement, resourceIds ) );
//						}
//					}
//					
//					return resourceIds;
//				}
//				catch ( final Throwable p_th ) {
//					getExceptionHandler().handleException( p_th , requirement );
//					
//					return null;
//				}
//			}
//
//			@Override
//			public void refreshLibrariesRequested( final Collection<String> p_libraryIds ) {
//				try {
//					displayData( businessDelegate.refreshLibraries( requirement, p_libraryIds ) );
//				}
//				catch ( final Throwable p_th ) {
//					getExceptionHandler().handleException( p_th , requirement );
//				}
//			}
//
//			@Override
//			public void deleteLibrariesRequested( final Collection<String> p_libraryIds ) {
//				try {
//					displayData( businessDelegate.deleteRefModelElementsLibraries( requirement, p_libraryIds ) );
//				}
//				catch ( final Throwable p_th ) {
//					getExceptionHandler().handleException( p_th , requirement );
//				}
//			}
//
//			@Override
//			public void openLibrariesRequested( final Collection<String> p_libraryIds ) {
//				try {
//					EditorUtil.openEditors( p_libraryIds );
//				}
//				catch ( final Throwable p_th ) {
//					getExceptionHandler().handleException( p_th, requirement );
//				}
//			}
//
//			@Override
//			public void constraintTextChanged(	final String p_languageId,
//												final String p_constraintText ) {
//			}
//		};
//
//		pnlConstraintLibrary = 	}
//	
//	public ToolItem createToolBarItem( 	final String p_imagePath,
//										final String p_tooltip,
//										final int pi_style,
//										final SelectionListener p_listener ) {
//		final ToolItem tbiItem = new ToolItem( tbrActions, pi_style );
//		tbiItem.setToolTipText( p_tooltip );
//		
//		if ( p_imagePath != null ) { 
//			tbiItem.setImage( createImage( p_imagePath ) );
//		}
//		
//		if ( p_listener != null ) {
//			tbiItem.addSelectionListener( p_listener );
//		}
//	    
//	    return tbiItem;
//	}
//	
//	public void setElements() {
//		dataElements.clear();
//		dataElements.addAll( getSelectedObject().getSpecifies() ); 
//		
//		Display.getDefault().asyncExec( new Runnable() {
//			@Override
//			public void run() {
//				tblElements.refresh();
//			}
//		} );
//	}
//
//	protected IExceptionHandler getExceptionHandler() {
//		return exceptionHandler;
//	}
//	
//	@Override
//	public void displayData( final Specification p_specification ) {
//		super.displayData( p_specification );
//		
//		displayDesignSpecifications();
//		displayLibraries();
//	}
//	
//	private void displayDesignSpecifications() {
//		manageButtons();
//		setElements();
//	}
//	
//	private void manageButtons() {
//		// TODO
//	}
//	
//	private void displayLibraries() {
//	}
}
