/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;

/**
 *
 * @author Quent
 */
public class Inventaire {
    private ArrayList<Recoltable> objetInactifs;
    private ArrayList<Recoltable> objetActif;
    private Joueur joueur;

    public Inventaire(Joueur j) {
        this.joueur = j;
        this.objetActif = new ArrayList<Recoltable>();
        this.objetInactifs = new ArrayList<Recoltable>();
    }

    public Inventaire() {
        this.joueur=new Joueur();
        this.objetActif = new ArrayList<Recoltable>();
        this.objetInactifs = new ArrayList<Recoltable>();
    }

    public ArrayList<Recoltable> getObjetInactifs() {
        return objetInactifs;
    }

    public void setObjetInactifs(ArrayList<Recoltable> objetInactifs) {
        this.objetInactifs = objetInactifs;
    }

    public ArrayList<Recoltable> getObjetActif() {
        return objetActif;
    }

    public void setObjetActif(ArrayList<Recoltable> objetActif) {
        this.objetActif = objetActif;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public void afficherObjetDisponibles(){
        int k=0;
        for(Recoltable obj:objetActif){
            System.out.print(k +" :");
            obj.afficherObjet();
        }
    }
    
    private void utiliserObj(int index){
        Objet obj= objetActif.get(index);
    }
}
