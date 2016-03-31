package com.circletime;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zml on 2016/3/29.
 */
public class CircleTime extends View {
    private int width;
    private int high;

    private int hourx;
    private int houry;
    private int minutx;
    private int minuty;
    private int miaox;
    private int miaoy;

    public CircleTime(Context context) {
        super(context);

    }

    public CircleTime(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleTime(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        width = getMeasuredWidth();
        high = getMeasuredHeight();

        Paint circlePaint = new Paint();
        circlePaint.setColor(getResources().getColor(R.color.colorAccent));
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        canvas.drawCircle(width / 2, high / 2, width / 2, circlePaint);

        Paint paintDegree = new Paint();
        paintDegree.setStrokeWidth(3);
        for (int i = 0; i < 12; i++) {
            if (i == 0 || i == 3 || i == 6 || i == 12) {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(width / 2, high / 2 - width / 2, width / 2, high / 2 - width / 2 + 60, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, width / 2, high / 2 - width / 2 + 90, paintDegree);
            } else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(width / 2, high / 2 - width / 2, width / 2, high / 2 - width / 2 + 30, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, width / 2, high / 2 - width / 2 + 60, paintDegree);
            }
            canvas.rotate(30, width / 2, high / 2);


        }
        Paint paintPointer = new Paint();
        paintPointer.setStrokeWidth(30);
        canvas.drawPoint(width / 2, high / 2, paintPointer);

        paintPointer.setStrokeWidth(20);

        Paint paintHour= new Paint();
        paintHour.setStrokeWidth(10);

        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);

        Paint paintMiao = new Paint();
        paintMiao.setStrokeWidth(10);

        canvas.save();
        canvas.translate(width / 2, high / 2);
        canvas.drawLine(0, 0, hourx, houry, paintHour);
        canvas.drawLine(0, 0, minutx, minuty, paintMinute);
        canvas.drawLine(0, 0, miaox, miaoy, paintMiao);
        canvas.restore();
        super.onDraw(canvas);
    }

    public void setTime(int hour, int minute, int miao) {
        System.out.println(hour + "--"+minute+"--"+miao);
        if (hour >= 0 && hour <= 3) {
            hourx = (int) (100 * Math.sin(Math.PI *(hour +minute/60)/ 6.0));
            houry = -(int) (100 * Math.cos(Math.PI *(hour +minute/60)/ 6.0));

        }
        if (hour >= 3 && hour <= 6) {
            System.out.println(((((hour +minute/60) + 0.0) / 12) * 360 - 90) + "-------------------------------------");
            double hx = ((((hour +minute/60) + 0.0) / 12) * 360 - 90);

            hourx = (int) (100 * Math.cos(Math.PI * (hx / 180.0)));
            houry = (int) (100 * Math.sin(Math.PI * (hx / 180.0)));
        }

        if (hour >= 6 && hour <= 9) {
            double hx = ((((hour +minute/60) + 0.0) / 12) * 360 - 180);

            hourx = -(int) (100 * Math.sin(Math.PI * (hx / 180.0)));
            houry = (int) (100 * Math.cos(Math.PI * (hx / 180.0)));
        }
        if (hour >= 9 && hour <= 12) {
            double hx = ((((hour +minute/60) + 0.0) / 12) * 360 - 270);

            hourx = -(int) (100 * Math.cos(Math.PI * (hx / 180.0)));
            houry = -(int) (100 * Math.sin(Math.PI * (hx / 180.0)));
        }
//分
        if (minute >= 0 && minute <= 15) {
            double hx = (((minute + 0.0) / 60.0) * 360 );
            System.out.println("minute" +hx+"%%%%%%%%%%%%%%%%%%%%%%%%%%");
            minutx = (int) (200 * Math.sin(Math.PI * (hx / 180.0)));

            minuty = -(int) (200 * Math.cos(Math.PI * (hx / 180.0)));
            System.out.println("minute" +minutx+"%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("minute" +minuty+"%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        if (minute >= 15 && minute <= 30) {

            double hx = (((minute + 0.0) / 60.0) * 360 - 90);
            minutx = (int) (200 * Math.cos(Math.PI * (hx / 180.0)));
            minuty = (int) (200 * Math.sin(Math.PI * (hx / 180.0)));

        }

        if (minute >= 30 && minute <= 45) {
            System.out.println("minute" + (((minute + 0.0) / 60) * 360 - 180) + "-------------------------------------");
            double hx = (((minute + 0.0) / 60.0) * 360 - 180);
            System.out.println("minute" + hx + "-------------------------------------");
            minutx = -(int) (200 * Math.sin(Math.PI * (hx / 180.0)));
            minuty = (int) (200 * Math.cos(Math.PI * (hx / 180.0)));

        }
        if (minute >= 45 && minute <= 60) {
            double hx = (((minute + 0.0) / 60.0) * 360 - 270);

            minutx = -(int) (200 * Math.cos(Math.PI * (hx / 180.0)));
            minuty = -(int) (200 * Math.sin(Math.PI * (hx / 180.0)));
        }

        //秒
        if (miao >= 0 && miao <= 15) {
            double hx = (((miao + 0.0) / 60.0) * 360 );
            miaox = (int) (270 * Math.sin(Math.PI * (hx / 180.0)));


            miaoy = -(int) (270 * Math.cos(Math.PI * (hx / 180.0)));

            System.out.println("miaox" +miaox+"%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("miaoy" +miaoy+"%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        if (miao >= 15 && miao <= 30) {

            double hx = (((miao + 0.0) / 60.0) * 360 - 90);

            miaox = (int) (270 * Math.cos(Math.PI * (hx / 180.0)));
            miaoy = (int) (270 * Math.sin(Math.PI * (hx / 180.0)));

        }
            if (miao >= 30 && miao <= 45) {

                double hx = (((miao + 0.0) / 60.0) * 360 - 180);
                System.out.println("minute" + hx + "-------------------------------------");
                miaox = -(int) (270 * Math.sin(Math.PI * (hx / 180.0)));
                miaoy = (int) (270 * Math.cos(Math.PI * (hx / 180.0)));
                System.out.println("minute" + minutx + "-------------------------------------" + minuty);
            }
            if (miao >= 45 && miao <= 60) {
                double hx = (((miao + 0.0) / 60.0) * 360 - 270);

                miaox = -(int) (270 * Math.cos(Math.PI * (hx / 180.0)));
                miaoy = -(int) (270 * Math.sin(Math.PI * (hx / 180.0)));
            }


            this.invalidate();
        }
    }
