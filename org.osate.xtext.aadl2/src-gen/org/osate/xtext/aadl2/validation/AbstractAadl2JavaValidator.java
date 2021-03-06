/*
 * generated by Xtext
 */
package org.osate.xtext.aadl2.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractAadl2JavaValidator extends org.osate.xtext.aadl2.properties.validation.PropertiesJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://aadl.info/AADL/2.0"));
		return result;
	}

}
