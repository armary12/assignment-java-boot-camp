package com.example.ecommerce.common.model;

public class ResponseStatus {
    private int code;
    private String header;
    private String description;

    public ResponseStatus(int code, String header, String description) {
        this.code = code;
        this.header = header;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
