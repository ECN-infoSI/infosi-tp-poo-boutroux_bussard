/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Permet de savoir si une creature est capable de se battre. 
 * @author remib
 */
public interface Combattant {
    /**
     * Tous les combattants doivent implémenter combattre
     * @param creature 
     * @param joueurImpliqué 
     */
    public void combattre(Creature creature,World monde);
}
