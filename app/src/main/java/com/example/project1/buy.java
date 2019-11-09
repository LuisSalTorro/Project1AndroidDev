package com.example.project1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class buy extends Fragment {

    DatabaseCars myDB; //initializes database class
    EditText carEditBuy, minEdit, maxEdit;
    Button searchButton;
    int min = 0, max = Integer.MAX_VALUE; //if crashes occur, keep these empty
    SharedViewModel model;


    public buy() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_buy, container, false);
        mySQLiteDB(rootView);
        return rootView;
    }

    public void mySQLiteDB(View rootView) {
        myDB = new DatabaseCars(getActivity());
        carEditBuy = rootView.findViewById(R.id.carEditBuy);
        minEdit = rootView.findViewById(R.id.minEdit);
        maxEdit = rootView.findViewById(R.id.maxEdit);
        searchButton = rootView.findViewById(R.id.searchButton);

        //searchCars();
        searchCar();
    }

    public void searchCar(){
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String input = carEditBuy.getText().toString();
                    model.setModel(input);

                    String minSTR = minEdit.getText().toString();
                    int minInt = Integer.valueOf(minSTR);
                    model.setMin(minInt);

                    String maxSTR = maxEdit.getText().toString();
                    int maxInt = Integer.valueOf(maxSTR);
                    model.setMax(maxInt);
                }catch (Exception e){

                    model.setModel(" ");

                    model.setMin(0);

                    model.setMax(Integer.MAX_VALUE);
                }


            }
        });
    }


    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
