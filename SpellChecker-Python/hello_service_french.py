# iPOPO decorators
from pelix.ipopo.decorators import ComponentFactory, Provides, Instantiate


# Manipulates the class and sets its (unique) factory name
@ComponentFactory("hello-service-french-factory")
# Indicate that the components will provide a service
@Provides("com.drem.osgi.services.hello")
# Tell iPOPO to instantiate a component instance as soon as the file is loaded
@Instantiate("hello-service-french-auto")
# A component class must always inherit from object (new-style class)
class HelloFrenchService(object):
    """
    A sample service provider
    """

    def hello(self, name="world"):
        """
        Says hello
        """
        print "Bonjor " + name + "!"
