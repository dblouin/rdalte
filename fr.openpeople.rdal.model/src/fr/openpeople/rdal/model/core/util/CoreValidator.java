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
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.openpeople.rdal.model.core.util;

import fr.openpeople.rdal.model.core.*;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see fr.openpeople.rdal.model.core.CorePackage
 * @generated
 */
public class CoreValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CoreValidator INSTANCE = new CoreValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "fr.openpeople.rdal.model.core";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return CorePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case CorePackage.IDENTIFIED_ELEMENT:
				return validateIdentifiedElement((IdentifiedElement)value, diagnostics, context);
			case CorePackage.CONTRACTUAL_ELEMENT:
				return validateContractualElement((ContractualElement)value, diagnostics, context);
			case CorePackage.VERIFIABLE_ELEMENT:
				return validateVerifiableElement((VerifiableElement)value, diagnostics, context);
			case CorePackage.SPECIFICATION:
				return validateSpecification((Specification)value, diagnostics, context);
			case CorePackage.REQUIREMENTS_GROUP:
				return validateRequirementsGroup((RequirementsGroup)value, diagnostics, context);
			case CorePackage.ABSTRACT_REQUIREMENT:
				return validateAbstractRequirement((AbstractRequirement)value, diagnostics, context);
			case CorePackage.REQUIREMENT:
				return validateRequirement((Requirement)value, diagnostics, context);
			case CorePackage.ASSUMPTION:
				return validateAssumption((Assumption)value, diagnostics, context);
			case CorePackage.VERIFICATION_ACTIVITY:
				return validateVerificationActivity((VerificationActivity)value, diagnostics, context);
			case CorePackage.STAKE_HOLDER:
				return validateStakeHolder((StakeHolder)value, diagnostics, context);
			case CorePackage.REF_EXPRESSION_COLLECTED_MODEL_ELEMENTS:
				return validateRefExpressionCollectedModelElements((RefExpressionCollectedModelElements)value, diagnostics, context);
			case CorePackage.REF_USER_SELECTED_MODEL_ELEMENTS:
				return validateRefUserSelectedModelElements((RefUserSelectedModelElements)value, diagnostics, context);
			case CorePackage.REFERENCED_MODEL_ELEMENTS:
				return validateReferencedModelElements((ReferencedModelElements)value, diagnostics, context);
			case CorePackage.CONTRACT_REFERENCED_MODEL_ELEMENTS:
				return validateContractReferencedModelElements((ContractReferencedModelElements)value, diagnostics, context);
			case CorePackage.MODEL_ELEMENT_REFERENCE:
				return validateModelElementReference((ModelElementReference)value, diagnostics, context);
			case CorePackage.TRACE:
				return validateTrace((Trace)value, diagnostics, context);
			case CorePackage.TRACE_MODEL_ELEMENT_REFERENCE:
				return validateTraceModelElementReference((TraceModelElementReference)value, diagnostics, context);
			case CorePackage.REQUIREMENTS_COVERAGE_DATA:
				return validateRequirementsCoverageData((RequirementsCoverageData)value, diagnostics, context);
			case CorePackage.GOAL:
				return validateGoal((Goal)value, diagnostics, context);
			case CorePackage.UNCERTAINTY:
				return validateUncertainty((Uncertainty)value, diagnostics, context);
			case CorePackage.SYSTEM_OVERVIEW:
				return validateSystemOverview((SystemOverview)value, diagnostics, context);
			case CorePackage.SYSTEM_CONTEXT:
				return validateSystemContext((SystemContext)value, diagnostics, context);
			case CorePackage.ACTOR:
				return validateActor((Actor)value, diagnostics, context);
			case CorePackage.INTERACTION:
				return validateInteraction((Interaction)value, diagnostics, context);
			case CorePackage.CONFLICT:
				return validateConflict((Conflict)value, diagnostics, context);
			case CorePackage.ENUM_RISK_KIND:
				return validateEnumRiskKind((EnumRiskKind)value, diagnostics, context);
			case CorePackage.ENUM_VERIFICATION_METHOD:
				return validateEnumVerificationMethod((EnumVerificationMethod)value, diagnostics, context);
			case CorePackage.ENUM_ASSUMPTION_TYPE:
				return validateEnumAssumptionType((EnumAssumptionType)value, diagnostics, context);
			case CorePackage.ENUM_FUNCTIONAL_REQUIREMENT_TYPE:
				return validateEnumFunctionalRequirementType((EnumFunctionalRequirementType)value, diagnostics, context);
			case CorePackage.DIRECTION:
				return validateDirection((Direction)value, diagnostics, context);
			case CorePackage.RATIO:
				return validateRatio((Float)value, diagnostics, context);
			case CorePackage.DATE:
				return validateDate((Date)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIdentifiedElement(IdentifiedElement identifiedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(identifiedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContractualElement(ContractualElement contractualElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(contractualElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecification(Specification specification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(specification, diagnostics, context);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractRequirement(AbstractRequirement abstractRequirement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractRequirement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequirement(Requirement requirement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requirement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssumption(Assumption assumption, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assumption, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVerificationActivity(VerificationActivity verificationActivity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(verificationActivity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStakeHolder(StakeHolder stakeHolder, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stakeHolder, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequirementsGroup(RequirementsGroup requirementsGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requirementsGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefExpressionCollectedModelElements(RefExpressionCollectedModelElements refExpressionCollectedModelElements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(refExpressionCollectedModelElements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRefUserSelectedModelElements(RefUserSelectedModelElements refUserSelectedModelElements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(refUserSelectedModelElements, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(refUserSelectedModelElements, diagnostics, context);
		if (result || diagnostics != null) result &= validateRefUserSelectedModelElements_modelElementsCardinality(refUserSelectedModelElements, diagnostics, context);
		return result;
	}

	/**
	 * Validates the modelElementsCardinality constraint of '<em>Ref User Selected Model Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateRefUserSelectedModelElements_modelElementsCardinality(RefUserSelectedModelElements refUserSelectedModelElements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if ( refUserSelectedModelElements.getModelElementReferences().isEmpty() ) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "modelElementsCardinality", getObjectLabel(refUserSelectedModelElements, context) },
						 new Object[] { refUserSelectedModelElements },
						 context));
			}
			
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferencedModelElements(ReferencedModelElements referencedModelElements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referencedModelElements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContractReferencedModelElements(ContractReferencedModelElements contractReferencedModelElements, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(contractReferencedModelElements, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementReference(ModelElementReference modelElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelElementReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelElementReference_modelElementsContainedInSpecifedArchSpecs(modelElementReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the modelElementsContainedInSpecifedArchSpecs constraint of '<em>Model Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateModelElementReference_modelElementsContainedInSpecifedArchSpecs( final ModelElementReference p_modelElementReference, 
																							final DiagnosticChain p_diagnostics, 
																							final Map<Object, Object> p_context ) {
		final Set<EObject> allowedObjects = RDALModelUtil.allowedModelElements( (Specification) EcoreUtil.getRootContainer( p_modelElementReference ) );
		
		// TODO: It would be safer to re-evaluate the query if it the satisfiedBy is defined as a query...
		if ( !allowedObjects.contains( p_modelElementReference.getModelElement() ) ) {
			if ( p_diagnostics != null) {
				p_diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "modelElementsContainedInSpecifedArchSpecs", getObjectLabel( p_modelElementReference, p_context) },
						 new Object[] { p_modelElementReference },
						 p_context));
			}
			
			return false;
		}
		
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrace(Trace trace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(trace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTraceModelElementReference(TraceModelElementReference traceModelElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(traceModelElementReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(traceModelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelElementReference_modelElementsContainedInSpecifedArchSpecs(traceModelElementReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequirementsCoverageData(RequirementsCoverageData requirementsCoverageData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requirementsCoverageData, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(goal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVerifiableElement(VerifiableElement verifiableElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(verifiableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUncertainty(Uncertainty uncertainty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(uncertainty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemOverview(SystemOverview systemOverview, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemOverview, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemContext(SystemContext systemContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(actor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteraction(Interaction interaction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interaction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConflict(Conflict conflict, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conflict, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumRiskKind(EnumRiskKind enumRiskKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumVerificationMethod(EnumVerificationMethod enumVerificationMethod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumAssumptionType(EnumAssumptionType enumAssumptionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumFunctionalRequirementType(EnumFunctionalRequirementType enumFunctionalRequirementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirection(Direction direction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRatio(Float ratio, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateRatio_rangeZeroOne(ratio, diagnostics, context);
		return result;
	}

	/**
	 * Validates the rangeZeroOne constraint of '<em>Ratio</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateRatio_rangeZeroOne(Float ratio, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if ( ratio != null ) {
			if ( ratio < 0.0 || ratio > 1.0 ) {
				if (diagnostics != null) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_GenericConstraint_diagnostic",
							 new Object[] { "rangeZeroOne", getValueLabel(CorePackage.Literals.RATIO, ratio, context) },
							 new Object[] { ratio },
							 context));
				}
				
				return false;
			}
		}
		
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDate(Date date, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //RdalValidator
