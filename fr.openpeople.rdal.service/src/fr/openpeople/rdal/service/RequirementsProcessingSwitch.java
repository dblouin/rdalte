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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import fr.labsticc.framework.constraints.core.exception.ConstraintException;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.RequirementsGroup;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.util.CoreSwitch;

/**
 * A switch for collecting requirements attached to design specifications. Dependency requirements
 * (i.e.: the contained or derived requirements) are traversed first so that constraint evaluation 
 * of dependent requirements occurs after their dependencies are computed.
 * 
 * @author <a href="mailto:dominique.blouin@univ-ubs.fr">Dominique Blouin</a>
 *
 * @param <T> The type of the collected elements
 */
public abstract class RequirementsProcessingSwitch<T extends EObject> extends CoreSwitch<Object> {
	
	protected final Object DONE = "";
	protected final Object NOT_DONE = null;
	
	private final List<T> processedObjects;
	
	private Throwable exception;
	
	private final Set<Object> traversedObjects;

	public RequirementsProcessingSwitch() {
		this( new ArrayList<T>() );
	}

	public RequirementsProcessingSwitch( final List<T> p_processedObjects ) {
		processedObjects = p_processedObjects;
		
		exception = null;
		traversedObjects = new HashSet<Object>();
	}
	
	public void processAllProperContent( final Collection<? extends EObject> p_objects ) {
//		for ( final Iterator<EObject> iterator = EcoreUtil.getAllProperContents( p_objects, false ); iterator.hasNext(); ) {
		for ( final EObject object : p_objects ) {
			doSwitch( object );
		}
	}
	
	protected boolean addProcessedObject( final T p_object ) {
		return processedObjects.add( p_object );
	}
	
	public List<T> getProcessedObjects() {
		return processedObjects;
	}
	
	public Throwable getException() {
		return exception;
	}
	
	protected void setException( 	final Throwable p_th,
									final EObject p_object ) {
		exception = p_th;
		
		if ( exception instanceof ConstraintException ) {
			( (ConstraintException) exception ).setContext( new EObject[]{ p_object } );
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	@Override
	public Object caseSpecification( final Specification p_spec ) {
		for ( final RequirementsGroup group : p_spec.getRequirementGroups() ) {
			doSwitch( group );
		}
		
		return DONE;
	}
	
	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirements Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirements Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	@Override
	public Object caseRequirementsGroup( final RequirementsGroup p_reqGroup ) {
		for ( final AbstractRequirement requirement : p_reqGroup.getRequirements() ) {
			doSwitch( requirement );
		}
		
		return DONE;
	}
	
	protected boolean isTraversed( final Object p_object ) {
		return traversedObjects.contains( p_object );
	}
	
	protected void setTraversed( final Object p_object ) {
		traversedObjects.add( p_object );
	}

	@Override
	public Object caseAbstractRequirement( final AbstractRequirement p_requirement ) {
		if ( !isTraversed( p_requirement ) ) {
			setTraversed( p_requirement );

			try {
				for ( final AbstractRequirement contRequirement : p_requirement.getContainedRequirements() ) {
					caseAbstractRequirement( contRequirement );
				}
	
				// Must be performed at the end to ensure proper traversal order.
				return caseRequirementEx( p_requirement );
			}
			catch ( final Throwable p_th ) {
				// If it is an unmanaged exception, we want to stop the traversal immediately.
				if ( p_th instanceof RuntimeException ) {
					throw (RuntimeException) p_th;
				}
				
				setException( p_th, p_requirement );
			}
		}
		
		return DONE;
	}
	
	protected Object caseRequirementEx( final AbstractRequirement p_requirement ) 
	throws Throwable {
		return NOT_DONE;
	}
}
