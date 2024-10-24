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
public class Archer extends Personnage {
    
    /**
     *
     * @param world
     */
    public Archer(World world) {
        super(world);
        this.pagAttpoing=60;
        this.pagPar=20;
        this.distAttMax=3;
        this.ptDegPoing=8;
        this.nbrFleche=10;
    }
    
    

    /**
     *
     * @param connection
     * @param id
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id) {
    }
    
    public String typeHumain(){
        return "Archer";
    }    
}
