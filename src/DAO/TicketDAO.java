package DAO;

import entity.Projection;
import entity.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Edisson
 */
public final class TicketDAO {

    private TicketDAO() {
    }

    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("CinemAppPU");

    public static void create(Ticket ticket) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        try {
            pr.persist(ticket);
            pr.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            pr.getTransaction().rollback();
        } finally {
            pr.close();
        }
    }

    public static boolean delete(Ticket ticket) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        boolean ret = false;
        try {
            pr.remove(ticket);
            pr.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            pr.getTransaction().rollback();
        } finally {
            pr.close();
            return ret;
        }
    }

    public static Ticket read(Ticket ticket) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        Ticket otherticket = null;
        Query q = pr.createQuery("SELECT t FROM Ticket t " + "WHERE t.id LIKE :ticket").setParameter("ticket", ticket.getId());
        try {
            otherticket = (Ticket) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            otherticket = (Ticket) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pr.close();
            return otherticket;
        }
    }

    public static ArrayList<Ticket> readTable() {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        List<Ticket> listOfTickets = new ArrayList<Ticket>();
        ArrayList<Ticket> listofTix = new ArrayList<Ticket>();
        Query q = mo.createQuery("SELECT m FROM Ticket m ");
        try {
            listOfTickets = (List<Ticket>) q.getResultList();
            listofTix = new ArrayList<Ticket>(listOfTickets);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return listofTix;
        }
    }
    
    public static ArrayList<Ticket> readByProjection(Projection proj) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        List<Ticket> listOfTickets = new ArrayList<Ticket>();
        ArrayList<Ticket> listofTix = new ArrayList<Ticket>();
        Query q = mo.createQuery("SELECT t FROM Ticket t "+"WHERE t.projection = :p").setParameter("p", proj);
        try {
            listOfTickets = (List<Ticket>) q.getResultList();
            listofTix = new ArrayList<Ticket>(listOfTickets);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return listofTix;
        }
    }

    /*
    public boolean update(Ticket ticket,Ticket neoticket){
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        boolean ret = false;
        try{
            ticket = read(neoticket);
            ticket.setMovie(neoticket.getMovie());
            ticket.setScreen(neoticket.getScreen());
            pr.merge(ticket);
            pr.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            pr.getTransaction().rollback();
        }finally{
            pr.close();
            return ret;
        }
    }*/
}
