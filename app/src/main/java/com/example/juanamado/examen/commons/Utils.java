package com.example.juanamado.examen.commons;

public class Utils {

    public static String getJson(double latitud, double longitud) {

        String lat = String.valueOf(latitud);
        String lon = String.valueOf(longitud);

        String json = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lon+"&radius=1000&key=AIzaSyDAayaRu6gwrk4DBdOXyFlKYhDTcDDTB0k";

        return json;
    }
}
