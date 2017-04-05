package com.silkroadpacific.loremy.gui.user;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silkroadpacific.loremy.R;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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
//            Button btn = new Button(getActivity());
//            btn.setText("Button " + k);
//            btn.setLayoutParams(new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT));
//            ll.addView(btn);

            TextView tk = new TextView(getActivity());

            tk.setText("Ngoc trinh " + k);

            tk.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            ll.addView(tk);

            ImageView vk = new ImageView(getActivity());

            Glide.with(getActivity())
                    .load("http://sohanews.sohacdn.com/k:2016/18-1461210229609/mat-qua-xinh-nhung-ngoc-trinh-se-xau-ho-khi-nhin-lai-hinh-anh-nay.jpg")
                    .into(vk);

            vk.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            ll.addView(vk);
        }

        return v;
    }

    private Bitmap getBitmap()
    {
        String url = "http://sohanews.sohacdn.com/k:2016/18-1461210229609/mat-qua-xinh-nhung-ngoc-trinh-se-xau-ho-khi-nhin-lai-hinh-anh-nay.jpg";


        try {
        URL newurl = new URL(url);
        return BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Uri getImage()
    {
        String url = "http://sohanews.sohacdn.com/k:2016/18-1461210229609/mat-qua-xinh-nhung-ngoc-trinh-se-xau-ho-khi-nhin-lai-hinh-anh-nay.jpg";
        try {
            //InputStream is = (InputStream) new URL(url).getContent();
            return Uri.parse(url);
            //return Drawable.createFromStream(is, "src name");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onClick(View v) {

    }
}
