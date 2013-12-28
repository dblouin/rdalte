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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Enum Assumption Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.openpeople.rdal.model.core.CorePackage#getEnumAssumptionType()
 * @model
 * @generated
 */
public enum EnumAssumptionType implements Enumerator {
	/**
	 * The '<em><b>Technical</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TECHNICAL_VALUE
	 * @generated
	 * @ordered
	 */
	TECHNICAL(0, "Technical", "Technical"),

	/**
	 * The '<em><b>Organizational</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORGANIZATIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	ORGANIZATIONAL(1, "Organizational", "Organizational"),

	/**
	 * The '<em><b>Managerial</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANAGERIAL_VALUE
	 * @generated
	 * @ordered
	 */
	MANAGERIAL(2, "Managerial", "Managerial");

	/**
	 * The '<em><b>Technical</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Technical</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TECHNICAL
	 * @model name="Technical"
	 * @generated
	 * @ordered
	 */
	public static final int TECHNICAL_VALUE = 0;

	/**
	 * The '<em><b>Organizational</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Organizational</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORGANIZATIONAL
	 * @model name="Organizational"
	 * @generated
	 * @ordered
	 */
	public static final int ORGANIZATIONAL_VALUE = 1;

	/**
	 * The '<em><b>Managerial</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Managerial</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANAGERIAL
	 * @model name="Managerial"
	 * @generated
	 * @ordered
	 */
	public static final int MANAGERIAL_VALUE = 2;

	/**
	 * An array of all the '<em><b>Enum Assumption Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EnumAssumptionType[] VALUES_ARRAY =
		new EnumAssumptionType[] {
			TECHNICAL,
			ORGANIZATIONAL,
			MANAGERIAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Enum Assumption Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EnumAssumptionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Enum Assumption Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumAssumptionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumAssumptionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enum Assumption Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumAssumptionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumAssumptionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enum Assumption Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumAssumptionType get(int value) {
		switch (value) {
			case TECHNICAL_VALUE: return TECHNICAL;
			case ORGANIZATIONAL_VALUE: return ORGANIZATIONAL;
			case MANAGERIAL_VALUE: return MANAGERIAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EnumAssumptionType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EnumAssumptionType
