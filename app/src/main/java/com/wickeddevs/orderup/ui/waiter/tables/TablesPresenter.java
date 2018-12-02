package com.wickeddevs.orderup.ui.waiter.tables;

import com.wickeddevs.orderup.data.DataManager;


public class TablesPresenter implements TablesContract.ViewListener {

    TablesContract.View view;

    public TablesPresenter(TablesContract.View view) {
        this.view = view;
    }

    @Override
    public void getTables() {

        view.initialTableStatus(DataManager.getInstance().getTables());
    }
}
