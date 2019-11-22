package entity;
//

import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "Movies")
public class Movie {

    private String title;
    private int runtime;
    private String rating;
    private boolean is3D;
    private boolean is4D;
    // NOT IN CONSTRUCTOR
    private LocalDate releaseDate;
    private String[] genre;
    private String[] languages;
    // Static Fields
    private final static String[] MOVIE_GENRE = {" ", "Documentary", "Historical", "Musical", "Comedy", "Children's", "Adventure/Action", "Science Fiction", "Thriller"}; // Add movie genres in ENGLISH
    private final static String[] MOVIE_RATING = {"TP", "A7", "A12", "A15", "A18"};
    private final static String[] MOVIE_LANGS = {" ", "English", "Spanish", "French", "Portuguese", "German", "Doblada"};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie() {
    }
    
    public Movie(String title, int runtime, String rating, boolean is3D, boolean is4D) {
        this.title = title;
        this.runtime = runtime;
        this.rating = rating;
        this.is3D = is3D;
        this.is4D = is4D;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public boolean isIs4D() {
        return is4D;
    }

    public void setIs4D(boolean is4D) {
        this.is4D = is4D;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public static String[] getMOVIE_GENRE() {
        return MOVIE_GENRE;
    }

    public static String[] getMOVIE_RATING() {
        return MOVIE_RATING;
    }

    public static String[] getMOVIE_LANGS() {
        return MOVIE_LANGS;
    }

}
