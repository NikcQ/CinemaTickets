
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
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
    private Projection projection;
    
    private String category;
    private int row;
    private int[] seats;
    
    private int totalPrice;
    
    private static String[] CATEGORIES = {"GA", "VIP", "4DX"};

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

    public Ticket(Projection projection, String category, int row, int[] seats, int totalPrice) {
        this.projection = projection;
        this.seats = seats;
        this.row = row;
        this.category = category;
        this.totalPrice = totalPrice;
        
        this.purchaseDate = LocalDate.now();
        this.purchaseTime = LocalTime.now();
    }

    @Override
    public String toString() {
        return "Ticket{" + "purchaseDate=" + purchaseDate + ", purchaseTime=" + purchaseTime + ", projection=" + projection.getId() + ", category=" + category + ", row=" + row + ", seats=" + Arrays.toString(seats) + ", totalPrice=" + totalPrice + '}';
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

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public int[] getSeats() {
        return seats;
    }

    public void setSeats(int[] seats) {
        this.seats = seats;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static String[] getCATEGORIES() {
        return CATEGORIES;
    }

    public static void setCATEGORIES(String[] CATEGORIES) {
        Ticket.CATEGORIES = CATEGORIES;
    }
    
    
    
    
    
    
    

}