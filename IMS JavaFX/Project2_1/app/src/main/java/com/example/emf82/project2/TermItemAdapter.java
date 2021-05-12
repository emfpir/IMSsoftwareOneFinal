package com.example.emf82.project2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.emf82.project2.model.TermsItem;

import java.util.List;

public class TermItemAdapter extends RecyclerView.Adapter<TermItemAdapter.ViewHolder> {

    public static final String TERM_ID_KEY = "term_id_key";
    public static final String TERM_KEY = "term_key";
    private List<TermsItem> mItems;
    private Context mContext;

    public TermItemAdapter(Context context, List<TermsItem> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public TermItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemview = inflater.inflate(R.layout.list_terms, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TermItemAdapter.ViewHolder holder, int position) {
        final TermsItem item = mItems.get(position);

        holder.termTitle.setText(item.getTermsTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "You selected " + item.getTermsTitle(), Toast.LENGTH_SHORT).show();
//                String itemId = item.getTermsId();
                Intent intent = new Intent(mContext, TermsDetail.class);
                intent.putExtra(TERM_KEY, item);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView termTitle;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            termTitle = itemView.findViewById(R.id.termsViewTitle);
            mView = itemView;
        }
    }
}
