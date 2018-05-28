package com.example.incubator3.travniknightrace.activities.propertyActivity;

/**
 * Created by admin on 3/22/2016.
 */
public class BeanClassForHomeListView {

    private int image;
    private String city;
    private String hotel;


    public BeanClassForHomeListView(int image, String city, String hotel) {

        this.image = image;
        this.city = city;
        this.hotel = hotel;


    }


    public int getImage() {
        return image;
    }

    public String getCity() {
        return city;
    }

    public String getHotel() {
        return hotel;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getcity() {
        return city;
    }

    public String gethotel() {
        return hotel;
    }
}

