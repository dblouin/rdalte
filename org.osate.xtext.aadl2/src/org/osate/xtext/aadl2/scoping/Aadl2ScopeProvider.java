/**
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
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
package org.osate.xtext.aadl2.scoping;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractSubcomponentType;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.BusSubcomponentType;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DeviceSubcomponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.MemorySubcomponentType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PortProxy;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessSubcomponentType;
import org.osate.aadl2.ProcessorSubcomponentType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SystemSubcomponentType;
import org.osate.aadl2.ThreadGroupSubcomponentType;
import org.osate.aadl2.ThreadSubcomponentType;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.VirtualBusSubcomponentType;
import org.osate.aadl2.VirtualProcessorSubcomponentType;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 */
@SuppressWarnings("all")
public class Aadl2ScopeProvider extends PropertiesScopeProvider {
  public IScope scope_TypeExtension_extended(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_ComponentImplementation(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_GroupExtension_extended(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_FeatureGroupPrototype_constrainingFeatureGroupType(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_FeatureGroupType_inverse(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_Realization_implemented(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_SubprogramCall_context(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IScope scope = this.scope_Classifier(context, reference);
      IScope _elvis = null;
      BehavioredImplementation _containerOfType = EcoreUtil2.<BehavioredImplementation>getContainerOfType(context, BehavioredImplementation.class);
      EList<NamedElement> _members = null;
      if (_containerOfType!=null) {
        _members=_containerOfType.getMembers();
      }
      Iterable<CallContext> _filter = null;
      if (_members!=null) {
        _filter=Iterables.<CallContext>filter(_members, CallContext.class);
      }
      Iterable<CallContext> _filterRefined = null;
      if (_filter!=null) {
        _filterRefined=PropertiesScopeProvider.<CallContext>filterRefined(_filter);
      }
      SimpleScope _scopeFor = null;
      if (_filterRefined!=null) {
        _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined, scope);
      }
      if (_scopeFor != null) {
        _elvis = _scopeFor;
      } else {
        _elvis = scope;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  public IScope scope_SubprogramCall_calledSubprogram(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IScope scope = this.scope_Classifier(context, reference);
      SubprogramCall _containerOfType = EcoreUtil2.<SubprogramCall>getContainerOfType(context, SubprogramCall.class);
      CallContext _context = null;
      if (_containerOfType!=null) {
        _context=_containerOfType.getContext();
      }
      final CallContext callContext = _context;
      boolean _equals = Objects.equal(callContext, null);
      if (_equals) {
        Classifier _containerOfType_1 = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
        EList<NamedElement> _members = _containerOfType_1.getMembers();
        Iterable<CalledSubprogram> _filter = Iterables.<CalledSubprogram>filter(_members, CalledSubprogram.class);
        Iterable<CalledSubprogram> _filterRefined = PropertiesScopeProvider.<CalledSubprogram>filterRefined(_filter);
        SimpleScope _scopeFor = PropertiesScopeProvider.scopeFor(_filterRefined, scope);
        scope = _scopeFor;
      } else {
        scope = IScope.NULLSCOPE;
        Classifier callContextNamespace = null;
        boolean _matched = false;
        if (!_matched) {
          if (callContext instanceof ComponentType) {
            _matched=true;
            AadlPackage _containerOfType_2 = EcoreUtil2.<AadlPackage>getContainerOfType(callContext, AadlPackage.class);
            PublicPackageSection _publicSection = _containerOfType_2.getPublicSection();
            EList<Classifier> _ownedClassifiers = _publicSection.getOwnedClassifiers();
            final ArrayList<Classifier> packageClassifiers = new ArrayList<Classifier>(_ownedClassifiers);
            final PackageSection packageSectionForComponentType = EcoreUtil2.<PackageSection>getContainerOfType(callContext, PackageSection.class);
            boolean _and = false;
            if (!(packageSectionForComponentType instanceof PrivatePackageSection)) {
              _and = false;
            } else {
              PrivatePackageSection _containerOfType_3 = EcoreUtil2.<PrivatePackageSection>getContainerOfType(context, PrivatePackageSection.class);
              boolean _equals_1 = Objects.equal(packageSectionForComponentType, _containerOfType_3);
              _and = _equals_1;
            }
            if (_and) {
              EList<Classifier> _ownedClassifiers_1 = packageSectionForComponentType.getOwnedClassifiers();
              packageClassifiers.addAll(_ownedClassifiers_1);
            }
            Iterable<CalledSubprogram> _filter_1 = Iterables.<CalledSubprogram>filter(packageClassifiers, CalledSubprogram.class);
            Iterable<ComponentImplementation> _filter_2 = Iterables.<ComponentImplementation>filter(_filter_1, ComponentImplementation.class);
            final Function1<ComponentImplementation, Boolean> _function = new Function1<ComponentImplementation, Boolean>() {
              @Override
              public Boolean apply(final ComponentImplementation it) {
                ComponentType _type = it.getType();
                return Boolean.valueOf(Objects.equal(_type, callContext));
              }
            };
            Iterable<ComponentImplementation> _filter_3 = IterableExtensions.<ComponentImplementation>filter(_filter_2, _function);
            final Function1<ComponentImplementation, QualifiedName> _function_1 = new Function1<ComponentImplementation, QualifiedName>() {
              @Override
              public QualifiedName apply(final ComponentImplementation it) {
                String _name = it.getName();
                String _name_1 = it.getName();
                int _lastIndexOf = _name_1.lastIndexOf(".");
                int _plus = (_lastIndexOf + 1);
                String _substring = _name.substring(_plus);
                return QualifiedName.create(_substring);
              }
            };
            SimpleScope _scopeFor_1 = PropertiesScopeProvider.<ComponentImplementation>scopeFor(_filter_3, _function_1, IScope.NULLSCOPE);
            scope = _scopeFor_1;
            callContextNamespace = ((ComponentType)callContext);
          }
        }
        if (!_matched) {
          if (callContext instanceof SubprogramGroupSubcomponent) {
            _matched=true;
            ComponentType _componentType = ((SubprogramGroupSubcomponent)callContext).getComponentType();
            callContextNamespace = _componentType;
          }
        }
        if (!_matched) {
          if (callContext instanceof SubprogramGroupAccess) {
            _matched=true;
            boolean _and = false;
            AccessType _kind = ((SubprogramGroupAccess)callContext).getKind();
            boolean _equals_1 = Objects.equal(_kind, AccessType.REQUIRES);
            if (!_equals_1) {
              _and = false;
            } else {
              SubprogramGroupSubcomponentType _subprogramGroupFeatureClassifier = ((SubprogramGroupAccess)callContext).getSubprogramGroupFeatureClassifier();
              _and = (_subprogramGroupFeatureClassifier instanceof Classifier);
            }
            if (_and) {
              SubprogramGroupSubcomponentType _subprogramGroupFeatureClassifier_1 = ((SubprogramGroupAccess)callContext).getSubprogramGroupFeatureClassifier();
              callContextNamespace = ((Classifier) _subprogramGroupFeatureClassifier_1);
            }
          }
        }
        if (!_matched) {
          if (callContext instanceof FeatureGroup) {
            _matched=true;
            FeatureGroupType _featureGroupType = ((FeatureGroup)callContext).getFeatureGroupType();
            callContextNamespace = _featureGroupType;
          }
        }
        IScope _elvis = null;
        EList<NamedElement> _members_1 = null;
        if (callContextNamespace!=null) {
          _members_1=callContextNamespace.getMembers();
        }
        Iterable<CalledSubprogram> _filter_1 = null;
        if (_members_1!=null) {
          _filter_1=Iterables.<CalledSubprogram>filter(_members_1, CalledSubprogram.class);
        }
        Iterable<CalledSubprogram> _filterRefined_1 = null;
        if (_filter_1!=null) {
          _filterRefined_1=PropertiesScopeProvider.<CalledSubprogram>filterRefined(_filter_1);
        }
        SimpleScope _scopeFor_1 = null;
        if (_filterRefined_1!=null) {
          _scopeFor_1=PropertiesScopeProvider.scopeFor(_filterRefined_1, scope);
        }
        if (_scopeFor_1 != null) {
          _elvis = _scopeFor_1;
        } else {
          _elvis = scope;
        }
        scope = _elvis;
      }
      _xblockexpression = scope;
    }
    return _xblockexpression;
  }
  
  public IScope scope_ComponentPrototype_constrainingClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  /**
   * Reference is from AbstractPrototype, BusPrototype, DataPrototype, DevicePrototype, MemoryPrototype,
   * ProcessPrototype, ProcessorPrototype, SubprogramPrototype, SubprogramGroupPrototype, SystemPrototype,
   * ThreadPrototype, ThreadGroupPrototype, VirtualBusPrototype, VirtualProcessorPrototype,
   * FeatureGroupPrototype and FeaturePrototype in Aadl2.xtext
   */
  public IScope scope_Prototype_refined(final Classifier context, final EReference reference) {
    IScope _elvis = null;
    Classifier _extended = context.getExtended();
    EList<Prototype> _allPrototypes = null;
    if (_extended!=null) {
      _allPrototypes=Aadl2ScopeProvider.allPrototypes(_extended);
    }
    Iterable<Prototype> _filterRefined = null;
    if (_allPrototypes!=null) {
      _filterRefined=PropertiesScopeProvider.<Prototype>filterRefined(_allPrototypes);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_FeaturePrototype_constrainingClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_PrototypeBinding_formal(final ComponentPrototypeActual context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      final SubcomponentType subcomponentType = context.getSubcomponentType();
      IScope _xifexpression = null;
      if ((subcomponentType instanceof ComponentClassifier)) {
        EList<Prototype> _allPrototypes = ((ComponentClassifier)subcomponentType).getAllPrototypes();
        Iterable<Prototype> _filterRefined = PropertiesScopeProvider.<Prototype>filterRefined(_allPrototypes);
        _xifexpression = PropertiesScopeProvider.scopeFor(_filterRefined);
      } else {
        _xifexpression = IScope.NULLSCOPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public IScope scope_PrototypeBinding_formal(final FeatureGroupPrototypeActual context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      final FeatureType featureType = context.getFeatureType();
      IScope _xifexpression = null;
      if ((featureType instanceof FeatureGroupType)) {
        EList<Prototype> _allPrototypes = ((FeatureGroupType)featureType).getAllPrototypes();
        Iterable<Prototype> _filterRefined = PropertiesScopeProvider.<Prototype>filterRefined(_allPrototypes);
        _xifexpression = PropertiesScopeProvider.scopeFor(_filterRefined);
      } else {
        _xifexpression = IScope.NULLSCOPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public IScope scope_PrototypeBinding_formal(final ComponentImplementationReference context, final EReference reference) {
    IScope _elvis = null;
    ComponentImplementation _implementation = context.getImplementation();
    EList<Prototype> _allPrototypes = null;
    if (_implementation!=null) {
      _allPrototypes=_implementation.getAllPrototypes();
    }
    Iterable<Prototype> _filterRefined = null;
    if (_allPrototypes!=null) {
      _filterRefined=PropertiesScopeProvider.<Prototype>filterRefined(_allPrototypes);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_PrototypeBinding_formal(final Subcomponent context, final EReference reference) {
    IScope _elvis = null;
    ComponentClassifier _allClassifier = context.getAllClassifier();
    EList<Prototype> _allPrototypes = null;
    if (_allClassifier!=null) {
      _allPrototypes=_allClassifier.getAllPrototypes();
    }
    Iterable<Prototype> _filterRefined = null;
    if (_allPrototypes!=null) {
      _filterRefined=PropertiesScopeProvider.<Prototype>filterRefined(_allPrototypes);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public SimpleScope scope_PrototypeBinding_formal(final Classifier context, final EReference reference) {
    EList<Classifier> _generals = context.getGenerals();
    final Function1<Classifier, EList<Prototype>> _function = new Function1<Classifier, EList<Prototype>>() {
      @Override
      public EList<Prototype> apply(final Classifier it) {
        return Aadl2ScopeProvider.allPrototypes(it);
      }
    };
    List<EList<Prototype>> _map = ListExtensions.<Classifier, EList<Prototype>>map(_generals, _function);
    Iterable<Prototype> _flatten = Iterables.<Prototype>concat(_map);
    Set<Prototype> _set = IterableExtensions.<Prototype>toSet(_flatten);
    Iterable<Prototype> _filterRefined = PropertiesScopeProvider.<Prototype>filterRefined(_set);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  public SimpleScope scope_FeatureGroupPrototypeActual_featureType(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<FeatureGroupPrototype> _filter = Iterables.<FeatureGroupPrototype>filter(_allPrototypes, FeatureGroupPrototype.class);
    Iterable<FeatureGroupPrototype> _filterRefined = PropertiesScopeProvider.<FeatureGroupPrototype>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public IScope scope_PortSpecification_classifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_AccessSpecification_classifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public SimpleScope scope_FeaturePrototypeReference_prototype(final Classifier context, final EReference reference) {
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(context);
    Iterable<FeaturePrototype> _filter = Iterables.<FeaturePrototype>filter(_allPrototypes, FeaturePrototype.class);
    Iterable<FeaturePrototype> _filterRefined = PropertiesScopeProvider.<FeaturePrototype>filterRefined(_filter);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  public SimpleScope scope_ComponentPrototypeActual_subcomponentType(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<SubcomponentType> _filter = Iterables.<SubcomponentType>filter(_allPrototypes, SubcomponentType.class);
    Iterable<SubcomponentType> _filterRefined = PropertiesScopeProvider.<SubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  /**
   * Reference is from AbstractSubcomponent, SystemSubcomponent, ProcessSubcomponent, ThreadGroupSubcomponent,
   * ThreadSubcomponent, SubprogramSubcomponent, SubprogramGroupSubcomponent, ProcessorSubcomponent,
   * VirtualProcessorSubcomponent, DeviceSubcomponent, MemorySubcomponent, BusSubcomponent,
   * VirtualBusSubcomponent, and DataSubcomponent in Aadl2.xtext
   */
  public IScope scope_Subcomponent_refined(final ComponentImplementation context, final EReference reference) {
    IScope _elvis = null;
    ComponentImplementation _extended = context.getExtended();
    EList<Subcomponent> _allSubcomponents = null;
    if (_extended!=null) {
      _allSubcomponents=_extended.getAllSubcomponents();
    }
    Iterable<Subcomponent> _filterRefined = null;
    if (_allSubcomponents!=null) {
      _filterRefined=PropertiesScopeProvider.<Subcomponent>filterRefined(_allSubcomponents);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public SimpleScope scope_AbstractSubcomponent_abstractSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<AbstractSubcomponentType> _filter = Iterables.<AbstractSubcomponentType>filter(_allPrototypes, AbstractSubcomponentType.class);
    Iterable<AbstractSubcomponentType> _filterRefined = PropertiesScopeProvider.<AbstractSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_SystemSubcomponent_systemSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<SystemSubcomponentType> _filter = Iterables.<SystemSubcomponentType>filter(_allPrototypes, SystemSubcomponentType.class);
    Iterable<SystemSubcomponentType> _filterRefined = PropertiesScopeProvider.<SystemSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_ProcessSubcomponent_processSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ProcessSubcomponentType> _filter = Iterables.<ProcessSubcomponentType>filter(_allPrototypes, ProcessSubcomponentType.class);
    Iterable<ProcessSubcomponentType> _filterRefined = PropertiesScopeProvider.<ProcessSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_ThreadGroupSubcomponent_threadGroupSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ThreadGroupSubcomponentType> _filter = Iterables.<ThreadGroupSubcomponentType>filter(_allPrototypes, ThreadGroupSubcomponentType.class);
    Iterable<ThreadGroupSubcomponentType> _filterRefined = PropertiesScopeProvider.<ThreadGroupSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_ThreadSubcomponent_threadSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ThreadSubcomponentType> _filter = Iterables.<ThreadSubcomponentType>filter(_allPrototypes, ThreadSubcomponentType.class);
    Iterable<ThreadSubcomponentType> _filterRefined = PropertiesScopeProvider.<ThreadSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_SubprogramSubcomponent_subprogramSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<SubprogramSubcomponentType> _filter = Iterables.<SubprogramSubcomponentType>filter(_allPrototypes, SubprogramSubcomponentType.class);
    Iterable<SubprogramSubcomponentType> _filterRefined = PropertiesScopeProvider.<SubprogramSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<SubprogramGroupSubcomponentType> _filter = Iterables.<SubprogramGroupSubcomponentType>filter(_allPrototypes, SubprogramGroupSubcomponentType.class);
    Iterable<SubprogramGroupSubcomponentType> _filterRefined = PropertiesScopeProvider.<SubprogramGroupSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_ProcessorSubcomponent_processorSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ProcessorSubcomponentType> _filter = Iterables.<ProcessorSubcomponentType>filter(_allPrototypes, ProcessorSubcomponentType.class);
    Iterable<ProcessorSubcomponentType> _filterRefined = PropertiesScopeProvider.<ProcessorSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<VirtualProcessorSubcomponentType> _filter = Iterables.<VirtualProcessorSubcomponentType>filter(_allPrototypes, VirtualProcessorSubcomponentType.class);
    Iterable<VirtualProcessorSubcomponentType> _filterRefined = PropertiesScopeProvider.<VirtualProcessorSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_DeviceSubcomponent_deviceSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<DeviceSubcomponentType> _filter = Iterables.<DeviceSubcomponentType>filter(_allPrototypes, DeviceSubcomponentType.class);
    Iterable<DeviceSubcomponentType> _filterRefined = PropertiesScopeProvider.<DeviceSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_MemorySubcomponent_memorySubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<MemorySubcomponentType> _filter = Iterables.<MemorySubcomponentType>filter(_allPrototypes, MemorySubcomponentType.class);
    Iterable<MemorySubcomponentType> _filterRefined = PropertiesScopeProvider.<MemorySubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_BusSubcomponent_busSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<BusSubcomponentType> _filter = Iterables.<BusSubcomponentType>filter(_allPrototypes, BusSubcomponentType.class);
    Iterable<BusSubcomponentType> _filterRefined = PropertiesScopeProvider.<BusSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_VirtualBusSubcomponent_virtualBusSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<VirtualBusSubcomponentType> _filter = Iterables.<VirtualBusSubcomponentType>filter(_allPrototypes, VirtualBusSubcomponentType.class);
    Iterable<VirtualBusSubcomponentType> _filterRefined = PropertiesScopeProvider.<VirtualBusSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_DataSubcomponent_dataSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    Iterable<DataSubcomponentType> _filterRefined = PropertiesScopeProvider.<DataSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public IScope scope_Feature_refined(final Classifier context, final EReference reference) {
    IScope _elvis = null;
    Classifier _extended = context.getExtended();
    EList<Feature> _allFeatures = null;
    if (_extended!=null) {
      _allFeatures=_extended.getAllFeatures();
    }
    Iterable<Feature> _filterRefined = null;
    if (_allFeatures!=null) {
      _filterRefined=PropertiesScopeProvider.<Feature>filterRefined(_allFeatures);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public SimpleScope scope_DataPort_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    Iterable<DataSubcomponentType> _filterRefined = PropertiesScopeProvider.<DataSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_EventDataPort_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    Iterable<DataSubcomponentType> _filterRefined = PropertiesScopeProvider.<DataSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_FeatureGroup_featureType(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<FeatureType> _filter = Iterables.<FeatureType>filter(_allPrototypes, FeatureType.class);
    Iterable<FeatureType> _filterRefined = PropertiesScopeProvider.<FeatureType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_Parameter_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    Iterable<DataSubcomponentType> _filterRefined = PropertiesScopeProvider.<DataSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_SubprogramAccess_subprogramFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<SubprogramSubcomponentType> _filter = Iterables.<SubprogramSubcomponentType>filter(_allPrototypes, SubprogramSubcomponentType.class);
    Iterable<SubprogramSubcomponentType> _filterRefined = PropertiesScopeProvider.<SubprogramSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<SubprogramGroupSubcomponentType> _filter = Iterables.<SubprogramGroupSubcomponentType>filter(_allPrototypes, SubprogramGroupSubcomponentType.class);
    Iterable<SubprogramGroupSubcomponentType> _filterRefined = PropertiesScopeProvider.<SubprogramGroupSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_BusAccess_busFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<BusSubcomponentType> _filter = Iterables.<BusSubcomponentType>filter(_allPrototypes, BusSubcomponentType.class);
    Iterable<BusSubcomponentType> _filterRefined = PropertiesScopeProvider.<BusSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_DataAccess_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    Iterable<DataSubcomponentType> _filterRefined = PropertiesScopeProvider.<DataSubcomponentType>filterRefined(_filter);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return PropertiesScopeProvider.scopeFor(_filterRefined, _scope_Classifier);
  }
  
  public SimpleScope scope_AbstractFeature_featurePrototype(final Classifier context, final EReference reference) {
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(context);
    Iterable<FeaturePrototype> _filter = Iterables.<FeaturePrototype>filter(_allPrototypes, FeaturePrototype.class);
    Iterable<FeaturePrototype> _filterRefined = PropertiesScopeProvider.<FeaturePrototype>filterRefined(_filter);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  public IScope scope_EventDataSource_dataClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_PortProxy_dataClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_SubprogramProxy_subprogramClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public SimpleScope scope_ConnectedElement_context(final ComponentImplementation context, final EReference reference) {
    ArrayList<Context> _allContexts = Aadl2ScopeProvider.allContexts(context);
    Iterable<Context> _filterRefined = PropertiesScopeProvider.<Context>filterRefined(_allContexts);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from ConnectedElement in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ConnectedElement.  When the
   * ConnectedElement is a single identifier, e.g. "port1", then the passed context is a Connection.  In this case, we know that the ConnectedElement's
   * Context is null even though we can't access it and check it here.  In all other cases, the passed context is a ConnectedElement, thus calling the other
   * scope method.
   */
  public SimpleScope scope_ConnectedElement_connectionEnd(final Connection context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    ArrayList<ConnectionEnd> _allConnectionEnds = Aadl2ScopeProvider.allConnectionEnds(_containerOfType);
    Iterable<ConnectionEnd> _filterRefined = PropertiesScopeProvider.<ConnectionEnd>filterRefined(_allConnectionEnds);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from ConnectedElement, ProcessorPort, ProcessorSubprogram, and InternalEvent in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ConnectedElement.  When the
   * ConnectedElement is a qualified reference, e.g. "subcomponent1.port1" or "processor.portproxy1", then the passed context is a ConnectedElement and we
   * can access and check the ConnectedElement's Context object.
   */
  public IScope scope_ConnectedElement_connectionEnd(final ConnectedElement context, final EReference reference) {
    IScope _elvis = null;
    Context _context = context.getContext();
    IScope _scopeForElementsOfContext = null;
    if (_context!=null) {
      Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
      final Function1<Classifier, Iterable<? extends EObject>> _function = new Function1<Classifier, Iterable<? extends EObject>>() {
        @Override
        public Iterable<? extends EObject> apply(final Classifier it) {
          ArrayList<ConnectionEnd> _allConnectionEnds = Aadl2ScopeProvider.allConnectionEnds(it);
          return PropertiesScopeProvider.<ConnectionEnd>filterRefined(_allConnectionEnds);
        }
      };
      _scopeForElementsOfContext=Aadl2ScopeProvider.scopeForElementsOfContext(_context, _containerOfType, _function);
    }
    if (_scopeForElementsOfContext != null) {
      _elvis = _scopeForElementsOfContext;
    } else {
      Element _owner = context.getOwner();
      SimpleScope _scope_ConnectedElement_connectionEnd = this.scope_ConnectedElement_connectionEnd(((Connection) _owner), reference);
      _elvis = _scope_ConnectedElement_connectionEnd;
    }
    return _elvis;
  }
  
  public IScope scope_Connection_refined(final ComponentImplementation context, final EReference reference) {
    IScope _elvis = null;
    ComponentImplementation _extended = context.getExtended();
    EList<Connection> _allConnections = null;
    if (_extended!=null) {
      _allConnections=_extended.getAllConnections();
    }
    Iterable<Connection> _filterRefined = null;
    if (_allConnections!=null) {
      _filterRefined=PropertiesScopeProvider.<Connection>filterRefined(_allConnections);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  /**
   * Reference is from PortConnection, AccessConnection, FeatureGroupConnection, FeatureConnection, ParameterConnection, FlowSpecification,
   * FlowImplementation, and EndToEndFlow in Aadl2.xtext
   */
  public SimpleScope scope_ModalPath_inModeOrTransition(final ComponentClassifier context, final EReference reference) {
    EList<Mode> _allModes = context.getAllModes();
    EList<ModeTransition> _allModeTransitions = context.getAllModeTransitions();
    Iterable<ModeFeature> _plus = Iterables.<ModeFeature>concat(_allModes, _allModeTransitions);
    return PropertiesScopeProvider.scopeFor(_plus);
  }
  
  public SimpleScope scope_FlowEnd_context(final ComponentType context, final EReference reference) {
    ArrayList<Context> _allContexts = Aadl2ScopeProvider.allContexts(context);
    Iterable<Context> _filterRefined = PropertiesScopeProvider.<Context>filterRefined(_allContexts);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from FlowEnd in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowEnd.  When the FlowEnd
   * is a single identifier, e.g. "port1", then the passed context is a FlowSpecification.  In this case, we know that the FlowEnd's Context is null even
   * though we can't access it and check it here.  When the FlowEnd is a qualified reference, e.g. "featuregroup1.port1", then the passed context is a
   * FlowEnd, thus calling the other scope method.
   */
  public SimpleScope scope_FlowEnd_feature(final FlowSpecification context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Feature> _allFeatures = _containerOfType.getAllFeatures();
    Iterable<Feature> _filterRefined = PropertiesScopeProvider.<Feature>filterRefined(_allFeatures);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from FlowEnd in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowEnd.  When the FlowEnd
   * is a qualified reference, e.g. "featuregroup1.port1", then the passed context is a FlowEnd and we can access and check the FlowEnd's Context object.
   */
  public IScope scope_FlowEnd_feature(final FlowEnd context, final EReference reference) {
    IScope _elvis = null;
    Context _context = context.getContext();
    IScope _scopeForElementsOfContext = null;
    if (_context!=null) {
      Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
      final Function1<Classifier, Iterable<? extends EObject>> _function = new Function1<Classifier, Iterable<? extends EObject>>() {
        @Override
        public Iterable<? extends EObject> apply(final Classifier it) {
          EList<Feature> _allFeatures = it.getAllFeatures();
          return PropertiesScopeProvider.<Feature>filterRefined(_allFeatures);
        }
      };
      _scopeForElementsOfContext=Aadl2ScopeProvider.scopeForElementsOfContext(_context, _containerOfType, _function);
    }
    if (_scopeForElementsOfContext != null) {
      _elvis = _scopeForElementsOfContext;
    } else {
      Element _owner = context.getOwner();
      SimpleScope _scope_FlowEnd_feature = this.scope_FlowEnd_feature(((FlowSpecification) _owner), reference);
      _elvis = _scope_FlowEnd_feature;
    }
    return _elvis;
  }
  
  public IScope scope_FlowSpecification_refined(final ComponentType context, final EReference reference) {
    IScope _elvis = null;
    ComponentType _extended = context.getExtended();
    EList<FlowSpecification> _allFlowSpecifications = null;
    if (_extended!=null) {
      _allFlowSpecifications=_extended.getAllFlowSpecifications();
    }
    Iterable<FlowSpecification> _filterRefined = null;
    if (_allFlowSpecifications!=null) {
      _filterRefined=PropertiesScopeProvider.<FlowSpecification>filterRefined(_allFlowSpecifications);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_FlowImplementation_specification(final ComponentImplementation context, final EReference reference) {
    IScope _elvis = null;
    ComponentType _type = context.getType();
    EList<FlowSpecification> _allFlowSpecifications = null;
    if (_type!=null) {
      _allFlowSpecifications=_type.getAllFlowSpecifications();
    }
    Iterable<FlowSpecification> _filterRefined = null;
    if (_allFlowSpecifications!=null) {
      _filterRefined=PropertiesScopeProvider.<FlowSpecification>filterRefined(_allFlowSpecifications);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_EndToEndFlow_refined(final ComponentImplementation context, final EReference reference) {
    IScope _elvis = null;
    ComponentImplementation _extended = context.getExtended();
    EList<EndToEndFlow> _allEndToEndFlows = null;
    if (_extended!=null) {
      _allEndToEndFlows=_extended.getAllEndToEndFlows();
    }
    Iterable<EndToEndFlow> _filterRefined = null;
    if (_allEndToEndFlows!=null) {
      _filterRefined=PropertiesScopeProvider.<EndToEndFlow>filterRefined(_allEndToEndFlows);
    }
    SimpleScope _scopeFor = null;
    if (_filterRefined!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_filterRefined);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public SimpleScope scope_FlowSegment_context(final ComponentImplementation context, final EReference reference) {
    ArrayList<Context> _allContexts = Aadl2ScopeProvider.allContexts(context);
    Iterable<Context> _filterRefined = PropertiesScopeProvider.<Context>filterRefined(_allContexts);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from SubcomponentFlow and ConnectionFlow in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowSegment.  When the
   * FlowSegment is a single identifier, e.g. "conn1", then the passed context is a FlowImplementation.  In this case, we know that the FlowSegment's Context
   * is null even though we can't access it and check it here.  When the FlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the
   * passed context is a FlowSegment, thus calling the other scope method.
   */
  public SimpleScope scope_FlowSegment_flowElement(final FlowImplementation context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    ArrayList<FlowElement> _allFlowElements = Aadl2ScopeProvider.allFlowElements(_containerOfType);
    Iterable<FlowElement> _filterRefined = PropertiesScopeProvider.<FlowElement>filterRefined(_allFlowElements);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from SubcomponentFlow in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowSegment.  When the
   * FlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the passed context is a FlowSegment and we can access and check the
   * FlowSegment's Context object.
   */
  public IScope scope_FlowSegment_flowElement(final FlowSegment context, final EReference reference) {
    IScope _elvis = null;
    Context _context = context.getContext();
    IScope _scopeForElementsOfContext = null;
    if (_context!=null) {
      Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
      final Function1<Classifier, Iterable<? extends EObject>> _function = new Function1<Classifier, Iterable<? extends EObject>>() {
        @Override
        public Iterable<? extends EObject> apply(final Classifier it) {
          ArrayList<FlowElement> _allFlowElements = Aadl2ScopeProvider.allFlowElements(it);
          return PropertiesScopeProvider.<FlowElement>filterRefined(_allFlowElements);
        }
      };
      _scopeForElementsOfContext=Aadl2ScopeProvider.scopeForElementsOfContext(_context, _containerOfType, _function);
    }
    if (_scopeForElementsOfContext != null) {
      _elvis = _scopeForElementsOfContext;
    } else {
      Element _owner = context.getOwner();
      SimpleScope _scope_FlowSegment_flowElement = this.scope_FlowSegment_flowElement(((FlowImplementation) _owner), reference);
      _elvis = _scope_FlowSegment_flowElement;
    }
    return _elvis;
  }
  
  public SimpleScope scope_EndToEndFlowSegment_context(final ComponentImplementation context, final EReference reference) {
    ArrayList<Context> _allContexts = Aadl2ScopeProvider.allContexts(context);
    Iterable<Context> _filterRefined = PropertiesScopeProvider.<Context>filterRefined(_allContexts);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from ETESubcomponentFlow and ETEConnectionFlow in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the EndToEndFlowSegment.  When
   * the EndToEndFlowSegment is a single identifier, e.g. "conn1", then the passed context is an EndToEndFlow.  In this case, we know that the
   * EndToEndFlowSegment's Context is null even though we can't access it and check it here.  When the EndToEndFlowSegment is a qualified reference, e.g.
   * "subcomponent1.flowpath1", then the passed context is an EndToEndFlowSegment, thus calling the other scope method.
   */
  public SimpleScope scope_EndToEndFlowSegment_flowElement(final EndToEndFlow context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    ArrayList<EndToEndFlowElement> _allEndToEndFlowElements = Aadl2ScopeProvider.allEndToEndFlowElements(_containerOfType);
    Iterable<EndToEndFlowElement> _filterRefined = PropertiesScopeProvider.<EndToEndFlowElement>filterRefined(_allEndToEndFlowElements);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from ETESubcomponentFlow in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the EndToEndFlowSegment.  When
   * the EndToEndFlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the passed context is an EndToEndFlowSegment and we can access
   * and check the EndToEndFlowSegment's Context object.
   */
  public IScope scope_EndToEndFlowSegment_flowElement(final EndToEndFlowSegment context, final EReference reference) {
    IScope _elvis = null;
    Context _context = context.getContext();
    IScope _scopeForElementsOfContext = null;
    if (_context!=null) {
      Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
      final Function1<Classifier, Iterable<? extends EObject>> _function = new Function1<Classifier, Iterable<? extends EObject>>() {
        @Override
        public Iterable<? extends EObject> apply(final Classifier it) {
          ArrayList<EndToEndFlowElement> _allEndToEndFlowElements = Aadl2ScopeProvider.allEndToEndFlowElements(it);
          return PropertiesScopeProvider.<EndToEndFlowElement>filterRefined(_allEndToEndFlowElements);
        }
      };
      _scopeForElementsOfContext=Aadl2ScopeProvider.scopeForElementsOfContext(_context, _containerOfType, _function);
    }
    if (_scopeForElementsOfContext != null) {
      _elvis = _scopeForElementsOfContext;
    } else {
      Element _owner = context.getOwner();
      SimpleScope _scope_EndToEndFlowSegment_flowElement = this.scope_EndToEndFlowSegment_flowElement(((EndToEndFlow) _owner), reference);
      _elvis = _scope_EndToEndFlowSegment_flowElement;
    }
    return _elvis;
  }
  
  public SimpleScope scope_ModeTransition_source(final ComponentClassifier context, final EReference reference) {
    EList<Mode> _allModes = context.getAllModes();
    return PropertiesScopeProvider.scopeFor(_allModes);
  }
  
  public SimpleScope scope_ModeTransition_destination(final ComponentClassifier context, final EReference reference) {
    EList<Mode> _allModes = context.getAllModes();
    return PropertiesScopeProvider.scopeFor(_allModes);
  }
  
  public SimpleScope scope_ModeTransitionTrigger_context(final ComponentClassifier context, final EReference reference) {
    ArrayList<Context> _allContexts = Aadl2ScopeProvider.allContexts(context);
    Iterable<Context> _filterRefined = PropertiesScopeProvider.<Context>filterRefined(_allContexts);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from Trigger in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ModeTransitionTrigger.  When
   * the ModeTransitionTrigger is a single identifier, e.g. "eventport1", then the passed context is a ModeTransition.  In this case, we know that the
   * ModeTransitionTrigger's Context is null even though we can't access it and check it here.  When the ModeTransitionTrigger is a qualified reference, e.g.
   * "featuregroup1.eventport1", then the passed context is a ModeTransitionTrigger, thus calling the other scope method.
   */
  public SimpleScope scope_ModeTransitionTrigger_triggerPort(final ModeTransition context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    ArrayList<TriggerPort> _allTriggerPorts = Aadl2ScopeProvider.allTriggerPorts(_containerOfType);
    Iterable<TriggerPort> _filterRefined = PropertiesScopeProvider.<TriggerPort>filterRefined(_allTriggerPorts);
    return PropertiesScopeProvider.scopeFor(_filterRefined);
  }
  
  /**
   * Reference is from Trigger in Aadl2.xtext
   * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ModeTransitionTrigger.  When
   * the ModeTransitionTrigger is a qualified reference, e.g. "featuregroup1.eventport1", then the passed context is a ModeTransitionTrigger and we can
   * access and check the ModeTransitionTrigger's Context object.
   */
  public IScope scope_ModeTransitionTrigger_triggerPort(final ModeTransitionTrigger context, final EReference reference) {
    IScope _elvis = null;
    Context _context = context.getContext();
    IScope _scopeForElementsOfContext = null;
    if (_context!=null) {
      Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
      final Function1<Classifier, Iterable<? extends EObject>> _function = new Function1<Classifier, Iterable<? extends EObject>>() {
        @Override
        public Iterable<? extends EObject> apply(final Classifier it) {
          ArrayList<TriggerPort> _allTriggerPorts = Aadl2ScopeProvider.allTriggerPorts(it);
          return PropertiesScopeProvider.<TriggerPort>filterRefined(_allTriggerPorts);
        }
      };
      _scopeForElementsOfContext=Aadl2ScopeProvider.scopeForElementsOfContext(_context, _containerOfType, _function);
    }
    if (_scopeForElementsOfContext != null) {
      _elvis = _scopeForElementsOfContext;
    } else {
      Element _owner = context.getOwner();
      SimpleScope _scope_ModeTransitionTrigger_triggerPort = this.scope_ModeTransitionTrigger_triggerPort(((ModeTransition) _owner), reference);
      _elvis = _scope_ModeTransitionTrigger_triggerPort;
    }
    return _elvis;
  }
  
  public SimpleScope scope_ModeBinding_parentMode(final ComponentImplementation context, final EReference reference) {
    EList<Mode> _allModes = context.getAllModes();
    return PropertiesScopeProvider.scopeFor(_allModes);
  }
  
  public IScope scope_ModeBinding_derivedMode(final Subcomponent context, final EReference reference) {
    IScope _elvis = null;
    ComponentClassifier _switchResult = null;
    SubcomponentType _allSubcomponentType = PropertiesScopeProvider.allSubcomponentType(context);
    final SubcomponentType subcomponentType = _allSubcomponentType;
    boolean _matched = false;
    if (!_matched) {
      if (subcomponentType instanceof ComponentClassifier) {
        _matched=true;
        _switchResult = ((ComponentClassifier)subcomponentType);
      }
    }
    if (!_matched) {
      if (subcomponentType instanceof ComponentPrototype) {
        _matched=true;
        Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
        _switchResult = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)subcomponentType), _containerOfType);
      }
    }
    EList<Mode> _allModes = null;
    if (_switchResult!=null) {
      _allModes=_switchResult.getAllModes();
    }
    SimpleScope _scopeFor = null;
    if (_allModes!=null) {
      _scopeFor=PropertiesScopeProvider.scopeFor(_allModes);
    }
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public SimpleScope scope_UnitLiteral_baseUnit(final UnitsType context, final EReference reference) {
    EList<EnumerationLiteral> _ownedLiterals = context.getOwnedLiterals();
    return PropertiesScopeProvider.scopeFor(_ownedLiterals);
  }
  
  public SimpleScope scope_NumberType_referencedUnitsType(final Element context, final EReference reference) {
    IScope _delegateGetScope = this.delegateGetScope(context, reference);
    Iterable<IEObjectDescription> _allElements = _delegateGetScope.getAllElements();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        boolean _or = false;
        QualifiedName _name = it.getName();
        QualifiedName _qualifiedName = it.getQualifiedName();
        boolean _equals = Objects.equal(_name, _qualifiedName);
        if (_equals) {
          _or = true;
        } else {
          QualifiedName _qualifiedName_1 = it.getQualifiedName();
          String _firstSegment = _qualifiedName_1.getFirstSegment();
          boolean _isPredeclaredPropertySet = AadlUtil.isPredeclaredPropertySet(_firstSegment);
          _or = _isPredeclaredPropertySet;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    return new SimpleScope(_filter, true);
  }
  
  public SimpleScope scope_RangeType_numberType(final Element context, final EReference reference) {
    IScope _delegateGetScope = this.delegateGetScope(context, reference);
    Iterable<IEObjectDescription> _allElements = _delegateGetScope.getAllElements();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        boolean _or = false;
        QualifiedName _name = it.getName();
        QualifiedName _qualifiedName = it.getQualifiedName();
        boolean _equals = Objects.equal(_name, _qualifiedName);
        if (_equals) {
          _or = true;
        } else {
          QualifiedName _qualifiedName_1 = it.getQualifiedName();
          String _firstSegment = _qualifiedName_1.getFirstSegment();
          boolean _isPredeclaredPropertySet = AadlUtil.isPredeclaredPropertySet(_firstSegment);
          _or = _isPredeclaredPropertySet;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    return new SimpleScope(_filter, true);
  }
  
  public SimpleScope scope_BasicProperty_referencedPropertyType(final Element context, final EReference reference) {
    IScope _delegateGetScope = this.delegateGetScope(context, reference);
    Iterable<IEObjectDescription> _allElements = _delegateGetScope.getAllElements();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        boolean _or = false;
        QualifiedName _name = it.getName();
        QualifiedName _qualifiedName = it.getQualifiedName();
        boolean _equals = Objects.equal(_name, _qualifiedName);
        if (_equals) {
          _or = true;
        } else {
          QualifiedName _qualifiedName_1 = it.getQualifiedName();
          String _firstSegment = _qualifiedName_1.getFirstSegment();
          boolean _isPredeclaredPropertySet = AadlUtil.isPredeclaredPropertySet(_firstSegment);
          _or = _isPredeclaredPropertySet;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    return new SimpleScope(_filter, true);
  }
  
  public SimpleScope scope_ListType_referencedElementType(final Element context, final EReference reference) {
    IScope _delegateGetScope = this.delegateGetScope(context, reference);
    Iterable<IEObjectDescription> _allElements = _delegateGetScope.getAllElements();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        boolean _or = false;
        QualifiedName _name = it.getName();
        QualifiedName _qualifiedName = it.getQualifiedName();
        boolean _equals = Objects.equal(_name, _qualifiedName);
        if (_equals) {
          _or = true;
        } else {
          QualifiedName _qualifiedName_1 = it.getQualifiedName();
          String _firstSegment = _qualifiedName_1.getFirstSegment();
          boolean _isPredeclaredPropertySet = AadlUtil.isPredeclaredPropertySet(_firstSegment);
          _or = _isPredeclaredPropertySet;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    return new SimpleScope(_filter, true);
  }
  
  public SimpleScope scope_PropertyConstant_referencedPropertyType(final Element context, final EReference reference) {
    IScope _delegateGetScope = this.delegateGetScope(context, reference);
    Iterable<IEObjectDescription> _allElements = _delegateGetScope.getAllElements();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        boolean _or = false;
        QualifiedName _name = it.getName();
        QualifiedName _qualifiedName = it.getQualifiedName();
        boolean _equals = Objects.equal(_name, _qualifiedName);
        if (_equals) {
          _or = true;
        } else {
          QualifiedName _qualifiedName_1 = it.getQualifiedName();
          String _firstSegment = _qualifiedName_1.getFirstSegment();
          boolean _isPredeclaredPropertySet = AadlUtil.isPredeclaredPropertySet(_firstSegment);
          _or = _isPredeclaredPropertySet;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    return new SimpleScope(_filter, true);
  }
  
  private static EList<Prototype> allPrototypes(final Classifier classifier) {
    EList<Prototype> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (classifier instanceof ComponentClassifier) {
        _matched=true;
        _switchResult = ((ComponentClassifier)classifier).getAllPrototypes();
      }
    }
    if (!_matched) {
      if (classifier instanceof FeatureGroupType) {
        _matched=true;
        _switchResult = ((FeatureGroupType)classifier).getAllPrototypes();
      }
    }
    return _switchResult;
  }
  
  private static ArrayList<Context> allContexts(final ComponentClassifier classifier) {
    ArrayList<Context> _xblockexpression = null;
    {
      final ArrayList<Context> validElements = CollectionLiterals.<Context>newArrayList();
      EList<Feature> _allFeatures = classifier.getAllFeatures();
      Iterable<Context> _filter = Iterables.<Context>filter(_allFeatures, Context.class);
      Iterables.<Context>addAll(validElements, _filter);
      if ((classifier instanceof ComponentImplementation)) {
        EList<Subcomponent> _allSubcomponents = ((ComponentImplementation)classifier).getAllSubcomponents();
        validElements.addAll(_allSubcomponents);
        if ((classifier instanceof BehavioredImplementation)) {
          ArrayList<SubprogramCall> _allSubprogramCalls = PropertiesScopeProvider.allSubprogramCalls(((BehavioredImplementation)classifier));
          validElements.addAll(_allSubprogramCalls);
        }
      }
      _xblockexpression = validElements;
    }
    return _xblockexpression;
  }
  
  private static ArrayList<ConnectionEnd> allConnectionEnds(final Classifier classifier) {
    ArrayList<ConnectionEnd> _xblockexpression = null;
    {
      final ArrayList<ConnectionEnd> connectionEnds = CollectionLiterals.<ConnectionEnd>newArrayList();
      EList<Feature> _allFeatures = classifier.getAllFeatures();
      connectionEnds.addAll(_allFeatures);
      if ((classifier instanceof ComponentImplementation)) {
        EList<Subcomponent> _allSubcomponents = ((ComponentImplementation)classifier).getAllSubcomponents();
        Iterable<ConnectionEnd> _filter = Iterables.<ConnectionEnd>filter(_allSubcomponents, ConnectionEnd.class);
        Iterables.<ConnectionEnd>addAll(connectionEnds, _filter);
        ArrayList<SubprogramProxy> _allSubprogramProxies = Aadl2ScopeProvider.allSubprogramProxies(((ComponentImplementation)classifier));
        connectionEnds.addAll(_allSubprogramProxies);
        ArrayList<PortProxy> _allPortProxies = Aadl2ScopeProvider.allPortProxies(((ComponentImplementation)classifier));
        connectionEnds.addAll(_allPortProxies);
        ArrayList<InternalFeature> _allInternalFeatures = PropertiesScopeProvider.allInternalFeatures(((ComponentImplementation)classifier));
        connectionEnds.addAll(_allInternalFeatures);
      }
      _xblockexpression = connectionEnds;
    }
    return _xblockexpression;
  }
  
  private static ArrayList<FlowElement> allFlowElements(final Classifier classifier) {
    ArrayList<FlowElement> _xblockexpression = null;
    {
      final ArrayList<FlowElement> flowElements = CollectionLiterals.<FlowElement>newArrayList();
      EList<Feature> _allFeatures = classifier.getAllFeatures();
      Iterable<DataAccess> _filter = Iterables.<DataAccess>filter(_allFeatures, DataAccess.class);
      Iterables.<FlowElement>addAll(flowElements, _filter);
      boolean _matched = false;
      if (!_matched) {
        if (classifier instanceof ComponentType) {
          _matched=true;
          EList<FlowSpecification> _allFlowSpecifications = ((ComponentType)classifier).getAllFlowSpecifications();
          flowElements.addAll(_allFlowSpecifications);
        }
      }
      if (!_matched) {
        if (classifier instanceof ComponentImplementation) {
          _matched=true;
          ComponentType _type = ((ComponentImplementation)classifier).getType();
          EList<FlowSpecification> _allFlowSpecifications = _type.getAllFlowSpecifications();
          flowElements.addAll(_allFlowSpecifications);
          EList<Connection> _allConnections = ((ComponentImplementation)classifier).getAllConnections();
          flowElements.addAll(_allConnections);
          EList<Subcomponent> _allSubcomponents = ((ComponentImplementation)classifier).getAllSubcomponents();
          flowElements.addAll(_allSubcomponents);
        }
      }
      _xblockexpression = flowElements;
    }
    return _xblockexpression;
  }
  
  private static ArrayList<EndToEndFlowElement> allEndToEndFlowElements(final Classifier classifier) {
    ArrayList<EndToEndFlowElement> _xblockexpression = null;
    {
      final ArrayList<EndToEndFlowElement> flowElements = CollectionLiterals.<EndToEndFlowElement>newArrayList();
      ArrayList<FlowElement> _allFlowElements = Aadl2ScopeProvider.allFlowElements(classifier);
      flowElements.addAll(_allFlowElements);
      if ((classifier instanceof ComponentImplementation)) {
        EList<EndToEndFlow> _allEndToEndFlows = ((ComponentImplementation)classifier).getAllEndToEndFlows();
        flowElements.addAll(_allEndToEndFlows);
      }
      _xblockexpression = flowElements;
    }
    return _xblockexpression;
  }
  
  private static ArrayList<TriggerPort> allTriggerPorts(final Classifier classifier) {
    ArrayList<TriggerPort> _xblockexpression = null;
    {
      final ArrayList<TriggerPort> triggerPorts = CollectionLiterals.<TriggerPort>newArrayList();
      EList<Feature> _allFeatures = classifier.getAllFeatures();
      Iterable<TriggerPort> _filter = Iterables.<TriggerPort>filter(_allFeatures, TriggerPort.class);
      Iterables.<TriggerPort>addAll(triggerPorts, _filter);
      if ((classifier instanceof ComponentImplementation)) {
        ArrayList<InternalFeature> _allInternalFeatures = PropertiesScopeProvider.allInternalFeatures(((ComponentImplementation)classifier));
        triggerPorts.addAll(_allInternalFeatures);
        ArrayList<PortProxy> _allPortProxies = Aadl2ScopeProvider.allPortProxies(((ComponentImplementation)classifier));
        triggerPorts.addAll(_allPortProxies);
      }
      _xblockexpression = triggerPorts;
    }
    return _xblockexpression;
  }
  
  private static ArrayList<SubprogramProxy> allSubprogramProxies(final ComponentImplementation implementation) {
    ArrayList<SubprogramProxy> _xblockexpression = null;
    {
      final ArrayList<SubprogramProxy> allSubprogramProxies = CollectionLiterals.<SubprogramProxy>newArrayList();
      for (ComponentImplementation currentImplementation = implementation; (!Objects.equal(currentImplementation, null)); currentImplementation = currentImplementation.getExtended()) {
        EList<SubprogramProxy> _ownedSubprogramProxies = currentImplementation.getOwnedSubprogramProxies();
        allSubprogramProxies.addAll(_ownedSubprogramProxies);
      }
      _xblockexpression = allSubprogramProxies;
    }
    return _xblockexpression;
  }
  
  private static ArrayList<PortProxy> allPortProxies(final ComponentImplementation implementation) {
    ArrayList<PortProxy> _xblockexpression = null;
    {
      final ArrayList<PortProxy> allPortProxies = CollectionLiterals.<PortProxy>newArrayList();
      for (ComponentImplementation currentImplementation = implementation; (!Objects.equal(currentImplementation, null)); currentImplementation = currentImplementation.getExtended()) {
        EList<PortProxy> _ownedPortProxies = currentImplementation.getOwnedPortProxies();
        allPortProxies.addAll(_ownedPortProxies);
      }
      _xblockexpression = allPortProxies;
    }
    return _xblockexpression;
  }
  
  private static FeatureClassifier allFeatureClassifier(final Feature feature) {
    FeatureClassifier _xblockexpression = null;
    {
      Feature refinedFeature = feature;
      while ((Objects.equal(refinedFeature.getFeatureClassifier(), null) && (!Objects.equal(refinedFeature.getRefined(), null)))) {
        Feature _refined = refinedFeature.getRefined();
        refinedFeature = _refined;
      }
      _xblockexpression = refinedFeature.getFeatureClassifier();
    }
    return _xblockexpression;
  }
  
  private static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(final FeatureGroupPrototype prototype, final Classifier containingClassifier) {
    return PropertiesLinkingService.findFeatureGroupTypeForFeatureGroupPrototype(containingClassifier, prototype);
  }
  
  private static ComponentClassifier findClassifierForComponentPrototype(final ComponentPrototype prototype, final Classifier containingClassifier) {
    return PropertiesLinkingService.findClassifierForComponentPrototype(containingClassifier, prototype);
  }
  
  private static ComponentClassifier findClassifierForComponentPrototype(final ComponentPrototype prototype, final Classifier classifierPrototypeContext, final Subcomponent subcomponentPrototypeContext) {
    return PropertiesLinkingService.findClassifierForComponentPrototype(classifierPrototypeContext, subcomponentPrototypeContext, prototype);
  }
  
  private static IScope scopeForElementsOfContext(final Context context, final Classifier containingClassifier, @Extension final Function1<? super Classifier, ? extends Iterable<? extends EObject>> validMemberCollector) {
    IScope _xblockexpression = null;
    {
      Classifier _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (context instanceof FeatureGroup) {
          _matched=true;
          FeatureGroupType _switchResult_1 = null;
          FeatureType _allFeatureType = PropertiesScopeProvider.allFeatureType(((FeatureGroup)context));
          final FeatureType featureType = _allFeatureType;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (featureType instanceof FeatureGroupType) {
              _matched_1=true;
              _switchResult_1 = ((FeatureGroupType)featureType);
            }
          }
          if (!_matched_1) {
            if (featureType instanceof FeatureGroupPrototype) {
              _matched_1=true;
              _switchResult_1 = Aadl2ScopeProvider.findFeatureGroupTypeForFeatureGroupPrototype(((FeatureGroupPrototype)featureType), containingClassifier);
            }
          }
          _switchResult = _switchResult_1;
        }
      }
      if (!_matched) {
        if (context instanceof Feature) {
          _matched=true;
          ComponentClassifier _switchResult_1 = null;
          FeatureClassifier _allFeatureClassifier = Aadl2ScopeProvider.allFeatureClassifier(((Feature)context));
          final FeatureClassifier featureClassifier = _allFeatureClassifier;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (featureClassifier instanceof ComponentClassifier) {
              _matched_1=true;
              _switchResult_1 = ((ComponentClassifier)featureClassifier);
            }
          }
          if (!_matched_1) {
            if (featureClassifier instanceof ComponentPrototype) {
              _matched_1=true;
              _switchResult_1 = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)featureClassifier), containingClassifier);
            }
          }
          _switchResult = _switchResult_1;
        }
      }
      if (!_matched) {
        if (context instanceof Subcomponent) {
          _matched=true;
          ComponentClassifier _switchResult_1 = null;
          SubcomponentType _allSubcomponentType = PropertiesScopeProvider.allSubcomponentType(((Subcomponent)context));
          final SubcomponentType subcomponentType = _allSubcomponentType;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (subcomponentType instanceof ComponentClassifier) {
              _matched_1=true;
              _switchResult_1 = ((ComponentClassifier)subcomponentType);
            }
          }
          if (!_matched_1) {
            if (subcomponentType instanceof ComponentPrototype) {
              _matched_1=true;
              _switchResult_1 = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)subcomponentType), containingClassifier);
            }
          }
          _switchResult = _switchResult_1;
        }
      }
      if (!_matched) {
        if (context instanceof SubprogramCall) {
          _matched=true;
          ComponentClassifier _switchResult_1 = null;
          CalledSubprogram _calledSubprogram = ((SubprogramCall)context).getCalledSubprogram();
          final CalledSubprogram calledSubprogram = _calledSubprogram;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (calledSubprogram instanceof ComponentClassifier) {
              _matched_1=true;
              _switchResult_1 = ((ComponentClassifier)calledSubprogram);
            }
          }
          if (!_matched_1) {
            if (calledSubprogram instanceof SubprogramSubcomponent) {
              _matched_1=true;
              ComponentClassifier _switchResult_2 = null;
              SubcomponentType _allSubcomponentType = PropertiesScopeProvider.allSubcomponentType(((Subcomponent)calledSubprogram));
              final SubcomponentType subcomponentType = _allSubcomponentType;
              boolean _matched_2 = false;
              if (!_matched_2) {
                if (subcomponentType instanceof ComponentClassifier) {
                  _matched_2=true;
                  _switchResult_2 = ((ComponentClassifier)subcomponentType);
                }
              }
              if (!_matched_2) {
                if (subcomponentType instanceof ComponentPrototype) {
                  _matched_2=true;
                  _switchResult_2 = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)subcomponentType), containingClassifier);
                }
              }
              _switchResult_1 = _switchResult_2;
            }
          }
          if (!_matched_1) {
            if (calledSubprogram instanceof SubprogramAccess) {
              _matched_1=true;
              ComponentClassifier _switchResult_2 = null;
              FeatureClassifier _allFeatureClassifier = Aadl2ScopeProvider.allFeatureClassifier(((Feature)calledSubprogram));
              final FeatureClassifier accessFeatureClassifier = _allFeatureClassifier;
              boolean _matched_2 = false;
              if (!_matched_2) {
                if (accessFeatureClassifier instanceof ComponentClassifier) {
                  _matched_2=true;
                  _switchResult_2 = ((ComponentClassifier)accessFeatureClassifier);
                }
              }
              if (!_matched_2) {
                if (accessFeatureClassifier instanceof ComponentPrototype) {
                  _matched_2=true;
                  ComponentClassifier _switchResult_3 = null;
                  CallContext _context = ((SubprogramCall)context).getContext();
                  final CallContext callContext = _context;
                  boolean _matched_3 = false;
                  if (!_matched_3) {
                    if (callContext instanceof ComponentType) {
                      _matched_3=true;
                      _switchResult_3 = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)accessFeatureClassifier), ((ComponentType)callContext));
                    }
                  }
                  if (!_matched_3) {
                    if (callContext instanceof FeatureGroup) {
                      _matched_3=true;
                      ComponentClassifier _xblockexpression_1 = null;
                      {
                        FeatureGroupType _switchResult_4 = null;
                        FeatureType _allFeatureType = PropertiesScopeProvider.allFeatureType(((FeatureGroup)callContext));
                        final FeatureType callContextFeatureType = _allFeatureType;
                        boolean _matched_4 = false;
                        if (!_matched_4) {
                          if (callContextFeatureType instanceof FeatureGroupType) {
                            _matched_4=true;
                            _switchResult_4 = ((FeatureGroupType)callContextFeatureType);
                          }
                        }
                        if (!_matched_4) {
                          if (callContextFeatureType instanceof FeatureGroupPrototype) {
                            _matched_4=true;
                            _switchResult_4 = Aadl2ScopeProvider.findFeatureGroupTypeForFeatureGroupPrototype(((FeatureGroupPrototype)callContextFeatureType), containingClassifier);
                          }
                        }
                        final FeatureGroupType prototypeContext = _switchResult_4;
                        ComponentClassifier _xifexpression = null;
                        boolean _notEquals = (!Objects.equal(prototypeContext, null));
                        if (_notEquals) {
                          _xifexpression = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)accessFeatureClassifier), prototypeContext);
                        }
                        _xblockexpression_1 = _xifexpression;
                      }
                      _switchResult_3 = _xblockexpression_1;
                    }
                  }
                  if (!_matched_3) {
                    if (callContext instanceof SubprogramGroupAccess) {
                      _matched_3=true;
                      ComponentClassifier _xblockexpression_1 = null;
                      {
                        ComponentClassifier _switchResult_4 = null;
                        FeatureClassifier _allFeatureClassifier_1 = Aadl2ScopeProvider.allFeatureClassifier(((Feature)callContext));
                        final FeatureClassifier callContextFeatureClassifier = _allFeatureClassifier_1;
                        boolean _matched_4 = false;
                        if (!_matched_4) {
                          if (callContextFeatureClassifier instanceof ComponentClassifier) {
                            _matched_4=true;
                            _switchResult_4 = ((ComponentClassifier)callContextFeatureClassifier);
                          }
                        }
                        if (!_matched_4) {
                          if (callContextFeatureClassifier instanceof ComponentPrototype) {
                            _matched_4=true;
                            _switchResult_4 = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)callContextFeatureClassifier), containingClassifier);
                          }
                        }
                        final ComponentClassifier prototypeContext = _switchResult_4;
                        ComponentClassifier _xifexpression = null;
                        boolean _notEquals = (!Objects.equal(prototypeContext, null));
                        if (_notEquals) {
                          _xifexpression = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)accessFeatureClassifier), prototypeContext);
                        }
                        _xblockexpression_1 = _xifexpression;
                      }
                      _switchResult_3 = _xblockexpression_1;
                    }
                  }
                  if (!_matched_3) {
                    if (callContext instanceof SubprogramGroupSubcomponent) {
                      _matched_3=true;
                      ComponentClassifier _xblockexpression_1 = null;
                      {
                        Subcomponent callContextSubcomponent = ((Subcomponent)callContext);
                        while ((Objects.equal(callContextSubcomponent.getSubcomponentType(), null) && (!Objects.equal(callContextSubcomponent.getRefined(), null)))) {
                          Subcomponent _refined = callContextSubcomponent.getRefined();
                          callContextSubcomponent = _refined;
                        }
                        ComponentClassifier _switchResult_4 = null;
                        SubcomponentType _subcomponentType = callContextSubcomponent.getSubcomponentType();
                        final SubcomponentType callContextSubcomponentType = _subcomponentType;
                        boolean _matched_4 = false;
                        if (!_matched_4) {
                          if (callContextSubcomponentType instanceof ComponentClassifier) {
                            _matched_4=true;
                            ComponentClassifier _xifexpression = null;
                            EList<PrototypeBinding> _ownedPrototypeBindings = callContextSubcomponent.getOwnedPrototypeBindings();
                            boolean _isEmpty = _ownedPrototypeBindings.isEmpty();
                            if (_isEmpty) {
                              _xifexpression = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)accessFeatureClassifier), ((Classifier)callContextSubcomponentType));
                            } else {
                              _xifexpression = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)accessFeatureClassifier), ((Classifier)callContextSubcomponentType), callContextSubcomponent);
                            }
                            _switchResult_4 = _xifexpression;
                          }
                        }
                        if (!_matched_4) {
                          if (callContextSubcomponentType instanceof ComponentPrototype) {
                            _matched_4=true;
                            ComponentClassifier _xblockexpression_2 = null;
                            {
                              ComponentClassifier prototypeContext = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)callContextSubcomponentType), containingClassifier);
                              ComponentClassifier _xifexpression = null;
                              boolean _notEquals = (!Objects.equal(prototypeContext, null));
                              if (_notEquals) {
                                _xifexpression = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)accessFeatureClassifier), prototypeContext);
                              }
                              _xblockexpression_2 = _xifexpression;
                            }
                            _switchResult_4 = _xblockexpression_2;
                          }
                        }
                        _xblockexpression_1 = _switchResult_4;
                      }
                      _switchResult_3 = _xblockexpression_1;
                    }
                  }
                  if (!_matched_3) {
                    _switchResult_3 = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)accessFeatureClassifier), containingClassifier);
                  }
                  _switchResult_2 = _switchResult_3;
                }
              }
              _switchResult_1 = _switchResult_2;
            }
          }
          if (!_matched_1) {
            if (calledSubprogram instanceof ComponentPrototype) {
              _matched_1=true;
              _switchResult_1 = Aadl2ScopeProvider.findClassifierForComponentPrototype(((ComponentPrototype)calledSubprogram), containingClassifier);
            }
          }
          _switchResult = _switchResult_1;
        }
      }
      final Classifier contextClassifier = _switchResult;
      IScope _xifexpression = null;
      boolean _notEquals = (!Objects.equal(contextClassifier, null));
      if (_notEquals) {
        Iterable<? extends EObject> _apply = validMemberCollector.apply(contextClassifier);
        _xifexpression = PropertiesScopeProvider.scopeFor(_apply);
      } else {
        _xifexpression = IScope.NULLSCOPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
