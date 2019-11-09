package com.example.project1;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> model = new MutableLiveData<>();
    private MutableLiveData<Integer> min = new MutableLiveData<>();
    private MutableLiveData<Integer> max = new MutableLiveData<>();

    public void setModel(String carModel) {
        model.setValue(carModel);
    }

    public void setMin(Integer minInput) {
        min.setValue(minInput);
    }

    public void setMax(Integer maxInput) {
        max.setValue(maxInput);
    }

    public LiveData<String> getModel() {
        return model;
    }

    public LiveData<Integer> getMin() {
        return min;
    }

    public LiveData<Integer> getMax() {
        return max;
    }
}