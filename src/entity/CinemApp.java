package entity;

import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class CinemApp {

    /**
     * @param args the command line arguments
     */
    private Theater cinema;
    private ArrayList<Movie> listings;

    /*
    public CinemApp(Theater cinema) {
        this.cinema = cinema;
    }
    */

    public Theater getCinema() {
        return cinema;
    }

    public void setCinema(Theater cinema) {
        this.cinema = cinema;
    }

}
