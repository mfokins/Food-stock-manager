package com.example.foodstockmanager.recipe;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeServiceGenerator {
    private static RecipeAPI recipeApi;

    public static RecipeAPI getRecipeApi() {
        if (recipeApi == null) {
            recipeApi = new Retrofit.Builder()
                    .baseUrl("https://www.themealdb.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RecipeAPI.class);
        }
        return recipeApi;
    }
}
