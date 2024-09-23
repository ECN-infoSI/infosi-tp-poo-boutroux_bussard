/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author remib
 */
public class Guerrier extends Personnage implements Combattant {

    public Guerrier(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(distAttMax, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Guerrier() {
        super();
    }

    public Guerrier(Point2D pos) {
        super(pos);
    }

    public Guerrier(Guerrier guerrier) {
        super(guerrier);
    }
    
    @Override protected void initialiseDistAttMax(){
        this.distAttMax = 1;
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'G';
    }
    
    @Override public void affiche(){
        System.out.println("guerrier");
        super.affiche();
    }
    
    @Override public void combattre(Creature creature) {
        combatCorpsACorps(creature);
    }
}
