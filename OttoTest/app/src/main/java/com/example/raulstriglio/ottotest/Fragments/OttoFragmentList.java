package com.example.raulstriglio.ottotest.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raulstriglio.R;
import com.example.raulstriglio.ottotest.MyAdapter;
import com.example.raulstriglio.ottotest.Utilities.DaggerDividerItemDecorationComponent;
import com.example.raulstriglio.ottotest.Utilities.DividerItemDecorationModule;
import com.example.raulstriglio.ottotest.model.User;
import com.example.raulstriglio.ottotest.model.UserProvider;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 12/08/16.
 */
public class OttoFragmentList extends Fragment {

    public final String TAG = "OttoFragmentList";
    View fragmentView;

    public static final String EXTRA_KEY = "userList";
    private RecyclerView mRecyclerView;
    private MyAdapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<User> myDataset;
    @Inject
    protected RecyclerView.ItemDecoration itemDecoration;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.detail_list,container,false);

        mRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(!(getActivity() instanceof CallbackToFragmentList)){
            throw new ClassCastException(getActivity().toString()
                    + "must implement CallbackToFragmentList");
        }

        myDataset = ((OttoFragment.ICallback<User>)getActivity()).getList();
        myDataset.addAll(UserProvider.GetData());

        listAdapter = new MyAdapter(myDataset, getContext(),(CallbackToFragmentList)getActivity());
        itemDecoration = DaggerDividerItemDecorationComponent
                .builder().dividerItemDecorationModule(new DividerItemDecorationModule(getContext()))
                .build().dividerItemDecoration();

        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setAdapter(listAdapter);
    }

    public interface CallbackToFragmentList{
        void openItemDetail(User user);
    }
}
