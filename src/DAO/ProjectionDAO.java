/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Projection;
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
public final class ProjectionDAO {

    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("CinemAppPU");

    public static void create(Projection projection) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        try {
            pr.persist(projection);
            pr.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            pr.getTransaction().rollback();
        } finally {
            pr.close();
        }
    }

    public static boolean delete(Projection projection) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        boolean ret = false;
        try {
            pr.remove(projection);
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

    public static Projection read(Projection projection) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        Projection otherprojection = null;
        Query q = pr.createQuery("SELECT p FROM Projection p " + "WHERE p.id = :id").setParameter("id", projection.getId());
        try {
            otherprojection = (Projection) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            otherprojection = (Projection) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pr.close();
            return otherprojection;
        }
    }

    public static ArrayList<Projection> readTable() {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        List<Projection> listOfProjections = new ArrayList<Projection>();
        ArrayList<Projection> listofPro = new ArrayList<Projection>();
        Query q = mo.createQuery("SELECT m FROM Projection m ");
        try {
            listOfProjections = (List<Projection>) q.getResultList();
            listofPro = new ArrayList<Projection>(listOfProjections);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return listofPro;
        }
    }

    public static boolean update(Projection projection, Projection neoprojection) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        boolean ret = false;
        try {
            projection = read(projection);
            projection.setMovie(neoprojection.getMovie());
            projection.setScreen(neoprojection.getScreen());
            projection.setDate(neoprojection.getDate());
            projection.setTime(neoprojection.getTime());
            projection.setIs3D(neoprojection.isIs3D());
            projection.setIs4D(neoprojection.isIs4D());
            projection.setId(neoprojection.getId());
            projection.setBlockGA(neoprojection.getBlockGA());
            projection.setBlockVIP(neoprojection.getBlockVIP());
            projection.setBlock4DX(neoprojection.getBlock4DX());
            pr.merge(projection);
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

    public static boolean updateBlock(Projection projection, boolean[][] block, String cat) {
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        boolean ret = false;
        try {
            projection = read(projection);

            if (cat.equals("GA")) {
                projection.setBlockGA(block);
            } else if (cat.equals("VIP")) {
                projection.setBlockVIP(block);
            } else if (cat.equals("4DX")) {
                projection.setBlock4DX(block);
            }

            pr.merge(projection);
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

    private ProjectionDAO() {
    }

}
