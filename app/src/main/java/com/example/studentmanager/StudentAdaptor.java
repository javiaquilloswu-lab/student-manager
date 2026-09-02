package com.example.studentmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdaptor extends RecyclerView.Adapter<StudentAdaptor.VH> {
    private final List<Student> list;

    public StudentAdaptor(List<Student> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int v) {
        View view = LayoutInflater.from(p.getContext()).inflate(R.layout.item_student, p, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int i) {
        Student s = list.get(i);
        h.name.setText(s.getName());
        h.email.setText(s.getEmail());
        h.course.setText(s.getCourse());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView name, email, course;
        VH(View v) {
            super(v);
            name = v.findViewById(R.id.tvName);
            email = v.findViewById(R.id.tvEmail);
            course = v.findViewById(R.id.tvCourse);
        }
    }
}