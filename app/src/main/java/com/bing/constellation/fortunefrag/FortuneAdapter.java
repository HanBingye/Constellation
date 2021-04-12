package com.bing.constellation.fortunefrag;

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

public class FortuneAdapter extends BaseAdapter {
    private Context context;

    private List<ContentInfoBeen.StarInfoBean> infoList;
    private Map<String, Bitmap> map;

    public FortuneAdapter(Context context, List<ContentInfoBeen.StarInfoBean> infoList) {
        this.context = context;
        this.infoList = infoList;
        map = getData.getContentLogo();
    }

    @Override
    public int getCount() {
        return infoList.size();
    }

    @Override
    public Object getItem(int position) {
        return infoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fortune, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ContentInfoBeen.StarInfoBean infoBean = infoList.get(position);
        String name = infoBean.getName();
        holder.tv_fortune.setText(name);
        String logoName = infoBean.getLogoname();
        Bitmap bitmap = map.get(logoName);
        holder.civ_fortune.setImageBitmap(bitmap);
        return convertView;
    }

    class ViewHolder {
        private CircleImageView civ_fortune;
        private TextView tv_fortune;

        public ViewHolder(View view) {
            civ_fortune = view.findViewById(R.id.civ_fortune);
            tv_fortune = view.findViewById(R.id.tv_fortune);

        }
    }
}
