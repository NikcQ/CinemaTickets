package control;

import entity.Projection;
import entity.Ticket;
import java.util.Arrays;

/**
 *
 * @author
 */
public final class ManageTicket {

    public static String verifySeats(Projection proj, String cat, int row, int[] seats, String cid, boolean redeem) {
        // Check for client id
        if (!cid.isEmpty() && CinemApp.rClient(cid) == null) {
            return "Client ID not found in records";
        } else if (cid.isEmpty() && redeem) {
            return "Valid client ID necessary for redemption";
        }

        int price;// Calculate price
        if (proj.isIs3D()) {
            price = seats.length * CinemApp.get3DPrices()[Arrays.asList(Ticket.getCATEGORIES()).indexOf(cat)];
        } else {
            price = seats.length * CinemApp.get2DPrices()[Arrays.asList(Ticket.getCATEGORIES()).indexOf(cat)];
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
        Projection neoproj = CinemApp.rProjection(proj);
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

        if (CinemApp.uProjection(proj, neoproj)) {
            if (!cid.isEmpty()) {
                if (!redeem) {
                    ManageClient.addScore(cid, price / 1000);
                } else {
                    ManageClient.addScore(cid, -price / 100);
                }
            }
            // Build and persist ticket
            Ticket tick = new Ticket(proj, cat, row, seats, redeem ? 0 : price);
            CinemApp.cTicket(tick);

            return "Ticket sale registered successfully.";
        } else {
            return "Ticket sale failed, please try again.";
        }
    }

    private ManageTicket() {
    }

}
