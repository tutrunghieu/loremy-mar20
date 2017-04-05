package com.silkroadpacific.loremy.gui.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.gui.common.BaseFragment;

import java.lang.reflect.Field;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class OrderFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.btnTren1)
    Button btnTren1;
    @BindView(R.id.btnTren2)
    Button btnTren2;
    @BindView(R.id.btnDuoi1)
    Button btnDuoi1;
    @BindView(R.id.btnDuoi2)
    Button btnDuoi2;
    @BindView(R.id.btnDuoi3)
    Button btnDuoi3;
    Unbinder unbinder;
    private String[] params;


    public OrderFragment() {
    }


    public static OrderFragment newInstance(Map<String, String> params) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();

        for (String sk : params.keySet()) args.putString(sk, params.get(sk));
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
        View v = inflater.inflate(R.layout.fragment_order, container, false);

        BaseFragment.bindId(this, v);

        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onClick(View v) {
//        if (v == btnTren1)
//            Toast.makeText(getActivity(), ((Button) v).getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnTren1)
    public void onBtnTren1Clicked() {
    }

    @OnClick(R.id.btnTren2)
    public void onBtnTren2Clicked() {

    }

    @OnClick(R.id.btnDuoi1)
    public void onBtnDuoi1Clicked() {
    }

    @OnClick(R.id.btnDuoi2)
    public void onBtnDuoi2Clicked() {
    }

    @OnClick(R.id.btnDuoi3)
    public void onBtnDuoi3Clicked() {
    }

    public static void main1(String[] args) throws Exception{
        for(Field fj: R.id.class.getFields())
        if(fj.getName().startsWith("btn"))
        {
            System.out.println(fj.getName());
        }

    }
}
