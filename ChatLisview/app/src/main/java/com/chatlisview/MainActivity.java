package com.chatlisview;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{
    private ListView chatListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intview();
    }

    private void intview() {
        ChatItemViewBean bean1 = new ChatItemViewBean();
        chatListView= (ListView) findViewById(R.id.chatListView);

        bean1.setType(0);
        bean1.setIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.in_icon));
        bean1.setText("Hello how are you?");

        ChatItemViewBean bean2 = new ChatItemViewBean();
        bean2.setType(1);
        bean2.setIcon(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher));
        bean2.setText("Fine thank you, and you?");

        ChatItemViewBean bean3 = new ChatItemViewBean();
        bean3.setType(0);
        bean3.setIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.in_icon));
        bean3.setText("I am fine too");

        ChatItemViewBean bean4 = new ChatItemViewBean();
        bean4.setType(1);
        bean4.setIcon(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher));
        bean4.setText("Bye bye");

        ChatItemViewBean bean5 = new ChatItemViewBean();
        bean5.setType(0);
        bean5.setIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.in_icon));
        bean5.setText("See you");


        ChatItemViewBean bean6 = new ChatItemViewBean();
        bean6.setType(0);
        bean6.setIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.in_icon));
        bean6.setText("See you");

        ChatItemViewBean bean7 = new ChatItemViewBean();
        bean7.setType(0);
        bean7.setIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.in_icon));
        bean7.setText("See you");

        ChatItemViewBean bean8 = new ChatItemViewBean();
        bean8.setType(0);
        bean8.setIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.in_icon));
        bean8.setText("See you");
        List<ChatItemViewBean> data = new ArrayList<ChatItemViewBean>();
        data.add(bean1);
        data.add(bean2);
        data.add(bean3);
        data.add(bean4);
        data.add(bean5);
        data.add(bean6);
        data.add(bean7);
        data.add(bean8);
        chatListView.setAdapter(new ChatListAdapter(this, data));

    }


}
