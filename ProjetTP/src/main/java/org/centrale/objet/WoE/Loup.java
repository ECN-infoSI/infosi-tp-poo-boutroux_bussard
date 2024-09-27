/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Le loup est un monstre capable de se battre. 
 * @author remib
 */
public class Loup extends Monstre implements Combattant {

    public Loup() {
    }

    public Loup(Point2D pos) {
        super(pos);
    }

    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Loup(Loup loup) {
        super(loup);
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'W';
    }
    
    /**
     * Le loup attaque s'il voit une creature a sa portee. 
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
     * Le loup est un animal qui ne peut tirer à l'arc donc sa portée est de 1. 
     * @param creature la creature a combattre
     */
    @Override public void combattre(Creature creature) {
        combatCorpsACorps(creature);
    }
    
}
