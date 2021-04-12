package com.bing.constellation.fortunefrag;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bing.constellation.R;

import java.util.List;

public class FortuneLvAdapter extends BaseAdapter {

    private Context context;
    private List<FortuneItemBean> list;

    public FortuneLvAdapter(Context context, List<FortuneItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fortune_second, parent, false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
           holder= (ViewHolder) convertView.getTag();
        }
        FortuneItemBean itemBean = list.get(position);
        holder.tv_lv_text.setText(itemBean.getText());
        holder.tv_lv_content.setText(itemBean.getContent());
        GradientDrawable drawable = (GradientDrawable) holder.tv_lv_text.getBackground();
        drawable.setColor(itemBean.getColorId());
        return convertView;
    }
    class ViewHolder{

        private  TextView tv_lv_text;
        private  TextView tv_lv_content;

        public ViewHolder(View view) {
            tv_lv_text = view.findViewById(R.id.tv_lv_text);
            tv_lv_content = view.findViewById(R.id.tv_lv_content);
        }
    }
}
