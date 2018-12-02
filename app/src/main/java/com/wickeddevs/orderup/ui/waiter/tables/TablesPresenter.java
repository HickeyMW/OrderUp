package com.wickeddevs.orderup.ui.waiter.tables;

import com.wickeddevs.orderup.data.Table;

import java.util.ArrayList;
import java.util.Random;

public class TablesPresenter implements TablesContract.ViewListener {

    TablesContract.View view;

    public TablesPresenter(TablesContract.View view) {
        this.view = view;
    }

    @Override
    public void getTables() {
        ArrayList<Table> tables = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            Table table = new Table();
            Random random = new Random();
            table.appetizerStatus = random.nextInt(4);
            table.drinkStatus = random.nextInt(4);
            table.foodStatus = random.nextInt(4);
            tables.add(table);
        }
        view.initialTableStatus(tables);
    }
}
