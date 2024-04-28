/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author louis
 */
public class DetecteurMassique extends Outil {
    
    private static final double MARGE_ERREUR = 0.1;
    private Direction directionCourante;
        
    private double getMarge(){return DetecteurMassique.MARGE_ERREUR;}
    
    public Direction getDirectionCourante(){
        return this.directionCourante;
                
    }
    
    protected void setDirectionCourante(Direction d)
    {
       this.directionCourante=d;
    }
    
    public DetecteurMassique()
    {
        super
        
        (
                ">O",
                "Detecteur massique unidirectionnel",
                "- Un Detecteur massique unidirectionnel permet de connaitre approximativement (a 10% \n" +
                "pres) le nombre d'objets (tous types confondus) situes dans une direction donnee. Son \n" +
                "utilisation necessite 2 unites d'energie.",
                2
        );
       
    }    

    @Override
    public void activation(Joueur j)
    {
        this.setDirectionCourante(Direction.getDirectionQuelconque());
        
        int obj=0;
        Position tmp = j.getPosition().getSuivante(directionCourante);
        
        while ((tmp.getRang()!=-1)){System.out.println(tmp.getRang());
            if(!tmp.getPlateau().getSalle(tmp).isVide()){ 
            obj++;
            }
            System.out.println(this.directionCourante);
            tmp=new Position (tmp.getLig()+this.directionCourante.getdLig(),tmp.getCol()+this.directionCourante.getdCol(),tmp.getPlateau());
        }    
        int marge1=(int)Math.abs(obj-this.getMarge()*obj);
        int marge2=(int)Math.abs(obj+this.getMarge()*obj);
        System.out.println("Dans cette direction, le nombre d'objets est compris entre "+marge1+" et "+marge2+".");
    }
          
}
