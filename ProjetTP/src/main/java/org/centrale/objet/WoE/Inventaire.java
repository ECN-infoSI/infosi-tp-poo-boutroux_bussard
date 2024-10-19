/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Une classe qui stocke les éléments que le joueur rammasse
 * @author Quent
 */
public class Inventaire {
    private ArrayList<Recoltable> objetActivable;
    private ArrayList<Nourriture> NourritureActive;
    private Joueur joueur;

    public Inventaire(Joueur j) {
        this.joueur = j;
        this.NourritureActive = new ArrayList<Nourriture>();
        this.objetActivable = new ArrayList<Recoltable>();
    }

    public Inventaire() {
        this.joueur=new Joueur();
        this.NourritureActive = new ArrayList<Nourriture>();
        this.objetActivable = new ArrayList<Recoltable>();
    }

    public ArrayList<Recoltable> getObjetActivable() {
        return objetActivable;
    }

    public void setObjetActivable(ArrayList<Recoltable> objetactivable) {
        this.objetActivable = objetactivable;
    }

    public ArrayList<Nourriture> getNourritureActive() {
        return NourritureActive;
    }

    public void setNourritureActive(ArrayList<Nourriture> nourritureActive) {
        this.NourritureActive = nourritureActive;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * l'utilisateur choisi les elements de son inventaire qu'il veut utiliser 
     */
    public void consulterInventaire(){
        System.out.println();
        if(objetActivable.size()==0){
            System.out.println("Votre inventaire est vide");
            return;
        }
        System.out.println("Voici votre inventaire :");
        afficherObjetDisponibles();
        boolean veutSortir=false;
        int choix;
        
        while (!veutSortir){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Quel objet voulez vous utiliser ? 0 pour sortir");
            try{
                choix = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Mauvaise entrée");
                choix=-1;
            }
            if(choix==0){
                veutSortir=true;
            }else if (choix>objetActivable.size()){
                System.out.println("Mauvaise entrée");
            }else{
                utiliserObj(choix-1);
            }
        }
    }
            
            
            
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    /**
     * affiche le contenu de l'inventaire
     */
    public void afficherObjetDisponibles(){
        int k=1;
        for(Recoltable obj:objetActivable){
            System.out.print((k) +" : ");
            obj.afficherObjet();
            k++;
        }
    }
    /**
     * utilise un objet spécifique de l'inventaire
     * @param index indice de l'objet à tester
     */
    private void utiliserObj(int index){
        Recoltable obj= objetActivable.get(index);
        obj.consommerDepuisInventaire(this.joueur);
        objetActivable.remove(index);
        if (obj instanceof Nourriture){
            NourritureActive.add((Nourriture) obj);
        }
    }
}
