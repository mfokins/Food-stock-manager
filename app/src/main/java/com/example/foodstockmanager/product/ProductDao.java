package com.example.foodstockmanager.product;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

        @Insert
        void addProduct(Product product);

        @Update
        void update(Product product);

        @Delete
        void delete(Product product);

        @Query("DELETE FROM product_table WHERE id=:id")
        void deleteById(int id);

        @Query("DELETE FROM product_table")
        void deleteAllProducts();

        @Query("SELECT * FROM product_table ORDER BY id ASC")
        LiveData<List<Product>> getAllProducts();

        @Query("SELECT * FROM product_table ORDER BY expiryDate DESC")
        LiveData<List<Product>> getAllProductsByExpiryDate();

        @Query("SELECT * FROM product_table ORDER BY type DESC")
        LiveData<List<Product>> getAllProductsByType();
    }
