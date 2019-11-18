package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author NikcQ
 */
@Entity
@Table(name = "Screens")
public class Screen implements Serializable {

//seat block order is GA - VIP - 4DX(if availlable)
    private int rowGA;
    private int colGA;
    private int rowVIP;
    private int colVIP;
    private int row4DX;
    private int col4DX;
    private boolean is3D;             //Specifies if the movie is projected in 3D or not. Default is FALSE
    private String name;              //names the screen as in "1", "2", "3", etc...

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Screen(int rowGA, int colGA, int rowVIP, int colVIP, int row4DX, int col4DX, boolean is3D, String name) {
        this.rowGA = rowGA;
        this.colGA = colGA;
        this.rowVIP = rowVIP;
        this.colVIP = colVIP;
        this.row4DX = row4DX;
        this.col4DX = col4DX;

        this.is3D = is3D;
        this.name = name;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public int getRowGA() {
        return rowGA;
    }

    public void setRowGA(int rowGA) {
        this.rowGA = rowGA;
    }

    public int getColGA() {
        return colGA;
    }

    public void setColGA(int colGA) {
        this.colGA = colGA;
    }

    public int getRowVIP() {
        return rowVIP;
    }

    public void setRowVIP(int rowVIP) {
        this.rowVIP = rowVIP;
    }

    public int getColVIP() {
        return colVIP;
    }

    public void setColVIP(int colVIP) {
        this.colVIP = colVIP;
    }

    public int getRow4DX() {
        return row4DX;
    }

    public void setRow4DX(int row4DX) {
        this.row4DX = row4DX;
    }

    public int getCol4DX() {
        return col4DX;
    }

    public void setCol4DX(int col4DX) {
        this.col4DX = col4DX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
