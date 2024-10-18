/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * l'ensemble des objets pouvant être mis dans l'inventaire du joueur
 * @author Quent
 */
public abstract class Recoltable extends Objet {
    /**
     * affiche une courte phrase de présentation
     */
    public abstract void afficherObjet();
    
    /**
     * applique les effets lorsque consommée par le joueur et les affiche
     * @param j 
     */
    public abstract void consommerDepuisInventaire(Joueur j);

    public Recoltable(Point2D point) {
        super(point);
    }

    public Recoltable() {
        super();
    }
    
}
