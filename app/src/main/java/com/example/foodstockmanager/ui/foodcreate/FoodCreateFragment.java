package com.example.foodstockmanager.ui.foodcreate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodstockmanager.databinding.FragmentFoodcreateBinding;

public class FoodCreateFragment extends Fragment {

    private FragmentFoodcreateBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FoodCreateViewModel foodCreateViewModel =
                new ViewModelProvider(this).get(FoodCreateViewModel.class);

        binding = FragmentFoodcreateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageView categoryImage = binding.categoryImage;
        TextView productName = binding.editProductName;
        TextView expiryDate = binding.editTextDate;
        Button confirmButton = binding.confirmProductButton;

//        final TextView textView = binding.textFoodcreate;
//        foodCreateViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}