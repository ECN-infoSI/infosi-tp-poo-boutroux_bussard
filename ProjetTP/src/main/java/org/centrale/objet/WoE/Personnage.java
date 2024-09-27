/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *Tous les types de créature humaine du jeu, pnj ou joueur
 * @author Quent
 */
public class Personnage extends Creature {
    /** distance d'attaque maximale*/
    public int distAttMax; 

    /**
     * Constructeur avec tous les parametres
     * @param distAttMax distance d'attaque maximale
     * @param ptVie points de vie
     * @param degAtt degats d'attaque
     * @param ptPar points de parades
     * @param pageAtt pourcentage d'attaque
     * @param pagePar pourcentage de parade
     * @param pos position en 2D
     */
    public Personnage(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.distAttMax = distAttMax;
    }

    /**
     * constructeur sans parametre 
     */
    public Personnage() {
        super();
        this.initialiseDistAttMax();
    }

    /**
     * constructeur avec 1 seul parametre, la position
     * @param pos position en 2D
     */
    public Personnage(Point2D pos) {
        super(pos);
        this.initialiseDistAttMax();
    }

    /**
     * constructeur de recopie
     * @param perso personnage a recopier
     */
    public Personnage(Personnage perso) {
        super(perso);
        this.distAttMax = perso.distAttMax;
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'T';
    }
    
    protected void initialiseDistAttMax(){
        this.distAttMax=1;
    }

    /**
     * getter de la distance d'attaque max
     * @return la distance d'attaque maximale du personnage
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * setter de la distance d'attaque maximale
     * @param distAttMax nouvelle valeur de la distance d'attaque maximale
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    /**
     * affiche tous les composants du personnage
     */
    @Override public void affiche(){
        super.affiche();
        System.out.println("Dist d'att max  : "+distAttMax);
    }

    @Override
    public void agir(Case[][] carte) {
    }
    
    /**
     * Permet de déterminer quelle créature est la plus proche dans le périmètre de ditance d'attaque
     * @param carte 
     */
    @Override
    public Creature verifierPresenceCreatureProches(Case[][] carte){
        int posX = getPos().getX();
        int posY = getPos().getY();

        for(int k =1 ; k <= getDistAttMax(); k++){
            for (int i=k ; i >= -k; i--){
                if (i == k || i == -k){//si on se trouve à une des extrémités, on parcourt toute la colonne
                    for (int j=-k ; j <= k; j++){
                        if (carte[posX+i][posY+j] != null && (i!=0 || j!=0)){
                            if (carte[posX+i][posY+j].creature != null){
                                System.out.println("attaque");
                                //combattre(carte[posX+i][posY+j].creature);
                                return carte[posX+i][posY+j].creature;
                            }
                        }
                    }
                }
                else {
                    if (carte[posX+i][posY+k] != null && carte[posX+i][posY+k].creature != null){
                        return carte[posX+i][posY+k].creature;
                    }
                    else if (carte[posX+i][posY-k] != null && carte[posX+i][posY-k].creature != null){
                        return carte[posX+i][posY-k].creature;
                    }
                }
            }
        }
        return null;
    }
}
