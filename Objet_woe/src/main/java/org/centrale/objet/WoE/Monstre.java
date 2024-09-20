/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Quent
 */
public class Monstre extends Creature {

    public Monstre() {
        super();
    }

    public Monstre(Point2D pos) {
        super(pos);
    }

    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Monstre(Creature m) {
        super(m);
    }
    @Override public void affiche(){
        System.out.println("Monstre");
        super.affiche();
    }
}
