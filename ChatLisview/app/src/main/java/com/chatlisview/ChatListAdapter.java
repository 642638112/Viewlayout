package com.chatlisview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zml on 2016/3/29.
 */
public class ChatListAdapter extends BaseAdapter {

    private LayoutInflater minflater;
    private List<ChatItemViewBean> mdata;
    ChatListAdapter(Context context,List<ChatItemViewBean> data){

        mdata=data;
        minflater= LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        ChatItemViewBean bean = mdata.get(position);
        return bean.getType();
    }

    @Override
    public int getCount()  {return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            if(getItemViewType(position)==0){
                viewHolder=new ViewHolder();
                convertView=minflater.inflate(R.layout.chat_item_in,null);
                viewHolder.icon=(ImageView)convertView.findViewById(R.id.icon_in);
                viewHolder.text=(TextView)convertView.findViewById(R.id.text_in);
            }
            else {
                viewHolder = new ViewHolder();
                convertView = minflater.inflate(
                        R.layout.chat_item_itemout, null);
                viewHolder.icon = (ImageView) convertView.findViewById(
                        R.id.icon_out);
                viewHolder.text = (TextView) convertView.findViewById(
                        R.id.text_out);
            }
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.icon.setImageBitmap(mdata.get(position).getIcon());
        viewHolder.text.setText(mdata.get(position).getText());
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private  final  class ViewHolder{
        public ImageView icon;
        public TextView text;
    }
}
