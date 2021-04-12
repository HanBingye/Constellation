package com.bing.constellation.confrag;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bing.constellation.R;
import com.bing.constellation.been.ContentInfoBeen;
import com.bing.constellation.utils.getData;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConAdapter extends BaseAdapter {
    private Context context;
    private List<ContentInfoBeen.StarInfoBean> dataList;
    private Map<String, Bitmap> logoMap;
    public ConAdapter(Context context, List<ContentInfoBeen.StarInfoBean> dataList) {
        this.context = context;
        this.dataList = dataList;
        logoMap= getData.getLogo();
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_con,parent,false);
            holder=new viewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (viewHolder) convertView.getTag();
        }
        ContentInfoBeen.StarInfoBean infoBean = dataList.get(position);
        String name = infoBean.getName();
        holder.tv_item.setText(name);
        String logoname = infoBean.getLogoname();
        Bitmap bitmap = logoMap.get(logoname);
        holder.ci_item.setImageBitmap(bitmap);

        return convertView;
    }
    class viewHolder{

        private  CircleImageView ci_item;
        private  TextView tv_item;

        public viewHolder(View view) {
            ci_item = view.findViewById(R.id.ci_item);
            tv_item = view.findViewById(R.id.tv_item);
        }
    }
}
