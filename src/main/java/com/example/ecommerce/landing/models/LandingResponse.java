package com.example.ecommerce.landing.models;

public class LandingResponse {
    private String message;

    public LandingResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
