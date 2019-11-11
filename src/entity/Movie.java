/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name="Movies")
public class Movie {

    private String title;
    private ArrayList genre;
    private String[] languages;
    private String rating;
    private String cast; // Not really necessary
    private LocalDate releaseDate;
    private boolean is3D;
    private boolean is4D;
    // Static Fields
    private final static String[] MOVIE_GENRE = {" ","Documentary", "Historical","Musical","Comedy","Children's","Adventure/Action","Science Fiction"}; // Add movie genres in ENGLISH
    private final static String[] MOVIE_RATING = {"TP", "A7", "A12", "A15", "A18"};
    private final static String[] MOVIE_LANGS = {"English", "Spanish", "French", "Portuguese", "German"};
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie(String title, ArrayList genre, String[] languages, String rating, String cast, LocalDate releaseDate, boolean is3D, boolean is4D, int id) {
        this.title = title;
        this.genre = genre;
        this.languages = languages;
        this.rating = rating;
        this.cast = cast;
        this.releaseDate = releaseDate;
        this.is3D = is3D;
        this.is4D = is4D;
        this.id = id;
    }
    


    public Movie() {
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList getGenre() {
        return genre;
    }

    public void setGenre(ArrayList genre) {
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

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
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
