package DB_book;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.logIn.R;

@Entity(tableName = "books")
public class Book implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;//书名
    private int coverResourceId;

    public Book(String title,int coverResourceId) {
        this.title = title;
        this.coverResourceId = R.drawable.logo;
    }

    protected Book(Parcel in) {
        id = in.readInt();
        title = in.readString();
        coverResourceId = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeInt(coverResourceId);
    }

    @Override
    public int describeContents() {
        return 0;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverResourceId=" + coverResourceId +
                '}';
    }
}
