package com.example.project;

import android.content.Context;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.app.FragmentManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class CustomPagerAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public CustomPagerAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AskQuestionFragment footballFragment = new AskQuestionFragment();
                return footballFragment;
            case 1:
                ViewQuestionsFragment cricketFragment = new ViewQuestionsFragment();
                return cricketFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }

}
