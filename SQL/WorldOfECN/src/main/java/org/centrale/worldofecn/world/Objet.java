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
 * @author kwyhr
 */
public abstract class Objet extends ElementDeJeu{
    
    /**
     *
     * @param world
     */
    public Objet(World world) {
        super(world);
    }
    
    /**
     *
     * @param connection
     */
    @Override
    public void saveToDatabase(Connection connection, Integer id_monde) {
        try{
            String query = "INSERT INTO objet "+
                    "(position_x,position_y,id_monde,type_objet)"+
                    "VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, this.position.getX());
            stmt.setInt(2, this.position.getY());
            stmt.setInt(3, id_monde);
            stmt.setString(4, this.typeObjet());
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
    public String typeObjet(){
        System.out.println("type objet n'est pas sencé etre appellé dans cette classe");
        return null;
    }
    
    /**
     *
     * @param connection
     * @param id
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id) {
        try{
            String query = "SELECT position_x, position_y FROM  objet WHERE id_objet=?";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                this.position = new Point2D(rs.getInt("position_x"),rs.getInt("position_y"));
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
        }  
    }
}
