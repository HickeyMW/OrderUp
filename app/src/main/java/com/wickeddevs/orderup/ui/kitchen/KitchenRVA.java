package com.wickeddevs.orderup.ui.kitchen;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wickeddevs.orderup.R;
import com.wickeddevs.orderup.data.Appetizer;
import com.wickeddevs.orderup.data.Food;
import com.wickeddevs.orderup.data.Item;
import com.wickeddevs.orderup.data.Order;

import java.util.ArrayList;

public class KitchenRVA extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Order> orders;
    private  ArrayList<Object> items;

    public KitchenRVA(Context context, ArrayList<Order> orders) {
        layoutInflater = LayoutInflater.from(context);
        this.orders = orders;
        createItemList();
    }

    private void createItemList() {
        items = new ArrayList<>();
        for (Order order: orders) {
            items.add(order);
            for (Item item: order.items) {
                items.add(item);
            }
        }
        notifyDataSetChanged();
    }

    public void addOrder(Order order) {
        orders.add(order);
        createItemList();
    }

    private void removeOrder(Order order) {
        orders.remove(order);
        createItemList();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position).getClass() == Order.class) {
            return 0;
        } else if (items.get(position).getClass() == Appetizer.class) {
            return 1;
        }
        return 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.view_order, parent, false);
            return new OrderVH(view);
        }
        view = layoutInflater.inflate(R.layout.view_order_item, parent, false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 0) {
            OrderVH orderVH = (OrderVH) holder;
            Order order = (Order) items.get(position);
            orderVH.order = order;
            orderVH.tvTable.setText("Table " + order.tableNumber);
            orderVH.tvOrder.setText("Order " + order.orderNumber);
        } else if (holder.getItemViewType() == 0) {
            ItemVH itemVH = (ItemVH) holder;
            Appetizer appetizer = (Appetizer) items.get(position);
            itemVH.tvName.setText(appetizer.getName());
        } else {
            ItemVH itemVH = (ItemVH) holder;
            Food food = (Food) items.get(position);
            itemVH.tvName.setText(food.getName());
        }
    }

    @Override
    public int getItemCount() {

        return items.size();
    }



    public class OrderVH extends RecyclerView.ViewHolder {
        TextView tvOrder;
        TextView tvTable;
        Button btnCompleted;
        Order order;

        public OrderVH(View itemView) {
            super(itemView);
            tvOrder = itemView.findViewById(R.id.tvOrder);
            tvTable = itemView.findViewById(R.id.tvTable);
            btnCompleted = itemView.findViewById(R.id.btnCompleted);
            btnCompleted.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    removeOrder(order);
                }
            });
        }
    }

    public class ItemVH extends RecyclerView.ViewHolder {
        TextView tvName;

        public ItemVH(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
