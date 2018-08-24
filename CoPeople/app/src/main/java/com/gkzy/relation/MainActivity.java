package com.gkzy.relation;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CirclePeopleView peopleView;
    private List<CoPersonBean> lists = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 222) {
                peopleView.SetFieldInfo(lists);
                peopleView.invalidate();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    private void loadData() {
        try {
            MyApplication.childSub = "张三";
            JSONObject object = new JSONObject(Contant.json);
            JSONArray array = object.getJSONArray("nodes");
            CoPersonBean personBean = null;
            for (int i = 0; i < array.length(); i++) {
                personBean = new CoPersonBean();
                JSONObject data = array.getJSONObject(i);
                personBean.setName(data.getString("name"));
                personBean.setSymbolSize(data.getInt("symbolSize"));
                lists.add(personBean);
            }
            Message msg = Message.obtain();
            msg.what = 222;
            handler.sendMessage(msg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        peopleView = findViewById(R.id.layout_cricle_people);

    }
}
