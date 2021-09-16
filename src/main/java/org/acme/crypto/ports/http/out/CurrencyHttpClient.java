package org.acme.crypto.ports.http.out;

import org.acme.crypto.ports.http.out.wire.WrapperCurrency;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tickers")
@RegisterClientHeaders(CurrencyHeaderFactory.class)
@RegisterRestClient(configKey = "currency-api")
public interface CurrencyHttpClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    WrapperCurrency getCurrencies();

}
