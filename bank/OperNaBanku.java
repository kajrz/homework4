package pl.waw.sgh.bank;

import java.math.BigDecimal;

public class OperNaBanku {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Klient k1 = bank.stworzKlienta("Anna", "Malinowska", "anna.malin@gmail.com");
        Klient k2 = bank.stworzKlienta("Jan", "Kowalski", "jan@kowal.com");
        Konto ko1 = bank.stworzKonto(true, "PLN", k1);
        Konto ko2 = bank.stworzKonto(false, "PLN", k1);
        Konto ko3 = bank.stworzKonto(true, "PLN", k2);
        Konto ko4 = bank.stworzKonto(false, "PLN", k2);
        BigDecimal kwota1 = new BigDecimal(-100.0);
        BigDecimal kwota2 = new BigDecimal(200.0);
        BigDecimal kwota3 = new BigDecimal(300.0);
        BigDecimal kwota4 = new BigDecimal(400.0);
        System.out.println(bank.listaKont);
        bank.uznanie(0,kwota1);
        System.out.println(bank.listaKont);
        bank.uznanie(1, kwota2);
        System.out.println(bank.listaKont);
        bank.uznanie(2, kwota3);
        System.out.println(bank.listaKont);
        bank.uznanie(3, kwota4);
        System.out.println(bank.listaKont);
        bank.obciazenie(0,kwota2);
        System.out.println(bank.listaKont);
        bank.obciazenie(1, kwota3);
        System.out.println(bank.listaKont);
        bank.obciazenie(2, kwota1);
        System.out.println(bank.listaKont);
        bank.obciazenie(3, kwota1);
        System.out.println(bank.listaKont);
        bank.przelew(3,1,kwota1);
        System.out.println(bank.listaKont);
        bank.przelew(0,3,kwota4);
        System.out.println(bank.listaKont);

    }
}
