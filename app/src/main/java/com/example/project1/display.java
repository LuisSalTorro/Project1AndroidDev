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
    TextView modelView, minView, maxView;

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
                //String modelName = model.getModel().toString();
                modelName = input;
                //modelView.setText(modelName);
                myDB.setModelCar(modelName);
                //tempView.setText(modelName);
                modelView.setText(myDB.getModelCar());
            }
        });

        model.getMin().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer input){
                //String modelName = model.getModel().toString();
//                min = input;
//                String getStr = Integer.toString(min);
//                tempView.setText(getStr);
                min = input;
                minView.setText(Integer.toString(min));
                myDB.setMin(min);
                //tempView.setText(Integer.toString(min));
            }
        });

        model.getMax().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer input){
                //String modelName = model.getModel().toString();
                max = input;
                maxView.setText(Integer.toString(max));
                myDB.setMax(max);
                //tempView.setText(max);
            }
        });
       // maxView.setText(Integer.toString(min));
        displayCars();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_display, container, false);
        modelView = rootView.findViewById(R.id.modelView);
        minView = rootView.findViewById(R.id.minView);
        maxView = rootView.findViewById(R.id.maxView);
        mySQLiteDB(rootView);
        displayCars();
        return rootView;

    }

    public void mySQLiteDB(View rootView) {
        myDB = new DatabaseCars(getActivity());
        carInfo = rootView.findViewById(R.id.carInfo);
    }

    public void displayCars(){
        //String model = "Nissan";
        //Cursor show = myDB.displayCars(this.modelName, this.min, this.max);
        //Cursor show = myDB.displayCars(model, minc, maxc);
        Cursor show = myDB.displayCars(myDB.getModelCar(), myDB.getMin(), myDB.getMax());
        if (show.getCount() == 0) {
            //showMessage("Error", "Nothing found");
//                            Toast.makeText(getActivity(), "Show Car Error / Empty", Toast.LENGTH_SHORT).show();
            carInfo.setText("There are no cars up for sale.");
        }
        StringBuffer buffer = new StringBuffer();
        while (show.moveToNext()) {
            //buffer.append("Id : " + show.getString(0) + "\n");
            buffer.append("Model : " + show.getString(1) + "\n");
            buffer.append("Year : " + show.getString(2) + "\n");
            buffer.append("Price : " + show.getString(3) + "\n");
        }
        //showMessage("Data", buffer.toString());
        carInfo.setText(buffer.toString());

    }

}
