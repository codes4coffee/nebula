package com.nebula.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Thread {
    private int id;
    private Location location;
    private Date lastActive;
    private RootMessage openingPost;
    private List<Message> comments;

    public Thread() {
        id = 0;
        location = new Location();
        lastActive = new Date(0);
        openingPost = new RootMessage();
        comments = new ArrayList<>();
    }

    public Thread(int id, Location location, Date lastActive, RootMessage openingPost, List<Message> comments) {
        this.id = id;
        this.location = location;
        this.lastActive = lastActive;
        this.openingPost = openingPost;
        this.comments = new ArrayList<>(comments);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public RootMessage getOpeningPost() {
        return openingPost;
    }

    public void setOpeningPost(RootMessage openingPost) {
        this.openingPost = openingPost;
    }

    public List<Message> getComments() {
        return comments;
    }

    public void setComments(List<Message> comments) {
        this.comments = comments;
    }
}
