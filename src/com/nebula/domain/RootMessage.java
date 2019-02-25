package com.nebula.domain;

public class RootMessage extends Message {
    private String type;
    private String title;

    public RootMessage() {
        type = "";
        title = "";
    }

    public RootMessage(String body, String type, String title) {
        super(body);
        this.type = type;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}