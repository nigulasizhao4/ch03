package com.example.home1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listview;
    private SimpleAdapter sim_adapter;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        text=(TextView) findViewById(R.id.text);
        listview = (ListView) findViewById(R.id.listview);
        sim_adapter = new SimpleAdapter(this, getdata(), R.layout.item, new String[]{"pic", "text"}, new int[]{R.id.pic, R.id.text});
        listview.setAdapter(sim_adapter);
        listview.setOnItemClickListener(this);
    }
    private List<Map<String, Object>> getdata() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pic", R.drawable.lion);
        map.put("text", "lion");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("pic", R.drawable.tiger);
        map.put("text", "Tiger");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("pic", R.drawable.monkey);
        map.put("text", "Monkey");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("pic", R.drawable.dog);
        map.put("text", "Dog");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("pic", R.drawable.cat);
        map.put("text", "Cat");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("pic", R.drawable.elephant);
        map.put("text", "Elephant");
        list.add(map);
        return list;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        /*adapterView是指当前的listview；
         *view是当前listview中的item的view的布局,就是可用这个view获取里面控件id后操作控件
         * i是当前item在listview中适配器的位置
         * l是当前item在listview里第几行的位置
         */
        //获得选中项中的HashMap对象
        HashMap<String,String> map=(HashMap<String,String>)adapterView.getItemAtPosition(i);
        String Text=map.get("text");
        Toast.makeText(MainActivity.this,Text,Toast.LENGTH_SHORT).show();
    }
}
