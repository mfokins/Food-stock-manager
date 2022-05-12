package com.example.foodstockmanager.ui.foodcategories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.foodstockmanager.R;
import com.example.foodstockmanager.databinding.FragmentFoodcategoriesBinding;

public class FoodCategoriesFragment extends Fragment {

    private FragmentFoodcategoriesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FoodCategoriesViewModel foodCategoriesViewModel =
                new ViewModelProvider(this).get(FoodCategoriesViewModel.class);

        binding = FragmentFoodcategoriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageButton dairyButton = binding.dairyButton;
        ImageButton fruitButton = binding.fruitButton;
        ImageButton meatButton = binding.meatButton;
        ImageButton grainsButton = binding.grainsButton;
        ImageButton vegetableButton = binding.vegetableButton;
        ImageButton junkFoodButton = binding.junkFoodButton;
        Button otherFoodButton = binding.otherFoodButton;

        NavController navController = Navigation.findNavController(super.getActivity(), R.id.nav_host_fragment_activity_main);
        dairyButton.setOnClickListener(v -> navController.navigate(R.id.navigation_foodcreate));
        fruitButton.setOnClickListener(v -> navController.navigate(R.id.navigation_foodcreate));
        meatButton.setOnClickListener(v -> navController.navigate(R.id.navigation_foodcreate));
        grainsButton.setOnClickListener(v -> navController.navigate(R.id.navigation_foodcreate));
        vegetableButton.setOnClickListener(v -> navController.navigate(R.id.navigation_foodcreate));
        junkFoodButton.setOnClickListener(v -> navController.navigate(R.id.navigation_foodcreate));
        otherFoodButton.setOnClickListener(v -> navController.navigate(R.id.navigation_foodcreate));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}