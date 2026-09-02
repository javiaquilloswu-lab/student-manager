package com.example.studentmanager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentActivity extends AppCompatActivity {
    private RecyclerView rv;
    private EditText name, email, course;
    private ApiService api;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_student);

        rv = findViewById(R.id.recyclerStudents);
        rv.setLayoutManager(new LinearLayoutManager(this));

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        course = findViewById(R.id.etCourse);

        api = RetrofitClient.getClient().create(com.example.studentapp.ApiResponse.class);

        findViewById(R.id.btnSave).setOnClickListener(v -> saveStudent());

        loadStudents();
    }

    private void loadStudents() {
        api.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> c, Response<List<Student>> r) {
                if (r.isSuccessful() && r.body() != null) {
                    rv.setAdapter(new StudentAdapter(r.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Student>> c, Throwable t) {
                Toast.makeText(StudentActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveStudent() {
        String n = name.getText().toString().trim();
        String e = email.getText().toString().trim();
        String c = course.getText().toString().trim();

        if (n.isEmpty() || e.isEmpty() || c.isEmpty()) {
            Toast.makeText(this, "Complete all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        api.addStudent(new Student(n, e, c)).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> r) {
                if (r.isSuccessful() && r.body() != null) {
                    Toast.makeText(StudentActivity.this, r.body().getMessage(), Toast.LENGTH_SHORT).show();
                    name.setText("");
                    email.setText("");
                    course.setText("");
                    loadStudents();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(StudentActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}