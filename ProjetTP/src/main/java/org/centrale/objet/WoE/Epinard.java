/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *Un aliment restorant de la force pendant 3 tour
 * @author remib
 */
public class Epinard extends Nourriture {

    public Epinard(int augmentationCarac, Point2D point) {
        super(augmentationCarac, point);
    }

    public Epinard(int augmentationCarac) {
        super(augmentationCarac);
    }
    
    public Epinard(Point2D point) {
        super(point);
    }
    
    public Epinard(){
        super();
    }

    /**
     * Gére les effets lors de la consomation par le joueur
     * @param j 
     */
    @Override
    protected void appliquerEffetNourriture(Joueur j) {
        System.out.println("vous mangez l'epinard, vous gagnez "+getAugmentationCarac()+" degats supplementaires");
        j.personnageJoue.setDegAtt(j.personnageJoue.getDegAtt() + getAugmentationCarac());
    }

    /**
     * annule les effets qui c'était appliqué lors de la consommation
     * @param j 
     */
    @Override
    public void annulerEffetNourriture(Joueur j) {
        System.out.println("les effets de l'epinard s'estompent, vous perdez "+getAugmentationCarac()+" degats supplementaires");
        j.personnageJoue.setDegAtt(j.personnageJoue.getDegAtt() - getAugmentationCarac());
    }

    /**
     * affiche une phrase de description de l'objet
     */
    @Override
    public void afficherObjet() {
        System.out.println("Epinard, donne " + getAugmentationCarac() + " degats supplementaires");
    }
    
}
