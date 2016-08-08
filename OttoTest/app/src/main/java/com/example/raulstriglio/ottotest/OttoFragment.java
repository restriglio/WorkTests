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
import com.example.raulstriglio.ottotest.Utilities.MyBus;
import com.example.raulstriglio.ottotest.model.User;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 28/07/16.
 */
public class OttoFragment extends Fragment {

    private final String URL = "https://raw.githubusercontent.com/restriglio/OttoTest/master/json/info.json";
    private View fragmentView;
    private Button getData;

    @Inject
    protected MyApi myApi;
    private TextView idName;
    private TextView idLastname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.otto_fragment, container, false);
        getData = (Button) fragmentView.findViewById(R.id.getData);
        idName = (TextView) fragmentView.findViewById(R.id.id_name);
        idLastname = (TextView) fragmentView.findViewById(R.id.id_lastname);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApi.readFromFile();
            }
        });
        return fragmentView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((OttoTestApplication) getActivity().getApplication()).getMyApiComponent().inject(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!(getActivity() instanceof ICallback)) {
            throw new ClassCastException(getActivity().toString()
                    + "must implement ICallback");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        MyBus.getBus().register(this);
    }

    @Subscribe
    public void receiveData(CustomUserEvent event) {

        if (event.getUsers() != null) {

            if (event.getUsers().size() > 0) {
                User u = event.getUsers().get(0);
                if (u != null) {
                    idName.setText(u.getName());
                    idLastname.setText(u.getLastname());
                }
            } else {
                idName.setText(getString(R.string.empty_item));
                idLastname.setText(getString(R.string.empty_item));
            }
        }
        ((ICallback) getActivity()).initListActivity(event.getUsers());
    }

    @Override
    public void onPause() {
        super.onPause();
        MyBus.getBus().unregister(this);
    }

    public interface ICallback {
        void initListActivity(ArrayList<User> userList);
    }
}
