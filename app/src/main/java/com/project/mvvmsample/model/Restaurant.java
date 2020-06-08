package com.project.mvvmsample.model;

public class Restaurant {
    private String name;
    private String image;

    public Restaurant(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
