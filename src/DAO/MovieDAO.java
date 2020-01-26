/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Movie;
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
public final class MovieDAO {

    private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("CinemAppPU");

    public static void create(Movie movie) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        try {
            mo.persist(movie);
            mo.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            mo.getTransaction().rollback();
        } finally {
            mo.close();
        }
    }

    public static boolean delete(Movie movie) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        boolean ret = false;
        try {
            mo.remove(movie);
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

    public static Movie read(Movie movie) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        Movie film = null;
        Query q = mo.createQuery("SELECT m FROM Movie m " + "WHERE m.title LIKE :title").setParameter("title", movie.getTitle());
        try {
            film = (Movie) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            film = (Movie) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return film;
        }
    }

    public static ArrayList<Movie> readTable() {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        List<Movie> listOfMovies = new ArrayList<Movie>();
        ArrayList<Movie> listofMov = new ArrayList<Movie>();
        Query q = mo.createQuery("SELECT m FROM Movie m ");
        try {
            listOfMovies = (List<Movie>) q.getResultList();
            listofMov = new ArrayList<Movie>(listOfMovies);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mo.close();
            return listofMov;
        }
    }

    public static boolean update(Movie movie, Movie neomovie) {
        EntityManager mo = efm.createEntityManager();
        mo.getTransaction().begin();
        boolean ret = false;
        try {
            // movie = read(movie);
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
        } catch (Exception e) {
            e.printStackTrace();
            mo.getTransaction().rollback();
        } finally {
            mo.close();
            return ret;
        }
    }

    private MovieDAO() {
    }

}
