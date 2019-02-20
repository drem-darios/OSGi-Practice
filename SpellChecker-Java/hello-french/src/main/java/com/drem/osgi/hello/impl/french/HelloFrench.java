package com.drem.osgi.hello.impl.french;

import com.drem.osgi.spell.services.Hello;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.ServiceProperty;

@Component
@Provides
@Instantiate // Declare an instance of the component
public class HelloFrench implements Hello {

    /**
     * Returns an 'Bonjor' message.
     *
     * @param name : name
     * @return Hello message
     * @see Hello#sayHello(String)
     */
    public String sayHello(String name) {
        return "Bonjor " + name + "!";
    }
}
