package com.wickeddevs.orderup.ui.waiter.tables;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wickeddevs.orderup.R;
import com.wickeddevs.orderup.data.Table;

import java.util.ArrayList;

public class TablesRVA extends RecyclerView.Adapter<TablesRVA.TableVH> {

    private Context context;
    private ArrayList<Table> tables;
    private LayoutInflater layoutInflater;

    public TablesRVA(Context context, ArrayList<Table> tables) {
        this.context = context;
        this.tables = tables;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public TableVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.view_table, parent, false);
        return new TableVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TableVH holder, int position) {
        Table table = tables.get(position);
        holder.tvTable.setText("Table " + table.tableNumber);
        setIvTint(holder.ivDrinks, table.drinkStatus);
        setIvTint(holder.ivAppetizers, table.appetizerStatus);
        setIvTint(holder.ivFood, table.foodStatus);
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public class TableVH extends RecyclerView.ViewHolder {
        TextView tvTable;
        ImageView ivDrinks;
        ImageView ivAppetizers;
        ImageView ivFood;

        public TableVH(View itemView) {
            super(itemView);
            tvTable = itemView.findViewById(R.id.tvTable);
            ivDrinks = itemView.findViewById(R.id.ivDrinks);
            ivAppetizers = itemView.findViewById(R.id.ivAppetizers);
            ivFood = itemView.findViewById(R.id.ivFood);
        }
    }

    private void setIvTint(ImageView iv, int status) {
        switch (status) {
            case 0:
                iv.setColorFilter(ContextCompat.getColor(context, R.color.colorNeedOrder));
                break;
            case 1:
                iv.setColorFilter(ContextCompat.getColor(context, R.color.colorOrderPlaced));
                break;
            case 2:
                iv.setColorFilter(ContextCompat.getColor(context, R.color.colorOrderReady));
                break;
            case 3:
                iv.setColorFilter(ContextCompat.getColor(context, R.color.colorOrderDelivered));
                break;
        }

    }
}
