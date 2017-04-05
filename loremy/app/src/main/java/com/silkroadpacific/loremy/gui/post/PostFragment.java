package com.silkroadpacific.loremy.gui.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.gui.BaseFragment;
import com.silkroadpacific.loremy.physical.Tab_Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostFragment extends Fragment implements View.OnClickListener {

    private String[] params;
    private PostAdapter adapter;
    private List<Tab_Post> posts;

    public ListView listPost;

    public PostFragment() {
        // Required empty public constructor
    }

    public static PostFragment newInstance(Map<String, String> params) {
        PostFragment fragment = new PostFragment();
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
        View v = inflater.inflate(R.layout.fragment_post, container, false);
        BaseFragment.bindId(this, v);
        posts = new ArrayList<>();
        for(int i = 0; i < 8; i++)
        {
            posts.add(new Tab_Post());
        }

        adapter = new PostAdapter(getActivity(), R.layout.item_post, posts);
        listPost.setAdapter(adapter);

        return v;
    }

    @Override
    public void onClick(View v) {

    }
}
