package com.wickeddevs.orderup.ui.waiter.tables;

import com.wickeddevs.orderup.data.Table;

import java.util.ArrayList;

public interface TablesContract {

    interface View {
        void initialTableStatus(ArrayList<Table> tables);

        void addTable(Table table);

        void updateTable(Table table);
    }

    interface ViewListener {
        void getTables();

    }
}
