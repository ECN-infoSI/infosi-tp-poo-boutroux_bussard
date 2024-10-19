/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Un objet toxique, se déplace sur la carte et inflige des dégats aux ennemis qui penettrent sur sa case
 * @author remib
 */
public class NuageToxique extends Objet implements Combattant, Deplacable {

    public NuageToxique() {
    }

    public NuageToxique(Point2D point) {
        super(point);
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'N';
    }

    @Override
    /**
     * inflige des dégats automatiques aux créatures qu'il touche
     */
    public void combattre(Creature creature,World monde) {        
        creature.setPtVie(Math.max(0, creature.getPtVie() - 5));
    }

    /**
     * Crée déplacement aléatoire de l'élément et l'empeche d'aller sur d'autre objets ou de sortir sur la carte
     * @param carte
     * @param monde 
     */
    @Override
    public void deplacer(Case[][] carte,World monde){
        
        Random generateurAleatoire = new Random();
        
        int oldX = this.getPos().getX();
        int oldY = this.getPos().getY();
        
        int avanceX = generateurAleatoire.nextInt(3)-1;
        int avanceY = generateurAleatoire.nextInt(3)-1;
//       int avanceX=0;
//       int avanceY=1;
       
//        System.out.println();
//        System.out.println("avance random : "+avanceX+";"+avanceY);
        int newX = oldX + avanceX;
        int newY = oldY + avanceY;
        
        
        if ( newX<0 || newX >= carte.length ){ //si la case cible est hors limites, on inverse le déplacement
            avanceX=-avanceX;
            newX=oldX+avanceX;      
        }
        if(newY<0 || newY >= carte.length){
            avanceY = -avanceY;
            newY = oldY + avanceY;
        }
        
        //si la case cible du déplacement existe et qu'elle contient un objet on interrompt le déplacement
        if (carte[newX][newY] != null){
            if (carte[newX][newY].objet != null){
                newX = oldX;
                newY = oldY;
            }
        }
        
        this.gererDeplacement(carte, oldX, oldY, newX, newY);
    }
    
    /**
     * gére le changement de position de l'élément et la supression de son ancienne position
     * @param carte
     * @param oldX ancienne ordonnée
     * @param oldY ancienne abscisse
     * @param newX nouvelle ordonnée
     * @param newY nouvelle abscisse
     */
    public void gererDeplacement(Case[][] carte,int oldX, int oldY, int newX, int newY){
        //vider case oldX,oldY;
        if (carte[oldX][oldY].creature != null ){
            carte[oldX][oldY].objet = null;
        }else {
            carte[oldX][oldY] = null;
        }
        
        //remplir case newX,newY;
        if (carte[newX][newY] != null){
            carte[newX][newY].objet=this;
        } 
        else {
            carte[newX][newY] = new Case(this);
        }
        
        //modifier la position de la créature
        this.getPos().SetPosition(newX, newY);
    }

    /**
     * Déclenche le combat lorsqu'une créature rentre sur la même case que le nuage
     * @param utilisateur la créature qui arrive sur la case
     * @param monde 
     */
    @Override
    public void utiliser(Creature utilisateur, World monde) {
        combattre(utilisateur, monde);
    }    
}
