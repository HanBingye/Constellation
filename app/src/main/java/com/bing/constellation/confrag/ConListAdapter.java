package com.bing.constellation.confrag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bing.constellation.R;

import java.util.List;

public class ConListAdapter extends BaseAdapter {
    private Context context;
    private List<ConListItem> list;

    public ConListAdapter(Context context, List<ConListItem> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_con_second, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ConListItem item = list.get(position);
        holder.tv_text.setText(item.getText());
        holder.tv_content.setText(item.getContext());
        holder.tv_content.setBackgroundResource(item.getColor());


        return convertView;
    }

    class ViewHolder {
        private TextView tv_text;
        private TextView tv_content;

        public ViewHolder(View view) {
            tv_text = view.findViewById(R.id.tv_itemText);
            tv_content = view.findViewById(R.id.tv_itemContext);
        }
    }
}
