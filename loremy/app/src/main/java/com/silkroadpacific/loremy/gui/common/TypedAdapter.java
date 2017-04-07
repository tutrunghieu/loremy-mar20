package com.silkroadpacific.loremy.gui.common;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.physical.Tab_Post;

import java.util.List;

/**
 * Created by Andy on 4/5/2017.
 */

public class TypedAdapter<T> extends ArrayAdapter {

    private Activity act;
    private int layout;
    private List<T> posts;

    public TypedAdapter(Activity _act, int _layout, List<T> _posts) {
        super(_act, _layout, _posts);
        this.act = _act;
        this.layout = _layout;
        this.posts = _posts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

        tvTitle.setText(posts.get(position).toString());

        return convertView;
    }
}

