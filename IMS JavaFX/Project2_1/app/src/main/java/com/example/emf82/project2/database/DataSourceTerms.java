package com.example.emf82.project2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.emf82.project2.model.TermsItem;

import java.util.ArrayList;
import java.util.List;

public class DataSourceTerms {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;
    private String[] allColumns = {termsTable.COLUMN_TERMS_ID, termsTable.COLUMN_TERMS_NAME,
            termsTable.COLUMN_TERMS_START, termsTable.COLUMN_TERMS_END};

    public DataSourceTerms(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public TermsItem createTerm() {
        TermsItem term = new TermsItem();
        term.setTermsTitle("new value");
        ContentValues values = term.toValues();
//        term.setTermsTitle("new term");
        mDatabase.insert(termsTable.TABLE_TERMS, null, values);
        return term;
    }

    public void deleteTerm(Integer termsId) {
        System.out.println("term deleted with id: " + termsId);

        mDatabase.delete(termsTable.TABLE_TERMS, termsTable.COLUMN_TERMS_ID + " = " + termsId, null);
        mDatabase.close();
    }

    public void saveTerm(TermsItem term) {
        System.out.println("term save with id: " + term.getTermsId());
        ContentValues contentValues = new ContentValues();
        contentValues.put(termsTable.COLUMN_TERMS_NAME,term.getTermsTitle());
//        contentValues.put(termsTable.COLUMN_TERMS_START,term.getTermsStart());
//        contentValues.put(termsTable.COLUMN_TERMS_END,term.getTermsEnd());
        mDatabase.update(termsTable.TABLE_TERMS, contentValues, termsTable.COLUMN_TERMS_ID + " = " + term.getTermsId(), null );
//        mDatabase.execSQL("UPDATE " + termsTable.TABLE_TERMS + " SET " +termsTable.COLUMN_TERMS_NAME + " = " + "'" +  term.getTermsTitle()
//                + "'" + ", "+  termsTable.COLUMN_TERMS_START + " = " + "'" + term.getTermsStart() + "'" + ", " + termsTable.COLUMN_TERMS_END +
//                " = " + "'" + term.getTermsEnd() + "'" + " WHERE"+ termsTable.COLUMN_TERMS_ID + " = " + term.getTermsId() + ";");
//        mDatabase.close();
    }

    public List<TermsItem> getAllTermsItem() {
        List<TermsItem> terms = new ArrayList<TermsItem>();
        Cursor cursor = mDatabase.query(termsTable.TABLE_TERMS, allColumns,
                null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            TermsItem term = cursorToTerm(cursor);
            terms.add(term);
            cursor.moveToNext();
        }
        cursor.close();
        return terms;
    }

    private TermsItem cursorToTerm(Cursor cursor) {
        TermsItem mTerm = new TermsItem();
        mTerm.setTermsId(cursor.getInt(0));
        mTerm.setTermsTitle(cursor.getString(1));
        mTerm.setTermsStart(cursor.getString(2));
        mTerm.setTermsEnd(cursor.getString(3));
        return mTerm;
    }

    public long getTermItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, termsTable.TABLE_TERMS);
    }

    public void seedDatabase(List<TermsItem> termsItemList) {
        long numTerms = getTermItemsCount();
        if (numTerms == 0) {
            for (TermsItem term : termsItemList) {
                try {
//                    createTerm(term);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<TermsItem> getAllTerms() {
        List<TermsItem> termsItems = new ArrayList<>();
        Cursor cursor = mDatabase.query(termsTable.TABLE_TERMS, termsTable.ALL_TERMS_COLUMNS, null, null, null, null, termsTable.COLUMN_TERMS_NAME);

        while (cursor.moveToNext()) {
            TermsItem term = new TermsItem();
            term.setTermsId(cursor.getInt(cursor.getColumnIndex(termsTable.COLUMN_TERMS_ID)));
            term.setTermsTitle(cursor.getString(cursor.getColumnIndex(termsTable.COLUMN_TERMS_NAME)));
            term.setTermsStart(cursor.getString(cursor.getColumnIndex(termsTable.COLUMN_TERMS_START)));
            term.setTermsEnd(cursor.getString(cursor.getColumnIndex(termsTable.COLUMN_TERMS_END)));
            termsItems.add(term);
        }
        cursor.close();
        return termsItems;
    }

    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, termsTable.TABLE_TERMS);
    }

}
