package com.silkroadpacific.loremy.gui.outlet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silkroadpacific.loremy.R;

import java.util.Map;


public class OutletFragment extends Fragment implements View.OnClickListener{

    private String[] params;

    public OutletFragment() {}

    public static OutletFragment newInstance(Map<String, String> params) {
        OutletFragment fragment = new OutletFragment();
        Bundle args = new Bundle();
        for(String sk: params.keySet()) args.putString(sk, params.get(sk));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_outlet, container, false);

        return v;
    }

    @Override
    public void onClick(View v) {

    }
}
