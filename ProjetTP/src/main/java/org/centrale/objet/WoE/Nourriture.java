/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author Quent
 */
public abstract class Nourriture extends Recoltable {
    
    private int tempsDebutUtilisation; 
    
    private int augmentationCarac; 
    
    public Nourriture() {
        super();
        Random generateurAleatoire = new Random();
        this.augmentationCarac = generateurAleatoire.nextInt(3)+1;
        this.tempsDebutUtilisation = Integer.MAX_VALUE;
    }
    
    public Nourriture(Point2D point) {
        super(point);
        Random generateurAleatoire = new Random();
        this.augmentationCarac = generateurAleatoire.nextInt(3)+1;
        this.tempsDebutUtilisation = Integer.MAX_VALUE;
    }
    
    public Nourriture(int augmentationCarac, Point2D point) {
        super(point);
        this.tempsDebutUtilisation = Integer.MAX_VALUE;
        this.augmentationCarac = augmentationCarac;
    }

    public Nourriture(int augmentationCarac) {
        this.tempsDebutUtilisation = Integer.MAX_VALUE;
        this.augmentationCarac = augmentationCarac;
    }

    public int getTempsDebutUtilisation() {
        return tempsDebutUtilisation;
    }

    public void setTempsDebutUtilisation(int tempsDebutUtilisation) {
        this.tempsDebutUtilisation = tempsDebutUtilisation;
    }

    public int getAugmentationCarac() {
        return augmentationCarac;
    }

    public void setAugmentationCarac(int augmentationCarac) {
        this.augmentationCarac = augmentationCarac;
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
    
    public abstract void annulerEffetNourriture(Joueur j);

    @Override
    public void utiliser(Creature utilisateur, World monde) {
        if (Util.estLeJoueur(utilisateur, monde)){
            System.out.println("vous avez trouve de la nourriture !");
            monde.joueur.stocker(this);
        }
    }
}
