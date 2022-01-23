package nl.tsai.javaee.resource.v1;

import nl.tsai.javaee.event.Message;
import nl.tsai.javaee.event.MessageEvent;
import nl.tsai.javaee.inject.GreetingsFacade;
import nl.tsai.javaee.paramconverter.QueryParamObject;
import nl.tsai.javaee.producer.GreetBob;
import nl.tsai.javaee.resource.HelloResource;
import nl.tsai.javaee.resource.ResponseObject;
import nl.tsai.javaee.scope.ScopedCountFacade;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class HelloV1Resource implements HelloResource {

    @Inject
    private GreetingsFacade greetingsFacade;

    @Inject
    @Message
    private Event<MessageEvent> messageEventPublisher;

    @Inject
    private ScopedCountFacade scopedCountFacade;

    @Inject
    @GreetBob
    private String greetBob;

    /**
     * http://localhost:9080/javaee7-examples/api/hello/hi?name=Jack
     *
     * @return formal greeting from {@link nl.tsai.javaee.inject.FormalHelloService}
     * OR
     * friendly greeting from {@link nl.tsai.javaee.inject.alternatives.WhatsUpService} when alternative is declared
     */
    public Response hi(String name) {
        String formalGreeting = greetingsFacade.formal(name);
        return createResponse(formalGreeting);
    }

    /**
     * http://localhost:9080/javaee7-examples/api/hello/hey?name=John
     *
     * @return informal greeting from {@link nl.tsai.javaee.inject.InformalHeyService}
     */
    public Response hey(QueryParamObject object) {
        String informalGreeting = greetingsFacade.informal(object.getName());
        return createResponse(informalGreeting);
    }

    /**
     * http://localhost:9080/javaee7-examples/api/hello/bob
     *
     * @return greet bob from {@link nl.tsai.javaee.producer.GreetBobProducer}
     */
    public Response bob() {
        String bob = greetBob;
        return createResponse(bob);
    }

    private Response createResponse(String greeting) {
        messageEventPublisher.fire(new MessageEvent(greeting));
        ResponseObject response = new ResponseObject();
        response.put("count", scopedCountFacade.count());
        response.put("greeting", greeting);
        return Response.ok().entity(response).build();
    }
}