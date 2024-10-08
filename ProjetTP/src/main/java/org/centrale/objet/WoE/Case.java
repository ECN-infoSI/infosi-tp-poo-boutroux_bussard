/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Element de base de la carte. 
 * On peut y placer un objet et/ou une creature. 
 * @author remib
 */
public class Case {
    public Creature creature;
    public Objet objet;

    public Case(Creature creature, Objet objet) {
        this.creature = creature;
        this.objet = objet;
    }
    
    public Case(Creature creature) {
        this.creature = creature;
    }
    
    public Case(Objet objet) {
        this.objet = objet;
    }
    
    public Case(){
        
    }
    /**
     * Remets les attributs creature et objet de la case à null
     */
    public void viderCase(){
        this.creature = null;
        this.objet = null;
    }
}
