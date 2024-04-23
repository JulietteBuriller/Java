/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author buril
 */
public class Excavatrice extends Outil{
    
     private Direction directionCourante;
    
    @Override
    public void interaction(Joueur j){
     System.out.println("Cette salle contient une Excavatrice");
     j.recupere(this);
    }
    
    public Excavatrice()
    {
        super
        (
                ">:*",
                "Excavatrice",
                "Une excavatrice qui permet de creuser un mur sans faire exploser la mine qu'elle pourrait\n" +
                "contenir. Mais la mine n'est pas desactivee et le joueur ne peut pas entrer dans la salle\n" +
                "qui la contient sans la faire exploser. Son utilisation necessite 8 unites d'energie.",
                8//coût énergétique de la détection des mines
        );
    }    

    protected void setDirectionCourante()
    {
        do
        {
            this.directionCourante = new Direction(Lire.S("Entrez une direction en combinant 'h','b','g','d' ou 'haut','bas','gauche','droite'"));
        }while(!directionCourante.isValide());
    }
    
    @Override
    public void activation(Joueur j)
    {
        this.setDirectionCourante();
        j.getPosition().getPlateau().getSalle(j.getPosition()).setAcces(this.directionCourante);
        j.getOutils().enlève(this);
    }
    
}
