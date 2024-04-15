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
        super(disponible+"$","Reserve Energie");
        setUenergie(disponible);
    }
    
    public ReserveEnergie()
    {
        this((int)(1+ReserveEnergie.MAX*Math.random()));
    }     
    
    public int getUenergie(){
        return this.uenergie;
    }

    private void setUenergie(int uenergie) {
        this.uenergie = uenergie;
    }
    
    @Override
    public void interaction(Joueur j)
    {
        if (this.uenergie!=0){
            int e=Lire.i("Rentrer un nombre d'unités d'énergie : ");
            
            if (e<=this.uenergie){
                j.setUEnergie(j.getUEnergie()+e);
                this.uenergie=this.uenergie-e;
            }
            else {
                j.setUEnergie(j.getUEnergie()-this.uenergie);
                System.out.println("Seulement "+this.uenergie+" unités d'énergie ont été ajoutées car il n'en restait plus assez dans la réserve.");  
                this.uenergie=0;
                }
        }
        else 
        System.out.println("il ne reste plus d'unités d'énergie dans cette réserve.");}
        /* S'il reste des unités d'énergie dans cette réserve,
           propose au joueur d'en prendre un certain nombre,
           ce qui augmente l'énergie du joueur et diminue d'autant cette réserve
        */
    }
