package com.example.emf82.project2.database;

public class termsTable {
    public static final String TABLE_TERMS = "terms";
    public static final String COLUMN_TERMS_ID = "termsId";
    public static final String COLUMN_TERMS_NAME = "termsName";
    public static final String COLUMN_TERMS_START = "termsStart";
    public static final String COLUMN_TERMS_END = "termsEnd";

    public static final String[] ALL_TERMS_COLUMNS =
            {COLUMN_TERMS_ID, COLUMN_TERMS_NAME, COLUMN_TERMS_START, COLUMN_TERMS_END};

    public static final String SQL_CREATE_TERMS =
            "CREATE TABLE " + TABLE_TERMS + "(" +
                    COLUMN_TERMS_ID + " integer PRIMARY KEY autoincrement," +
                    COLUMN_TERMS_NAME + " TEXT," +
                    COLUMN_TERMS_START + " TEXT," +
                    COLUMN_TERMS_END + " TEXT" + ");";

    public static final String SQL_TERMS_DELETE = "DROP TABLE" + TABLE_TERMS;
}
