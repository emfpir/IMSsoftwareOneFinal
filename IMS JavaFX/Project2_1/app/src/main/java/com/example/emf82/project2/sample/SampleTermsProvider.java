package com.example.emf82.project2.sample;

import com.example.emf82.project2.model.TermsItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleTermsProvider {
    public static List<TermsItem> termsItemList;
    public static Map<String, TermsItem> termsItemMap;

    static {
        termsItemList = new ArrayList<>();
        termsItemMap = new HashMap<>();

        addTerm(new TermsItem(1, "1 term", "121212","121213"));
        addTerm(new TermsItem(2, "2 term", "121212","121213"));
        addTerm(new TermsItem(3, "3 term", "121212","121213"));
        addTerm(new TermsItem(4, "4 term", "121212","121213"));
        addTerm(new TermsItem(5, "5 term", "121212","121213"));
        addTerm(new TermsItem(6, "6 term", "121212","121213"));
        addTerm(new TermsItem(7, "7 term", "121212","121213"));
        addTerm(new TermsItem(8, "8 term", "121212","121213"));
        addTerm(new TermsItem(9, "9 term", "121212","121213"));
    }

    private static void addTerm(TermsItem item) {
        termsItemList.add(item);
        termsItemMap.put(item.getTermsId().toString(), item);
    }
}
