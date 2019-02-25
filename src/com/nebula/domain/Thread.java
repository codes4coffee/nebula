package com.nebula.domain;

import java.util.Date;

public class Thread {
    private int id = 0;
    private Location location;
    private Date lastActive;

    public Thread() {
        location = new Location();
        lastActive = new Date(0);
    }

    public Thread(int id, Location location, Date lastActive) {
        this.id = id;
        this.location = location;
        this.lastActive = lastActive;
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
}
