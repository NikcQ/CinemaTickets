/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class Theater {

    private ArrayList<Screen> screens;
    private int[] prices2D;
    private int[] prices3D;
    private ArrayList<Projection> projections;

    public Theater(int[] cost2D, int[] cost3D) {
        this.screens = new ArrayList<Screen>();
        this.prices2D = cost2D;
        this.prices3D = cost3D;
        this.projections = new ArrayList<Projection>();
    }

    public ArrayList<Projection> getProjections() {
        return projections;
    }

    public void setProjections(ArrayList<Projection> projections) {
        this.projections = projections;
    }

    public ArrayList<Screen> getScreens() {
        return screens;
    }

    public void setScreens(ArrayList<Screen> screens) {
        this.screens = screens;
    }

    public int[] getPrices2D() {
        return prices2D;
    }

    public void setPrices2D(int[] prices2D) {
        this.prices2D = prices2D;
    }

    public int[] getPrices3D() {
        return prices3D;
    }

    public void setPrices3D(int[] prices3D) {
        this.prices3D = prices3D;
    }

}
