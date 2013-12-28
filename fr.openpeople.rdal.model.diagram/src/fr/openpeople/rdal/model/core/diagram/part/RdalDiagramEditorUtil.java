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
package fr.openpeople.rdal.model.core.diagram.part;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import fr.labsticc.framework.constraints.ide.ConstraintsIDEPlugin;
import fr.openpeople.rdal.model.core.CoreFactory;
import fr.openpeople.rdal.model.core.Specification;
import fr.openpeople.rdal.model.core.diagram.edit.parts.SpecificationEditPart;

/**
 * @generated
 */
public class RdalDiagramEditorUtil {

	/**
	 * @generated
	 */
	public static Map<?, ?> getSaveOptions() {
		HashMap<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		return saveOptions;
	}

	/**
	 * @generated
	 */
	public static boolean openDiagram(Resource diagram)
			throws PartInitException {
		String path = diagram.getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(path));
		if (workspaceResource instanceof IFile) {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			return null != page.openEditor(new FileEditorInput(
					(IFile) workspaceResource), RdalDiagramEditor.ID);
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static void setCharset(IFile file) {
		if (file == null) {
			return;
		}
		try {
			file.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
		} catch (CoreException e) {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Unable to set charset for file " + file.getFullPath(), e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public static String getUniqueFileName(IPath containerFullPath,
			String fileName, String extension) {
		if (containerFullPath == null) {
			containerFullPath = new Path(""); //$NON-NLS-1$
		}
		if (fileName == null || fileName.trim().length() == 0) {
			fileName = "default"; //$NON-NLS-1$
		}
		IPath filePath = containerFullPath.append(fileName);
		if (extension != null && !extension.equals(filePath.getFileExtension())) {
			filePath = filePath.addFileExtension(extension);
		}
		extension = filePath.getFileExtension();
		fileName = filePath.removeFileExtension().lastSegment();
		int i = 1;
		while (ResourcesPlugin.getWorkspace().getRoot().exists(filePath)) {
			i++;
			filePath = containerFullPath.append(fileName + i);
			if (extension != null) {
				filePath = filePath.addFileExtension(extension);
			}
		}
		return filePath.lastSegment();
	}

	/**
	 * Runs the wizard in a dialog.
	 * 
	 * @generated
	 */
	public static void runWizard(Shell shell, Wizard wizard, String settingsKey) {
		IDialogSettings pluginDialogSettings = RdalDiagramEditorPlugin
				.getInstance().getDialogSettings();
		IDialogSettings wizardDialogSettings = pluginDialogSettings
				.getSection(settingsKey);
		if (wizardDialogSettings == null) {
			wizardDialogSettings = pluginDialogSettings
					.addNewSection(settingsKey);
		}
		wizard.setDialogSettings(wizardDialogSettings);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.create();
		dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x),
				500);
		dialog.open();
	}

	/**
	 * This method should be called within a workspace modify operation since it creates resources.
	 * @generated NOT
	 */
	public static Resource createDiagram(URI diagramURI, URI modelURI,
			IProgressMonitor progressMonitor) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		progressMonitor.beginTask(
				Messages.RdalDiagramEditorUtil_CreateDiagramProgressTask, 3);
		final Resource diagramResource = editingDomain.getResourceSet()
				.createResource(diagramURI);

