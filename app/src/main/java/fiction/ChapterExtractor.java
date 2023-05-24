package fiction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChapterExtractor {

    public static List<Chapter> extractChapters(InputStream inputStream) {
        List<Chapter> chapters = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String chapterTitle = null;
            StringBuilder chapterContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (isChapterTitle(line)) {
                    if (chapterTitle != null) {
                        chapters.add(new Chapter(chapterTitle, chapterContent.toString()));
                    }
                    chapterTitle = getChapterTitle(line);
                    chapterContent = new StringBuilder();
                } else {
                    chapterContent.append(line).append("\n");
                }
            }

            if (chapterTitle != null && chapterContent.length() > 0) {
                chapters.add(new Chapter(chapterTitle, chapterContent.toString()));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chapters;
    }

    private static boolean isChapterTitle(String line) {
        String pattern = "^===第[一二三四五六七八九十百千万亿]+章\\s+.+===$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(line);
        return matcher.matches();
    }

    private static String getChapterTitle(String line) {
        String pattern = "^===第([一二三四五六七八九十百千万亿]+)章\\s+(.+)===";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(line);
        if (matcher.find()) {
            return matcher.group(2);  // 返回第二个捕获组（章节标题）
        }
        return "";
    }
}
