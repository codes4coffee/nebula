package com.nebula.domain;

/**
 * Represents a generic message posted by a user.
 */
public class Message {
    private String customerId;
    private String body;

    /**
     * Constructs an undefined message.
     */
    public Message() {
        customerId = "";
        body = "";
    }

    /**
     * Constructs a message from a given user and a body of text.
     * @param customerId the given user
     * @param body the body of text
     */
    public Message(String customerId, String body) {
        this.customerId = customerId;
        this.body = body;
    }

    /**
     * Gets the username of the user who posted this message.
     * @return the username of the user
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the poster of this message in the form of a username.
     * @param customerId the new poster
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the text body of this message.
     * @return the text body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the text body of this message.
     * @param body the new text body
     */
    public void setBody(String body) {
        this.body = body;
    }
}