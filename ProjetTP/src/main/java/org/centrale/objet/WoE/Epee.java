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
public class Epee extends Objet {
    /**nombre de degat d'attaque que l eppee rajoute*/
    private int degAtt;
    private final int minQttDegat=1;
    private final int maxQttDegat=10;

    public Epee() {
        super();
        this.degAtt= genereNombreAleatoire();
    }

    public Epee(Point2D pos,int degAtt) {
        super(pos);
        this.degAtt = degAtt;
    }

    public Epee(Point2D point) {
        super(point);
        this.degAtt=genereNombreAleatoire();
    }
    
    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'E';
    }
    
    private int genereNombreAleatoire(){
        Random generateurAleatoire = new Random();
        return minQttDegat+ generateurAleatoire.nextInt(maxQttDegat-minQttDegat+1);
    }
}
