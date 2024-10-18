/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
/**
 * Le monde est la classe principale qui contient des references vers toutes les creatures s'y trouvant et les faisant agir a chaque tour. 
 * @author remib
 */
public class World {
    /** Une liste qui contient les créatures du monde */
    private ArrayList<Creature> creatures;
    
    /** Une liste des objets capables d'agir */
    private ArrayList<Objet> objetsAgissants;
    
    /** valeur de la longeur d'un coté du monde carré */
    public final int tailleMonde = 50;
    
    /** La carte dans laquelle est sauvegardé les objets et les creatures presents dans le monde. */
    public Case[][] carte = new Case[tailleMonde][tailleMonde];
    
    /** L'objet joueur est instancié au debut du monde et gere les inputs envoyes par le vrai joueur. */
    public Joueur joueur;
    
    /** permet d'avoir une notion du temps, utile pour les effets ayant une duree*/
    public int compteurTemps; 
    
    
    /** constructeur sans parametre
     * choisi aléatoirement un nombre de chaque type d'entité
     */
    public World() {
        this.compteurTemps = 0;
        
        this.creatures = new ArrayList<Creature>();

        // On divise par 15 pour ne pas saturer la carte avec des personnages. 
        int nbrMaxParElement = tailleMonde*tailleMonde/15;
        Random generateurAleatoire = new Random();

        int nbrArcher = generateurAleatoire.nextInt(nbrMaxParElement);
        System.out.println("Nombre d'Archer : "+ (nbrArcher+1));
        for(int i=0;i<=nbrArcher;i++){
            creatures.add(new Archer());
        }
        int nbrGuerrier = generateurAleatoire.nextInt(nbrMaxParElement);
        System.out.println("Nombre de Guerrier : "+ (nbrGuerrier+1));
        for(int i=0;i<=nbrGuerrier;i++){
            creatures.add(new Guerrier());
        }
        int nbrPaysan = generateurAleatoire.nextInt(nbrMaxParElement);
        System.out.println("Nombre de paysan : "+ (nbrPaysan+1));
        for(int i=0;i<=nbrPaysan;i++){
            creatures.add(new Paysan());
        }
        int nbrLoup = generateurAleatoire.nextInt(nbrMaxParElement);
        System.out.println("Nombre de loup : "+ (nbrLoup+1));
        for(int i=0;i<=nbrLoup;i++){
            creatures.add(new Loup());
        }
        int nbrLapin = generateurAleatoire.nextInt(nbrMaxParElement);
        System.out.println("Nombre de Lapin : "+ (nbrLapin+1));
        for(int i=0;i<=nbrLapin;i++){
            creatures.add(new Lapin());
        }
        
        objetsAgissants = new ArrayList<Objet>();
    }
    
