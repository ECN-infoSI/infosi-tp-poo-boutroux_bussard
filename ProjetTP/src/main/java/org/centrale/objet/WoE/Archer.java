/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Quent
 */
public class Archer extends Personnage {
    private int nbFleche;

    public void setNbFleche(int nbFleche) {
        this.nbFleche = nbFleche;
    }

    public int getNbFleche() {
        return nbFleche;
    }

    public Archer(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos,int nbFleche) {
        super(distAttMax, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.nbFleche=nbFleche;
    }

    public Archer() {
        super();
        this.initialisefleche();
    }

    public Archer(Point2D pos) {
        super(pos);
        this.initialisefleche();
    }

    public Archer(Creature m) {
        super(m);
        this.initialisefleche();
    }
    private void initialisefleche(){
        this.nbFleche=5;
    }
    @Override public void affiche(){
        System.out.println("archer");
        super.affiche();
        System.out.println("nbr de fleches  : "+nbFleche);
    }
}