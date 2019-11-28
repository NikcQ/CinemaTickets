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

    private final static int[] prices2D={10000,12500,15000};
    private final static int[] prices3D={15000,20000,25000}; // {PRICE_GA, PRICE_VIP, PRICE_4DX}
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

    public Theater() {
        this.screens = new ArrayList<Screen>();
        this.projections = new ArrayList<Projection>();

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



    public int[] getPrices3D() {
        return prices3D;
    }

 
    public void addScreen(Screen u) {
        screens.add(u);
    }

}
