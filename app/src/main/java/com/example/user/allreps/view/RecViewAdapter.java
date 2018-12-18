package com.example.user.allreps.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.user.allreps.R;
import com.example.user.allreps.model.RepsModel;

import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RecViewHolder> {
    private List<RepsModel> repsModels;
    public RecViewAdapter(List<RepsModel > repsModels) {
        this.repsModels = repsModels;
    }


    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rep_layout, viewGroup, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder recViewHolder, int i) {
       RepsModel repsModel = repsModels.get(i);
       recViewHolder.repName.setText(repsModel.getName().toString());

    }


    @Override
    public int getItemCount() {
        return repsModels.size();
    }

    class RecViewHolder extends RecyclerView.ViewHolder {
        private TextView repName;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            repName = itemView.findViewById(R.id.rep_name);
        }
    }
}
