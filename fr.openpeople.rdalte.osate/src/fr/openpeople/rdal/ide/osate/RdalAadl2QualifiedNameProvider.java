package fr.openpeople.rdal.ide.osate;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.xtext.naming.QualifiedName;
//import org.eclipse.xtext.nodemodel.INode;
//import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Flow;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.Subcomponent;
//import org.osate.aadl2.operations.NamedElementOperations;
//import org.osate.xtext.aadl2.naming.Aadl2QualifiedNameProvider;

public class RdalAadl2QualifiedNameProvider {//extends Aadl2QualifiedNameProvider {

//	@Override
//	public QualifiedName getFullyQualifiedName(final EObject obj) {
//		if ( obj instanceof Feature || obj instanceof Subcomponent || obj instanceof Flow ) {
//			final String name = getTheName( (NamedElement) obj );
//			
//			if ( name != null ) {
//				return getConverter().toQualifiedName( name );
//			}
//		}
//		
//		return super.getFullyQualifiedName( obj );
//	}
//
//	protected String getTheName(NamedElement namedElement) {
//		// DB Work around to avoid cyclic resolution of lazy link error for refined features and subcomponents
//		if ( 	namedElement instanceof Feature &&
//				( (Feature) namedElement ).eIsSet( Aadl2Package.eINSTANCE.getFeature_Refined() ) ) {
//	         return qualifiedName( namedElement, getNameFromNode( namedElement, Aadl2Package.eINSTANCE.getFeature_Refined() ) );
//	    }
//
//		if ( 	namedElement instanceof Subcomponent &&
//				( (Subcomponent) namedElement ).eIsSet( Aadl2Package.eINSTANCE.getSubcomponent_Refined() ) ) {
//	         return qualifiedName( namedElement, getNameFromNode( namedElement, Aadl2Package.eINSTANCE.getSubcomponent_Refined() ) );
//	    }
//
//		if ( namedElement.getName() != null ) {
//		
//			// DB: Reuse the logic coded in the model. The previous commented code erroneously returned the simple name for features.
//			return namedElement.getQualifiedName();
//		}
//				
//		return null;
//	}
//	
//	/**
//	 * DB: Added to fix qualified name provider problem of refined features
//	 * @param p_namedElement
//	 * @param p_elemName
//	 * @return
//	 */
//	public String qualifiedName(	final NamedElement p_namedElement,
//									final String p_elemName ) {
//		final Namespace namespace = p_namedElement.getNamespace();
//			
//		if ( namespace != null ) {
//			if ( namespace instanceof PropertySet && namespace.hasName() ) {
//				return namespace.getName() + "::" + p_elemName;
//			}
//			
//			if ( namespace instanceof PackageSection && ( (AadlPackage) namespace.getOwner() ).hasName() ) {
//				return ((AadlPackage) namespace.getOwner()).getName() + getDelimiter() + p_elemName;
//			}
//			
//			return NamedElementOperations.qualifiedName( namespace ) + '.' + p_elemName;
//		}
//		
//		return p_elemName;
//	}
//	
//	private String getNameFromNode( final NamedElement p_namedElement,
//									final EStructuralFeature p_feature ) {
//		 final List<INode> nodes = NodeModelUtils.findNodesForFeature( p_namedElement, p_feature );
//         final INode first = nodes.get( 0 );
//         
//         return NodeModelUtils.getTokenText( first );
//	}
}
