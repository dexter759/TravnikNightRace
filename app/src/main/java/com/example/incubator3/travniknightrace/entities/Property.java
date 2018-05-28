package com.example.incubator3.travniknightrace.entities;

public class Property {

    private String name;
    private String location;
    private String text;
    private String broj;
    private String email;
    private String lonLat;
    private String besplatno;
    private int image;

    public Property(String name, String location, String text, String broj, String email, String lonLat, String besplatno) {
        this.name = name;
        this.location = location;
        this.text = text;
        this.broj = broj;
        this.email = email;
        this.lonLat = lonLat;
        this.besplatno = besplatno;
    }

    public Property(String name, String location, String text, String broj, String email, String lonLat, String besplatno, int image) {
        this.name = name;
        this.location = location;
        this.text = text;
        this.broj = broj;
        this.email = email;
        this.lonLat = lonLat;
        this.besplatno = besplatno;
        this.image = image;
    }

    public Property() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLonLat() {
        return lonLat;
    }

    public void setLonLat(String lonLat) {
        this.lonLat = lonLat;
    }

    public String getBesplatno() {
        return besplatno;
    }

    public void setBesplatno(String besplatno) {
        this.besplatno = besplatno;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

