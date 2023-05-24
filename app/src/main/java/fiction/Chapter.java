package fiction;

public class Chapter {
    private String title;
    private String content;

    public Chapter(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public int getPageContent(int linesPerPage) {
        int lineCount = content.split("\n").length;
        return (int) Math.ceil((double) lineCount / linesPerPage);
    }

}
