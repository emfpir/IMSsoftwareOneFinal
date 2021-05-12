package com.example.emf82.project2;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emf82.project2.database.DataSourceTerms;
import com.example.emf82.project2.model.TermsItem;

public class TermsDetail extends AppCompatActivity {

    private EditText termsTitle;
//    private EditText termsStart, termsEnd;

    DataSourceTerms dataSourceTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_detail);

        dataSourceTerms = new DataSourceTerms(this);
        dataSourceTerms.open();

        TermsItem item = getIntent().getExtras().getParcelable(TermItemAdapter.TERM_KEY);

            termsTitle = findViewById(R.id.termsTitle);
//            termsStart = findViewById(R.id.termsStart);
//            termsEnd = findViewById(R.id.termsEnd);

            termsTitle.setText("new term");
//            termsTitle.setText(item.getTermsTitle());
//            termsStart.setText(item.getTermsStart());
//            termsEnd.setText(item.getTermsEnd());

//        final Button buttonSave = findViewById(R.id.termsSaveButton);
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
////                TermsItem item = getIntent().getExtras().getParcelable(TermItemAdapter.TERM_KEY);
////                String userInput = termsTitle.toString();
////                item.setTermsTitle(userInput);
////                userInput = termsStart.toString();
////                item.setTermsStart(userInput);
////                userInput = termsEnd.toString();
////                item.setTermsEnd(userInput);
////                dataSourceTerms.saveTerm(item);
////                String displayed = termsTitle.getText().toString();
////                System.out.println(displayed);
//
//
////                Intent termsIntent = new Intent(TermsDetail.this, Terms.class);
////                startActivity(termsIntent);
//            }
//        });

        final Button buttonDelete = findViewById(R.id.termsDeleteButtom);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TermsItem item = getIntent().getExtras().getParcelable(TermItemAdapter.TERM_KEY);

                dataSourceTerms.deleteTerm(item.getTermsId());
                Intent termsIntent = new Intent(TermsDetail.this, Terms.class);
                startActivity(termsIntent);
            }
        });


    }

    public void showToast(String theToast) {
        Toast.makeText(getApplicationContext(), theToast, Toast.LENGTH_LONG).show();
    }

    public void showSaveToast(View view){
        showToast(termsTitle.getText().toString());
        TermsItem item = getIntent().getExtras().getParcelable(TermItemAdapter.TERM_KEY);
        item.setTermsTitle(termsTitle.getText().toString());
        dataSourceTerms.saveTerm(item);
        Intent termsIntent = new Intent(TermsDetail.this, Terms.class);
        startActivity(termsIntent);
    }

}
