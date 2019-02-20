package com.drem.osgi.hello.impl.english;

import com.drem.osgi.spell.services.Hello;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.ServiceProperty;

@Component
@Provides
@Instantiate // Declare an instance of the component
public class HelloEnglish implements Hello {


    @ServiceProperty(name = "user.name")
    public String propName;


    /**
     * Returns an 'Hello' message.
     *
     * @param name : name
     * @return Hello message
     * @see com.drem.osgi.spell.services.Hello#sayHello(String)
     */
    public String sayHello(String name) {
        if (propName != null) {
            name = propName;
        }
        return "Hello " + name + "!";
    }
}
