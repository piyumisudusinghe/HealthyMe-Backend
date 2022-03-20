package com.healthyme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/check")
    public String healthCheck(){
        return "sample application";
    }
}
