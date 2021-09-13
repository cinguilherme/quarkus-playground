package org.acme.config;

import org.eclipse.microprofile.config.spi.Converter;

public class Base64Converter implements Converter<Base64Value> {

    @Override
    public Base64Value convert(String s) throws IllegalArgumentException, NullPointerException {
        return new Base64Value(s);
    }
}
