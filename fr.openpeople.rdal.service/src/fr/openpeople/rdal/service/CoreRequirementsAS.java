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
package fr.openpeople.rdal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.constraints.core.exception.ConstraintEvaluationException;
import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.constraints.core.exception.ConstraintValidationException;
import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguagesSpecification;
import fr.labsticc.framework.constraints.model.constraints.ConstraintsFactory;
import fr.labsticc.framework.constraints.model.constraints.Expression;
import fr.labsticc.framework.constraints.model.constraints.FormalConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageExpression;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageLibrary;
import fr.labsticc.framework.constraints.model.constraints.NaturalLanguageExpression;
import fr.labsticc.framework.constraints.service.IConstraintServicesFacade;
import fr.labsticc.framework.constraints.service.IConstraintValidationAS;
import fr.labsticc.framework.core.IResourceHandler;
import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.labsticc.framework.core.exception.SystemException;
import fr.labsticc.framework.core.util.FileUtil;
import fr.labsticc.framework.emf.core.object.EMFURIEqualsList;
import fr.labsticc.framework.emf.core.resource.BundleEMFResourceHandler;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.ContractReferencedModelElements;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements;
import fr.openpeople.rdal.model.core.RefUserSelectedModelElements;
import fr.openpeople.rdal.model.core.ReferencedModelElements;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;

public class CoreRequirementsAS {

	private static final String LINE_SEPARATOR = System.getProperty( "line.separator" );

	private final IConstraintValidationAS validator;
	private final IConstraintServicesFacade cstFacade;
	private final IResourceHandler resourcesHandler;

	public CoreRequirementsAS( 	final IConstraintValidationAS p_validator,
								final IConstraintServicesFacade p_cstFacade ) {
		validator = p_validator;
		cstFacade = p_cstFacade;
		resourcesHandler = new BundleEMFResourceHandler();
	}

	Map<String, String> libraries( final FormalLanguageExpression p_constraintExpr ) {
		final Map<String, String> libraries = new LinkedHashMap<String, String>();
		
		for ( final FormalLanguageLibrary library : p_constraintExpr.getUsedLibraries() ) {
			final FormalLanguageExpression expression = library.getExpression();
			
			if ( expression != null ) {
				libraries.put( library.getId(), expression.getText() );
			}
		}
		
		return libraries;
	}

	private List<EObject> modelElements( final Collection<ModelElementReference> p_references ) {
		final List<EObject> context = new EMFURIEqualsList<EObject>();
		
		for ( final ModelElementReference ref : p_references ) {
			context.add( ref.getModelElement() );
		}
		
		return context;
	}

	List<EObject> modelElements( final RefUserSelectedModelElements p_refModelElement ) {
		return modelElements( p_refModelElement.getModelElementReferences() );
	}

