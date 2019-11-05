package com.example.project1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class sell extends Fragment {
    DatabaseCars myDB; //initializes database class
    //database things
    EditText carEdit, yearEdit, priceEdit;
    Button sellButton;

    public sell() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sell, container, false);
        mySQLiteDB(rootView);
        return rootView;
    }

    protected void mySQLiteDB(View rootView){
        myDB = new DatabaseCars(getActivity());
        carEdit = rootView.findViewById(R.id.carEdit);
        yearEdit = rootView.findViewById(R.id.yearEdit);
        priceEdit = rootView.findViewById(R.id.priceEdit);
        sellButton = rootView.findViewById(R.id.sellButton);
        //searchButton = rootView.findViewById(R.id.searchButton);

        addData(); //causing problems
        //viewCars(); //might be causing problems too
    }


    public void addData(){
        sellButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean addData_works = myDB.addData(carEdit.getText().toString(),
                                yearEdit.getText().toString(),
                                priceEdit.getText().toString());
                        if (addData_works) {
                            Toast.makeText(getActivity(), "Car Added", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Car Not Added", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }



}
