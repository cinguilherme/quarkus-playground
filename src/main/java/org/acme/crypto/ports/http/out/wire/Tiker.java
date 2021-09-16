package org.acme.crypto.ports.http.out.wire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tiker {

    private InTiker tiker;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    class InTiker {

        private String high;
        private String low;
        private String vol;
        private String last;
        private String buy;
        private String sell;
        private String open;
        private String date;

    }
}
