package myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.logIn.R;
import data.Book;
import list.BookListAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentB extends Fragment {
    private ListView bookListView;
    private List<Book> bookList;
    private BookListAdapter bookListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        // 初始化书籍列表数据
        bookList = getBookList();

        // 初始化 ListView 和适配器
        bookListView = view.findViewById(R.id.bookList);
        bookListAdapter = new BookListAdapter(getActivity(), bookList);
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

        return view;
    }

    private List<Book> getBookList() {
        // 返回一个包含图书信息的 List<Book> 对象，用于填充列表数据
        // 这里可以从数据库、网络或其他数据源获取图书数据
        // 示例中使用了一个虚拟的书籍列表数据
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book(1, "ZZ", "Description 1"));
        bookList.add(new Book(2, "Author 2", "Description 2"));
        bookList.add(new Book(3, "Author 3", "Description 3"));
        bookList.add(new Book(4, "Z333Z", "Description 1"));
        bookList.add(new Book(5, "Author 2", "Description 2"));
        bookList.add(new Book(6, "Author 3", "Description 3"));
        bookList.add(new Book(7, "ZZ22", "Description 1"));
        bookList.add(new Book(8, "Author 2", "Description 2"));
        bookList.add(new Book(9, "Author 3", "Description 3"));
        bookList.add(new Book(10, "Z1231Z", "Description 1"));

        // 添加更多书籍...

        return bookList;
    }
}

