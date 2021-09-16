package org.acme.crypto;

import org.acme.crypto.ports.http.out.CurrencyHttpClient;
import org.acme.crypto.ports.http.out.TikerHttpClient;
import org.acme.crypto.ports.http.out.wire.CurrencyDto;
import org.acme.crypto.ports.http.out.wire.Tiker;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Path("/crypto")
public class CryptoResource {

    private final Logger logger = Logger.getLogger(this.getClass()
                                                       .getName());
    @Inject
    @RestClient
    CurrencyHttpClient currencyHttpClient;

    @Inject
    @RestClient
    TikerHttpClient tikerHttpClient;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newFile() {
        return Response.ok()
                       .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CurrencyDto> getCryptos() {

        try {
            return currencyHttpClient.getCurrencies()
                                     .getData();
        } catch (Exception e) {
            logger.info("error in restclient");
            logger.info(e);
        }

        return List.of();

    }

    @GET
    @Path("/inTiker")
    @Produces(MediaType.APPLICATION_JSON)
    public Tiker getTiker() {
        logger.info("Got a http call in /inTiker");
        return tikerHttpClient.getTiker();
    }

}
