/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Projection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Home
 */
public class ProjectionDAO {
    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("CinemAppPU");
    
    public void create (Projection projection){
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        try{
            pr.persist(projection);
            pr.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            pr.getTransaction().rollback();
        }finally{
            pr.close();
        }
    }
    
    public boolean delete(Projection projection){
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        boolean ret = false;
        try{
            pr.remove(projection);
            pr.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            pr.getTransaction().rollback();
        }finally{
            pr.close();
            return ret;
        }
    }
    
    public Projection read(Projection projection){
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        Projection otherprojection = null;
        Query q = pr.createQuery("SELECT p FROM Projection p "+"WHERE p.movie LIKE :movie"+" AND p.screen LIKE :screen").setParameter("movie", projection.getMovie()).setParameter("screen", projection.getScreen());
        try{
            otherprojection = (Projection) q.getSingleResult();
        }catch(NonUniqueResultException e){
            otherprojection = (Projection) q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            pr.close();
            return otherprojection;
        }
    }
    
    public boolean update(Projection projection,Projection neoprojection){
        EntityManager pr = efm.createEntityManager();
        pr.getTransaction().begin();
        boolean ret = false;
        try{
            projection = read(projection);
            projection.setMovie(neoprojection.getMovie());
            projection.setScreen(neoprojection.getScreen());
            projection.setDateTime(neoprojection.getDateTime());
            projection.setIs3D(neoprojection.isIs3D());
            projection.setIs4D(neoprojection.isIs4D());
            projection.setId(neoprojection.getId());
            pr.merge(projection);
            pr.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            pr.getTransaction().rollback();
        }finally{
            pr.close();
            return ret;
        }
    }
    
}
