package domain.login;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


public class Location {
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
    }
}
