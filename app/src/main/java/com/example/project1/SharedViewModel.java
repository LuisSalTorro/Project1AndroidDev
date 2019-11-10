package com.example.project1;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> modelCar = new MutableLiveData<>();
    private MutableLiveData<Integer> min = new MutableLiveData<>();
    private MutableLiveData<Integer> max = new MutableLiveData<>();

    private MutableLiveData<String> everything = new MutableLiveData<>();

    public void setEverything(String everything){
        this.everything.setValue(everything);
    }

    public LiveData<String> getEverything(){
        return this.everything;
    }


    public void setModel(String carModel) {
        modelCar.setValue(carModel);
    }

    public void setMin(Integer minInput) {
        min.setValue(minInput);
    }

    public void setMax(Integer maxInput) {
        max.setValue(maxInput);
    }

    public LiveData<String> getModel() {
        return modelCar;
    }

    public LiveData<Integer> getMin() {
        return min;
    }

    public LiveData<Integer> getMax() {
        return max;
    }
}