/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

import exploration.Joueur;
import exploration.Objet;

/**
 *
 * @author jo
 */
public abstract class Outil extends Objet
{    
    private int conso;
    private String descriptif;

    public int getConsommationEnergetique(){return this.conso;}
    protected void setConsommationEnergetique(int conso){this.conso = conso;}
    public String getDescriptif(){return this.descriptif;}
    protected void setDescriptif(String descriptif){this.descriptif = descriptif;}

    public boolean isUtilisablePar(Joueur j)
    { 
        if (j.getUEnergie()>=this.conso){
            return true;
        }
        else return false;
    }
    
    /**
     * Restitue des infos sur l'outil qui serviront à afficher un men
     * @return
     */
    public String getInfos(){return "("+this.getSymbole()+")"+this.getNature()+this.getDescriptif();}
    
    @Override
    public void interaction(Joueur j){}
    
    public void utilise(Joueur j)
    {
           if (this.isUtilisablePar(j))
           {
            this.activation(j);
            int energie=j.getUEnergie();
            energie = energie - this.conso;
        }
        else System.out.println("vous n'avez pas assez d'énergie pour utiliser cet outil.");
        
        /*
            Utilisation de l'outil. Il faut vérifier que le joueur a assez d'énergie (Sinon, faire un message d'erreur),
            activer l'outil (différemment suivant l'outil) et diminuer l'énergie du joueur en conséquence
        */
    }
    
    public abstract void activation(Joueur j); // activation spécifique à chaque outil
    
    public Outil(String symbole,String nature, String descriptif, int conso)
    {
        super(symbole,nature);
        this.setDescriptif(descriptif);
        this.setConsommationEnergetique(conso);
    }

    @Override
    public boolean equals(Object autre)
    {
        if (this == autre) return true;
        if (autre == null) return false;
        if (getClass() != autre.getClass())return false;
        return true;
    }
}
