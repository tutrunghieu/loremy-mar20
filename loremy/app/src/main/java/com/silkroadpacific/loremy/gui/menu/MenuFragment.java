package com.silkroadpacific.loremy.gui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.gui.BaseFragment;

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

        GridView gridView = (GridView)v.findViewById(R.id.menu);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, Arrays.asList("a", "b", "c") );


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //Button btnDetails = (Button) v.findViewById(R.id.btnDetails);
//        btnDetails.setOnClickListener(this);
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
