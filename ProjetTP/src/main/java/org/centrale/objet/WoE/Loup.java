/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author remib
 */
public class Loup extends Monstre implements Combattant {
    
    @Override public void combattre(Creature creature) {
        if (this.getPos().distance(creature.getPos()) < 1){
            creature.setPtVie(creature.getPtVie() - this.getDegAtt());
        }
    }
    
}
