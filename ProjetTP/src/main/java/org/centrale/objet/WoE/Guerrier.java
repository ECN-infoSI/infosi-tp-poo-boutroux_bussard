/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Le guerrier est un personnage se battant à courte portee. 
 * @author remib
 */
public class Guerrier extends Personnage implements Combattant, Jouable {

    public Guerrier(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(distAttMax, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Guerrier() {
        super();
        this.setPtVie(this.getPtVie()+80);
        this.setDegAtt(this.getDegAtt()+10);
        this.setPtPar(this.getPtPar()+5);
        this.setPageAtt(this.getPageAtt()+70);
        this.setPagePar((this.getPagePar())+20);
    }

    public Guerrier(Point2D pos) {
        super(pos);
        this.setPtVie(this.getPtVie()+80);
        this.setDegAtt(this.getDegAtt()+10);
        this.setPtPar(this.getPtPar()+5);
        this.setPageAtt(this.getPageAtt()+70);
        this.setPagePar((this.getPagePar())+20);
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
    
    /**
     * affiche les attributs du guerrier
     */
    @Override public void affiche(){
        System.out.println("guerrier");
        super.affiche();
    }
    
    /**
     * Le guerrier se bat des que possible. 
     * @param carte 
     */
    @Override
    public void agir(Case[][] carte) {
        Creature creatureAAttaquer = verifierPresenceCreatureProches(carte);
        if (creatureAAttaquer != null){
            combattre(creatureAAttaquer);
        }
    }
    
    /**
     * le guerrier ne se bat qu'au corps a corps
     * @param creature 
     */
    @Override public void combattre(Creature creature) {
        combatCorpsACorps(creature);
    }
}
