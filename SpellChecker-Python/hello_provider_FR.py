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
    def hello(self, name="monde"):
        """
        Says hello
        """
        print("Bonjour,", name, "!")

    def bye(self, name="monde cruel"):
        """
        Says bye
        """
        print("Au revoir,", name, "!")
