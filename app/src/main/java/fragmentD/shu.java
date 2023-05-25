package fragmentD;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.logIn.R;

public class shu extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shuu);//asd
        Button button1 = findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.tv_book_title);
                float currentSize = textView.getTextSize();
                float newSize = currentSize + 10;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize);
            }
        });
        Button buttonD = findViewById(R.id.ButtonD);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvBookTitle = findViewById(R.id.tv_book_title);
                float currentTextSize = tvBookTitle.getTextSize();
                if (currentTextSize > 10) { // 如果当前字体大小大于10sp，则进行缩小操作
                    float newTextSize = currentTextSize - 2;
                    tvBookTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, newTextSize);
                }
            }
        });
    }
}