/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDateTime;

/**
 *
 * @author juanc
 */
public class Projection {

    private Movie movie;
    private Screen screen;
    private LocalDateTime dateTime;
    private boolean is3D;
    private boolean is4D;

    public Projection(Movie movie, Screen screen, LocalDateTime dateTime, boolean is3D, boolean is4D) {
        this.movie = movie;
        this.screen = screen;
        this.dateTime = dateTime;
        this.is3D = is3D;
        this.is4D = is4D;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

}
