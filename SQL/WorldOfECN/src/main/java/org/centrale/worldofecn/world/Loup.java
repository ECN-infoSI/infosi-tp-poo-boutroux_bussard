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
        try{
            String query = "INSERT INTO monstre (page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre) VALUES (?,?,?,'Loup')";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, pEsquive);
            stmt.setInt(2, pAttaque);
            stmt.setInt(3, ptAttaque);
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
        try{
            String query = "INSERT INTO Creature (point_de_vie,position_x,position_y,id_monde,id_humanoide,id_monstre,est_male)" +
            " VALUES (?,?,?,?,(SELECT max(id_monstre) FROM monstre),?)";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, ptVie);
            stmt.setInt(2, this.position.getX());
            stmt.setInt(3, this.position.getY());
            stmt.setInt(4, id_monde);
            stmt.setBoolean(5,estMale);
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
