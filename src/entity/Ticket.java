
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Edisson
 */
@Entity
@Table(name = "Tickets")
public class Ticket implements Serializable {
  
    private Movie movie;
    private Screen screen;
    private LocalDate date;
    private LocalTime time;
  //  private Client client;
  //  private int discount;
    private int amountOfMoney;  
    private Projection projection;
    private int numberOfGASeats;
    private int numberOfVIPSeats;
    private int numberOf4DSeats;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket() {
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

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public int getNumberOfGASeats() {
        return numberOfGASeats;
    }

    public void setNumberOfGASeats(int numberOfGASeats) {
        this.numberOfGASeats = numberOfGASeats;
    }

    public int getNumberOfVIPSeats() {
        return numberOfVIPSeats;
    }

    public void setNumberOfVIPSeats(int numberOfVIPSeats) {
        this.numberOfVIPSeats = numberOfVIPSeats;
    }

    public int getNumberOf4DSeats() {
        return numberOf4DSeats;
    }

    public void setNumberOf4DSeats(int numberOf4DSeats) {
        this.numberOf4DSeats = numberOf4DSeats;
    }
    

}
