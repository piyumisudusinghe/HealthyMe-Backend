package com.healthyme.util;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpUtil
{
    public static final String RAPID_API_HOST_KEY = "x-rapidapi-host";
    public static final String RAPID_API_HOST_VALUE = "fitness-calculator.p.rapidapi.com";
    public static final String RAPID_API_KEY = "x-rapidapi-key";
    public static final String RAPID_API_KEY_VALUE = "500bb7bf09msh652cb4e9dd447e7p1e96dajsn6a1e9c629b5c";

    public static HttpRequest createHttpGetRequest( String url )
    {
        return HttpRequest.newBuilder()
                .GET()
                .headers( RAPID_API_HOST_KEY, RAPID_API_HOST_VALUE, RAPID_API_KEY, RAPID_API_KEY_VALUE )
                .uri( URI.create( url ) )
                .build();
    }
}
