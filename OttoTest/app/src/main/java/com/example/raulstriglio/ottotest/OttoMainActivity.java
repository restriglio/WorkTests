package com.example.raulstriglio.ottotest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raulstriglio.ottotest.Fragments.DetailFragment;
import com.example.raulstriglio.ottotest.Fragments.OttoFragment;
import com.example.raulstriglio.ottotest.Fragments.OttoFragmentList;

import com.example.raulstriglio.ottotest.Fragments.backPressedCallBack;
import com.example.raulstriglio.ottotest.model.User;

import java.util.ArrayList;

public class OttoMainActivity extends AppCompatActivity
        implements OttoFragment.ICallback<User>, OttoFragmentList.callbackToFragmentList {

    public static final String EXTRA_KEY = "userList";
    public static int minBackstaskCount = 1;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_main);

        OttoFragment ottoFragment = OttoFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.FrameID, ottoFragment, ottoFragment.TAG);
        ft.addToBackStack(ottoFragment.TAG);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        ft.commit();
    }

    @Override
    public void initList(ArrayList<User> userList) {

        this.userList = userList;
        OttoFragmentList ottoListFragment = OttoFragmentList.newInstance();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.FrameID2, ottoListFragment, ottoListFragment.TAG);
        ft.addToBackStack(ottoListFragment.TAG);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public ArrayList<User> getList() {
        return this.userList;
    }

    @Override
    public void openItemDetail(User user) {

        DetailFragment detailFragment = DetailFragment.newInstance(user.getName(), user.getLastname());
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.FrameID, detailFragment, detailFragment.TAG);
        ft.addToBackStack(detailFragment.TAG);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        int backStackCount = getFragmentManager().getBackStackEntryCount();
        if (backStackCount > minBackstaskCount) {
            FragmentManager fragmentManager = getFragmentManager();
            String fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
            Fragment currentFragment = getFragmentManager().findFragmentByTag(fragmentTag);
            ((backPressedCallBack)currentFragment).fragmentBackPressed();
        }else{
            super.onBackPressed();
        }
    }

}
