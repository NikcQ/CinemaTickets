package DAO;

import entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Edisson
 */
public class ClientDAO {

    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("CinemAppPU");

    public static void create(Client client) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        try {
            mo.persist(client);
            mo.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            mo.getTransaction().rollback();
        } finally {
            mo.close();
        }
    }

    public static boolean delete(Client client) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        boolean ret = false;
        try {
            mo.remove(client);
            mo.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            mo.getTransaction().rollback();
        } finally {
            mo.close();
            return ret;
        }
    }

    public static Client read(Client client) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        Client cli = null;
        Query q = mo.createQuery("SELECT i FROM Client i " + "WHERE i.Ic LIKE :Ic").setParameter("Ic", client.getIc());
        try {
            cli = (Client) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            cli = (Client) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return cli;
        }
    }

    public static ArrayList<Client> readTable() {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        List<Client> listOfClients = new ArrayList<Client>();
        ArrayList<Client> listOfCli = new ArrayList<Client>();
        Query q = mo.createQuery("SELECT m FROM Movie m ");
        try {
            listOfClients = (List<Client>) q.getResultList();
            listOfCli = new ArrayList<Client>(listOfClients);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return listOfCli;
        }
    }

    public static boolean update(Client client, Client neoclient) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        boolean ret = false;
        try {
            client.setEmail(neoclient.getEmail());
            client.setScoreBalance(neoclient.getScoreBalance());
            client.setTotalScore(neoclient.getTotalScore());
            client.setCategory(neoclient.getCategory());
            mo.merge(client);
            mo.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            mo.getTransaction().rollback();
        } finally {
            mo.close();
            return ret;
        }
    }
}
