package fr.openpeople.rdalte.compatibility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.labsticc.framework.compatibility.ICompatibilityUpdater;
import fr.labsticc.framework.compatibility.IUpdatedData;
import fr.labsticc.framework.compatibility.UpdatedData;
import fr.labsticc.framework.constraints.ide.ConstraintsIDEPlugin;
import fr.labsticc.framework.constraints.model.constraints.FormalConstraintLanguage;
import fr.labsticc.framework.constraints.model.constraints.FormalLanguageExpression;
import fr.labsticc.framework.core.exception.ResourceAccessException;
import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.RefExpressionCollectedModelElements;

public class Constraints11RequirementCompatibilityUpdater implements ICompatibilityUpdater {
	
	private static final String OLD_OCL_LANGUAGE_ID = "fr.labsticc.framework.constraints.service.ocl.ocl";
	private static final String NEW_OCL_LANGUAGE_ID = "fr.labsticc.framework.constraints.ocl";
	private static final String UPDATE_SUMMARY = "Update of RDAL specifications following constraints framework refactoring.";
	private static final String OCL_ID_UPDATE = "Rename OCL language ID from \"" + OLD_OCL_LANGUAGE_ID + "\" to \"" + NEW_OCL_LANGUAGE_ID + "\" ";
	
	private final FormalConstraintLanguage newOclLanguage;
	
	private final ResourceSet resSet;
	
	public Constraints11RequirementCompatibilityUpdater() {
		newOclLanguage = (FormalConstraintLanguage) ConstraintsIDEPlugin.getDefault().getSpecification().languageById( NEW_OCL_LANGUAGE_ID );
		resSet = new ResourceSetImpl();
	}

	@Override
	public IUpdatedData update( final IFile p_file ) 
	throws ResourceAccessException {
		if ( 	newOclLanguage == null || 
				( !"rdal".equals( p_file.getFileExtension() ) ) ) {
			return null;
		}
		
		final List<String> info = new ArrayList<String>();
		final Resource emfRes = resSet.getResource( URI.createPlatformResourceURI( p_file.getFullPath().toString(), true ), true );
		final Iterator<EObject> containedObjectsIt = emfRes.getAllContents();
		
		while ( containedObjectsIt.hasNext() ) {
			final EObject object = containedObjectsIt.next();
			
			if ( object instanceof FormalLanguageExpression  ) {
				final FormalLanguageExpression expression = (FormalLanguageExpression) object;
				final FormalConstraintLanguage language = (FormalConstraintLanguage) expression.getLanguage();
				final String languageId;
				
				if ( language.eIsProxy() ) {
					final URI unresUri = EcoreUtil.getURI( language );
					languageId = unresUri.fragment();
				}
				else {
					languageId = language.getId();
				}
				
				if ( OLD_OCL_LANGUAGE_ID.equals( languageId ) ) {
					info.add( createUpdateInfoDetail( expression ) );
					expression.setLanguage( newOclLanguage );
				}
			}
		}
		
		try {
			final ByteArrayOutputStream byteStr = new ByteArrayOutputStream();
			emfRes.save( byteStr, null );
			
			return new UpdatedData( this, info, byteStr.toByteArray(), !info.isEmpty() );
		}
		catch ( final IOException p_ex ) {
			throw new ResourceAccessException( p_ex );
		}
	}
	
	private String createUpdateInfoDetail( final FormalLanguageExpression p_expression ) {
		final EObject parent = p_expression.eContainer();
		final StringBuilder strBuilder = new StringBuilder( OCL_ID_UPDATE + "for expression " );
		final AbstractRequirement requirement;
		
		if ( parent instanceof AbstractRequirement ) {
			requirement = (AbstractRequirement) parent;
		}
		else if ( parent instanceof RefExpressionCollectedModelElements ) {
			requirement = (AbstractRequirement) ( (RefExpressionCollectedModelElements) parent ).eContainer();
			strBuilder.append( " collecting design elements" );
		}
		else {
			requirement = null;
		}
		
		if ( requirement != null ) {
			strBuilder.append( " of requirement \"" + requirement.getName() + "\"" );
		}
		
		return strBuilder.toString();
	}

	@Override
	public String getDescription() {
		return UPDATE_SUMMARY;
	}

	@Override
	public String getUpdateId() {
		return getClass().getName();
	}
}
