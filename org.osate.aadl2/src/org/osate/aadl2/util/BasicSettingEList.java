package org.osate.aadl2.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

public class BasicSettingEList<E> extends BasicEList<E> implements InternalEList<E>, EStructuralFeature.Setting {

	private static final long serialVersionUID = 7326976595806462429L;
	
	private final InternalEObject owner;
	private final EStructuralFeature feature;

	public BasicSettingEList(	final InternalEObject owner,
								final EStructuralFeature feature ) {
		super();

	    this.owner = owner;
	    this.feature = feature;
	}

	@Override
	public EObject getEObject() {
		return owner;
	}

	@Override
	public EStructuralFeature getEStructuralFeature() {
	    return feature;
	}

	@Override
	public Object get(boolean resolve) {
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void set(Object newValue) {
	    clear();
	    addAll((List<? extends E>)newValue);
	}

	@Override
	public boolean isSet() {
	    return !isEmpty();
	}

	@Override
	public void unset() {
	    clear();
	}

	@Override
	public Object[] basicToArray() {
	    return super.toArray();
	}

	@Override
	public <T> T[] basicToArray(T[] array) {
	    return super.toArray(array);
	}

	@Override
	public int basicIndexOf(Object object) {
	    return super.indexOf(object);
	}

	@Override
	public int basicLastIndexOf(Object object) {
	    return super.lastIndexOf(object);
	}

	@Override
	public boolean basicContains(Object object) {
	    return super.contains(object);
	}

	@Override
	public boolean basicContainsAll(Collection<?> collection) {
	    return super.containsAll(collection);
	}

	@Override
	public NotificationChain basicRemove(	Object object,
											NotificationChain notifications) {
	    int index = indexOf(object);
	    
	    if (index != -1) {
	        remove(index);
	    }

	    return notifications;
	}

	@Override
	public NotificationChain basicAdd(E object, NotificationChain notifications) {
		addUnique(size, object);

	    return notifications;
	}

	@Override
	public ListIterator<E> basicListIterator() {
		return super.basicListIterator();
	}

	@Override
	public ListIterator<E> basicListIterator(int index) {
		return super.basicListIterator( index );
	}

	@Override
	public Iterator<E> basicIterator() {
		return super.basicIterator();
	}

	@Override
	public List<E> basicList() {
		return super.basicList();
	}
}
