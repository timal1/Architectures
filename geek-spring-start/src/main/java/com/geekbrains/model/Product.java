package com.geekbrains.model;


public class Product {
    private Long id;
    private String title;
    private double coast;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCoast() {
        return coast;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public Product() {
    }

    public Product(Long id, String title, double coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Товар № " + id + " " + title + " " + coast + " руб.";
    }
}
