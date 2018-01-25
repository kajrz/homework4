package pl.waw.sgh.bank;

import java.math.BigDecimal;

public class KontoOszcz extends Konto {
    public KontoOszcz(Integer kontoId, String waluta, BigDecimal stan, Klient klient) {
        super(kontoId, waluta, stan, klient);
    }
}
