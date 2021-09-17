package org.acme;

import io.agroal.api.AgroalDataSource;
import org.acme.config.Base64Value;
import org.acme.config.GreetingConfig;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/hello")
public class GreetingResource {

    private final Logger LOGGER = Logger.getLogger(this.getClass()
                                                       .getName());

    @Inject
    GreetingConfig greetingConfig;

    @Inject
    AgroalDataSource dataSource;

    @ConfigProperty(name = "greeting.base64name")
    Base64Value name64;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try {
            boolean execute = dataSource.getConnection()
                                        .prepareCall("select (1,2,3)")
                                        .execute();
            LOGGER.info(String.format("executed with result %s", execute));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("Accepted request on /hello and processed");
        return sayHello();
    }

    private String sayHello() {

        return String.format(
                "The number is %d %s %s%s Country information of %s with code: %d. The base64 property is %s",
                greetingConfig.getNumber()
                              .orElse(1), greetingConfig.getPrefix(), greetingConfig.getName(),
                greetingConfig.getSuffix(), greetingConfig.getCountry()
                                                          .getName(), greetingConfig.getCountry()
                                                                                    .getId(),
                name64.getValue());
    }

    @GET
    @Path("/details")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloDetails() {
        return "hello from details";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(String body) {
        System.out.println(body);
        return body;
    }
}
