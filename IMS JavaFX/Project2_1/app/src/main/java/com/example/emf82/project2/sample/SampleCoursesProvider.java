package com.example.emf82.project2.sample;

import com.example.emf82.project2.model.CoursesItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleCoursesProvider {
    public static List<CoursesItem> coursesItemList;
    public static Map<String, CoursesItem> coursesItemMap;

    static {
        coursesItemList = new ArrayList<>();
        coursesItemMap = new HashMap<>();

        addCourse(new CoursesItem(null, "101", "basic", "121212", "121213", null, null, null));
    }

    private static void addCourse(CoursesItem item) {
        coursesItemList.add(item);
        coursesItemMap.put(item.getCoursesId(), item);
    }

}
