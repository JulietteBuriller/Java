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
    private void setPlateau(Plateau plateau){ this.plateau = plateau;}  

    private Categorie[] listeCategories;
    private void setListeCategories(Categorie[] listeCategories){this.listeCategories = listeCategories;}
    public Categorie[] getListeCategories(){return this.listeCategories;}

    private int proportionVides;

    /**
     * Proportion de salles vides par rapport à l'ensemble des salles : 50 signifie que 50% des salles du plateau sont vides
     * @return
     */
    public int getProportionVides(){return this.proportionVides;}
    private void setProportionVides(int proportionVides){this.proportionVides = proportionVides;}
    
    public boolean isFini()
    {
       
        return (this.getJoueur().isGagnant()||this.getJoueur().isPerdant());
    }
    /**
     * Restitue le joueur qui a été créé dans le plateau (Le joueur pourrait aussi être référencé dans une instance de jeu)
     * @return
     */
    public Joueur getJoueur(){return this.getPlateau().getJoueur();}
    
    public void initJeu(){
        System.out.println("EXPLODING GAME");
        System.out.println("Le but du jeu est de trouver la sortie qui se situe dans l'une des salle du coin du plateau,\nmais gare aux mines si jamais vous entrez dans une salle qui en contient une c'est la mort assuree !");
        System.out.println("Pour cela vous disposez du materiel de depart(grenades pour vous deplacer/unites d'energie pour utiliser des outils),\ncependant vous pouvez aussi en acquerir durant le jeu, en entrant dans certaines salles.");
        
        System.out.println("voici une petit rappel de ce qui existe :");
        for(int i=0;i<this.getJoueur().getOutils().getTaille();i++){
        System.out.println(this.getJoueur().getOutils().get(i).getDescriptif()+"("+this.getJoueur().getOutils().get(i).getSymbole()+")");
        }
        System.out.println("Voici le plateau, pour l'instant aucune salle n'est visible a part celle ou vous vous trouvez,\nelles apparaitrons quand vous entrerez a l'interieur. \nBonne chance !");
    }
    
   private void joue()
    {
        this.initJeu();
        while (!isFini())
        {
            System.out.println(" ");
            System.out.println (this.getPlateau().toString());
            System.out.println("Que voulez vous faire ?");
            
            System.out.println("1- Consulter mon materiel");
            System.out.println("2- Lancer une grenade");
            System.out.println("3- Aller dans une salle accessible");
            System.out.println("4- Utiliser un outil");
            System.out.println("5- Abandonner");
            int choix = Lire.i("Rentrer 1,2,3,4,ou 5");
            System.out.println(" ");
            
            switch (choix){
                case 1:
                        System.out.println("Vous avez :\n"+this.getJoueur().toString());
                        break;
                case 2:
                    
                        Direction d1 = new Direction();
                        do
                        {
                            d1=new Direction(Lire.S("Entrez la direction dans laquelle vous souhaitez lancer votre grenade \nen combinant 'h','b','g','d' ou 'haut','bas','gauche','droite'"));

                        }while(!d1.isValide());
                        this.getJoueur().lanceGrenade(d1);
                        
                    break;
                case 3:
                    Direction d2 = new Direction();
                    do
                    {
                         d2=new Direction(Lire.S("Entrez la direction de la salle dans laquelle vous souhaitez aller \n 'h','b','g','d' ou 'haut','bas','gauche','droite'"));

                    }while(!d2.isValide());
                    this.getJoueur().avance(d2);
                    break;
                case 4: 
                    System.out.println("Quel outil souhaitez-vous utiliser ? vous possedez "+this.getJoueur().getOutils().toString());
                    int x=0;
                    do{
                    x = Lire.i("Rentrer le numero de la place ou se situe l'objet dans la liste (entier) ");
                    x=x-1;
                    }
                    while(x<0 || x>=this.getJoueur().getOutils().getTaille());
                    this.getJoueur().getOutils().get(x).utilise(this.getJoueur());
                    break;
                case 5: 
                    this.getJoueur().setPerdant(true);
                    System.out.println("Vous avez perdu...");
                    break;
            }
            
        }
        
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
