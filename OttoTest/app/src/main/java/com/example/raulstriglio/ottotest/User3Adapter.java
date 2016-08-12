package com.example.raulstriglio.ottotest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raulstriglio.ottotest.AdapterUtils.AdapterDelegate;
import com.example.raulstriglio.ottotest.Utilities.CircleTransform;
import com.example.raulstriglio.ottotest.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by raul.striglio on 04/08/16.
 */
public class User3Adapter implements AdapterDelegate<List<User>> {

    private final String IMAGE_PATH3 = "file:///android_asset/images.jpg";
    private Context context;

    public User3Adapter(Context context) {
        this.context = context;
    }


    @Override
    public boolean isForViewType(@NonNull List<User> items, int position, int viewType) {
        return items.get(position).getType() == viewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item3, parent, false);
        return new User3ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull List<User> items, int position, @NonNull RecyclerView.ViewHolder holder) {

        User3ViewHolder u3Holder = (User3ViewHolder) holder;
        User user = items.get(position);

        u3Holder.name.setText(user.getName());
        u3Holder.lastName.setText(user.getLastname());

        Picasso.with(context).load(IMAGE_PATH3).transform(new CircleTransform())
                .into(u3Holder.iconImage, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(context, context.getString(R.string.picasso_error_msg), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public static class User3ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView lastName;
        private ImageView iconImage;

        public User3ViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.name);
            this.lastName = (TextView) v.findViewById(R.id.lastName);
            this.iconImage = (ImageView) v.findViewById(R.id.iconImage);
        }
    }
}
