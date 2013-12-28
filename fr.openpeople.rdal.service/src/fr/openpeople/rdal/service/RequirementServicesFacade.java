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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.constraints.core.ICompletionProposal;
import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.constraints.core.exception.ConstraintValidationException;
import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageExpression;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageLibrary;
import fr.labsticc.framework.constraints.service.DefaultConstraintServicesFacade;
import fr.labsticc.framework.constraints.service.IConstraintInterpretationAS;
import fr.labsticc.framework.constraints.service.IConstraintPersistenceAS;
import fr.labsticc.framework.constraints.service.IConstraintServicesFacade;
import fr.labsticc.framework.constraints.service.IConstraintValidationAS;
import fr.labsticc.framework.core.exception.SystemException;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements;
import fr.openpeople.rdal.model.core.RefUserSelectedModelElements;
import fr.openpeople.rdal.model.core.Specification;

public class RequirementServicesFacade {
	
	private final IConstraintServicesFacade cstFacade;
	
	private final CoreRequirementsAS requirementAS;
	
	public RequirementServicesFacade( 	final Map<String, IConstraintInterpretationAS> p_interpreters,
										final Map<String, IConstraintPersistenceAS> p_persistenceServices,
										final IConstraintValidationAS p_validationService ) {
		cstFacade = new DefaultConstraintServicesFacade( p_interpreters, p_persistenceServices );
		requirementAS = new CoreRequirementsAS( p_validationService, cstFacade );
	}

	public List<ICompletionProposal> computeCompletionProposals( 	final AbstractRequirement p_requirement,
																	final String p_constraintText )
	throws ConstraintException, SystemException, InterruptedException {
		requirementAS.validate( p_requirement, false );
		
		final FormalLanguageExpression constraintExpr = (FormalLanguageExpression) p_requirement.getExpression();

		return cstFacade.computeCompletionProposals( 	constraintExpr.getLanguage().getId(),
														p_constraintText, // Partial text depending on cursor position
														requirementAS.libraries( constraintExpr ),
														requirementAS.modelElements( p_requirement ).toArray() );
	}
	
	public void persistConstraint(	final String p_languageId, 
									final String p_resourceId,
									final String p_constraintText )
	throws ConstraintException, SystemException,	InterruptedException {
		cstFacade.persistConstraint( p_languageId, p_resourceId, p_constraintText );
	}
	
	public String readConstraintText( 	final String p_languageId,
										final String p_resourceId ) 
	throws SystemException,	InterruptedException {
		return cstFacade.readConstraintText( p_languageId, p_resourceId );
	}
	
	public String evaluateConstraintAsString( final AbstractRequirement p_requirement )
	throws ConstraintException, SystemException, InterruptedException {
		return requirementAS.evaluateConstraintAsString( p_requirement );
	}
	
	public AbstractRequirement evaluateConstraint( final AbstractRequirement p_requirement )
	throws ConstraintException,	SystemException, InterruptedException {
		return requirementAS.evaluateConstraint( p_requirement );
	}

	public AbstractRequirement evaluateConstraint( 	final AbstractRequirement p_requirement,
													final boolean pb_handleEvalException,
													final Collection<EObject> p_context ) 
	throws ConstraintException, SystemException, InterruptedException {
		return requirementAS.evaluateConstraint( p_requirement, pb_handleEvalException, p_context );
	}
	
	public AbstractRequirement setExpressionLibraries( 	final AbstractRequirement p_requirement,
														final Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		return requirementAS.setExpressionLibraries( p_requirement, p_libraries );
	}
	
	public AbstractRequirement setRefModelElementsLibraries( 	final AbstractRequirement p_requirement,
																final Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		return requirementAS.setRefModelElementsLibraries( p_requirement, p_libraries );
	}

	public AbstractRequirement setConstraintExprText( 	final AbstractRequirement p_requirement,
														final String p_languageId,
														final String p_constraintText ) 
	throws SystemException, InterruptedException{
		return requirementAS.setConstraintExprText( p_requirement, p_languageId, p_constraintText );
	}

	public AbstractRequirement setConstraintExprLanguage( 	final AbstractRequirement p_requirement,
															final String p_languageId ) 
	throws SystemException, InterruptedException{
		return requirementAS.setConstraintExprLanguage( p_requirement, p_languageId );
	}

	public AbstractRequirement setRefModelElementsConstraintExprText( 	final AbstractRequirement p_requirement,
																		final String p_languageId,
																		final String p_constraintText ) 
	throws SystemException, InterruptedException {
		return requirementAS.setRefModelElementsConstraintExprText( p_requirement, p_languageId, p_constraintText ); 
	}

