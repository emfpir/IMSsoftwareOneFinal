package com.example.emf82.project2;

import android.support.v7.app.AppCompatActivity;

import com.example.emf82.project2.model.CoursesItem;
import com.example.emf82.project2.sample.SampleCoursesProvider;

import java.util.List;

public class Courses extends AppCompatActivity {

    List<CoursesItem> coursesItemList = SampleCoursesProvider.coursesItemList;
}
