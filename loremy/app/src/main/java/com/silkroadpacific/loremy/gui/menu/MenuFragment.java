package com.silkroadpacific.loremy.gui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.gui.common.BaseFragment;
import com.silkroadpacific.loremy.gui.common.TypedAdapter;
import com.silkroadpacific.loremy.gui.common.TypedFragment;
import com.silkroadpacific.loremy.physical.Tab_Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MenuFragment extends TypedFragment<Tab_Product>
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        mainAdapter = new TypedAdapter<Tab_Product>(getActivity(), R.layout.item_menu, getOperatingList());

        try {
            mainView.setAdapter(mainAdapter);
            mainView.setOnItemClickListener(this);
        } catch (Exception xp) {
            xp.printStackTrace();
        }

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), MenuDetailActivity.class);
        intent.putExtra("parent", i + "/" + l);
        startActivity(intent);
    }

    @Override
    public List<Tab_Product> getOperatingList()
    {
        List<Tab_Product> products = new ArrayList<Tab_Product>();
        for(int i = 0; i < 10; i++)
        {
            Tab_Product p = new Tab_Product();
            products.add(p);
        }

        return products;
    }

    @Override
    public int R_layout_id() {
        return R.layout.fragment_menu;
    }

    @Override
    public int R_item_id() {
        return R.layout.item_menu;
    }
//
//    private String[] params;
//    private MenuAdapter adapter;
//    private List<Tab_Product> products;
//
//    public GridView gridMenu;
//
//    public MenuFragment() {
//
//    }
//
    public static MenuFragment newInstance(Map<String, String> params) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        for(String sk: params.keySet()) args.putString(sk, params.get(sk));
        fragment.setArguments(args);
        return fragment;
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            //mParam1 = getArguments().getString(ARG_PARAM1);
//            //mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_menu, container, false);
//        BaseFragment.bindId(this, v);
//
//        products = new ArrayList<Tab_Product>();
//        for(int i = 0; i < 10; i++)
//        {
//            Tab_Product p = new Tab_Product();
//            products.add(p);
//        }
//
//        adapter = new MenuAdapter(getActivity(), R.layout.item_menu, products);
//        gridMenu.setAdapter(adapter);
//
//        gridMenu.setOnItemClickListener(this);
//
//        return v;
//    }
//
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//    {
//        Intent intent = new Intent(getActivity(), MenuDetailActivity.class);
//        intent.putExtra("parent", position + "/" + id);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onClick(View v)
//    {
//
//    }

}
