package com.nebula.domain;

/**
 * Represents the opening post of a message thread. It mainly consists
 * of a title/subject, the image representing the subject, and a body
 * of text.
 */
public class RootMessage extends Message {
    private String title;
    private String type;
    private String imageUrl;

    /**
     * Constructs an empty opening post.
     */
    public RootMessage() {
        title = "";
        type = "";
        imageUrl = "";
    }

    /**
     * Constructs an opening post from given parameters.
     * @param customerId the poster of this message post
     * @param body the body of text
     * @param title the title/subject of this message
     * @param type the category which this message belongs to
     * @param imageUrl a URL to the message's image
     */
    public RootMessage(String customerId, String body, String title, String type, String imageUrl) {
        super(customerId, body);
        this.title = title;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the title of this message.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this message.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the type of message.
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of this message.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets a URL of the message's image.
     * @return the image URL
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the URL of the message' image.
     * @param imageUrl the new image URL
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}