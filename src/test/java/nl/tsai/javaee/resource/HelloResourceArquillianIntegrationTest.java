package nl.tsai.javaee.resource;

import io.restassured.RestAssured;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;

import static org.hamcrest.core.StringContains.containsString;

@RunWith(Arquillian.class)
public class HelloResourceArquillianIntegrationTest {

    @ArquillianResource
    private URL baseUrl;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "nl.tsai")
                .addAsManifestResource(new File("/META-INF/beans.xml"));
    }

    @Before
    public void init() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @RunAsClient
    public void testHi() {
        final String name = "jan";
        RestAssured
                .given().queryParam("name", name)
                .when().get(baseUrl + "api/hello/hi")
                .then().assertThat().body("map.greeting", containsString(name));
    }

    @Test
    @RunAsClient
    public void testHi_twice() {
        final String name = "jan";
        //first call
        RestAssured
                .given().queryParam("name", name)
                .when().get(baseUrl + "api/hello/hi")
                .then().assertThat().body("map.greeting", containsString(name));
        //2nd call
        RestAssured
                .given().queryParam("name", name)
                .when().get(baseUrl + "api/hello/hey")
                .then().assertThat().body("map.greeting", containsString(name));
    }

}
