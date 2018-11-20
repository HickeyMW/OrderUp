package com.wickeddevs.orderup.ui.waiter.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.wickeddevs.orderup.R;
import com.wickeddevs.orderup.data.Table;

import java.util.ArrayList;

public class TablesActivity extends AppCompatActivity implements TablesContract.View {

    RecyclerView rvTables;
    //BarRVA barRVA;
    TablesContract.ViewListener viewListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        viewListener = new TablesPresenter(this);
        setTitle("Tables Activity");
    }

    @Override
    public void initialTableStatus(ArrayList<Table> tables) {

    }

    @Override
    public void addTable(Table table) {

    }

    @Override
    public void updateTable(Table table) {

    }
}
