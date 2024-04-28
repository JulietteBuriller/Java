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
     
    public Excavatrice()
    {
        super
        (
                ">:*",
                "Excavatrice",
                "- Une excavatrice qui permet de creuser un mur sans faire exploser la mine qu'elle pourrait\n" +
                "contenir. Mais la mine n'est pas desactivee et le joueur ne peut pas entrer dans la salle\n" +
                "qui la contient sans la faire exploser. Son utilisation necessite 8 unites d'energie.",
                8//coût énergétique de la détection des mines
        );
    }    

    protected void setDirectionCourante(Direction d)
    {
     this.directionCourante=d;
    }
    
    @Override
    public void activation(Joueur j)
    {
        this.setDirectionCourante(Direction.getDirectionQuelconque());
        j.getSalle().setAcces(this.directionCourante);
        j.getSalle().getVoisine(directionCourante).setVisible(true);

    }
    
}
