package entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "Theatres")
public class Theater implements Serializable {

    private ArrayList<Screen> screens;
    private ArrayList<Projection> projections;

    private int[] prices2D; // {PRICE_GA, PRICE_VIP, PRICE_4DX}
    private int[] prices3D; // {PRICE_GA, PRICE_VIP, PRICE_4DX}
    private String theatreName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Theater(int[] cost2D, int[] cost3D) {
        this.screens = new ArrayList<Screen>();
        this.projections = new ArrayList<Projection>();
        
        this.prices2D = cost2D;
        this.prices3D = cost3D;
    }

    public ArrayList<Projection> getProjections() {
        return projections;
    }

    public void setProjections(ArrayList<Projection> projections) {
        this.projections = projections;
    }

    public ArrayList<Screen> getScreens() {
        return screens;
    }

    public void setScreens(ArrayList<Screen> screens) {
        this.screens = screens;
    }

    public int[] getPrices2D() {
        return prices2D;
    }

    public void setPrices2D(int[] prices2D) {
        this.prices2D = prices2D;
    }

    public int[] getPrices3D() {
        return prices3D;
    }

    public void setPrices3D(int[] prices3D) {
        this.prices3D = prices3D;
    }

}
