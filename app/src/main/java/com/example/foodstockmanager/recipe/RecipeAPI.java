package com.example.foodstockmanager.recipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeAPI {
    @GET("/api/json/v1/1/search.php")
    Call<RecipeResponse> getRecipe(@Query("s") String name);

    @GET("/api/json/v1/1/filter.php")
    Call<RecipeResponse> getRecipes(@Query("i") String ingredient);
}
