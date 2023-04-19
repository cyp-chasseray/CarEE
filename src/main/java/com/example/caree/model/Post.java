package com.example.caree.model;

public class Post {

    private Long id;
    private String title;
    private String content;
    private double price;
    private int categoryId;
    private String pictureUrl;

    public Post(Long id, String title, String content, double price, int categoryId, String pictureUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.categoryId = categoryId;
        this.pictureUrl = pictureUrl;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public double getPrice() {
        return price;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
}
