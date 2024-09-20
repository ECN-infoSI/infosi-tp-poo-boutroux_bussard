/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author Quent
 */
public class Creature {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    public Creature() {
        this.ptVie = 100;
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 0;
        this.pagePar = 0;
        this.pos = new Point2D();
    }

    public Creature(Point2D pos) {
        this();
        this.pos = pos;
    }
    
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }
    
    public Creature(Creature m) {
        this(m.ptVie,m.degAtt,m.ptPar,m.pageAtt,m.pagePar,m.pos);
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public Point2D getPos() {
        return pos;
    }
    
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * Affiche tous les attributs de la créature. 
     */
    public void affiche(){
    System.out.println("Point de Vie    : "+ptVie);
    System.out.println("Degat d'attaque : "+ degAtt);
    System.out.println("Point de Parade : "+ptVie);
    System.out.println("% d'attaque     : "+ pageAtt);
    System.out.println("% de parade     : "+ pagePar);
    System.out.print("Position        :");
    pos.affiche();
    }
    
    /**
     * Deplace aleatoirement la creature sur une des cases adjacentes (diagonales inclues). 
     * La creature peut egalement ne pas se deplacer (1 chance sur 9). 
     */
    public void deplace(){
        Random generateurAleatoire = new Random();
        int avanceX = generateurAleatoire.nextInt(2)-1;
        int avanceY = generateurAleatoire.nextInt(2)-1;
        pos.translate(avanceX, avanceY);
    }
}
