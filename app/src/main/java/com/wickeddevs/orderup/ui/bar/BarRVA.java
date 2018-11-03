package com.wickeddevs.orderup.ui.bar;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wickeddevs.orderup.R;

public class BarRVA extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;

    public BarRVA(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.view_bar_order, parent, false);
            view.setBackgroundColor(Color.BLUE);
            return new BarOrderVH(view);
        }
        view = layoutInflater.inflate(R.layout.view_bar_drink, parent, false);
        view.setBackgroundColor(Color.GREEN);
        return new BarDrinkVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class BarOrderVH extends RecyclerView.ViewHolder {

        public BarOrderVH(View itemView) {
            super(itemView);
        }
    }

    public class BarDrinkVH extends RecyclerView.ViewHolder {

        public BarDrinkVH(View itemView) {
            super(itemView);
        }
    }


}
