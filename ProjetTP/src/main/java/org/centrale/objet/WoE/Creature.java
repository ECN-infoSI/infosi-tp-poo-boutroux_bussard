/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Classe abstraite que possèdent tous les etres vivants du monde. 
 * @author Quent
 */
public abstract class Creature implements AffichableCarte, Deplacable{
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    protected char symboleCarte;
    protected int distAttMax; 

    public Creature() {
        Random generateurAleatoire = new Random();
        this.ptVie = generateurAleatoire.nextInt(21);
        this.degAtt = generateurAleatoire.nextInt(3);
        this.ptPar = generateurAleatoire.nextInt(3);
        this.pageAtt = generateurAleatoire.nextInt(6);
        this.pagePar = generateurAleatoire.nextInt(11);
        this.pos = new Point2D();
        definirSymboleCarte();
        initialiseDistAttMax();
    }

    public Creature(Point2D pos) {
        this();
        this.pos = new Point2D(pos);
    }
   
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = new Point2D(pos);
        definirSymboleCarte();
        initialiseDistAttMax();
    }

    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, int distAttMax) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
        this.distAttMax = distAttMax;
        definirSymboleCarte();
    }

    protected void initialiseDistAttMax(){
        this.distAttMax=1;
    }
    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    
    
    public Creature(Creature m) {
        this(m.ptVie,m.degAtt,m.ptPar,m.pageAtt,m.pagePar,m.pos,m.distAttMax);
    }

    
    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public Point2D getPos() {
        return pos;
    }
    
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public char getSymboleCarte() {
        return symboleCarte;
    }

    @Override
    public void definirSymboleCarte() {
        symboleCarte = 'T';
    }
    
    public void definirSymboleCarte(char symbole){
        symboleCarte = symbole;
    }
    
    /**
     * Affiche tous les attributs de la créature. 
     */
    public void affiche(){
    System.out.println("Point de Vie    : "+ptVie);
    System.out.println("Degat d'attaque : "+ degAtt);
    System.out.println("Point de Parade : "+ptVie);
    System.out.println("% d'attaque     : "+ pageAtt);
    System.out.println("% de parade     : "+ pagePar);
    System.out.println("Dist d'att max  : "+distAttMax);
    System.out.print("Position        :");
    pos.affiche();
    }
    
    /**
     * Deplace aleatoirement la creature sur une des cases adjacentes (diagonales inclues). 
     * La creature peut egalement ne pas se deplacer (1 chance sur 9).
     * si la creature veut se deplacer sur une case contenant une autre creature, elle reste sur place
     * si la creature veut se deplacer sur une case hors de la carte elle fait le mouvement opposé
     * @param carte le tableau représentant contenant les differents objets du monde et leur positions 
     */
    @Override
    public void deplacer(Case[][] carte,World monde){
        
        Random generateurAleatoire = new Random();
        
        int oldX=this.pos.getX();
        int oldY=this.pos.getY();
        
        int avanceX = generateurAleatoire.nextInt(3)-1;
        int avanceY = generateurAleatoire.nextInt(3)-1;
//       int avanceX=0;
//       int avanceY=1;
       
//        System.out.println();
//        System.out.println("avance random : "+avanceX+";"+avanceY);
        int newX=oldX +avanceX;
        int newY=oldY +avanceY;
        
        
        if ( newX<0 || newX>=carte.length ){ //si la case cible est hors limites, on inverse le déplacement
            avanceX=-avanceX;
            newX=oldX+avanceX;      
        }
        if(newY<0 || newY>=carte.length){
            avanceY=-avanceY;
            newY=oldY+avanceY;
        }
        
        //si la case cible du déplacement existe et qu'elle contient une créature on interrompt le déplacement
        if (carte[newX][newY] != null){
            if (carte[newX][newY].creature != null){
                newX=oldX;
                avanceY=0;
                avanceX=0;
                newY=oldY;
            }
        }
//        System.out.println("avance final  : "+avanceX+";"+avanceY);
        this.gererDeplacement(carte, oldX, oldY, newX, newY,false,monde);
    }
    
    /**
     * change les coordonnées de la créature sur la carte et dans créature
     * !!Neccessite d'avoir vérifier que la case d'arrivée est possible!!
     * (case vide et dans la carte)
     * @param carte tableau de case contenant les objets
     * @param oldX abscisse de la position avant déplacement
     * @param oldY ordonnée de la position avant déplacement
     * @param newX abscisse de la position après déplacement
     * @param newY ordonnée de la position après déplacement
     * @param estLeJoueur
     */
    public void gererDeplacement(Case[][] carte,int oldX, int oldY, int newX, int newY,boolean estLeJoueur, World monde){
        //vider case oldX,oldY;
        if (carte[oldX][oldY].objet != null ){
            carte[oldX][oldY].creature=null;
        }else {
            carte[oldX][oldY]=null;
        }
        
        //remplir case newX,newY;
        if (carte[newX][newY]!=null){
            carte[newX][newY].creature=this;
        } 
        else {
            carte[newX][newY] = new Case(this);
        }
        
        //modifier la position de la créature
        this.pos.SetPosition(newX, newY);
        
        //utiliser les objets de la case d'arrivée
        if (carte[newX][newY].objet!=null){
            carte[newX][newY].objet.utiliser(this,monde);
            if (carte[newX][newY].objet instanceof Recoltable){
                carte[newX][newY].objet = null;
            }
        }
    }
    
    /**
     * La méthode à appeler pour que la créature fasse ses actions spécifiques
     * @param carte 
     */
    public abstract void agir(Case[][] carte,World monde);
    
    /**
     * Verfie que la creature est adjacente puis l'attaque. 
     * @param creature 
     */
    protected void combatCorpsACorps(Creature creature, World monde){
        if (this.getPos().distance(creature.getPos()) <= 1){
//            System.out.println("combat corps a corps");
            attaqueCorpsACorps(creature,monde);
            
        }
    }
    
    /**
     * Attaque pouvant etre paree. 
     * @param creature 
     */
    protected void attaqueCorpsACorps(Creature creature,World monde){
        
        boolean joueurImplique=joueurImpliqueDansCombat(creature, monde);
        
        
        Random generateurAleatoire = new Random();
        int jetDe = generateurAleatoire.nextInt(100) + 1;
        if(joueurImplique){System.out.println("jet d'attaque : "+jetDe);}
        if (getPageAtt() >= jetDe){
            if(joueurImplique){System.out.println("l'attaque reussi !");}
            jetDe = generateurAleatoire.nextInt(100) + 1;
            if(joueurImplique){System.out.println("jet de parade : "+jetDe);}
            int degats;
            if (creature.getPagePar() >= jetDe){
                degats = Math.max(this.getDegAtt() - creature.getPtPar(), 0);
                if(joueurImplique){System.out.println("la parade est reussie "+degats+" degats sont infliges");}
            }else{
                degats =this.getDegAtt();
                if(joueurImplique){System.out.println("la parade est manquee "+degats+" degats sont infliges");}
            }
            int nouveauPointVie = Math.max(creature.getPtVie() - degats, 0);
            creature.setPtVie(nouveauPointVie);
            
        }else if(joueurImplique){System.out.println("l'attaque manque !");}
    }
    
    /**
     * Attaque ne pouvant pas etre paree. 
     * @param creature 
     */
    protected void attaqueDistance(Creature creature,World monde){
        boolean joueurImplique=joueurImpliqueDansCombat(creature, monde);
        Random generateurAleatoire = new Random();
        int jetDe = generateurAleatoire.nextInt(100) + 1;
        if(joueurImplique){System.out.println("jet d'attaque : "+jetDe);}
        if (getPageAtt() >= jetDe){
            int degats =this.getDegAtt();
            if(joueurImplique){System.out.println("l'attaque reussi ! "+degats+" degats sont infliges");}
            int nouveauPointVie = Math.max(creature.getPtVie() - degats, 0);
            creature.setPtVie(nouveauPointVie);
            
        }else if(joueurImplique){
            System.out.println("l'attaque manque !");
        }
    }
    
    private boolean joueurImpliqueDansCombat(Creature creature,World monde){
        
        boolean joueurImplique;
        
        if (this.getPos().getX()==monde.joueur.personnageJoue.getPos().getX() && this.getPos().getY()==monde.joueur.personnageJoue.getPos().getY()){
            joueurImplique=true;
            System.out.println("Vous attaquez le "+ creature.getClass().getSimpleName()+" !");
        }
        else if(creature.getPos().getX()==monde.joueur.personnageJoue.getPos().getX() && creature.getPos().getY()==monde.joueur.personnageJoue.getPos().getY()){
            joueurImplique=true;
            monde.afficheWorld();
            System.out.println("Un "+this.getClass().getSimpleName()+" vous attaque !");
        }
        else{
            joueurImplique=false;
        }
        return joueurImplique;
    }
    /**
     * Permet de déterminer quelle créature est la plus proche dans le périmètre de ditance d'attaque
     * @param carte
     * @return 
     */
    public abstract Creature verifierPresenceCreatureProches(Case[][] carte);
}