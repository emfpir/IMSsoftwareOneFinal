package com.example.emf82.project2.database;

public class AssessmentsTable {
    public static final String TABLE_ASSESSMENTS = "assessments";
    public static final String COLUMN_ASSESSMENTS_ID = "assessments";
    public static final String COLUMN_ASSESSMENTS_NAME = "assessments";
    public static final String COLUMN_ASSESSMENTS_TYPE = "assessments";
    public static final String COLUMN_ASSESSMENTS_START = "assessments";
    public static final String COLUMN_ASSESSMENTS_END = "assessments";
    public static final String COLUMN_ASSESSMENTS_COURSES_ID = "assessments";

    public static final String[] ALL_ASSESSMENTS_COLUMNS =
            {COLUMN_ASSESSMENTS_ID, COLUMN_ASSESSMENTS_NAME, COLUMN_ASSESSMENTS_TYPE,
            COLUMN_ASSESSMENTS_START, COLUMN_ASSESSMENTS_END, COLUMN_ASSESSMENTS_COURSES_ID};

    public static final String SQL_ASSESSMENTS_DELETE = "DROP TABLE" + TABLE_ASSESSMENTS;
}
