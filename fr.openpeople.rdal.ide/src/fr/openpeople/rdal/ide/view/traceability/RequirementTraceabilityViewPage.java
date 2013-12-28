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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import fr.labsticc.framework.core.exception.IExceptionHandler;
import fr.labsticc.framework.ide.viewpart.TreeColumnSortSelectionListener;
import fr.labsticc.framework.ide.viewpart.TreeColumnSorter;
import fr.openpeople.rdal.ide.view.AbstractRdalEditorViewPage;
import fr.openpeople.rdal.ide.view.EditorUtil;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.service.IRequirementsTraceabilityBusinessDelegate;

public class RequirementTraceabilityViewPage extends AbstractRdalEditorViewPage<EObject> {

	private static final Class<? extends IdentifiedElement> INITIAL_ROOT_ELEM_TYPE = AbstractRequirement.class;
	private static final boolean INITIAL_FLAT_LAYOUT = false;
	
	private final IRequirementsTraceabilityBusinessDelegate businessDelegate;
	
	private final TreeViewer tblRequirements;
	private RequirementsTreeContentProvider contentProvider;
	
	private final IAction actExpColl;
	private final IAction actEvaluate;
	private final IAction actOpen;
	private final IAction actSetRootElement;
	
	private final Image imgTraceability;

	private final ImageDescriptor imgCollapseAll;
	private final ImageDescriptor imgExpandAll;

	private final ImageDescriptor imgHierarchicalLayout;
	private final ImageDescriptor imgFlatLayout;
		
	public RequirementTraceabilityViewPage( final Composite p_parent,
											final IRequirementsTraceabilityBusinessDelegate p_businessDelegate,
											final IExceptionHandler p_exceptionHandler ) {
		super( p_parent, SWT.NULL, p_exceptionHandler );
		
		businessDelegate = p_businessDelegate;
		tblRequirements = createControls();
		
		imgTraceability = createImage( "traceabilityView.gif" );
		imgCollapseAll = ImageDescriptor.createFromImage( createImage( "collapseall.gif" ) );
		imgExpandAll = ImageDescriptor.createFromImage( createImage( "expandall.gif" ) );
		imgHierarchicalLayout = ImageDescriptor.createFromImage( createImage( "hierarchicalLayout.gif" ) );
		imgFlatLayout = ImageDescriptor.createFromImage( createImage( "flatLayout.gif" ) );

		actExpColl = createExpCollAction();
		actEvaluate = createEvaluateAction();
		actOpen = createOpenAction();
		actSetRootElement = createActSetRootElement();
	}
	
