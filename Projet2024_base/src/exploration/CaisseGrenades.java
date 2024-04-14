/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 * À compléter
 * @author jo
 */
public class CaisseGrenades extends Objet
{
    private final static int MAX = 9;// nombre maximal dans les caisses de grenades trouvées dans les salles
    private int nbgren;

     public CaisseGrenades(int nbGrenades)
    {
        super("<symbole>","nom");
        setNbgren(nbGrenades);
        //suite code
    }
    
   public CaisseGrenades()
    {
        this((int)(1+10*Math.random()));
    }
    
    public static int getMAX() {
        return MAX;
    }
    public int getNbgren() {
        return nbgren;
    }

    private void setNbgren(int nbgren) {
        this.nbgren = nbgren;
    }

    @Override
   public void interaction(Joueur j)
    {
        int grenade=j.getNbgrenades();
        if (this.nbgren!=0){
            int g=Lire.i("Rentrer un nombre de grenades : ");
            if (this.nbgren>=g){
                grenade=grenade+g;
                this.nbgren=this.nbgren-g;
                j.setNbgrenades(grenade);
            }
            else {
                grenade=grenade+this.nbgren;
                this.nbgren=0;
                j.setNbgrenades(grenade);
                System.out.println("Seulement "+this.nbgren+" grenades ont été ajoutées car il n'en restait plus assez dans la réserve");  
            }
        }
        else System.out.println("il ne reste plus de grenades dans cette réserve");
        
        /* S'il reste des grenades dans cette réserve,
           propose au joueur d'en prendre un certain nombre,
           ce qui augmente les grenades du joueur et diminue d'autant cette réserve
        */
    }

   
}
