package com.awi;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.awi.coronatracker.home.HomeFragment;

import com.awi.coronatracker.nestedtab.MapFragment;
import com.awi.coronatracker.news.NewsFragment;
import com.awi.coronatracker.notification.retrofit.NotificationFragment;
import com.awi.coronatracker.profile.retrofit.ProfileFragment;

import java.util.ArrayList;
import java.util.List;



public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }



    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new MapFragment();
        }else if(position==2){
            return new NotificationFragment();
        }else
            return new ProfileFragment();

    }

    @Override
    public int getCount() {
        return 4;
    }
}