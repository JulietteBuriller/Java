/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 * À compléter
 * @author jo
 */
public class Jeu
{
    private Plateau plateau;
    public Plateau getPlateau(){return this.plateau;}
    public void setPlateau(Plateau plateau){ this.plateau = plateau;}  

    private Categorie[] listeCategories;
    public void setListeCategories(Categorie[] listeCategories){this.listeCategories = listeCategories;}
    public Categorie[] getListeCategories(){return this.listeCategories;}

    private int proportionVides;

    /**
     * Proportion de salles vides par rapport à l'ensemble des salles : 50 signifie que 50% des salles du plateau sont vides
     * @return
     */
    public int getProportionVides(){return this.proportionVides;}
    private void setProportionVides(int proportionVides){this.proportionVides = proportionVides;}
    
    public boolean isFini(){return true;}

    /**
     * Restitue le joueur qui a été créé dans le plateau (Le joueur pourrait aussi être référencé dans une instance de jeu)
     * @return
     */
    public Joueur getJoueur(){return this.getPlateau().getJoueur();}
    
    public void initJeu(){}
    
   public void joue()
    {
        while (!this.getJoueur().isPerdant()) /*(et tant qu'il n'a pas gagné)*/ 
        {
            System.out.println("Que vous voulez vous faire ?");
            
            System.out.println("1- Lancer une grenade");
            System.out.println("2- Aller dans une salle accessible");
            System.out.println("3- Utiliser un outil");
            System.out.println("4- Abandonner");
            int choix = Lire.i("Rentrer 1,2,3, ou 4 : ");
            
            switch (choix){
                case 1:
                        Direction d1 = new Direction();
                        do
                        {
                            d1=new Direction(Lire.S("Entrez la direction dans laquelle vous souhaitez lancer votre grenade en combinant 'h','b','g','d' ou 'haut','bas','gauche','droite'"));

                        }while(!d1.isValide());
                        this.getJoueur().lanceGrenade(d1);
                    
                case 2:
                    Direction d2 = new Direction();
                    do
                    {
                         d2=new Direction(Lire.S("Entrez la direction de la salle dans laquelle vous souhaitez aller 'h','b','g','d' ou 'haut','bas','gauche','droite'"));

                    }while(!d2.isValide());
                    this.getJoueur().avance(d2);
                    
                case 3: 
                    
                case 4: 
                    this.getJoueur().setPerdant(true);
            }
            
        }
        System.out.println (this.getPlateau().toString());
        // Déroulement du jeu
    }
    public Jeu(int nbLig, int nbCol, int proportionVides, Categorie... listeCategories)
    {
        this.setListeCategories(listeCategories);
        this.setProportionVides(proportionVides);
        Plateau p =new Plateau(nbLig,nbCol,this);
        this.setPlateau(p);
        
        this.joue();
        /*  initialisations du jeu : création d'un plateau et exécution de joue()
            nbLig et nbCol sont les tailles du plateau (Elles peuvent être fixes au moins au début)
        */
    }
}
