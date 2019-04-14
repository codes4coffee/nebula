package com.nebula.domain;

/**
 * Represents a user account in the website.
 */
public class Customer {
    private String username;
    private String password;
    private String name;
    private Location location;

    /**
     * Gets the username of this user.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of this user.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of this user in plain text.
     * @return the password in plain text
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of this user.
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the full name of this user.
     * @return the full name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of this user.
     * @param name the new full name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Locates the user.
     * @return the user's location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the location of the user
     * @param location the new location
     */
    public void setLocation(Location location) {
        this.location = location;
    }
}
