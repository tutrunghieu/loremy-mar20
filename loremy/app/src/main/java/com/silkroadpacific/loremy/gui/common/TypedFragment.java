package com.silkroadpacific.loremy.gui.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.silkroadpacific.loremy.R;

import java.util.List;

public abstract class TypedFragment<T> extends Fragment implements AdapterView.OnItemClickListener
{
    protected TypedAdapter<T> mainAdapter;
    protected List<T> mainModel;

    protected ListView mainView;

    public TypedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        try {
            View v = inflater.inflate(R_layout_id(), container, false);

            mainAdapter = createAdapter(getActivity(), R_item_id(), getOperatingList());

            mainView.setAdapter(mainAdapter);
            mainView.setOnItemClickListener(this);

            return v;
        }

        catch(Exception xp) {
            return inflater.inflate(R.layout.fragment_menu, container, false);
        }
    }

    protected TypedAdapter<T> createAdapter(FragmentActivity act, int num, List<T> items)
    {
        TypedAdapter<T> res = new TypedAdapter<T>(act, num, items);
        return res;
    }

    @Override
    public abstract void onItemClick(AdapterView<?> adapterView, View view, int i, long l);

    public abstract List<T> getOperatingList();

    public abstract int R_layout_id();

    public abstract int R_item_id();
}
