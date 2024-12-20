/* --------------------------------------------------------------------------------
 * WoE
 * 
 * Ecole Centrale Nantes - Septembre 2022
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin
 * -------------------------------------------------------------------------------- */
package org.centrale.worldofecn.world;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * contient tous les elements de la partie et gère son déroulé
 * @author ECN
 */
public class World {

    private static final int MAXPEOPLE = 20;
    private static final int MAXMONSTERS = 10;
    private static final int MAXOBJECTS = 20;

    private Integer width;
    private Integer height;

    private List<ElementDeJeu> listElements;
    private Joueur player;

    /**
     * Default constructor
     */
    public World() {
        this(20, 20);
    }

    /**
     * Constructor for specific world size
     *
     * @param width : world width
     * @param height : world height
     */
    public World(int width, int height) {
        this.setHeightWidth(height, width);
        init();
        generate();
    }

    /**
     * Initialize elements
     */
    private void init() {
        this.listElements = new LinkedList();
        this.player = new Joueur("Player");
    }

    /**
     *
     * @return
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @param height
     * @param width
     */
    public final void setHeightWidth(Integer height, Integer width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    /**
     * Check element can be created
     *
     * @param element
     * @return
     */
    private ElementDeJeu check(ElementDeJeu element) {
        return element;
    }

    /**
     * Generate personnages
     */
    private void generatePersonnages(int nbElements) {
        Random rand = new Random();
        for (int i = 0; i < nbElements; i++) {
            int itemType = rand.nextInt(3);
            Personnage item = null;
            while (item == null) {
                switch (itemType) {
                    case 0: // Guerrier
                        item = new Guerrier(this);
                        break;
                    case 1: // Archer
                        item = new Archer(this);
                        break;
                    case 2: // Paysan
                        item = new Paysan(this);
                        break;
                }
                item = (Personnage) check(item);
            }
            // Add to list
            this.listElements.add(item);
        }
    }

    /**
     * Generate Monsters
     */
    private void generateMonsters(int nbElements) {
        Random rand = new Random();

        // Generate monsters
        for (int i = 0; i < nbElements; i++) {
            int itemType = rand.nextInt(2);
            Monstre item = null;
            while (item == null) {
                switch (itemType) {
                    case 0: // Lapin
                        item = new Lapin(this);
                        break;
                    case 1: // Loup
                        item = new Loup(this);
                        break;
                }
                item = (Monstre) check(item);
            }
            // Add to list
            this.listElements.add(item);
        }
    }

    /**
     * Generate Objects
     */
    private void generateObjects(int nbElements) {
        Random rand = new Random();

        // Generate objects
        for (int i = 0; i < nbElements; i++) {
            int itemType = rand.nextInt(2);
            Objet item = null;
            while (item == null) {
                switch (itemType) {
                    case 0: // Potion de soin
                        item = new PotionSoin(this);
                        break;
                    case 1: // Arme
                        item = new Epee(this);
                        break;
                }
                item = (Objet) check(item);
            }
            // Add to list
            this.listElements.add(item);
        }
    }

    /**
     * Generate Player
     */
    private void generatePlayer(int itemType) {
        Personnage item = null;
        while (item == null) {
            switch (itemType) {
                case 0: // Guerrier
                    item = new Guerrier(this);
                    break;
                case 1: // Archer
                    item = new Archer(this);
                    break;
                case 2: // Paysan
                    item = new Paysan(this);
                    break;
            }
            item = (Personnage) check(item);
        }
        // Add to list
        this.listElements.add(item);
        // Add to joueur
        this.player.setPersonnage(item);
    }

    /**
     * Generate elements randomly
     */
    private void generate() {
        Random rand = new Random();

        generatePlayer(1);

        generatePersonnages(rand.nextInt(MAXPEOPLE));
        generateMonsters(rand.nextInt(MAXMONSTERS));
        generateObjects(rand.nextInt(MAXOBJECTS));
    }

    /**
     * Set Player name
     *
     * @param name
     */
    public void setPlayer(String name) {
        this.player.setNom(name);
    }

    /**
     * Save world to database
     *
     * @param connection
     * @param idPartie
     * @param gameName
     * @param saveName
     * @return 
     */
    public Integer saveToDatabase(Connection connection, Integer idPartie, String gameName, String saveName) {
        if (connection != null) {
            // Insertion du joueur
//            String queryJoueur ="BEGIN; "+
//                                "INSERT INTO creature (point_de_vie, position_x, position_y, id_monde, id_humanoide, id_monstre);"+
//                                "VALUES (?,?,?,?,?,?)"+
//                                "SELECT MAX(id_creature) FROM creature;"+
//                                "COMMIT;";
//            Integer id_creature_joueur = -1;
//            
//            System.out.println("queryJoueur : " + queryJoueur);
//            try{
//                PreparedStatement stmt = connection.prepareStatement(queryJoueur);
//                ResultSet rs = stmt.executeQuery();
//                if (rs.next()){
//                    id_creature_joueur = rs.getInt("id_creature");
//                }
//                System.out.println("id_creature_joueur : " + id_creature_joueur);
//            }
//            catch (SQLException ex){
//                System.err.println(ex);
//            }
//            
//            
//            // Insertion du monde
//            String query = "BEGIN;" + 
//                            "INSERT INTO monde (id_creature, largeur, longueur) VALUES ("+id_creature_joueur+","+ width+ ","+height + ");" + 
//                            "SELECT id_monde FROM monde WHERE id_creature = "+id_creature_joueur+";" + 
//                            "COMMIT;";
            
//            System.out.println("query world pas utile : " + query);
            
            String queryWorld = "INSERT INTO monde (largeur, longueur) VALUES ("+ width+ ","+height + ") RETURNING id_monde;";
            
            Integer id_monde = -1;
            
            try{
                PreparedStatement stmt = connection.prepareStatement(queryWorld);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    id_monde = rs.getInt("id_monde");
                }
                System.out.println("id_monde : " + id_monde);
                
                
            }
            catch (SQLException ex){
                System.err.println(ex);
                return -1;
            }
            boolean joueurSauvegarde = false;
            for (ElementDeJeu element : listElements){
                if (!joueurSauvegarde){
                    ((Creature) element).saveCreatureJoueurToDatabase(connection, id_monde);
                    joueurSauvegarde = true;
                }
                else {
                    element.saveToDatabase(connection, id_monde);
                }
            }
            String queryPartie = "UPDATE partie\n" +
                                "SET column_name = new_value\n" +
                                "WHERE column_name IS NULL;";
            
            return id_monde;
        }
        return -1;
    }

