package pl.waw.sgh.bank;

import java.math.BigDecimal;

public class KontoRor extends Konto {
    public KontoRor(Integer kontoId, String waluta, BigDecimal stan, Klient klient) {
        super(kontoId, waluta, stan, klient);
    }
}
