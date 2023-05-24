package fiction;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.logIn.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainReadActivity extends AppCompatActivity {

    private ListView lvChapterList;
    private List<Chapter> chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainread);


        lvChapterList = findViewById(R.id.lvChapterList);

        // 从assets文件夹中读取小说内容
        chapters = readNovelFromAssets("book2.txt");

        // 创建章节标题列表
        List<String> chapterTitles = getChapterTitles();

        // 将章节标题显示在ListView中
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_chapter, R.id.tvChapterTitle, chapterTitles);
        lvChapterList.setAdapter(adapter);


        // ListView点击事件，跳转到对应章节
        lvChapterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chapter chapter = chapters.get(position);
                Intent intent = new Intent(MainReadActivity.this, ChapterActivity.class);
                intent.putExtra("title", chapter.getTitle());
                intent.putExtra("content", chapter.getContent());
                startActivity(intent);
            }
        });
    }

    private List<Chapter> readNovelFromAssets(String fileName) {
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open(fileName);
            return ChapterExtractor.extractChapters(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getChapterTitles() {
        List<String> chapterTitles = new ArrayList<>();
        if (chapters != null) {
            for (Chapter chapter : chapters) {
                chapterTitles.add(chapter.getTitle());
            }
        }
        return chapterTitles;
    }
}
