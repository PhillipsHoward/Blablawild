package fr.wcs.blablawild;

import java.util.Date;

public class TripModel {

    private String firstname;
    private String lastname;
    private Date dateModel;
    private int price;

    public TripModel(String firstname, String lastname, Date date, int price) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateModel = date;
        this.price = price;

    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public Date getDateModel() {
        return this.dateModel;
    }

    public int getPrice() {
        return this.price;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDate(Date date) {
        this.dateModel = date;
    }

    public void setPrice(int price) {
        this.price = price;
    }









}
