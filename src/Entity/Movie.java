package Entity;

public class Movie {
    int movieID;
    String title;
    String genre;
    String lang;
    int duration;

    public Movie(int movieID, String title, String genre, String lang, int duration) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.lang = lang;
        this.duration = duration;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
