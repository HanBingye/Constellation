package com.bing.constellation;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bing.constellation.been.ContentInfoBeen;
import com.bing.constellation.confrag.ConFragment;
import com.bing.constellation.fortunefrag.FortuneFragment;
import com.bing.constellation.minefrag.MineFragment;
import com.bing.constellation.pairfrag.PairFragment;
import com.bing.constellation.utils.getData;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_mRg;
    private Fragment conFrag, fortuneFrag, pairFrag,mineFrag;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_mRg = findViewById(R.id.rg_mRg);

        rg_mRg.setOnCheckedChangeListener(this);
        ContentInfoBeen contentInfoBeen = loadData();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", contentInfoBeen);
        conFrag = new ConFragment();
        conFrag.setArguments(bundle);
        pairFrag = new PairFragment();
        pairFrag.setArguments(bundle);
        fortuneFrag = new FortuneFragment();
        fortuneFrag.setArguments(bundle);
        mineFrag=new MineFragment();
        mineFrag.setArguments(bundle);

        manager = getSupportFragmentManager();

        firstAddFragment();

    }

    private ContentInfoBeen loadData() {
        String jsonContent = getData.getContent(this, "content/content.json");
        Gson gson = new Gson();
        ContentInfoBeen contentInfoBeen = gson.fromJson(jsonContent, ContentInfoBeen.class);
        getData.saveBitmapTo(this,contentInfoBeen);
        return contentInfoBeen;
    }

    private void firstAddFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.ll_atCenter, conFrag);
        transaction.add(R.id.ll_atCenter, pairFrag);
        transaction.add(R.id.ll_atCenter, fortuneFrag);
        transaction.add(R.id.ll_atCenter,mineFrag);
        transaction.hide(pairFrag);
        transaction.hide(fortuneFrag);
        transaction.hide(mineFrag);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId) {
            case R.id.rb_con:
                transaction.hide(pairFrag);
                transaction.hide(fortuneFrag);
                transaction.hide(mineFrag);
                transaction.show(conFrag);

                break;
            case R.id.rb_pair:
                transaction.hide(conFrag);
                transaction.hide(fortuneFrag);
                transaction.hide(mineFrag);
                transaction.show(pairFrag);

                break;
            case R.id.rb_fortune:
                transaction.hide(conFrag);
                transaction.hide(pairFrag);
                transaction.hide(mineFrag);
                transaction.show(fortuneFrag);

                break;
            case R.id.rb_mine:
                transaction.hide(conFrag);
                transaction.hide(pairFrag);
                transaction.hide(fortuneFrag);
                transaction.show(mineFrag);

                break;


        }
        transaction.commit();
    }
}