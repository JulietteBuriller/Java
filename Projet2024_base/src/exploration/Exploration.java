package exploration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 * Classe d'amorce qui créne une instance de jeu. À compléter avec d'autres objets/outils
 * @author jo
 */
public class Exploration
{

    /**
     * Création des différentes catégories d'objets et des proportions de leurs instances par rapport aux instances d'autres catégories dans le plateau
     * Par exemple, ici, dans le plateau il y aura deux fois plus de réserves d'énergie que de caisses de grenades
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
       Categorie
                grenades = new Categorie(5, CaisseGrenades.class),
                mines = new Categorie(5, Mine.class),
                unitededeminage = new Categorie(5, UniteDeDeminage.class),
                energie = new Categorie(8, ReserveEnergie.class),
                scannerCourtePortee = new Categorie(7, ScannerCourtePortee.class),
                detecteurMassique = new Categorie(3, DetecteurMassique.class),
                excavatrice = new Categorie(3, Excavatrice.class);
        Jeu p = new Jeu(7, 7, 28, grenades,mines,energie,scannerCourtePortee,detecteurMassique,excavatrice,unitededeminage);
       
       
    }
}
