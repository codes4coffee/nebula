package com.nebula.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a message thread, mainly consisting of an opening post
 * and several comments.
 */
public class Thread {
    private int id;
    private String customerId;
    private Location location;
    private Date lastActive;
    private RootMessage openingPost;
    private List<Message> comments;

    /**
     * Constructs an undefined message thread.
     */
    public Thread() {
        id = 0;
        customerId = "";
        location = new Location();
        lastActive = new Date(0);
        openingPost = new RootMessage();
        comments = new ArrayList<>();
    }

    /**
     * Constructs a message thread from given parameters.
     * @param id a unique identifier
     * @param customerId the username of the opening poster
     * @param location a location
     * @param lastActive a last active date/time
     * @param openingPost the opening post
     * @param comments a list of comments
     */
    public Thread(int id, String customerId, Location location, Date lastActive, RootMessage openingPost, List<Message> comments) {
        this.id = id;
        this.customerId = customerId;
        this.location = location;
        this.lastActive = lastActive;
        this.openingPost = openingPost;
        this.comments = new ArrayList<>(comments);
    }

    /**
     * Gets the username of the message thread's opening poster.
     * @return the username
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the username of the message thread's opening poster.
     * @param customerId the new username
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the thread's unique identifier.
     * @return the unique identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the thread's unique identifier.
     * @param id the new unique identifier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Determines where the thread was posted.
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the thread's posting location.
     * @param location the new location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets the date/time of the message thread's last activity.
     * @return the last activity
     */
    public Date getLastActive() {
        return lastActive;
    }

    /**
     * Sets the date/time of the message thread last activity.
     * @param lastActive the new last activity
     */
    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    /**
     * Gets the message thread's opening post.
     * @return the opening post
     */
    public RootMessage getOpeningPost() {
        return openingPost;
    }

    /**
     * Sets the message thread's opening post.
     * @param openingPost the new opening post
     */
    public void setOpeningPost(RootMessage openingPost) {
        this.openingPost = openingPost;
    }

    /**
     * Gets the message thread's comments.
     * @return the list of comments
     */
    public List<Message> getComments() {
        return comments;
    }

    /**
     * Sets the message thread's comments.
     * @param comments the new list of comments
     */
    public void setComments(List<Message> comments) {
        this.comments = comments;
    }
}
