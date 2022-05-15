package com.example.foodstockmanager.ui.foodcreate;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodstockmanager.product.Product;
import com.example.foodstockmanager.product.ProductRepository;

import java.util.List;

public class FoodCreateViewModel extends AndroidViewModel {
    private ProductRepository repository;

    public FoodCreateViewModel(Application application) {
        super(application);
        repository = ProductRepository.getInstance(application);
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }

}