# iPOPO decorators
from threading import Thread

import time
from pelix.ipopo.decorators import ComponentFactory, Requires, Instantiate, \
    Validate, Invalidate, Property


# Manipulates the class and sets its (unique) factory name
@ComponentFactory("hello-consumer-factory")
# Indicate that the components require a sample.hello service to work
# and to inject the found service in the _svc field
@Requires('_svc', "com.drem.osgi.services.hello", aggregate=True, optional=False)
# Tell iPOPO to instantiate a component instance as soon as the file is loaded
@Instantiate("hello-consumer-auto")
# A component class must always inherit from object (new-style class)
class HelloClient(object):
    """
    A sample service consumer
    """

    def __init__(self):
        """
        Defines (injected) members
        """
        self._svc = None
        self._delay = 5
        self._end = None

    @Validate
    def validate(self, context):
        self._end = False
        """
        Component validated: all its requirements have been injected
        """
        thread = Thread(target=self.run)
        thread.start()

    def run(self):
        while not self._end:
            self.invoke_hello_service()
            time.sleep(self._delay)

    def invoke_hello_service(self):
        for hello_service in self._svc:
            hello_service.hello('Drem')

    @Invalidate
    def invalidate(self, context):
        """
        Component invalidated: one of its requirements is going away
        """
        self._end = True
