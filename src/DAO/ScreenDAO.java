/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Movie;
import entity.Screen;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Home
 */
public class ScreenDAO {

    private ScreenDAO() {
    }

    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("CinemAppPU");

    public static void create(Screen screen) {
        EntityManager sc = efm.createEntityManager();
        sc.getTransaction().begin();
        try {
            sc.persist(screen);
            sc.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            sc.getTransaction().rollback();
        } finally {
            sc.close();
        }
    }

    public static boolean delete(Screen screen) {
        EntityManager sc = efm.createEntityManager();
        sc.getTransaction().begin();
        boolean ret = false;
        try {
            sc.remove(screen);
            sc.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            sc.getTransaction().rollback();
        } finally {
            sc.close();
            return ret;
        }
    }

    public static Screen read(Screen screen) {
        EntityManager sc = efm.createEntityManager();
        sc.getTransaction().begin();
        Screen secondsc = null;
        Query q = sc.createQuery("SELECT s FROM Screen s " + "WHERE s.title LIKE :name").setParameter("name", screen.getName());            //falta parametro indicador de la busqueda
        try {
            secondsc = (Screen) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            secondsc = (Screen) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
            return secondsc;
        }
    }

    public static ArrayList<Screen> readTable() {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        List<Screen> listOfScreens = new ArrayList<Screen>();
        ArrayList<Screen> listofScr = new ArrayList<Screen>();
        Query q = mo.createQuery("SELECT m FROM Screen m ");
        try {
            listOfScreens = (List<Screen>) q.getResultList();
            listofScr = new ArrayList<Screen>(listOfScreens);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return listofScr;
        }
    }

    public static boolean update(Screen screen, Screen neoscreen) {  //es necesario que read este completo para el uso de update
        EntityManager sc = efm.createEntityManager();
        sc.getTransaction().begin();
        boolean ret = false;
        try {
            screen = read(screen);
            screen.setRowGA(neoscreen.getRowGA());
            screen.setColGA(neoscreen.getColGA());

            screen.setRowVIP(neoscreen.getRowVIP());
            screen.setColVIP(neoscreen.getColVIP());

            screen.setRow4DX(neoscreen.getRow4DX());
            screen.setCol4DX(neoscreen.getCol4DX());

            screen.setIs3D(neoscreen.isIs3D());
            screen.setId(neoscreen.getId());
            sc.merge(screen);
            sc.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            sc.getTransaction().rollback();
        } finally {
            sc.close();
            return ret;
        }
    }

}
