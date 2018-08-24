package com.gkzy.relation;

import android.app.Application;
import android.content.Context;

/**
 * @author chenhua
 * @describe
 * @date 2018/8/24.
 */

public class MyApplication extends Application {

    public static Context mContext;
    public static String childSub;//关系图中心文字

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }
}
