/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Quent
 */
public class PotionSoin extends Objet {
    /** position de la potion sur la carte */
    private Point2D pos;

    /** constructeur sans parametre */
    public PotionSoin() {
        super();
        this.pos=new Point2D();
    }
    
    /** constructeur
     *@param pos point de la carte où se situe la potion
     */
    public PotionSoin (Point2D pos) {
        super();
        this.pos=pos;
    }
    
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
}
