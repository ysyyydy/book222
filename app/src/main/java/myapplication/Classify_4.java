package myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.logIn.R;

import rank.TextFileActivity;

public class Classify_4 extends Activity {
    ListView list4;

    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classify_4);

        list4 = (ListView) findViewById(R.id.bookList);
        String[] data = {
                "校花的贴身高手",
                "重生之都市狂魔",
        };

        list4.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data));

        // 添加条目点击监听器
        list4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);

                // 执行点击后的操作，例如跳转到指定文本文件
                if (item.equals("校花的贴身高手")) {
                    Intent intent = new Intent(Classify_4.this, TextFileActivity.class);
                    intent.putExtra("fileName", "校花的贴身高手.txt");
                    startActivity(intent);
                }
                if (item.equals("重生之都市狂魔")) {
                    Intent intent = new Intent(Classify_4.this, TextFileActivity.class);
                    intent.putExtra("fileName", "重生之都市狂魔.txt");
                    startActivity(intent);
                }
            }
        });
    }

    public void onImageButtonClick1(View view) {
        Intent intent = new Intent(this, FragmentAA.class);
        startActivity(intent);
    }
}
