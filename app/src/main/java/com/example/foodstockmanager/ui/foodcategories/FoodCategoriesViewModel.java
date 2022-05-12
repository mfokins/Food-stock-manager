package com.example.foodstockmanager.ui.foodcategories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FoodCategoriesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FoodCategoriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is foodcategories fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}