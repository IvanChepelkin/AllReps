package com.example.user.allreps;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RecViewHolder> {

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rep_layout, viewGroup, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder recViewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    class RecViewHolder extends RecyclerView.ViewHolder {
        private TextView repName;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            repName = itemView.findViewById(R.id.rep_name);
        }
    }
}
