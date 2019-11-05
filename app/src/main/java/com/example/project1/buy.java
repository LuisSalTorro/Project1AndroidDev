package com.example.project1;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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
public class buy extends Fragment {
    DatabaseCars myDB; //initializes database class
    EditText carEditBuy, minEdit, maxEdit;
    Button searchButton;
    int min = 0, max = Integer.MAX_VALUE; //if crashes occur, keep these empty


    public buy() {
        // Required empty public constructor
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

        searchCars();
    }

    public void convertStringToInt(String min, String max){
        try{
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }catch(Exception e){
            Toast.makeText(getActivity(),"Type numbers", Toast.LENGTH_LONG).show();
        }
    }


    public void searchCars() {
        searchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor show = myDB.showCar();
                        if (show.getCount() == 0) {
                            showMessage("Error", "Nothing found");
                            Toast.makeText(getActivity(), "Show Car Error / Empty", Toast.LENGTH_SHORT).show();
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (show.moveToNext()) {
                            //buffer.append("Id : " + show.getString(0) + "\n");
                            buffer.append("Model : " + show.getString(1) + "\n");
                            buffer.append("Year : " + show.getString(2) + "\n");
                            buffer.append("Price : " + show.getString(3) + "\n");
                        }
                        convertStringToInt(minEdit.getText().toString(), maxEdit.getText().toString());
                        //showMessage("Data", buffer.toString());
                        Intent intent = new Intent(getActivity(), display.class);
                        Fragment fragment = new Fragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("Key", buffer.toString());
                        intent.putExtras(bundle);
                        fragment.setArguments(bundle);


                    }//onClick
                }
        );
    }


    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
