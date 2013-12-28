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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.openpeople.rdal.model.core.CorePackage
 * @generated
 */
public class CoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreSwitch<Adapter> modelSwitch =
		new CoreSwitch<Adapter>() {
			@Override
			public Adapter caseIdentifiedElement(IdentifiedElement object) {
				return createIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseContractualElement(ContractualElement object) {
				return createContractualElementAdapter();
			}
			@Override
			public Adapter caseVerifiableElement(VerifiableElement object) {
				return createVerifiableElementAdapter();
			}
			@Override
			public Adapter caseSpecification(Specification object) {
				return createSpecificationAdapter();
			}
			@Override
			public Adapter caseRequirementsGroup(RequirementsGroup object) {
				return createRequirementsGroupAdapter();
			}
			@Override
			public Adapter caseAbstractRequirement(AbstractRequirement object) {
				return createAbstractRequirementAdapter();
			}
			@Override
			public Adapter caseRequirement(Requirement object) {
				return createRequirementAdapter();
			}
			@Override
			public Adapter caseAssumption(Assumption object) {
				return createAssumptionAdapter();
			}
			@Override
			public Adapter caseVerificationActivity(VerificationActivity object) {
				return createVerificationActivityAdapter();
			}
			@Override
			public Adapter caseStakeHolder(StakeHolder object) {
				return createStakeHolderAdapter();
			}
			@Override
			public Adapter caseRefExpressionCollectedModelElements(RefExpressionCollectedModelElements object) {
				return createRefExpressionCollectedModelElementsAdapter();
			}
			@Override
			public Adapter caseRefUserSelectedModelElements(RefUserSelectedModelElements object) {
				return createRefUserSelectedModelElementsAdapter();
			}
			@Override
			public Adapter caseReferencedModelElements(ReferencedModelElements object) {
				return createReferencedModelElementsAdapter();
			}
			@Override
			public Adapter caseContractReferencedModelElements(ContractReferencedModelElements object) {
				return createContractReferencedModelElementsAdapter();
			}
			@Override
			public Adapter caseModelElementReference(ModelElementReference object) {
				return createModelElementReferenceAdapter();
			}
			@Override
			public Adapter caseTrace(Trace object) {
				return createTraceAdapter();
			}
			@Override
			public Adapter caseTraceModelElementReference(TraceModelElementReference object) {
				return createTraceModelElementReferenceAdapter();
			}
			@Override
			public Adapter caseRequirementsCoverageData(RequirementsCoverageData object) {
				return createRequirementsCoverageDataAdapter();
			}
			@Override
			public Adapter caseGoal(Goal object) {
				return createGoalAdapter();
			}
			@Override
			public Adapter caseUncertainty(Uncertainty object) {
				return createUncertaintyAdapter();
			}
			@Override
			public Adapter caseSystemOverview(SystemOverview object) {
				return createSystemOverviewAdapter();
			}
			@Override
			public Adapter caseSystemContext(SystemContext object) {
				return createSystemContextAdapter();
			}
			@Override
			public Adapter caseActor(Actor object) {
				return createActorAdapter();
			}
			@Override
			public Adapter caseInteraction(Interaction object) {
				return createInteractionAdapter();
			}
			@Override
			public Adapter caseConflict(Conflict object) {
				return createConflictAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.IdentifiedElement <em>Identified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.IdentifiedElement
	 * @generated
	 */
	public Adapter createIdentifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.ContractualElement <em>Contractual Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.ContractualElement
	 * @generated
	 */
	public Adapter createContractualElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Specification
	 * @generated
	 */
	public Adapter createSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.AbstractRequirement <em>Abstract Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.AbstractRequirement
	 * @generated
	 */
	public Adapter createAbstractRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Assumption
	 * @generated
	 */
	public Adapter createAssumptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.VerificationActivity <em>Verification Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.VerificationActivity
	 * @generated
	 */
	public Adapter createVerificationActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.StakeHolder <em>Stake Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.StakeHolder
	 * @generated
	 */
	public Adapter createStakeHolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.RequirementsGroup <em>Requirements Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.RequirementsGroup
	 * @generated
	 */
	public Adapter createRequirementsGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements <em>Ref Expression Collected Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements
	 * @generated
	 */
	public Adapter createRefExpressionCollectedModelElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.RefUserSelectedModelElements <em>Ref User Selected Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.RefUserSelectedModelElements
	 * @generated
	 */
	public Adapter createRefUserSelectedModelElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.ReferencedModelElements <em>Referenced Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.ReferencedModelElements
	 * @generated
	 */
	public Adapter createReferencedModelElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.ContractReferencedModelElements <em>Contract Referenced Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.ContractReferencedModelElements
	 * @generated
	 */
	public Adapter createContractReferencedModelElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.ModelElementReference <em>Model Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.ModelElementReference
	 * @generated
	 */
	public Adapter createModelElementReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Trace
	 * @generated
	 */
	public Adapter createTraceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.TraceModelElementReference <em>Trace Model Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.TraceModelElementReference
	 * @generated
	 */
	public Adapter createTraceModelElementReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.RequirementsCoverageData <em>Requirements Coverage Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.RequirementsCoverageData
	 * @generated
	 */
	public Adapter createRequirementsCoverageDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Goal
	 * @generated
	 */
	public Adapter createGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.VerifiableElement <em>Verifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.VerifiableElement
	 * @generated
	 */
	public Adapter createVerifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Uncertainty <em>Uncertainty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Uncertainty
	 * @generated
	 */
	public Adapter createUncertaintyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.SystemOverview <em>System Overview</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.SystemOverview
	 * @generated
	 */
	public Adapter createSystemOverviewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.SystemContext <em>System Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.SystemContext
	 * @generated
	 */
	public Adapter createSystemContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Actor
	 * @generated
	 */
	public Adapter createActorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Interaction
	 * @generated
	 */
	public Adapter createInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.openpeople.rdal.model.core.Conflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.openpeople.rdal.model.core.Conflict
	 * @generated
	 */
	public Adapter createConflictAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RdalAdapterFactory
