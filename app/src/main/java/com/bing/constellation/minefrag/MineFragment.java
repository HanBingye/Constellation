package com.bing.constellation.minefrag;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bing.constellation.R;
import com.bing.constellation.been.ContentInfoBeen;
import com.bing.constellation.fortunefrag.FortuneAdapter;
import com.bing.constellation.utils.getData;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class MineFragment extends Fragment {


    private CircleImageView civ_mine;
    private TextView tv_mine;
    private Map<String, Bitmap> map;
    private List<ContentInfoBeen.StarInfoBean> listData;
    private SharedPreferences pref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        civ_mine = view.findViewById(R.id.civ_mine);
        tv_mine = view.findViewById(R.id.tv_mine);
        Bundle bundle = getArguments();
        ContentInfoBeen contentInfoBeen = (ContentInfoBeen) bundle.getSerializable("info");
        listData = contentInfoBeen.getStarInfo();
        pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        String name = pref.getString("name", "白羊座");
        String logoName = pref.getString("logoName", "baiyang");
        tv_mine.setText(name);
        map = getData.getContentLogo();
        Bitmap bitmap = map.get(logoName);
        civ_mine.setImageBitmap(bitmap);
        civ_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        return view;
    }
    private void showDialog(){
        Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine, null);

        dialog.setContentView(dialogView);

        GridView gv_mine = dialogView.findViewById(R.id.gv_mine);
        FortuneAdapter adapter = new FortuneAdapter(getContext(), listData);
        gv_mine.setAdapter(adapter);
        gv_mine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContentInfoBeen.StarInfoBean infoBean = listData.get(position);
                String name = infoBean.getName();
                tv_mine.setText(name);
                String logoName = infoBean.getLogoname();
                Bitmap bitmap = map.get(logoName);
                civ_mine.setImageBitmap(bitmap);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("name",name);
                editor.putString("logoName",logoName);
                editor.apply();
                dialog.cancel();
            }
        });

        dialog.show();
    }
}