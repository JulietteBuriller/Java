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

    public String getSymbole(){return this.symbole;}
    public String getNature(){return this.nature;}
    
    private void setNature(String nature){this.nature = nature;}
    private void setSymbole(String symbole){this.symbole = symbole;}

    
    public abstract void interaction(Joueur j);
    public abstract int getNb();

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

    @Override
    public boolean equals(Object autre)
    {
        if (this == autre) return true;
        if (autre == null) return false;
        if (getClass() != autre.getClass())return false;
        final Outil autreObjet = (Outil) autre;
        return Objects.equals(this.getSymbole(), autreObjet.getSymbole());
    }
    
    @Override
    public String toString()
    {
        return this.getNb()+this.getSymbole();
    }
}
