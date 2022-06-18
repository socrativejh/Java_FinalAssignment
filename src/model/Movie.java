package model;

public class Movie {
    private String name;
    private int pg;
    private String image; // for storing image path
    private String genre;
    private String cast;
    private String summary;
    
    // constructor for initializing 6 variables
    public Movie(String name, int pg, String image, String genre, String cast, String summary) {
        this.name = name;
        this.pg = pg;
        this.image = image;
        this.genre = genre;
        this.cast = cast;
        this.summary = summary;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Movie() {

    }

    @Override // for making values into one String
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", pg=" + pg +
                ", image='" + image + '\'' +
                ", genre='" + genre + '\'' +
                ", cast='" + cast + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
