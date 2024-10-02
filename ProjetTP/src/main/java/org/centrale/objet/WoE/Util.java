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
    
    public static boolean verifierSiPositionExiste(Point2D pos, Case[][] carte){
        if (pos.getX() < 0 || pos.getX() >= carte.length || pos.getY() < 0 || pos.getY() >= carte[0].length){
            return false;
        }
        return true;
    }
}
