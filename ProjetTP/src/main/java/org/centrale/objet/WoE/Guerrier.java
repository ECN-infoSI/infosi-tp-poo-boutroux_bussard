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
    
    
    private void initialiseDistAttMax(){
        this.distAttMax = 1;
    }
    
    @Override public void combattre(Creature creature) {
        if (this.getPos().distance(creature.getPos()) <= this.getDistAttMax()){
            creature.setPtVie(creature.getPtVie() - this.getDegAtt());
        }
    }
}
