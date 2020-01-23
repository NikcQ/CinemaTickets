package control;

import DAO.ProjectionDAO;
import DAO.TicketDAO;
import boundary.mainFrame;
import entity.Projection;
import entity.Ticket;
import java.util.Arrays;

/**
 *
 * @author
 */
public class ManageTicket {

    public static String verifySeats(Projection proj, String cat, int row, int[] seats) {
        boolean[][] block = ManageProjection.getSeatBlock(proj, cat);
        for (int i = 0; i < seats.length; i++) {
            if (block[row][seats[i] - 1]) {
                return "One of the selected seats is not avaliable.";
            } else {
                block[row][seats[i] - 1] = true;
            }
        }
        
        Projection neoproj = ProjectionDAO.read(proj);
        if (cat.equals("GA")) {
            neoproj.setBlockGA(block);
        } else if (cat.equals("VIP")) {
            neoproj.setBlockVIP(block);
        } else if (cat.equals("4DX")) {
            neoproj.setBlock4DX(block);
        }

        if (ProjectionDAO.update(proj, neoproj)) {
            int price;
            if (proj.isIs3D()) {
                price = seats.length * mainFrame.cinemapp.getPrices3D()[Arrays.asList(Ticket.getCATEGORIES()).indexOf(cat)];
            } else {
                price = seats.length * mainFrame.cinemapp.getPrices2D()[Arrays.asList(Ticket.getCATEGORIES()).indexOf(cat)];
            }
            Ticket tick = new Ticket(proj, cat, row, seats, price);

            //mainFrame.cinemapp.addTicket(tick);
            TicketDAO tdao = new TicketDAO();
            tdao.create(tick);

            return "Ticket sale registered successfully.";
        } else {
            return "Ticket sale failed, please try again.";
        }
    }

}
