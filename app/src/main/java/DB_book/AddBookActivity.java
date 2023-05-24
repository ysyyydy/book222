package DB_book;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import com.logIn.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddBookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> bookList;
    private BookDatabase bookDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        // 初始化数据库
        bookDatabase = Room.databaseBuilder(getApplicationContext(), BookDatabase.class, "book-db")
                .fallbackToDestructiveMigration() // 使用破坏性迁移
                .allowMainThreadQueries()
                .build();

        // 初始化视图
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(this, bookList);
        recyclerView.setAdapter(bookAdapter);
        addBooksFromAssets();

        displayBooks();


    }

    private void addBooksFromAssets() {

        AssetManager assetManager = getAssets();
        String[] files;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for (String file : files) {
            if (file.endsWith(".txt")) {
                String title = extractTitleFromTextAsset(assetManager, file);
                if (title != null) {
                    // 检查数据库中是否已存在相同标题的书籍
                    List<Book> existingBooks = bookDatabase.bookDao().getBookByTitle(title);
                    if (existingBooks.isEmpty()) {
                        Book book = new Book(title);
                        bookDatabase.bookDao().insertBook(book);
                    }
                }
            }
        }

        Toast.makeText(this, "Books added successfully", Toast.LENGTH_SHORT).show();
    }

    private String extractTitleFromTextAsset(AssetManager assetManager, String filename) {
        InputStream inputStream;
        try {
            inputStream = assetManager.open(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            line = reader.readLine();
            System.out.println(line);
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Pattern pattern = Pattern.compile("《(.*?)》");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }

    private void displayBooks() {
        bookList.clear();
        bookList.addAll(bookDatabase.bookDao().getAllBooks());
        bookAdapter.notifyDataSetChanged();
    }
}

