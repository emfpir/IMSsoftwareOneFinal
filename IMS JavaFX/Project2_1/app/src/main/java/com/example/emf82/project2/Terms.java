package com.example.emf82.project2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;

import com.example.emf82.project2.database.DataSourceTerms;
import com.example.emf82.project2.model.TermsItem;
import com.example.emf82.project2.sample.SampleTermsProvider;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Terms extends AppCompatActivity {

    private DataSourceTerms dataSourceTerms;
//    List<TermsItem> termsItemList = SampleTermsProvider.termsItemList;
//    List<TermsItem> termsItemList = dataSourceTerms.getAllTermsItem();
//    List<String> termsNames = new ArrayList<>();
    private CursorAdapter cursorAdapter;
    private TermsItem termsItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

//        Collections.sort(termsItemList, new Comparator<TermsItem>() {
//            @Override
//            public int compare(TermsItem o1, TermsItem o2) {
//                return o1.getTermsTitle().compareTo(o2.getTermsTitle());
//            }
//        });



        dataSourceTerms = new DataSourceTerms(this);
        dataSourceTerms.open();
        List<TermsItem> termsItemList = dataSourceTerms.getAllTermsItem();
        TermItemAdapter adapter = new TermItemAdapter(this, termsItemList);


        long numItems = dataSourceTerms.getDataItemsCount();
        if (numItems == 0) {
            for (TermsItem term : termsItemList) {
                dataSourceTerms.createTerm();
            }
        }

        RecyclerView recyclerView = findViewById(R.id.termsList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.terms_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent intent = new Intent(this,Home.class);
                startActivity(intent);
                break;
            case R.id.action_terms:
                Intent termsIntent = new Intent(this, Terms.class);
                startActivity(termsIntent);
                break;
            case R.id.action_terms_detail:
//                dataSourceTerms.createTerm();
//                List<TermsItem> termsItemList = dataSourceTerms.getAllTermsItem();
//                termsItemList = findViewById(R.id.termsList);
//
//
//
//                TermItemAdapter adapter = new TermItemAdapter(this, termsItemList);
                Intent termsDetail = new Intent (this, TermsDetail.class);
                startActivity(termsDetail);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    public void openEditorForNewTerm(View view) {
//        Intent intent = new Intent(this, TermsDetail.class);
//        startActivityForResult(intent, TERM_EDITOR_REQUEST_CODE);
//    }
}
