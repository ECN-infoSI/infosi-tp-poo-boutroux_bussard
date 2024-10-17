/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author remib
 */
public class Joueur {
    public Creature personnageJoue; 
    public String nomPersonnage;

    public Joueur() {
    }

    public Joueur(Creature perso, String nom) {
        this.personnageJoue = perso;
        this.nomPersonnage = nom;
    }
    
    /**
     * propose au joueur de combattre puis lance le combat si le joueur en fait le choix
     * @param carte position de tous les ennemis
     * @param monde
     */
    public void choixCombat(Case[][] carte,World monde){
        System.out.println("Voulez-vous combattre ?");
        System.out.println("o-oui   ; n-non");
        Scanner lectureClavier=new Scanner(System.in);
        boolean choixValable = false;
        
        while (!choixValable){
            
            String choix =lectureClavier.nextLine();
            choix = choix.toUpperCase();

            switch (choix){
                case "N":
                    System.out.println("Pas de combat");
                    choixValable=true;
                    break;
                case "O":
                    choixAdversaire(carte,monde);
                    choixValable=true;
                    break;
                default :
                    break;
            }
        }
        
        
    }
    
    /**
     * propose la liste des adversaires à portée
     * @param carte 
     */
    private void choixAdversaire(Case[][] carte,World monde){
        ArrayList<Creature> ennemis = new ArrayList<Creature>();
        ennemis= verifierPresenceCreatureProches(carte);
        if(ennemis.isEmpty()){
            System.out.println("aucun ennemi a portee");
            return;
        }
        System.out.println("choisissez votre adversaire");
        for(int i=0; i<ennemis.size();i++){
            System.out.println((i+1)+" :  "+ennemis.get(i).getClass().getSimpleName() +"   "+ennemis.get(i).getPtVie()+" points de vie, " +ennemis.get(i).getPos().distance(personnageJoue.getPos())+ " cases de distance");
        }
        
        boolean choixValable = false;
        boolean estUnEntier=true;
        int choix=0;
        while (!choixValable){
            estUnEntier=true;
            Scanner lectureEntier=new Scanner(System.in);
            try{
                choix =lectureEntier.nextInt();
            }
            catch(Exception e){
                estUnEntier=false;
            }
            
            if(choix<= ennemis.size() && choix>0 && estUnEntier){
                choixValable=true;
            }else{
                System.out.println("mauvaise entrée veuillez reessayer");
            }
            
        }
        attaquer(ennemis.get(choix-1),monde);
        System.out.println("votre ennemi n'a plus que "+ennemis.get(choix-1).getPtVie()+" points de vie");
    }
       
    private void attaquer(Creature ennemi,World monde){
        int ecart = ennemi.getPos().distance(personnageJoue.getPos());
        if(ecart==1){
            personnageJoue.attaqueCorpsACorps(ennemi,monde);
        }else{
            personnageJoue.attaqueDistance(ennemi,monde);
        }
    }
        
        
         
    private ArrayList<Creature> verifierPresenceCreatureProches(Case[][] carte){
        int posX = personnageJoue.getPos().getX();
        int posY = personnageJoue.getPos().getY();
        ArrayList ennemis = new ArrayList<Creature>();

        for(int k =1 ; k <= personnageJoue.getDistAttMax(); k++){ //on parcours toutes les cases a distance de personnage
            for (int i=k ; i >= -k; i--){
                if (i == k || i == -k){//si on se trouve à une des extrémités, on parcourt toute la colonne
                    for (int j=-k ; j <= k; j++){
                        if(!Util.verifierSiPositionExiste(new Point2D(posX+i,posY+j), carte)){
                            continue;
                        }
                        if (carte[posX+i][posY+j] == null){
                            continue;
                        }
                        Case caseATester = carte[posX+i][posY+j];
                        if (caseATester.creature == null){
                            continue;
                        }
                        ennemis.add(caseATester.creature);
                    }
                }
                else {
                    if (Util.verifierSiPositionExiste(new Point2D(posX+i,posY+k), carte)){
                        if (carte[posX+i][posY+k] == null){
                            continue;
                        }
                        Case caseATester = carte[posX+i][posY+k];
                        if (caseATester.creature == null){
                            continue;
                        }
                        ennemis.add(caseATester.creature);
                    }
                    if (Util.verifierSiPositionExiste(new Point2D(posX+i,posY-k), carte)){
                        if (carte[posX+i][posY-k] == null){
                            continue;
                        }
                        Case caseATester = carte[posX+i][posY-k];
                        if (caseATester.creature == null){
                            continue;
                        }
                        ennemis.add(caseATester.creature);
                    }
                }
            }
        }
        return ennemis;
    }
    
    
    
    public void deplacerJoueur(Case[][] carte){
        affiche_boussole();
        int[] deplacement=new int[2];
        boolean deplacementValide= false;
        int x=personnageJoue.getPos().getX();
        int y=personnageJoue.getPos().getY();
        int newX=0;
        int newY=0;
        
        while (deplacementValide==false){
            deplacementValide= true;
            
            deplacement=choixDeplacement();
            
            newX=x+deplacement[0];
            newY=y+deplacement[1];
            
            if ((newX<0)||(newY<0)||(newY>=carte.length)||(newX>=carte.length)){
                deplacementValide=false;
                System.out.println("le déplacement sort de la carte, veuillez recommencer");
            }
            else if ((carte[newX][newY]!=null) && (deplacement[0]!=0 || deplacement[1]!=0) ){
                if (carte[newX][newY].creature!=null){
                    deplacementValide=false;
                    System.out.println("il y a deja une creature sur cette case, veuillez recommencer");
                }   
            }
        }
        
    personnageJoue.gererDeplacement(carte, x, y, newX, newY,true);
    }
    
    private void affiche_boussole(){
        System.out.println();
        System.out.println("   NO N NE");
        System.out.println("     \\|/");
        System.out.println("   O -x- E");
        System.out.println("     /|\\");
        System.out.println("   SO S SE");
        System.out.println("x pour rester sur place");
    }
    
    /*
    lit les commandes de l'utilisateur et renvoie les coordonées [X,Y] du déplacement voulu
    */
    private int[] choixDeplacement(){
        int[] direction=new int[2];
        System.out.println("choissisez votre deplacement");
        Scanner lectureClavier=new Scanner(System.in);
        String choix =lectureClavier.nextLine();
        choix = choix.toUpperCase();
        
        switch (choix){
            case "X":
                direction[0]=0;
                direction[1]=0;
                return direction;
            case "NO":
                direction[0]=-1;
                direction[1]=-1;
                return direction;
            case "N":
                direction[0]=-1;
                direction[1]=0;
                return direction;
            case "NE":
                direction[0]=-1;
                direction[1]=1;
                return direction;
            case "O":
                direction[0]=0;
                direction[1]=-1;
                return direction;
            case "E":
                direction[0]=0;
                direction[1]=1;
                return direction;
            case "SO":
                direction[0]=1;
                direction[1]=-1;
                return direction;
            case "S":
                direction[0]=1;
                direction[1]=0;
                return direction;
            case "SE":
                direction[0]=1;
                direction[1]=1;
                return direction;
            default:
                System.out.println("mauvaise entrée, veuillez recommencer");
                return choixDeplacement();
                
        }
    }
    public void afficheStat(){
        System.out.println("stats "+nomPersonnage+" :");
        personnageJoue.affiche();
        System.out.println();
    }
}
