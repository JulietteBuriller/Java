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
     
    public ScannerCourtePortee()
    {
        super
        (
                "}O",
                "Scanner omnidirectionnel de courte portee",
                "- Un Scanner omnidirectionnel de courte portee permet de detecter au travers des murs le \n" +
                "nombre de salles contigues contenant un objet. Son utilisation necessite 1 unite d'energie",
                1
        );
    }    

    @Override
    public void activation(Joueur j)
    {
        int nbobj =0;

        for (int i=0;i<8;i++){
            Salle tmp=j.getSalle().getVoisine(new Direction(i));
            if(tmp!=null){
                if (!tmp.isVide())
                    nbobj++;
            }
        }
        System.out.println("il y a "+nbobj+" objets autour de vous.");
        
    }
}
