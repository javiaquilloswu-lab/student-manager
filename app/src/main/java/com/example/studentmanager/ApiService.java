package com.example.studentmanager;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("get_student.php")
    Call<List<Student>> getStudents();

    @POST("add_student.php")
    Call<ApiResponse> addStudent(@Body Student student);
}