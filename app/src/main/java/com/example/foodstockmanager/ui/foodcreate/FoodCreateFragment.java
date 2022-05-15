package com.example.foodstockmanager.ui.foodcreate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodstockmanager.databinding.FragmentFoodcreateBinding;
import com.example.foodstockmanager.product.DateConverter;
import com.example.foodstockmanager.product.Product;

import java.util.Date;

public class FoodCreateFragment extends Fragment {

    private FragmentFoodcreateBinding binding;
    FoodCreateViewModel foodCreateViewModel;
    ImageView categoryImage;
    TextView productName;
    CalendarView expiryDate;
    Button confirmButton;
    public static final  String CATEGORY = "category";
    public String productCategory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        foodCreateViewModel = new ViewModelProvider(this).get(FoodCreateViewModel.class);
        binding = FragmentFoodcreateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle extras = getArguments();
        productCategory = extras.getString(CATEGORY);
        initViews();
        setPicture();

        expiryDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                //Gregorian calendar is set to start from 1900 in code, so need to subtract 1900 to get selected year
                expiryDate.setDate(DateConverter.fromDate(new Date(year-1900, month, day)));
            }
        });

        confirmButton.setOnClickListener(this::addProduct);
        return root;
    }

    private void setPicture() {
        categoryImage.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(productCategory, "drawable", getContext().getPackageName())));
    }

    public void addProduct(View v) {
        foodCreateViewModel.addProduct(new Product(productCategory, productName.getText().toString(), new Date(binding.calendarView.getDate())));
        Toast.makeText(getContext(), "Added: " + productName.getText().toString(), Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }

    private void initViews(){
        categoryImage = binding.categoryImage;
        productName = binding.editProductName;
        expiryDate = binding.calendarView;
        expiryDate.setMinDate(binding.calendarView.getDate());
        confirmButton = binding.confirmProductButton;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}