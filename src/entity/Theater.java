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
public class Theater {

    private Screen[] screens;
    private int[] prices2D;
    private int[] prices3D;
    private Projection[] projections;

    public Theater(Screen[] screens, int[] cost2D, int[] cost3D, Projection[] projections) {
        this.screens = screens;
        this.prices2D = cost2D;
        this.prices3D = cost3D;
        this.projections = projections;
    }

    public Projection[] getProjections() {
        return projections;
    }

    public void setProjections(Projection[] projections) {
        this.projections = projections;
    }

    public Screen[] getScreens() {
        return screens;
    }

    public void setScreens(Screen[] screens) {
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
