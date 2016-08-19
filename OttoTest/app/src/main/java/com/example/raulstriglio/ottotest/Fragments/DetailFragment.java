package com.example.raulstriglio.ottotest.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raulstriglio.ottotest.R;

/**
 * Created by raul.striglio on 12/08/16.
 */
public class DetailFragment extends BaseFragment {

    public final String TAG = "DetailFragment";
    public static final String NAME_KEY = "name";
    public static final String LAST_NAME_KEY = "lastname";

    private View detailFragment;
    private TextView lastNameTxt;
    private TextView nameTxt;

    public static DetailFragment newInstance(String name, String lastName) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, name);
        bundle.putString(LAST_NAME_KEY, lastName);
        detailFragment.setArguments(bundle);

        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        detailFragment = inflater.inflate(R.layout.detail_fragment_layout, container, false);
        lastNameTxt = (TextView) detailFragment.findViewById(R.id.lastNameTxt);
        nameTxt = (TextView) detailFragment.findViewById(R.id.nameTxt);
        return detailFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.lastNameTxt.setText(bundle.get(LAST_NAME_KEY).toString());
            this.nameTxt.setText(bundle.get(NAME_KEY).toString());
        }
    }


}
