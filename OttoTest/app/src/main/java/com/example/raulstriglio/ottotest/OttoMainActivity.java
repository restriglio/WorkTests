package com.example.raulstriglio.ottotest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raulstriglio.ottotest.Fragments.DetailFragment;
import com.example.raulstriglio.ottotest.Fragments.OttoFragment;
import com.example.raulstriglio.ottotest.Fragments.OttoFragmentList;

import com.example.raulstriglio.ottotest.model.User;

import java.util.ArrayList;

public class OttoMainActivity extends AppCompatActivity implements OttoFragment.ICallback<User>, OttoFragmentList.CallbackToFragmentList {

    public static final String EXTRA_KEY = "userList";

    public static final String NAME_KEY = "name";
    public static final String LAST_NAME_KEY = "lastname";

    OttoFragment ottoFragment = new OttoFragment();
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.FrameID, ottoFragment, ottoFragment.TAG);
        ft.addToBackStack(ottoFragment.TAG);
        ft.commit();

    }

    @Override
    public void initListActivity(ArrayList<User> userList) {

        this.userList = userList;
        OttoFragmentList ottoListFragment = new OttoFragmentList();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_KEY, "From Activity");
        ottoListFragment.setArguments(bundle);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.FrameID2, ottoListFragment, ottoListFragment.TAG);
        ft.addToBackStack(ottoListFragment.TAG);
        ft.commit();
    }

    @Override
    public ArrayList<User> getList() {
        return this.userList;
    }

    @Override
    public void openItemDetail(User user) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, user.getName());
        bundle.putString(LAST_NAME_KEY, user.getLastname());
        detailFragment.setArguments(bundle);

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(R.id.FrameID2, detailFragment, detailFragment.TAG);
        ft.addToBackStack(detailFragment.TAG);
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        int backStackCount = getFragmentManager().getBackStackEntryCount();
        if(backStackCount > 0) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();

            String name = manager.getBackStackEntryAt(backStackCount-1).getName();
            Fragment currentFragment = manager.findFragmentByTag(name);

            trans.remove(currentFragment);
            trans.commit();
            manager.popBackStack();
        }else{
            super.onBackPressed();
        }

    }
}
