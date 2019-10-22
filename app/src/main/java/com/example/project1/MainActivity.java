package com.example.project1;

//import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

//import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TabLayout mTabLayout;
    TabItem sell;
    TabItem buy;
    TabItem display;
    ViewPager mPager;
    PagerController mPagerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        mPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));  //causing the application to crash

    }
}
