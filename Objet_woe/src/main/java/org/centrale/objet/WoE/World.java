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
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs;

    public World() {
    }
    
    public void creerMondeAlea(){
        Random generateurAleatoire = new Random();
        
        Point2D pointApparitionAleatoire = generePoint2DAleatoire(generateurAleatoire);
        robin = new Archer(pointApparitionAleatoire);
        
        while(pointApparitionAleatoire.equals(robin.getPos())){
            pointApparitionAleatoire = generePoint2DAleatoire(generateurAleatoire);
        }
        peon = new Paysan(pointApparitionAleatoire);
        
        while(pointApparitionAleatoire.equals(robin.getPos()) || pointApparitionAleatoire.equals(peon.getPos())){
            pointApparitionAleatoire = generePoint2DAleatoire(generateurAleatoire);
        }
        bugs = new Lapin(pointApparitionAleatoire);
    }
    
    private Point2D generePoint2DAleatoire(Random generateurAleatoire){
        int posX = generateurAleatoire.nextInt(50);
        int posY = generateurAleatoire.nextInt(50);
        Point2D pointAleatoire = new Point2D(posX, posY);
        pointAleatoire.affiche();
        return pointAleatoire;
    }
    
    public void afficheWorld(){
        System.out.print("L'archer se trouve en : ");
        robin.getPos().affiche();
        System.out.print("Le paysan se trouve en : ");
        peon.getPos().affiche();
        System.out.print("Le lapin se trouve en : ");
        bugs.getPos().affiche();
        
    }
}
