package com.example.emf82.project2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.emf82.project2.model.TermsItem;

import java.util.List;

public class TermItemAdapterListView extends ArrayAdapter<TermsItem> {

    List<TermsItem> mTermItems;
    LayoutInflater mInflater;


    public TermItemAdapterListView(@NonNull Context context, @NonNull List<TermsItem> objects) {
        super(context, R.layout.list_terms, objects);

        mTermItems = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_terms, parent, false);
        }

        TextView titleName = convertView.findViewById(R.id.termsViewTitle);

        TermsItem item = mTermItems.get(position);

        titleName.setText(item.getTermsTitle());

        return convertView;
    }
}
