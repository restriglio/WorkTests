package com.example.raulstriglio.ottotest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.raulstriglio.ottotest.API.MyApi;
import com.example.raulstriglio.ottotest.Events.CustomUserEvent;
import com.example.raulstriglio.ottotest.model.User;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class OttoFragment extends Fragment {

    private String URL = "https://raw.githubusercontent.com/restriglio/OttoTest/master/json/info.json";
    View fragmentView;
    Button getData;
    MyApi myApi;
    Bus bus;
    TextView id_name, id_lastname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.otto_fragment, container, false);

        getData = (Button) fragmentView.findViewById(R.id.getData);
        id_name = (TextView) fragmentView.findViewById(R.id.id_name);
        id_lastname = (TextView) fragmentView.findViewById(R.id.id_lastname);

        myApi = new MyApi(getContext());

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data
                myApi.sedRequest(URL);
            }
        });

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Subscribe
    public void receiveData(CustomUserEvent event){
        User u = event.getUser();

        if(u != null) {
            id_name.setText(u.getName());
            id_lastname.setText(u.getLast_name());
        }
    }
}
