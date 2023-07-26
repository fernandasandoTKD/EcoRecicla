package com.example.ecorecicla.modelos;

public class Plastic {
    float kg;
    float price;
    String month;

    public Plastic(float kg, float price, String month) {
        this.kg = kg;
        this.price = price;
        this.month = month;
    }

    public float getKg() {
        return kg;
    }

    public float getPrice() {
        return price;
    }

    public String getMonth() {
        return month;
    }
}
