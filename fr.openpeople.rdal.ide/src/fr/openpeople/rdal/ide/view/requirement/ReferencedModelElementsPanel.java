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
package fr.openpeople.rdal.ide.view.requirement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import fr.labsticc.framework.constraints.core.ICompletionProposal;
import fr.labsticc.framework.constraints.ide.view.UsedLibrarySelectionDialog;
import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.FormalConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageExpression;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageLibrary;
import fr.labsticc.framework.constraints.view.ConstraintPanel;
import fr.labsticc.framework.constraints.view.IConstraintPanelActionHandler;
import fr.labsticc.framework.constraints.view.IConstraintViewersConfiguration;
import fr.labsticc.framework.constraints.view.TableColumnSortSelectionListener;
import fr.labsticc.framework.constraints.view.TableColumnSorter;
import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.openpeople.rdal.ide.view.EditorUtil;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements;
import fr.openpeople.rdal.model.core.RefUserSelectedModelElements;
import fr.openpeople.rdal.model.core.ReferencedModelElements;
import fr.openpeople.rdal.service.IRequirementBusinessDelegate;

public class ReferencedModelElementsPanel extends Composite {
	
	private TableViewer tblElements;
	private List<ModelElementReference> dataElements;
	private ToolBar tbrActions;
	private ToolItem tbiUseQuery;
	private ToolItem tbiSelectElements;
	private ToolItem tbiOpenElements;
	
	private ConstraintPanel pnlConstraint;
	
	private final IRequirementBusinessDelegate businessDelegate;
	private final IExceptionHandler exceptionHandler;
	
	private final ILabelProvider labelProvider = new LabelProvider() {

		@Override
		public String getText( final Object p_object ) {
			return businessDelegate.getText( p_object );
		}

		@Override
		public Image getImage( final Object p_object ) {
			return (Image) businessDelegate.getImage( p_object );
		}
	};
	
	private AbstractRequirement requirement;

	public ReferencedModelElementsPanel(	final Composite p_parent, 
											final int pi_style,
											final IConstraintViewersConfiguration p_constraintViewsConfig,
											final IRequirementBusinessDelegate p_businessDelegate,
											final IExceptionHandler p_exceptionHandler ) {
		super( p_parent, pi_style );
		
		businessDelegate = p_businessDelegate;
		exceptionHandler = p_exceptionHandler;
		dataElements = new ArrayList<ModelElementReference>();
		requirement = null;
		
		createControls( p_constraintViewsConfig );
	}

	private void createControls( final IConstraintViewersConfiguration p_constraintViewsConfig ) {
		setLayout( new FillLayout() );
		final SashForm sashForm = new SashForm( this, SWT.VERTICAL | SWT.LEFT_TO_RIGHT );
		sashForm.setLayout( new GridLayout() );
		
		createElementsTable( sashForm );
		createExpressionPanel( sashForm, p_constraintViewsConfig );

		sashForm.setWeights( new int[] { 1, 2 } );
	}
	
	private void createElementsTable( final Composite p_parent ) {
		final Composite pnlElements = new Composite( p_parent, SWT.NULL );
		pnlElements.setLayout( new GridLayout() );
		
		tbrActions = new ToolBar( pnlElements, SWT.FLAT | SWT.WRAP | SWT.RIGHT );
		
		tbiUseQuery = createToolBarItem( 	"/icons/useQuery.gif", 
											"Use query expression to calculate design model elements",
											SWT.CHECK,
											new SelectionAdapter() {
							
												@Override
												public void widgetSelected( final SelectionEvent p_evt ) {
													final boolean useQuery = ( (ToolItem) p_evt.getSource() ).getSelection();
													setReferencedModelElements( useQuery );
												}
											} );
		tbiOpenElements = createToolBarItem( 	"/icons/openElements.gif", 
												"Open design model element(s)",
												SWT.PUSH,
												new SelectionAdapter() {
								
													@Override
													public void widgetSelected( final SelectionEvent p_evt ) {
														openEditors();
													}
												} );
		tbiOpenElements.setEnabled( false );

		tbiSelectElements = createToolBarItem( 	"/icons/selectElements.gif", 
												"Select referenced design element(s)",
												SWT.PUSH,
												new SelectionAdapter() {
					
													@Override
													public void widgetSelected( final SelectionEvent p_evt ) {
														selectReferencedElements();
													}
												} );

		createTblElements( pnlElements );
	}
	
