package com.example.incubator3.travniknightrace.entities;

public class UserExtra {

private String id;
private String ime;
private String prezime;
private String osobaZaHitnePozive;
private String kontakOsobaZaHitnePozive;
private String datumRodenja;
private String velicinaMajice;
private String lokacija;
private String rezultat1;
private String rezultat2;
private boolean prijavljen;
private String brojTelefona;

private User user;


    public UserExtra(String id, String ime, String prezime, String osobaZaHitnePozive, String kontakOsobaZaHitnePozive, String datumRodenja, String velicinaMajice, String lokacija, String rezultat1, String rezultat2, boolean prijavljen, String brojTelefona, User user) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.osobaZaHitnePozive = osobaZaHitnePozive;
        this.kontakOsobaZaHitnePozive = kontakOsobaZaHitnePozive;
        this.datumRodenja = datumRodenja;
        this.velicinaMajice = velicinaMajice;
        this.lokacija = lokacija;
        this.rezultat1 = rezultat1;
        this.rezultat2 = rezultat2;
        this.prijavljen = prijavljen;
        this.brojTelefona = brojTelefona;
        this.user = user;
    }

    public UserExtra(String id, String ime, String prezime, String osobaZaHitnePozive, String kontakOsobaZaHitnePozive, String datumRodenja, String velicinaMajice, String lokacija, String brojTelefona, User user) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.osobaZaHitnePozive = osobaZaHitnePozive;
        this.kontakOsobaZaHitnePozive = kontakOsobaZaHitnePozive;
        this.datumRodenja = datumRodenja;
        this.velicinaMajice = velicinaMajice;
        this.lokacija = lokacija;
        this.brojTelefona = brojTelefona;
        this.user = user;
    }

    public UserExtra() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOsobaZaHitnePozive() {
        return osobaZaHitnePozive;
    }

    public void setOsobaZaHitnePozive(String osobaZaHitnePozive) {
        this.osobaZaHitnePozive = osobaZaHitnePozive;
    }

    public String getKontakOsobaZaHitnePozive() {
        return kontakOsobaZaHitnePozive;
    }

    public void setKontakOsobaZaHitnePozive(String kontakOsobaZaHitnePozive) {
        this.kontakOsobaZaHitnePozive = kontakOsobaZaHitnePozive;
    }

    public String getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(String datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getVelicinaMajice() {
        return velicinaMajice;
    }

    public void setVelicinaMajice(String velicinaMajice) {
        this.velicinaMajice = velicinaMajice;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getRezultat1() {
        return rezultat1;
    }

    public void setRezultat1(String rezultat1) {
        this.rezultat1 = rezultat1;
    }

    public String getRezultat2() {
        return rezultat2;
    }

    public void setRezultat2(String rezultat2) {
        this.rezultat2 = rezultat2;
    }

    public boolean getPrijavljen() {
        return prijavljen;
    }

    public void setPrijavljen(boolean prijavljen) {
        this.prijavljen = prijavljen;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return "UserExtra{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", osobaZaHitnePozive='" + osobaZaHitnePozive + '\'' +
                ", kontakOsobaZaHitnePozive='" + kontakOsobaZaHitnePozive + '\'' +
                ", datumRodenja='" + datumRodenja + '\'' +
                ", velicinaMajice='" + velicinaMajice + '\'' +
                ", lokacija='" + lokacija + '\'' +
                ", rezultat1='" + rezultat1 + '\'' +
                ", rezultat2='" + rezultat2 + '\'' +
                ", prijavljen='" + prijavljen + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", user=" + user +
                '}';
    }
}
