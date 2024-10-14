/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
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
    public final int tailleMonde = 5;
    
    public Case[][] carte = new Case[tailleMonde][tailleMonde];
    
    Joueur joueur;
    
    
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
          System.out.println("Nombre d'Archer : "+ (nbrArcher+1));
          for(int i=0;i<=nbrArcher;i++){
              creatures.add(new Archer());
          }
          int nbrGuerrier=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de Guerrier : "+ (nbrGuerrier+1));
          for(int i=0;i<=nbrGuerrier;i++){
              creatures.add(new Guerrier());
          }
          int nbrPaysan=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de paysan : "+ (nbrPaysan+1));
          for(int i=0;i<=nbrPaysan;i++){
              creatures.add(new Paysan());
          }
          int nbrLoup=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de loup : "+ (nbrLoup+1));
          for(int i=0;i<=nbrLoup;i++){
              creatures.add(new Loup());
          }
          int nbrLapin=generateurAleatoire.nextInt(nbrMaxParElement);
          System.out.println("Nombre de Lapin : "+ (nbrLapin+1));
          for(int i=0;i<=nbrLapin;i++){
              creatures.add(new Lapin());
          }
    }
    
    /**
     * constructeur d'un monde ne contenant que des archers
     * utilisé pour créer un monde dont on connait le nombre de créature
     * @param nbrPersonnage nombre d'archer dans le monde
     */
    public World(int nbrPersonnage){
        if (nbrPersonnage>tailleMonde*tailleMonde){
            System.out.println("Trop de personnage, monde trop petit");
            nbrPersonnage=0;
        }
        this.creatures = new ArrayList<Creature>();
        for(int i=0;i<nbrPersonnage;i++){
              creatures.add(new Archer());
          }
    }
            
            
            
            
            
            
    /**
     * crée un monde aléatoire contenant des éléments donnés,
     * fixe les positions des elements et s'assure qu'il n'y a pas plusieurs éléments sur la même case
     * créé des objets et les pose sur des cases vide du monde
     */
    public void creerMondeAlea(){
        //positionner les creatures dans le monde
        Random generateurAleatoire = new Random();
        boolean testPosDifferents;
        
        for(Creature creature :creatures){
            testPosDifferents=false;
            
            while(testPosDifferents==false){
                int creatureX=generateurAleatoire.nextInt(tailleMonde);
                int creatureY=generateurAleatoire.nextInt(tailleMonde);
                if (carte[creatureX][creatureY]==null){
                    testPosDifferents=true;
                    creature.setPos(new Point2D(creatureX, creatureY));
                    carte[creatureX][creatureY]= new Case(creature);
                } 
            }
        }
        
        int nbrEntiteMaxObjet= (tailleMonde*tailleMonde-creatures.size())/2;
        int nbrObjet=generateurAleatoire.nextInt(nbrEntiteMaxObjet);
        System.out.println("Nombre d'objet : "+ (nbrObjet+1) );
        for(int i=0;i<=nbrObjet;i++){
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
            creature.deplacer(carte);
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
    
    /**
     * Permet d'initialiser l'objet Joueur avec des inputs demandes a l'utilisateur. 
     * On recoit la classe et le nom du personnage joueur. 
     */
    public void creerJoueur(){
        System.out.println("Choisissez une classe a jouer parmi la liste suivante : ");
        afficherListeClassesJouables();
        int nombreClassesJouables = ClassesJouable.values().length;
        Scanner scanner = new Scanner(System.in);
        int choix = -1;
        while (choix <= 0 || choix > nombreClassesJouables){
            System.out.println("Donnez un nomber entier entre 1 et " + nombreClassesJouables + " svp. ");
            choix = scanner.nextInt();
        }
        
        Jouable personnageJoueur = null;
        ClassesJouable classeChoisie = ClassesJouable.values()[choix-1];
        switch(classeChoisie){
            case GUERRIER : 
                personnageJoueur = new Guerrier();
                break;
            case ARCHER : 
                personnageJoueur = new Archer();
                break;
            default : 
                System.out.println("Il manque un case pour une des classes jouables, nous instancions un guerrier à la place. ");
                personnageJoueur = new Guerrier();
                break;     
        }
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Choisissez un nom pour votre personnage. ");
        String choixNom = scannerString.nextLine();
        while (choixNom  == ""){
            System.out.println("Choisissez un nom pour votre personnage. ");
            choixNom = scannerString.nextLine();
        }
        
        joueur = new Joueur((Jouable) personnageJoueur, choixNom);
    }
    
    public enum ClassesJouable{
        GUERRIER("Guerrier"),
        ARCHER("Archer");
        
        private final String classe;
        
        ClassesJouable(String classeJouable){
            this.classe = classeJouable; 
        }
    }
    
    private void afficherListeClassesJouables(){
        int i = 1;
        for (ClassesJouable classe : ClassesJouable.values()){
            System.out.println(i + " : " + classe.toString());
            i++;
        }
    }
    
    /**
     * Calcule les pv de toutes les créature du monde et affiche leur somme en utilisant l'iterateur
     */
    public void afficherNbrPvTotIterateur(){
        int somme=0;
        for(Creature creature:creatures){
            somme+=creature.getPtVie();
        }
        System.out.println("Le nombre de point de vie total de l'ensemble des creatures est :"+ somme);
    }
    
    /**
     * Calcule les pv de toutes les créature du monde et affiche leur somme en utilisant la taille de la liste
     */
    public void afficherNbrPvTotTaille(){
            int somme=0;
            for(int i=0;i<creatures.size();i++){
                  somme+=creatures.get(i).getPtVie();
            }
            System.out.println("Le nombre de point de vie total de l'ensemble des creatures est :"+ somme);
    }
}
