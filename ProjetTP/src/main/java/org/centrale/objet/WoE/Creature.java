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
public class Creature implements AffichableCarte{
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    protected char symboleCarte;  

    public Creature() {
        this.ptVie = 100;
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 0;
        this.pagePar = 0;
        this.pos = new Point2D();
        definirSymboleCarte();
    }

    public Creature(Point2D pos) {
        this();
        this.pos = new Point2D(pos);
    }
    
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = new Point2D(pos);
        definirSymboleCarte();
    }
    
    public Creature(Creature m) {
        this(m.ptVie,m.degAtt,m.ptPar,m.pageAtt,m.pagePar,new Point2D(m.pos));
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

    public char getSymboleCarte() {
        return symboleCarte;
    }

    @Override
    public void definirSymboleCarte() {
        symboleCarte = 'T';
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
     * si la creature veut se deplacer sur une case contenant une autre creature, elle reste sur place
     * si la creature veut se deplacer sur une case hors de la carte elle fait le mouvement opposé
     * @param carte le tableau représentant contenant les differents objets du monde et leur positions 
     */
    public void deplace(Case[][] carte){
        
        Random generateurAleatoire = new Random();
        
        int oldX=this.pos.getX();
        int oldY=this.pos.getY();
        
        int avanceX = generateurAleatoire.nextInt(3)-1;
        int avanceY = generateurAleatoire.nextInt(3)-1;
        
        int newX=oldX +avanceX;
        int newY=oldY +avanceY;
        
        //si la case cible du déplacement existe et qu'elle contient une créature on interrompt le déplacement
        if (carte[newX][newY] != null){
            if (carte[newX][newY].creature != null){
                avanceX=0;
                avanceY=0;
            }
        }else if ( newX<0 || newX>carte.length || newY<0 || newY>carte.length){ //si la case cible est hors limites, on inverse le déplacement
                avanceX=-avanceX;
                avanceY=-avanceY;
                }
        
        newX=oldX+avanceX;
        newY=oldY+avanceY;
        
        //vider case oldX,oldY;
        if (carte[oldX][oldY].objet != null ){
            carte[oldX][oldY].creature=null;
        }else {
            carte[oldX][oldY]=null;
        }
        
        //remplir case newX,newY;
        if (carte[newX][newY]==null){
            carte[newX][newY] = new Case(this);
        } 
        else {
            carte[newX][newY].creature=this;
        }
        
        //modifier la position de la créature
        this.pos.translate(avanceX, avanceY);    
       
    }
    
    protected void combatCorpsACorps(Creature creature){
        if (this.getPos().distance(creature.getPos()) <= 1){
            attaque(creature);
        }
    }
    
    protected void attaque(Creature creature){
        Random generateurAleatoire = new Random();
        int jetDe = generateurAleatoire.nextInt(100) + 1;
        if (getPageAtt() >= jetDe){
            jetDe = generateurAleatoire.nextInt(100) + 1;
            if (creature.getPagePar() >= jetDe){
                int degats = Math.max(this.getDegAtt() - creature.getPtPar(), 0);
                int nouveauPointVie = Math.max(creature.getPtVie() - degats, 0);
                creature.setPtVie(nouveauPointVie);
            }
        }
    }
}
