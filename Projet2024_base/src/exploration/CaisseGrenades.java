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

    public CaisseGrenades(int nbGrenades){
        
        super("G","grenade");
        this.setNbgren(nbGrenades);
        
        
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
    public int getNb(){
        return nbgren;
    }
    @Override
    public void interaction(Joueur j)
    {
           if (this.nbgren!=0){
            int g=Lire.i("Combien souhaitez vous prendre de grenades ? il y en a "+nbgren+" disponible.");
            if (this.nbgren>=g){
                j.setNbgrenades(j.getNbgrenades()+g);
                this.nbgren=this.nbgren-g;
            }
            else {
                j.setNbgrenades(j.getNbgrenades()+this.nbgren);
                System.out.println("Seulement "+this.nbgren+" grenades ont été ajoutées car il n'en restait plus assez dans la réserve.");  
                this.nbgren=0;
            }
        }
        else System.out.println("Il ne reste plus de grenades dans cette réserve.");
        
        /* S'il reste des grenades dans cette réserve,
           propose au joueur d'en prendre un certain nombre,
           ce qui augmente les grenades du joueur et diminue d'autant cette réserve
        */
    }
    
}
