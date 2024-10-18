/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author remib
 */
public class NuageToxique extends Objet implements Combattant, Deplacable {
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'N';
    }

    @Override
    public void combattre(Creature creature,World monde) {        
        creature.setPtVie(Math.max(0, creature.getPtVie() - 5));
    }

    @Override
    public void deplacer(Case[][] carte,World monde){
        
        Random generateurAleatoire = new Random();
        
        int oldX=this.getPos().getX();
        int oldY=this.getPos().getY();
        
        int avanceX = generateurAleatoire.nextInt(3)-1;
        int avanceY = generateurAleatoire.nextInt(3)-1;
//       int avanceX=0;
//       int avanceY=1;
       
//        System.out.println();
//        System.out.println("avance random : "+avanceX+";"+avanceY);
        int newX=oldX +avanceX;
        int newY=oldY +avanceY;
        
        
        if ( newX<0 || newX>=carte.length ){ //si la case cible est hors limites, on inverse le déplacement
            avanceX=-avanceX;
            newX=oldX+avanceX;      
        }
        if(newY<0 || newY>=carte.length){
            avanceY=-avanceY;
            newY=oldY+avanceY;
        }
        
        //si la case cible du déplacement existe et qu'elle contient une créature on interrompt le déplacement
        if (carte[newX][newY] != null){
            if (carte[newX][newY].creature != null){
                newX=oldX;
                avanceY=0;
                avanceX=0;
                newY=oldY;
            }
        }
        System.out.println("avance final  : "+avanceX+";"+avanceY);
        this.gererDeplacement(carte, oldX, oldY, newX, newY);
    }
    

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

    @Override
    public void utiliser(Creature utilisateur, World monde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
}
