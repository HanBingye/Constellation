package com.bing.constellation.confrag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bing.constellation.R;
import com.bing.constellation.been.ContentInfoBeen;

import java.util.ArrayList;
import java.util.List;


public class ConFragment extends Fragment {


    private ViewPager vp_con;
    private LinearLayout ll_con;
    private GridView gv_con;
    private List<ContentInfoBeen.StarInfoBean> dataList;
    private List<ImageView> ivList;
    private List<ImageView> pointList;
    int[] imgs = { R.mipmap.xingzuo,R.mipmap.pic_con};
    private ConTopAdapter conTopAdapter;
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
           if(msg.what==1){
               int currentItem = vp_con.getCurrentItem();
               if(currentItem==pointList.size()-1){
                   vp_con.setCurrentItem(0);
               }else{
                   currentItem++;
                   vp_con.setCurrentItem(currentItem);
               }
               handler.sendEmptyMessageDelayed(1,5000);
           }
        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_con, container, false);

        initView(view);
        initPager();
        vp_con.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < pointList.size(); i++) {
                    pointList.get(i).setImageResource(R.mipmap.point_normal);
                }
                pointList.get(position).setImageResource(R.mipmap.point_focus);
            }
        });
        Bundle bundle = getArguments();
        ContentInfoBeen contentInfoBeen = (ContentInfoBeen) bundle.getSerializable("info");
        dataList = contentInfoBeen.getStarInfo();
        ConAdapter conAdapter = new ConAdapter(getContext(), dataList);
        gv_con.setAdapter(conAdapter);
        gv_con.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 ContentInfoBeen.StarInfoBean starInfoBean= dataList.get(position);
                Intent intent=new Intent(getContext(),ConSecondActivity.class);
                intent.putExtra("con",starInfoBean);
                startActivity(intent);
            }
        });
        handler.sendEmptyMessageDelayed(1, 5000);
        return view;
    }

    private void initPager() {
        ivList = new ArrayList<>();
        pointList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(imgs[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            iv.setLayoutParams(layoutParams1);
            ivList.add(iv);
            ImageView pointIv = new ImageView(getContext());
            pointIv.setImageResource(R.mipmap.point_normal);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams2.setMargins(20, 0, 0, 0);
            pointIv.setLayoutParams(layoutParams2);
            ll_con.addView(pointIv);
            pointList.add(pointIv);
        }
        pointList.get(0).setImageResource(R.mipmap.point_focus);
        conTopAdapter = new ConTopAdapter(getContext(), ivList);
        vp_con.setAdapter(conTopAdapter);
    }

    private void initView(View view) {
        vp_con = view.findViewById(R.id.vp_con);
        ll_con = view.findViewById(R.id.ll_con);
        gv_con = view.findViewById(R.id.gv_con);
    }
}