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
public class Guerrier extends Personnage {
    
    /**
     *
     * @param world
     */
    public Guerrier(World world) {
        super(world);
    }
    
    /**
     *
     * @param connection
     */
    @Override
    public void saveToDatabase(Connection connection) {
        
    }

    /**
     *
     * @param connection
     * @param id
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id) {
    }
}
