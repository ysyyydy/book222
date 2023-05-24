package DB_book;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM books")
    List<Book> getAllBooks();

    @Insert
    void insertBook(Book book);

    @Query("SELECT * FROM books WHERE title = :title")
    List<Book> getBookByTitle(String title);
}
