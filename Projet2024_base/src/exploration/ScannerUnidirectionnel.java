/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;


/**
 *
 * @author jo
 */
public class ScannerUnidirectionnel extends Outil
{
    private static final int MARGE_ERREUR = 20;
    private Direction directionCourante;
    
    private int getMarge(){return ScannerUnidirectionnel.MARGE_ERREUR;}
    public Direction getDirectionCourante(){
        return this.directionCourante;
    }
    
    protected void setDirectionCourante()
    {
        do
        {
            this.directionCourante = new Direction(Lire.S("Entrez une direction en combinant 'h','b','g','d' ou 'haut','bas','gauche','droite'"));
        }while(!directionCourante.isValide());
    }
    
    public ScannerUnidirectionnel()
    {
        super
        (
                "☞1",
                "Scanner unidirectionnel",
                "Détecte à travers les murs la distance —\n" +
                "en nombre de salles vides traversée — à laquelle se situe le premier objet — ou le mur du\n" +
                "plateau — dans une direction donnée. L'estimation de la distance est approximative : elle\n" +
                "est à 20% de la distance près. L'utilisation de cet outil nécessite 2 unités d'énergie. ",
                2//coût énergétique de l'utilisation du scanner
        );
    }    

    @Override
    public void activation(Joueur j)
    {
        this.setDirectionCourante();
        /* recherche dans une direction demandée au joueur jusqu'à tomber sur une position null (en dehors de l'enceinte)
            ou une salle contenant un objet. Le nombre de salles parcourues est affiché à 20% près
        */
    }
