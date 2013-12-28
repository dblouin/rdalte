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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import fr.labsticc.framework.constraints.core.ICompletionProposal;
import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.constraints.core.exception.ConstraintValidationException;
import fr.labsticc.framework.constraints.ide.ConstraintsIDEPlugin;
import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageExpression;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageLibrary;
import fr.labsticc.framework.constraints.model.constraints.provider.ConstraintsItemProviderAdapterFactory;
import fr.labsticc.framework.constraints.service.IConstraintInterpretationAS;
import fr.labsticc.framework.constraints.service.IConstraintPersistenceAS;
import fr.labsticc.framework.core.exception.SystemException;
import fr.labsticc.framework.emf.view.editor.AbstractEditorCommand;
import fr.openpeople.rdal.ide.view.AbstractViewPageBusinessDelegate;
import fr.openpeople.rdal.ide.view.commands.AbstractRequirementCommand;
import fr.openpeople.rdal.ide.view.commands.RequirementsEditorValidationAS;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RefUserSelectedModelElements;
import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorPlugin;
import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorUtil;
import fr.openpeople.rdal.model.core.provider.ModelElementReferenceModelElementPropertyDescriptor;
import fr.openpeople.rdal.service.IRequirementBusinessDelegate;
import fr.openpeople.rdal.service.RequirementServicesFacade;

/**
 * The delegate to perform the business logic related to the requirements model objects. This implementation is
 * especially designed to handle the transactions for the editor and calls appropriate methods on the requirements
 * business facade.
 * 
 * @author <a href="mailto:dominique.blouin@univ-ubs.fr">Dominique Blouin</a>
 */
public class RequirementViewBusinessDelegate extends AbstractViewPageBusinessDelegate implements IRequirementBusinessDelegate {

	private static final AdapterFactory defaultAdapterFactory = RdalDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory();
	
	private final RequirementServicesFacade reqBusinessFacade;

	public RequirementViewBusinessDelegate( final Map<String, IConstraintInterpretationAS> p_interpreters,
											final Map<String, IConstraintPersistenceAS> p_persistenceServices ) {
		reqBusinessFacade = new RequirementServicesFacade( 	p_interpreters, 
															p_persistenceServices, 
															new RequirementsEditorValidationAS() );
		
		if ( defaultAdapterFactory instanceof ComposedAdapterFactory ) {
			( (ComposedAdapterFactory) defaultAdapterFactory ).addAdapterFactory( new ConstraintsItemProviderAdapterFactory() );
		}
	}
	
	@Override
	public AbstractRequirement setModelElements( 	final AbstractRequirement p_requirement, 
													final Collection<EObject> p_selectedElements ) 
	throws SystemException, InterruptedException {
		return executeCommand( new AbstractRequirementCommand( p_requirement ) {
		    	
		    	@Override
		    	protected void executeCommand() 
		    	throws SystemException, InterruptedException {
		    		setExecResult( reqBusinessFacade.setModelElements( p_requirement, p_selectedElements ) );
		    	}
	    }, 
	    false );
	}

