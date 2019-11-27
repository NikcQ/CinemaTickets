package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "Projections")
public class Projection implements Serializable {

    private Movie movie;
    private Screen screen;
    private LocalDateTime dateTime;
    private boolean is3D;
    private boolean is4D;
    private boolean blockGA[][];   //matrix that contains the availlability of general seats. Default is FALSE
    private boolean blockVIP[][];   //matrix that contains the availlability of VIP seats. Default is FALSE
    private boolean block4DX[][]; //matrix that contains the availlability of 4DX seats. Default is FALSE

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
    
    public Projection(Movie movie, Screen screen, LocalDateTime dateTime, boolean is3D, boolean is4D,
            int rowGA, int colGA, int rowVIP, int colVIP, int row4DX, int col4DX) {
        this.movie = movie;
        this.screen = screen;
        this.dateTime = dateTime;
        this.is3D = is3D;
        this.is4D = is4D;

        this.blockGA = new boolean[rowGA][colGA];
        this.blockVIP = new boolean[rowVIP][colVIP];
        this.block4DX = new boolean[row4DX][col4DX];
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
}
