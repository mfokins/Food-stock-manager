package com.example.foodstockmanager.ui.foodcreate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FoodCreateViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FoodCreateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is foodcreate fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}