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
    /** un archer du monde */
    public Archer robin; 
    /** un archer du monde */
    public Archer guillaumeT; 
    /** un paysan du monde */
    public Paysan peon; 
    /** un lapin du monde */
    public Lapin bugs1; 
    /** un lapin du monde */
    public Lapin bugs2;
    /** un guerrier du monde */
    public Guerrier grosBill;
    /** un loup du monde */
    public Loup wolfie;
    /** Une liste qui contient les créatures du monde */
    private ArrayList<Creature> creatures;
    /** valeur de la longeur d'un coté du monde carré */
    private final int tailleMonde = 50;

    public int getTailleMonde() {
        return tailleMonde;
    }
    
    /** constructeur sans parametre*/
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
        this.grosBill=new Guerrier();
        creatures.add(grosBill);
        this.wolfie=new Loup();
        creatures.add(wolfie);
    }
    
    /**
     * crée un monde aléatoire contenant des éléments donnés (2 lapins, 1 archer et 1 paysans),
     * fixe les positions des elements et s'assure qu'il n'y a pas plusieurs éléments sur la même case
     */
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
    /**
     * genere un point2D aleatoire
     * @param generateurAleatoire un générateur de nombre aléatoire 
     * @return un Point2D aleatoire dont les deux attributs sont compris entre 0 et tailleMonde
     */
    private Point2D generePoint2DAleatoire(Random generateurAleatoire){
        int posX = generateurAleatoire.nextInt(tailleMonde);
        int posY = generateurAleatoire.nextInt(tailleMonde);
        Point2D pointAleatoire = new Point2D(posX, posY);
        return pointAleatoire;
    }
    /**
     * affiche les coordonnées de tous les elements du monde
     */
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
