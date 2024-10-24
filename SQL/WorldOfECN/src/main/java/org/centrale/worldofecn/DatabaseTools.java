/* --------------------------------------------------------------------------------
 * WoE Tools
 * 
 * Ecole Centrale Nantes - Septembre 2022
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin
 * -------------------------------------------------------------------------------- */
package org.centrale.worldofecn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.centrale.worldofecn.world.World;

/**
 *
 * @author ECN
 */
public class DatabaseTools {

    private String login;
    private String password;
    private String url;
    private Connection connection;

    /**
     * Load infos
     */
    public DatabaseTools() {
        try {
            // Get Properties file
            ResourceBundle properties = ResourceBundle.getBundle(DatabaseTools.class.getPackage().getName() + ".database");
     
            // USE config parameters
            login = properties.getString("login");
            password = properties.getString("password");
            String server = properties.getString("server");
            String database = properties.getString("database");
            url = "jdbc:postgresql://" + server + "/" + database;

            // Mount driver
            Driver driver = DriverManager.getDriver(url);
            if (driver == null) {
                Class.forName("org.postgresql.Driver");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.connection = null;
    }

    /**
     * Get connection to the database
     */
    public void connect() {
        if (this.connection == null) {
            try {
                this.connection = DriverManager.getConnection(url, login, password);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Disconnect from database
     */
    public void disconnect() {
        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * get Player ID
     * @param nomJoueur
     * @param password
     * @return
     * @throws java.sql.SQLException
     */
    public Integer getPlayerID(String nomJoueur, String password){
        
        try{
            String query = "SELECT id_joueur FROM Joueur WHERE nom_de_code=? AND mot_de_passe=?";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setString(1, nomJoueur);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return processId(rs);
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
        return null;
    }

    
    /**
     * test result of SQL request
     * @param rs
     * @return
     * @throws SQLException 
     */
    private Integer processId(ResultSet rs) throws SQLException{
        if(rs.next()){
            int resultat=rs.getInt("id_joueur");
            System.out.println("var:"+resultat);
            if (rs.next()){
                System.out.println("erreur plusieurs compte identifiés");
                return null;
            }
            else{
                return resultat;
            }
        }
        else{
            System.out.println("ce compte n'existe pas"); 
            return null;
        }
    }
    /**
     * save world to database
     * @param idJoueur
     * @param nomPartie
     * @param nomSauvegarde
     * @param monde
     */
    public void saveWorld(Integer idJoueur, Integer idPartie, String nomPartie, String nomSauvegarde, World monde){
        Integer id_monde = monde.saveToDatabase(connection, idPartie, nomPartie, nomSauvegarde);

//INSERT INTO sauvegarde (id_monde,id_partie,date_sauvegarde,nom) 
//VALUES ('m1','p1','2024-04-10 00:00:00','Sauvegarde_1'),('m2','p1','2024-04-10 03:00:00','Sauvegarde_2'),('m5','p3','2024-04-10 00:00:00','Sauvegarde_1');
//
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("timestamp : " + timestamp);

        String query = "INSERT INTO sauvegarde (id_monde_sauvegarde,id_partie,date_sauvegarde,nom) "
                + "VALUES (?,?,?,?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id_monde);
            stmt.setInt(2, idPartie);
            stmt.setTimestamp(3, timestamp);
            stmt.setString(4, nomSauvegarde);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
//            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * get world from database
     * @param idJoueur
     * @param nomPartie
     * @param nomSauvegarde
     * @param monde
     */
    public void readWorld(Integer idJoueur, Integer idPartie, String nomPartie, String nomSauvegarde, World monde) {
        monde.getFromDatabase(connection, nomPartie, nomSauvegarde);
    }
}
