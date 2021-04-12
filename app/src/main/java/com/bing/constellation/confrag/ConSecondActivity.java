package com.bing.constellation.confrag;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bing.constellation.R;
import com.bing.constellation.been.ContentInfoBeen;
import com.bing.constellation.utils.getData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConSecondActivity extends AppCompatActivity {

    private TextView tv_sTitle;
    private ImageView iv_back;
    private CircleImageView iv_sLogo;
    private TextView tv_sLogoText;
    private TextView tv_sLogoTime;
    private ListView lv_character;
    private ContentInfoBeen.StarInfoBean starInfoBean;
    private Map<String, Bitmap> contentLogo;
    private TextView tv_sBottomInfo;
    private List<ConListItem> list;
    private ConListAdapter conListAdapter;

    private void addToList() {
        ConListItem item1= new ConListItem("性格特点", starInfoBean.getTd(), R.color.lightBlue);
        ConListItem item2= new ConListItem("掌管宫位", starInfoBean.getGw(), R.color.lightPink);
        ConListItem item3= new ConListItem("显阴阳性", starInfoBean.getYy(), R.color.lightGreen);
        ConListItem item4= new ConListItem("最大特征", starInfoBean.getTz(), R.color.purple);
        ConListItem item5= new ConListItem("主管星球", starInfoBean.getZg(), R.color.orange);
        ConListItem item6= new ConListItem("幸运颜色", starInfoBean.getYs(), R.color.colorAccent);
        ConListItem item7= new ConListItem("搭配宝珠", starInfoBean.getZb(), R.color.black);
        ConListItem item8= new ConListItem("幸运号码", starInfoBean.getHm(), R.color.darkBlue);
        ConListItem item9= new ConListItem("相配金属", starInfoBean.getJs(), R.color.grey);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        list.add(item7);
        list.add(item8);
        list.add(item9);
        conListAdapter.notifyDataSetChanged();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_second);
        Intent intent = getIntent();
        starInfoBean = (ContentInfoBeen.StarInfoBean) intent.getSerializableExtra("con");
        initView();
        list = new ArrayList<>();

        conListAdapter = new ConListAdapter(this, list);
        lv_character.setAdapter(conListAdapter);
        addToList();

    }

    private void initView() {
        tv_sTitle = findViewById(R.id.tv_sTitle);
        iv_back = findViewById(R.id.iv_back);
        iv_sLogo = findViewById(R.id.iv_sLogo);
        tv_sLogoText = findViewById(R.id.tv_sLogoText);
        tv_sLogoTime = findViewById(R.id.tv_sLogoTime);
        lv_character = findViewById(R.id.lv_character);

        View view = LayoutInflater.from(this).inflate(R.layout.con_second_bottom, null);
        lv_character.addFooterView(view);
        tv_sBottomInfo = view.findViewById(R.id.tv_sBottomInfo);
        tv_sBottomInfo.setText(starInfoBean.getInfo());

        tv_sTitle.setText("星座详情");
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_sLogoText.setText(starInfoBean.getName());
        tv_sLogoTime.setText(starInfoBean.getDate());
        contentLogo = getData.getContentLogo();
        Bitmap bitmap = contentLogo.get(starInfoBean.getLogoname());
        iv_sLogo.setImageBitmap(bitmap);

    }
}