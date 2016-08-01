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
import com.example.raulstriglio.ottotest.API.MyApiComponent;
import com.example.raulstriglio.ottotest.Events.CustomUserEvent;
import com.example.raulstriglio.ottotest.Utilities.MyBus;
import com.example.raulstriglio.ottotest.model.User;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class OttoFragment extends Fragment {

    private final String URL = "https://raw.githubusercontent.com/restriglio/OttoTest/master/json/info.json";
    private View fragmentView;
    private Button getData;

    @Inject MyApi myApi;
    private MyApiComponent myApiComponent;

    private Bus bus;
    private TextView id_name, id_lastname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.otto_fragment, container, false);
        getData = (Button) fragmentView.findViewById(R.id.getData);
        id_name = (TextView) fragmentView.findViewById(R.id.id_name);
        id_lastname = (TextView) fragmentView.findViewById(R.id.id_lastname);

        //myApi = MyApi.getInstanceMyApi(getContext());

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApi.readFromFile();
            }
        });
        return fragmentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((OttoTestApplication) getActivity().getApplication()).getComponent().inject(getContext());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(!(getActivity() instanceof ICallback)){
            throw new ClassCastException(getActivity().toString()
                    + getResources().getString(R.string.OttoFragmentError));
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        MyBus.getBus().register(this);
    }

    @Subscribe
    public void receiveData(CustomUserEvent event){
        User u = event.getUsers().get(0);
        if(u != null) {
            id_name.setText(u.getName());
            id_lastname.setText(u.getLast_name());
        }

        ((ICallback)getActivity()).initListActivity(event.getUsers());
    }

    @Override
    public void onPause() {
        super.onPause();
        MyBus.getBus().unregister(this);
    }

    public interface ICallback{
        void initListActivity(ArrayList<User> userList);
    }
}
