/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *Le lapin est un monstre assez faible
 * @author Quent
 */
public class Lapin extends Monstre {

    public Lapin() {
        super();
    }

    public Lapin(Point2D pos) {
        super(pos);
    }

    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Lapin(Lapin lapin) {
        super(lapin);
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'L';
    }
    
    @Override public void affiche(){
        System.out.println("Lapin");
        super.affiche();
    }
}
