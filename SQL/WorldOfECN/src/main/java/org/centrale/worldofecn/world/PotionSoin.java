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
public class PotionSoin extends Objet {
    
    /**
     *
     */
    public PotionSoin(World world) {
        super(world);
    }

    @Override
    public String typeObjet(){
        return "PotionSoin";
    }

    
    
}
