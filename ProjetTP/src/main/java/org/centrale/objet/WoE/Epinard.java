/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author remib
 */
public class Epinard extends Nourriture {

    public Epinard(int augmentationCarac, Point2D point) {
        super(augmentationCarac, point);
    }

    public Epinard(int augmentationCarac) {
        super(augmentationCarac);
    }

    @Override
    protected void appliquerEffetNourriture(Joueur j) {
        System.out.println("vous mangez l'epinard, vous gagnez "+getAugmentationCarac()+" degats supplementaires");
        j.personnageJoue.setDegAtt(j.personnageJoue.getDegAtt() + getAugmentationCarac());
    }

    @Override
    public void annulerEffetNourriture(Joueur j) {
        System.out.println("les effets de l'epinard s'estompent, vous perdez "+getAugmentationCarac()+" degats supplementaires");
        j.personnageJoue.setDegAtt(j.personnageJoue.getDegAtt() - getAugmentationCarac());
    }

    @Override
    public void afficherObjet() {
        System.out.println("Epinard, donne " + getAugmentationCarac() + " degats supplementaires");
    }
    
}
