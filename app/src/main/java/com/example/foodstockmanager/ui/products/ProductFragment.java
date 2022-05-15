package com.example.foodstockmanager.ui.products;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodstockmanager.R;
import com.example.foodstockmanager.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    private ProductViewModel productViewModel;
    private ArrayList<Product> products;
    private MyProductRecyclerViewAdapter myProductRecyclerViewAdapter;
    RecyclerView productList;

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productList = view.findViewById(R.id.product_list);
        productList.setLayoutManager(new LinearLayoutManager(getContext()));

        productViewModel.getAllProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                ArrayList<Product> temp = new ArrayList<>(products);
                myProductRecyclerViewAdapter = new MyProductRecyclerViewAdapter(getContext(), temp);
                productList.setAdapter(myProductRecyclerViewAdapter);
                myProductRecyclerViewAdapter.setOnClickListener(product -> {
                    Toast.makeText(getContext(), ""+product.getId(), Toast.LENGTH_SHORT).show();
                });
            }
        });

        return view;
    }
}