package pl.waw.sgh.bank;

public class Klient {

    private Integer klientId;

    private String imie;

    private String nazwisko;

    private String email;

    public Klient(Integer klientId, String imie, String nazwisko, String email) {
        this.klientId = klientId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public Integer getKlientId() {
        return klientId;
    }

    public void setKlientId(Integer klientId) {
        this.klientId = klientId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "Id=" + klientId +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
