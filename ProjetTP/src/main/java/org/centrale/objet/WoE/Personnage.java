/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Tous les types de créature humaine du jeu, pnj ou joueur. 
 * @author Quent
 */
public abstract class Personnage extends Creature {
    /** distance d'attaque maximale*/
    

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
    public Personnage(int distAttMax,int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos,distAttMax);
    }

    /**
     * constructeur sans parametre 
     */
    public Personnage() {
        super();
    }

    /**
     * constructeur avec 1 seul parametre, la position
     * @param pos position en 2D
     */
    public Personnage(Point2D pos) {
        super(pos);
    }

    /**
     * constructeur de recopie
     * @param perso personnage a recopier
     */
    public Personnage(Personnage perso) {
        super(perso);
    }
    
    /**
     * Getter de la distance d'attaque max
     * @return la distance d'attaque maximale du personnage
     */
    @Override
    public int getDistAttMax() {
        return super.getDistAttMax();
    }

    /**
     * Setter de la distance d'attaque maximale
     * @param distAttMax nouvelle valeur de la distance d'attaque maximale
     */
    @Override
    public void setDistAttMax(int distAttMax) {
        super.setDistAttMax(distAttMax);
    }
    
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'T';
    }
    
    /**
     * Affiche tous les composants du personnage
     */
    @Override public void affiche(){
        super.affiche(); 
    }

    /**
     * Le personnage ne fait rien de particulier pour le moment. 
     * @param carte 
     */
    @Override
    public void agir(Case[][] carte,World monde) {
    }
    
    /**
     * Permet de déterminer quelle créature est la plus proche dans le perimetre de ditance d'attaque. 
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
                        if(!Util.verifierSiPositionExiste(new Point2D(posX+i,posY+j), carte)){
                            continue;
                        }
                        if (carte[posX+i][posY+j] == null){
                            continue;
                        }
                        Case caseATester = carte[posX+i][posY+j];
                        if (caseATester.creature == null){
                            continue;
                        }
                        return caseATester.creature;
                    }
                }
                else {
                    if (Util.verifierSiPositionExiste(new Point2D(posX+i,posY+k), carte)){
                        if (carte[posX+i][posY+k] == null){
                            continue;
                        }
                        Case caseATester = carte[posX+i][posY+k];
                        if (caseATester.creature == null){
                            continue;
                        }
                        return caseATester.creature;
                    }
                    if (Util.verifierSiPositionExiste(new Point2D(posX+i,posY-k), carte)){
                        if (carte[posX+i][posY-k] == null){
                            continue;
                        }
                        Case caseATester = carte[posX+i][posY-k];
                        if (caseATester.creature == null){
                            continue;
                        }
                        return caseATester.creature;
                    }
                }
            }
        }
        return null;
    }
}
