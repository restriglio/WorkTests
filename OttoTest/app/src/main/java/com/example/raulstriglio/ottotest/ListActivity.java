package com.example.raulstriglio.ottotest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.raulstriglio.ottotest.Utilities.DividerItemDecoration;
import com.example.raulstriglio.ottotest.model.User;

import java.util.ArrayList;

/**
 * Created by raul.striglio on 29/07/16.
 */
public class ListActivity extends Activity {

    private final String EXTRA_KEY = "userList";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
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

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset,getApplicationContext());

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);

        mRecyclerView.setAdapter(mAdapter);


    }
}
