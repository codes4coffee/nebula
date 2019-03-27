package com.nebula.domain;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Represents an exact location on earth.
 */
public class Location {

    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String postalCode;

    /**
     * Integration test between GeoLite2's API and the Location class.
     * @param args unused
     * @throws IOException this must not throw
     * @throws GeoIp2Exception this must not throw
     */
    public static void main(String[] args) throws IOException, GeoIp2Exception {
        File database = new File("GeoLite2-City.mmdb");
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();

        CityResponse response = dbReader.city(InetAddress.getByName("64.189.202.198"));
        //CityResponse response = dbReader.city(InetAddress.getByName);

        System.out.println(response.getCountry().getName());
        System.out.println(response.getCity().getName());
        System.out.println(response.getPostal().getCode());
        System.out.println(response.getLeastSpecificSubdivision().getName());
        System.out.println(response.getLocation().getLatitude().toString());
        System.out.println(response.getLocation().getLongitude().toString());
        System.out.println(response.getLocation().getAccuracyRadius().toString());
    }

    /**
     * Constructs an undefined location.
     */
    public Location() {
        latitude = "";
        longitude = "";
        country = "";
        city = "";
        postalCode = "";
    }

    /**
     * Constructs a location based on IP address.
     * @param ip the IP address
     * @throws IOException this must not throw
     * @throws GeoIp2Exception this must not throw
     */
    public Location(String ip) throws IOException, GeoIp2Exception{
        File database = new File("GeoLite2-City.mmdb");
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();

        CityResponse response = dbReader.city(InetAddress.getByName(ip));

        latitude = response.getLocation().getLatitude().toString();
        longitude = response.getLocation().getLongitude().toString();
        country = response.getCountry().getName();
        city = response.getCity().getName();
        postalCode = response.getPostal().getCode();
    }

    /**
     * Gets the latitude of this location.
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of this location.
     * @param latitude the new latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the longitude of this location.
     * @return the new longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of this location.
     * @param longitude the new longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the country of this location.
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of this location
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the city of this location.
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of this location
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the postal code of this location.
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of this location.
     * @param postalCode the new postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
