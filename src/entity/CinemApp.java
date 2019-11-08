/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author juanc
 */
public class CinemApp {

    /**
     * @param args the command line arguments
     */
    private Theater cinema;

    public CinemApp(Theater cinema) {
        this.cinema = cinema;
    }

    public Theater getCinema() {
        return cinema;
    }

    public void setCinema(Theater cinema) {
        this.cinema = cinema;
    }

}