	private void createTblElements(  final Composite p_parent ) {
		tblElements = new TableViewer( p_parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER );
		final Table table = tblElements.getTable();
		table.setToolTipText( "Double-click element to open it." );
		table.setHeaderVisible( true );
		table.setLinesVisible( true );
		table.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseDoubleClick( MouseEvent p_evt ) {
				final Object source = p_evt.getSource();
				
				if ( source instanceof Table ) {
					final Table tbl = (Table) source;
					
					if ( tbl.getSelectionCount() == 1 ) {
						openEditors();
					}
				}
			}
		} );

		final GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		tblElements.getControl().setLayoutData( gridData );

		tblElements.setContentProvider( new IStructuredContentProvider() {
			
			@Override
			public void inputChanged( 	final Viewer p_viewer, 
										final Object p_oldInput, 
										final Object p_newInput ) {
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public Object[] getElements( final Object p_inputElement ) {
				return ( (Collection<?>) p_inputElement ).toArray();
			}
		} );
		
		tblElements.setInput( dataElements );
		tblElements.setSorter( new TableColumnSorter() );
		tblElements.addPostSelectionChangedListener( new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged( final SelectionChangedEvent p_event ) {
				if ( p_event.getSelection() instanceof IStructuredSelection ) {
					final IStructuredSelection structSel = (IStructuredSelection) p_event.getSelection();
					tbiOpenElements.setEnabled( structSel.size() > 0 );
				}
				else {
					tbiOpenElements.setEnabled( false );
				}
			}
		} );

		buildColumns();
	}
	
	private void openEditors() {
		try {
			for ( final ModelElementReference modelObjectRef : selectedRefModelElements() ) {
				final EObject modelElement = modelObjectRef.getModelElement();
				EditorUtil.openEditor( modelElement );
			}
		}
		catch ( Throwable p_th ) {
			getExceptionHandler().handleException( p_th, null );
		}
	}
	
	private List<ModelElementReference> selectedRefModelElements() {
		final List<ModelElementReference> elements = new ArrayList<ModelElementReference>();
		final Table table = tblElements.getTable();
		for ( final TableItem item : table.getSelection() ) {
			elements.add( (ModelElementReference) item.getData() );
		}

		return elements;
	}

	private void buildColumns() {
		final TableColumnSortSelectionListener sortListener = new TableColumnSortSelectionListener( tblElements );
		
		ColumnLabelProvider colLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText( final Object p_element ) {
				final ModelElementReference ref =  (ModelElementReference) p_element; 
				
				return labelProvider.getText( ref.getModelElement() );
			}

			@Override
			public Image getImage( final Object p_element ) {
				final ModelElementReference ref =  (ModelElementReference) p_element; 

				return labelProvider.getImage( ref.getModelElement() );
			}
		};
		TableViewerColumn viewerColumn = new TableViewerColumn( tblElements, SWT.NONE );
		viewerColumn.setLabelProvider( colLabelProvider );
		TableColumn column = viewerColumn.getColumn();
		column.setText( "Element" );
		column.setWidth( 350 );
		column.setResizable( true );
		column.setMoveable(true);
		column.addSelectionListener( sortListener );

		colLabelProvider  = new ColumnLabelProvider() {
			@Override
			public String getText( final Object p_element ) {
				final ModelElementReference ref =  (ModelElementReference) p_element;
				final EObject modelElement = ref.getModelElement();
				final Resource resource = modelElement.eResource(); 
				
				return resource == null ? "Unsaved" : String.valueOf( resource.getURI() );
			}
		};
		viewerColumn = new TableViewerColumn( tblElements,	SWT.NONE );
		
		viewerColumn.setLabelProvider( colLabelProvider  );
		column = viewerColumn.getColumn();
		column.setText( "Location" );
		column.setWidth( 600 );
		column.setResizable( true );
		column.setMoveable( true );
		column.addSelectionListener( sortListener );		
	}
	
	private void setReferencedModelElements( final boolean pb_useQuery ) {
		try {
			if ( pb_useQuery ) {
				displayData( businessDelegate.setReferencedModelElements( 	requirement,
																			pnlConstraint.getLanguageId(),
																			pnlConstraint.getConstraintText() ) );
			}
			else {
				displayData( businessDelegate.setReferencedModelElements( requirement, dataElements ) );
			}
		}
		catch( final Throwable p_th ) {
			exceptionHandler.handleException( p_th, requirement );
		}
	}
	
	private void selectReferencedElements() {
		final ReferencedModelElements currentRefModelElement = requirement.getSatisfiedBy();
		final RefUserSelectedModelElements templRefModelElement;
		
		if ( currentRefModelElement instanceof RefUserSelectedModelElements ) {
			templRefModelElement = (RefUserSelectedModelElements) currentRefModelElement;
		}
		else {
			templRefModelElement = CoreFactory.eINSTANCE.createRefUserSelectedModelElements();
		}
		
		final RefModelElementsSelectionDialog dialog = new RefModelElementsSelectionDialog( getShell(),
																							labelProvider,
																							templRefModelElement,
																							businessDelegate.modelElements( templRefModelElement ),
																							businessDelegate.modelElementsChoice( requirement, templRefModelElement ));
		if ( dialog.open() == Window.OK ) {
			final Collection<EObject> selectedElements = dialog.getResult();
	
			if ( selectedElements != null ) {
				try {
					displayData( businessDelegate.setModelElements( requirement, selectedElements ) );
				}
				catch( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th, requirement );
				}
			}
		}
	}
	
	private void createExpressionPanel( final Composite p_parent ,
										final IConstraintViewersConfiguration p_constraintViewsConfig ) {
		final IConstraintPanelActionHandler actionHandler = new IConstraintPanelActionHandler() {
			
			@Override
			public List<ICompletionProposal> completionProposalRequested( 	final String p_languageId,
																			final String p_constraintText,
																			final Collection<String> p_libraryIds ) {
				try {
					return businessDelegate.computeRefElementsCompletionProposals( 	requirement, p_constraintText );
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th, requirement );
					
					return null;
				}
			}

			@Override
			public String constraintEvaluationRequested(	final String p_languageId,
															final String p_constraintText, 
															final Collection<String> p_libraryIds ) {
				try {
					final Collection<ModelElementReference> refElements = businessDelegate.modelElementReferences( requirement ); 
					setElements( refElements );
					
					return refElements.toString();
					//pnlConstraint.displayConstraint( p_constraintText, refElements.toString() );
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th, p_constraintText );
					
					return null;
				}
			}

			@Override
			public String constraintLoadingRequested( final String p_languageId ) {
				final FileDialog fileDialog = new FileDialog( getShell(), SWT.OPEN );
				
				try {
					fileDialog.setFilterExtensions( new String[] { businessDelegate.languageFileExtension( requirement, p_languageId ) } );
					fileDialog.setText( "Load Constraint Expression" );
					final String resourceId = fileDialog.open();
	
					if ( resourceId != null ) {
						final String constraintText = businessDelegate.readConstraintText( 	p_languageId,
																							resourceId );
						
						// Must save the new data
						displayData( businessDelegate.setRefModelElementsConstraintExprText( 	requirement, 
																								p_languageId, 
																								constraintText ) );
						
						return constraintText;
					}
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th, requirement );
				}
				
				return null;
			}

			@Override
			public void constraintSavingRequested( 	final String p_languageId,
													final String p_constraintText ) {
				final String languageId = pnlConstraint.getLanguageId();
				
				final FileDialog fileDialog = new FileDialog( getShell(), SWT.SAVE );

				try {
					fileDialog.setFilterExtensions( new String[] { businessDelegate.languageFileExtension( 	requirement, 
																											p_languageId ) } );
					fileDialog.setText( "Save Constraint Expression" );
					final String resourceId = fileDialog.open();
	
					if ( resourceId != null ) {
						businessDelegate.persistConstraint( languageId, resourceId, p_constraintText );
					}
				} 
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th, requirement );
				}
			}

			@Override
			public Collection<String> constraintLanguageChanged( final String p_newLanguageId ) {
				try {
					displayData( businessDelegate.setReferencedModelElements( requirement, p_newLanguageId, pnlConstraint.getConstraintText() ) );
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th, requirement );
				}
				
				final FormalLanguageExpression expression = ( (RefExpressionCollectedModelElements) requirement.getSatisfiedBy() ).getQueryExpression();

				return expression.getUsedLibraryNames();
			}

			@Override
			public Collection<String> addLibrariesRequested( 	final String p_languageId,
																final Collection<String> p_currentLibraries ) {
				try {
					final FormalLanguageExpression expression = ( (RefExpressionCollectedModelElements) requirement.getSatisfiedBy() ).getQueryExpression();
					final UsedLibrarySelectionDialog dialog = new UsedLibrarySelectionDialog( 	getShell(), 
																								labelProvider, 
																								expression,
																								businessDelegate.librariesChoice( expression ) );
					if ( dialog.open() == Window.OK ) {
						businessDelegate.setRefModelElementsLibraries( requirement, dialog.getResult() );
						
						return expression.getUsedLibraryNames();
					}
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th , requirement );
				}
				
				return null;
			}

			@Override
			public void librariesRefreshRequested( final Collection<String> p_libraryNames ) {
				try {
					businessDelegate.refreshRefModelElementsLibraries( requirement, libraryIds( p_libraryNames ) );
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th , requirement );
				}
			}

			@Override
			public void librariesDeleted( final Collection<String> p_libraryNames ) {
				try {
					businessDelegate.deleteRefModelElementsLibraries( requirement, libraryIds( p_libraryNames ) );
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th , requirement );
				}
			}

			@Override
			public void openLibrariesRequested( final Collection<String> p_libraryNames ) {
				try {
					EditorUtil.openEditors( libraryIds( p_libraryNames ) );
				}
				catch ( final Throwable p_th ) {
					getExceptionHandler().handleException( p_th, requirement );
				}
			}

			@Override
			public void constraintTextChanged(	final String p_languageId,
												final String p_constraintText ) {
				// The text change event may be fired even after the use query button has been released.
				// Call this method only when in proper type of referenced model elements.
				if ( tbiUseQuery.getSelection() ) {
					try {
						businessDelegate.setRefModelElementsConstraintExprText( requirement, p_languageId, p_constraintText );
					}
					catch ( final Throwable p_th ) {
						getExceptionHandler().handleException( p_th, requirement );
					}
				}
			}
		};

		pnlConstraint = new ConstraintPanel( 	p_parent, 
												SWT.NULL,
												actionHandler,
												p_constraintViewsConfig,
												getExceptionHandler() );

		final GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessVerticalSpace = true;
		data.verticalAlignment = SWT.FILL;
		pnlConstraint.setLayoutData( data );
	}
	
	private Collection<String> libraryIds( final Collection<String> p_libraryNames ) {
		final Collection<String> libIds = new HashSet<String>();
		final FormalConstraintLanguage language = (FormalConstraintLanguage) ( (RefExpressionCollectedModelElements) requirement.getSatisfiedBy() ).getQueryExpression().getLanguage();
		
		for ( final String libName : p_libraryNames ) {
			final FormalLanguageLibrary library = language.libraryByName( libName );
			
			if ( library != null ) {
				libIds.add( library.getId() );
			}
		}
		
		return libIds;
	}
	
	public ToolItem createToolBarItem( 	final String p_imagePath,
										final String p_tooltip,
										final int pi_style,
										final SelectionListener p_listener ) {
		final ToolItem tbiItem = new ToolItem( tbrActions, pi_style );
		tbiItem.setToolTipText( p_tooltip );
		
		if ( p_imagePath != null ) { 
			tbiItem.setImage( createImage( p_imagePath ) );
		}
		
		if ( p_listener != null ) {
			tbiItem.addSelectionListener( p_listener );
		}
	    
	    return tbiItem;
	}
	
	private Image createImage( final String p_imagePath ) {
		return new Image( 	getDisplay(), 
							Thread.currentThread().getContextClassLoader().getResourceAsStream( p_imagePath ) );
	}
	
	public void setElements( final Collection<ModelElementReference> p_elements ) {
		dataElements.clear();

		if ( p_elements != null ) {
			dataElements.addAll( p_elements ); 
		}
		
		Display.getDefault().asyncExec( new Runnable() {
			@Override
			public void run() {
				tblElements.refresh();
			}
		} );
	}

	protected IExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}
	
	public void displayData( final AbstractRequirement p_requirement ) {
		requirement = p_requirement;
		
		displayReferencedModelElements();
	}
	
	private void displayReferencedModelElements() {
		final ReferencedModelElements refElements = requirement.getSatisfiedBy();
		
		final FormalLanguageExpression refExpression;

		if ( refElements instanceof RefUserSelectedModelElements ) {
//			for ( final ModelElementReference ref : ( (RefModelElementsCollection) refElements ).getModelElementReferences() ) {
//				elements.add( ref.getModelElement() );
//			}
			
			refExpression = null;
		}
		else if ( refElements instanceof RefExpressionCollectedModelElements ) {
//			elements = null;
			refExpression = ( (RefExpressionCollectedModelElements) refElements ).getQueryExpression();
		}
		else {
//			elements = null;
			refExpression = null;
		}
		
		displayExpression( refExpression );
		manageButtons( refExpression != null );
		setElements( refElements == null ? null :refElements.getModelElementReferences() );
	}
	
	private void manageButtons( final boolean pb_useQuery ) {
		tbiUseQuery.setSelection( pb_useQuery );
		tbiSelectElements.setEnabled( !pb_useQuery );
		pnlConstraint.setEnabled( pb_useQuery );
	}
	
	private void displayExpression( final FormalLanguageExpression p_expression ) {
		final String languageId;
		final String expressionText;
		
		if ( p_expression == null ) {
			languageId = null;
			expressionText = null;
		}
		else {
			expressionText = p_expression.getText();
			
			final ConstraintLanguage language = p_expression.getLanguage();
			
			if ( language == null ) {
				languageId = null;
			}
			else {
				languageId = language.getId();
			}
		}
		
		final Set<String> definedLanguageIds = new TreeSet<String>();
	
		for ( final ConstraintLanguage language : businessDelegate.definedLanguages( requirement ) ) {
			if ( language instanceof FormalConstraintLanguage ) {
				definedLanguageIds.add( language.getId() );
			}
		}
	
		pnlConstraint.configure( definedLanguageIds, languageId );
		pnlConstraint.displayConstraint( expressionText, null );
		
		displayLibraries( p_expression );
	}
	
	private void displayLibraries( final FormalLanguageExpression p_expression ) {
		final Collection<String> libraryNames = new ArrayList<String>();

		if ( p_expression != null ) {
			for ( final FormalLanguageLibrary library : ( (FormalLanguageExpression) p_expression ).getUsedLibraries() ) {
				libraryNames.add( library.getName() );
			}
		}
		
		pnlConstraint.setLibraries( libraryNames );
	}
}
