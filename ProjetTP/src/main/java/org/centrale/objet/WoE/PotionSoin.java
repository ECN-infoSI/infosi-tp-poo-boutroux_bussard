/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Objet que les creatures peuvent ramasser puis utiliser pour regagner de la vie. 
 * @author Quent
 */
public class PotionSoin extends Recoltable{
    /** total de point de vie que la potion restaure */
    private int qttSoin;
    private final int minimumQttSoin=5;
    private final int maximumQttSoin=50;

    /** constructeur sans parametre, la quantité de soin est aléatoirement fixée entre 5 et 50 */
    public PotionSoin() {
        super();
        this.qttSoin= genereNombreAleatoire() ;
    }
    
    /** constructeur avec uniquement la position
     * la quantité de soin est aléatoirement fixée entre 5 et 50 
     *@param pos point de la carte où se situe la potion
     */
    public PotionSoin (Point2D pos) {
        super(pos);
        this.qttSoin= genereNombreAleatoire();
    }

    /**
     * constructeur avec tous les parametres
     * @param qttSoin  total de point de vie que la potion restaure
     * @param point position de la potion sur la carte
     */
    public PotionSoin(int qttSoin, Point2D point) {
        super(point);
        this.qttSoin = qttSoin;
    }
    
    private int genereNombreAleatoire(){
        Random generateurAleatoire = new Random();
        return minimumQttSoin+ generateurAleatoire.nextInt(maximumQttSoin-minimumQttSoin+1);
    }

    public int getQttSoin() {
        return qttSoin;
    }

    public void setQttSoin(int qttSoin) {
        this.qttSoin = qttSoin;
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'S';
    }
    
    /**
     * Augmente les points de vie de l'utilisateur. 
     * @param utilisateur 
     */
    @Override
    public void utiliser(Creature utilisateur, World monde) {
        if (Util.estLeJoueur(utilisateur, monde)){
            System.out.println("vous avez trouve une Potion !");
            monde.joueur.stocker(this);
        }
        else {
        utilisateur.setPtVie(utilisateur.getPtVie()+qttSoin);
        }
    }
    
    /**
     * affiche une simple phrase présentant l'objet dans la console
     */
    @Override
    public void afficherObjet(){
        System.out.println("Potion de Soin, restaure "+qttSoin+" points de vie");
    }
    
    /**
     * applique les effets au joueur
     * @param j 
     */
    @Override
    public void consommerDepuisInventaire(Joueur j){
        System.out.println("vous buvez la potion, vous gagnez "+qttSoin+" points de vie");
        j.personnageJoue.setPtVie(j.personnageJoue.getPtVie()+qttSoin);
    }
}    
