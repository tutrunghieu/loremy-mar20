package com.silkroadpacific.loremy.gui.menu;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.physical.Tab_Product;

import java.util.List;

/**
 * Created by Andy on 4/5/2017.
 */

public class MenuAdapter extends ArrayAdapter<Tab_Product> {

    public List<Tab_Product> products;
    public Activity act;
    public int layout;

    public MenuAdapter(Activity _act, int _layout, List<Tab_Product> _products) {
        super(_act, _layout, _products);
        this.act = _act;
        this.layout = _layout;
        this.products = _products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
        }

        return convertView;
    }
}
