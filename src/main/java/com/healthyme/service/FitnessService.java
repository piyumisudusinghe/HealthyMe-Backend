package com.healthyme.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthyme.model.Activity;
import com.healthyme.model.ApiResponse;
import com.healthyme.model.BMIResult;
import com.healthyme.model.BurnedCalorie;
import com.healthyme.util.ExternalURLNamingUtil;
import com.healthyme.util.HttpUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class FitnessService implements IFitnessService
{
    @Override public Optional<ApiResponse<BMIResult>> getBMIValue( Double age, Double weight, Double height ) throws IOException, InterruptedException
    {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpUtil.createHttpGetRequest( ExternalURLNamingUtil.getBMIUrl( age.toString(), weight.toString(), height.toString() ) );
        HttpResponse<String> response = httpClient.send( httpRequest, HttpResponse.BodyHandlers.ofString() );

        ObjectMapper mapper = new ObjectMapper();
        ApiResponse<BMIResult> apiResponse = mapper.readValue( response.body(), ApiResponse.class );
        return Optional.ofNullable( apiResponse );
    }

    @Override public Optional<ApiResponse<Activity>> getActivityByIntensityLevel( Integer intensityLevel ) throws IOException, InterruptedException
    {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpUtil.createHttpGetRequest( ExternalURLNamingUtil.getActByIntensityLevelUrl( intensityLevel.toString() ) );
        HttpResponse<String> response = httpClient.send( httpRequest, HttpResponse.BodyHandlers.ofString() );

        ObjectMapper mapper = new ObjectMapper();
        ApiResponse<Activity> apiResponse = mapper.readValue( response.body(), ApiResponse.class );
        return Optional.ofNullable( apiResponse );
    }

    @Override public Optional<ApiResponse<BurnedCalorie>> getBurnedCalorieByActivity( Double minutes, Double weight, String activityId ) throws IOException, InterruptedException
    {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpUtil.createHttpGetRequest( ExternalURLNamingUtil.getBurnedCalorieUrl( activityId, minutes.toString(), weight.toString() ) );
        HttpResponse<String> response = httpClient.send( httpRequest, HttpResponse.BodyHandlers.ofString() );

        ObjectMapper mapper = new ObjectMapper();
        ApiResponse<BurnedCalorie> apiResponse = mapper.readValue( response.body(), ApiResponse.class );
        return Optional.ofNullable( apiResponse );
    }

    @Override public Optional<ApiResponse<List<Activity>>> getAllActivities() throws IOException, InterruptedException
    {
        int[] intensityLevels = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Activity> allActivities = new ArrayList<>();
        for( int intensityLevel : intensityLevels )
        {
            Optional<ApiResponse<Activity>> tempResponse = getActivityByIntensityLevel( intensityLevel );
            allActivities.addAll( (Collection<? extends Activity>) tempResponse.get().getData() );
        }
        ApiResponse<List<Activity>> apiResponse = new ApiResponse<>();
        if (!allActivities.isEmpty())
        {
            apiResponse.setRequest_result( "Successful" );
            apiResponse.setStatus_code( "200" );
            apiResponse.setData( allActivities );
        }
        return Optional.of( apiResponse );
    }
}
