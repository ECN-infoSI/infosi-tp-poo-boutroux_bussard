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
    
    public String typeMonstre(){
        System.out.println("type monstre n'est pas sencé etre appellé dans cette classe");
        return null;
    }
    
    /**
     *
     * @param connection
     * @param id_monde
     */
    @Override
    public void saveToDatabase(Connection connection, Integer id_monde){
        try{
            String query = "INSERT INTO monstre (page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre) VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, pEsquive);
            stmt.setInt(2, pAttaque);
            stmt.setInt(3, ptAttaque);
            stmt.setString(4, this.typeMonstre());
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
}
