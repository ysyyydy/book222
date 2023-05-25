package fiction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.logIn.R;

import java.util.List;

public class ChapterActivity extends AppCompatActivity {

    private TextView tvChapterTitle;
    private TextView tvChapterContent;
    private TextView tvPageNumber;
    private int currentChapterIndex = 0;


    private Chapter chapter;
    private int currentPage = 0;
    private int linesPerPage = 30;
    private List<Chapter> chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        getWindow().setBackgroundDrawableResource(R.drawable.p01);

        tvChapterTitle = findViewById(R.id.tvChapterTitle);
        tvChapterContent = findViewById(R.id.tvChapterContent);
        tvPageNumber = findViewById(R.id.tvPageNumber);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");

            chapter = new Chapter(title, content);

            tvChapterTitle.setText(chapter.getTitle()); // 设置章节标题
            showPageContent();
            updatePageNumber();
        }
    }

    private void showPageContent() {
/*        int startIndex = currentPage * linesPerPage;
        int endIndex = Math.min(startIndex + linesPerPage, chapter.getContent().split("\n").length);
        String[] lines = chapter.getContent().split("\n");

        StringBuilder pageContent = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            pageContent.append(lines[i]).append("\n");
        }
        tvChapterContent.setText(pageContent.toString());*/

        if (chapter != null) {
            int startIndex = currentPage * linesPerPage;
            String[] lines = chapter.getContent().split("\n");

            StringBuilder pageContent = new StringBuilder();
            for (int i = startIndex; i < Math.min(startIndex + linesPerPage, lines.length); i++) {
                pageContent.append(lines[i]).append("\n");
            }
            tvChapterContent.setText(pageContent.toString());
        }

/*            if (chapters != null && currentChapterIndex >= 0 && currentChapterIndex < chapters.size()) {
                Chapter currentChapter = chapters.get(currentChapterIndex);
                int startIndex = currentPage * linesPerPage;
                String[] lines = currentChapter.getContent().split("\n");

                StringBuilder pageContent = new StringBuilder();
                for (int i = startIndex; i < Math.min(startIndex + linesPerPage, lines.length); i++) {
                    pageContent.append(lines[i]).append("\n");
                }
                tvChapterContent.setText(pageContent.toString());
            }*/

    }

    private void updatePageNumber() {
        int pageCount = chapter.getPageContent(linesPerPage);
        String pageNumberText = String.format("Page %d/%d", currentPage + 1, pageCount);
        tvPageNumber.setText(pageNumberText);

/*            if (chapters != null && currentChapterIndex >= 0 && currentChapterIndex < chapters.size()) {
                Chapter currentChapter = chapters.get(currentChapterIndex);
                int pageCount = currentChapter.getPageContent(linesPerPage);
                String pageNumberText = String.format("Page %d/%d", currentPage + 1, pageCount);
                tvPageNumber.setText(pageNumberText);
            }*/



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_previous:
                if (currentPage > 0) {
                    currentPage--;
                    showPageContent();
                    updatePageNumber();
                }
                return true;

            case R.id.action_next:
                int pageCount = chapter.getPageContent(linesPerPage);
                if (currentPage < pageCount - 1) {
                    currentPage++;
                    showPageContent();
                    updatePageNumber();
                }
/*                if (currentChapterIndex < chapters.size() - 1) {
                    currentChapterIndex++;
                    currentPage = 0;
                    showPageContent();
                    updatePageNumber();
                }*/
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chapter, menu);
        return true;
    }

}