    /**
     * Get world from database
     *
     * @param connection
     * @param gameName
     * @param saveName
     */
    public void getFromDatabase(Connection connection, String gameName, String saveName) {
        if (connection != null) {
            // Remove old data
            this.setHeightWidth(0, 0);
            init();

            // Get Player ID
            
            // get world for Player ID   
            Integer id_world = 1;
            String queryWorld = "SELECT largeur, longueur,id_monde FROM monde WHERE id_monde = (SELECT MAX(id_monde)AS id_max FROM monde);";
            try{
                PreparedStatement stmt = connection.prepareStatement( queryWorld );
//                stmt.setInt(1,id_world);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    height = rs.getInt("longueur");
                    width = rs.getInt("largeur");
                    id_world=rs.getInt("id_monde");
                }
            }
            catch(SQLException ex){
                System.err.println(ex);
                ex.printStackTrace();
                return;
            }
            creerJoueur(id_world,connection);
            creerCreatures("humanoide", "Guerrier", "Guerrier", id_world, connection);
            creerCreatures("humanoide", "Paysan", "Paysan", id_world, connection);
            creerCreatures("humanoide", "Archer", "Archer", id_world, connection);
            creerCreatures("monstre", "Loup", "Loup", id_world, connection);
            creerCreatures("monstre", "Lapin", "Lapin", id_world, connection);
            creerObjets(id_world, connection);
//            String type_humanoide = "Guerrier";
//            Integer id_humanoide = -1;
//            try{
//                String query = "SELECT humanoide.id_humanoide FROM (humanoide JOIN creature ON humanoide.id_humanoide = creature.id_humanoide) JOIN monde ON monde.id_monde = creature.id_monde WHERE creature.id_monde = ? AND humanoide.type_humanoide = ?;";
//                PreparedStatement stmt = connection.prepareStatement( query );
//                stmt.setInt(1,id_world);
//                stmt.setString(2,type_humanoide);
//                ResultSet rs = stmt.executeQuery();
//                System.out.println("query : "+ query);
//                while (rs.next()){
//                    System.out.println("rs.next() true : ");
//                    id_humanoide = rs.getInt("id_humanoide");
//                    System.out.println("id_humanoide : "+id_humanoide);
//                    Guerrier newGuerrier = new Guerrier(this);
//                    newGuerrier.getFromDatabase(connection, id_humanoide);
//                    listElements.add(newGuerrier);
//                }
//            }
//            catch (SQLException ex){
//                System.err.println(ex);
//                ex.printStackTrace();
//            }
        }
    }
    
    /**
     * récupère toutes les créatures non joueur du monde dans la bdd et les implémentes dans ce monde
     * @param humanoideOumonstre contient soit "humanoide" soit "monstre"
     * @param classeJava contient le nom de la classe finale dans le code java (par ex "Guerrier")
     * @param classeBdd contient le nom de l'entité dans la bdd (par exemple "Archer"
     * @param id_world id du monde dont on veut récupérer les donnees
     * @param connection 
     */
    private void creerCreatures(String humanoideOumonstre, String classeJava, String classeBdd, int id_world,Connection connection){
        Integer id_creature = -1;
        try{
            String id=".id_"+humanoideOumonstre;
            //SELECT humanoide.id_humanoide FROM (humanoide JOIN creature ON humanoide.id_humanoide = creature.id_humanoide)
            String query = "SELECT "+humanoideOumonstre + id+
                    " FROM (("+humanoideOumonstre+" JOIN creature ON "+humanoideOumonstre +id+" = creature"+id+")"+
                    "JOIN monde ON monde.id_monde = creature.id_monde) WHERE creature.id_monde = ? AND monde.id_creature <> creature.id_creature "+
                    "AND "+humanoideOumonstre+".type_"+humanoideOumonstre+" = ?;";
//            System.out.println(query);
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1,id_world);
            stmt.setString(2,classeBdd);
            ResultSet rs = stmt.executeQuery();
            
            Class<?> typeCreature = Class.forName("org.centrale.worldofecn.world."+classeJava);
            Constructor<?> constructor = typeCreature.getDeclaredConstructor(World.class);
            Class<?>[] methodParamTypes = { Connection.class,Integer.class };
            Method method = typeCreature.getDeclaredMethod("getFromDatabase", methodParamTypes);
//            int k=0;
            while (rs.next()){
//                k++;
//                System.out.println(classeJava + " : " + k);
                id_creature = rs.getInt("id_"+humanoideOumonstre);
                Object newCreature = constructor.newInstance(this);
                method.invoke(newCreature, connection, id_creature);
                listElements.add((ElementDeJeu) newCreature);
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
             System.err.println(ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (SecurityException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }
    
    /**
     * recupere tous les objets du monde dans la bdd et les implémentes dans ce monde
     * @param id_world
     * @param connection 
     */
    private void creerObjets(int id_world, Connection connection){
       Objet newobjet; 
       try{
            String query="SELECT id_objet, type_objet FROM objet WHERE id_monde = ?";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1,id_world);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                switch(rs.getString("type_objet")){
                    case "Epee":
                        newobjet=new Epee(this);
                        break;
                    case "PotionSoin":
                        newobjet=new PotionSoin(this);
                        break;
                    default:
                        System.out.println("type d'objet inconnu");
                        continue;
                }
                newobjet.getFromDatabase(connection, rs.getInt("id_objet"));
                listElements.add(newobjet);
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
    
    /**
     * recupere le joueur dans la bdd et l'implémente dans le monde
     * @param id_world
     * @param connection 
     */
    private void creerJoueur(int id_world, Connection connection){
       try{
            String query="SELECT id_humanoide, id_monstre FROM (creature JOIN monde ON creature.id_creature = monde.id_creature)"+
                    "WHERE monde.id_monde = ?";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1,id_world);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                if (rs.getInt("id_humanoide")!=0){
                    creerUnHumanoide(rs.getInt("id_humanoide"),connection);
                }
                else if(rs.getInt("id_monstre")!=0){
                    creerUnMonstre(rs.getInt("id_monstre"),connection);
                }
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
    
    /**
     * recupere un humanoide spécifique et en fait le personnage joueur de ce monde
     * @param id_humanoide
     * @param connection 
     */
    private void creerUnHumanoide(int id_humanoide,Connection connection){
        String type_humanoide="";
        Boolean persoDef=false;
        try{
            String query="SELECT type_humanoide FROM humanoide WHERE id_humanoide = ?";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1,id_humanoide);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                type_humanoide=rs.getString("type_humanoide");
                persoDef=true;
            }
            
            if(persoDef){
                Personnage perso=null;
                switch(type_humanoide){
                    case "Guerrier":
                        perso=new Guerrier(this);
                        break;
                    case "Archer":
                        perso=new Archer(this);
                        break;
                    case "Paysan":
                        perso =new Paysan(this);
                        break;
                    default:
                        System.out.println("classe non reconnue");
                }
                
                if(perso!=null){
                    perso.getFromDatabase(connection, id_humanoide);
                    this.player.setPersonnage(perso);
                    this.listElements.add(perso);
                }
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
    
    /**
     * recupere un monstre spécifique et en fait le personnage joueur de ce monde
     * @param id_monstre
     * @param connection 
     */
    private void creerUnMonstre(int id_monstre,Connection connection){
        String type_monstre="";
        Boolean persoDef=false;
        try{
            String query="SELECT type_monstre FROM monstre WHERE monde.id_monde = ?";
            PreparedStatement stmt = connection.prepareStatement( query );
            stmt.setInt(1,id_monstre);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                type_monstre=rs.getString("type_monstre");
                persoDef=true;
            }
            
            if(persoDef){
                Monstre perso=null;
                switch(type_monstre){
                    case "Lapin":
                        perso=new Lapin(this);
                        break;
                    case "Loup":
                        perso=new Loup(this);
                        break;
                    default:
                        System.out.println("classe non reconnue");
                }
                
                if(perso!=null){
                    perso.getFromDatabase(connection, id_monstre);
                    System.out.println("le personnage ne peut pas etre un monstre");
                    this.listElements.add(perso);
                }
            }
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }
}
