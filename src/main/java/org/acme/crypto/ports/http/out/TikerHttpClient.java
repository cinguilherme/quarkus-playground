package org.acme.crypto.ports.http.out;

import org.acme.crypto.ports.http.out.wire.Tiker;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tiker")
@RegisterRestClient(configKey = "tiker-api")
public interface TikerHttpClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Tiker getTiker();

}