	@Override
    public AbstractRequirement setReferencedModelElements( 	final AbstractRequirement p_requirement, 
															final Collection<ModelElementReference> p_modelElementRefs )
    throws SystemException, InterruptedException {
		return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.setReferencedModelElements( p_requirement, p_modelElementRefs ) );
	    	}
		}, 
	    false );
	}

    @Override
	public AbstractRequirement setReferencedModelElements(	final AbstractRequirement p_requirement,
															final String p_languageId,
															final String p_queryText )
	throws SystemException,	InterruptedException {
		return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.setReferencedModelElements( 	p_requirement,
	    																		p_languageId,
	    																		p_queryText ) );
	    	}
		}, 
	    false );
	}
	
	@Override
	public AbstractRequirement deleteLibraries(	final AbstractRequirement p_requirement,
												final Collection<String> p_libraryIds )
    throws SystemException, InterruptedException {
	    return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.deleteLibraries( p_requirement, p_libraryIds ) );
	    	}
	    }, 
	    false );
	}
	
	@Override
	public AbstractRequirement deleteRefModelElementsLibraries(	final AbstractRequirement p_requirement,
																final Collection<String> p_libraryIds )
    throws SystemException, InterruptedException {
	    return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.deleteRefModelElementsLibraries( 	p_requirement, 
	    																			p_libraryIds ) );
	    	}
	    }, 
	    false );
	}
	
	@Override
	public AbstractRequirement setExpressionLibraries( 	final AbstractRequirement p_requirement,
														final Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
	    try {
			return executeConstraintCommand( new AbstractRequirementCommand( p_requirement ) {
				
				@Override
				protected void executeCommand() 
				throws ConstraintException, SystemException, InterruptedException {
					setExecResult( reqBusinessFacade.setExpressionLibraries( p_requirement, p_libraries ) );
				}
			} );
		} 
	    catch ( final ConstraintValidationException p_ex ) {
			throw p_ex;
		}
	    catch ( final ConstraintException p_ex ) {
			throw new SystemException( p_ex );
		}
	}
	
	@Override
	public AbstractRequirement setRefModelElementsLibraries( 	final AbstractRequirement p_requirement,
																final Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
	    try {
			return executeConstraintCommand( new AbstractRequirementCommand( p_requirement ) {
				
				@Override
				protected void executeCommand() 
				throws ConstraintException, SystemException, InterruptedException {
					setExecResult( reqBusinessFacade.setRefModelElementsLibraries( p_requirement, p_libraries ) );
				}
			} );
		} 
	    catch ( final ConstraintValidationException p_ex ) {
			throw p_ex;
		}
	    catch ( final ConstraintException p_ex ) {
			throw new SystemException( p_ex );
		}
	}

	@Override
	public AbstractRequirement refreshLibraries(	final AbstractRequirement p_requirement,
													final Collection<String> p_libraryIds ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
	    try {
			final AbstractRequirement requirement = executeConstraintCommand( new AbstractRequirementCommand( p_requirement ) {
				
				@Override
				protected void executeCommand() 
				throws ConstraintException, SystemException, InterruptedException {
					setExecResult( reqBusinessFacade.refreshLibraries( p_requirement, p_libraryIds ) );
				}
			} );

			ConstraintsIDEPlugin.getDefault().saveSpecification();
			
			return requirement;
		} 
	    catch ( final ConstraintValidationException p_ex ) {
			throw p_ex;
		}
	    catch ( final ConstraintException p_ex ) {
			throw new SystemException( p_ex );
		}
//	    catch ( final IOException p_ex ) {
//			throw new SystemException( p_ex );
//		}
	}

	@Override
	public AbstractRequirement refreshRefModelElementsLibraries(	final AbstractRequirement p_requirement,
																	final Collection<String> p_libraryIds ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
	    try {
			final AbstractRequirement requirement = executeConstraintCommand( new AbstractRequirementCommand( p_requirement ) {
				
				@Override
				protected void executeCommand() 
				throws ConstraintException, SystemException, InterruptedException {
					setExecResult( reqBusinessFacade.refreshRefModelElementsLibraries( p_requirement, p_libraryIds ) );
				}
			} );
			
			ConstraintsIDEPlugin.getDefault().saveSpecification();
			
			return requirement;
		} 
	    catch ( final ConstraintValidationException p_ex ) {
			throw p_ex;
		}
	    catch ( final ConstraintException p_ex ) {
			throw new SystemException( p_ex );
		}
//	    catch ( final IOException p_ex ) {
//			throw new SystemException( p_ex );
//		}
	}

	@Override
	public AbstractRequirement setConstraintExprText( 	final AbstractRequirement p_requirement,
														final String p_languageId,
														final String p_constraintText ) 
	throws SystemException, InterruptedException {
	    return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.setConstraintExprText( p_requirement, p_languageId, p_constraintText ) );
	    	}
	    }, 
	    false );
	}

	@Override
	public AbstractRequirement setConstraintExprLanguage( 	final AbstractRequirement p_requirement,
															final String p_languageId ) 
	throws SystemException, InterruptedException {
	    return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.setConstraintExprLanguage( p_requirement, p_languageId ) );
	    	}
	    }, 
	    false );
	}

	@Override
	public AbstractRequirement setRefModelElementsConstraintExprText( 	final AbstractRequirement p_requirement,
																		final String p_languageId,
																		final String p_constraintText ) 
	throws SystemException, InterruptedException {
	    return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.setRefModelElementsConstraintExprText( p_requirement, 
	    																				p_languageId, 
	    																				p_constraintText ) );
	    	}
	    }, 
	    false );
	}

	@Override
	public AbstractRequirement evaluateConstraint( final AbstractRequirement p_requirement )
	throws ConstraintException, SystemException, InterruptedException {
	    return executeConstraintCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws ConstraintException, SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.evaluateConstraint( p_requirement ) );
	    	}
	    } );
	}

	@Override
	public AbstractRequirement evaluateConstraint(	final AbstractRequirement p_requirement,
													final Collection<EObject> p_contextElements )
	throws ConstraintException, SystemException, InterruptedException {
	    return executeConstraintCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws ConstraintException, SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.evaluateConstraint( p_requirement, true, p_contextElements ) );
	    	}
	    } );
	}

	@Override
	public List<ICompletionProposal> computeCompletionProposals(	final AbstractRequirement p_requirement,
																	final String p_constraintText )
	throws ConstraintException, SystemException, InterruptedException {
		return reqBusinessFacade.computeCompletionProposals( p_requirement, p_constraintText );
	}

	@Override
	public List<ICompletionProposal> computeRefElementsCompletionProposals(	final AbstractRequirement p_requirement,
																			final String p_constraintText )
	throws ConstraintException, SystemException, InterruptedException {
		return reqBusinessFacade.computeRefElementsCompletionProposals( p_requirement, p_constraintText );
	}

	@Override
	public ConstraintLanguage constraintLanguage(	final AbstractRequirement p_requirement,
													final String p_languageId ) {
		return reqBusinessFacade.constraintLanguage( p_requirement, p_languageId );
	}

	@Override
	public Collection<ConstraintLanguage> definedLanguages(	final AbstractRequirement p_requirement ) {
		return reqBusinessFacade.definedLanguages( p_requirement );
	}

	@Override
	public String evaluateConstraintAsString( 	final AbstractRequirement p_requirement )
	throws ConstraintException, SystemException, InterruptedException {
		return reqBusinessFacade.evaluateConstraintAsString( p_requirement );
	}

	@Override
	public Collection<EObject> modelElements( final AbstractRequirement p_requirement )
	throws ConstraintException,	SystemException, InterruptedException {
		return reqBusinessFacade.modelElements( p_requirement );
	}

	@Override
	public AbstractRequirement setModelElements( final AbstractRequirement p_requirement )
	throws ConstraintException,	SystemException, InterruptedException {
	    return executeConstraintCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws ConstraintException, SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.setModelElements( p_requirement ) );
	    	}
	    } );
	}

	@Override
	public AbstractRequirement setDescriptionText( 	final AbstractRequirement p_requirement,
													final String p_text )
	throws SystemException, InterruptedException {
	    return executeCommand( new AbstractRequirementCommand( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws ConstraintException, SystemException, InterruptedException {
	    		p_requirement.setDescription( p_text );
	    		setExecResult( p_requirement );
	    	}
	    }, 
	    false );
	}

	@Override
	public Collection<ModelElementReference> modelElementReferences( final AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException {
	    return executeConstraintCommand( new AbstractEditorCommand<Collection<ModelElementReference>>( p_requirement ) {
	    	
	    	@Override
	    	protected void executeCommand() 
	    	throws ConstraintException, SystemException, InterruptedException {
	    		setExecResult( reqBusinessFacade.modelElementReferences( p_requirement, true ) );
	    	}
	    } );
	}

	@Override
	public String languageFileExtension(	final AbstractRequirement p_requirement,
											final String p_languageId ) 
	throws ConstraintValidationException {
		return reqBusinessFacade.languageFileExtension( p_requirement, p_languageId );
	}

	@Override
	public void persistConstraint(	final String p_languageId,
									final String p_resourceId,
									final String p_constraintText )
	throws ConstraintException, SystemException,	InterruptedException {
		reqBusinessFacade.persistConstraint( p_languageId, p_resourceId, p_constraintText );
	}

	@Override
	public String readConstraintText(	final String p_languageId, 
										final String p_resourceId )
	throws SystemException, InterruptedException {
		return reqBusinessFacade.readConstraintText( p_languageId, p_resourceId );
	}


	@Override
	public List<EObject> modelElementsChoice(	final AbstractRequirement p_requirement,
												final RefUserSelectedModelElements p_refModelElement ) {
		final List<ModelElementReference> refs = p_refModelElement.getModelElementReferences(); 
		final ModelElementReference modelRef = refs.isEmpty() ? CoreFactory.eINSTANCE.createModelElementReference() : refs.get( 0 ); 
		final IItemPropertySource propertySource = (IItemPropertySource) defaultAdapterFactory.adapt( (Object) modelRef, IItemPropertySource.class );
		final ModelElementReferenceModelElementPropertyDescriptor propDescriptor = (ModelElementReferenceModelElementPropertyDescriptor) propertySource.getPropertyDescriptor( modelRef,
																																												CorePackage.Literals.MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT );
		final List<EObject> choices = propDescriptor.getChoiceOfValues( p_requirement.getGroup().getSpecification() );
		choices.removeAll( modelElements( p_refModelElement ) );
		
		return choices;
	}

	@Override
	public List<FormalLanguageLibrary> librariesChoice(	final FormalLanguageExpression p_expression )
	throws SystemException, InterruptedException {
		return reqBusinessFacade.librariesChoice( p_expression );
	}
	
	@Override
	protected Map<?, ?> getSaveOptions() {
		return RdalDiagramEditorUtil.getSaveOptions();
	}

	@Override
	public List<EObject> modelElements( final RefUserSelectedModelElements p_refModelElement ) {
		return reqBusinessFacade.modelElements( p_refModelElement );
	}
	
	private IItemLabelProvider itemLabelProvider( final Object p_object ) {
		return (IItemLabelProvider) defaultAdapterFactory.adapt( p_object, IItemLabelProvider.class );
	}
	
	@Override
	public String getText( final Object p_element ) {
		final IItemLabelProvider lblProvider = itemLabelProvider( p_element );
		
		return lblProvider == null ? String.valueOf( p_element ) : lblProvider.getText( p_element );
	}
	
	@Override
	public Object getImage( final Object p_element ) {
		return ExtendedImageRegistry.getInstance().getImage( itemLabelProvider( p_element ).getImage( p_element ) );
	}
}
