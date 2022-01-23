package nl.tsai.javaee.client;

import nl.tsai.javaee.client.filter.LoggingRequestFilter;
import nl.tsai.javaee.client.filter.LoggingResponseFilter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@ApplicationScoped
public class JaxRsClientApi {

    @Produces
    @Named("v1-redirect")
    public Client getClient() {
        return ClientBuilder.newClient()
                .register(LoggingRequestFilter.class)
                .register(LoggingResponseFilter.class);
    }
}
