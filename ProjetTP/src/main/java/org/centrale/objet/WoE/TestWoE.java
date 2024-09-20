/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author remib
 */
public class TestWoE {
    /**
     * Permet de tester toutes les méthodes du projet. 
     * @param args 
     */
    public static void main(String[] args){
        World mondetest=new World();
        mondetest.creerMondeAlea();
        mondetest.afficheWorld();
        mondetest.bugs1.affiche();
        mondetest.robin.affiche();
        mondetest.peon.affiche();
        System.out.println("Position peon avant deplacement aleatoire : ");
        mondetest.peon.getPos().affiche();
        for (int i = 0; i < 10; i++){
            mondetest.peon.deplace();
            System.out.println("Position peon apres deplacement aleatoire : ");
            mondetest.peon.getPos().affiche();
        }
        System.out.println("Position bugs1 avant deplacement aleatoire : ");
        mondetest.bugs1.getPos().affiche();
        mondetest.bugs1.deplace();
        System.out.println("Position bugs1 apres deplacement aleatoire : ");
        mondetest.bugs1.getPos().affiche();
        
        System.out.println("Position robin avant deplacement aleatoire : ");
        mondetest.robin.getPos().affiche();
        mondetest.robin.deplace();
        System.out.println("Position robin apres deplacement aleatoire : ");
        mondetest.robin.getPos().affiche();
        
        System.out.println("Position peon avant deplacement aleatoire : ");
        mondetest.peon.getPos().affiche();
        mondetest.peon.deplace();
        System.out.println("Position peon apres deplacement aleatoire : ");
        mondetest.peon.getPos().affiche();
    }
}