    /**
     * constructeur d'un monde ne contenant que des archers
     * utilisé pour créer un monde dont on connait le nombre de créature
     * @param nbrPersonnage nombre d'archer dans le monde
     */
    public World(int nbrPersonnage){
        this.compteurTemps = 0;
        
        if (nbrPersonnage > tailleMonde * tailleMonde){
            System.out.println("Trop de personnage, monde trop petit");
            nbrPersonnage=0;
        }
        this.creatures = new ArrayList<Creature>();
        for(int i=0;i<nbrPersonnage;i++){
              creatures.add(new Archer());
        }
        objetsAgissants = new ArrayList<Objet>();
    }
            
            
            
            
            
            
    /**
     * crée un monde aléatoire contenant des éléments donnés,
     * fixe les positions des elements et s'assure qu'il n'y a pas plusieurs éléments sur la même case
     * cree des objets et les pose sur des cases vide du monde
     */
    public void creerMondeAlea(){
        //positionner les creatures dans le monde
        Random generateurAleatoire = new Random();
        boolean testPosDifferentes;
        
        for(Creature creature :creatures){
            testPosDifferentes = false;
            
            while(testPosDifferentes == false){
                int creatureX=generateurAleatoire.nextInt(tailleMonde);
                int creatureY=generateurAleatoire.nextInt(tailleMonde);
                if (carte[creatureX][creatureY] == null){
                    testPosDifferentes = true;
                    creature.setPos(new Point2D(creatureX, creatureY));
                    carte[creatureX][creatureY]= new Case(creature);
                } 
            }
        }
        
        int nbrEntiteMaxObjet= (tailleMonde*tailleMonde-creatures.size())/8;
        int nbrObjet=generateurAleatoire.nextInt(nbrEntiteMaxObjet);
        System.out.println("Nombre d'objet : "+ (nbrObjet+1) );
        for(int i=0;i<=nbrObjet;i++){
            testPosDifferentes=false;
            
            while(testPosDifferentes==false){
                int x=generateurAleatoire.nextInt(tailleMonde);
                int y=generateurAleatoire.nextInt(tailleMonde);
                if ( carte[x][y]==null){
                    int typeAleatoire = generateurAleatoire.nextInt(4);
                    switch(typeAleatoire){
                        case 0:
                           carte[x][y]=new Case(new PotionSoin(new Point2D(x,y)));
                           break;
                        case 1:
                           carte[x][y]=new Case(new Epee(new Point2D(x,y)));
                           break;
                        case 2:
                           carte[x][y]=new Case(new NuageToxique(new Point2D(x,y)));
                           objetsAgissants.add(carte[x][y].objet);
                           break; 
                        case 3:
                           carte[x][y]=new Case(new Epinard(new Point2D(x,y)));
                           break;
                        default:
                            System.out.println("Erreur: création objet non existant");
                            break;    
                    }
                    testPosDifferentes=true;
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
     * le joueur se déplace (ou pas) puis choisi s'il veut combattre
     * s'il veut combattre il choisit sa cible puis combat
     * Chaque creature bouge puis agit, 
     * l'action va dépendre de la créature appelée.
     * Certaines crétures ne font rien d'autre que se déplacer. 
     */
    public void tourDeJeu(){
        compteurTemps++;
        for(int k=0;k<joueur.inventaire.getNourritureActive().size();k++){
            if (joueur.inventaire.getNourritureActive().get(k).getTempsDebutUtilisation()+3>=compteurTemps){
                joueur.inventaire.getNourritureActive().get(k).annulerEffetNourriture(joueur);
                joueur.inventaire.getNourritureActive().remove(k);
                k--;
            }
        }
        joueur.afficheStat();
        afficheWorld();
        joueur.deplacerJoueur(carte,this);
        afficheWorld();
        joueur.inventaire.consulterInventaire();
        joueur.choixCombat(carte,this);
        attendre();
        //joueur.choixsauvegarde();
        int compteur=0;
        ArrayList<Creature> creaturesASupprimer = new ArrayList<Creature>(); 
        for (Creature creature : creatures){
            compteur+=1;
            if(creature.getPtVie()<=0){
                creaturesASupprimer.add(creature);
            }
            else{
                creature.deplacer(carte,this);
                creature.agir(carte,this); 
            }
            //condition d'affichage si le joueur est attaqué a rajouter
        }
        
        // On supprime des différentes listes toutes les creatures qui sont mortes
        for (Creature creature : creaturesASupprimer){
            int posX = creature.getPos().getX();
            int posY = creature.getPos().getY();
            creatures.remove(creature);
            creature = null;
            if (carte[posX][posY].objet == null){
                carte[posX][posY] = null;
            }
        }
        
        for (Objet objet: objetsAgissants){
            if (objet instanceof Deplacable){
                ((Deplacable) objet).deplacer(carte,this);
            }
            if (objet instanceof Combattant){
                Point2D positionObjet = objet.getPos();
                if (carte[positionObjet.getX()][positionObjet.getY()].creature !=null){
                    ((Combattant) objet).combattre(carte[positionObjet.getX()][positionObjet.getY()].creature, this);
                }
            }
        }
    }
    
    public void attendre(){
        System.out.println("appuyer sur entree pour continuer");
        Scanner lectureClavier=new Scanner(System.in);
        String entreeClavier =lectureClavier.nextLine();
        return;
    }
    /**
     * Affiche les toutes les cases avec un caractere adapte à l'element present sur la case
     */
    public void afficheWorldTotal(){
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
     * permet d'afficher le carré de 5 case centré sur le Joueur
     */
    public void afficheWorld(){
        for (int indiceX = joueur.personnageJoue.getPos().getX()-4; indiceX<= joueur.personnageJoue.getPos().getX()+4; indiceX++){
            System.out.println("");
            for (int indiceY = joueur.personnageJoue.getPos().getY()-4; indiceY <= joueur.personnageJoue.getPos().getY()+4; indiceY++){
                
                if(!Util.verifierSiCaseExiste(indiceX, indiceY, carte)){
                    System.out.print(" " + " " + " ");
                    continue;
                }
                if (carte[indiceX][indiceY] == null){
                    System.out.print(" " + "." + " ");
                    continue;
                }
                Case caseActuelle = carte[indiceX][indiceY];
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
        // Choisir classe
        System.out.println("Choisissez une classe a jouer parmi la liste suivante : ");
        afficherListeClassesJouables();
        int nombreClassesJouables = ClassesJouable.values().length;
        int choix = -1;
        while (choix <= 0 || choix > nombreClassesJouables){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Donnez un nomber entier entre 1 et " + nombreClassesJouables + " svp. ");
            try{
                choix = scanner.nextInt();
            }
            catch(Exception e){
                choix=-1;
            }
        }
        
        Creature personnageJoueur = null;
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
        
        // Choisir nom personnage
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Choisissez un nom pour votre personnage. ");
        String choixNom = scannerString.nextLine();
        while (choixNom.isEmpty()){
            System.out.println("Choisissez un nom pour votre personnage. ");
            choixNom = scannerString.nextLine();
        }
        
        joueur = new Joueur( personnageJoueur, choixNom, this);
        joueur.personnageJoue.definirSymboleCarte('J');
        
        // Placer le joueur aleatoirement sur la carte
        boolean positionPasEncoreUtilisee = false;
        Random generateurAleatoire = new Random();
        while(positionPasEncoreUtilisee == false){
            int creatureX = generateurAleatoire.nextInt(tailleMonde);
            int creatureY = generateurAleatoire.nextInt(tailleMonde);
            if (carte[creatureX][creatureY] == null){
                positionPasEncoreUtilisee = true;
                joueur.personnageJoue.setPos(new Point2D(creatureX, creatureY));
                carte[creatureX][creatureY]= new Case(joueur.personnageJoue);
            } 
        }
    }
    
    /**
     * Enumerateur permettant de savoir quelles classes sont jouables et quel string affiche pour les presenter au joueur. 
     */
    public enum ClassesJouable{
        GUERRIER("Guerrier"),
        ARCHER("Archer");
        
        private final String classe;
        
        ClassesJouable(String classeJouable){
            this.classe = classeJouable; 
        }
    }
    
    /**
     * Affiche toutes les classes qui sont jouables avec un numero devant permettant au joueur de les selectionner. 
     */
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
