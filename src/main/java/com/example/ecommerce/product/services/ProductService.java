package com.example.ecommerce.landing.services;

import com.example.ecommerce.landing.models.LandingResponse;
import org.springframework.stereotype.Service;

@Service
public class LandingService {

    public LandingResponse getLanding() {
        return new LandingResponse("test");
    }
}
