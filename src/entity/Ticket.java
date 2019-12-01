
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
  
    
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
  //  private Client client;
  //  private int discount;
    private int totalPrice;
    
    //private Movie movie;
    //private Screen screen;
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


    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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
