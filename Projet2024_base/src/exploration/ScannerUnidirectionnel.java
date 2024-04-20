/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;


/**
 *
 * @author jo
 */
public class ScannerUnidirectionnel extends Outil
{
    private static final double MARGE_ERREUR = 0.2;
    private Direction directionCourante;
    
    private double getMarge(){return ScannerUnidirectionnel.MARGE_ERREUR;}
    public Direction getDirectionCourante(){
        return this.directionCourante;
    }
    
    protected void setDirectionCourante()
    {
        do
        {
            this.directionCourante = new Direction(Lire.S("Entrez une direction en combinant 'h','b','g','d' ou 'haut','bas','gauche','droite'"));
        }while(!directionCourante.isValide());
    }
      @Override
    public void interaction(Joueur j){
     System.out.println("Cette salle contient un scanner unidirectionnel");
     j.recupere(this);
    }
    public ScannerUnidirectionnel()
    {
        super
        (
                "}V",
                "Scanner unidirectionnel",
                "Détecte a travers les murs la distance —\n" +
                "en nombre de salles vides traversee — à laquelle se situe le premier objet — ou le mur du\n" +
                "plateau — dans une direction donnee. L'estimation de la distance est approximative : elle\n" +
                "est à 20% de la distance près. L'utilisation de cet outil nécessite 2 unités d'Energie. ",
                2//coût énergétique de l'utilisation du scanner
        );
    }    

    @Override
    public void activation(Joueur j)
    {
        this.setDirectionCourante();
        int salle=0;
        Position tmp = j.getPosition().getSuivante(directionCourante);
        System.out.println("condition");
        System.out.println(tmp.getPlateau().getSalle(tmp)==null);
        while ((tmp!=null && tmp.getPlateau().getSalle(tmp).isVide())){
            tmp=tmp.getSuivante(directionCourante);
            salle=salle+1;
        }
        
        int marge1=(int)Math.abs(salle-(this.getMarge()*salle));
        int marge2=(int)Math.abs(salle+(this.getMarge()*salle));

        j.getOutils().enlève(this);
        System.out.println("Le nombre de salles vides dans cette direction est compris entre "+marge1+" et "+marge2+".");
    }
}
