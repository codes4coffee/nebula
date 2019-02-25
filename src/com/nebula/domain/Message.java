package com.nebula.domain;

public class Message {
    private String body;

    public Message() {
        body = "";
    }

    public Message(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}