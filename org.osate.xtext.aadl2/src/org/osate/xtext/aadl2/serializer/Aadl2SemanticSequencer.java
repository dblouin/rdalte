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
import com.google.inject.Inject;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.xtext.aadl2.Activator;
import org.osate.xtext.aadl2.serializer.AbstractAadl2SemanticSequencer;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class Aadl2SemanticSequencer extends AbstractAadl2SemanticSequencer {
  @Inject
  private Aadl2GrammarAccess grammarAccess;
  
  AnnexUnparserRegistry unparserRegistry;
  
  protected AnnexUnparserRegistry getAnnexUnparserRegistry() {
    AnnexUnparserRegistry _elvis = null;
    if (this.unparserRegistry != null) {
      _elvis = this.unparserRegistry;
    } else {
      AnnexRegistry _registry = AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
      _elvis = (this.unparserRegistry = ((AnnexUnparserRegistry) _registry));
    }
    return _elvis;
  }
  
  @Override
  public void createSequence(final EObject context, final EObject semanticObject) {
    boolean _matched = false;
    if (!_matched) {
      if (semanticObject instanceof DefaultAnnexLibrary) {
        boolean _or = false;
        ParserRule _annexLibraryRule = this.grammarAccess.getAnnexLibraryRule();
        boolean _equals = Objects.equal(context, _annexLibraryRule);
        if (_equals) {
          _or = true;
        } else {
          ParserRule _defaultAnnexLibraryRule = this.grammarAccess.getDefaultAnnexLibraryRule();
          boolean _equals_1 = Objects.equal(context, _defaultAnnexLibraryRule);
          _or = _equals_1;
        }
        if (_or) {
          _matched=true;
          final AnnexLibrary parsedLibrary = ((DefaultAnnexLibrary)semanticObject).getParsedAnnexLibrary();
          AnnexUnparserRegistry _annexUnparserRegistry = this.getAnnexUnparserRegistry();
          String _name = ((DefaultAnnexLibrary)semanticObject).getName();
          final AnnexUnparser annexUnparser = _annexUnparserRegistry.getAnnexUnparser(_name);
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(parsedLibrary, null));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _notEquals_1 = (!Objects.equal(annexUnparser, null));
            _and = _notEquals_1;
          }
          if (_and) {
            try {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("{**");
              String _unparseAnnexLibrary = annexUnparser.unparseAnnexLibrary(parsedLibrary, "  ");
              _builder.append(_unparseAnnexLibrary, "");
              _builder.append("**}");
              final String text = _builder.toString();
              final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
              CommandStack _commandStack = domain.getCommandStack();
              _commandStack.execute(new RecordingCommand(domain) {
                @Override
                protected void doExecute() {
                  ((DefaultAnnexLibrary) semanticObject).setSourceText(text);
                }
              });
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
                Activator _default = Activator.getDefault();
                ILog _log = _default.getLog();
                Activator _default_1 = Activator.getDefault();
                Bundle _bundle = _default_1.getBundle();
                String _symbolicName = _bundle.getSymbolicName();
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("Error while serializing ");
                String _name_1 = ((DefaultAnnexLibrary)semanticObject).getName();
                _builder_1.append(_name_1, "");
                _builder_1.append(" annex library");
                Status _status = new Status(IStatus.ERROR, _symbolicName, _builder_1.toString(), e);
                _log.log(_status);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          this.sequence_DefaultAnnexLibrary(context, ((DefaultAnnexLibrary)semanticObject));
        }
      }
    }
    if (!_matched) {
      if (semanticObject instanceof DefaultAnnexSubclause) {
        boolean _or = false;
        ParserRule _annexSubclauseRule = this.grammarAccess.getAnnexSubclauseRule();
        boolean _equals = Objects.equal(context, _annexSubclauseRule);
        if (_equals) {
          _or = true;
        } else {
          ParserRule _defaultAnnexSubclauseRule = this.grammarAccess.getDefaultAnnexSubclauseRule();
          boolean _equals_1 = Objects.equal(context, _defaultAnnexSubclauseRule);
          _or = _equals_1;
        }
        if (_or) {
          _matched=true;
          final AnnexSubclause parsedSubclause = ((DefaultAnnexSubclause)semanticObject).getParsedAnnexSubclause();
          AnnexUnparserRegistry _annexUnparserRegistry = this.getAnnexUnparserRegistry();
          String _name = ((DefaultAnnexSubclause)semanticObject).getName();
          final AnnexUnparser annexUnparser = _annexUnparserRegistry.getAnnexUnparser(_name);
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(parsedSubclause, null));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _notEquals_1 = (!Objects.equal(annexUnparser, null));
            _and = _notEquals_1;
          }
          if (_and) {
            try {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("{**");
              String _unparseAnnexSubclause = annexUnparser.unparseAnnexSubclause(parsedSubclause, "  ");
              _builder.append(_unparseAnnexSubclause, "");
              _builder.append("**}");
              final String text = _builder.toString();
              final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
              CommandStack _commandStack = domain.getCommandStack();
              _commandStack.execute(new RecordingCommand(domain) {
                @Override
                protected void doExecute() {
                  ((DefaultAnnexSubclause) semanticObject).setSourceText(text);
                }
              });
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
                Activator _default = Activator.getDefault();
                ILog _log = _default.getLog();
                Activator _default_1 = Activator.getDefault();
                Bundle _bundle = _default_1.getBundle();
                String _symbolicName = _bundle.getSymbolicName();
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("Error while serializing ");
                String _name_1 = ((DefaultAnnexSubclause)semanticObject).getName();
                _builder_1.append(_name_1, "");
                _builder_1.append(" annex subclause");
                Status _status = new Status(IStatus.ERROR, _symbolicName, _builder_1.toString(), e);
                _log.log(_status);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          this.sequence_DefaultAnnexSubclause(context, ((DefaultAnnexSubclause)semanticObject));
        }
      }
    }
    if (!_matched) {
      super.createSequence(context, semanticObject);
    }
  }
}
