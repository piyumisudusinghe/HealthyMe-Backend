package com.healthyme.model;

public class BMIResult
{
    private String health;
    private String healthy_bmi_range;
    private double bmi;

    public String getHealth()
    {
        return health;
    }

    public void setHealth( String health )
    {
        this.health = health;
    }

    public double getBmi()
    {
        return bmi;
    }

    public void setBmi( double bmi )
    {
        this.bmi = bmi;
    }

    public String getHealthy_bmi_range()
    {
        return healthy_bmi_range;
    }

    public void setHealthy_bmi_range( String healthy_bmi_range )
    {
        this.healthy_bmi_range = healthy_bmi_range;
    }
}
