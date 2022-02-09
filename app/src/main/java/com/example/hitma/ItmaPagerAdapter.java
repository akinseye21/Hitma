package com.example.hitma;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ItmaPagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;

    public ItmaPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                InecDashboards inecDashboards = new InecDashboards();
                return  inecDashboards;
            case 1:
                ProgressReport progressReport = new ProgressReport();
                return progressReport;
            case 2:
                Notification notification = new Notification();
                return notification;
            case 3:
                InecHotlines inecHotlines = new InecHotlines();
                return inecHotlines;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
