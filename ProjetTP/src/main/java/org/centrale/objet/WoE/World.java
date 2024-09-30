/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;

/**
 * Le monde est la classe principale qui contient des references vers toutes les creatures s'y trouvant et les faisant agir a chaque tour. 
 * @author remib
 */
public class World {
    /** un archer du monde */
//    public Archer robin; 
//    /** un archer du monde */
//    public Archer guillaumeT; 
//    /** un paysan du monde */
//    public Paysan peon; 
//    /** un lapin du monde */
//    public Lapin bugs1; 
//    /** un lapin du monde */
//    public Lapin bugs2;
//    /** un guerrier du monde */
//    public Guerrier grosBill;
//    /** un loup du monde */
//    public Loup wolfie;
    /** Une liste qui contient les créatures du monde */
    private ArrayList<Creature> creatures;
    /** valeur de la longeur d'un coté du monde carré */
    public final int tailleMonde = 10;
    
    public Case[][] carte = new Case[tailleMonde][tailleMonde];
    
    
    /** constructeur sans parametre
     * choisi aléatoirement un nombre de chaque type d'entité
     */
    public World() {
        this.creatures = new ArrayList<Creature>();
//        this.robin=new Archer();
//        creatures.add(robin);
//        this.guillaumeT = new Archer();
//        creatures.add(guillaumeT);
//        this.peon=new Paysan();
//        creatures.add(peon);
//        this.bugs1=new Lapin();
//        creatures.add(bugs1);
//        this.bugs2=new Lapin();
//        creatures.add(bugs2);
//        this.grosBill=new Guerrier();
//        creatures.add(grosBill);
//        this.wolfie=new Loup();
//        creatures.add(wolfie);
          //5 est le nombre d'entité différentes (Archer,Guerrier,Paysan,lapin, Loup)
          int nbrMaxParElement=tailleMonde*tailleMonde/5;
          Random generateurAleatoire = new Random();
          
          int nbrArcher=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre d'Archer -1 : "+ nbrArcher);
          for(int i=0;i<=nbrArcher;i++){
              creatures.add(new Archer());
          }
          int nbrGuerrier=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de Guerrier -1 : "+ nbrGuerrier);
          for(int i=0;i<=nbrGuerrier;i++){
              creatures.add(new Guerrier());
          }
          int nbrPaysan=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de paysan -1 : "+ nbrPaysan);
          for(int i=0;i<=nbrPaysan;i++){
              creatures.add(new Paysan());
          }
          int nbrLoup=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de loup -1 : "+ nbrLoup);
          for(int i=0;i<=nbrLoup;i++){
              creatures.add(new Loup());
          }
          int nbrLapin=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de Lapin -1 : "+ nbrLapin);
          for(int i=0;i<=nbrLapin;i++){
              creatures.add(new Lapin());
          }
    }
    
    /**
     * crée un monde aléatoire contenant des éléments donnés,
     * fixe les positions des elements et s'assure qu'il n'y a pas plusieurs éléments sur la même case
     * créé des objets et les pose sur des cases vide du monde
     */
    public void creerMondeAlea(){
        //positionner les creatures dans le monde
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
        for (Creature creature : creatures){
            carte[creature.getPos().getX()][creature.getPos().getY()] = new Case(creature);
        }
        
        int NbrEntiteMaxObjet= (tailleMonde*tailleMonde-creatures.size())/2;
        int nbrObjet=generateurAleatoire.nextInt(NbrEntiteMaxObjet);
        for(int i=0;i<nbrObjet;i++){
            testPosDifferents=false;
            
            while(testPosDifferents==false){
                int x=generateurAleatoire.nextInt(tailleMonde);
                int y=generateurAleatoire.nextInt(tailleMonde);
                if ( carte[x][y]==null){
                    int typeAleatoire = generateurAleatoire.nextInt(2);
                    switch(typeAleatoire){
                        case 0:
                           carte[x][y]=new Case(new PotionSoin());
                           break;
                        case 1:
                           carte[x][y]=new Case(new Epee());
                           break;
                        default:
                            System.out.println("Erreur: création objet non existant");
                            break;    
                    }
                    testPosDifferents=true;
                }
            }
        }     
    }
    
    
    /**
     * crée un monde choisi par nous pour tester les différents mécanismes du jeu
     * Ne marche que si le monde n'a pas encore été créé
     */
    public void creerMondeSpecifique(){
        //On choisi les personnages sur la carte
        creatures.clear();
//        creatures.add(robin);
//        creatures.add(bugs1);
        
        //On choisi les diférents objets sur la carte
        //new Epee excalibur =new Epee();
        
        //On choisi les positions des éléments
//        Point2D positionrobin =new Point2D(2,2);
//        Point2D positionBugs =new Point2D(2,4);
//        robin.setPos(positionrobin);
//        bugs1.setPos(positionBugs);
        
        for (Creature creature : creatures){
            carte[creature.getPos().getX()][creature.getPos().getY()] = new Case(creature);
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
     * Chaque creature bouge puis agit, 
     * l'action va dépendre de la créature appelée.
     * Certaines crétures ne font rien d'autre que se déplacer. 
     */
    public void tourDeJeu(){
        for (Creature creature : creatures){
            creature.deplace(carte);
            creature.agir(carte);
        }
    }
    
    /**
     * Affiche les toutes les cases avec un caractere adapte à l'element present sur la case
     */
    public void afficheWorld(){
        for (int indiceColonne = 0; indiceColonne < tailleMonde; indiceColonne++){
            System.out.println("");
            for (int indiceLigne = 0; indiceLigne < tailleMonde; indiceLigne++){
                if (carte[indiceColonne][indiceLigne] == null){
                    System.out.print(" " + "." + " ");
                    continue;
                }
                Case caseActuelle = carte[indiceColonne][indiceLigne];
                if (caseActuelle.creature != null){
                    System.out.print(" " + caseActuelle.creature.getSymboleCarte() + " ");
                    continue;
                }
                if (caseActuelle.objet != null){
                    System.out.print(" " + caseActuelle.objet.getSymboleCarte() + " ");
                    continue;
                }
                System.out.print(" " + "." + " ");
            }
        }
        System.out.println();
    }
}
