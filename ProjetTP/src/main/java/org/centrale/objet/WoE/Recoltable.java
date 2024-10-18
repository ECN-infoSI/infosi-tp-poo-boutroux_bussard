/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Quent
 */
public abstract class Recoltable extends Objet {
    
    public abstract void afficherObjet();
    public abstract void consommerDepuisInventaire(Joueur j);

    public Recoltable(Point2D point) {
        super(point);
    }

    public Recoltable() {
        super();
    }
    
}
