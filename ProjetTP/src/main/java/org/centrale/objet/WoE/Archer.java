/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * L'archer est un personnage se battant à longue portee. 
 * @author Quent
 */
public class Archer extends Personnage implements Combattant {
    private int nbFleche;

    public Archer(int distAttMax, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos,int nbFleche) {
        super(distAttMax, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.nbFleche=nbFleche;
    }

    public Archer() {
        super();
        this.initialisefleche();
    }

    public Archer(Point2D pos) {
        super(pos);
        this.initialisefleche();
    }

    public Archer(Archer archer) {
        super(archer);
        this.nbFleche = archer.nbFleche;
    }
    
    @Override protected void initialiseDistAttMax(){
        this.distAttMax = 10;
    }
    
    @Override public void definirSymboleCarte(){
        symboleCarte = 'A';
    }
    
    private void initialisefleche(){
        this.nbFleche=5;
    }
    
    public void setNbFleche(int nbFleche) {
        this.nbFleche = nbFleche;
    }

    public int getNbFleche() {
        return nbFleche;
    }
    
    @Override public void affiche(){
        System.out.println("archer");
        super.affiche();
        System.out.println("nbr de fleches  : "+nbFleche);
    }
    
    /**
     * L'archer attaque s'il voit une creature a sa portee. 
     * @param carte 
     */
    @Override
    public void agir(Case[][] carte) {
        Creature creatureAAttaquer = verifierPresenceCreatureProches(carte);
        if (creatureAAttaquer != null){
            combattre(creatureAAttaquer);
        }
    }
    
    /**
     * L'archer se bat au corps a corps (avec un couteau par exemple)
     * et il se bat evidemment a distance
     * @param creature 
     */
    @Override
    public void combattre(Creature creature) {
        combatCorpsACorps(creature);
        combatADistance(creature);
    }
    
    /**
     * Tire une flèche sur une créature
     * @param creature 
     */
    private void combatADistance(Creature creature){
        if (getNbFleche() <=0){
            System.out.println("pas de fleches");
            return;
        }
        int distance = this.getPos().distance(creature.getPos());
        if (distance <= getDistAttMax() && distance > 1){
            attaqueDistance(creature);
            nbFleche -=1; 
        }
    }
}
