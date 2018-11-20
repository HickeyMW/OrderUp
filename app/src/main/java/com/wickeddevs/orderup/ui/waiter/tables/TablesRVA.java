package com.wickeddevs.orderup.ui.waiter.tables;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wickeddevs.orderup.R;
import com.wickeddevs.orderup.data.Table;

import java.util.ArrayList;

public class TablesRVA extends RecyclerView.Adapter<TablesRVA.TableVH> {

    private ArrayList<Table> tables;
    private LayoutInflater layoutInflater;

    public TablesRVA(Context context, ArrayList<Table> tables) {
        this.tables = tables;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public TableVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return layoutInflater.inflate();
    }

    @Override
    public void onBindViewHolder(@NonNull TableVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public class TableVH extends RecyclerView.ViewHolder {
        TextView tvName;

        public TableVH(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
