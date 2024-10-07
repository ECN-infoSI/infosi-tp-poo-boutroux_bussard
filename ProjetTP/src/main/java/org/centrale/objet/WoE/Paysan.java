/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * une créature de type humanoide Paysan
 * @author Quent
 */
public class Paysan extends Personnage {

    public Paysan(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(distAttMax, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Paysan() {
        super();
        this.setPtVie(this.getPtVie()+60);
        this.setDegAtt(this.getDegAtt()+4);
        this.setPtPar(this.getPtPar()+1);
        this.setPageAtt(this.getPageAtt()+50);
        this.setPagePar((this.getPagePar())+10);
    }

    public Paysan(Point2D pos) {
        super(pos);
        this.setPtVie(this.getPtVie()+60);
        this.setDegAtt(this.getDegAtt()+4);
        this.setPtPar(this.getPtPar()+1);
        this.setPageAtt(this.getPageAtt()+50);
        this.setPagePar((this.getPagePar())+10);
    }

    public Paysan(Paysan paysan) {
        super(paysan);
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'P';
    }
    
    @Override public void affiche(){
        System.out.println("paysan");
        super.affiche();
    }
}
