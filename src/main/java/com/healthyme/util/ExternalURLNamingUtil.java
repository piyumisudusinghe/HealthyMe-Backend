package com.healthyme.util;

public class ExternalURLNamingUtil
{
    public static final String BMI_URL = "https://fitness-calculator.p.rapidapi.com/bmi";
    public static final String ACTIVITY_BY_INTENSITY_URL = "https://fitness-calculator.p.rapidapi.com/activities";
    public static final String BURNED_CALORIE_URL = "https://fitness-calculator.p.rapidapi.com/burnedcalorie";
    public static final String PARAMETER_START = "?";
    public static final String AGE = "age";
    public static final String WEIGHT = "weight";
    public static final String HEIGHT = "height";
    public static final String EQUAL = "=";
    public static final String SEPARATOR = "&";
    public static final String INTENSITY_LEVEL = "intensitylevel";
    public static final String ACTIVITY_ID = "activityid";
    public static final String ACTIVITY_MINUTES = "activitymin";

    public static String getBMIUrl( String age, String weight, String height )
    {
        return BMI_URL + PARAMETER_START + AGE + EQUAL + age + SEPARATOR + WEIGHT + EQUAL + weight + SEPARATOR + HEIGHT + EQUAL + height;
    }

    public static String getActByIntensityLevelUrl( String intensityLevel )
    {
        return ACTIVITY_BY_INTENSITY_URL + PARAMETER_START + INTENSITY_LEVEL + EQUAL + intensityLevel;
    }

    public static String getBurnedCalorieUrl( String activityId, String activityMin,String weight )
    {
        return BURNED_CALORIE_URL + PARAMETER_START + ACTIVITY_ID + EQUAL + activityId + SEPARATOR + ACTIVITY_MINUTES + EQUAL + activityMin + SEPARATOR + WEIGHT + EQUAL + weight;
    }
}
