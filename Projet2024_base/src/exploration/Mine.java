/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Mine extends Objet
{
    
    @Override
    public void interaction(Joueur j)
    {
        System.out.println("Vous avez perdu...(boom!)");
        j.setPerdant(true);
        this.nb=0;
        
    }

    public Mine(){super("* ","Mine");}
    
    @Override
    public int getNb(){
        return this.getnb();
    }
    
}
