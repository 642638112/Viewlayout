package com.circletime;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private  CircleTime circleTime;
    int   miao;
    int hour;
    int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intview();
    }

    private void intview() {



        circleTime=(CircleTime)findViewById(R.id.circle);
      //  circleTime.setTime(hour, minute, miao);

        new ProgressAnimation().execute();
    }

    class ProgressAnimation extends AsyncTask<Void, String, Void> {
        @Override
        protected Void doInBackground(Void... params) {





            for (int i=1;i<10;i=1) {
                Calendar c1=Calendar.getInstance();
                hour = c1.get(Calendar.HOUR_OF_DAY);
                if(hour>12){hour=hour-12;}
                minute = c1.get(Calendar.MINUTE);
                miao = c1.get(Calendar.SECOND);
                try {

                    System.out.println(minute + "-------------------for");

                    publishProgress(miao+"/"+minute+"/"+hour);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            String[] array= new String[3];
            array=values[0].split("/");

          int miao= Integer.parseInt(array[0]);
           int fen= Integer.parseInt(array[1]);
          int xiaoshi= Integer.parseInt(array[2]);
       circleTime.setTime(xiaoshi,fen,miao);

      System.out.println(array[0] + "-------------------");
            super.onProgressUpdate(values);
        }
    }


}
