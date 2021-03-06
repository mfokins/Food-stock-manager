package com.example.foodstockmanager.ui.products;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.foodstockmanager.product.Product;
import com.example.foodstockmanager.product.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repository;

    public ProductViewModel(Application application) {
        super(application);
        repository = ProductRepository.getInstance(application);
    }

    public LiveData<List<Product>> getAllProducts() {
        return repository.getAllProducts();
    }

    public LiveData<List<Product>> getAllProductsByExpiryDate() {
        return repository.getAllProductsByExpiryDate();
    }

    public LiveData<List<Product>> getAllProductsByType() {
        return repository.getAllProductsByType();
    }

    public void deleteAllProducts() {
        repository.deleteAllProducts();
    }

    //Could also be done with id method
    public void delete(Product product) {
        repository.delete(product);
    }
}
