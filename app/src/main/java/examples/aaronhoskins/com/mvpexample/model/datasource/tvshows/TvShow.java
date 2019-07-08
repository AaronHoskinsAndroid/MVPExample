package examples.aaronhoskins.com.mvpexample.model.datasource.tvshows;

public class TvShow {
    private String title;
    private String description;
    private int season;
    private String rating;

    public TvShow() {
    }

    public TvShow(String title, String description, int season, String rating) {
        this.title = title;
        this.description = description;
        this.season = season;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
