package com.nebula.domain;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.*;

/**
 * Represents an exact location on earth.
 */
public class Location {

    private String city;

    /**
     * Constructs an undefined location.
     */
    public Location() {
        city = "";
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public Location(String ip) throws IOException{
        URL url = new URL("http://api.ipstack.com/" + ip + "?access_key=3f580d4b0f64392760e2053a7a6b7aa8");
        URLConnection connection = (URLConnection) url.openConnection();
        connection.connect();
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONObject json = new JSONObject(jsonText);
        try {
            this.city = (String) json.get("city");
        } catch (java.lang.ClassCastException ex) {
            this.city = "Dallas";
        }
    }

    /**
     * Gets the city of this location.
     * @return the city
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
