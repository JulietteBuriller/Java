/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

import java.util.ArrayList;

/**
 *
 * @author jo
 */
public class Salle
{    
    private boolean visible;
    private Position position;
    private Plateau plateau;
    private Objet objet;
    private ArrayList<Direction> acces;


    /**
     * restitue true si la salle est visible
     * @return
     */
    public boolean isVisible()
    {
        return this.visible||this.getPlateau().isVisible();
    }
    protected void setVisible(boolean visible)
    {
        this.visible = visible;
    }
    
    public Position getPosition(){return this.position;}
    private void setPosition(Position position){this.position = position;}
    
    public Plateau getPlateau()
    {
        return this.plateau;
    }
    private void setPlateau(Plateau p){this.plateau = p;}


    /**
     * Restitue la référence à l'objet contenu dans la salle… ou null
     * @return une référence à un objet
     */
    public Objet getContenu() {return this.objet;}
    protected void setObjet(Objet objet){this.objet = objet;}

    public boolean isVide(){return this.getContenu()==null;};
    
    /*
        Gère les accès aux salles contigües (horizontalement et verticalement). Au départ, la salle est emmurée : aucun accès.
        Quand un mur est détruit, on crée un accès vers la salle contiguë et un accès inverse à partir de cette salle
    */
    public boolean isPossible(Direction d){return acces.contains(d);}
    private void initAcces(){this.acces = new ArrayList<Direction>();}//Création d'une liste d'accès vide

    /**
     * Crée un accès vers la salle contiguë dans la direction donnée… si l'accès n'existe pas déjà et si la salle contiguë existe
     * L'accès inverse est aussi ajouté (direction inverse ajoutée à la liste d'accès de la salle contiguë)
     * @param d La direction : haut, bas, gauche, droite
     */
    public void setAcces(Direction d)
    {
        if (this.isPossible(d)==false && this.getVoisine(d) != null)
        {
            this.acces.add(d);
            this.getVoisine(d).acces.add(d.getInverse());
            this.setVisible(true);
        }
        else System.out.print("");
    }
    public String getSymbole(){
       if(this.getPlateau().getJoueur().getPosition().equals(this.getPosition()))
            if (this.isVide()) return "|  j|";
                else 
                    return "|"+this.getContenu().getSymbolInd()+ " j|";
        else if (this.isVide()) return "|   |";
                else 
                    return "|"+this.getContenu().getSymbolInd()+"|";
        
        // renvoie des espaces ou le toString de l'objet contenu dans la salle
    }
    
    public void entree(Joueur j)
    {   
         if (j.getPosition().equals(this.getPosition())){
            this.setVisible(true);}
         if (this.getPosition().equals(this.getPlateau().getSortie().getPosition())){
             System.out.println("Vous avez gagne !");
             j.setGagnant(true);}
         if (!this.isVide()){
             this.getContenu().interaction(j); 
            
            }
            
        // activé quand le joueur se positionne sur la salle. Déclenche l'intéraction avec l'objet contenu dans la salle s'il y en a un
        
    }
    @Override
    public  String toString()
    {
        if(this.isVisible())
            if (this.getPosition().equals(this.getPlateau().getSortie().getPosition()))
                return "Exit" ;
            else return this.getSymbole();
                return "#####"; // salle non visible
    }
    
    /**
     * Restitue la salle contiguë dans la direction donnée… ou null si on sort du plateau
     * @param d
     * @return
     */
    public Salle getVoisine(Direction d)
    {
        Position posSuivante = this.getPosition().getSuivante(d);
        if(posSuivante.isValide()) return this.getPlateau().getSalle(posSuivante);
        else return null;
    }
        
    public Salle(Position pos, Plateau p, Objet o)
    {
        this.initAcces();
        this.setPosition(pos);
        this.setPlateau(p);
        this.setObjet(o);// initialisations
        this.setVisible(false); // au départ, la salle n'est pas visible
    }
    public Salle(Position pos, Plateau p)
    {
        this(pos,p,null);
    }
}
