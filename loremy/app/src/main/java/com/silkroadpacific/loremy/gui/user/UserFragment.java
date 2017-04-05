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

        String[] arr = {
                "coast_arnat59.jpg",
                "coast_art1130.jpg",
                "coast_art294.jpg",
                "coast_art487.jpg",
                "coast_bea1.jpg",
                "coast_bea10.jpg",
                "coast_bea14.jpg",
                "coast_bea2.jpg",
                "coast_bea20.jpg",
                "coast_bea24.jpg",
                "coast_bea26.jpg",
                "coast_bea27.jpg",
                "coast_bea29.jpg",
                "coast_bea3.jpg",
                "coast_bea30.jpg",
                "coast_bea33.jpg",
                "coast_bea38.jpg",
                "coast_bea39.jpg",
                "coast_bea4.jpg",
                "coast_bea5.jpg",
                "coast_bea9.jpg",
                "coast_cdmc1000.jpg",
                "coast_cdmc123.jpg",
                "coast_cdmc706.jpg",
                "coast_cdmc821.jpg",
                "coast_cdmc825.jpg",
                "coast_cdmc830.jpg",
                "coast_cdmc838.jpg",
                "coast_cdmc841.jpg",
                "coast_cdmc845.jpg",
                "coast_cdmc848.jpg",
                "coast_cdmc850.jpg",
                "coast_cdmc851.jpg",
                "coast_cdmc853.jpg",
                "coast_cdmc860.jpg",
                "coast_cdmc862.jpg",
                "coast_cdmc866.jpg",
                "coast_cdmc871.jpg",
                "coast_cdmc873.jpg",
                "coast_cdmc878.jpg",
                "coast_cdmc889.jpg",
                "coast_cdmc891.jpg",
                "coast_cdmc900.jpg",
                "coast_cdmc906.jpg",
                "coast_cdmc916.jpg",
                "coast_cdmc922.jpg",
                "coast_cdmc923.jpg",
                "coast_cdmc924.jpg",
                "coast_cdmc927.jpg",
                "coast_cdmc929.jpg",
                "coast_cdmc933.jpg",
                "coast_cdmc934.jpg",
                "coast_cdmc940.jpg",
                "coast_cdmc942.jpg",
                "coast_cdmc948.jpg",
                "coast_cdmc951.jpg",
                "coast_cdmc953.jpg",
                "coast_cdmc954.jpg",
                "coast_cdmc955.jpg",
                "coast_cdmc960.jpg",
                "coast_cdmc969.jpg",
                "coast_cdmc976.jpg",
                "coast_cdmc977.jpg",
                "coast_cdmc988.jpg",
                "coast_cdmc989.jpg",
                "coast_cdmc990.jpg",
                "coast_cdmc991.jpg",
                "coast_cdmc997.jpg",
                "coast_gre637.jpg",
                "coast_land100.jpg",
                "coast_land108.jpg",
                "coast_land111.jpg",
                "coast_land112.jpg",
                "coast_land113.jpg",
                "coast_land114.jpg",
                "coast_land115.jpg",
                "coast_land237.jpg",
                "coast_land253.jpg",
                "coast_land258.jpg",
                "coast_land261.jpg",
                "coast_land277.jpg",
                "coast_land296.jpg",
                "coast_land302.jpg",
                "coast_land309.jpg",
                "coast_land334.jpg",
                "coast_land339.jpg",
                "coast_land340.jpg",
                "coast_land341.jpg",
                "coast_land367.jpg",
                "coast_land368.jpg",
                "coast_land369.jpg",
                "coast_land370.jpg",
                "coast_land371.jpg",
                "coast_land372.jpg",
                "coast_land374.jpg",
                "coast_land386.jpg",
                "coast_land480.jpg",
                "coast_land623.jpg",
                "coast_land812.jpg",
                "coast_land897.jpg",
        };

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
                    .load("http://naebulae.org/sl/spatial-envelope-images/" + arr[k])
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
