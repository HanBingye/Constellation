package com.bing.constellation.pairfrag;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.bing.constellation.R;
import com.bing.constellation.been.ContentInfoBeen;
import com.bing.constellation.utils.getData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PairFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    private ImageView iv_man;
    private ImageView iv_woman;
    private Spinner sp_man;
    private Spinner sp_woman;
    private Button bt_pair;
    private List<ContentInfoBeen.StarInfoBean> infoList;
    private List<String> nameList;
    private Map<String, Bitmap> map;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pair, container, false);
        initView(view);
        Bundle bundle = getArguments();
        ContentInfoBeen info = (ContentInfoBeen) bundle.getSerializable("info");
        infoList = info.getStarInfo();
        nameList = new ArrayList<>();
        for (int i = 0; i < infoList.size(); i++) {
            String name = infoList.get(i).getName();
            nameList.add(name);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.item_sp, R.id.tv_sp, nameList);
        sp_man.setAdapter(arrayAdapter);
        sp_woman.setAdapter(arrayAdapter);
        String logoName = infoList.get(0).getLogoname();
        map = getData.getContentLogo();
        Bitmap bitmap = map.get(logoName);
        iv_man.setImageBitmap(bitmap);
        iv_woman.setImageBitmap(bitmap);

        return view;
    }

    private void initView(View view) {
        iv_man = view.findViewById(R.id.iv_man);
        iv_woman = view.findViewById(R.id.iv_woman);
        sp_man = view.findViewById(R.id.sp_man);
        sp_woman = view.findViewById(R.id.sp_woman);
        bt_pair = view.findViewById(R.id.bt_pair);
        bt_pair.setOnClickListener(this);
        sp_man.setOnItemSelectedListener(this);
        sp_woman.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_man:
                String logoName = infoList.get(position).getLogoname();
                map = getData.getContentLogo();
                Bitmap bitmap = map.get(logoName);
                iv_man.setImageBitmap(bitmap);
                break;
            case R.id.sp_woman:
                logoName = infoList.get(position).getLogoname();
                map = getData.getContentLogo();
                bitmap = map.get(logoName);
                iv_woman.setImageBitmap(bitmap);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        int manPosition = sp_man.getSelectedItemPosition();
        int womanPosition = sp_woman.getSelectedItemPosition();
        Intent intent = new Intent(getContext(), PairSecondActivity.class);
        intent.putExtra("man_name", infoList.get(manPosition).getName());
        intent.putExtra("woman_name", infoList.get(womanPosition).getName());
        intent.putExtra("man_logoName", infoList.get(manPosition).getLogoname());
        intent.putExtra("woman_logoName", infoList.get(womanPosition).getLogoname());
        startActivity(intent);
    }
}