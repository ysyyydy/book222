package local;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.logIn.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingActivity extends AppCompatActivity {

    private TextView readingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        readingTextView = findViewById(R.id.readTextView);

        Intent intent = getIntent();//通过 getIntent() 方法获取启动该活动的 Intent 对象。
        String filePath = intent.getStringExtra("filePath");
        //使用 getStringExtra() 方法从 Intent 中获取名为 "filePath" 的额外数据，即文件路径
        String fileContent = readFileContent(new File(filePath));
        //调用 readFileContent() 方法读取文件内容，并将结果存储在 fileContent 变量中
        readingTextView.setText(fileContent);
        //使用 setText() 方法将文件内容设置到 readingTextView 控件中，以显示在阅读界面上。
    }

    private String readFileContent(File file) {
        StringBuilder stringBuilder = new StringBuilder();//使用 StringBuilder 对象来构建文件内容的字符串。
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            //通过创建 BufferedReader 对象并使用 FileReader 将文件传递给它，可以逐行读取文件内容。
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }//每次读取一行时，将其追加到 stringBuilder 对象中，并添加一个换行符。
            bufferedReader.close();//关闭 bufferedReader 对象
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();//将构建的字符串返回。
    }//readFileContent() 方法用于读取文件的内容
}
