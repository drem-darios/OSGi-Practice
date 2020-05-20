# iPOPO decorators
from pelix.ipopo.decorators import ComponentFactory, Requires, Instantiate, \
    Validate, Invalidate

# Manipulates the class and sets its (unique) factory name
@ComponentFactory("hello-consumer-factory")
# Indicate that the components require a sample.hello service to work
# and to inject the found service in the _svc field
@Requires('_svc', "hello_service")
# Tell iPOPO to instantiate a component instance as soon as the file is loaded
@Instantiate("hello-consumer-auto")
# A component class must always inherit from object (new-style class)
class HelloConsumer(object):
    """
    A sample service consumer
    """
    def __init__(self):
        """
        Defines (injected) members
        """
        self._svc = None

    @Validate
    def validate(self, context):
        """
        Component validated: all its requirements have been injected
        """
        self._svc.hello("Consumer")

    @Invalidate
    def invalidate(self, context):
        """
        Component invalidated: one of its requirements is going away
        """
        self._svc.bye("Consumer")