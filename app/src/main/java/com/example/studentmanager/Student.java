package com.example.studentmanager;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;

    // Constructor for POST request (without ID)
    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Constructor for GET response (with ID)
    public Student(int id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
}