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
        
    }

    public Mine(){super("*","Mine");}
    @Override
    public int getNb(){
        return 1;
    }
    
}
