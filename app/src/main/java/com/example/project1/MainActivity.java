package com.example.project1;

//import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

//import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TabLayout mTabLayout;
    TabItem sell, buy, display;
    ViewPager mPager;
    PagerController mPagerController;

<<<<<<< Updated upstream
    //database things
    DatabaseCars myDB; //initializes database class
    EditText carEdit, yearEdit, priceEdit;
    Button sellButton, searchButton;
=======
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< Updated upstream
        //call constructer, creates the database
        myDB = new DatabaseCars(this);
        userInterface();
        mySQLiteDB();
=======

        userInterface();
>>>>>>> Stashed changes
    }

    protected void userInterface(){
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Tab Cars");

        mTabLayout = findViewById(R.id.tabLayout);
        sell = findViewById(R.id.sell);
        buy = findViewById(R.id.buy);
        display = findViewById(R.id.display);
        mPager = findViewById(R.id.viewPager);

        mPagerController = new PagerController(getSupportFragmentManager(),1 );
        mPager.setAdapter(mPagerController);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));  //causing the application to crash
    }

<<<<<<< Updated upstream
    protected void mySQLiteDB(){
        carEdit = (EditText) findViewById(R.id.carEdit);
        yearEdit = (EditText) findViewById(R.id.yearEdit);
        priceEdit = (EditText) findViewById(R.id.priceEdit);
        sellButton = (Button) findViewById(R.id.sellButton);
        searchButton = (Button) findViewById(R.id.searchButton);

        addData(); //causing problems
        viewCars(); //might be causing problems too
    }
    public void addData(){
        sellButton.setOnClickListener(                  //sellButton is showing up null when it shouldn't be
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean addData_works = myDB.addData(carEdit.getText().toString(),
                                yearEdit.getText().toString(),
                                priceEdit.getText().toString());
                        if (addData_works) {
                            Toast.makeText(MainActivity.this, "Car Added", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Car Not Added", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void viewCars(){
        searchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor show = myDB.showCar();
                        if(show.getCount() == 0){
                            showMessage("Error", "Nothing found");
                            Toast.makeText(MainActivity.this, "Show Car Error / Empty", Toast.LENGTH_SHORT).show();
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(show.moveToNext()){
                            buffer.append("Id : " + show.getString(0) + "\n");
                            buffer.append("Model : " + show.getString(1) + "\n");
                            buffer.append("Year : " + show.getString(2) + "\n");
                            buffer.append("Price : " + show.getString(3) + "\n");
                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
=======

>>>>>>> Stashed changes
}
