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
        int id_perso=-1;
        try{
            String query1 = "INSERT INTO humanoide "+
                    "(page_att_arme_poing,page_par,dist_att_max,pt_degats_arme_poing,nombre_de_fleche,type_humanoide)"+
                    "VALUES (?,?,?,?,?,?) RETURNING id_humanoide";
            PreparedStatement stmt1 = connection.prepareStatement( query1 );
            stmt1.setInt(1, pagAttpoing);
            stmt1.setInt(2, pagPar);
            stmt1.setInt(3, distAttMax);
            stmt1.setInt(4, ptDegPoing);
            stmt1.setInt(5, nbrFleche);
            stmt1.setString(6, this.typeHumain());
            ResultSet rs= stmt1.executeQuery();
            if (rs.next()){
                id_perso=rs.getInt("id_humanoide");
            }
            String query = "INSERT INTO Creature (point_de_vie,position_x,position_y,id_monde,id_humanoide,est_male)" +
            " VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, ptVie);
            stmt.setInt(2, this.position.getX());
            stmt.setInt(3, this.position.getY());
            stmt.setInt(4, id_monde);
            stmt.setInt(5,id_perso);
            stmt.setBoolean(6,estMale);
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
    
    
    @Override
    public int saveCreatureJoueurToDatabase(Connection connection, Integer id_monde){
        int id_perso=-1;
        int id_creature=-1;
        try{
            String query1 = "INSERT INTO humanoide "+
                    "(page_att_arme_poing,page_par,dist_att_max,pt_degats_arme_poing,nombre_de_fleche,type_humanoide)"+
                    "VALUES (?,?,?,?,?,?) RETURNING id_humanoide";
            PreparedStatement stmt1 = connection.prepareStatement( query1 );
            stmt1.setInt(1, pagAttpoing);
            stmt1.setInt(2, pagPar);
            stmt1.setInt(3, distAttMax);
            stmt1.setInt(4, ptDegPoing);
            stmt1.setInt(5, nbrFleche);
            stmt1.setString(6, this.typeHumain());
            ResultSet rs1= stmt1.executeQuery();
            if (rs1.next()){
                id_perso=rs1.getInt("id_humanoide");
            }
            String query = "INSERT INTO Creature (point_de_vie,position_x,position_y,id_monde,id_humanoide,est_male)" +
            " VALUES (?,?,?,?,?,?) RETURNING id_creature";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1, ptVie);
            stmt.setInt(2, this.position.getX());
            stmt.setInt(3, this.position.getY());
            stmt.setInt(4, id_monde);
            stmt.setInt(5,id_perso);
            stmt.setBoolean(6,estMale);
            ResultSet rs= stmt.executeQuery();
            if (rs.next()){
                id_creature=rs.getInt("id_creature");
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
        return id_creature;
    }
    
    
    
    public String typeHumain(){
        System.out.println("type humain n'est pas sencé etre appellé dans cette classe");
        return null;
    }
    
    /**
     *
     * @param connection
     * @param idHumanoide
     */
    @Override
    public void getFromDatabase(Connection connection, Integer idHumanoide) {
        try{
            String query = "SELECT * FROM humanoide NATURAL JOIN creature WHERE id_humanoide=?";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1,idHumanoide );
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                this.position = new Point2D(rs.getInt("position_x"),rs.getInt("position_y"));
                this.ptVie=rs.getInt("point_de_vie");
                this.estMale=rs.getBoolean("est_male");
                this.pagAttpoing=rs.getInt("page_att_arme_poing");
                this.pagPar=rs.getInt("page_par");
                this.distAttMax=rs.getInt("dist_att_max");
                this.ptDegPoing=rs.getInt("pt_degats_arme_poing");
                this.nbrFleche=rs.getInt("nombre_de_fleche");
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
    
    
    
}
