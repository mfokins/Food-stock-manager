package com.example.foodstockmanager.recipe;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    @SerializedName("idMeal")
    private final int number;
    @SerializedName("strMeal")
    private final String name;
    @SerializedName("strCategory")
    private final String category;
    @SerializedName("strInstructions")
    private final String instruction;
    @SerializedName("strMealThumb")
    private final String imageUrl;

    public Recipe(int number, String name, String category, String instruction, String imageUrl) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.instruction = instruction;
        this.imageUrl = imageUrl;
        //also possible to create two arrays of String: 1:ingredients 2:measures from the API
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
