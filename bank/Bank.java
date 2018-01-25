package pl.waw.sgh.bank;

import javax.print.attribute.IntegerSyntax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    public Integer ostKlientId = 0;

    public Integer ostKontoId = 0;

    public List<Klient> listaKlient = new ArrayList<>();

    public List<Konto> listaKont = new ArrayList<>();

    public Klient stworzKlienta(String imie, String nazwisko, String email) {
        Klient kl = new Klient(ostKlientId++,imie,nazwisko,email);
        listaKlient.add(kl);
        return kl;
    }

    public Konto stworzKonto(boolean czyRor, String waluta, Klient klient) {
        Konto konto = czyRor ?
                new KontoRor(ostKontoId++, waluta, new BigDecimal(0), klient)
                :
                new KontoOszcz(ostKontoId++, waluta, new BigDecimal(0), klient);
        listaKont.add(konto);
        return konto;
    }

    public Konto uznanie(Integer kontoID, BigDecimal kwota){
        System.out.println("Uznanie na kwotę: " + kwota + " na koncie: " + kontoID);
        Integer odbiorca = znajdzKonto(kontoID);
        if (odbiorca.equals(999)){
            System.out.println("Konto o numerze " + kontoID + " nie istnieje, przerwanie operacji.");
        } else {
            if (kwota.signum()<0){
                System.out.println("Podana kwota uznania jest ujemna, przerwanie operacji.");
            } else {
                Konto update = listaKont.get(odbiorca);
                BigDecimal saldo = update.getStan();
                saldo = saldo.add(kwota);
                update.setStan(saldo);
                listaKont.set(odbiorca,update);
                System.out.println("Uznanie wykonane.");
            }
        }
        return null;
    }

    public Konto obciazenie(Integer kontoID, BigDecimal kwota){
        System.out.println("Obciążenie na kwotę: " + kwota + " na koncie: " + kontoID);
        Integer odbiorca = znajdzKonto(kontoID);
        if (odbiorca.equals(999)){
            System.out.println("Konto o numerze " + kontoID + " nie istnieje, przerwanie operacji.");
        } else {
            if (kwota.signum()<0){
                System.out.println("Podana kwota obciążenia jest ujemna, przerwanie operacji.");
            } else {
                Konto update = listaKont.get(odbiorca);
                BigDecimal saldo = update.getStan();
                if (saldo.compareTo(kwota) >0){
                saldo = saldo.subtract(kwota);
                update.setStan(saldo);
                listaKont.set(odbiorca,update);
                System.out.println("Obciążenie wykonane.");
                } else {
                    System.out.println("Na koncie nie ma wystarczającej liczby środków, przerwanie operacji.");
                }
            }
        }
        return null;
    }


    public Integer znajdzKonto(Integer kontoId) {
        Integer tech = 999;
        for (Integer i = 0; i<ostKontoId; i++){
            if (listaKont.get(i).getKontoId().equals(kontoId)) {
                tech = i;
            }
        }
        return tech;
    }

    public void przelew(Integer kontoZrodloweId, Integer kontoCelId, BigDecimal kwota) {
        Integer cel = znajdzKonto(kontoCelId);
        Integer zrodlo = znajdzKonto(kontoZrodloweId);
        System.out.println("Przelew na kwotę " + kwota + " z konta " + kontoZrodloweId + " na konto " + kontoCelId);
        if (cel.equals(999)||zrodlo.equals(999)){
            System.out.println("Co najmniej jeden z numerów kont jest niepoprawny, przerwanie operacji.");
        } else {
            if (kwota.signum()<0) {
                System.out.println("Podana kwota przelewu jest ujemna, przerwanie operacji.");
            } else {
                if (listaKont.get(zrodlo).getStan().compareTo(kwota)<0) {
                    System.out.println("Na koncie źródłowym: " + zrodlo + " nie ma wystarczającej liczby środków: " + kwota + ", przerwanie operacji.");
                } else {
                    Konto updateZr = listaKont.get(zrodlo);
                    BigDecimal saldoZr = updateZr.getStan();
                    saldoZr = saldoZr.subtract(kwota);
                    updateZr.setStan(saldoZr);
                    listaKont.set(zrodlo, updateZr);
                    Konto updateCel = listaKont.get(cel);
                    BigDecimal saldoCel = updateCel.getStan();
                    saldoCel = saldoCel.add(kwota);
                    updateCel.setStan(saldoCel);
                    listaKont.set(cel,updateCel);
                    System.out.println("Przelew wykonany.");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "ostKlientId=" + ostKlientId +
                ", ostKontoId=" + ostKontoId +
                "\n, listaKlient=" + listaKlient +
                "\n, listaKont=" + listaKont +
                '}';
    }
}
