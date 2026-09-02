package com.example.studentmanager;

public class ApiResponse {
    private boolean success;
    private String message;

    // Default no-arg constructor required by Gson
    public ApiResponse() {}

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}