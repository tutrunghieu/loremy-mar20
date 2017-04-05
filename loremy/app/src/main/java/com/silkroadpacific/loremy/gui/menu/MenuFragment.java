package com.silkroadpacific.loremy.gui.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.gui.BaseFragment;
import com.silkroadpacific.loremy.physical.Tab_Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MenuFragment extends Fragment implements View.OnClickListener {

    private String[] params;
    private MenuAdapter adapter;
    private List<Tab_Product> products;

    public GridView gridMenu;

    public MenuFragment() {

    }

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

        products = new ArrayList<Tab_Product>();
        for(int i = 0; i < 10; i++)
        {
            Tab_Product p = new Tab_Product();
            products.add(p);
        }

        adapter = new MenuAdapter(getActivity(), R.layout.item_menu, products);
        gridMenu.setAdapter(adapter);

        gridMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }



    @Override
    public void onClick(View v) {

    }

}
