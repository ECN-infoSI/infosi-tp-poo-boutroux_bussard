/* --------------------------------------------------------------------------------
 * WoE
 * 
 * Ecole Centrale Nantes - Septembre 2022
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin
 * -------------------------------------------------------------------------------- */

package org.centrale.worldofecn.world;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ECN
 */
public class Lapin extends Monstre {
    
    /**
     *
     * @param world
     */
    public Lapin(World world) {
        super(world);
    }
    
    /**
     *
     * @param connection
     */
    @Override
    public void saveToDatabase(Connection connection, Integer id_monde) {
        super.saveToDatabase(connection, id_monde);
    }

    /**
     *
     * @param connection
     * @param id
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id) {
        super.getFromDatabase(connection, id);
    }
    
    @Override
    public String typeMonstre(){
        return "Lapin";
    }
}
