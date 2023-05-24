package DB_book;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 4, exportSchema=false) // 更新版本号为2
public abstract class BookDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "book-db";
    private static volatile BookDatabase instance;

    public abstract BookDao bookDao();

    public static synchronized BookDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static BookDatabase create(final Context context) {
        return Room.databaseBuilder(
                        context.getApplicationContext(),
                        BookDatabase.class,
                        DATABASE_NAME
                ).fallbackToDestructiveMigration() // 使用破坏性迁移
                .build();
    }
}