	public AbstractRequirement deleteLibraries(	final AbstractRequirement p_requirement,
												final Collection<String> p_libraryIds ) 
    throws SystemException, InterruptedException {
		return requirementAS.deleteLibraries( p_requirement, p_libraryIds );
	}

	public AbstractRequirement deleteRefModelElementsLibraries(	final AbstractRequirement p_requirement,
																final Collection<String> p_libraryIds ) 
    throws SystemException, InterruptedException {
		return requirementAS.deleteRefModelElementsLibraries( p_requirement, p_libraryIds );
	}

	public AbstractRequirement refreshLibraries(	final AbstractRequirement p_requirement,
													final Collection<String> p_libraryIds ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		return requirementAS.refreshLibraries( p_requirement, p_libraryIds );
	}

	public AbstractRequirement refreshRefModelElementsLibraries(	final AbstractRequirement p_requirement,
																	final Collection<String> p_libraryIds ) 
	throws ConstraintValidationException, SystemException, InterruptedException {
		return requirementAS.refreshRefModelElementsLibraries( p_requirement, p_libraryIds );
	}
	
	public Collection<ConstraintLanguage> definedLanguages( final AbstractRequirement p_requirement ) {
		return requirementAS.definedLanguages( p_requirement );
	}
	
	public ConstraintLanguage constraintLanguage( 	final AbstractRequirement p_requirement,
													final String p_languageId ) {
		return requirementAS.constraintLanguage( p_requirement, p_languageId );
	}

	public List<ICompletionProposal> computeRefElementsCompletionProposals( final AbstractRequirement p_requirement ,
																			final String p_constraintText ) 
	throws ConstraintException,	SystemException, InterruptedException {
		final Specification spec = p_requirement.getGroup().getSpecification();
		requirementAS.validateSpecifies( spec );
		
		final FormalLanguageExpression constraintExpr = ( (RefExpressionCollectedModelElements) p_requirement.getSatisfiedBy() ).getQueryExpression();
		
		return cstFacade.computeCompletionProposals( 	constraintExpr.getLanguage().getId(),
														p_constraintText,
														requirementAS.libraries( constraintExpr ),
													//	ModelingLevel.M2,
														spec.getSpecifies().toArray() );
	}
	
	public  String languageFileExtension( 	final AbstractRequirement p_requirement,
											final String p_languageId ) 
	throws ConstraintValidationException {
		if ( p_languageId == null ) {
			throw new ConstraintValidationException( "Constraint language not set." );
		}
		
		final ConstraintLanguage language = constraintLanguage( p_requirement, p_languageId );
		
		return "*." + language.getName().toLowerCase();
	}
	
	public AbstractRequirement setModelElements( 	final AbstractRequirement p_requirement, 
													final Collection<EObject> p_selectedElements ) 
	throws SystemException, InterruptedException {
		return requirementAS.setModelElements( p_requirement, p_selectedElements );
	}

	public AbstractRequirement setReferencedModelElements( 	final AbstractRequirement p_requirement,
															final String p_languageId,
															final String p_queryText ) 
	throws SystemException, InterruptedException {
		return requirementAS.setReferencedModelElements( p_requirement, p_languageId, p_queryText );
	}

	public AbstractRequirement setReferencedModelElements( 	final AbstractRequirement p_requirement,
															final Collection<ModelElementReference> p_modelElementRefs ) 
	throws SystemException, InterruptedException {
		return requirementAS.setReferencedModelElements( p_requirement, p_modelElementRefs );
	}

	public List<EObject> modelElements( final RefUserSelectedModelElements p_refModelElement ) {
		return requirementAS.modelElements( p_refModelElement );
	}

	public Collection<EObject> modelElements( final AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException {
		return requirementAS.modelElements( p_requirement );
	}

	public AbstractRequirement setModelElements( final AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException {
		return requirementAS.setModelElements( p_requirement );
	}

	public Collection<ModelElementReference> modelElementReferences( 	final AbstractRequirement p_requirement,
																		final boolean pb_update )
	throws SystemException, ConstraintException, InterruptedException {
		return requirementAS.modelElementReferences( p_requirement, pb_update );
	}

	public List<FormalLanguageLibrary> librariesChoice(	final FormalLanguageExpression p_expression )
	throws SystemException, InterruptedException {
		return requirementAS.librariesChoice( p_expression );
	}
}
