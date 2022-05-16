package com.example.foodstockmanager.ui.recipeDetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodstockmanager.recipe.Recipe;
import com.example.foodstockmanager.recipe.RecipeRepository;

public class RecipeDetailsViewModel extends ViewModel {
    RecipeRepository repository;

    public RecipeDetailsViewModel() {
        repository = RecipeRepository.getInstance();
    }

    LiveData<Recipe> getExactRecipe() {
        return repository.getLookedUpRecipe();
    }


    public void lookForRecipe(String name) { repository.lookupRecipe(name);
    }

}