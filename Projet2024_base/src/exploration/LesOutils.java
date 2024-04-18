/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Gère la liste des outils d'un joueur
 * @author jo
 */
public class LesOutils
{
    private ArrayList<Outil> liste;
    public int getTaille(){return liste.size();}
    public Outil get(int i){return liste.get(i);}
    public void setListe(ArrayList<Outil> liste){this.liste = liste;}
    private void init()
    {
        liste = new ArrayList<Outil>(); // Crée une liste d'outils vide
        liste.add(new ScannerUnidirectionnel()); // outil ajouté dès le départ
        liste.add(new DetecteurMines()); // idem
    }
    public void ajoute(Outil o)
    {
        if(this.isInList(o)) System.out.println(this.getProprietaire().NomtoString()+" est deja en possession de "+o);
        else {this.liste.add(o); o.nb=0;}
    }
    public void enlève(Outil o)
    {
        if(!this.liste.contains(o)) System.out.println(this.getProprietaire().NomtoString()+" n'est pas en possession de "+o);
        else this.liste.remove(o);
    }
    private Joueur proprietaire;
    public Joueur getProprietaire(){return this.proprietaire;}
    private void setProprietaire(Joueur proprietaire){this.proprietaire = proprietaire;}

    
    public boolean isInList(Outil o){
        return this.liste.contains(o);
     }
    public LesOutils(Joueur proprietaire)
    {
        this.setProprietaire(proprietaire);
        this.init();
    }

    @Override
    public String toString() {
        return "" + liste.toString() ;
    }

    
}
