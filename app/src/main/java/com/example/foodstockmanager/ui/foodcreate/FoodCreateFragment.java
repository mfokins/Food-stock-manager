package com.example.foodstockmanager.ui.foodcreate;

import android.content.Intent;
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

import com.example.foodstockmanager.R;
import com.example.foodstockmanager.databinding.FragmentFoodcreateBinding;

public class FoodCreateFragment extends Fragment {

    private FragmentFoodcreateBinding binding;
    ImageView categoryImage;
    TextView productName;
    TextView expiryDate;
    Button confirmButton;
    public static final  String CATEGORY = "category";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FoodCreateViewModel foodCreateViewModel =
                new ViewModelProvider(this).get(FoodCreateViewModel.class);

        binding = FragmentFoodcreateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Bundle extras = getArguments();

        initViews();
        setPicture(extras);

        return root;
    }

    private void setPicture(Bundle extras) {
        switch (extras.getString(CATEGORY))
        {
            case "dairy":  categoryImage.setImageDrawable(getResources().getDrawable(R.drawable.dairy));
                break;
            case "fruit":  categoryImage.setImageDrawable(getResources().getDrawable(R.drawable.fruit));
                break;
            case "meat":  categoryImage.setImageDrawable(getResources().getDrawable(R.drawable.meat));
                break;
            case "grains":  categoryImage.setImageDrawable(getResources().getDrawable(R.drawable.grains));
                break;
            case "vegetables":  categoryImage.setImageDrawable(getResources().getDrawable(R.drawable.vegetables));
                break;
            case "junkfood":  categoryImage.setImageDrawable(getResources().getDrawable(R.drawable.junkfood));
                break;
        }
    }

    private void initViews(){
        categoryImage = binding.categoryImage;
        productName = binding.editProductName;
        expiryDate = binding.editTextDate;
        confirmButton = binding.confirmProductButton;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}