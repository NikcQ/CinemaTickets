package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juanc
 */


@Entity
@Table(name = "Projections")

public class Projection implements Serializable {
    
    
    private LocalDate date;
    private LocalTime time;
    private boolean is3D;
    private boolean is4D;
    private boolean blockGA[][];   //matrix that contains the availlability of general seats. Default is FALSE
    private boolean blockVIP[][];   //matrix that contains the availlability of VIP seats. Default is FALSE
    private boolean block4DX[][]; //matrix that contains the availlability of 4DX seats. Default is FALSE
    
    
    @OneToOne
    private Movie movie;
    @OneToOne
    private Screen screen;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Projection() {
    }

    public Projection(Movie movie, Screen screen, LocalDate date, LocalTime time, boolean is3D, boolean is4D) {
        this.movie = movie;
        this.screen = screen;
        this.date = date;
        this.time = time;
        this.is3D = is3D;
        this.is4D = is4D;
        this.blockGA = new boolean[screen.getRowGA()][screen.getColGA()];
        this.blockVIP = new boolean[screen.getRowVIP()][screen.getColVIP()];
        this.block4DX = new boolean[screen.getRow4DX()][screen.getCol4DX()];
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public boolean[][] getBlockGA() {
        return blockGA;
    }

    public void setBlockGA(boolean[][] blockGA) {
        this.blockGA = blockGA;
    }

    public boolean[][] getBlockVIP() {
        return blockVIP;
    }

    public void setBlockVIP(boolean[][] blockVIP) {
        this.blockVIP = blockVIP;
    }

    public boolean[][] getBlock4DX() {
        return block4DX;
    }

    public void setBlock4DX(boolean[][] block4DX) {
        this.block4DX = block4DX;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "Projection{" + "movie=" + movie.getId() + ", screen=" + screen.getId() + ", date=" + date + ", time=" + time + ", is3D=" + is3D + ", is4D=" + is4D + ", id=" + id + '}';
    }

    public String getDescription(boolean withDate) {
        return (withDate ? date + " | " + time : time) + (is3D ? " | 3D" : " | 2D") + (is4D ? " - 4D |" : " | ") + movie.getTitle() + " - " + id;
    }

    public int numberOfAvailableSeats(boolean block[][]) {
        int seats = 0;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                seats++;
            }

        }
        return seats;
    }
}
