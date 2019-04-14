package com.nebula.domain;

/**
 * Represents a login form model for authentication.
 */
public class Login {
    private String username;
    private String password;

    /**
     * Constructs a login form model.
     * @param username the username
     * @param password the password
     */
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of this login form model.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of this login form model.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of this login form model in plain text.
     * @return the password in plain text
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of this login form model.
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
