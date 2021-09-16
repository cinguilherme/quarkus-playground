package org.acme.crypto.ports.http.out;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

public class CurrencyHeaderFactory implements ClientHeadersFactory {
    @Override
    public MultivaluedMap<String, String> update(
            MultivaluedMap<String, String> multivaluedMap,
            MultivaluedMap<String, String> multivaluedMap1) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        result.add("content-type", "application/json");
        return result;
    }
}
