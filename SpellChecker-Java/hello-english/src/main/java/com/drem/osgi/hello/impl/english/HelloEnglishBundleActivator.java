package com.drem.osgi.hello.impl.english;

import com.drem.osgi.spell.services.Hello;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

@Component
@Instantiate
public class HelloEnglishBundleActivator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting HelloEnglish Bundle");
        ServiceReference helloServiceRef = bundleContext.getServiceReference(Hello.class.getName());
        Hello helloService = (Hello) bundleContext.getService(helloServiceRef);
        System.out.println(helloService.sayHello("Bundle Activator"));
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping HelloEnglish Bundle");
    }
}
