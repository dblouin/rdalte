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
package fr.openpeople.rdal.model.core.diagram.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;

import fr.openpeople.rdal.model.core.AbstractRequirement;
import fr.openpeople.rdal.model.core.Assumption;
import fr.openpeople.rdal.model.core.ContractualElement;
import fr.openpeople.rdal.model.core.CorePackage;
import fr.openpeople.rdal.model.core.Requirement;
import fr.openpeople.rdal.model.core.StakeHolder;
import fr.openpeople.rdal.model.core.VerificationActivity;
import fr.openpeople.rdal.model.core.diagram.edit.helpers.RdalBaseEditHelper;
import fr.openpeople.rdal.model.core.diagram.expressions.RdalOCLFactory;
import fr.openpeople.rdal.model.core.diagram.part.RdalDiagramEditorPlugin;
import fr.openpeople.rdal.model.core.diagram.part.RdalVisualIDRegistry;
import fr.openpeople.rdal.model.core.diagram.providers.RdalElementTypes;

/**
 * @generated
 */
public class RdalBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * Extended request data key to hold editpart visual id.
	 * @generated
	 */
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final IElementType myElementType;

	/**
	 * @generated
	 */
	protected RdalBaseItemSemanticEditPolicy(IElementType elementType) {
		myElementType = elementType;
	}

	/**
	 * Extended request data key to hold editpart visual id.
	 * Add visual id of edited editpart to extended data of the request
	 * so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram
	 * element kind from domain element.
	 * 
	 * @generated
	 */
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart()
					.getModel();
			if (view instanceof View) {
				Integer id = new Integer(
						RdalVisualIDRegistry.getVisualID((View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest,
				semanticCommand);
		if (completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(
					semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand,
			DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(
				getEditingDomain(), (View) getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand
				.chain(deleteViewCommand);
	}

	/**
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request,
			Command editPolicyCommand) {
		if (editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand)
					.getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(RdalBaseEditHelper.EDIT_POLICY_COMMAND,
					command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(RdalBaseEditHelper.CONTEXT_ELEMENT_TYPE,
				requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(RdalBaseEditHelper.EDIT_POLICY_COMMAND, null);
		request.setParameter(RdalBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
		if (command != null) {
			if (!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(),
						command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * @generated
	 */
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = RdalElementTypes
				.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType
				: myElementType;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(MoveRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * Returns editing domain from the host edit part.
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram
	 * @generated
	 */
	protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
		assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
		for (Iterator it = view.getDiagram().getChildren().iterator(); it
				.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			cmd.add(new DeleteCommand(getEditingDomain(), nextView));
		}
	}

	/**
	 * @generated
	 */
	public static LinkConstraints getLinkConstraints() {
		LinkConstraints cached = RdalDiagramEditorPlugin.getInstance()
				.getLinkConstraints();
		if (cached == null) {
			RdalDiagramEditorPlugin.getInstance().setLinkConstraints(
					cached = new LinkConstraints());
		}
		return cached;
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		LinkConstraints() {
			// use static method #getLinkConstraints() to access instance
		}

		/**
		 * @generated
		 */
		public boolean canCreateAbstractRequirementContainedRequirements_4016(
				AbstractRequirement source, AbstractRequirement target) {
			if (source != null) {
				if (source.getContainedRequirements().contains(target)) {
					return false;
				}
			}

			return canExistAbstractRequirementContainedRequirements_4016(
					source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateContractualElementStakeHolders_4020(
				ContractualElement source, StakeHolder target) {
			if (source != null) {
				if (source.getStakeHolders().contains(target)) {
					return false;
				}
			}
			if (target != null
					&& (target.getContractualElements().contains(target))) {
				return false;
			}

			return canExistContractualElementStakeHolders_4020(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateAbstractRequirementVerifiedBy_4019(
				AbstractRequirement source, VerificationActivity target) {
			if (source != null) {
				if (source.getVerifiedBy().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getRequirement() != null)) {
				return false;
			}

			return canExistAbstractRequirementVerifiedBy_4019(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRequirementDerivedFrom_4014(Requirement source,
				Requirement target) {
			if (source != null) {
				if (source.getDerivedFrom().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getDerivations().contains(target))) {
				return false;
			}

			return canExistRequirementDerivedFrom_4014(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRequirementRefinedBy_4015(Requirement source,
				EObject target) {
			if (source != null) {
				if (source.getRefinedBy().contains(target)) {
					return false;
				}
			}

			return canExistRequirementRefinedBy_4015(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRequirementAssumptions_4017(Requirement source,
				Assumption target) {
			if (source != null) {
				if (source.getAssumptions().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getRequirements() != null)) {
				return false;
			}

			return canExistRequirementAssumptions_4017(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canExistAbstractRequirementContainedRequirements_4016(
				AbstractRequirement source, AbstractRequirement target) {
			try {
				if (target == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections
							.<String, EClassifier> singletonMap(
									"oppositeEnd", CorePackage.eINSTANCE.getAbstractRequirement()); //$NON-NLS-1$
					Object targetVal = RdalOCLFactory
							.getExpression(
									0,
									CorePackage.eINSTANCE
											.getAbstractRequirement(), env)
							.evaluate(
									target,
									Collections.singletonMap(
											"oppositeEnd", source)); //$NON-NLS-1$
					if (false == targetVal instanceof Boolean
							|| !((Boolean) targetVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				RdalDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistContractualElementStakeHolders_4020(
				ContractualElement source, StakeHolder target) {
			try {
				if (source == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections
							.<String, EClassifier> singletonMap(
									"oppositeEnd", CorePackage.eINSTANCE.getStakeHolder()); //$NON-NLS-1$
					Object sourceVal = RdalOCLFactory.getExpression(1,
							CorePackage.eINSTANCE.getContractualElement(), env)
							.evaluate(
									source,
									Collections.singletonMap(
											"oppositeEnd", target)); //$NON-NLS-1$
					if (false == sourceVal instanceof Boolean
							|| !((Boolean) sourceVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				RdalDiagramEditorPlugin.getInstance().logError(
						"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistAbstractRequirementVerifiedBy_4019(
				AbstractRequirement source, VerificationActivity target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRequirementDerivedFrom_4014(Requirement source,
				Requirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRequirementRefinedBy_4015(Requirement source,
				EObject target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRequirementAssumptions_4017(Requirement source,
				Assumption target) {
			return true;
		}
	}

}
