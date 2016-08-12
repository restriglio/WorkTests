package com.example.raulstriglio.ottotest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raulstriglio.ottotest.AdapterUtils.AdapterDelegate;
import com.example.raulstriglio.ottotest.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by raul.striglio on 04/08/16.
 */
public class User1Adapter implements AdapterDelegate<List<User>> {

    private final String IMAGE_PATH = "file:///android_asset/image.jpg";
    private Context context;

    public User1Adapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean isForViewType(@NonNull List<User> items, int position, int viewType) {
        return items.get(position).getType() == viewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new User1ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull List<User> items, int position, @NonNull RecyclerView.ViewHolder holder) {

        User1ViewHolder u1Holder = (User1ViewHolder) holder;
        User user = items.get(position);

        u1Holder.txtHeader.setText(user.getLastname());
        u1Holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        u1Holder.txtFooter.setText(String.format(context.getResources().getString(R.string.name_listItem), user.getName(), user.getLastname()));
        Picasso.with(context).load(IMAGE_PATH).placeholder(R.mipmap.ic_launcher)
                .into(u1Holder.icon, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class User1ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView icon;

        public User1ViewHolder(View v) {
            super(v);
            this.txtHeader = (TextView) v.findViewById(R.id.firstLine);
            this.txtFooter = (TextView) v.findViewById(R.id.secondLine);
            this.icon = (ImageView) v.findViewById(R.id.icon);
        }
    }
}
