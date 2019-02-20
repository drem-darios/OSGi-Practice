package com.drem.osgi.hello.impl.english;

import com.drem.osgi.spell.services.Hello;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class HelloEnglishBundleActivator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting HelloEnglish Bundle");
        ServiceReference helloServiceRef = bundleContext.getServiceReference(Hello.class.getName());
        if (helloServiceRef != null) {
            Hello helloService = (Hello) bundleContext.getService(helloServiceRef);
            System.out.println(helloService.sayHello("Bundle Activator"));
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping HelloEnglish Bundle");
    }
}
