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

    public static String verifyClient(String name, String lastName, LocalDate birthDate,String ic,  String phone, String mail, String address) {

        Client newClient = new Client(name, lastName, ic, birthDate, mail, phone, address);

        if (name.length() > 35 || name.length() < 2 || name.isEmpty()) {
            return "Invalid Name";
        }
        if (lastName.length() > 35 || lastName.length() < 2 || lastName.isEmpty()) {
            return "Invalid Lastname";
        }
        if (checkID(ic)==true){
            return "existing user";
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

        //ClientDAO cdao = new ClientDAO();
        ClientDAO.create(newClient);
        return "Client successfully registered.";
    }

    //Metodo que agrega el puntaje al cliente
    public static void addScore(String ic, int points) {
        Client c = ClientDAO.read(ic);
        Client d = ClientDAO.read(ic);
        d.setScoreBalance(c.getScoreBalance() + points);
        ClientDAO.update(c, d);
    }
    
    // Check if client has enough points
    public static boolean checkScore(String ic, int points) {
        return ClientDAO.read(ic).getScoreBalance() >= points ? true : false;
    }

    // Función que verifica si el cliente existe
    private static boolean checkID( String ic) {
        Client a = ClientDAO.read(ic);
        if (a==null){
        return false;
        }
        return true;
    }
    //Metodo que verifica si se debe ascender de categoria el cliente

    public static boolean upgrade(int points, char m) {

        return false;
    }

}
