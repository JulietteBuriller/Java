/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

import java.util.Objects;

/**
 * Regroupe les points communs à tous les objets : un symbole, une nature (Mine par exemple) et la possibilité d'interagir avec le joueur
 * @author jo
 */
public abstract class Objet
{
    private String symbole;
    private String nature;
    public int nb=1;

    public String getSymbole(){return this.symbole;}
    public String getNature(){return this.nature;}
    public int getnb(){return this.nb;}
    
    private void setNature(String nature){this.nature = nature;}
    private void setSymbole(String symbole){this.symbole = symbole;}
    private void setNb(int nb){this.nb=nb;}

    
    public abstract void interaction(Joueur j);
    public abstract int getNb();
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.symbole);
        return hash;
    }

    
    public Objet(String symbole, String nature)
    {
        this.setSymbole(symbole);
        this.setNature(nature);
    }

    public boolean equals(Objet autre)
    {
        if (this == autre) return true;
        if (autre == null) return false;
        if (getClass() != autre.getClass())return false;
        //final Outil autreObjet = (Outil) autre;
        return Objects.equals(this.getSymbole(), autre.getSymbole());
    }
    
    @Override
    public String toString()
    {
        return this.getSymbole();
    }
    public String getSymbolInd()
    {
        return this.getNb()+this.toString();
    }
}
