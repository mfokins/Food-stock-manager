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

    public void deleteAllProducts() {
        repository.deleteAllProducts();
    }

    public void delete(Product product) {
        repository.delete(product);
    }
}
