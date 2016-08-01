package com.example.raulstriglio.ottotest;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raulstriglio.ottotest.model.User;
import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final String IMAGE_PATH = "file:///android_asset/image.jpg";
    private ArrayList<User> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView icon;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            icon = (ImageView) v.findViewById(R.id.icon);
        }
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

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<User> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final User name = mDataset.get(position);
        holder.txtHeader.setText(mDataset.get(position).getLast_name());
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(context,context.getString(R.string.click_string) + position,Toast.LENGTH_SHORT).show();
            }
        });
        holder.txtFooter.setText(context.getString(R.string.name_listItem) + mDataset.get(position).getName() + " " + mDataset.get(position).getLast_name());
        Picasso.with(context).load(IMAGE_PATH).placeholder(R.mipmap.ic_launcher)
                .into(holder.icon, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
                Toast.makeText(context,context.getString(R.string.picasso_error_msg),Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}