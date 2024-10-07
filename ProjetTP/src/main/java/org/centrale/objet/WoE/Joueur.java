/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author remib
 */
public class Joueur {
    public Personnage personnageJoue; 
    public String nomPersonnage;

    public Joueur() {
    }

    public Joueur(Personnage perso, String nom) {
        this.personnageJoue = perso;
        this.nomPersonnage = nom;
    }
}
