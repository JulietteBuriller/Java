/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author louis
 */
public class ScannerCourtePortee extends Outil {
     
    public void interaction(Joueur j)
    {
        System.out.println("Cette salle contient un scanner omnidirectionnel de courte portee.");
        j.recupere(this); 
    }
    public ScannerCourtePortee()
    {
        super
        (
                "}O",
                "Scanner omnidirectionnel de courte portee",
                " il permet de detecter au travers des murs le \n" +
                "nombre de salles contiguës contenant un objet. Son utilisation necessite 1 unité d'energie",
                1
        );
    }    

    @Override
    public void activation(Joueur j)
    {
        int nbobj =0;
        
        j.getPosition().getSuivante();
        for (int i=0;i<8;i++){
            if (!j.getSalle().getVoisine(new Direction(i)).isVide())
                nbobj++;
        }
        j.getOutils().enlève(this);
        System.out.println("il y a "+nbobj+" objets autour de vous.");
        
    }
}
