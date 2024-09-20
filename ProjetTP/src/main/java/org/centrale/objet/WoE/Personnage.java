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

    /**
     * Constructeur avec tous les parametres
     * @param distAttMax distance d'attaque maximale
     * @param ptVie points de vie
     * @param degAtt degats d'attaque
     * @param ptPar points de parades
     * @param pageAtt pourcentage d'attaque
     * @param pagePar pourcentage de parade
     * @param pos position en 2D
     */
    public Personnage(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.distAttMax = distAttMax;
    }

    /**
     * constructeur sans parametre 
     */
    public Personnage() {
        super();
        this.initialisedistAttMax();
    }

    /**
     * constructeur avec 1 seul parametre, la position
     * @param pos 
     */
    public Personnage(Point2D pos) {
        super(pos);
        this.initialisedistAttMax();
    }

    /**
     * constructeur de recopie
     * @param perso personnage a recopier
     */
    public Personnage(Personnage perso) {
        super(perso);
        this.distAttMax = perso.distAttMax;
    }
    
    private void initialisedistAttMax(){
        this.distAttMax=1;
    }

    /**
     * getter de la distance d'attaque max
     * @return la distance d'attaque maximale du personnage
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * setter de la distance d'attaque maximale
     * @param distAttMax nouvelle valeur de la distance d'attaque maximale
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    /**
     * affcihe tous les composants du personnage
     */
    @Override public void affiche(){
        super.affiche();
        System.out.println("Dist d'att max  : "+distAttMax);
    }
}
