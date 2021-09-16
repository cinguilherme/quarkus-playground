package org.acme.crypto.ports.http.out.wire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WrapperCurrency {

    private Collection<CurrencyDto> data;


    public Collection<CurrencyDto> getData() {
        return data;
    }

    public void setData(Collection<CurrencyDto> data) {
        this.data = data;
    }
}
