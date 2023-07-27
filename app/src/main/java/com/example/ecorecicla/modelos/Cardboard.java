package com.example.ecorecicla.modelos;

public class Cardboard {
    float kg;
    float price;
    String month;

    public float getKg() {
        return kg;
    }

    public float getPrice() {
        return price;
    }

    public String getMonth() {
        return month;
    }

    public Cardboard(float kg, float price, String month) {
        this.kg = kg;
        this.price = price;
        this.month = month;
    }
}
