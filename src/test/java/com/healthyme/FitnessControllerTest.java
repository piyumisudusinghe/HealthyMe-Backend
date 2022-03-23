package com.healthyme;

import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.services.lambda.runtime.Context;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.fail;

public class FitnessControllerTest
{
    private static BaseSpringStreamHandler handler;
    private static Context lambdaContext;

    @BeforeAll
    public static void setup()
    {
        lambdaContext = new MockLambdaContext();
        handler = new BaseSpringStreamHandler();
    }

    private void handle( InputStream is, ByteArrayOutputStream os )
    {
        try
        {
            handler.handleRequest( is, os, lambdaContext );
            System.out.println( os.toString() );
        }
        catch( IOException e )
        {
            e.printStackTrace();
            fail( e.getMessage() );
        }
    }

    @Disabled
    @Test
    public void testBMI()
    {
        try
        {
            InputStream inputStream = new AwsProxyRequestBuilder( "/fitness/bmi", HttpMethod.GET )
                    .header( HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON )
                    .header( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON )
                    .queryString( "age", "25" )
                    .queryString( "weight", "60" )
                    .queryString( "height", "150" )
                    .buildStream();
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            handle( inputStream, responseStream );
            System.out.println( responseStream.toString() );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    @Disabled
    @Test
    public void testActivityByIntensityLevel()
    {
        try
        {
            InputStream inputStream = new AwsProxyRequestBuilder( "/fitness/activities", HttpMethod.GET )
                    .header( HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON )
                    .header( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON )
                    .queryString( "intensityLevel", "1" )
                    .buildStream();
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            handle( inputStream, responseStream );
            System.out.println( responseStream.toString() );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    @Disabled
    @Test
    public void testBurnedCalorie()
    {
        try
        {
            InputStream inputStream = new AwsProxyRequestBuilder( "/fitness/burnedcalorie", HttpMethod.GET )
                    .header( HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON )
                    .header( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON )
                    .queryString( "activityId", "bi_1" )
                    .queryString( "weight", "75" )
                    .queryString( "activityMin", "25" )
                    .buildStream();
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            handle( inputStream, responseStream );
            System.out.println( responseStream.toString() );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

}


