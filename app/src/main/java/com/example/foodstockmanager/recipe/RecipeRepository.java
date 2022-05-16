package com.example.foodstockmanager.recipe;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class RecipeRepository {

    private static RecipeRepository instance;
    private final MutableLiveData<Recipe> gainedRecipe;
    private final MutableLiveData<ArrayList<Recipe>> searchedRecipes;
    private RecipeAPI recipeApi;

    private RecipeRepository() {
        gainedRecipe = new MutableLiveData<>();
        searchedRecipes = new MutableLiveData<>();
        recipeApi = RecipeServiceGenerator.getRecipeApi();
    }

    public static synchronized RecipeRepository getInstance() {
        if (instance == null) {
            instance = new RecipeRepository();
        }
        return instance;
    }

    public LiveData<Recipe> getLookedUpRecipe() {
        return gainedRecipe;
    }

    public MutableLiveData<ArrayList<Recipe>> getSearchedRecipes() {
        return searchedRecipes;
    }

    public void lookupRecipe(String recipeName) {
        Call<RecipeResponse> call = recipeApi.getRecipe(recipeName);
        call.enqueue(new Callback<RecipeResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful()) {
                    gainedRecipe.setValue(response.body().getFirstRecipe());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }

    public void searchForRecipes(String ingredient) {
        Call<RecipeResponse> call = recipeApi.getRecipes(ingredient);
        call.enqueue(new Callback<RecipeResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful()) {
                    searchedRecipes.setValue(response.body().getListOfRecipes());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }

}
