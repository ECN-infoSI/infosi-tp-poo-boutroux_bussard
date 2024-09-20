/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author remib
 */
public class World {
    public Archer robin;
    public Archer guillaumeT;
    public Paysan peon;
    public Lapin bugs1;
    public Lapin bugs2;
    private ArrayList<Creature> creatures;
    private final int tailleMonde = 50;

    public World() {
        this.creatures = new ArrayList<Creature>();
        this.robin=new Archer();
        creatures.add(robin);
        this.guillaumeT = new Archer();
        creatures.add(guillaumeT);
        this.peon=new Paysan();
        creatures.add(peon);
        this.bugs1=new Lapin();
        creatures.add(bugs1);
        this.bugs2=new Lapin();
        creatures.add(bugs2);
    }
    
    public void creerMondeAlea(){
        int nbrElements = creatures.size();
        Random generateurAleatoire = new Random();
        Point2D[] positions = new Point2D[nbrElements];
        boolean testPosDifferents;
        
        for(int i=0;i<nbrElements;i++){
            testPosDifferents=false;
            
            while(testPosDifferents==false){
                positions[i]=generePoint2DAleatoire(generateurAleatoire);
                testPosDifferents=true;
                
                for(int j=0; j<i;j++){
                    if (positions[i].equals(positions[j])){
                        testPosDifferents=false;
                    }
                }
            }
        }
        
        for (int creatureIndex = 0; creatureIndex < nbrElements; creatureIndex++){
            creatures.get(creatureIndex).setPos(positions[creatureIndex]);
        }
    }
    
    private Point2D generePoint2DAleatoire(Random generateurAleatoire){
        int posX = generateurAleatoire.nextInt(tailleMonde);
        int posY = generateurAleatoire.nextInt(tailleMonde);
        Point2D pointAleatoire = new Point2D(posX, posY);
        pointAleatoire.affiche();
        return pointAleatoire;
    }
    
    public void afficheWorld(){
        System.out.print("L'archer se trouve en : ");
        robin.getPos().affiche();
        System.out.print("Le paysan se trouve en : ");
        peon.getPos().affiche();
        System.out.print("Le premier lapin se trouve en : ");
        bugs1.getPos().affiche();
        System.out.print("Le second lapin se trouve en : ");
        bugs2.getPos().affiche();
        
    }
}
