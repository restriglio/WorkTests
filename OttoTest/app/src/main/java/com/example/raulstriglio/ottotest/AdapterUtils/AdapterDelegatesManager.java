package com.example.raulstriglio.ottotest.AdapterUtils;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.raulstriglio.ottotest.model.User;


/**
 * Created by raul.striglio on 04/08/16.
 */
public class AdapterDelegatesManager<T> {

    private SparseArrayCompat<AdapterDelegate<T>> listDelegates;

    public AdapterDelegatesManager(){
        listDelegates = new SparseArrayCompat();
    }

    public AdapterDelegatesManager<T> addDelegate(@NonNull AdapterDelegate<T> delegate, int viewType) {
        listDelegates.put(viewType, delegate);
        return this;
    }

    public void removeDelegate(@NonNull AdapterDelegate<T> delegate) {
        int index = listDelegates.indexOfValue(delegate);
        if (index >= 0)
            listDelegates.removeAt(index);
    }

    public int getItemViewType(@NonNull T items, int position) {

        if (items == null) {
            throw new NullPointerException("Items datasource is null!");
        }

        int delegatesCount = listDelegates.size();
        for (int i = 0; i < delegatesCount; i++) {
            AdapterDelegate<T> delegate = listDelegates.valueAt(i);

            if (delegate.isForViewType(items, position, User.USER_TYPE_1)) {
                return User.USER_TYPE_1;
            }
            if (delegate.isForViewType(items, position, User.USER_TYPE_2)) {
                return User.USER_TYPE_2;
            }
            if (delegate.isForViewType(items, position, User.USER_TYPE_3)) {
                return User.USER_TYPE_3;
            }
        }

        throw new NullPointerException(
                "No AdapterDelegate added that matches position=" + position + " in data source");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterDelegate<T> delegate = listDelegates.get(viewType);
        return delegate.onCreateViewHolder(parent);
    }

    public void onBindViewHolder(@NonNull T items, int position, @NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> delegate = listDelegates.get(viewHolder.getItemViewType());
        delegate.onBindViewHolder(items, position, viewHolder);
    }

}
