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

public class Classify_1 extends Activity {
    ListView list1;//声明变量

    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classify_1);

        list1 = (ListView) findViewById(R.id.bookList);//利用findViewById方法查找bookList控件并绑定内容
        String[] data = {
                "斗罗大陆",
                "元尊",
                "凡人修仙传",
        };

        //将内容呈现在控件上
        list1.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data));

        // 添加条目点击监听器
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);

                // 执行点击后的操作，例如跳转到指定文本文件
                if (item.equals("斗罗大陆")) {
                    Intent intent = new Intent(Classify_1.this, TextFileActivity.class);
                    intent.putExtra("fileName", "斗罗大陆.txt");
                    startActivity(intent);
                }
                if (item.equals("元尊")) {
                    Intent intent = new Intent(Classify_1.this, TextFileActivity.class);
                    intent.putExtra("fileName", "元尊.txt");
                    startActivity(intent);
                }
                if (item.equals("凡人修仙传")) {
                    Intent intent = new Intent(Classify_1.this, TextFileActivity.class);//跳转
                    intent.putExtra("fileName", "凡人修仙传.txt");
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
