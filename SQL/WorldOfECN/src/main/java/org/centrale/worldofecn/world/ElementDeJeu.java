/* --------------------------------------------------------------------------------
 * WoE
 * 
 * Ecole Centrale Nantes - Septembre 2022
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin
 * -------------------------------------------------------------------------------- */

package org.centrale.worldofecn.world;

import java.sql.Connection;
import java.util.Random;

/**
 *
 * @author ECN
 */
public abstract class ElementDeJeu {
    protected Point2D position;
    
    /**
     * generate element in the world
     * @param world
     */
    public ElementDeJeu(World world) {
        super();
        
        Random rand = new Random();
        this.position = new Point2D(rand.nextInt(world.getWidth()), rand.nextInt(world.getHeight()));
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
    
    /**
     *
     * @param connection
     */
    public abstract void saveToDatabase(Connection connection, Integer id_monde);
    
    /**
     *
     * @param connection
     * @param id
     */
    public abstract void getFromDatabase(Connection connection, Integer id);
}
