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
    
    public void setDirectionCourante(Direction dir){
        this.directionCourante=dir;
    }
    public Direction getDirectionCourante(){
        return this.directionCourante;
                
    }
       
    public DetecteurMassique()
    {
        super
        
        (
                ">O",
                "Detecteur massique unidirectionnel",
                " permet de connaître approximativement (à 10% \n" +
                "pres) le nombre d'objets — tous types confondus — situes dans une direction donnee. Son \n" +
                "utilisation necessite 2 unites d'energie.",
                2
        );
       
    }    

    @Override
    public void activation(Joueur j)
    {
        this.setDirectionCourante(this.getDirectionCourante().getDirectionQuelconque());
        int obj=0;
        Position tmp = j.getPosition().getSuivante(directionCourante);
        while (tmp!=null){
            if (!j.getSalle().isVide()){
                obj++;
            }
            tmp=tmp.getSuivante(directionCourante);
        }
        int marge1=(int)Math.abs(obj-this.getMarge()*obj);
        int marge2=(int)Math.abs(obj+this.getMarge()*obj);
        j.getOutils().enlève(this);
        System.out.println("Dans cette direction, le nombre d'objets est compris entre "+marge1+" et "+marge2+".");
    }
           
      

    
    @Override
    public void interaction(Joueur j){
        System.out.println("Cette salle contient un detecteur massique unidirectionnel");
        j.recupere(this);
    }
    
}
