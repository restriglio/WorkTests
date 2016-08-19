package com.example.raulstriglio.ottotest.Fragments;

import android.app.Fragment;

/**
 * Created by raul.striglio on 19/08/16.
 */
public class BaseFragment extends Fragment implements backPressedCallBack {

    @Override
    public void fragmentBackPressed() {
        getFragmentManager().popBackStackImmediate();
    }
}
