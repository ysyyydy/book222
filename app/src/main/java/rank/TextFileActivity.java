package rank;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.logIn.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFileActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_file);

        // 获取textView控件的引用
        textView = findViewById(R.id.textView);

        // 获取Intent中传递的fileName参数
        String fileName = getIntent().getStringExtra("fileName");

        // 打开指定文件并读取其内容
        try {
            InputStream inputStream = getAssets().open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }

            // 将文本内容显示在textView控件上
            textView.setText(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
