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
    public static void main(String[] args){
        World mondetest=new World();
        mondetest.creerMondeAlea();
        mondetest.afficheWorld();
        mondetest.bugs1.affiche();
        mondetest.robin.affiche();
        mondetest.peon.affiche();
    }
}
