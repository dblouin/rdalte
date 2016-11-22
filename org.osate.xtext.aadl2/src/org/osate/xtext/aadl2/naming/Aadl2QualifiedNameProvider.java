/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.naming;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Flow;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.operations.NamedElementOperations;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexRegistry;

public class Aadl2QualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	AnnexLinkingServiceRegistry annexlinkingserviceregistry;

	protected AnnexLinkingServiceRegistry getAnnexLinkingServiceRegistry() {
		if (annexlinkingserviceregistry == null) {
			annexlinkingserviceregistry = (AnnexLinkingServiceRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID);
		}
		return annexlinkingserviceregistry;
	}

	// Enable to limit indexing to global items
	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		if (!(obj instanceof NamedElement)) {
			return null;
		}
		NamedElement annex = AadlUtil.getContainingAnnex(obj);
		if (annex != null) {
			String annexName = annex.getName();
			if (annexName != null) {
				if (annexlinkingserviceregistry == null) {
					getAnnexLinkingServiceRegistry();
				}
				if (annexlinkingserviceregistry != null) {
					AnnexLinkingService linkingservice = getAnnexLinkingServiceRegistry()
							.getAnnexLinkingService(annexName);
					if (linkingservice != null) {
						return linkingservice.getFullyQualifiedName(obj);
					}
				}
			}
		}
		if (obj instanceof AadlPackage || obj instanceof Classifier || obj instanceof PropertyConstant
				|| obj instanceof Property || obj instanceof PropertySet || obj instanceof PropertyType ||
				// DB: We also want a qualified name for package sections
				obj instanceof PackageSection ||
				// DB: We also want a qualified name for features
				obj instanceof Feature ||
				// DB: We also want a qualified name for subcomponents
				obj instanceof Subcomponent ||
				obj instanceof Connection ||
				obj instanceof Flow ) {
			final String name = getTheName( (NamedElement) obj );
			
			if ( name != null ) {
				return getConverter().toQualifiedName( name );
			}
//			if (((NamedElement) obj).getName() == null) {
//				return null;
//			}
//			return getConverter().toQualifiedName(getTheName((NamedElement) obj));
		}

		return null;
	}

//	protected String getTheName(NamedElement namedElement) {
//		if (namedElement.getName() != null) {
//			Namespace namespace = namedElement.getNamespace();
//			if (namespace != null) {
//				if (namespace instanceof PropertySet && namespace.hasName()) {
//					return namespace.getName() + "::" + namedElement.getName();
//				} else if (namespace instanceof PackageSection && ((AadlPackage) namespace.getOwner()).hasName()) {
//					return ((AadlPackage) namespace.getOwner()).getName() + "::" + namedElement.getName();
//				} else {
//					return namedElement.getName();
//				}
//			} else {
//				return namedElement.getName();
//			}
//		} else {
//			return "<noname>";
//		}
//	}
//

	protected String getTheName(NamedElement namedElement) {
		// DB Work around to avoid cyclic resolution of lazy link error for refined features and subcomponents
		if ( 	namedElement instanceof Feature &&
				( (Feature) namedElement ).eIsSet( Aadl2Package.eINSTANCE.getFeature_Refined() ) ) {
	         return qualifiedName( namedElement, getNameFromNode( namedElement, Aadl2Package.eINSTANCE.getFeature_Refined() ) );
	    }

		if ( 	namedElement instanceof Subcomponent &&
				( (Subcomponent) namedElement ).eIsSet( Aadl2Package.eINSTANCE.getSubcomponent_Refined() ) ) {
	         return qualifiedName( namedElement, getNameFromNode( namedElement, Aadl2Package.eINSTANCE.getSubcomponent_Refined() ) );
	    }

		if ( namedElement.getName() != null ) {
		
			// DB: Reuse the logic coded in the model. The previous commented code erroneously returned the simple name for features.
			return namedElement.getQualifiedName();
		}
				
		return null;
	}
	
	/**
	 * DB: Added to fix qualified name provider problem of refined features
	 * @param p_namedElement
	 * @param p_elemName
	 * @return
	 */
	public String qualifiedName(	final NamedElement p_namedElement,
									final String p_elemName ) {
		final Namespace namespace = p_namedElement.getNamespace();
			
		if ( namespace != null ) {
			if ( namespace instanceof PropertySet && namespace.hasName() ) {
				return namespace.getName() + "::" + p_elemName;
			}
			
			if ( namespace instanceof PackageSection && ( (AadlPackage) namespace.getOwner() ).hasName() ) {
				return ((AadlPackage) namespace.getOwner()).getName() + getDelimiter() + p_elemName;
			}
			
			return NamedElementOperations.qualifiedName( namespace ) + '.' + p_elemName;
		}
		
		return p_elemName;
	}
	
	private String getNameFromNode( final NamedElement p_namedElement,
									final EStructuralFeature p_feature ) {
		 final List<INode> nodes = NodeModelUtils.findNodesForFeature( p_namedElement, p_feature );
         final INode first = nodes.get( 0 );
         
         return NodeModelUtils.getTokenText( first );
	}

	public String getDelimiter() {
		return "::";
	}
}