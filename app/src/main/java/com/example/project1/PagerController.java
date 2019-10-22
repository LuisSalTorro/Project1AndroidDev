package com.example.project1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
//
// import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;




public class PagerController extends FragmentStatePagerAdapter {
    int tabCount;

//    public PagerController(FragmentManager fm, int tabCounts) {
//        super(fm);
//        this.tabCount = tabCounts;
//    }
    //BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    public PagerController(FragmentManager fm, int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabCount = 3;
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new sell();
            case 1:
                return new buy();
            case 2:
                return new display();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.tabCount;
    }
}
