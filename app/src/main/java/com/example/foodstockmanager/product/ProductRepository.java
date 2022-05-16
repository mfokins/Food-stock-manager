package com.example.foodstockmanager.product;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductRepository {
    private final ProductDao productDAO;
    private static ProductRepository instance;
    private final LiveData<List<Product>> allProducts;
    ExecutorService executorService;
    Handler mainThreadHandler;


    private ProductRepository(Application application) {
        ProductDatabase database = ProductDatabase.getInstance(application);
        productDAO = database.productDAO();
        allProducts = productDAO.getAllProducts();
        executorService = Executors.newFixedThreadPool(2);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    public static ProductRepository getInstance(Application application) {
        if (instance == null)
            instance = new ProductRepository(application);

        return instance;
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    public LiveData<List<Product>> getAllProductsByExpiryDate() {
        return productDAO.getAllProductsByExpiryDate();
    }

    public LiveData<List<Product>> getAllProductsByType() {
        return productDAO.getAllProductsByType();
    }

    public void addProduct(Product product) {
        executorService.execute(() -> productDAO.addProduct(product));
    }

    public void delete(Product product) {
        executorService.execute(() -> productDAO.delete(product));
    }

    //alternative to delete by ID
    public void deleteById(int id) {
        productDAO.deleteById(id);
    }


    public void deleteAllProducts() {
        productDAO.deleteAllProducts();
    }

}
