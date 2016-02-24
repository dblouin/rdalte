package org.osate.xtext.aadl2;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

@SuppressWarnings("all")
public class Activator extends Plugin {
  private static Activator plugin;
  
  @Override
  public void start(final BundleContext context) throws Exception {
    super.start(context);
    Activator.plugin = this;
  }
  
  @Override
  public void stop(final BundleContext context) throws Exception {
    Activator.plugin = null;
    super.stop(context);
  }
  
  public static Activator getDefault() {
    return Activator.plugin;
  }
}