	Collection<EObject> modelElements( final AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException {
		final Collection<ModelElementReference> modelElementReferences = modelElementReferences( p_requirement, false );
		
		return modelElements( modelElementReferences );
	}
	
	AbstractRequirement setModelElements( final AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException {
		modelElementReferences( p_requirement, true );
		
		return p_requirement;
	}

	@SuppressWarnings("unchecked")
	Collection<ModelElementReference> modelElementReferences( 	final AbstractRequirement p_requirement,
																final boolean pb_update ) 
	throws SystemException, ConstraintException, InterruptedException {
		final ReferencedModelElements refElements = p_requirement.getSatisfiedBy();
		
		if ( refElements instanceof RefExpressionCollectedModelElements ) {
			final Specification spec = p_requirement.getGroup().getSpecification();
			validateSpecifies( spec );
			
			final FormalLanguageExpression constraintExpr = ( (RefExpressionCollectedModelElements) refElements ).getQueryExpression();
			final Collection<?> results = (Collection<?>) cstFacade.evaluateConstraint( constraintExpr.getLanguage().getId(),
																						constraintExpr.getText(),
																						libraries( constraintExpr ),
																					//	ModelingLevel.M2,
																						false,
																						spec.getSpecifies().toArray() );
			final Collection<ModelElementReference> modelElementReferences = new EMFURIEqualsList<ModelElementReference>(); 
			
			for ( final EObject modelElement : extractModelElements( results ) ) {
				final ModelElementReference reference = CoreFactory.eINSTANCE.createModelElementReference();
				reference.setModelElement( modelElement );
				modelElementReferences.add( reference );
			}
			
			if ( pb_update ) {
				refElements.getModelElementReferences().clear();
				refElements.getModelElementReferences().addAll( modelElementReferences );
			}
			
			return modelElementReferences;
		}

		return refElements == null ? Collections.EMPTY_LIST : refElements.getModelElementReferences();
	}

	AbstractRequirement setConstraintExprLanguage( 	final AbstractRequirement p_requirement,
													final String p_languageId )
	throws SystemException, InterruptedException {
		final Expression cstExpr = p_requirement.getExpression();
		final String currentText;
		
		if ( cstExpr == null ) {
			currentText = null;
		}
		else {
			currentText = cstExpr.getText();
		}
		
		return setConstraintExprText( p_requirement, p_languageId, currentText );
	}

	AbstractRequirement setConstraintExprText( 	final AbstractRequirement p_requirement,
												final String p_languageId,
												final String p_constraintText ) 
	throws SystemException, InterruptedException {
		setConstraintExpression( 	p_requirement, 
									constraintLanguage( p_requirement, p_languageId ), 
									p_constraintText );
		
		return p_requirement;
	}

	private void setConstraintExpression( 	final AbstractRequirement p_requirement,
											final ConstraintLanguage p_language,
											final String p_constraintText ) {
		Expression cstExpr = p_requirement.getExpression();
		
		if ( cstExpr == null ) {
			cstExpr = createExpression( p_language );
			p_requirement.setExpression( cstExpr );
		}
		else {
			if ( p_language instanceof FormalConstraintLanguage ) {
				if ( cstExpr instanceof FormalLanguageExpression ) {
					final FormalLanguageExpression currentExpr = (FormalLanguageExpression) p_requirement.getExpression();
					
					if ( !p_language.equals( currentExpr.getLanguage() ) ) {
						
						// Recreate the expression so that the current libraries are reset with the default ones for the new language.
						cstExpr = createExpression( p_language );
						p_requirement.setExpression( cstExpr );
					}
				}
				else {
					cstExpr = createExpression( p_language );
					p_requirement.setExpression( cstExpr );
				}
			}
			else {
				if ( !( cstExpr instanceof NaturalLanguageExpression ) ) {
					//p_requirement.unsetExpression();
					cstExpr = createExpression( p_language );
					p_requirement.setExpression( cstExpr );
				}
			}
		}
		
		cstExpr.setLanguage( p_language );
		cstExpr.setText( p_constraintText );
	}
	
	private Collection<EObject> extractModelElements( final Collection<?> p_results ) {
		final Collection<EObject> elements = new EMFURIEqualsList<EObject>();
		
		if ( !p_results.isEmpty() ) {
			for ( final Object result : p_results ) {
				if ( result instanceof EObject ) {
					elements.add( (EObject) result );
				}
				else if ( result instanceof Collection<?> ) {
					elements.addAll( extractModelElements( (Collection<?>) result ) );
				}
			}
		}
		
		return elements;
	}
	
	AbstractRequirement setModelElements( 	final AbstractRequirement p_requirement, 
											final Collection<EObject> p_selectedElements ) 
	throws SystemException, InterruptedException {
		final Collection<ModelElementReference> refs = new ArrayList<ModelElementReference>();
		
		for ( final EObject eObject : p_selectedElements ) {
			final ModelElementReference modelRef = CoreFactory.eINSTANCE.createModelElementReference();
			modelRef.setModelElement( eObject );
			refs.add( modelRef );
		}
		
		return setReferencedModelElements( p_requirement, refs );
	}

	AbstractRequirement setReferencedModelElements( final AbstractRequirement p_requirement,
													final Collection<ModelElementReference> p_modelElemRefs ) 
	throws SystemException, InterruptedException {
		ContractReferencedModelElements curRefModelElement = p_requirement.getSatisfiedBy();
		
		if ( !( curRefModelElement instanceof RefUserSelectedModelElements ) ) {
			curRefModelElement = CoreFactory.eINSTANCE.createRefUserSelectedModelElements();
			p_requirement.setSatisfiedBy( curRefModelElement );
		}
		
		// Updates the elements
		final RefUserSelectedModelElements newElement = (RefUserSelectedModelElements) p_requirement.getSatisfiedBy();
		newElement.getModelElementReferences().clear();
		newElement.getModelElementReferences().addAll( p_modelElemRefs );
		
		return p_requirement;
	}

	AbstractRequirement setReferencedModelElements( final AbstractRequirement p_requirement,
													final String p_languageId,
													final String p_queryText ) 
	throws SystemException, InterruptedException {
		final RefExpressionCollectedModelElements exprRefModelElement;
		final FormalLanguageExpression expression;
	
		if ( p_requirement.getSatisfiedBy() instanceof RefExpressionCollectedModelElements ) {
			exprRefModelElement = (RefExpressionCollectedModelElements) p_requirement.getSatisfiedBy();
			expression = exprRefModelElement.getQueryExpression();
			
			if ( expression.getLanguage() == null || !p_languageId.equals( expression.getLanguage().getId() ) ) {
				expression.setLanguage( constraintLanguage( p_requirement, p_languageId ) );
				setDefaultLibraries( expression );
			}
		}
		else {
			exprRefModelElement = CoreFactory.eINSTANCE.createRefExpressionCollectedModelElements();
			expression = createFormalLanguageExpression( (FormalConstraintLanguage) constraintLanguage( p_requirement, p_languageId ) );
			expression.setLanguage( constraintLanguage( p_requirement, p_languageId ) );
			exprRefModelElement.setQueryExpression( expression );
			p_requirement.setSatisfiedBy( exprRefModelElement );
		}
		
		expression.setText( p_queryText );
		
		return p_requirement;
	}

	AbstractRequirement setRefModelElementsConstraintExprText( 	final AbstractRequirement p_requirement,
																final String p_languageId,
																final String p_constraintText ) 
	throws SystemException, InterruptedException {
		final ConstraintLanguage language = constraintLanguage( p_requirement, p_languageId );
		final RefExpressionCollectedModelElements refModelElements = (RefExpressionCollectedModelElements) p_requirement.getSatisfiedBy(); 
		FormalLanguageExpression cstExpr = refModelElements.getQueryExpression();
		
		if ( cstExpr == null ) {
			cstExpr = ( FormalLanguageExpression) createExpression( language );
			refModelElements.setQueryExpression( cstExpr );
		}
		
		cstExpr.setLanguage( language );
		cstExpr.setText( p_constraintText );
		
		return p_requirement; 
	}
	
	ConstraintLanguage constraintLanguage( 	final AbstractRequirement p_requirement,
											final String p_languageId ) {
		if ( p_languageId != null ) {
			for ( final ConstraintLanguage language : definedLanguages( p_requirement ) ) {
				if ( p_languageId.equals( language.getId() ) ) {
					return language;
				}
			}
		}
		
		return null;
	}

	AbstractRequirement deleteRefModelElementsLibraries(	final AbstractRequirement p_requirement,
															final Collection<String> p_libraryIds ) 
    throws SystemException, InterruptedException {
		final FormalLanguageExpression expression = ( (RefExpressionCollectedModelElements) p_requirement.getSatisfiedBy() ).getQueryExpression();
		deleteLibraries( expression, p_libraryIds );
		
		return p_requirement;
	}
	
	Collection<ConstraintLanguage> definedLanguages( final AbstractRequirement p_requirement ) {
		if ( p_requirement == null ) {
			return Collections.emptyList();
		}
		
		final RequirementsGroup group = p_requirement.getGroup();
		assert group != null : "A requirement should always be contained in a requirements group.";
		
		final Specification reqSpec = group.getSpecification();
		assert reqSpec != null : "A requirement group should always be contained in a specification.";
		
		final ConstraintLanguagesSpecification langSpec = reqSpec.getConstraintLanguagesSpecification();
		assert langSpec != null : "A requirements specification should always have a constraint languages specification.";

		return langSpec.getLanguages();
	}

	AbstractRequirement refreshLibraries(	final AbstractRequirement p_requirement,
											final Collection<String> p_libraryIds ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		final FormalLanguageExpression expression = (FormalLanguageExpression) p_requirement.getExpression();

		for ( final String libraryId : p_libraryIds ) {
			try {
				setLibraryText( expression, libraryId, libraryContent( libraryId ) );
			}
			catch ( final IOException p_ex ) {
				throw new ResourceAccessException( p_ex );
			}
		}
		
		return p_requirement;
	}
	
	private String libraryContent( final String p_libraryId ) 
	throws IOException, ResourceAccessException {
		String location = resourcesHandler.locateResource( p_libraryId );
		
		if ( location == null ) {
			location = p_libraryId;
		}
		
		return FileUtil.getFileContent( location );
	}

	AbstractRequirement refreshRefModelElementsLibraries(	final AbstractRequirement p_requirement,
															final Collection<String> p_libraryIds ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		for ( final String libraryId : p_libraryIds ) {
			try {
				setLibraryText( ( (RefExpressionCollectedModelElements) p_requirement.getSatisfiedBy() ).getQueryExpression(), 
								libraryId, 
								libraryContent( libraryId ) );
			}
			catch ( final IOException p_ex ) {
				throw new ResourceAccessException( p_ex );
			}
		}
		
		return p_requirement;
	}
	
	AbstractRequirement deleteLibraries(	final AbstractRequirement p_requirement,
											final Collection<String> p_libraryIds ) 
    throws SystemException, InterruptedException {
		deleteLibraries( (FormalLanguageExpression) p_requirement.getExpression(), p_libraryIds );

		return p_requirement;
	}
	
	private boolean deleteLibrary( 	final FormalLanguageExpression p_expression,
									final String p_libraryId ) {
		for ( final FormalLanguageLibrary library : p_expression.getUsedLibraries() ) {
			if ( p_libraryId.equals( library.getId() ) ) {
				p_expression.getUsedLibraries().remove( library );
				
				return true;
			}
		}
		
		return false;
	}
	
	private void deleteLibraries(	final FormalLanguageExpression p_expression,
									final Collection<String> p_libraryIds ) {
		for ( final String libraryId : p_libraryIds ) {
			deleteLibrary( p_expression, libraryId );
		}
		
		// Clean bad libraries due to constraint model change.
		for ( final FormalLanguageLibrary library : new ArrayList<FormalLanguageLibrary>( p_expression.getUsedLibraries() ) ) {
			if ( library.getExpression() == null ) {
				p_expression.getUsedLibraries().remove( library );
			}
		}
	}
	
	AbstractRequirement setExpressionLibraries( final AbstractRequirement p_requirement,
												final Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		setExpressionLibraries( (FormalLanguageExpression) p_requirement.getExpression(), p_libraries );
		
		return p_requirement;
	}
	
	AbstractRequirement setRefModelElementsLibraries( 	final AbstractRequirement p_requirement,
														final Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		validator.validate( CorePackage.REQUIREMENT__SATISFIED_BY, false, p_requirement );
		
		setExpressionLibraries( ( (RefExpressionCollectedModelElements) p_requirement.getSatisfiedBy() ).getQueryExpression(), p_libraries );
		
		return p_requirement;
	}
	
	private void setExpressionLibraries( 	final FormalLanguageExpression p_expression,
											final Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		validate( p_expression, false );
		
		p_expression.getUsedLibraries().addAll( p_libraries );
	}

	private boolean setLibraryText( final FormalLanguageExpression p_expression,
									final String p_libraryId,
									final String p_libraryText ) 
	throws SystemException {
		final FormalLanguageLibrary library = findLibrary( p_expression, p_libraryId );
		
		if ( library == null ) {
			return false;
		}

		library.getExpression().setText( p_libraryText );
		
		// Invalidates the library cache.
		cstFacade.libraryContentChanged( p_expression.getLanguage().getId(), library.getId() );
				
		return true;
	}
	
	private Expression createExpression( final ConstraintLanguage p_language ) {
		final Expression cstExpr;
		
		if ( p_language instanceof FormalConstraintLanguage ) {
			cstExpr = createFormalLanguageExpression( (FormalConstraintLanguage) p_language );
		}
		else {
			cstExpr = ConstraintsFactory.eINSTANCE.createNaturalLanguageExpression();
		}
		
		return cstExpr;
	}
	
	private FormalLanguageExpression createFormalLanguageExpression( final FormalConstraintLanguage p_language ) {
		final FormalLanguageExpression expression = ConstraintsFactory.eINSTANCE.createFormalLanguageExpression();
		expression.setLanguage( p_language );
		
		setDefaultLibraries( expression );
		
		return expression;
	}
	
	private void setDefaultLibraries( final FormalLanguageExpression p_expression ) {
		p_expression.getUsedLibraries().clear();
		
		if ( p_expression.getLanguage() != null ) {
			for ( final FormalLanguageLibrary library : ((FormalConstraintLanguage) p_expression.getLanguage() ).getLibraries() ) {
				if ( library.isDefault() ) {
					p_expression.getUsedLibraries().add( library );
				}
			}
		}
	}
	
	private FormalLanguageLibrary findLibrary( 	final FormalLanguageExpression p_expression,
												final String p_libraryId ) {
		final ConstraintLanguage expressionLanguage = p_expression.getLanguage();

		for ( final FormalLanguageLibrary library : ( (FormalConstraintLanguage) expressionLanguage ).getLibraries() ) {
			if ( p_libraryId.equals( library.getId() ) ) {
				return library;
			}
		}
		
		return null;
	}
	
	void validate( 	final EObject p_object,
					final boolean pb_validateDependencies ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		validator.validate( p_object );
		
		if ( pb_validateDependencies && p_object instanceof AbstractRequirement ) {
			// Default validation does not validate all dependencies
			for ( final AbstractRequirement requirement : dependencies( (AbstractRequirement) p_object ) ) {
				validate( requirement, pb_validateDependencies );
			}
		}
	}
	
	void validateSpecifies( final Specification p_specification ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		validator.validate( CorePackage.SPECIFICATION__SPECIFIES, false, p_specification );
//		if ( p_specification.getSpecifies().isEmpty() ) {
//			throw new ConstraintValidationException( "The requirements specification must specify at least one design specification" );
//		}
	}
	
	String evaluateConstraintAsString( final AbstractRequirement p_requirement )
	throws ConstraintException, SystemException, InterruptedException {
		final Collection<String> results = evaluateConstraintAsStringCollection( p_requirement, false );
		final StringBuffer resultsBuffer = new StringBuffer();
		
		for ( final Iterator<String> resIt = results.iterator(); resIt.hasNext(); ) {
			resultsBuffer.append( resIt.next() );
			
			if ( resIt.hasNext() ) {
				resultsBuffer.append( LINE_SEPARATOR );
			}
		}
		
		return resultsBuffer.toString();
	}
	
	protected Collection<String> evaluateConstraintAsStringCollection( 	final AbstractRequirement p_requirement,
																		final boolean pb_update )
	throws ConstraintException, SystemException, InterruptedException {
		final AbstractRequirement updRequirement;
		final Collection<EObject> modelElements;

		if ( pb_update ) {
			updRequirement = setModelElements( p_requirement );
			modelElements = modelElements( updRequirement.getSatisfiedBy().getModelElementReferences() );
		}
		else {
			updRequirement = p_requirement;
			modelElements = modelElements( p_requirement );
		}
		
		return evaluateConstraintAsStringCollection( updRequirement, modelElements );
	}

	@SuppressWarnings("unchecked")
	protected Collection<String> evaluateConstraintAsStringCollection( 	final AbstractRequirement p_requirement,
																		final Collection<EObject> p_context )
	throws ConstraintException, SystemException, InterruptedException {
		validate( p_requirement, false );

		final FormalLanguageExpression constraintExpr = (FormalLanguageExpression) p_requirement.getExpression();
		
		return (Collection<String>) cstFacade.evaluateConstraint( 	constraintExpr.getLanguage().getId(),
																	constraintExpr.getText(),
																	libraries( constraintExpr ),
																//	ModelingLevel.M2,
																	true,
																	p_context.toArray() );
	}
	
	protected Collection<Boolean> evaluateInvariant( 	final AbstractRequirement p_requirement,
														final boolean pb_update )
	throws ConstraintException, SystemException, InterruptedException {
		final AbstractRequirement updRequirement;
		final Collection<EObject> modelElements;

		if ( pb_update ) {
			updRequirement = setModelElements( p_requirement );
			modelElements = modelElements( updRequirement.getSatisfiedBy().getModelElementReferences() );
		}
		else {
			updRequirement = p_requirement;
			modelElements = modelElements( p_requirement );
		}
		
		return evaluateInvariant( updRequirement, modelElements );
	}

	protected Collection<Boolean> evaluateInvariant( 	final AbstractRequirement p_requirement,
														final Collection<EObject> p_context )
	throws ConstraintException, SystemException, InterruptedException {
		validate( p_requirement, false );

		final FormalLanguageExpression formalCstExpr = (FormalLanguageExpression) p_requirement.getExpression(); 

		return cstFacade.evaluateInvariant( formalCstExpr.getLanguage().getId(),
											formalCstExpr.getText(),
											libraries( formalCstExpr ),
											p_context.toArray() );
	}

	@SuppressWarnings("unchecked")
	AbstractRequirement evaluateConstraint( final AbstractRequirement p_requirement,
											final boolean pb_handleEvalException,
											final Collection<EObject> p_context )
	throws ConstraintException,	SystemException, InterruptedException {
		validate( p_requirement, false );
		
		@SuppressWarnings("rawtypes")
		final Collection results;

		// Constraints can still be evaluated for natural language expression requirements because 
		// possible requirements dependencies.
		if ( p_requirement.getExpression() instanceof FormalLanguageExpression ) {
			if ( pb_handleEvalException ) {
				results = new ArrayList<Object>();
			
				for ( final EObject contextElem : p_context ) {
					try {
						results.add( evaluateInvariant( p_requirement, Arrays.asList( contextElem ) ).iterator().next() );
					}
					catch ( final ConstraintEvaluationException p_ex ) {
						results.add( p_ex.getLocalizedMessage() );
					}
				}
			}
			else {
				results = evaluateInvariant( p_requirement, p_context );
			}
		}
		else {
			results = new ArrayList<Object>();
		}
		
		return buildConstraintEvalResults( p_requirement, results );
	}
	
	AbstractRequirement evaluateConstraint( final AbstractRequirement p_requirement )
	throws ConstraintException,	SystemException, InterruptedException {
		return buildConstraintEvalResults( p_requirement, evaluateInvariant( p_requirement, true ) );
	}
	
	private AbstractRequirement buildConstraintEvalResults( final AbstractRequirement p_requirement,
															final Collection<?> p_results ) 
	throws ConstraintEvaluationException, SystemException { 
		final Collection<ModelElementReference> modelElements = p_requirement.getSatisfiedBy().getModelElementReferences();
		int nbVerified = 0;
		int nbModelElementsTotal = 0;
		
		if ( p_requirement.getExpression() instanceof FormalLanguageExpression ) {
			assert p_results.size() == modelElements.size() : "Constraint did not return the same number of results as there are context elements.";

			nbModelElementsTotal += modelElements.size();
		}
		
		final Iterator<ModelElementReference> modelElemRefIt = modelElements.iterator();
		
		for ( final Object result : p_results ) {
			final ModelElementReference modelRef = modelElemRefIt.next();
			
			if ( result instanceof Boolean ) {
				modelRef.setVerifies( (Boolean) result );
				modelRef.setReason( null );
				
				if ( modelRef.getVerifies() ) {
					nbVerified++;
				}
			}
			else {
				modelRef.setVerifies( Boolean.FALSE );
				
				if ( result != null ) {
					modelRef.setReason( result.toString() );
				}
			}
		}
		
		// Assume requirements are already evaluated (traversed in appropriate order)
		for ( final AbstractRequirement depRequirement : dependencies( p_requirement ) ) {
			final int nbModelElements = depRequirement.getSatisfiedBy().getModelElementReferences().size();
			nbModelElementsTotal += nbModelElements;

			if ( depRequirement.getSatisfactionLevel() != null ) {
				final Float satifactionLevel = depRequirement.getSatisfactionLevel();
				
				if ( satifactionLevel != null ) {
					nbVerified += satifactionLevel * nbModelElements; 
				}
			}
		}
		
		p_requirement.setSatisfactionLevel( (float) nbVerified / nbModelElementsTotal );
		
		return p_requirement;
	}
	
	private Collection<AbstractRequirement> dependencies( final AbstractRequirement p_requirement ) {
		final Collection<AbstractRequirement> dependencies = new HashSet<AbstractRequirement>();
		dependencies.addAll( p_requirement.getContainedRequirements() );
		// A derived requirement not verified does not mean that the source requirement is not verified.
		//dependencies.addAll( p_requirement.getDerivations() );
		
		return dependencies;
	}

	List<FormalLanguageLibrary> librariesChoice( final FormalLanguageExpression p_expression )
	throws SystemException, InterruptedException {
		final List<FormalLanguageLibrary> choice = new ArrayList<FormalLanguageLibrary>( ( (FormalConstraintLanguage) p_expression.getLanguage() ).getLibraries() );
		choice.removeAll( p_expression.getUsedLibraries() );
		
		return choice;
	}
}
