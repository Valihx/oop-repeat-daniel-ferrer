package com.musicshop.dto;

public class Instrument {

    private int instrumentId;
    private String name;
    private String type;
    private double price;
    private int stock;

    public Instrument(int instrumentId, String name, String type, double price, int stock) {
        this.instrumentId = instrumentId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Instrument:" +
                "Id=" + instrumentId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price + '\''+
                ", stock=" + stock +
                '}';
    }
}