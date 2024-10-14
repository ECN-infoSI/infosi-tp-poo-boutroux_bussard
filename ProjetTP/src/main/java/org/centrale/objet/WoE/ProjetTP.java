/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 * Classe appelant la creation du monde et lui demandant d'agir regulierement. 
 * @author remib
 */
public class ProjetTP {

    public static void main(String[] args) {
        World world = new World();
        world.creerMondeAlea();
        world.creerJoueur();
        System.out.println("world.joueur.nomPersonnage : " + world.joueur.nomPersonnage);
        System.out.println("world.joueur.getClass : " + world.joueur.personnageJoue.getClass().getName());
        
        world.afficheWorld();
//        for (int i = 0; i < 10; i++){
//            world.tourDeJeu();
//            world.afficheWorld();
//        }
    }
}
