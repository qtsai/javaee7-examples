package nl.tsai.javaee.resource;

import io.restassured.RestAssured;
import nl.tsai.javaee.BaseDeployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;

public class HelloResourceArquillianIntegrationTest extends BaseDeployment {

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
