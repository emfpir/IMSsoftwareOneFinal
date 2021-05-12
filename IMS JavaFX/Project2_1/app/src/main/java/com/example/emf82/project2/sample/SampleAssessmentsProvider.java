package com.example.emf82.project2.sample;

import com.example.emf82.project2.model.AssessmentsItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleAssessmentsProvider {

    public static List<AssessmentsItem> assessmentsItemList;
    public static Map<String, AssessmentsItem> assessmentsItemMap;

    static {
        assessmentsItemList = new ArrayList<>();
        assessmentsItemMap = new HashMap<>();

        addAssessment(new AssessmentsItem(null, "quiz for 101", "objective", "121212","121213",null));
    }

    private static void addAssessment(AssessmentsItem item) {
        assessmentsItemList.add(item);
        assessmentsItemMap.put(item.getAssessmentsId(), item);
    }
}
