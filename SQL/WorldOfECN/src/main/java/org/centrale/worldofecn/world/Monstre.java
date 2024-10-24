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
public abstract class Monstre extends Creature {
    
    protected int pEsquive;
    protected int pAttaque;
    protected int ptAttaque;
    /**
     *
     * @param world
     */
    public Monstre(World world) {
        super(world);
        pEsquive=10;
        pAttaque=50;
        ptAttaque=1;
    }
    
}
