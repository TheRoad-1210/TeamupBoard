package com.example.teamupboard.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.teamupboard.ui.home.CardFragment;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] titleArray;
    private List<CardFragment> listFragments = new ArrayList<>();

    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public TabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }


    public void addFragment(CardFragment fragment){
        listFragments.add(fragment);
    }

    public void setTitleArray(String[] titleArray) {
        this.titleArray = titleArray;
    }

    public void setListFragments(List<CardFragment> listFragments) {
        this.listFragments = listFragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleArray.length != 0 ? titleArray[position] :"";
    }
}
