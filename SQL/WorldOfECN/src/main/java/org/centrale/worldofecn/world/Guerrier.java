/* --------------------------------------------------------------------------------
 * WoE
 * 
 * Ecole Centrale Nantes - Septembre 2022
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin
 * -------------------------------------------------------------------------------- */
package org.centrale.worldofecn.world;

import java.sql.Connection;

/**
 *
 * @author ECN
 */
public class Guerrier extends Personnage {
    
    /**
     *
     * @param world
     */
    public Guerrier(World world) {
        super(world);
    }
    
    /**
     *
     * @param connection
     */
    @Override
    public void saveToDatabase(Connection connection){//int id_monde) {
//        INSERT INTO monstre (page_esquive,page_attaque_arme_naturelle,pt_att_arme_naturelle,type_monstre) VALUES (?,?,?,'Loup');
//        INSERT INTO Creature (point_de_vie,position_x,position_y,id_monde,id_humanoide,id_monstre,est_male) VALUES 
//        (?,?,?,?,(SELECT max(id_monstre) FROM monstre),?);
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
