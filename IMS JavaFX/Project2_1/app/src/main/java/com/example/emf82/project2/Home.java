package com.example.emf82.project2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.emf82.project2.database.DBHelper;
import com.example.emf82.project2.database.DataSourceTerms;
import com.example.emf82.project2.model.TermsItem;
import com.example.emf82.project2.sample.SampleTermsProvider;

import java.util.List;

public class Home extends AppCompatActivity {

    List<TermsItem> termsItemList = SampleTermsProvider.termsItemList;
    DataSourceTerms mDataSourceTerms;
//    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        SQLiteOpenHelper dbHelper = new DBHelper(this);
//        database = dbHelper.getWritableDatabase();


        mDataSourceTerms = new DataSourceTerms(this);
        mDataSourceTerms.open();
        Toast.makeText(this, "db created", Toast.LENGTH_SHORT).show();
        mDataSourceTerms.seedDatabase(termsItemList);

//        List<TermsItem> listFromDB = mDataSourceTerms.getAllTerms();

        TermItemAdapter adapter = new TermItemAdapter(this, termsItemList);

        final Button button = findViewById(R.id.terms);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent termsIntent = new Intent(Home.this, Terms.class);
                startActivity(termsIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSourceTerms.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSourceTerms.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
        }
        return super.onOptionsItemSelected(item);
    }

}
