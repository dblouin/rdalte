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
package fr.openpeople.rdal.model.core.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;

import fr.openpeople.rdal.model.core.CorePackage;

public class SpecificationSpecifiesPropertyDescriptor extends SettingsRefPropertyDescriptor {
//public class SpecificationSpecifiesPropertyDescriptor extends ItemPropertyDescriptor {
    public SpecificationSpecifiesPropertyDescriptor( 	final AdapterFactory p_adapterFactory,
    	      											final ResourceLocator p_resourceLocator,
    	      											final String p_displayName,
    	      											final String p_description ) {
    	super( 	p_adapterFactory, 
    			p_resourceLocator, 
    			p_displayName, 
    			p_description,
    			CorePackage.Literals.SPECIFICATION__SPECIFIES );
    }
//    @SuppressWarnings("unchecked")
//	@Override
//	public Collection<EObject> getChoiceOfValues( final Object p_object ) {
//		final Collection<EObject> elementsChoice = new EMFURIEqualsList<EObject>();
//		final Collection<EObject> currentElements = new EMFURIEqualsList<EObject>();
//		final PropertyValueWrapper wrapper = (PropertyValueWrapper) getPropertyValue( p_object );
//		final Object value = wrapper.getEditableValue( p_object );
//		
//		// Test so that it works also for single cardinality features
//		if ( value instanceof Collection<?> )  {
//			currentElements.addAll( (Collection<EObject>) value );
//		}
//
//		try {
//			ResourcesPlugin.getWorkspace().getRoot().accept( new IResourceVisitor() {
//				
//				@Override
//				public boolean visit(IResource resource) throws CoreException {
//					if( resource instanceof IFile && Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(resource.getFileExtension())!=null){
//						
//						URI uri = URI.createURI( resource.getFullPath().toString() );
//						ResourceSet res = new ResourceSetImpl();
//						Resource resArchitecture=res.getResource(uri, true);
//						
//						//EReference ereference=CorePackage.eINSTANCE.getModelElementReference_ModelElement();
//						TreeIterator<Object> list = EcoreUtil.getAllContents(resArchitecture, false );
//						SettingPlugin.getDefault().clear();
//						Collection<EClass> allowedClasses = SettingPlugin.getDefault().associatedTypes(CorePackage.eINSTANCE.getSpecification_Specifies());
//						//System.out.println(allowedClasses.toString());
//						//String [] tempList=SettingPlugin.getDefault().associatedTypesToString();
//						
//						while(list.hasNext()){
//							//System.out.println(list.next().toString().split("@")[0]+" "+tempList[1]);
//							EObject eobject=(EObject) list.next();
//							Iterator <EClass> it = allowedClasses.iterator();
//							
//							while(it.hasNext()){
//								EClass object=it.next();
//							if(eobject.eClass().isInstance(object)){
//								elementsChoice.add(eobject);
//								//System.out.println("not it"+eobject.toString());
//								break;
//							}
//							/*for(int i=0;i<tempList.length;i++){
//							if(eobject.toString().split("@")[0].contains(tempList[i])){
//								elementsChoice.add(eobject);
//								break;
//							}
//							
//							}*/
//						}
//							
//						}
//						
//					}
//					
//					return true;
//				}
//			} );
//		} catch (CoreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return elementsChoice;
//	}
//
//	@Override
//	public AadlProcessingSwitch getSwitch( 	final Collection<NamedElement> p_currentElements, 
//											final Collection<NamedElement> p_elementsChoice ) {
//		return new PredefResExcludingAadlProcessingSwitch( p_currentElements, p_elementsChoice ) {
//			
//			@Override
//			protected void initSwitches() {
//				coreSwitch = new CoreSwitch() {
//					
//					@Override
//					public Object caseAadlSpec( final AadlSpec p_element ) {
//						return addElement( p_element );
//					}
//				};
//				
//				instanceSwitch = new InstanceSwitch() {
//					
//					@Override
//					public Object caseSystemInstance( final SystemInstance p_element ) {
//						return addElement( p_element );
//					}
//				};
//			}
//		};
//	}
}
