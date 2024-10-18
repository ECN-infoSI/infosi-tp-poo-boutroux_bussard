/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe static permettant d'utiliser certaines methodes a travers tous les scripts. 
 * @author remib
 */
public final class Util {
    
    /**
     * verifie si un point2D peut etre stocké dans une carte ou est hors limite
     * @param pos le point2D
     * @param carte la carte
     * @return true si il peut appartenir a la carte
     */
    public static boolean verifierSiPositionExiste(Point2D pos, Case[][] carte){
        return verifierSiCaseExiste(pos.getX(), pos.getY(), carte);
    }
    /**
     * verifie si un couple d'entier (x,y) peut etre stocké dans une carte ou est hors limite
     * @param x
     * @param y
     * @param carte
     * @return true si il peut appartenir a la carte
     */
    public static boolean verifierSiCaseExiste(int x,int y, Case[][] carte){
        if (x < 0 || x >= carte.length || y < 0 || y >= carte[0].length){
            return false;
        }
        return true;
    }
    
    public static boolean estLeJoueur(Creature crea, World monde){
        if (crea.getPos().getX()==monde.joueur.personnageJoue.getPos().getX() && crea.getPos().getY()==monde.joueur.personnageJoue.getPos().getY()){
            return true;
        }
        return false;
    }
}
