package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Client;
import entity.Projection;
import entity.Ticket;
import java.io.FileOutputStream;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public final class ManageTicket {

    public static String verifySeats(Projection proj, String cat, int row, int[] seats, String cid, boolean redeem) {
        // Check for client id
        Client cli = new Client();
        cli = CinemApp.rClient(cid);
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
            generarFactura(tick.getId(), cid, cli.getFname(), proj.getTime(), proj.getScreen().getName(), price, cat);
            return "Ticket sale registered successfully.";
        } else {
            return "Ticket sale failed, please try again.";
        }
    }

    public static void generarFactura(int id, String cid, String name, LocalTime sTime, String sName, int price, String category) {
        String rut = "C:\\Users\\Johan_Prieto\\Downloads\\Factura";
        String separador = "----------------------------------------------";
        String cuadro = "****************************************";
        try {
            FileOutputStream archivo = new FileOutputStream(rut + String.valueOf(id) + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            doc.add(new Paragraph("             CINEMAPP"));
            doc.add(new Paragraph("           Nit 00000000-0"));
            doc.add(new Paragraph("        Universidad Nacional"));
            doc.add(new Paragraph("              Sede Bogota"));
            doc.add(new Paragraph("Fecha: " + LocalDate.now() + " Hora: " + Time.valueOf(LocalTime.now())));
            doc.add(new Paragraph(separador));
            doc.add(new Paragraph("FACTURA DE VENTA No. " + id));
            doc.add(new Paragraph("Cliente: " + name));
            doc.add(new Paragraph("C.C: " + cid));
            doc.add(new Paragraph(separador));
            doc.add(new Paragraph("Hora de función: " + sTime));
            doc.add(new Paragraph("Sala: " + sName));
            doc.add(new Paragraph("Categoria: " + category));
            doc.add(new Paragraph("Total: " + price));
            doc.add(new Paragraph(cuadro));
            doc.add(new Paragraph("*         Gracias por preferirnos       *"));
            doc.add(new Paragraph(cuadro));
            doc.close();
            JOptionPane.showMessageDialog(null, "Factura de venta creada");
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    private ManageTicket() {
    }
}
