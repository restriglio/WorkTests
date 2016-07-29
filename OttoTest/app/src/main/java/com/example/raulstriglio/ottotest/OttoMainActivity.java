package com.example.raulstriglio.ottotest;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OttoMainActivity extends AppCompatActivity {

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

}
