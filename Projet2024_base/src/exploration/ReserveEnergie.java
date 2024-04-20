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
        super("$ ","Reserve Energie");
        setUenergie(disponible);
    }
    
    public ReserveEnergie()
    {
        this((int)(1+ReserveEnergie.MAX*Math.random()));
    }     
    
    public int getUenergie(){
        return this.uenergie;
    }
    @Override
    public int getNb(){
        return this.uenergie;
    }
    private void setUenergie(int uenergie) {
        this.uenergie = uenergie;
    }
   
    @Override
    public void interaction(Joueur j)
    {
        if (this.uenergie!=0){
            int e=Lire.i("Combien souhaitez-vous prendre d'unites d'energie ? (Il en reste "+uenergie+".)");
            
            if (e<=this.uenergie){
                j.setUEnergie(j.getUEnergie()+e);
                this.uenergie=this.uenergie-e;
            }
            else {
                j.setUEnergie(j.getUEnergie()+this.uenergie);
                System.out.println("Seulement "+this.uenergie+" unites d'energie ont ete ajoutees car il n'en restait plus assez dans la reserve.");  
                this.uenergie=0;
                }
        }
        else 
        System.out.println("il ne reste plus d'unites d'energie dans cette reserve.");}
        /* S'il reste des unités d'énergie dans cette réserve,
           propose au joueur d'en prendre un certain nombre,
           ce qui augmente l'énergie du joueur et diminue d'autant cette réserve
        */
    }
   

