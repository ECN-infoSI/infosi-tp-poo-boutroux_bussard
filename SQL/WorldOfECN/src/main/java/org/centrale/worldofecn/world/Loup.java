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
    }
    
    /**
     *
     * @param connection
     * @param id_monde
     */
    @Override
    public void saveToDatabase(Connection connection, Integer id_monde) {
        try{
            String query = "INSERT INTO monstre (page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre) VALUES (?,?,?,'Loup')";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, pesquive);
            stmt.setInt(2, pattaque);
            stmt.setInt(3, ptattaque);
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
        try{
            String query = "INSERT INTO Creature (point_de_vie,position_x,position_y,id_monde,id_humanoide,id_monstre,est_male)" +
            " VALUES (?,?,?,?,(SELECT max(id_monstre) FROM monstre),?)";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, ptvie);
            stmt.setInt(2, posX);
            stmt.setInt(3, posY);
            stmt.setInt(4, id_monde);
            stmt.setBoolean(5, est_male);
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
        
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
