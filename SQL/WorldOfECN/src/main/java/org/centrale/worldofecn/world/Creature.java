/* --------------------------------------------------------------------------------
 * WoE
 * 
 * Ecole Centrale Nantes - Septembre 2022
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin
 * -------------------------------------------------------------------------------- */
package org.centrale.worldofecn.world;

import java.sql.Connection;

/**
 *
 * @author ECN
 */
public abstract class Creature extends ElementDeJeu {
    
    protected int ptVie;
    protected boolean estMale;
   
    /**
     *
     * @param world
     */
    public Creature(World world) {
        super(world);
        ptVie=100;
        estMale=true;
    }
    
    public abstract int saveCreatureJoueurtoDatabase(Connection connection, Integer id_monde);
}
