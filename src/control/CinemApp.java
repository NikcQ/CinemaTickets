package control;

import DAO.ClientDAO;
import DAO.MovieDAO;
import DAO.ProjectionDAO;
import DAO.ScreenDAO;
import DAO.TicketDAO;
import entity.Client;
import entity.Movie;
import entity.Projection;
import entity.Screen;
import entity.Ticket;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author juanc
 */
public class CinemApp {

    private final static int[] prices2D = {10000, 12500, 15000};
    private final static int[] prices3D = {15000, 20000, 25000}; // {PRICE_GA, PRICE_VIP, PRICE_4DX}
//    private static ArrayList<Screen> screens;
//    private static ArrayList<Projection> projections;
//    private static ArrayList<Ticket> tickets;
//    private static ArrayList<Movie> listings;
//    private static ArrayList<Client> clients;
//    private static String theatreName;

    public static int[] getPrices2D() {
        return prices2D;
    }

    public static int[] getPrices3D() {
        return prices3D;
    }

    public static ArrayList<Screen> getScreens() {
        return ScreenDAO.readTable();
    }

    public static ArrayList<Projection> getProjections() {
        return ProjectionDAO.readTable();
    }

    public static ArrayList<Ticket> getTickets() {
        return TicketDAO.readTable();
    }

    public static ArrayList<Movie> getListings() {
        return MovieDAO.readTable();
    }

    public static ArrayList<Client> getClients() {
        return ClientDAO.readTable();
    }

    public CinemApp() {
    }

}
