/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Movie {
    private String title;
    private String [] genre;
    private String [] languages;
    private String rating;
    private String cast;
    private LocalDate date;
    private static String[] genres={"accion", "romance"};
}
