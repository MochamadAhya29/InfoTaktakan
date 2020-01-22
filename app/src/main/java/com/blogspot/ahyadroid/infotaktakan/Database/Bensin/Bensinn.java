package com.blogspot.ahyadroid.infotaktakan.Database.Bensin;

public class Bensinn {

    private int id;
    private String title;
    private String contact;
    private String location;
    private String image;

    public Bensinn(int id, String title, String contact, String location, String image) {
        this.id = id;
        this.title = title;
        this.contact = contact;
        this.location = location;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
