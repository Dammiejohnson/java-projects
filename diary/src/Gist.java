import java.time.LocalDateTime;

public class Gist {
    private String title;
    private LocalDateTime time = LocalDateTime.now();
    private String gist;

    public Gist(String entryTitle, String amebo) {
        this.title = entryTitle;
        this.gist = amebo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getGist() {
        return gist;
    }

    public void setGist(String gist) {
        this.gist = gist;
    }

    @Override
    public String toString() {
        return "Gist{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", gist='" + gist + '\'' +
                '}';
    }
}
