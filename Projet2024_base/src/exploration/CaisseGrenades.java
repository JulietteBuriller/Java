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
        
        super("@ ","grenade");
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
