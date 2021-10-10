package test.demo.rest;

import test.demo.event.Message;
import test.demo.event.MessageEvent;
import test.demo.inject.GreetingsFacade;
import test.demo.producer.GreetBob;
import test.demo.scope.ScopedCountFacade;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("hello")
@Produces({"application/json"})
public class HelloResource {

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

    @GET
    @Path("hi")
    public Response hi() {
        String formalGreeting = greetingsFacade.formal();
        return createResponse(formalGreeting);
    }

    @GET
    @Path("hey")
    public Response hey() {
        String informalGreeting = greetingsFacade.informal();
        return createResponse(informalGreeting);
    }

    @GET
    @Path("bob")
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
