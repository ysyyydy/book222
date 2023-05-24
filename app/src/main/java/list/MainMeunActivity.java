package list;

import DB_book.Book;
import DB_book.BookDao;
import DB_book.BookDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.logIn.R;

import java.util.List;

public class MainMeunActivity extends AppCompatActivity {
    private ListView bookListView;
    private List<Book> bookList;
    private BookListAdapter bookListAdapter;
    private BookDatabase bookDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmeun);
        bookListView = findViewById(R.id.bookList);
        bookDatabase = BookDatabase.getInstance(this);
        BookDao bookDao = bookDatabase.bookDao();


        Book book = new Book("zz",R.drawable.logo);
        bookList.add(book);
        // 从数据库获取书籍列表数据
        for (Book book1:bookDao.getAllBooks())
        {
            bookList.add(book1);
            System.out.println(book1);
        }

        bookListAdapter = new BookListAdapter(this, bookList);
        // 初始化 ListView 和适配器
        bookListView.setAdapter(bookListAdapter);

        // 设置 ListView 的点击事件监听器
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // 处理图书列表项的点击事件
                Book selectedBook = bookList.get(position);
                // 进行相关操作，如打开图书详情页面
            }
        });
    }
}

