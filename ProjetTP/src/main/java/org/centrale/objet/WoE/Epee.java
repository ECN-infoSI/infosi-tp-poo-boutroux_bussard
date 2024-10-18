/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 * L'epee est un objet permettant d'augmenter les degats de celui qui l'utilise. 
 * @author Quent
 */
public class Epee extends Recoltable{
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
    
    /**
     * Augmente les degats de l'utilisateur. 
     * @param utilisateur 
     * @param monde 
     */
    @Override
    public void utiliser(Creature utilisateur, World monde) {
        if (Util.estLeJoueur(utilisateur, monde)){
            System.out.println("vous avez trouve une eppee !");
            monde.joueur.stocker(this);
        }
        else {utilisateur.setDegAtt(utilisateur.getDegAtt()+degAtt);}
    }
    
    /**
     * affiche une phrase descriptive de l'objet
     */
    @Override
    public void afficherObjet(){
        System.out.println("Epee, inflige "+degAtt+" degats supplementaires");
    }
    
    /**
     * L'épée est sortie de l'inventaire et utilisée
     * @param j 
     */
    @Override
    public void consommerDepuisInventaire(Joueur j){
        System.out.println("vous equipez l'epee, vous gagnez "+degAtt+" degats supplementaires");
        j.personnageJoue.setDegAtt(j.personnageJoue.getDegAtt()+degAtt);
    }
}
