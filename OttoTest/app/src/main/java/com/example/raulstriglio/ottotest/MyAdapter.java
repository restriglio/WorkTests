package com.example.raulstriglio.ottotest;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.raulstriglio.ottotest.AdapterUtils.AdapterDelegatesManager;
import com.example.raulstriglio.ottotest.Fragments.OttoFragmentList;
import com.example.raulstriglio.ottotest.model.User;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private AdapterDelegatesManager<List<User>> adaptersManager;
    private List<User> mDataset;
    private Context context;

    OttoFragmentList.callbackToFragmentList callbackToFragmentList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<User> myDataset, Context context, OttoFragmentList.callbackToFragmentList callbackToFragmentList) {
        mDataset = myDataset;
        this.context = context;
        adaptersManager = new AdapterDelegatesManager<>();
        adaptersManager.addDelegate(new User1Adapter(context), User.USER_TYPE_1);
        adaptersManager.addDelegate(new User2Adapter(context), User.USER_TYPE_2);
        adaptersManager.addDelegate(new User3Adapter(context), User.USER_TYPE_3);
        this.callbackToFragmentList = callbackToFragmentList;
    }


    @Override
    public int getItemViewType(int position) {
        return adaptersManager.getItemViewType(mDataset, position);
    }

    public void removeAllData() {
        mDataset.removeAll(mDataset);
        notifyDataSetChanged();
    }

    public void insertAllNewData(List<User> mNewDataSet) {
        mDataset.addAll(mNewDataSet);
        notifyDataSetChanged();
    }

    public void add(int position, User item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(User item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return adaptersManager.onCreateViewHolder(parent, viewType);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = mDataset.get(position);
                callbackToFragmentList.openItemDetail(user);
            }
        });
        adaptersManager.onBindViewHolder(mDataset, position, holder);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}