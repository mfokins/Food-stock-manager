package com.example.foodstockmanager.ui.foodpyramid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodstockmanager.databinding.FragmentFoodpyramidBinding;

public class FoodPyramidFragment extends Fragment {

    private FragmentFoodpyramidBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FoodPyramidViewModel foodPyramidViewModel =
                new ViewModelProvider(this).get(FoodPyramidViewModel.class);

        binding = FragmentFoodpyramidBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textGallery;
//        foodPyramidViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}