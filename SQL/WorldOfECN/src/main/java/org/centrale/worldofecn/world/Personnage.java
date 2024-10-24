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
public abstract class Personnage extends Creature {
    
    protected int pagAttpoing;
    protected int pagPar;
    protected int distAttMax;
    protected int ptDegPoing;
    protected int nbrFleche;
    /**
     *
     * @param world
     */
    public Personnage(World world) {
        super(world);
        this.pagAttpoing=70;
        this.pagPar=30;
        this.distAttMax=1;
        this.ptDegPoing=8;
        this.nbrFleche=0;
    }
    
    /**
     *
     * @param connection
     * @param id_monde
     */
    @Override
    public void saveToDatabase(Connection connection, Integer id_monde) {
        try{
            String query = "INSERT INTO monstre "+
                    "(page_att_arme_poing,page_par,dist_att_max,pt_degats_arme_poing,nombre_de_fleche,type_humanoide)"+
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, pagAttpoing);
            stmt.setInt(2, pagPar);
            stmt.setInt(3, distAttMax);
            stmt.setInt(4, ptDegPoing);
            stmt.setInt(5, nbrFleche);
            stmt.setString(6, this.typeHumain());
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
        try{
            String query = "INSERT INTO Creature (point_de_vie,position_x,position_y,id_monde,id_humanoide,id_monstre,est_male)" +
            " VALUES (?,?,?,?,(SELECT max(id_humanoide) FROM humanoide),?)";
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
    
    public String typeHumain(){
        System.out.println("type humain n'est pas sencé etre appellé dans cette classe");
        return null;
    }
}
