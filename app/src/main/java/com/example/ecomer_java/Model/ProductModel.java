package com.example.ecomer_java.Model;

public class ProductModel {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;


    public ProductModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
