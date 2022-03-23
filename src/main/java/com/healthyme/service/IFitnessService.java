package com.healthyme.service;

import com.healthyme.model.Activity;
import com.healthyme.model.ApiResponse;
import com.healthyme.model.BMIResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface IFitnessService
{
    Optional<ApiResponse<BMIResult>> getBMIValue( Double age, Double weight, Double height ) throws IOException, InterruptedException;

    Optional<ApiResponse<Activity>> getActivityByIntensityLevel( Integer intensityLevel ) throws IOException, InterruptedException;
}
