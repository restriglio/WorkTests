package com.example.raulstriglio.ottotest;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raulstriglio.ottotest.model.User;

import java.util.ArrayList;
import java.util.List;

public class OttoMainActivity extends AppCompatActivity implements OttoFragment.ICallback {

    OttoFragment ottoFragment = new OttoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.FrameID,ottoFragment);
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void initListActivity(ArrayList<User> userList) {
        Intent intent = new Intent(getApplicationContext(),ListActivity.class);
        intent.putExtra("userList",userList);
        startActivity(intent);
    }
}
