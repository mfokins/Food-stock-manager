package com.example.foodstockmanager.ui.products;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodstockmanager.databinding.FragmentProductsListBinding;
import com.example.foodstockmanager.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    private FragmentProductsListBinding binding;
    private ProductViewModel productViewModel;
    private MyProductRecyclerViewAdapter myProductRecyclerViewAdapter;
    RecyclerView productList;
    Button addedFilterButton;
    Button expiryFilterButton;
    Button typeFilterButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductsListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initViews();
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productList.setLayoutManager(new LinearLayoutManager(getContext()));

        productViewModel.getAllProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                ArrayList<Product> temp = new ArrayList<>(products);
                myProductRecyclerViewAdapter = new MyProductRecyclerViewAdapter(getContext(), productViewModel, temp);
                productList.setAdapter(myProductRecyclerViewAdapter);
            }
        });

        setAddedFilterButton();

        setExpiryFilterButton();

        setTypeFilterButton();

        return root;
    }

    private void initViews() {
        productList = binding.productList;
        addedFilterButton = binding.addedFilterButton;
        expiryFilterButton = binding.expiryFilterButton;
        typeFilterButton = binding.typeFilterButton;
    }

    private void setTypeFilterButton() {
        typeFilterButton.setOnClickListener(view -> {
            productViewModel.getAllProductsByType().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
                @Override
                public void onChanged(List<Product> products) {
                    ArrayList<Product> temp = new ArrayList<>(products);
                    myProductRecyclerViewAdapter = new MyProductRecyclerViewAdapter(getContext(), productViewModel, temp);
                    productList.setAdapter(myProductRecyclerViewAdapter);
                }
            });
        });
    }

    private void setExpiryFilterButton() {
        expiryFilterButton.setOnClickListener(view -> {
            productViewModel.getAllProductsByExpiryDate().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
                @Override
                public void onChanged(List<Product> products) {
                    ArrayList<Product> temp = new ArrayList<>(products);
                    myProductRecyclerViewAdapter = new MyProductRecyclerViewAdapter(getContext(), productViewModel, temp);
                    productList.setAdapter(myProductRecyclerViewAdapter);
                }
            });
        });
    }

    private void setAddedFilterButton() {
        addedFilterButton.setOnClickListener(view -> {
            productViewModel.getAllProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
                @Override
                public void onChanged(List<Product> products) {
                    ArrayList<Product> temp = new ArrayList<>(products);
                    myProductRecyclerViewAdapter = new MyProductRecyclerViewAdapter(getContext(), productViewModel, temp);
                    productList.setAdapter(myProductRecyclerViewAdapter);
                }
            });
        });
    }
}