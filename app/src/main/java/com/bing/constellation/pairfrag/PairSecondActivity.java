package com.bing.constellation.pairfrag;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bing.constellation.R;
import com.bing.constellation.utils.HttpUtils;
import com.bing.constellation.utils.getData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PairSecondActivity extends AppCompatActivity {

    private CircleImageView civ_man;
    private CircleImageView civ_woman;
    private TextView tv_man;
    private TextView tv_woman;
    private TextView tv_pd;
    private TextView tv_vs;
    private TextView tv_pf;
    private TextView tv_bz;
    private TextView tv_jx;
    private TextView tv_zy;
    private String man_name;
    private String woman_name;
    private String man_logoName;
    private String woman_logoName;
    private ImageView iv_back;
    private TextView tv_sTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_second);
        initView();
        tv_sTitle.setText("配对详情");
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        man_name = intent.getStringExtra("man_name");
        woman_name = intent.getStringExtra("woman_name");
        man_logoName = intent.getStringExtra("man_logoName");
        woman_logoName = intent.getStringExtra("woman_logoName");
        Map<String, Bitmap> map = getData.getContentLogo();
        Bitmap manBitmap = map.get(man_logoName);
        civ_man.setImageBitmap(manBitmap);
        Bitmap womanBitmap = map.get(woman_logoName);
        civ_woman.setImageBitmap(womanBitmap);
        tv_man.setText(man_name);
        tv_woman.setText(woman_name);
        tv_pd.setText("星座配对——" + man_name + "和" + woman_name + "配对");
        tv_vs.setText(man_name + " vs " + woman_name);
        String url = HttpUtils.getPairUrl(man_name, woman_name);
        HttpUtils.sendOkHttp(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"请确认您的网络状态",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if (!TextUtils.isEmpty(json)) {
                    PairBean pairBean = new Gson().fromJson(json, PairBean.class);
                    PairBean.ResultBean resultData = pairBean.getResult();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_pf.setText("配对评分: " + resultData.getZhishu() + "  " + resultData.getJieguo());
                            tv_bz.setText("星座比重: " + resultData.getBizhong());
                            tv_jx.setText("解析:\n\n" + resultData.getLianai());
                            tv_zy.setText("注意事项:\n\n" + resultData.getZhuyi()+"\n");
                        }
                    });


                }
            }
        });


    }

    private void initView() {
        iv_back = findViewById(R.id.iv_back);
        tv_sTitle = findViewById(R.id.tv_sTitle);
        civ_man = findViewById(R.id.civ_man);
        civ_woman = findViewById(R.id.civ_woman);
        tv_man = findViewById(R.id.tv_man);
        tv_woman = findViewById(R.id.tv_woman);
        tv_pd = findViewById(R.id.tv_pd);
        tv_vs = findViewById(R.id.tv_vs);
        tv_pf = findViewById(R.id.tv_pf);
        tv_bz = findViewById(R.id.tv_bz);
        tv_jx = findViewById(R.id.tv_jx);
        tv_zy = findViewById(R.id.tv_zy);
    }


}