package com.wickeddevs.orderup.ui.waiter.tables;

public class TablesPresenter implements TablesContract.ViewListener {

    TablesContract.View view;

    public TablesPresenter(TablesContract.View view) {
        this.view = view;
    }

    @Override
    public void getTables() {

    }
}