	private TreeViewer createControls() {
		setLayout( new FillLayout() );
		final Tree traceTree = new Tree( this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL );
		traceTree.setHeaderVisible( true );
		traceTree.setLinesVisible( true );
		traceTree.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseDoubleClick( MouseEvent p_evt ) {
				final Object source = p_evt.getSource();
				
				if ( source instanceof Tree ) {
					final Tree tbl = (Tree) source;
					
					if ( tbl.getSelectionCount() == 1 ) {
						selectInEditor();
					}
				}
			}
		} );

		final TreeViewer viewer = new TreeViewer( traceTree );
		ColumnViewerToolTipSupport.enableFor( viewer );
			
		buildColumns( viewer );

		contentProvider = new RequirementsTreeContentProvider( 	businessDelegate, 
																INITIAL_ROOT_ELEM_TYPE,
																INITIAL_FLAT_LAYOUT,
																getExceptionHandler() );
		viewer.setContentProvider( contentProvider );
		viewer.setLabelProvider( new RequirementTreeLabelProvider( 	createImage( "verifOk.gif" ),
																	createImage( "verifUnknown.gif" ),
																	createImage( "verifError.gif" ),
																	createImage( "lowRisk.gif" ),
																	createImage( "mediumRisk.gif" ),
																	createImage( "highRisk.gif") ) );
		viewer.setComparator( new TreeColumnSorter() );
		viewer.addPostSelectionChangedListener( new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged( final SelectionChangedEvent p_event ) {
				if ( p_event.getSelection() instanceof IStructuredSelection ) {
					final IStructuredSelection structSel = (IStructuredSelection) p_event.getSelection();
					actOpen.setEnabled( structSel.size() > 0 );
				}
				else {
					actOpen.setEnabled( false );
				}
			}
		} );

		viewer.setInput( contentProvider.getDataElements() );
		viewer.expandAll();
		
		return viewer;
	}
	
	private List<EObject> selectedModelElements() {
		final List<EObject> elements = new ArrayList<EObject>();
		final Tree tree = tblRequirements.getTree();
		
		for ( final TreeItem item : tree.getSelection() ) {
			elements.add( (EObject) item.getData() );
		}

		return elements;
	}
	
	private void selectInEditor() {
		try {
			for ( final EObject element : selectedModelElements() ) {
				if ( element instanceof ModelElementReference ) {
					EditorUtil.openEditor( ( (ModelElementReference) element ).getModelElement() );
				}
				else {
					EditorUtil.openEditor( element );
				}
			}
		}
		catch ( final Throwable p_th ) {
			getExceptionHandler().handleException( p_th, null );
		}
	}
	
	@Override
	public String getExternalTitle() {
		return "Traceability";
	}
	
	@Override
	public Image getExternalImage() {
		return imgTraceability;
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		if ( !imgTraceability.isDisposed() ) {
			imgTraceability.dispose();
		}
	}
	
	@Override
	public Collection<IAction> getExternalToolbarActions() {
		return Arrays.asList( new IAction[]{ actEvaluate, actOpen, actExpColl, actSetRootElement } );
	}
	
	private IAction createExpCollAction() {
		final IAction action = new Action() {
			@Override
			public void run() {
				if ( getImageDescriptor() == imgExpandAll ) {
					setImageDescriptor( imgCollapseAll );
					setToolTipText( "Collapse All" );
					manageTreeExpansion( true );
				}
				else {
					setImageDescriptor( imgExpandAll );
					setToolTipText( "Expand All" );
					manageTreeExpansion( false );
				}
			}
		};
		
		action.setImageDescriptor( imgExpandAll );
		action.setToolTipText( "Expand All" );
		action.setEnabled( !INITIAL_FLAT_LAYOUT );
		
		return action;
	}

	private IAction createEvaluateAction() {
		final IAction action = new Action() {
			@Override
			public void run() {
				final EObject currentObject = getSelectedObject();
				
				try {
					businessDelegate.evaluateConstraints( currentObject );
					displayData( currentObject );
				}
				catch ( final Throwable p_th ) {
					handleException( p_th, currentObject );
				}
			}
		};
		
		action.setImageDescriptor( ImageDescriptor.createFromImage( createImage( "evaluateConstraints.gif" ) ) );
		action.setToolTipText( "Evaluate Requirements Constraints" );
		
		return action;
	}

	private IAction createOpenAction() {
		final IAction action = new Action() {
			@Override
			public void run() {
				selectInEditor();
			}
		};
		
		action.setImageDescriptor( ImageDescriptor.createFromImage( createImage( "openElements.gif" ) ) );
		action.setToolTipText( "Open Selected Element" );
		action.setEnabled( false );
		
		return action;
	}
	
	private IAction createActSetRootElement() {
		final IAction action = new Action( null, IAction.AS_DROP_DOWN_MENU ) {

			@Override
			public void run() {
				if ( getImageDescriptor() == imgFlatLayout ) {
					setImageDescriptor( imgHierarchicalLayout );
					setToolTipText( "Hierarchical Layout" );
					setFlatLayout( true );
					actExpColl.setEnabled( false );
				}
				else {
					setImageDescriptor( imgFlatLayout );
					setToolTipText( "Flat Layout" );
					setFlatLayout( false );
					actExpColl.setEnabled( true );
				}
			}
		};

		action.setMenuCreator( new IMenuCreator() {
			private Menu menu = null;
			
			@Override
			public void dispose() {
				if ( menu != null ) {
					menu.dispose();
					menu = null;
				}
			}

			@Override
			public Menu getMenu( final Control p_parent ) {
				if ( menu == null ) {
					menu = new Menu( p_parent );

					createContributor( Specification.class );
					createContributor( RequirementsGroup.class );
					createContributor( AbstractRequirement.class );
				}
				
				return menu;
			}

			@Override
			public Menu getMenu( final Menu p_parent ) {
				return menu;
			}

			private void createContributor( final Class<? extends IdentifiedElement> p_class ) {
				final ActionContributionItem item = new ActionContributionItem( new SetRootElementAction( p_class ) );
				item.fill( menu, - 1 );
				item.getAction().setChecked( p_class.equals( contentProvider.getRootElementType() ) );
			}
		} );
		
		if ( INITIAL_FLAT_LAYOUT ) {
			action.setToolTipText(  "Hierarchical Layout" );
			action.setImageDescriptor( imgHierarchicalLayout );
		}
		else {
			action.setToolTipText(  "Flat Layout" );
			action.setImageDescriptor( imgFlatLayout );
		}

		return action;
	}
	
	protected class SetRootElementAction extends Action {
		private final Class<? extends IdentifiedElement> elementClass;
		
		public SetRootElementAction( final Class<? extends IdentifiedElement> p_elementClass ) {
			super( p_elementClass.getSimpleName(), AS_RADIO_BUTTON );

			elementClass = p_elementClass;
			setChecked( INITIAL_ROOT_ELEM_TYPE.equals( elementClass ) );
		}

		@Override
		public void run() {
			contentProvider.setRootElementType( elementClass );
			refreshTblRequirements();
		}
	}
	
	private static void buildColumns( final TreeViewer p_viewer ) {
		final TreeColumnSortSelectionListener sortListener = new TreeColumnSortSelectionListener( p_viewer );
		final Tree traceTree = p_viewer.getTree();
		buildColumn( traceTree, SWT.LEFT, "Element", 400, sortListener );
		buildColumn( traceTree, SWT.CENTER, "Verified", 60, sortListener );
		buildColumn( traceTree, SWT.RIGHT, "Level (%)", 60, sortListener );
		buildColumn( traceTree, SWT.LEFT, "Risk", 60, sortListener );
		buildColumn( traceTree, SWT.LEFT, "Type", 90, sortListener );
		buildColumn( traceTree, SWT.LEFT, "Description", 500, sortListener );
 	}
	
	private static TreeColumn buildColumn( 	final Tree p_parent,
											final int pi_alignment,
											final String p_headerText,
											final int pi_width,
											final SelectionListener p_selectionListener ) {
		final TreeColumn column = new TreeColumn( p_parent, SWT.RIGHT );
		column.setAlignment( pi_alignment );
		column.setText( p_headerText );
		column.setWidth( pi_width );
		column.addSelectionListener( p_selectionListener );
		
		return column;
	}
	
	@Override
	public void displayData( final EObject p_object ) {
		super.displayData( p_object );
		
		contentProvider.setDesignElement( p_object );
		refreshTblRequirements();
	}
	
	private void refreshTblRequirements() {
		getDisplay().syncExec( new Runnable() {
			@Override
			public void run() {
				tblRequirements.refresh();
			}
		} );
		
		manageTreeExpansion( actExpColl.getImageDescriptor() != imgExpandAll );
	}
	
	private void manageTreeExpansion( final boolean pb_expand ) {
		if ( pb_expand ) { 
			tblRequirements.expandAll();
		}
		else {
			tblRequirements.collapseAll();
		}
	}
	
	private void setFlatLayout( final boolean pb_flat ) {
		contentProvider.setFlatLayout( pb_flat );
		refreshTblRequirements();
	}
}
