package com.gkzy.relation;

/**
 * Created by dell on 2018/6/27.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.gkzy.relation.MyApplication.mContext;


/**
 * 自定义关系图
 *
 * @author chenhua
 * @date 2018/6/27
 */
public class CirclePeopleView extends View {

    private String[] colors = {"#BE9300", "#EC9D0C", "#B36301", "#B3B001", "#B3016E", "#862BB5", "#09B301", "#65BF7A", "#01ADB3", "#E8C91A"};
    private Paint paint;
    private float XPoint;
    private float YPoint;
    private int[] radius = new int[8];
    private List<CoPersonBean> lists = new ArrayList<>();

    public CirclePeopleView(Context context) {
        super(context);
    }

    public CirclePeopleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CirclePeopleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void SetFieldInfo(List<CoPersonBean> lists) {
        this.lists = lists;
        for (int i = 0; i < 8; i++) {
            Random r = new Random();
            radius[i] = r.nextInt(160) + 180;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        this.paint.setColor(Color.parseColor("#BE9300"));
        this.paint.setStrokeWidth(dip2px(mContext, 2));
        XPoint = getWidth() / 2;
        YPoint = getHeight() / 2;
        canvas.drawCircle(XPoint, YPoint, dip2px(mContext, 20), paint);

        this.paint.setColor(Color.parseColor("#333333"));
        this.paint.setTextSize(dip2px(mContext, 10));
        canvas.drawText(MyApplication.childSub, XPoint - 40, YPoint + 60, paint);
        int count = lists.size();
        if (lists != null && count > 0) {
            double pere = Math.PI * 2 / count;
            for (int i = 0; i < count; i++) {
                paint.setColor(Color.parseColor(colors[i % colors.length]));
                paint.setStrokeWidth(dip2px(mContext, 2));
                int r = lists.get(i).getSymbolSize();
                if (r < 8){
                    r = 8;
                }
                canvas.drawCircle(XPoint + (float) Math.cos(pere * i + 5) * radius[i % radius.length], YPoint + (float) Math.sin(pere * i + 5) * radius[i % radius.length], dip2px(mContext, r), paint);
                this.paint.setColor(Color.parseColor("#333333"));
                this.paint.setTextSize(dip2px(mContext, 8));
                canvas.drawText(lists.get(i).getName(), XPoint + (float) Math.cos(pere * i + 5) * radius[i % radius.length] - 30, YPoint + (float) Math.sin(pere * i + 5) * radius[i % radius.length] + 35, paint);
                this.paint.setColor(Color.parseColor("#666666"));
                this.paint.setStrokeWidth(0.5f);
                canvas.drawLine(XPoint + (float) Math.cos(pere * i + 5) * 40, YPoint + (float) Math.sin(pere * i + 5) * 40, XPoint + (float) Math.cos(pere * i + 5) * (radius[i % radius.length] - 20), YPoint + (float) Math.sin(pere * i + 5) * (radius[i % radius.length] - 20), paint);

            }
        }

    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale);
    }

}
