/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Quent
 */
public abstract class Nourriture extends Recoltable {
    
    private int tempsDebutUtilisation; 

    public int getTempsDebutUtilisation() {
        return tempsDebutUtilisation;
    }

    public void setTempsDebutUtilisation(int tempsDebutUtilisation) {
        this.tempsDebutUtilisation = tempsDebutUtilisation;
    }
    
    
    @Override
    public void definirSymboleCarte() {
        super.definirSymboleCarte(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void consommerDepuisInventaire(Joueur j) {
        tempsDebutUtilisation = j.monde.compteurTemps;
        appliquerEffetNourriture(j);
    }
    
    protected abstract void appliquerEffetNourriture(Joueur j);

    @Override
    public void utiliser(Creature utilisateur, World monde) {
        if (Util.estLeJoueur(utilisateur, monde)){
            System.out.println("vous avez trouve de la nourriture !");
            monde.joueur.stocker(this);
        }
    }
}
