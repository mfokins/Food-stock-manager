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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodstockmanager.R;
import com.example.foodstockmanager.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ProductViewModel productViewModel;
    private ArrayList<Product> products;
    private MyProductRecyclerViewAdapter myProductRecyclerViewAdapter;
    RecyclerView productList;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductFragment() {
    }


    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProductFragment newInstance(int columnCount) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productList = view.findViewById(R.id.product_list);
        productList.setLayoutManager(new LinearLayoutManager(getContext()));


//        LiveData<List<Product>> temp = productViewModel.getAllProducts();
//        products = productViewModel.getAllProducts().getValue();
        productViewModel.getAllProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                ArrayList<Product> temp = new ArrayList<>(products);
                myProductRecyclerViewAdapter = new MyProductRecyclerViewAdapter(temp);
                productList.setAdapter(myProductRecyclerViewAdapter);
            }
        });


        return view;
    }
}