		final Resource modelResource;
		final IFile modelFile = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(modelURI.toPlatformString(true)));

		if (modelFile.exists()) {
			modelResource = editingDomain.getResourceSet().getResource(
					modelURI, true);
		} else {
			modelResource = editingDomain.getResourceSet().createResource(
					modelURI);
		}
		
		//createResource(modelURI);
		final String diagramName = diagramURI.lastSegment();
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				editingDomain,
				Messages.RdalDiagramEditorUtil_CreateDiagramCommandLabel,
				Collections.EMPTY_LIST) {
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				final Specification model;

				if (modelFile.exists()) {
					model = (Specification) modelResource.getContents().get(0);
				} else {
					model = createInitialModel();
					attachModelToResource(model, modelResource);
				}

				Diagram diagram = ViewService.createDiagram(model,
						SpecificationEditPart.MODEL_ID,
						RdalDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName(diagramName);
					diagram.setElement(model);
				}

				try {
					if (!modelFile.exists()) {
						modelResource
								.save(fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorUtil
										.getSaveOptions());
					}

					diagramResource
							.save(fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorUtil
									.getSaveOptions());
				} catch (IOException e) {

					RdalDiagramEditorPlugin.getInstance().logError(
							"Unable to store model and diagram resources", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new SubProgressMonitor(progressMonitor, 1), null);
		} catch (ExecutionException e) {
			RdalDiagramEditorPlugin.getInstance().logError(
					"Unable to create model and diagram", e); //$NON-NLS-1$
		}
		setCharset(WorkspaceSynchronizer.getFile(modelResource));
		setCharset(WorkspaceSynchronizer.getFile(diagramResource));
		return diagramResource;
	}

	/**
	 * Create a new instance of domain element associated with canvas.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private static Specification createInitialModel() {
		// FIXME: Eventually move to business delegate
		final Specification specification = CoreFactory.eINSTANCE
				.createSpecification();

		initDefaultConstraintLanguages(specification);

		return specification;
	}

	private static void initDefaultConstraintLanguages(
			final Specification p_specification) {
		p_specification.setConstraintLanguagesSpecification(ConstraintsIDEPlugin
				.getDefault().getSpecification());
	}

	//	
	//	/*
	//	 * new function
	//	 * get librarues from default.constraint
	//	 * 
	//	 * 
	//	 * */
	//	
	//
	//	private static void initDefaultConstraintLanguages(
	//			final Specification p_specification) {
	//		final ConstraintPlugin cstPlugin = ConstraintPlugin.getDefault();
	//
	//		for (final Map.Entry<String, fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage> languageEntry : cstPlugin
	//				.getDefinedConstraintLanguages().entrySet()) {
	//			final fr.labsticc.framework.constraints.model.constraints.ConstraintLanguage envCstLanguage = languageEntry
	//					.getValue();
	//			final ConstraintLanguage reqCstLanguage;
	//
	//			if (envCstLanguage instanceof fr.labsticc.framework.constraints.model.constraints.FormalConstraintLanguage) {
	//				reqCstLanguage = CoreFactory.eINSTANCE
	//						.createFormalConstraintLanguage();
	//
	//				// Must be set before initializing libs
	//				reqCstLanguage.setName(envCstLanguage.getName());
	//				initLibraries((FormalConstraintLanguage) reqCstLanguage);
	//			} else {
	//				reqCstLanguage = CoreFactory.eINSTANCE
	//						.createConstraintLanguage();
	//				reqCstLanguage.setName(envCstLanguage.getName());
	//			}
	//
	//			reqCstLanguage.setId(envCstLanguage.getId());
	//
	//			p_specification.getConstraintLanguages().add(reqCstLanguage);
	//		}
	//	}
	//
	//	private static void initLibraries(final FormalConstraintLanguage p_language) {
	//		final IPreferenceStore prefStore = RdalDiagramEditorPlugin
	//				.getInstance().getPreferenceStore();
	//
	//		final String location = prefStore
	//				.getString(IRdalPreferenceConstants.DEFAULT_LIBRARIES_LOCATION);
	//
	//		if (location != null && !"".equals(location)) {
	//			try {
	//				final String absolutePath = resourceHandler
	//						.locateResource(location);
	//				final String directoryPath = new File( absolutePath ).getPath();
	//
	//				for (final File libraryFile : FileUtil
	//						.findFilesOfTypeInDirectory(absolutePath, p_language
	//								.getName().toLowerCase(), true)) {
	//					if (libraryFile.isFile()) {
	//						final FormalLanguageExpression libExpression = CoreFactory.eINSTANCE
	//								.createFormalLanguageExpression();
	//						final String libraryPath = libraryFile.getPath();
	//
	//						try {
	//							libExpression.setText(FileUtil
	//									.getFileContent(libraryPath));
	//							final FormalLanguageLibrary library = CoreFactory.eINSTANCE
	//									.createFormalLanguageLibrary();
	//							final StringBuffer libraryId = new StringBuffer();
	//							
	//							File parent = libraryFile;
	//							
	//							while ( !directoryPath.equals( parent.getPath() ) ) {
	//								libraryId.insert( 0, FILE_SEPARATOR_CHAR + parent.getName() );
	//								parent = parent.getParentFile();
	//							}
	//
	//							library.setId( location + libraryId.toString() );
	//							library.setName(libraryFile.getName());
	//							library.setExpression(libExpression);
	//
	//							if (libraryFile.getParent().endsWith("default")) {
	//								library.setDefault(true);
	//							}
	//
	//							p_language.getLibraries().add(library);
	//						} catch (final IOException p_ex) {
	//							RdalDiagramEditorPlugin.getInstance().logError(
	//									null, p_ex);
	//						}
	//					}
	//				}
	//			} catch (final ResourceAccessException p_ex) {
	//				RdalDiagramEditorPlugin.getInstance().logError(null, p_ex);
	//			}
	//		}
	//	}

	/**
	 * Store model element in the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static void attachModelToResource(Specification model,
			Resource resource) {
		resource.getContents().add(model);
	}

	/**
	 * @generated
	 */
	public static void selectElementsInDiagram(
			IDiagramWorkbenchPart diagramPart, List<EditPart> editParts) {
		diagramPart.getDiagramGraphicalViewer().deselectAll();

		EditPart firstPrimary = null;
		for (EditPart nextPart : editParts) {
			diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
			if (firstPrimary == null && nextPart instanceof IPrimaryEditPart) {
				firstPrimary = nextPart;
			}
		}

		if (!editParts.isEmpty()) {
			diagramPart.getDiagramGraphicalViewer().reveal(
					firstPrimary != null ? firstPrimary : (EditPart) editParts
							.get(0));
		}
	}

	/**
	 * @generated
	 */
	private static int findElementsInDiagramByID(DiagramEditPart diagramPart,
			EObject element, List<EditPart> editPartCollector) {
		IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer) diagramPart
				.getViewer();
		final int intialNumOfEditParts = editPartCollector.size();

		if (element instanceof View) { // support notation element lookup
			EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(
					element);
			if (editPart != null) {
				editPartCollector.add(editPart);
				return 1;
			}
		}

		String elementID = EMFCoreUtil.getProxyID(element);
		@SuppressWarnings("unchecked")
		List<EditPart> associatedParts = viewer.findEditPartsForElement(
				elementID, IGraphicalEditPart.class);
		// perform the possible hierarchy disjoint -> take the top-most parts only
		for (EditPart nextPart : associatedParts) {
			EditPart parentPart = nextPart.getParent();
			while (parentPart != null && !associatedParts.contains(parentPart)) {
				parentPart = parentPart.getParent();
			}
			if (parentPart == null) {
				editPartCollector.add(nextPart);
			}
		}

		if (intialNumOfEditParts == editPartCollector.size()) {
			if (!associatedParts.isEmpty()) {
				editPartCollector.add(associatedParts.get(0));
			} else {
				if (element.eContainer() != null) {
					return findElementsInDiagramByID(diagramPart,
							element.eContainer(), editPartCollector);
				}
			}
		}
		return editPartCollector.size() - intialNumOfEditParts;
	}

	/**
	 * @generated
	 */
	public static View findView(DiagramEditPart diagramEditPart,
			EObject targetElement, LazyElement2ViewMap lazyElement2ViewMap) {
		boolean hasStructuralURI = false;
		if (targetElement.eResource() instanceof XMLResource) {
			hasStructuralURI = ((XMLResource) targetElement.eResource())
					.getID(targetElement) == null;
		}

		View view = null;
		LinkedList<EditPart> editPartHolder = new LinkedList<EditPart>();
		if (hasStructuralURI
				&& !lazyElement2ViewMap.getElement2ViewMap().isEmpty()) {
			view = lazyElement2ViewMap.getElement2ViewMap().get(targetElement);
		} else if (findElementsInDiagramByID(diagramEditPart, targetElement,
				editPartHolder) > 0) {
			EditPart editPart = editPartHolder.get(0);
			view = editPart.getModel() instanceof View ? (View) editPart
					.getModel() : null;
		}

		return (view == null) ? diagramEditPart.getDiagramView() : view;
	}

	/**
	 * @generated
	 */
	public static class LazyElement2ViewMap {
		/**
		 * @generated
		 */
		private Map<EObject, View> element2ViewMap;

		/**
		 * @generated
		 */
		private View scope;

		/**
		 * @generated
		 */
		private Set<? extends EObject> elementSet;

		/**
		 * @generated
		 */
		public LazyElement2ViewMap(View scope, Set<? extends EObject> elements) {
			this.scope = scope;
			this.elementSet = elements;
		}

		/**
		 * @generated
		 */
		public final Map<EObject, View> getElement2ViewMap() {
			if (element2ViewMap == null) {
				element2ViewMap = new HashMap<EObject, View>();
				// map possible notation elements to itself as these can't be found by view.getElement()
				for (EObject element : elementSet) {
					if (element instanceof View) {
						View view = (View) element;
						if (view.getDiagram() == scope.getDiagram()) {
							element2ViewMap.put(element, view); // take only those that part of our diagram
						}
					}
				}

				buildElement2ViewMap(scope, element2ViewMap, elementSet);
			}
			return element2ViewMap;
		}

		/**
		 * @generated
		 */
		private static boolean buildElement2ViewMap(View parentView,
				Map<EObject, View> element2ViewMap,
				Set<? extends EObject> elements) {
			if (elements.size() == element2ViewMap.size()) {
				return true;
			}

			if (parentView.isSetElement()
					&& !element2ViewMap.containsKey(parentView.getElement())
					&& elements.contains(parentView.getElement())) {
				element2ViewMap.put(parentView.getElement(), parentView);
				if (elements.size() == element2ViewMap.size()) {
					return true;
				}
			}
			boolean complete = false;
			for (Iterator<?> it = parentView.getChildren().iterator(); it
					.hasNext() && !complete;) {
				complete = buildElement2ViewMap((View) it.next(),
						element2ViewMap, elements);
			}
			for (Iterator<?> it = parentView.getSourceEdges().iterator(); it
					.hasNext() && !complete;) {
				complete = buildElement2ViewMap((View) it.next(),
						element2ViewMap, elements);
			}
			for (Iterator<?> it = parentView.getTargetEdges().iterator(); it
					.hasNext() && !complete;) {
				complete = buildElement2ViewMap((View) it.next(),
						element2ViewMap, elements);
			}
			return complete;
		}
	} //LazyElement2ViewMap	

}
