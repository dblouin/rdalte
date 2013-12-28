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
package fr.openpeople.rdal.model.core;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contractual Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getSatisfactionLevel <em>Satisfaction Level</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getChangeUncertainty <em>Change Uncertainty</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getContactInformation <em>Contact Information</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getOriginDate <em>Origin Date</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getScheduleDate <em>Schedule Date</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getStakeHolders <em>Stake Holders</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getPriority <em>Priority</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getSatisfiedBy <em>Satisfied By</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getEvolvedTo <em>Evolved To</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#isDropped <em>Dropped</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getTracedTo <em>Traced To</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getRationale <em>Rationale</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.ContractualElement#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement()
 * @model abstract="true"
 * @generated
 */
public interface ContractualElement extends IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Satisfaction Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfaction Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Satisfaction Level</em>' attribute.
	 * @see #setSatisfactionLevel(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_SatisfactionLevel()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getSatisfactionLevel();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getSatisfactionLevel <em>Satisfaction Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Satisfaction Level</em>' attribute.
	 * @see #getSatisfactionLevel()
	 * @generated
	 */
	void setSatisfactionLevel(Float value);

	/**
	 * Returns the value of the '<em><b>Change Uncertainty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Uncertainty</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Uncertainty</em>' containment reference.
	 * @see #setChangeUncertainty(Uncertainty)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_ChangeUncertainty()
	 * @model containment="true"
	 * @generated
	 */
	Uncertainty getChangeUncertainty();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getChangeUncertainty <em>Change Uncertainty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Uncertainty</em>' containment reference.
	 * @see #getChangeUncertainty()
	 * @generated
	 */
	void setChangeUncertainty(Uncertainty value);

	/**
	 * Returns the value of the '<em><b>Contact Information</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contact Information</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact Information</em>' attribute list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_ContactInformation()
	 * @model
	 * @generated
	 */
	EList<String> getContactInformation();

	/**
	 * Returns the value of the '<em><b>Origin Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Date</em>' attribute.
	 * @see #setOriginDate(Date)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_OriginDate()
	 * @model dataType="fr.openpeople.rdal.model.core.Date"
	 * @generated
	 */
	Date getOriginDate();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getOriginDate <em>Origin Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Date</em>' attribute.
	 * @see #getOriginDate()
	 * @generated
	 */
	void setOriginDate(Date value);

	/**
	 * Returns the value of the '<em><b>Schedule Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Date</em>' attribute.
	 * @see #setScheduleDate(Date)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_ScheduleDate()
	 * @model dataType="fr.openpeople.rdal.model.core.Date"
	 * @generated
	 */
	Date getScheduleDate();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getScheduleDate <em>Schedule Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Date</em>' attribute.
	 * @see #getScheduleDate()
	 * @generated
	 */
	void setScheduleDate(Date value);

	/**
	 * Returns the value of the '<em><b>Stake Holders</b></em>' reference list.
	 * The list contents are of type {@link fr.openpeople.rdal.model.core.StakeHolder}.
	 * It is bidirectional and its opposite is '{@link fr.openpeople.rdal.model.core.StakeHolder#getContractualElements <em>Contractual Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stake Holders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stake Holders</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_StakeHolders()
	 * @see fr.openpeople.rdal.model.core.StakeHolder#getContractualElements
	 * @model opposite="contractualElements"
	 * @generated
	 */
	EList<StakeHolder> getStakeHolders();

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_Priority()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getPriority();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Float value);

	/**
	 * Returns the value of the '<em><b>Satisfied By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfied By</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Satisfied By</em>' containment reference.
	 * @see #setSatisfiedBy(ContractReferencedModelElements)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_SatisfiedBy()
	 * @model containment="true"
	 * @generated
	 */
	ContractReferencedModelElements getSatisfiedBy();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getSatisfiedBy <em>Satisfied By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Satisfied By</em>' containment reference.
	 * @see #getSatisfiedBy()
	 * @generated
	 */
	void setSatisfiedBy(ContractReferencedModelElements value);

	/**
	 * Returns the value of the '<em><b>Evolved To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evolved To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evolved To</em>' reference.
	 * @see #setEvolvedTo(ContractualElement)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_EvolvedTo()
	 * @model
	 * @generated
	 */
	EList<ContractualElement> getEvolvedTo();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getEvolvedTo <em>Evolved To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evolved To</em>' reference.
	 * @see #getEvolvedTo()
	 * @generated
	 */
	//void setEvolvedTo(ContractualElement value);

	/**
	 * Returns the value of the '<em><b>Dropped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dropped</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dropped</em>' attribute.
	 * @see #setDropped(boolean)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_Dropped()
	 * @model required="true"
	 * @generated
	 */
	boolean isDropped();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#isDropped <em>Dropped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dropped</em>' attribute.
	 * @see #isDropped()
	 * @generated
	 */
	void setDropped(boolean value);

	/**
	 * Returns the value of the '<em><b>Traced To</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traced To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traced To</em>' reference list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_TracedTo()
	 * @model
	 * @generated
	 */
	EList<EObject> getTracedTo();

	/**
	 * Returns the value of the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rationale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rationale</em>' attribute.
	 * @see #setRationale(String)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_Rationale()
	 * @model
	 * @generated
	 */
	String getRationale();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.ContractualElement#getRationale <em>Rationale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rationale</em>' attribute.
	 * @see #getRationale()
	 * @generated
	 */
	void setRationale(String value);

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' attribute list.
	 * @see fr.openpeople.rdal.model.core.CorePackage#getContractualElement_Sources()
	 * @model
	 * @generated
	 */
	EList<String> getSources();

} // ContractualElement
