/* --------------------------------------------------------------------------------
 * WoE
 * 
 * Ecole Centrale Nantes - Septembre 2022
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin
 * -------------------------------------------------------------------------------- */
package org.centrale.worldofecn.world;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
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
     * @param gameName
     * @param saveName
     */
    public void saveToDatabase(Connection connection, Integer idPartie, String gameName, String saveName) {
        if (connection != null) {
            // Insertion du joueur
            String queryJoueur = "BEGIN; "+
                                 "INSERT INTO creature (point_de_vie, position_x, position_y, id_monde, id_humanoide, id_monstre);";
            
            Integer id_creature = 0;
            // Insertion du monde
            String query = "BEGIN;" + 
                            "INSERT INTO monde (id_creature, largeur, longueur) VALUES ("+id_creature+","+ width+ ","+height + ");" + 
                            "SELECT id_monde INTO id_monde FROM monde WHERE id_creature = "+id_creature+";" + 
                            "COMMIT;";

            // Insertion des elements
            
            // Get Player ID
            
            // Save world for Player ID
            //        INSERT INTO monde (id_monde, largeur, longueur) 
//        VALUES ('m1', 50, 50), ('m2', 55, 100),
//        ('m3', 60, 10), ('m4', 20, 50), ('m5', 50, 50);
//
//        INSERT INTO inventaire (id_inventaire) VALUES ('i2'), ('i3'), ('i4');
//        INSERT INTO humanoide (id_humanoide, type_humanoide, page_att_arme_poing, page_par, dist_att_max, pt_degats_arme_poing, nombre_de_fleche) VALUES ('g1', 'Guerrier', 10, 10, 10, 10, NULL), ('a1', 'Archer', 15, 15, 15, 15, 10), ('g2', 'Guerrier', 10, 10, 10, 10, NULL), ('g3', 'Guerrier', 10, 10, 10, 10, NULL), ('g4', 'Guerrier', 10, 10, 10, 10, NULL), ('g5', 'Guerrier', 10, 10, 10, 10, NULL), ('g6', 'Guerrier', 10, 10, 10, 10, NULL), ('a2', 'Archer', 15, 15, 15, 15, 10);
//        INSERT INTO objet (id_objet,position_x,position_y,id_monde,type_objet) VALUES ('ps1',10,1,'m1','PotionSoin'),('ps2',15,11,'m2','PotionSoin'),('ps3',12,5,'m4','PotionSoin');
//
//        INSERT INTO objet (id_objet,id_monde,id_inventaire,type_objet) VALUES ('e1','m2','i2','Epee'),('e2','m5','i3','Epee'),('e3','m5','i4','Epee'),('ps4','m5','i3','PotionSoin');
//        INSERT INTO monstre (id_monstre,page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre)
//VALUES ('m1',20,70,8,'Loup'),('m2',20,70,8,'Loup'),('m3',8,15,2,'Lapin'),('m4',8,15,2,'Lapin'),
//('m5',20,70,8,'Loup'),('m6',20,70,8,'Loup'),('m7',20,70,8,'Loup'),('m8',8,15,2,'Lapin');
//
//INSERT INTO creature (id_creature,point_de_vie,position_x,position_y,id_monde,id_humanoide,id_monstre,id_inventaire,est_male) VALUES 
//-- monde 1
//('c1',100,10,10,'m1','g1',NULL,NULL,TRUE);
        }
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
        }
    }
}
