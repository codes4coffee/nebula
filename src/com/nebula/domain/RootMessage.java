package com.nebula.domain;

public class RootMessage extends Message {
    private String title;
    private String type;
    private String imageUrl;

    public RootMessage() {
        title = "";
        type = "";
        imageUrl = "";
    }

    public RootMessage(String customerId, String body, String title, String type, String imageUrl) {
        super(customerId, body);
        this.title = title;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}