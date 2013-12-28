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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.labsticc.framework.core.exception.SystemException;
import fr.labsticc.framework.emf.core.object.EMFURIEqualsList;
import fr.labsticc.framework.emf.core.util.EMFUtil;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.IdentifiedElement;
import fr.openpeople.rdal.model.core.ModelElementReference;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.Trace;
import fr.openpeople.rdal.model.core.TraceModelElementReference;

public class RequirementsTracabilityAS {
	
	private final IRequirementBusinessDelegate requirementDelegate;
	private final Collection<? extends EClassifier> supportedSatisfyingTypes;
	private final Collection<? extends EClassifier> supportedSatisfyingTypesInclContainers;
	
	public RequirementsTracabilityAS( 	final IRequirementBusinessDelegate p_requirementDelegate,
										final Collection<? extends EClassifier> p_supportedSatisfyingTypes,
										final Collection<? extends EClassifier> p_supportedSatisfyingTypesInclContainers ) {
		requirementDelegate = p_requirementDelegate;
		supportedSatisfyingTypes = p_supportedSatisfyingTypes;
		supportedSatisfyingTypesInclContainers = p_supportedSatisfyingTypesInclContainers;
	}

	@SuppressWarnings("unchecked")
	<T extends IdentifiedElement> Collection<T> satisfiableNodes( 	final EObject p_designElement,
																	final Collection<Specification> p_availableSpecs,
																	final Class<? extends T> p_rootType,
																	boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException {
		final Collection<EObject> designElements = designElements( p_designElement, pb_recursive );

		if ( p_rootType.isAssignableFrom( Specification.class ) ) {
			return (Collection<T>) satisfiableSpecs( designElements, p_availableSpecs );
		}

		if ( p_rootType.isAssignableFrom( RequirementsGroup.class ) ) {
			final Set<RequirementsGroup> elements = new HashSet<RequirementsGroup>();

			for ( final Specification spec : satisfiableNodes( p_designElement, p_availableSpecs, Specification.class, pb_recursive ) ) {
				elements.addAll( satisfiableRequirementGroups( designElements, spec ) );
			}
			
			return (Collection<T>) elements;
		}

		if ( p_rootType.isAssignableFrom( AbstractRequirement.class ) ) {
			// Find all requirements having a context including one or several of the design 
			// element candidates and evaluate their attached constraints.
			final Set<AbstractRequirement> elements = new HashSet<AbstractRequirement>();

			for ( final RequirementsGroup reqGroup : satisfiableNodes( p_designElement, p_availableSpecs, RequirementsGroup.class, pb_recursive ) ) {
				elements.addAll( satisfiableRequirements( designElements, reqGroup ) );
			}
			
			return (Collection<T>) elements;
		}
		
		throw new IllegalArgumentException();
	}

	Collection<Specification> satisfiableSpecs( final Collection<EObject> p_designElements,
												final Collection<Specification> p_specifications )
	throws ConstraintException, SystemException, InterruptedException {
		final Set<Specification> satSpecs = new HashSet<Specification>();
		
		for ( final Specification spec : p_specifications ) {
			if ( !satisfiableRequirementGroups( p_designElements, spec ).isEmpty() ) {
				satSpecs.add( spec );
			}
		}
		
		return satSpecs;
	}

	<T extends IdentifiedElement> Collection<? extends IdentifiedElement> satisfiableNodes(	final EObject p_designElement, 
																							final T p_parentNode, 
																							final boolean pb_recursive )
	throws ConstraintException, SystemException, InterruptedException {
		final Collection<EObject> designElements = designElements( p_designElement, pb_recursive );

		if ( p_parentNode instanceof Specification ) {
			return satisfiableRequirementGroups( designElements, (Specification) p_parentNode );
		}

		if ( p_parentNode instanceof RequirementsGroup ) {
			return satisfiableRequirements( designElements, (RequirementsGroup) p_parentNode );
		}

		if ( p_parentNode instanceof AbstractRequirement ) {
			final Collection<ModelElementReference> satElements = new EMFURIEqualsList<ModelElementReference>();
			final AbstractRequirement requirement = (AbstractRequirement) p_parentNode;
			Collection<ModelElementReference> actualElements = requirement.getSatisfiedBy().getModelElementReferences();

			// Return the evaluated results if computed
			if ( actualElements.isEmpty() ) {
				actualElements = requirementDelegate.modelElementReferences( requirement );
			}
			
			for ( final ModelElementReference refElement : actualElements ) {
				if ( designElements.contains( refElement.getModelElement() ) ) {
					satElements.add( refElement );
				}
			}
			
			return satElements;
		}

		// No more child elements
		return Collections.emptyList();
	}

	Collection<RequirementsGroup> satisfiableRequirementGroups( final Collection<EObject> p_designElements, 
																final Specification p_specification ) 
	throws ConstraintException, SystemException, InterruptedException {
		final Set<RequirementsGroup> groups = new HashSet<RequirementsGroup>();
		
		for ( final RequirementsGroup group : p_specification.getRequirementGroups() ) {
			if ( !satisfiableRequirements( p_designElements, group ).isEmpty() ) {
				groups.add( group );
			}
		}
		
		return groups;
	}

	Collection<AbstractRequirement> satisfiableRequirements( 	final Collection<EObject> p_designElements, 
														final RequirementsGroup p_reqGroup )
	throws ConstraintException, SystemException, InterruptedException {
		final Collection<AbstractRequirement> requirements = new HashSet<AbstractRequirement>();

		for ( final AbstractRequirement req : p_reqGroup.getRequirements() ) {
			//if ( req instanceof Requirement ) {
				final Collection<EObject> reqContext = requirementDelegate.modelElements( req );
				
				for ( final EObject element : p_designElements ) {
					requirements.addAll( satisfiableRequirements( element, req, reqContext ) );
				}
			//}
		}
		
		return requirements;
	}

	Collection<AbstractRequirement> satisfiableRequirements( 	final EObject p_designElement, 
																final AbstractRequirement p_requirement ) 
	throws ConstraintException, SystemException, InterruptedException {
		return satisfiableRequirements( p_designElement, 
										p_requirement, 
										requirementDelegate.modelElements( p_requirement ) );
		
	}
	
	Collection<AbstractRequirement> satisfiableRequirements( 	final EObject p_designElement, 
																final AbstractRequirement p_requirement,
																final Collection<EObject> p_context ) 
	throws ConstraintException, SystemException, InterruptedException {
		final Set<AbstractRequirement> requirements = new HashSet<AbstractRequirement>();
		
		if ( p_context.contains( p_designElement ) ) {
			requirements.add( p_requirement );
		}
		else {
			for ( final AbstractRequirement req : p_requirement.getContainedRequirements() ) {
				requirements.addAll( satisfiableRequirements( p_designElement, req ) );
			}
		}

		return requirements;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Collection<EObject> designElements( final EObject p_designElement,
										final boolean pb_recursive ) {
		final Collection<EObject> elements = new EMFURIEqualsList<EObject>();
		//final AObject aadlDesignElement = (AObject) p_designElement;
		
		if ( pb_recursive ) {
			EMFUtil.fillContentOfTypes( p_designElement, false, supportedSatisfyingTypesInclContainers, elements, true );
			
//			final RecursiveAadlElementsProcessSwitch satElementSwitch = new RecursiveAadlElementsProcessSwitch( elements );
//			satElementSwitch.defaultTraversal( aadlDesignElement );
		}
		//else {
		//elements.add( p_designElement );
		//}
		
		return (Collection) elements;
	}

	Trace evaluateConstraints( 	final EObject p_designSpecification,
								final Collection<Specification> p_specs ) 
	throws ConstraintException, SystemException, InterruptedException {
		
		// Find all requirements satisfying candidates of the design.
		final Collection<EObject> satisfyingDesignElements = new EMFURIEqualsList<EObject>();
		
		
//		final AadlProcessingSwitch aadlSwitch = new SatifyingElemAadlProcessSwitch( satisfyingDesignElements );
//		aadlSwitch.processPreOrderAll( (AObject) p_designSpecification );
		EMFUtil.fillContentOfTypes( p_designSpecification, false, supportedSatisfyingTypes, satisfyingDesignElements, true );
		// Find all requirements having a context including one or several of the design 
		// element candidates and evaluate their attached constraints.
		final RequirementsProcessingSwitch<AbstractRequirement> requirementsSwitch = new RequirementsProcessingSwitch<AbstractRequirement>() {
			
			@Override
			protected Object caseRequirementEx( final AbstractRequirement p_requirement ) 
			throws Throwable {
				final AbstractRequirement updRequirement = requirementDelegate.setModelElements( p_requirement );  
				Collection<EObject> context = requirementDelegate.modelElements( updRequirement );
					
				for ( final EObject contextElement : context ) {
					// Requirement evaluation is needed because an element of the requirement's context is contained in
					// the concerned design.
					if ( satisfyingDesignElements.contains( contextElement ) ) {
						addProcessedObject( requirementDelegate.evaluateConstraint( updRequirement, context ) );
						
						return DONE;
					}
				}
				
				return DONE;
			}
		};
		
		requirementsSwitch.processAllProperContent( p_specs );
		
		if ( requirementsSwitch.getException() != null ) {
			handleException( requirementsSwitch.getException() );
		}

		final Set<Specification> processedSpecifications = new HashSet<Specification>();
		final Trace trace = CoreFactory.eINSTANCE.createTrace();
		
		for ( final AbstractRequirement req : requirementsSwitch.getProcessedObjects() ) {
			for ( final ModelElementReference modelRef : req.getSatisfiedBy().getModelElementReferences() ) {
				final EObject modelElement = modelRef.getModelElement();
				TraceModelElementReference existingRef = trace.modelElementReference( modelElement );
				
				if ( existingRef == null ) {
					existingRef = CoreFactory.eINSTANCE.createTraceModelElementReference();
					existingRef.setDescription( "Traceability reference : " + modelRef.getDescription() );
					existingRef.setReason( modelRef.getReason() );
					existingRef.setName( modelRef.getName() );
					existingRef.setModelElement( modelElement );
					
					// For natural language expressed requirements, the verifies of each reference may not have
					// been set by the designer. We assume it is not verified.
					if ( modelRef.getVerifies() != null && modelRef.getVerifies() ) {
						existingRef.setVerificationLevel( (float) 1.0 );
					}
					else {
						existingRef.setVerificationLevel( (float) 0.0 );
					}

					existingRef.setNbRequirements( 1 );
					trace.getModelElementReferences().add( existingRef );
				}
				else {
					final TraceModelElementReference traceElem = CoreFactory.eINSTANCE.createTraceModelElementReference();
					traceElem.setNbRequirements( 1 );
					
					// For natural language expressed requirements, the verifies of each reference may not have
					// been set by the designer. We assume it is not verified.
					if ( modelRef.getVerifies() != null && modelRef.getVerifies() ) {
						traceElem.setVerificationLevel( (float) 1.0 );
					}
					else {
						traceElem.setVerificationLevel( (float) 0.0 );
					}

					traceElem.setDescription( modelRef.getDescription() );
					traceElem.setId( modelRef.getId() );
					traceElem.setName( modelRef.getName() );
					existingRef.merge( traceElem );
				}
			}
				
			processedSpecifications.add( req.getGroup().getSpecification() );
		}

		trace.getSpecifications().addAll( processedSpecifications );
		
		processContainnerDesignElements( p_designSpecification, trace );
		
		return trace;
	}
	
	/**
	 * Calculates the verification level of design containing elements to be displayed in the traceability views.
	 * @param p_designElement
	 * @param p_trace
	 * @return
	 */
	private TraceModelElementReference processContainnerDesignElements( final EObject p_designElement,
																		final Trace p_trace ) {
		int nbRequirements = 0;
		int nbVerifiedRequirements = 0;
			
		for ( final EObject childObject : p_designElement.eContents() ) {
			final TraceModelElementReference reference = processContainnerDesignElements( childObject, p_trace );
			
			if ( reference != null ) {
				nbRequirements += reference.getNbRequirements();
				nbVerifiedRequirements += reference.getNbRequirements() * reference.getVerificationLevel();
			}
		}
		
		TraceModelElementReference parentReference = p_trace.modelElementReference( p_designElement );
		
		if ( parentReference != null ) {
			final int nbParentReq = parentReference.getNbRequirements(); 
			nbRequirements += nbParentReq;
			nbVerifiedRequirements += parentReference.getVerificationLevel() * nbParentReq;
		}

		if ( nbRequirements !=  0 ) {
			if ( parentReference == null ) {
				parentReference = CoreFactory.eINSTANCE.createTraceModelElementReference();
				
				// Used to distinguish so that container elements are not marked as problems when requirements of contained
				// elements are not all verified.
				parentReference.setContainer( true );
			}
			
			parentReference.setDescription( "Traceability reference container" );
			parentReference.setName( p_designElement.toString() );
			parentReference.setModelElement( p_designElement );
			parentReference.setVerificationLevel( (float) nbVerifiedRequirements  / nbRequirements );
			parentReference.setNbRequirements( nbRequirements );
			
			p_trace.getModelElementReferences().add( parentReference );
		}
		
		return parentReference;
	}
	
	private void handleException( final Throwable p_th )
	throws ConstraintException, SystemException, InterruptedException {
		if ( p_th instanceof ConstraintException ) {
			throw (ConstraintException) p_th;
		}

		if ( p_th instanceof SystemException ) {
			throw (SystemException) p_th;
		}
		if ( p_th instanceof InterruptedException ) {
			throw (InterruptedException) p_th;
		}
		
		throw new SystemException( p_th );
	}
}
