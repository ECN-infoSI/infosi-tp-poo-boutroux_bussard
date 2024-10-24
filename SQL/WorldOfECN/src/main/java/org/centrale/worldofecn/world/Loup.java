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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ECN
 */
public class Loup extends Monstre {
    
    /**
     *
     */
    public Loup(World world) {
        super(world);
        pEsquive=25;
        pAttaque=75;
        ptAttaque=8;
    }
    
    /**
     *
     * @param connection
     * @param id_monde
     */
    @Override
    public void saveToDatabase(Connection connection, Integer id_monde) {
        super.saveToDatabase(connection, id_monde);
    }

    
    @Override
    public String typeMonstre(){
        return "Loup";
    }
}
