package com.silkroadpacific.loremy.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.silkroadpacific.loremy.MenuDetailActivity;
import com.silkroadpacific.loremy.R;

import java.util.Map;


public class MenuFragment extends Fragment implements View.OnClickListener {

    private String[] params;

    public Button btnDetails;

    public MenuFragment() {}

    public static MenuFragment newInstance(Map<String, String> params) {
        MenuFragment fragment = new MenuFragment();
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
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        BaseFragment.bindId(this, v);

        //Button btnDetails = (Button) v.findViewById(R.id.btnDetails);

        return v;
    }


    @Override
    public void onClick(View v) {
        if(v == btnDetails) {
            Intent intent = new Intent(getActivity(), MenuDetailActivity.class);
            startActivity(intent);
        }
    }
}
