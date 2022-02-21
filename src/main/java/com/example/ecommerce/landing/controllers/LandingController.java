package com.example.ecommerce.landing.controllers;

import com.example.ecommerce.landing.models.LandingResponse;
import com.example.ecommerce.landing.services.LandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingController {

    @Autowired
    LandingService landingService;

    @GetMapping("/v1/landing")
    public LandingResponse getLanding() {
        return landingService.getLanding();
    }
}
