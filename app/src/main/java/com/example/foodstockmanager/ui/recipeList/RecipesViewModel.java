package com.example.foodstockmanager.ui.recipeList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodstockmanager.recipe.Recipe;
import com.example.foodstockmanager.recipe.RecipeRepository;

import java.util.ArrayList;

public class RecipesViewModel extends ViewModel {
    RecipeRepository repository;

    public RecipesViewModel() {
        repository = RecipeRepository.getInstance();
    }

    LiveData<ArrayList<Recipe>> getSearchedRecipes() {
        return repository.getSearchedRecipes();
    }

    public void searchForRecipes(String ingredient) {
        repository.searchForRecipes(ingredient);
    }
}
