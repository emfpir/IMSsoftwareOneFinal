package com.example.emf82.project2.database;

public class coursesTable {
    public static final String TABLE_COURSES = "courses";
    public static final String COLUMN_COURSES_ID = "coursesId";
    public static final String COLUMN_COURSES_CODE = "coursesCode";
    public static final String COLUMN_COURSES_NAME = "coursesName";
    public static final String COLUMN_COURSES_START = "coursesStart";
    public static final String COLUMN_COURSES_END = "coursesEnd";
    public static final String COLUMN_COURSES_STATUS = "coursesStatus";
    public static final String COLUMN_COURSES_NOTES = "coursesNotes";
    public static final String COLUMN_COURSES_TERM_ID = "coursesTermId";

    public static final String[] ALL_COURSES_COLUMNS =
            {COLUMN_COURSES_ID, COLUMN_COURSES_CODE, COLUMN_COURSES_NAME, COLUMN_COURSES_START, COLUMN_COURSES_END,
            COLUMN_COURSES_STATUS, COLUMN_COURSES_NOTES, COLUMN_COURSES_TERM_ID};

    public static final String SQL_CREATE_COURSES =
            "CREATE TABLE " + TABLE_COURSES + "(" +
                COLUMN_COURSES_ID + " TEXT PRIMARY KEY," +
                COLUMN_COURSES_CODE + " TEXT," +
                COLUMN_COURSES_NAME + " TEXT," +
                COLUMN_COURSES_START + " TEXT," +
                COLUMN_COURSES_END + " TEXT," +
                COLUMN_COURSES_STATUS + " TEXT," +
                COLUMN_COURSES_NOTES + " TEXT," +
                COLUMN_COURSES_TERM_ID + " TEXT" + ");";

    public static final String SQL_COURSES_DELETE = "DROP TABLE" + TABLE_COURSES;

}
