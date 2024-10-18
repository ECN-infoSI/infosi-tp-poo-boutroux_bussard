/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Les objets peuvent se trouver sur la carte ou dans l'inventaire d'une creature(bientot implemente). 
 * @author Quent
 */
public abstract class  Objet implements AffichableCarte{
    private Point2D pos;
    
    protected char symboleCarte;
    
    public Objet() {
        this.pos= new Point2D();
        definirSymboleCarte();
    }
    
    public Objet(Point2D point){
        this.pos = new Point2D(point);
        definirSymboleCarte();
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
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'O';
    }
    
    public abstract void utiliser(Creature utilisateur);
    
    
}
