package com.healthyme.service;

import com.healthyme.model.ApiResponse;
import com.healthyme.model.BMIResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public interface IFitnessService
{
    Optional<ApiResponse<BMIResult>> getBMIValue( Double age, Double weight, Double height ) throws IOException, InterruptedException;
}
