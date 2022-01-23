package nl.tsai.javaee.resource.v2;

import nl.tsai.javaee.paramconverter.QueryParamObject;
import nl.tsai.javaee.resource.HelloResource;

import javax.ws.rs.core.Response;

public class HelloV2Resource implements HelloResource {
    @Override
    public Response hi(String name) {
        throw new RuntimeException("Not yet implemented...");
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
