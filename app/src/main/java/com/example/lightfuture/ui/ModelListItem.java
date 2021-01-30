package com.example.lightfuture.ui;

public class ModelListItem {
    public int id;
    public String number;
    public String location;
    public double coordinate1;
    public double coordinate2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ModelListItem(int id, String number, String location, double coordinate1, double coordinate2) {
        this.id = id;
        this.number = number;
        this.location = location;
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }
}
