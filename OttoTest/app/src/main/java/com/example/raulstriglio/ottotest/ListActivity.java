package com.example.raulstriglio.ottotest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.raulstriglio.ottotest.Utilities.DividerItemDecoration;
import com.example.raulstriglio.ottotest.Utilities.GuavaUtils;
import com.example.raulstriglio.ottotest.model.Person;
import com.example.raulstriglio.ottotest.model.User;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by raul.striglio on 29/07/16.
 */
public class ListActivity extends Activity {

    public static final String EXTRA_KEY = "userList";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Person> listPerson;
    private ArrayList<User> myDataset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = (ArrayList<User>) getIntent().getSerializableExtra(EXTRA_KEY);
        listPerson = GuavaUtils.fluentExample(myDataset);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(listPerson, getApplicationContext());

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);

        mRecyclerView.setAdapter(mAdapter);


    }

}
