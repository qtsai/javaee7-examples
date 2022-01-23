package nl.tsai.javaee;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;

@RunWith(Arquillian.class)
public abstract class BaseDeployment {

    @ArquillianResource
    protected URL baseUrl;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "nl.tsai")
                .addAsManifestResource(new File("/META-INF/beans.xml"));
    }
}
