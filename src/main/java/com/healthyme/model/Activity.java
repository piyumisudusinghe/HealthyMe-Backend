package com.healthyme.model;

public class Activity
{
    private String id;
    private String activity;
    private double metValue;
    private String description;
    private int intensityLevel;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getActivity()
    {
        return activity;
    }

    public void setActivity( String activity )
    {
        this.activity = activity;
    }

    public double getMetValue()
    {
        return metValue;
    }

    public void setMetValue( double metValue )
    {
        this.metValue = metValue;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public int getIntensityLevel()
    {
        return intensityLevel;
    }

    public void setIntensityLevel( int intensityLevel )
    {
        this.intensityLevel = intensityLevel;
    }
}
