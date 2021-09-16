package org.acme.crypto.ports.http.out.wire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyDto {

    private String id;
    private String symbol;
    private String name;
    private Integer rank;
    private BigDecimal price_usd;

}
