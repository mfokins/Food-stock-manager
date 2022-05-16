package com.example.foodstockmanager.ui.recipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodstockmanager.recipe.Recipe;
import com.example.foodstockmanager.recipe.RecipeRepository;

import java.util.ArrayList;

public class RecipesViewModel extends ViewModel {
    RecipeRepository repository;

    public RecipesViewModel() {
        repository = RecipeRepository.getInstance();
    }

    LiveData<Recipe> getExactRecipe() {
        return repository.getLookedUpRecipe();
    }

    LiveData<ArrayList<Recipe>> getSearchedRecipes() {
        return repository.getSearchedRecipes();
    }

    public void lookForRecipe(String name) { repository.lookupRecipe(name);
    }

    public void searchForRecipes(String ingredient) {
        repository.searchForRecipes(ingredient);
    }
}
