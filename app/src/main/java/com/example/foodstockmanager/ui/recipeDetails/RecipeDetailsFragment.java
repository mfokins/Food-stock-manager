package com.example.foodstockmanager.ui.recipeDetails;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodstockmanager.databinding.FragmentRecipeDetailsBinding;
import com.example.foodstockmanager.recipe.Recipe;

public class RecipeDetailsFragment extends Fragment {

    private FragmentRecipeDetailsBinding binding;
    private RecipeDetailsViewModel recipeDetailsViewModel;
    ImageView recipeImage;
    TextView recipeDescription;
    public static final String RECIPE = "Recipe";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        recipeDetailsViewModel = new ViewModelProvider(this).get(RecipeDetailsViewModel.class);
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recipeImage = binding.recipePicture;
        recipeDescription = binding.recipeDescription;

        Bundle extras = getArguments();

        recipeDetailsViewModel.lookForRecipe(extras.getString(RECIPE));

        recipeDetailsViewModel.getExactRecipe().observe(getViewLifecycleOwner(), new Observer<Recipe>() {
            @Override
            public void onChanged(Recipe recipe) {
                if (recipe != null) {
                    Glide.with(binding.getRoot()).load(recipe.getImageUrl()).into(recipeImage);
                    recipeDescription.setText("Instructions: \n\n" + recipe.getInstruction());
                }
            }
        });

        return root;
    }


}