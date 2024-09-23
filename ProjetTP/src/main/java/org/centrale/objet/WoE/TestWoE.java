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
        World mondeTest=new World();
        mondeTest.creerMondeAlea();
//        mondeTest.afficheWorld();
//        mondeTest.bugs1.affiche();
//        mondeTest.robin.affiche();
//        mondeTest.peon.affiche();
//        System.out.println("Position peon avant deplacement aleatoire : ");
//        mondeTest.peon.getPos().affiche();
//        for (int i = 0; i < 10; i++){
//            mondeTest.peon.deplace(mondeTest.carte);
//            System.out.println("Position peon apres deplacement aleatoire : ");
//            mondeTest.peon.getPos().affiche();
//        }
//        System.out.println("Position bugs1 avant deplacement aleatoire : ");
//        mondeTest.bugs1.getPos().affiche();
//        mondeTest.bugs1.deplace(mondeTest.carte);
//        System.out.println("Position bugs1 apres deplacement aleatoire : ");
//        mondeTest.bugs1.getPos().affiche();
//        
//        System.out.println("Position robin avant deplacement aleatoire : ");
//        mondeTest.robin.getPos().affiche();
//        mondeTest.robin.deplace(mondeTest.carte);
//        System.out.println("Position robin apres deplacement aleatoire : ");
//        mondeTest.robin.getPos().affiche();
//        
//        System.out.println("Position peon avant deplacement aleatoire : ");
//        mondeTest.peon.getPos().affiche();
//        mondeTest.peon.deplace(mondeTest.carte);
//        System.out.println("Position peon apres deplacement aleatoire : ");
//        mondeTest.peon.getPos().affiche();
        
//        mondeTest.guillaumeT = new Archer(mondeTest.robin);
//        System.out.println("Position robin avant deplacement robin : ");
//        mondeTest.robin.getPos().affiche();
//        System.out.println("Position guillaumeT avant deplacement robin : ");
//        mondeTest.guillaumeT.getPos().affiche();
//        mondeTest.robin.deplace(mondeTest.carte);
//        System.out.println("Position robin apres deplacement robin : ");
//        mondeTest.robin.getPos().affiche();
//        System.out.println("Position guillaumeT apres deplacement robin : ");
//        mondeTest.guillaumeT.getPos().affiche();
        
        for(int i=0; i<20;i++){
            mondeTest.grosBill.deplace(mondeTest.carte);
            mondeTest.grosBill.combattre(mondeTest.wolfie);
            System.out.println("pv loup : " +mondeTest.wolfie.getPtVie());
            
        }
        
    }
}
