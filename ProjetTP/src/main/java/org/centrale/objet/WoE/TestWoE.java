/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;



/**
 * Classe de test pour toutes les autres classes. 
 * @author remib
 */
public class TestWoE {
    /**
     * Permet de tester toutes les méthodes du projet. 
     * @param args les arguments de la methode
     */
    public static void main(String[] args){
        World mondeTest=new World();
        mondeTest.creerMondeAlea();
        mondeTest.creerJoueur();
        
        for(int i=0;i<10;i++){
            mondeTest.tourDeJeu();
            mondeTest.afficheWorld();
            mondeTest.joueur.inventaire.afficherObjetDisponibles();
        }    
    }
}
