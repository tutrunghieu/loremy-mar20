package com.silkroadpacific.loremy.gui.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.silkroadpacific.loremy.R;

import java.util.Map;

public class UserFragment extends Fragment implements View.OnClickListener {

    private String[] params;

    public UserFragment() {

    }

    public static UserFragment newInstance(Map<String, String> params) {
        UserFragment fragment = new UserFragment();
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
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        LinearLayout ll = (LinearLayout)v.findViewById(R.id.layout_user);

        for(int k=0; k<100; k++)
        {
            Button btn = new Button(getActivity());
            btn.setText("Button " + k);
            btn.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            ll.addView(btn);
        }

        return v;
    }

    @Override
    public void onClick(View v) {

    }
}
