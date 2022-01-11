package com.example.app_end_18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private String[] item_name=new String[]{"item1","item2","item3","item4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setAdapter();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg=item_name[position];
                setToast(MainActivity.this,"你選擇了:"+msg);
            }
        });
    }
    public void setToast(Context context, String text){
        TextView tv=findViewById(R.id.textview);
        tv.setText(text);
    }

    private void setAdapter() {
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item_name);
        lv.setAdapter(adapter);
    }
    private void findViews() {
        lv=(ListView)findViewById(R.id.ListView);
    }
}