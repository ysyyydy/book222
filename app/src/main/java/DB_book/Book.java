package DB_book;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.logIn.R;

import java.io.Serializable;

@Entity(tableName = "books")
public class Book implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private int coverResourceId;


    public Book(String title) {
        this.title = title;
        this.coverResourceId = R.drawable.logo;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCoverResourceId() {
        return coverResourceId;
    }

    public void setCoverResourceId(int coverResourceId) {
        this.coverResourceId = coverResourceId;
    }

}
