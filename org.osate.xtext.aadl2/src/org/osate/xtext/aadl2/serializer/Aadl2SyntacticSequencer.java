/**
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
package org.osate.xtext.aadl2.serializer;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.serializer.AbstractAadl2SyntacticSequencer;

@SuppressWarnings("all")
public class Aadl2SyntacticSequencer extends AbstractAadl2SyntacticSequencer {
  @Override
  protected String getIDToken(final EObject semanticObject, final RuleCall ruleCall, final INode node) {
    String _xifexpression = null;
    if ((semanticObject instanceof Classifier)) {
      _xifexpression = ((Classifier)semanticObject).getName();
    } else {
      String _xifexpression_1 = null;
      if ((semanticObject instanceof AadlPackage)) {
        _xifexpression_1 = ((AadlPackage)semanticObject).getName();
      } else {
        _xifexpression_1 = super.getIDToken(semanticObject, ruleCall, node);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  protected String getFULLINAMEToken(final EObject semanticObject, final RuleCall ruleCall, final INode node) {
    String _xifexpression = null;
    if ((semanticObject instanceof ComponentImplementation)) {
      _xifexpression = ((ComponentImplementation)semanticObject).getName();
    } else {
      _xifexpression = super.getFULLINAMEToken(semanticObject, ruleCall, node);
    }
    return _xifexpression;
  }
  
  @Override
  protected String getPNAMEToken(final EObject semanticObject, final RuleCall ruleCall, final INode node) {
    String _xifexpression = null;
    if ((semanticObject instanceof AadlPackage)) {
      _xifexpression = ((AadlPackage)semanticObject).getName();
    } else {
      _xifexpression = super.getPNAMEToken(semanticObject, ruleCall, node);
    }
    return _xifexpression;
  }
  
  @Override
  protected String getFLOWOUTToken(final EObject semanticObject, final RuleCall ruleCall, final INode node) {
    String _xifexpression = null;
    if ((semanticObject instanceof FlowImplementation)) {
      String _xblockexpression = null;
      {
        FlowSpecification _specification = ((FlowImplementation)semanticObject).getSpecification();
        final FlowEnd outend = _specification.getOutEnd();
        FlowSpecification _specification_1 = ((FlowImplementation)semanticObject).getSpecification();
        final FlowEnd inend = _specification_1.getInEnd();
        String _xifexpression_1 = null;
        FlowKind _kind = ((FlowImplementation)semanticObject).getKind();
        boolean _equals = Objects.equal(_kind, FlowKind.SINK);
        if (_equals) {
          String _xifexpression_2 = null;
          boolean _and = false;
          boolean _equals_1 = Objects.equal(outend, null);
          if (!_equals_1) {
            _and = false;
          } else {
            boolean _notEquals = (!Objects.equal(inend, null));
            _and = _notEquals;
          }
          if (_and) {
            _xifexpression_2 = AadlUtil.getFlowEndName(inend);
          } else {
            _xifexpression_2 = AadlUtil.getFlowEndName(outend);
          }
          _xifexpression_1 = _xifexpression_2;
        } else {
          String _xblockexpression_1 = null;
          {
            String _xifexpression_3 = null;
            boolean _and_1 = false;
            FlowKind _kind_1 = ((FlowImplementation)semanticObject).getKind();
            boolean _equals_2 = Objects.equal(_kind_1, FlowKind.PATH);
            if (!_equals_2) {
              _and_1 = false;
            } else {
              EList<FlowSegment> _ownedFlowSegments = ((FlowImplementation)semanticObject).getOwnedFlowSegments();
              boolean _isEmpty = _ownedFlowSegments.isEmpty();
              _and_1 = _isEmpty;
            }
            if (_and_1) {
              String _flowEndName = AadlUtil.getFlowEndName(inend);
              _xifexpression_3 = (_flowEndName + " -> ");
            } else {
              _xifexpression_3 = "";
            }
            final String head = _xifexpression_3;
            String _flowEndName_1 = AadlUtil.getFlowEndName(outend);
            _xblockexpression_1 = (head + _flowEndName_1);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.getFLOWOUTToken(semanticObject, ruleCall, node);
    }
    return _xifexpression;
  }
  
  @Override
  protected String getFLOWINToken(final EObject semanticObject, final RuleCall ruleCall, final INode node) {
    String _xifexpression = null;
    if ((semanticObject instanceof FlowImplementation)) {
      String _xblockexpression = null;
      {
        FlowSpecification _specification = ((FlowImplementation)semanticObject).getSpecification();
        final FlowEnd inend = _specification.getInEnd();
        _xblockexpression = AadlUtil.getFlowEndName(inend);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.getFLOWINToken(semanticObject, ruleCall, node);
    }
    return _xifexpression;
  }
}
