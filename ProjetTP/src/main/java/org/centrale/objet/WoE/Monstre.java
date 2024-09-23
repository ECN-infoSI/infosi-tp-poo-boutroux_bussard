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
    
    /**constructeur sans parametre*/
    public Monstre() {
        super();
    }
    
    /**
     * constructeur avec 1 parametre
     * @param pos point2D déffinissant la position où le monstre sera genere
     */
    public Monstre(Point2D pos) {
        super(pos);
    }
    
    /**
     * Constructeur avec tout les parametres de Monstre
     * @param ptVie points de vie
     * @param degAtt degats d'attaque
     * @param ptPar points de parade
     * @param pageAtt pourcentage d'attaque
     * @param pagePar pourcentage de parade
     * @param pos position
     */
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    /**
     * constructeur de recopie
     * @param m Monstre a recopier
     */
    public Monstre(Monstre monstre) {
        super(monstre);
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'M';
    }
    
    /**
     * affiche tout les attributs de monstre
     */
    @Override public void affiche(){
        System.out.println("Monstre");
        super.affiche();
    }
}
