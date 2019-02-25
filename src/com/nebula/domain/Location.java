package com.nebula.domain;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


public class Location {

    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String postalCode;

    /**
     * Testing Data
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

    public Location() {
        latitude = "";
        longitude = "";
        country = "";
        city = "";
        postalCode = "";
    }

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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
