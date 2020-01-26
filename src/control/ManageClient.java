package control;

import entity.Client;
import java.time.LocalDate;

/**
 *
 * @author Edisson
 */
public final class ManageClient {

    //Metodo que agrega el puntaje al cliente
    public static void addScore(String ic, int points) {
        Client c = CinemApp.rClient(ic);
        Client d = CinemApp.rClient(ic);
        d.setScoreBalance(c.getScoreBalance() + points);
        CinemApp.uClient(c, d);
    }

    // Función que verifica si el cliente existe
    private static boolean checkExistingId(String ic) {
        Client a = CinemApp.rClient(ic);
        if (a == null) {
            return false;
        }
        return true;
    }

    //Metodo que verifica si se debe ascender de categoria el cliente
    // Check if client has enough points
    public static boolean checkScore(String ic, int points) {
        return CinemApp.rClient(ic).getScoreBalance() >= points ? true : false;
    }

    public static boolean upgrade(int points, char m) {

        return false;
    }

    public static String verifyClient(String name, String lastName, LocalDate birthDate, String ic, String phone, String mail, String address) {

        Client newClient = new Client(name, lastName, birthDate, ic, phone, mail, address);

        if (name.length() > 35 || name.length() < 2 || name.isEmpty()) {
            return "Invalid Name";
        }
        if (lastName.length() > 35 || lastName.length() < 2 || lastName.isEmpty()) {
            return "Invalid Lastname";
        }
        if (checkExistingId(ic)) {
            return "existing user";
        }

        if (birthDate.isBefore(LocalDate.of(1900, 01, 01))) {
            return "Invalid birthDate";
        }
        if (birthDate.isAfter(LocalDate.now().minusYears(16))) {
            return "The client must be 16 or older";
        }
        if (mail.length() < 7 || mail.length() > 40) {
            return "Invalid mail length";
        }
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        if (address.length() < 7 || address.length() > 50) {
            return "Invalid address length";
        }

        CinemApp.cClient(newClient);
        return "Client successfully registered.";
    }

    private ManageClient() {
    }

}
