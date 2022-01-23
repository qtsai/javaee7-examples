package nl.tsai.javaee.resource;

import nl.tsai.javaee.paramconverter.QueryParamObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("hello")
@Produces({"application/json"})
public interface HelloResource {

    @GET
    @Path("hi")
    Response hi(@QueryParam("name") String name);

    @GET
    @Path("hey")
    Response hey(@QueryParam("name") QueryParamObject object);

    @GET
    @Path("bob")
    Response bob();
}
