package com.silkroadpacific.loremy.gui.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.silkroadpacific.loremy.R;
import com.silkroadpacific.loremy.gui.common.TypedFragment;
import com.silkroadpacific.loremy.physical.Tab_Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostFragment extends TypedFragment<Tab_Post>
{
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_post, container, false);
//        BaseFragment.bindId(this, v);
//
//        adapter = new PostAdapter(getActivity(), R.layout.item_post, findPosts());
//        listPost.setAdapter(adapter);
//        listPost.setOnItemClickListener(this);
//
//        return v;
//    }

    public static PostFragment newInstance(Map<String, String> params) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        for(String sk: params.keySet()) args.putString(sk, params.get(sk));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Intent intent = new Intent(getActivity(), PostDetailActivity.class);
        intent.putExtra("parent", i + "/" + l);
        startActivity(intent);
    }

    @Override
    public List<Tab_Post> getOperatingList()
    {
        List<Tab_Post> res = new ArrayList<>();
        for(int k=0; k<10; k++) res.add(new Tab_Post());
        return res;
    }

    @Override
    public int R_layout_id() {
        return R.layout.fragment_post;
    }

    @Override
    public int R_item_id() {
        return R.layout.item_post;
    }


}
