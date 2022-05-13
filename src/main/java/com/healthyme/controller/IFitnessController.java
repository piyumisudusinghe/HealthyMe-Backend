package com.healthyme.controller;

import com.healthyme.model.Activity;
import com.healthyme.model.BMIResult;
import com.healthyme.model.BurnedCalorie;
import com.healthyme.util.EndPointNamingUtil;
import com.healthyme.util.URLParameterNamingUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Tag(description = "API to get Fitness details", name = "Fitness Service")
@RequestMapping(EndPointNamingUtil.FITNESS)
public interface IFitnessController
{
    @Operation(summary = "Get BMI Value", description = "Returning BMI Results", responses = {@ApiResponse(responseCode = "200", description = "BMI")})
    @GetMapping( value = EndPointNamingUtil.BMI, produces = "application/json")
    public ResponseEntity<com.healthyme.model.ApiResponse<BMIResult>> getBMIValue(
            @Parameter( description = "Age", hidden = false, required = true ) @RequestParam( value = URLParameterNamingUtil.AGE ) Double age,
            @Parameter( description = "Weight", hidden = false, required = true ) @RequestParam( value = URLParameterNamingUtil.WEIGHT ) Double weight,
            @Parameter( description = "Height", hidden = false, required = true ) @RequestParam( value = URLParameterNamingUtil.HEIGHT ) Double height,
            HttpServletRequest request
    ) throws IOException, InterruptedException;

    @Operation(summary = "Get activity details", description = "Returning activity Results", responses = {@ApiResponse(responseCode = "200", description = "Activity")})
    @GetMapping( value = EndPointNamingUtil.ACTIVITY, produces = "application/json")
    public ResponseEntity<com.healthyme.model.ApiResponse<Activity>> getActivityByIntensityLevel(
            @Parameter( description = "Intensity Level", hidden = false, required = true ) @RequestParam( value = URLParameterNamingUtil.INTENSITY_LEVEL ) Integer intensityLevel,
            HttpServletRequest request
    ) throws IOException, InterruptedException;

    @Operation(summary = "Get Burned Calorie By Activity", description = "Returning Burned Calorie amount", responses = {@ApiResponse(responseCode = "200", description = "Burnt Calorie")})
    @GetMapping( value = EndPointNamingUtil.BURNED_CALORIE, produces = "application/json")
    public ResponseEntity<com.healthyme.model.ApiResponse<BurnedCalorie>> getBurnedCalorieByActivity(
            @Parameter( description = "Activity minutes", hidden = false, required = true ) @RequestParam( value = URLParameterNamingUtil.ACTIVITY_MINUTES ) Double minutes,
            @Parameter( description = "Weight", hidden = false, required = true ) @RequestParam( value = URLParameterNamingUtil.WEIGHT ) Double weight,
            @Parameter( description = "Activity Id", hidden = false, required = true ) @RequestParam( value = URLParameterNamingUtil.ACTIVITY_ID ) String activityId,
            HttpServletRequest request
    ) throws IOException, InterruptedException;

    @Operation(summary = "Get all activity details", description = "Returning all activity Results", responses = {@ApiResponse(responseCode = "200", description = "All Activity")})
    @GetMapping(value = EndPointNamingUtil.ALL_ACTIVITY, produces = "application/json")
    public ResponseEntity<List<com.healthyme.model.ApiResponse<Activity>>> getAllActivities(
            HttpServletRequest request
    ) throws IOException, InterruptedException;
}
