/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Theater;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Home
 */
public class TheatreDAO {
    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("CinemAppPU");
    
    public void create (Theater theater){
        EntityManager th = efm.createEntityManager();
        th.getTransaction().begin();
        try{
            th.persist(theater);
            th.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            th.getTransaction().rollback();
        }finally{
            th.close();
        }
    }
    
    public boolean delete(Theater theater){
        EntityManager th = efm.createEntityManager();
        th.getTransaction().begin();
        boolean ret = false;
        try{
            th.remove(theater);
            th.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            th.getTransaction().rollback();
        }finally{
            th.close();
            return ret;
        }
    }
    
    public Theater read(Theater theater){
        EntityManager th = efm.createEntityManager();
        th.getTransaction().begin();
        Theater othertheater = null;
        Query q = th.createQuery("SELECT t FROM Theater t "+"WHERE t.id LIKE :id").setParameter("id", theater.getId());
        try{
            othertheater = (Theater) q.getSingleResult();
        }catch(NonUniqueResultException e){
            othertheater = (Theater) q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            th.close();
            return othertheater;
        }
    }
    
    public boolean update(Theater theater,Theater neotheater){
        EntityManager th = efm.createEntityManager();
        th.getTransaction().begin();
        boolean ret = false;
        try{
            theater = read(theater);
            theater.setScreens(neotheater.getScreens());
            theater.setPrices2D(neotheater.getPrices2D());
            theater.setPrices3D(neotheater.getPrices3D());
            theater.setProjections(neotheater.getProjections());
            theater.setId(neotheater.getId());
            th.merge(theater);
            th.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            th.getTransaction().rollback();
        }finally{
            th.close();
            return ret;
        }
    }
    
}
