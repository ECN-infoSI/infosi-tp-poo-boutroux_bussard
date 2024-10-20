/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Quent
 */
public class creationErreur {
    
    public static void main(String[] args){
//        NullPointer();
//        OutOfRange();
//        ArithmeticExept();
//        ClassCast();
//        ConcurrentModification();
        StackOverFlow();
    }
    
    private static void OutOfRange(){
        ArrayList listeVide=new ArrayList();
        listeVide.get(1);
    }
    
    private static void NullPointer(){
        ArrayList<Case> listeDeCaseNonInitialisé=new ArrayList();
        listeDeCaseNonInitialisé.add(null);
        Creature AttributDuneCaseNonExistante=listeDeCaseNonInitialisé.get(0).creature;
    }
    
    private static void ArithmeticExept(){
        int zero=0;
        int deux=2;
        int resultatDivision= deux/0;
    }
    
    private static void ClassCast(){
        Objet epee =new Epee();
        PotionSoin Potion=(PotionSoin) epee;
    }
    
    private static void ConcurrentModification(){
        List<String> listePleine=new ArrayList<>();
        listePleine.add("1");
        listePleine.add("2");
        listePleine.add("3");
        
        Iterator<String> iterateur = listePleine.iterator();
        
        while(iterateur.hasNext()){
            String elementListe=iterateur.next();
            listePleine.remove(elementListe);
        }
    }
    
    private static void StackOverFlow(){
        StackOverFlow();
    }
}
