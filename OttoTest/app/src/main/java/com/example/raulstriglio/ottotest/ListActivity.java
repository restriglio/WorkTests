package com.example.raulstriglio.ottotest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.raulstriglio.ottotest.Utilities.DividerItemDecoration;
import com.example.raulstriglio.ottotest.model.UserProvider;
import com.example.raulstriglio.ottotest.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raul.striglio on 29/07/16.
 */
public class ListActivity extends Activity {

    public static final String EXTRA_KEY = "userList";
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<User> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = (ArrayList<User>) getIntent().getSerializableExtra(EXTRA_KEY);
        myDataset.addAll(UserProvider.GetData());

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset, getApplicationContext());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setAdapter(mAdapter);
    }

}
