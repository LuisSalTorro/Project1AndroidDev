package com.example.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseCars extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Car.db";
    public static final String TABLE_NAME = "car_table";
    public static final String idCol = "ID";
    public static final String modelCar = "ModelCar";
    public static final String yearCol = "Year";
    public static final String priceCol = "Price";

    String carName;
    int minVal, maxVal;
    public static final int DATABASE_VERSION = 4;

    String CREATE_QUERY = "CREATE TABLE " + NewCar.info.TABLE_NAME + "("
            + NewCar.info.idCol + " INTEGER PRIMARY KEY,"
            + NewCar.info.modelCar + " TEXT,"
            + NewCar.info.yearCol + " TEXT,"
            //+ NewCar.info.maxCol + " INTEGER PRIMARY KEY,"
            //+ NewCar.info.minCol + " INTEGER PRIMARY KEY,"
            + NewCar.info.priceCol + " INTEGER);"; 

    //Data base is created whenever constructer is called
    public DatabaseCars(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }

    //creates the table
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created...");
    }

    //drops the table if it already exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NewCar.info.TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String modelCar, String yearCol, String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentData = new ContentValues();

        contentData.put(NewCar.info.modelCar,modelCar);
        contentData.put(NewCar.info.yearCol,yearCol);
        contentData.put(NewCar.info.priceCol,price);

        long error = db.insert(NewCar.info.TABLE_NAME, null, contentData);
        if(error == -1){
            Log.e("DATABASE OPERATIONS","Table INSERT ERROR...");
            return false; //insert did not succeed
        }else{
            Log.e("DATABASE OPERATIONS", "Table INSERT SUCCESS...");
            return true; //insert succeeded
        }

    }
    public Cursor showCar(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor show = db.rawQuery("select * from " +NewCar.info.TABLE_NAME, null);
        return show;
    }

    public void setModelCar(String model){
        this.carName = model;
    }

    public String getModelCar(){
        return this.carName;
    }

    public void setMin(Integer min){
        this.minVal = min;
    }

    public int getMin(){
        return this.minVal;
    }

    public void setMax(Integer max){
        this.maxVal = max;
    }

    public int getMax(){
        return this.maxVal;
    }

    public Cursor displayCars(String modelc, int mini, int maxi){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor filterData = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE MAKE = " + make + " AND PRICE BETWEEN " + min + " AND " + max, null);
        Cursor filterData = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ModelCar = '" + modelc + "' AND PRICE BETWEEN " + mini + " AND " + maxi, null);
        //Cursor filterData = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE PRICE BETWEEN " + min + " AND " + max, null);
        return filterData;
    }
}
