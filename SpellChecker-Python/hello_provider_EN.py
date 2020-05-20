# iPOPO decorators
from pelix.ipopo.decorators import ComponentFactory, Provides, Instantiate

# Manipulates the class and sets its (unique) factory name
@ComponentFactory("hello-provider-factory")
# Indicate that the components will provide a service
@Provides("hello_service")
# Tell iPOPO to instantiate a component instance as soon as the file is loaded
@Instantiate("hello-provider-auto")
# A component class must always inherit from object (new-style class)
class HelloProvider(object):
    """
    A sample service provider
    """
    def hello(self, name="world"):
        """
        Says hello
        """
        print("Hello,", name, "!")

    def bye(self, name="cruel world"):
        """
        Says bye
        """
        print("Bye,", name, "!")