package com.example.foodstockmanager.recipe;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecipeResponse {
    private ArrayList<Recipe> meals;

    public Recipe getFirstRecipe() {
        return meals.get(0);
    }

    public ArrayList<Recipe> getListOfRecipes() {
        return meals;
    }
}
