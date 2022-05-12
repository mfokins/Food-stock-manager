package com.example.foodstockmanager.ui.foodpyramid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FoodPyramidViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FoodPyramidViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is foodpyramid fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}