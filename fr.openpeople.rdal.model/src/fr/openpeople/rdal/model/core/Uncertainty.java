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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uncertainty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getVolatility <em>Volatility</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getCostsImpact <em>Costs Impact</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getScheduleImpact <em>Schedule Impact</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getTimeCriticality <em>Time Criticality</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getRiskIndex <em>Risk Index</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getPropRiskIndex <em>Prop Risk Index</em>}</li>
 *   <li>{@link fr.openpeople.rdal.model.core.Uncertainty#getMaturityIndex <em>Maturity Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty()
 * @model
 * @generated
 */
public interface Uncertainty extends IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Volatility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volatility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volatility</em>' attribute.
	 * @see #setVolatility(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_Volatility()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getVolatility();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getVolatility <em>Volatility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volatility</em>' attribute.
	 * @see #getVolatility()
	 * @generated
	 */
	void setVolatility(Float value);

	/**
	 * Returns the value of the '<em><b>Costs Impact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Costs Impact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Costs Impact</em>' attribute.
	 * @see #setCostsImpact(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_CostsImpact()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getCostsImpact();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getCostsImpact <em>Costs Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Costs Impact</em>' attribute.
	 * @see #getCostsImpact()
	 * @generated
	 */
	void setCostsImpact(Float value);

	/**
	 * Returns the value of the '<em><b>Schedule Impact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Impact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Impact</em>' attribute.
	 * @see #setScheduleImpact(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_ScheduleImpact()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getScheduleImpact();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getScheduleImpact <em>Schedule Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Impact</em>' attribute.
	 * @see #getScheduleImpact()
	 * @generated
	 */
	void setScheduleImpact(Float value);

	/**
	 * Returns the value of the '<em><b>Precedence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedence</em>' attribute.
	 * @see #setPrecedence(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_Precedence()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getPrecedence();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getPrecedence <em>Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' attribute.
	 * @see #getPrecedence()
	 * @generated
	 */
	void setPrecedence(Float value);

	/**
	 * Returns the value of the '<em><b>Time Criticality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Criticality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Criticality</em>' attribute.
	 * @see #setTimeCriticality(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_TimeCriticality()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio"
	 * @generated
	 */
	Float getTimeCriticality();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getTimeCriticality <em>Time Criticality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Criticality</em>' attribute.
	 * @see #getTimeCriticality()
	 * @generated
	 */
	void setTimeCriticality(Float value);

	/**
	 * Returns the value of the '<em><b>Risk Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Risk Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risk Index</em>' attribute.
	 * @see #setRiskIndex(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_RiskIndex()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Float getRiskIndex();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getRiskIndex <em>Risk Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risk Index</em>' attribute.
	 * @see #getRiskIndex()
	 * @generated
	 */
	void setRiskIndex(Float value);

	/**
	 * Returns the value of the '<em><b>Prop Risk Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop Risk Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop Risk Index</em>' attribute.
	 * @see #setPropRiskIndex(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_PropRiskIndex()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Float getPropRiskIndex();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getPropRiskIndex <em>Prop Risk Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop Risk Index</em>' attribute.
	 * @see #getPropRiskIndex()
	 * @generated
	 */
	void setPropRiskIndex(Float value);

	/**
	 * Returns the value of the '<em><b>Maturity Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maturity Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maturity Index</em>' attribute.
	 * @see #setMaturityIndex(Float)
	 * @see fr.openpeople.rdal.model.core.CorePackage#getUncertainty_MaturityIndex()
	 * @model dataType="fr.openpeople.rdal.model.core.Ratio" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Float getMaturityIndex();

	/**
	 * Sets the value of the '{@link fr.openpeople.rdal.model.core.Uncertainty#getMaturityIndex <em>Maturity Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maturity Index</em>' attribute.
	 * @see #getMaturityIndex()
	 * @generated
	 */
	void setMaturityIndex(Float value);

} // Uncertainty
