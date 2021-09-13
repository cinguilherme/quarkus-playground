package org.acme.config;

import lombok.Getter;
import lombok.ToString;

import java.util.Base64;

@Getter
@ToString
public class Base64Value {

    private final String value;

    public Base64Value(String base64) {
        this.value = new String(Base64.getDecoder()
                                      .decode(base64));
    }

}
