package org.acme;

import org.acme.config.Base64Value;
import org.acme.config.GreetingConfig;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingConfig greetingConfig;

    @ConfigProperty(name = "greeting.base64name")
    Base64Value name64;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return sayHello();
    }

    private String sayHello() {

        return String.format(
                "The number is %d %s %s%s Country information of %s with code: %d",
                greetingConfig.getNumber()
                              .orElse(1), greetingConfig.getPrefix(), greetingConfig.getName(),
                greetingConfig.getSuffix(), greetingConfig.getCountry()
                                                          .getName(), greetingConfig.getCountry()
                                                                                    .getId());
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
