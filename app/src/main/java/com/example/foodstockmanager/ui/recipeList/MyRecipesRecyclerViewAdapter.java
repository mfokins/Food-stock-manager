package com.example.foodstockmanager.ui.recipeList;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodstockmanager.R;
import com.example.foodstockmanager.databinding.FragmentRecipeBinding;
import com.example.foodstockmanager.recipe.Recipe;

import java.util.List;

public class MyRecipesRecyclerViewAdapter extends RecyclerView.Adapter<MyRecipesRecyclerViewAdapter.ViewHolder> {

    private final List<Recipe> recipes;
    NavController navController;
    public static final String RECIPE = "Recipe";

    public MyRecipesRecyclerViewAdapter(List<Recipe> items) {
        recipes = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentRecipeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.recipePositionView.setText(position + 1 + ":");
        holder.recipeNameView.setText(recipes.get(position).getName());
        Glide.with(holder.recipeImageView.getContext()).load(recipes.get(position).getImageUrl()).into(holder.recipeImageView);
        holder.lookupButton.setOnClickListener(product ->{
            Bundle temp = new Bundle();
            temp.putString(RECIPE, recipes.get(position).getName());
            navController = Navigation.findNavController(holder.itemView);
            navController.navigate(R.id.navigation_recipe_details, temp);
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView recipePositionView;
        public ImageView recipeImageView;
        public final TextView recipeNameView;
        public final ImageButton lookupButton;

        public ViewHolder(FragmentRecipeBinding binding) {
            super(binding.getRoot());
            recipePositionView = binding.recipeNumber;
            recipeImageView = binding.recipeIcon;
            recipeNameView = binding.recipeName;
            lookupButton = binding.lookupRecipeButton;
        }
    }
}