/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class ReserveEnergie extends Objet
{
    private final static int MAX = 9;
    private int uenergie;

    public ReserveEnergie(int disponible){
        super("<symbole>","nom");
        setUenergie(disponible);
    }
    
    public ReserveEnergie()
    {
        this((int)(1+ReserveEnergie.MAX*Math.random()));
    }     
    
    public int getuReserveEnergie(){
        return this.uenergie;
    }

    private void setUenergie(int uenergie) {
        this.uenergie = uenergie;
    }
    
    @Override
    public void interaction(Joueur j)
    {
        int jenergie =j.getUEnergie();
        if (this.uenergie!=0){
            int e=Lire.i("Combien en voulez-vous : ");
            
            if (e<=this.uenergie){
                jenergie= jenergie + e;
                this.uenergie=this.uenergie-e;
                j.setUEnergie(jenergie);
            }
            else {
                jenergie=jenergie+this.uenergie;
                this.uenergie=0;
                j.setUEnergie(jenergie);
                System.out.println("Il restait "+this.uenergie+" unités d'énergie dans cette réserve.\nVous ne pouviez donc pas en prendre "+e+"On vous a donc rajouté tout ce qu'il restait dans la réserve");
                }
        }
        else 
        System.out.println("il ne reste plus d'unités d'énergie dans cette réserve.");}
        /* S'il reste des unités d'énergie dans cette réserve,
           propose au joueur d'en prendre un certain nombre,
           ce qui augmente l'énergie du joueur et diminue d'autant cette réserve
        */
    }

