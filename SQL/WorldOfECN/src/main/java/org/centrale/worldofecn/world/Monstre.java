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
        int id_monstre=-1;
        try{
            String query1 = "INSERT INTO monstre (page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre) "+
                    "VALUES (?,?,?,?) RETURNING monstre_id";
            PreparedStatement stmt1 = connection.prepareStatement( query1 );
            stmt1.setInt(1, pEsquive);
            stmt1.setInt(2, pAttaque);
            stmt1.setInt(3, ptAttaque);
            stmt1.setString(4, this.typeMonstre());
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()){
                id_monstre=rs.getInt("monstre id");
            }
            String query2 = "INSERT INTO Creature (point_de_vie,position_x,position_y,id_monde,id_monstre,est_male)" +
            " VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt2 = connection.prepareStatement( query2 );
            stmt2.setInt(1, ptVie);
            stmt2.setInt(2, this.position.getX());
            stmt2.setInt(3, this.position.getY());
            stmt2.setInt(4, id_monde);
            stmt2.setInt(5,id_monstre);
            stmt2.setBoolean(6,estMale);
            stmt2.executeUpdate();
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
}
