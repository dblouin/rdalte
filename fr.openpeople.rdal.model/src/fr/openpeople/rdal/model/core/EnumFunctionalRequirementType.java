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
 * A representation of the literals of the enumeration '<em><b>Enum Functional Requirement Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.openpeople.rdal.model.core.CorePackage#getEnumFunctionalRequirementType()
 * @model
 * @generated
 */
public enum EnumFunctionalRequirementType implements Enumerator {
	/**
	 * The '<em><b>Allocation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALLOCATION_VALUE
	 * @generated
	 * @ordered
	 */
	ALLOCATION(1, "Allocation", "Allocation"),

	/**
	 * The '<em><b>Audit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUDIT_VALUE
	 * @generated
	 * @ordered
	 */
	AUDIT(3, "Audit", "Audit"),

	/**
	 * The '<em><b>Backup</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BACKUP_VALUE
	 * @generated
	 * @ordered
	 */
	BACKUP(4, "Backup", "Backup");

	/**
	 * The '<em><b>Allocation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Allocation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALLOCATION
	 * @model name="Allocation"
	 * @generated
	 * @ordered
	 */
	public static final int ALLOCATION_VALUE = 1;

	/**
	 * The '<em><b>Audit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Audit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUDIT
	 * @model name="Audit"
	 * @generated
	 * @ordered
	 */
	public static final int AUDIT_VALUE = 3;

	/**
	 * The '<em><b>Backup</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Backup</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BACKUP
	 * @model name="Backup"
	 * @generated
	 * @ordered
	 */
	public static final int BACKUP_VALUE = 4;

	/**
	 * An array of all the '<em><b>Enum Functional Requirement Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EnumFunctionalRequirementType[] VALUES_ARRAY =
		new EnumFunctionalRequirementType[] {
			ALLOCATION,
			AUDIT,
			BACKUP,
		};

	/**
	 * A public read-only list of all the '<em><b>Enum Functional Requirement Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EnumFunctionalRequirementType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Enum Functional Requirement Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumFunctionalRequirementType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumFunctionalRequirementType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enum Functional Requirement Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumFunctionalRequirementType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumFunctionalRequirementType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enum Functional Requirement Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumFunctionalRequirementType get(int value) {
		switch (value) {
			case ALLOCATION_VALUE: return ALLOCATION;
			case AUDIT_VALUE: return AUDIT;
			case BACKUP_VALUE: return BACKUP;
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
	private EnumFunctionalRequirementType(int value, String name, String literal) {
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
	
} //EnumFunctionalRequirementType
