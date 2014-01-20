package com.example.DRS;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class DrawView extends LinearLayout {
    private Paint paint = new Paint();
    public int x1, x2;
    public int y1, y2;

    public DrawView(Context c){
        super(c);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addView(inflater.inflate(R.layout.main, null));

        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;

        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(10);
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawLine(0, 50, 900,2000 , paint);//WORKS

    }

    public void setFirstCoord(int e, int f){
        x1 = e;
        y1 = f;
    }

    public void setSecondCoord(int e, int f){
        x2 = e;
        y2 = f;
    }
}