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
package fr.openpeople.rdal.model.core.impl;

import fr.openpeople.rdal.model.core.*;

import java.util.Date;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreFactoryImpl extends EFactoryImpl implements CoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoreFactory init() {
		try {
			CoreFactory theCoreFactory = (CoreFactory)EPackage.Registry.INSTANCE.getEFactory("http:///www.open-people.fr/rdal/core"); 
			if (theCoreFactory != null) {
				return theCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CorePackage.VERIFIABLE_ELEMENT: return createVerifiableElement();
			case CorePackage.SPECIFICATION: return createSpecification();
			case CorePackage.REQUIREMENTS_GROUP: return createRequirementsGroup();
			case CorePackage.REQUIREMENT: return createRequirement();
			case CorePackage.ASSUMPTION: return createAssumption();
			case CorePackage.VERIFICATION_ACTIVITY: return createVerificationActivity();
			case CorePackage.STAKE_HOLDER: return createStakeHolder();
			case CorePackage.REF_EXPRESSION_COLLECTED_MODEL_ELEMENTS: return createRefExpressionCollectedModelElements();
			case CorePackage.REF_USER_SELECTED_MODEL_ELEMENTS: return createRefUserSelectedModelElements();
			case CorePackage.MODEL_ELEMENT_REFERENCE: return createModelElementReference();
			case CorePackage.TRACE: return createTrace();
			case CorePackage.TRACE_MODEL_ELEMENT_REFERENCE: return createTraceModelElementReference();
			case CorePackage.REQUIREMENTS_COVERAGE_DATA: return createRequirementsCoverageData();
			case CorePackage.GOAL: return createGoal();
			case CorePackage.UNCERTAINTY: return createUncertainty();
			case CorePackage.SYSTEM_OVERVIEW: return createSystemOverview();
			case CorePackage.SYSTEM_CONTEXT: return createSystemContext();
			case CorePackage.ACTOR: return createActor();
			case CorePackage.INTERACTION: return createInteraction();
			case CorePackage.CONFLICT: return createConflict();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CorePackage.ENUM_RISK_KIND:
				return createEnumRiskKindFromString(eDataType, initialValue);
			case CorePackage.ENUM_VERIFICATION_METHOD:
				return createEnumVerificationMethodFromString(eDataType, initialValue);
			case CorePackage.ENUM_ASSUMPTION_TYPE:
				return createEnumAssumptionTypeFromString(eDataType, initialValue);
			case CorePackage.ENUM_FUNCTIONAL_REQUIREMENT_TYPE:
				return createEnumFunctionalRequirementTypeFromString(eDataType, initialValue);
			case CorePackage.DIRECTION:
				return createDirectionFromString(eDataType, initialValue);
			case CorePackage.RATIO:
				return createRatioFromString(eDataType, initialValue);
			case CorePackage.DATE:
				return createDateFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CorePackage.ENUM_RISK_KIND:
				return convertEnumRiskKindToString(eDataType, instanceValue);
			case CorePackage.ENUM_VERIFICATION_METHOD:
				return convertEnumVerificationMethodToString(eDataType, instanceValue);
			case CorePackage.ENUM_ASSUMPTION_TYPE:
				return convertEnumAssumptionTypeToString(eDataType, instanceValue);
			case CorePackage.ENUM_FUNCTIONAL_REQUIREMENT_TYPE:
				return convertEnumFunctionalRequirementTypeToString(eDataType, instanceValue);
			case CorePackage.DIRECTION:
				return convertDirectionToString(eDataType, instanceValue);
			case CorePackage.RATIO:
				return convertRatioToString(eDataType, instanceValue);
			case CorePackage.DATE:
				return convertDateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification createSpecification() {
		SpecificationImpl specification = new SpecificationImpl();
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assumption createAssumption() {
		AssumptionImpl assumption = new AssumptionImpl();
		return assumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationActivity createVerificationActivity() {
		VerificationActivityImpl verificationActivity = new VerificationActivityImpl();
		return verificationActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StakeHolder createStakeHolder() {
		StakeHolderImpl stakeHolder = new StakeHolderImpl();
		return stakeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsGroup createRequirementsGroup() {
		RequirementsGroupImpl requirementsGroup = new RequirementsGroupImpl();
		return requirementsGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefExpressionCollectedModelElements createRefExpressionCollectedModelElements() {
		RefExpressionCollectedModelElementsImpl refExpressionCollectedModelElements = new RefExpressionCollectedModelElementsImpl();
		return refExpressionCollectedModelElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefUserSelectedModelElements createRefUserSelectedModelElements() {
		RefUserSelectedModelElementsImpl refUserSelectedModelElements = new RefUserSelectedModelElementsImpl();
		return refUserSelectedModelElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference createModelElementReference() {
		ModelElementReferenceImpl modelElementReference = new ModelElementReferenceImpl();
		return modelElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace createTrace() {
		TraceImpl trace = new TraceImpl();
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceModelElementReference createTraceModelElementReference() {
		TraceModelElementReferenceImpl traceModelElementReference = new TraceModelElementReferenceImpl();
		return traceModelElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsCoverageData createRequirementsCoverageData() {
		RequirementsCoverageDataImpl requirementsCoverageData = new RequirementsCoverageDataImpl();
		return requirementsCoverageData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerifiableElement createVerifiableElement() {
		VerifiableElementImpl verifiableElement = new VerifiableElementImpl();
		return verifiableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Uncertainty createUncertainty() {
		UncertaintyImpl uncertainty = new UncertaintyImpl();
		return uncertainty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemOverview createSystemOverview() {
		SystemOverviewImpl systemOverview = new SystemOverviewImpl();
		return systemOverview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemContext createSystemContext() {
		SystemContextImpl systemContext = new SystemContextImpl();
		return systemContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction createInteraction() {
		InteractionImpl interaction = new InteractionImpl();
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conflict createConflict() {
		ConflictImpl conflict = new ConflictImpl();
		return conflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumRiskKind createEnumRiskKindFromString(EDataType eDataType, String initialValue) {
		EnumRiskKind result = EnumRiskKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumRiskKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumVerificationMethod createEnumVerificationMethodFromString(EDataType eDataType, String initialValue) {
		EnumVerificationMethod result = EnumVerificationMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumVerificationMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumAssumptionType createEnumAssumptionTypeFromString(EDataType eDataType, String initialValue) {
		EnumAssumptionType result = EnumAssumptionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumAssumptionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumFunctionalRequirementType createEnumFunctionalRequirementTypeFromString(EDataType eDataType, String initialValue) {
		EnumFunctionalRequirementType result = EnumFunctionalRequirementType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumFunctionalRequirementTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction createDirectionFromString(EDataType eDataType, String initialValue) {
		Direction result = Direction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float createRatioFromString(EDataType eDataType, String initialValue) {
		return (Float)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRatioToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date createDateFromString(EDataType eDataType, String initialValue) {
		return (Date)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDateToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorePackage getCorePackage() {
		return (CorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CorePackage getPackage() {
		return CorePackage.eINSTANCE;
	}

} //RdalFactoryImpl
