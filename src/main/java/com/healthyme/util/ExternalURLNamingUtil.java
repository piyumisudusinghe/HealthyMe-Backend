package com.healthyme.util;

public class ExternalURLNamingUtil
{
    public static final String BMI_URL = "https://fitness-calculator.p.rapidapi.com/bmi";
    public static final String PARAMETER_START = "?";
    public static final String AGE = "age";
    public static final String WEIGHT = "weight";
    public static final String HEIGHT = "height";
    public static final String EQUAL = "=";
    public static final String SEPARATOR = "&";

    public static String constructBMIUrl( String age, String weight, String height )
    {

        return BMI_URL +
                PARAMETER_START +
                AGE +
                EQUAL +
                age +
                SEPARATOR +
                WEIGHT +
                EQUAL +
                weight +
                SEPARATOR +
                HEIGHT +
                EQUAL +
                height;
    }
}