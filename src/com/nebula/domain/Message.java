package com.nebula.domain;

public class Message {
    private String customerId;
    private String body;

    public Message() {
        customerId = "";
        body = "";
    }

    public Message(String customerId, String body) {
        this.customerId = customerId;
        this.body = body;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}