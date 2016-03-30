package com.chatlisview;

import android.graphics.Bitmap;

/**
 * Created by zml on 2016/3/29.
 */
public class ChatItemViewBean {
    private int type; //表示发送或者是接收数据
    private  String text;
    private Bitmap icon;
    public ChatItemViewBean(){

    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
}
