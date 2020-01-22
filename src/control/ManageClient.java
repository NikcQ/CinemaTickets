package control;

import DAO.ClientDAO;
import DAO.ProjectionDAO;
import entity.Client;
import java.time.LocalDate;

/**
 *
 * @author Edisson
 */

public class ManageClient {

    public static String verifyClient(String name, String lastName, String ic, LocalDate birthDate, String mail, String phone, String address) {

        Client newClient = new Client(name, lastName, ic, birthDate, mail, phone, address);

        if (name.length() > 35 || name.length() < 2 || name.isEmpty()) {
            return "Invalid Name";
        }
        if (lastName.length() > 35 || lastName.length() < 2 || lastName.isEmpty()) {
            return "Invalid Lastname";
        }
        /*  if (ic < 1 || ic > 20) {
            return "Invalid ic length";
        }*/
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
            return "Invalid phone name";
        }
        if (address.length() < 7 || address.length() > 50) {
            return "Invalid address length";
        }

        ClientDAO cdao = new ClientDAO();
        cdao.create(newClient);
        return "Client successfully registered.";
    }

    //Metodo que agrega el puntaje al cliente
    public static void addScore(int points, char m) {

    }

    // Función que verifica si el cliente existe
    private static boolean checkID() {

        return false;
    }
    //Metodo que verifica si se debe ascender de categoria el cliente

    public static boolean upgrade(int points, char m) {

        return false;
    }

}
