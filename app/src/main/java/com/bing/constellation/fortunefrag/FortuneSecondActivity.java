package com.bing.constellation.fortunefrag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.constellation.R;
import com.bing.constellation.utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FortuneSecondActivity extends AppCompatActivity {

    private TextView tv_sTitle;
    private ImageView iv_back;
    private ListView lv_fortune;
    private List<FortuneItemBean> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune_second);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        initView(name);
        list = new ArrayList<>();

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String url = HttpUtils.getFortuneUrl(name);
        HttpUtils.sendOkHttp(url, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请确认您的网络状态", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if (!TextUtils.isEmpty(json)) {
                    FortuneBean fortuneBean = new Gson().fromJson(json, FortuneBean.class);
                    addToList(fortuneBean);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            FortuneLvAdapter adapter = new FortuneLvAdapter(getApplicationContext(), list);
                            lv_fortune.setAdapter(adapter);
                        }
                    });


                }

            }
        });


    }

    private void addToList(FortuneBean fortuneBean) {
        FortuneItemBean item1 = new FortuneItemBean("综合运势", fortuneBean.getMima().getText().get(0), Color.BLUE);
        FortuneItemBean item2 = new FortuneItemBean("爱情运势", fortuneBean.getLove().get(0), Color.RED);
        FortuneItemBean item3 = new FortuneItemBean("事业学业", fortuneBean.getCareer().get(0), Color.GRAY);
        FortuneItemBean item4 = new FortuneItemBean("健康运势", fortuneBean.getHealth().get(0), Color.GREEN);
        FortuneItemBean item5 = new FortuneItemBean("财富运势", fortuneBean.getFinance().get(0), Color.BLACK);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

    }

    private void initView(String name) {
        tv_sTitle = findViewById(R.id.tv_sTitle);
        tv_sTitle.setText(name);
        iv_back = findViewById(R.id.iv_back);
        lv_fortune = findViewById(R.id.lv_fortune);
    }
}