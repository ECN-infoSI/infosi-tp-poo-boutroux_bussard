/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Quent
 */
public class Personnage extends Creature {
    public int distAttMax; 

    public Personnage(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.distAttMax = distAttMax;
    }

    public Personnage() {
        super();
        this.initialisedistAttMax();
    }

    public Personnage(Point2D pos) {
        super(pos);
        this.initialisedistAttMax();
    }

    public Personnage(Creature m) {
        super(m);
        this.initialisedistAttMax();
    }
    private void initialisedistAttMax(){
        this.distAttMax=1;
    }
}
