package pl.waw.sgh.bank;

import java.math.BigDecimal;

public abstract class Konto {

    private Integer kontoId;

    private String waluta;

    private BigDecimal stan;

    private Klient klient;

    public Konto(Integer kontoId, String waluta, BigDecimal stan, Klient klient) {
        this.kontoId = kontoId;
        this.waluta = waluta;
        this.stan = stan;
        this.klient = klient;
    }

    public Integer getKontoId() {
        return kontoId;
    }

    public void setKontoId(Integer kontoId) {
        this.kontoId = kontoId;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public BigDecimal getStan() {
        return stan;
    }

    public void setStan(BigDecimal stan) {
        this.stan = stan;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "Id=" + kontoId +
                ", " + waluta +
                ", stan=" + stan +
                ", klient=" + klient.getKlientId() +
                '}';
    }
}
