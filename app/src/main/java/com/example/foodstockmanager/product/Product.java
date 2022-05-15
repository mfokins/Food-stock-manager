package com.example.foodstockmanager.product;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;


@Entity(tableName = "product_table")
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String type;
    private String name;
    @TypeConverters(DateConverter.class)
    private Date expiryDate;


    public Product (String type, String name, Date date) {
        this.type = type;
        this.name = name;
        this.expiryDate =  date;
    }

    public Product(){}


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
