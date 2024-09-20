/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 *
 * @author remib
 */
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs1;
    public Lapin bugs2;

    public World() {
        this.bugs1=new Lapin();
        this.bugs2=new Lapin();
        this.robin=new Archer();
        this.peon=new Paysan();
    }
    
    public void creerMondeAlea(){
        int nbrElements =4;
        Random generateurAleatoire = new Random();
        Point2D[] positions = new Point2D[nbrElements];
        boolean testPosDifferents;
        
        for(int i=0;i<nbrElements;i++){
            testPosDifferents=false;
            
            while(testPosDifferents==false){
                positions[i]=generePoint2DAleatoire(generateurAleatoire);
                testPosDifferents=true;
                
                for(int j=0; j<i;j++){
                    if (positions[i].equals(positions[j])){
                        testPosDifferents=false;
                    }
                }
            }
        }
        bugs1.setPos(positions[0]);
        bugs2.setPos(positions[1]);
        peon.setPos(positions[2]);
        robin.setPos(positions[3]);
    }
    
    private Point2D generePoint2DAleatoire(Random generateurAleatoire){
        int taillemonde=2; //largeur du monde 
        int posX = generateurAleatoire.nextInt(taillemonde);
        int posY = generateurAleatoire.nextInt(taillemonde);
        Point2D pointAleatoire = new Point2D(posX, posY);
        pointAleatoire.affiche();
        return pointAleatoire;
    }
    
    public void afficheWorld(){
        System.out.print("L'archer se trouve en : ");
        robin.getPos().affiche();
        System.out.print("Le paysan se trouve en : ");
        peon.getPos().affiche();
        System.out.print("Le premier lapin se trouve en : ");
        bugs1.getPos().affiche();
        System.out.print("Le second lapin se trouve en : ");
        bugs2.getPos().affiche();
        
    }
}
