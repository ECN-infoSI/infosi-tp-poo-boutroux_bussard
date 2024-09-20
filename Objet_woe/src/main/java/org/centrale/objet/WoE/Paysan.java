/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Quent
 */
public class Paysan extends Personnage {

    public Paysan(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(distAttMax, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Paysan() {
    }

    public Paysan(Point2D pos) {
        super(pos);
    }

    public Paysan(Creature m) {
        super(m);
    }
    
}
