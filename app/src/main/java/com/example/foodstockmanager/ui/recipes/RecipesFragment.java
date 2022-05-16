package com.example.foodstockmanager.ui.recipes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodstockmanager.R;
import com.example.foodstockmanager.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;


public class RecipesFragment extends Fragment {

    RecipesViewModel recipesViewModel;
    MyRecipesRecyclerViewAdapter myRecipesRecyclerViewAdapter;
    RecyclerView recipeList;
    public static final String INGREDIENT = "ingredient";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes_list, container, false);


        recipesViewModel = new ViewModelProvider(this).get(RecipesViewModel.class);

        Bundle extras = getArguments();

        recipesViewModel.searchForRecipes(extras.getString(INGREDIENT));

        recipeList = view.findViewById(R.id.recipes_list);
        recipeList.setLayoutManager(new LinearLayoutManager(getContext()));

        recipesViewModel.getSearchedRecipes().observe(getViewLifecycleOwner(), new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                ArrayList<Recipe> temp = new ArrayList<>(recipes);
                myRecipesRecyclerViewAdapter = new MyRecipesRecyclerViewAdapter(temp);
                recipeList.setAdapter(myRecipesRecyclerViewAdapter);
            }
        });

        return view;
    }
}