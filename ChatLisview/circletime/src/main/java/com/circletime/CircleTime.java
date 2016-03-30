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
    private  int width;
    private  int high;

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

        width=getMeasuredWidth();
        high=getMeasuredHeight();

        Paint circlePaint=new Paint();
        circlePaint.setColor(getResources().getColor(R.color.colorAccent));
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        canvas.drawCircle(width / 2, high / 2, width / 2, circlePaint);

        Paint paintDegree=new Paint();
        paintDegree.setStrokeWidth(3);
        for(int i=0;i<24;i++){
            if(i==0||i==6||i==12||i==18){
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(width / 2, high / 2 - width / 2, width / 2, high / 2 - width / 2 + 60, paintDegree);
                String degree=String.valueOf(i);
                canvas.drawText(degree,width / 2, high / 2 - width / 2 + 90,paintDegree);
            }
            else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(width / 2, high / 2 - width / 2, width / 2, high / 2 - width / 2 + 30, paintDegree);
                String degree=String.valueOf(i);
                canvas.drawText(degree, width / 2, high / 2 - width / 2 + 60, paintDegree);
            }
            canvas.rotate(15,width/2,high/2);




        }
        Paint paintPointer = new Paint();
        paintPointer.setStrokeWidth(30);
        canvas.drawPoint(width / 2, high / 2, paintPointer);
        // 鐢绘寚閽?        Paint paintHour = new Paint();
        paintPointer.setStrokeWidth(20);
        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);
        canvas.save();
        canvas.translate(width / 2, high / 2);
        canvas.drawLine(0, 0, 100, 100, paintMinute);
        canvas.drawLine(0, 0, 100, 200, paintPointer);
        canvas.restore();
        super.onDraw(canvas);
    }
}
