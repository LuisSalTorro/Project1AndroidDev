package com.example.project1;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.project1.DatabaseCars.TABLE_NAME;


/**
 * A simple {@link Fragment} subclass.
 */
public class display extends Fragment {
    TextView carInfo;
    DatabaseCars myDB; //initializes database class
    int min, max;
    String modelName;


    public display() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< Updated upstream
        return inflater.inflate(R.layout.fragment_display, container, false);
=======
        View rootView = inflater.inflate(R.layout.fragment_display, container, false);

        mySQLiteDB(rootView);
        return rootView;
>>>>>>> Stashed changes
    }

    public void mySQLiteDB(View rootView) {
        myDB = new DatabaseCars(getActivity());
        carInfo = rootView.findViewById(R.id.carInfo);

        //searchCars();
        displayCars();
    }

    public void displayCars(){
        String model = "Nissan";
        Cursor show = myDB.displayCars(model, 0, 1000);
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

//    public void searchCars() {
//
//        Cursor show = myDB.showCar();
//        if (show.getCount() == 0) {
//            //showMessage("Error", "Nothing found");
////                            Toast.makeText(getActivity(), "Show Car Error / Empty", Toast.LENGTH_SHORT).show();
//            carInfo.setText("There are no cars up for sale.");
//        }
//        StringBuffer buffer = new StringBuffer();
//        while (show.moveToNext()) {
//            //buffer.append("Id : " + show.getString(0) + "\n");
//            buffer.append("Model : " + show.getString(1) + "\n");
//            buffer.append("Year : " + show.getString(2) + "\n");
//            buffer.append("Price : " + show.getString(3) + "\n");
//        }
//        //showMessage("Data", buffer.toString());
//        carInfo.setText(buffer.toString());
//
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {


        }

    }


}
