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

public class Classify_2 extends Activity {
    ListView list2;

    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classify_2);

        list2 = (ListView) findViewById(R.id.bookList);
        String[] data = {
                "全职法师",
                "大主宰",
        };

        list2.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data));

        // 添加条目点击监听器
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);

                // 执行点击后的操作，例如跳转到指定文本文件
                if (item.equals("全职法师")) {
                    Intent intent = new Intent(Classify_2.this, TextFileActivity.class);
                    intent.putExtra("fileName", "全职法师.txt");
                    startActivity(intent);
                }
                if (item.equals("大主宰")) {
                    Intent intent = new Intent(Classify_2.this, TextFileActivity.class);
                    intent.putExtra("fileName", "大主宰.txt");
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