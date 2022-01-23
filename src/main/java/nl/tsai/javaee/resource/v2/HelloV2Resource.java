package nl.tsai.javaee.resource.v2;

import nl.tsai.javaee.paramconverter.QueryParamObject;
import nl.tsai.javaee.resource.HelloResource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HelloV2Resource implements HelloResource {

    @Inject
    @Named("v1-redirect")
    private Client client;

    /**
     * Redirect to {@link nl.tsai.javaee.resource.v1.HelloV1Resource#hi} impl
     */
    @Override
    public Response hi(String name) {
        return client.target("http://localhost:9080/javaee7-examples/api/v1/hello/hi").queryParam("name", name)
                .request().accept(MediaType.APPLICATION_JSON).get();
    }

    /**
     * https://docs.oracle.com/javaee/7/tutorial/jaxrs-client003.htm
     * <p>
     * call bob for async
     */
    @Override
    public Response hey(QueryParamObject object) {
        longRunningTask();
        return hi(object.getName());
    }

    @Override
    public Response bob() {
        Future<Response> responseFuture = client.target("http://localhost:9080/javaee7-examples/api/v2-overridden/hello/hey").queryParam("name", "bob")
                .request().accept(MediaType.APPLICATION_JSON).async().get();

        Response response = null;
        try {
            response = responseFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return response;
    }

    private void longRunningTask() {
        try {
            System.out.println("Waiting for task to complete");
            Thread.sleep(5000);
            System.out.println("Task completed");
        } catch (InterruptedException ignored) {
        }
    }
}
