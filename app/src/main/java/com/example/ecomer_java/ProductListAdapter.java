package com.example.ecomer_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecomer_java.Model.ProductModel;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<com.example.ecomer_java.ProductListAdapter.ProductViewHolder> {
    private ArrayList<ProductModel> productList = new ArrayList<>();

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productNameTV.setText(productList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setList(ArrayList<ProductModel> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productNameTV;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTV = itemView.findViewById(R.id.product_name);
        }
    }
}
