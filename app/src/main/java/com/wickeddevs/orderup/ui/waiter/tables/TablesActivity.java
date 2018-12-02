package com.wickeddevs.orderup.ui.waiter.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wickeddevs.orderup.R;
import com.wickeddevs.orderup.data.Table;
import com.wickeddevs.orderup.ui.bar.BarRVA;

import java.util.ArrayList;

public class TablesActivity extends AppCompatActivity implements TablesContract.View {

    RecyclerView rvTables;
    TablesRVA tablesRVA;
    TablesContract.ViewListener viewListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        viewListener = new TablesPresenter(this);
        setTitle("Tables Activity");
        rvTables = findViewById(R.id.rvTables);
        viewListener.getTables();
    }

    @Override
    public void initialTableStatus(ArrayList<Table> tables) {
        rvTables.setLayoutManager(new LinearLayoutManager(this));
        tablesRVA = new TablesRVA(this, tables);
        rvTables.setAdapter(tablesRVA);
    }

    @Override
    public void addTable(Table table) {

    }

    @Override
    public void updateTable(Table table) {

    }

    public void showTableDetails(int tableNumber) {

    }
}
