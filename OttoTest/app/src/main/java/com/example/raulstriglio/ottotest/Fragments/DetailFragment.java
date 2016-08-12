package com.example.raulstriglio.ottotest.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raulstriglio.R;
import com.example.raulstriglio.ottotest.OttoMainActivity;

/**
 * Created by raul.striglio on 12/08/16.
 */
public class DetailFragment extends Fragment {

    public final String TAG = "DetailFragment";

    private View detailFragment;
    private TextView lastNameTxt;
    private TextView NameTxt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        detailFragment = inflater.inflate(R.layout.detail_fragment_layout,container,false);
        lastNameTxt = (TextView)detailFragment.findViewById(R.id.lastNameTxt);
        NameTxt = (TextView)detailFragment.findViewById(R.id.nameTxt);
        return detailFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        this.lastNameTxt.setText(bundle.get(OttoMainActivity.LAST_NAME_KEY).toString());
        this.NameTxt.setText(bundle.get(OttoMainActivity.NAME_KEY).toString());}
}
