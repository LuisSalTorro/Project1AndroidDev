package com.example.project1;


import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class display extends Fragment {
    TextView carInfo;
    DatabaseCars myDB; //initializes database class
    int min, max;
    String modelName;
    SharedViewModel model;

    public display() {
        // Required empty public constructor
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        model.getModel().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String input){
                modelName = input;
                myDB.setModelCar(modelName);
            }
        });

        model.getMin().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer input){
                min = input;
                myDB.setMin(min);
                //tempView.setText(Integer.toString(min));
            }
        });

        model.getMax().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer input){
                //String modelName = model.getModel().toString();
                max = input;
                myDB.setMax(max);
                //tempView.setText(max);
            }
        });

        model.getEverything().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String every) {
                String[] everythingArray = every.split(" ");
                //A[0] is model
                //A[1] is min
                //A[2] is max
                int min = Integer.valueOf(everythingArray[1]);
                int max = Integer.valueOf(everythingArray[2]);
                displayCars(everythingArray[0], min, max);

            }
        });

        //displayCars();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_display, container, false);
        mySQLiteDB(rootView);
        //displayCars();
        return rootView;

    }

    public void mySQLiteDB(View rootView) {
        myDB = new DatabaseCars(getActivity());
        carInfo = rootView.findViewById(R.id.carInfo);
    }

    public void displayCars(String arr0, int arr1, int arr2){
        Cursor show = myDB.displayCars(arr0, arr1, arr2);
        if (show.getCount() == 0) {
            carInfo.setText("There are no cars up for sale.");
        }
        StringBuffer buffer = new StringBuffer();
        while (show.moveToNext()) {
            buffer.append("Model : " + show.getString(1) + "\n");
            buffer.append("Year : " + show.getString(2) + "\n");
            buffer.append("Price : " + show.getString(3) + "\n\n");
        }
        carInfo.setText(buffer.toString());
    }

}
