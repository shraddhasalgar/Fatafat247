package com.sattakhelo.mtk;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class TransferTabAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TransferTabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                all_transaction homeFragment = new all_transaction();
                return homeFragment;
            case 1:
                in_transaction sportFragment = new in_transaction();
                return sportFragment;
            case 2:
                out_transaction movieFragment = new out_transaction();
                return movieFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}