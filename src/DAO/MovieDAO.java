/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Movie;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Home
 */
public class MovieDAO {
    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("TheaterPersistenceJPAPU");
    
    public void create (Movie movie){
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        try{
            mo.persist(movie);
            mo.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            mo.getTransaction().rollback();
        }finally{
            mo.close();
        }
    }
    
    public boolean delete(Movie movie){
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        boolean ret = false;
        try{
            mo.remove(movie);
            mo.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            mo.getTransaction().rollback();
        }finally{
            mo.close();
            return ret;
        }
    }
    
    public Movie read(Movie movie){
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        Movie film = null;
        Query q = mo.createQuery("SELECT m FROM Movie m "+"WHERE u.title LIKE :title").setParameter("title", movie.getTitle());
        try{
            film = (Movie) q.getSingleResult();
        }catch(NonUniqueResultException e){
            film = (Movie) q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            mo.close();
            return film;
        }
    }
    
    public boolean update(Movie movie,Movie neomovie){
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        boolean ret = false;
        try{
            movie = read(movie);
            movie.setTitle(neomovie.getTitle());
            movie.setGenre(neomovie.getGenre());
            movie.setLanguages(neomovie.getLanguages());
            movie.setRating(neomovie.getRating());
            movie.setReleaseDate(neomovie.getReleaseDate());
            movie.setIs3D(neomovie.isIs3D());
            movie.setIs4D(neomovie.isIs4D());
            movie.setId(neomovie.getId());
            mo.merge(movie);
            mo.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            mo.getTransaction().rollback();
        }finally{
            mo.close();
            return ret;
        }
    }
    
}
