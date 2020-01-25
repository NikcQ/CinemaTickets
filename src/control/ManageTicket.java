package control;

import DAO.ClientDAO;
import DAO.ProjectionDAO;
import DAO.TicketDAO;
import entity.Projection;
import entity.Ticket;
import java.util.Arrays;

/**
 *
 * @author
 */
public class ManageTicket {

    public static String verifySeats(Projection proj, String cat, int row, int[] seats, String cid, boolean redeem) {
        // Check for client id
        if (!cid.isEmpty() && ClientDAO.read(cid) == null) {
            return "Client ID not found in records";
        }else if(cid.isEmpty() && redeem){
            return "Valid client ID necessary for redemption";
        }

        int price;// Calculate price
        if (proj.isIs3D()) {
            price = seats.length * CinemApp.getPrices3D()[Arrays.asList(Ticket.getCATEGORIES()).indexOf(cat)];
        } else {
            price = seats.length * CinemApp.getPrices2D()[Arrays.asList(Ticket.getCATEGORIES()).indexOf(cat)];
        }

        // Add points to costumer if available
        if (!cid.isEmpty() && redeem && !ManageClient.checkScore(cid, price / 100)) {
            return "Score balance is insufficient for purchase.";
        }

        // Update seat block
        boolean[][] block = ManageProjection.getSeatBlock(proj, cat);
        for (int i = 0; i < seats.length; i++) {
            if (block[row][seats[i] - 1]) {
                return "One of the selected seats is not avaliable.";
            } else {
                block[row][seats[i] - 1] = true;
            }
        }

        // Update block in projection
        Projection neoproj = ProjectionDAO.read(proj);
        switch (cat) {
            case "GA":
                neoproj.setBlockGA(block);
                break;
            case "VIP":
                neoproj.setBlockVIP(block);
                break;
            case "4DX":
                neoproj.setBlock4DX(block);
                break;
            default:
                break;
        }

        if (ProjectionDAO.update(proj, neoproj)) {
            if (!cid.isEmpty()) {
                if (!redeem) {
                    ManageClient.addScore(cid, price / 1000);
                } else {
                    ManageClient.addScore(cid, -price / 100);
                }
            }
            // Build and persist ticket
            Ticket tick = new Ticket(proj, cat, row, seats, redeem ? 0 : price);
            //mainFrame.cinemapp.addTicket(tick);
            //TicketDAO tdao = new TicketDAO();
            TicketDAO.create(tick);

            return "Ticket sale registered successfully.";
        } else {
            return "Ticket sale failed, please try again.";
        }
    }

}
