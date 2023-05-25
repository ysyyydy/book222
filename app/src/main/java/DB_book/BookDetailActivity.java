package DB_book;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.logIn.R;

public class BookDetailActivity extends AppCompatActivity {

    private TextView tvBookTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // 获取传递的书籍信息
        Book book = getIntent().getParcelableExtra("book");

        // 初始化视图
        tvBookTitle = findViewById(R.id.tvBookTitle);

        // 设置书籍标题
        if (book != null) {
            tvBookTitle.setText(book.getTitle());
        }
    }
}
