package com.bing.constellation.fortunefrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bing.constellation.R;
import com.bing.constellation.been.ContentInfoBeen;

import java.util.List;


public class FortuneFragment extends Fragment {


    private GridView gv_fortune;
    private List<ContentInfoBeen.StarInfoBean> infoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fortune, container, false);
        gv_fortune = view.findViewById(R.id.gv_fortune);
        Bundle bundle = getArguments();
        ContentInfoBeen contentInfoBeen= (ContentInfoBeen) bundle.getSerializable("info");
        infoList = contentInfoBeen.getStarInfo();
        FortuneAdapter adapter = new FortuneAdapter(getContext(), infoList);
        gv_fortune.setAdapter(adapter);
        gv_fortune.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContentInfoBeen.StarInfoBean infoBean = infoList.get(position);
                String name = infoBean.getName();
                Intent intent=new Intent(getContext(),FortuneSecondActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });


        return view;
    }
}