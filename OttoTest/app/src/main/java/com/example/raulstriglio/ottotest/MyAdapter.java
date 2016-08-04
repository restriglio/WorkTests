package com.example.raulstriglio.ottotest;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raulstriglio.ottotest.Utilities.CircleTransform;
import com.example.raulstriglio.ottotest.model.User;
import com.squareup.picasso.Picasso;

import static com.example.raulstriglio.ottotest.model.User.USER_TYPE_1;
import static com.example.raulstriglio.ottotest.model.User.USER_TYPE_2;
import static com.example.raulstriglio.ottotest.model.User.USER_TYPE_3;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final String IMAGE_PATH = "file:///android_asset/image.jpg";
    private final String IMAGE_PATH2 = "file:///android_asset/DvpvklR.jpg";
    private final String IMAGE_PATH3 = "file:///android_asset/images.jpg";

    private List<User> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class User1ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtHeader;
        private TextView txtFooter;
        private ImageView icon;

        public User1ViewHolder(View v) {
            super(v);
            this.txtHeader = (TextView) v.findViewById(R.id.firstLine);
            this.txtFooter = (TextView) v.findViewById(R.id.secondLine);
            this.icon = (ImageView) v.findViewById(R.id.icon);
        }
    }

    public static class User2ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView lastName;
        private ImageView iconImage;

        public User2ViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.name);
            this.lastName = (TextView) v.findViewById(R.id.lastName);
            this.iconImage = (ImageView) v.findViewById(R.id.iconImage);
        }
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

    @Override
    public int getItemViewType(int position) {

        int resultType = 0;

        if (mDataset != null) {
            User object = mDataset.get(position);
            if (object != null) {
                resultType = object.getType();
            }
        }
        return resultType;
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

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<User> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case USER_TYPE_1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new User1ViewHolder(v);
            case USER_TYPE_2:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2, parent, false);
                return new User2ViewHolder(v);
            case USER_TYPE_3:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item3, parent, false);
                return new User3ViewHolder(v);
        }
        return null;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final User element = mDataset.get(position);

        switch (element.getType()) {
            case USER_TYPE_1:
                initUser1Layout((User1ViewHolder) holder, position);
                break;
            case USER_TYPE_2:
                initUser2Layout((User2ViewHolder) holder, position);
                break;
            case USER_TYPE_3:
                initUser3Layout((User3ViewHolder) holder, position);
                break;

        }
    }

    private void initUser3Layout(User3ViewHolder holder, final int position) {

        User user = mDataset.get(position);

        holder.name.setText(user.getName());
        holder.lastName.setText(user.getLastname());

        Picasso.with(context).load(IMAGE_PATH3).transform(new CircleTransform()).into(holder.iconImage, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
                Toast.makeText(context, context.getString(R.string.picasso_error_msg), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUser2Layout(User2ViewHolder holder, final int position) {

        User user = mDataset.get(position);

        holder.name.setText(user.getName());
        holder.lastName.setText(user.getLastname());

        Picasso.with(context).load(IMAGE_PATH2).transform(new CircleTransform()).into(holder.iconImage, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
                Toast.makeText(context, context.getString(R.string.picasso_error_msg), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUser1Layout(User1ViewHolder holder, final int position) {

        User user = mDataset.get(position);

        holder.txtHeader.setText(user.getLastname());
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, context.getString(R.string.click_string) + position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.txtFooter.setText(context.getString(R.string.name_listItem) + user.getName() + " " + user.getLastname());
        Picasso.with(context).load(IMAGE_PATH).placeholder(R.mipmap.ic_launcher)
                .into(holder.icon, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(context, context.getString(R.string.picasso_error_msg), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}