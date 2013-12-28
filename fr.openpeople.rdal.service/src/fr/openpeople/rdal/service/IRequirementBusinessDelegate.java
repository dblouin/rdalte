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

import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.constraints.core.ICompletionProposal;
import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.constraints.core.exception.ConstraintValidationException;
import fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageExpression;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageLibrary;
import fr.labsticc.framework.core.exception.SystemException;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RefUserSelectedModelElements;

public interface IRequirementBusinessDelegate {

	String evaluateConstraintAsString( 	AbstractRequirement p_requirement ) 
	throws ConstraintException, SystemException, InterruptedException;

	AbstractRequirement evaluateConstraint( final AbstractRequirement p_requirement )
	throws ConstraintException,	SystemException, InterruptedException;
	
	AbstractRequirement evaluateConstraint( AbstractRequirement p_requirement,
											Collection<EObject> p_context ) 
	throws ConstraintException, SystemException, InterruptedException;

	List<ICompletionProposal> computeCompletionProposals( 	AbstractRequirement p_requirement,
															String p_constraintText )
	throws ConstraintException, SystemException, InterruptedException;
	
	List<ICompletionProposal> computeRefElementsCompletionProposals( 	AbstractRequirement p_requirement,
																		String p_constraintText )
	throws ConstraintException, SystemException, InterruptedException;

	String readConstraintText( 	String p_languageId,
								String p_resourceId ) 
	throws SystemException, InterruptedException;

	void persistConstraint( String p_languageId,
							String p_resourceId,
							String p_constraintText ) 
	throws ConstraintException, SystemException, InterruptedException;
	
	AbstractRequirement setExpressionLibraries( AbstractRequirement p_requirement,
												Collection<FormalLanguageLibrary> p_libraries )
	throws ConstraintValidationException, SystemException, InterruptedException;

	AbstractRequirement setRefModelElementsLibraries( 	AbstractRequirement p_requirement,
														Collection<FormalLanguageLibrary> p_libraries ) 
	throws ConstraintValidationException, SystemException, InterruptedException;
	
	AbstractRequirement refreshLibraries( 	AbstractRequirement p_requirement, 
											Collection<String> p_libraryIds )
	throws ConstraintValidationException, SystemException, InterruptedException;
	
	AbstractRequirement refreshRefModelElementsLibraries( 	AbstractRequirement p_requirement, 
															Collection<String> p_libraryIds )
	throws ConstraintValidationException, SystemException, InterruptedException;

	AbstractRequirement deleteLibraries( 	AbstractRequirement p_requirement, 
											Collection<String> p_libraryIds )
    throws SystemException, InterruptedException;
	
	AbstractRequirement deleteRefModelElementsLibraries(	AbstractRequirement p_requirement,
															Collection<String> p_libraryIds ) 
    throws SystemException, InterruptedException;

	AbstractRequirement setConstraintExprText( 	AbstractRequirement p_requirement,
												String p_languageId,
												String p_constraintText )
	throws SystemException, InterruptedException;

	AbstractRequirement setConstraintExprLanguage( 	AbstractRequirement p_requirement,
													String p_languageId )
	throws SystemException, InterruptedException;
	
	Collection<ConstraintLanguage> definedLanguages( AbstractRequirement p_requirement );

	ConstraintLanguage constraintLanguage( 	AbstractRequirement p_requirement,
											String p_languageId );

	String languageFileExtension( 	AbstractRequirement p_requirement,
									String p_languageId )
	throws ConstraintValidationException;
	
    /**
     * Returns the image for the label of the given element.  The image
     * is owned by the label provider and must not be disposed directly.
     * Instead, dispose the label provider when no longer needed.
     *
     * @param p_element the element for which to provide the label image
     * @return the image used to label the element, or <code>null</code>
     *   if there is no image for the given object
     */
    Object getImage( Object p_element );

    /**
     * Returns the text for the label of the given element.
     *
     * @param p_element the element for which to provide the label text
     * @return the text string used to label the element, or <code>null</code>
     *   if there is no text label for the given object
     */
    String getText( Object p_element );

    /**
     * Sets the actual model elements that should satisfy the requirement.
     * @param p_requirement
     * @param p_selectedElements
     * @return
     * @throws SystemException
     * @throws InterruptedException
     */
    AbstractRequirement setModelElements( 	AbstractRequirement p_requirement, 
											Collection<EObject> p_selectedElements )
    throws SystemException, InterruptedException;

    /**
     * Sets the requirements "satisfiedBy" feature as an expression collected referenced
     * model elements for the given language and query text.
     * @param p_requirement
     * @param p_languageId
     * @param p_queryText
     * @return
     * @throws SystemException
     * @throws InterruptedException
     */
    AbstractRequirement setReferencedModelElements( AbstractRequirement p_requirement, 
													String p_languageId,
													String p_queryText )
    throws SystemException, InterruptedException;

	/**
	 * Sets the text of the "satisfiedBy" feature expression collected referenced model elements
	 * object.
	 * @param p_requirement
	 * @param p_languageId
	 * @param p_constraintText
	 * @return
	 * @throws SystemException
	 * @throws InterruptedException
	 */
	AbstractRequirement setRefModelElementsConstraintExprText( 	AbstractRequirement p_requirement,
																String p_languageId,
																String p_constraintText ) 
	throws SystemException, InterruptedException;

    /**
     * Sets the collection of model elements references of the collection ref model elements
     * of the satisfiedBy feature.
     * @param p_requirement
     * @param p_modelElementRefs
     * @return
     * @throws SystemException
     * @throws InterruptedException
     */
    AbstractRequirement setReferencedModelElements( AbstractRequirement p_requirement, 
													Collection<ModelElementReference> p_modelElementRefs )
    throws SystemException, InterruptedException;

	
	/**
	 * Extracts the model element references from the referenced model elements object. May imply
	 * query evaluation in case of expression collected referenced model elements.
	 * @param p_refModelElement
	 * @return
	 */
	Collection<ModelElementReference> modelElementReferences( AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException;

	/**
	 * Calculates the model elements available for the satisfiedBy relation of a requirement. Takes into
	 * account the elements that have already been set for the requirement.
	 * @param p_refModelElement
	 * @return
	 */
	List<EObject> modelElementsChoice( 	AbstractRequirement p_requirement,
										RefUserSelectedModelElements p_refModelElement );

	List<FormalLanguageLibrary> librariesChoice( FormalLanguageExpression p_expression )
	throws SystemException, InterruptedException;
	
	/**
	 * Extracts the model elements from the referenced model elements object.
	 * @param p_refModelElement
	 * @return
	 */
	List<EObject> modelElements( RefUserSelectedModelElements p_refModelElement );

	/**
	 * Returns the model elements that should satisfy this requirement. May include evaluating
	 * the query in case of expression collected references.
	 * @param p_requirement
	 * @return
	 * @throws SystemException
	 * @throws ConstraintException
	 * @throws InterruptedException
	 */
	Collection<EObject> modelElements( AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException;

	/**
	 * Sets the referenced model elements into the specified requirement.  May include evaluating
	 * the query in case of expression collected references.
	 * @param p_requirement
	 * @return
	 * @throws SystemException
	 * @throws ConstraintException
	 * @throws InterruptedException
	 */
	AbstractRequirement setModelElements( AbstractRequirement p_requirement )
	throws SystemException, ConstraintException, InterruptedException;
	
	AbstractRequirement setDescriptionText( AbstractRequirement p_requirement,
											String p_descriptionText )
	throws SystemException, InterruptedException;
}
