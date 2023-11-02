package com.example.weather2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class weatherAPI {
    private static final String API_KEY = "dd82843dd09c8ee480a0ab33f1c6da19";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    //https://api.openweathermap.org/data/2.5/weather?id=Busan&appid=dd82843dd09c8ee480a0ab33f1c6da19

    public static String getWeather(String city) throws Exception {
        String url = String.format("%s?q=%s&appid=%s&units=metric", BASE_URL, city, API_KEY);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        System.out.println("API 응답: " + response.toString());


        return response.toString();
    }
}