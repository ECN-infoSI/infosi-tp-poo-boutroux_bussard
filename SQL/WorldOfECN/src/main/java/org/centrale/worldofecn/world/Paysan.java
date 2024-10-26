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
public class Paysan extends Personnage {
    
    /**
     *
     * @param world
     */
    public Paysan(World world) {
        super(world);
        this.pagAttpoing=50;
        this.pagPar=10;
        this.distAttMax=1;
        this.ptDegPoing=5;
        this.nbrFleche=0;
    }
    
   
    /**
     *
     * @param connection
     * @param id
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id) {
        super.getFromDatabase(connection, id);
    }
    
    public String typeHumain(){
        return "Paysan";
    }    
}
