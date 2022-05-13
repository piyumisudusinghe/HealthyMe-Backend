package com.healthyme.service;

import com.healthyme.model.Activity;
import com.healthyme.model.ApiResponse;
import com.healthyme.model.BMIResult;
import com.healthyme.model.BurnedCalorie;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface IFitnessService
{
    Optional<ApiResponse<BMIResult>> getBMIValue( Double age, Double weight, Double height ) throws IOException, InterruptedException;

    Optional<ApiResponse<Activity>> getActivityByIntensityLevel( Integer intensityLevel ) throws IOException, InterruptedException;

    Optional<ApiResponse<BurnedCalorie>> getBurnedCalorieByActivity( Double minutes, Double weight, String activityId ) throws IOException, InterruptedException;

    Optional<ApiResponse<List<Activity>>> getAllActivities( ) throws IOException, InterruptedException;
}
