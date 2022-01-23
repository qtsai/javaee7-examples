package nl.tsai.javaee.resource.v2;

import nl.tsai.javaee.paramconverter.QueryParamObject;
import nl.tsai.javaee.resource.HelloResource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @Override
    public Response hey(QueryParamObject object) {
        throw new RuntimeException("Not yet implemented...");
    }

    @Override
    public Response bob() {
        throw new RuntimeException("Not yet implemented...");
    }
}
