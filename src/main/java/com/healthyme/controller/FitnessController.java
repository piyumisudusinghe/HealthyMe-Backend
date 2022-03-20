package com.healthyme.controller;

import com.healthyme.model.ApiResponse;
import com.healthyme.model.BMIResult;
import com.healthyme.service.IFitnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class FitnessController implements IFitnessController
{
    @Autowired
    IFitnessService fitnessService;

    @Override public ResponseEntity<ApiResponse<BMIResult>> getBMIValue( Double age, Double weight, Double height, HttpServletRequest request ) throws IOException, InterruptedException
    {
        ApiResponse<BMIResult> apiResponse = fitnessService.getBMIValue( age, weight, height ).get();
        return new ResponseEntity( apiResponse, HttpStatus.OK );
    }
}
