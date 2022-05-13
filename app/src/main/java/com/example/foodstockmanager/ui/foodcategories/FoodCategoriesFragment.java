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
import com.example.foodstockmanager.ui.foodcreate.FoodCreateFragment;

public class FoodCategoriesFragment extends Fragment {

    private FragmentFoodcategoriesBinding binding;
    ImageButton dairyButton;
    ImageButton fruitButton;
    ImageButton meatButton;
    ImageButton grainsButton;
    ImageButton vegetableButton;
    ImageButton junkFoodButton;
    Button otherFoodButton;
    NavController navController;
    public static final  String CATEGORY = "category";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
           binding = FragmentFoodcategoriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initViews();
        setupNavigation();

        return root;
    }

    private void initViews() {
        dairyButton = binding.dairyButton;
        fruitButton = binding.fruitButton;
        meatButton = binding.meatButton;
        grainsButton = binding.grainsButton;
        vegetableButton = binding.vegetableButton;
        junkFoodButton = binding.junkFoodButton;
        otherFoodButton = binding.otherFoodButton;
    }

    private void setupNavigation() {
        navController = Navigation.findNavController(super.getActivity(), R.id.nav_host_fragment_activity_main);
        dairyButton.setOnClickListener(v -> goToFoodCreate("dairy"));
        fruitButton.setOnClickListener(v -> goToFoodCreate("fruit"));
        meatButton.setOnClickListener(v -> goToFoodCreate("meat"));
        grainsButton.setOnClickListener(v -> goToFoodCreate("grains"));
        vegetableButton.setOnClickListener(v -> goToFoodCreate("vegetables"));
        junkFoodButton.setOnClickListener(v -> goToFoodCreate("junkfood"));
        otherFoodButton.setOnClickListener(v -> goToFoodCreate("other"));
    }

    private void goToFoodCreate(String argument) {
        Bundle temp = new Bundle();
        temp.putString(CATEGORY, argument);
        navController.navigate(R.id.navigation_foodcreate, temp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}