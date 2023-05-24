package DB_book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.logIn.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private static Context context;
    private static List<Book> bookList;



    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.tvTitle.setText(book.getTitle());
        if (book.getCoverResourceId() == R.drawable.logo) {
            holder.ivCover.setImageResource(R.drawable.logo);
        } else {
            holder.ivCover.setImageResource(book.getCoverResourceId());
        }
    }



    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivCover;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivCover);

            ivCover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Book book = bookList.get(position);
                        // 在这里添加跳转到对应小说阅读界面的逻辑
                        Intent intent = new Intent(context, BookDetailActivity.class);
                        intent.putExtra("book", book);
                        context.startActivity(intent);
                    }
                    Toast.makeText(context, "封面图片被点击", Toast.LENGTH_SHORT).show();
                }
            });

            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 处理标题文字的点击事件
                    // 在这里添加你想要执行的操作
                    Toast.makeText(context, "文字被点击", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}

