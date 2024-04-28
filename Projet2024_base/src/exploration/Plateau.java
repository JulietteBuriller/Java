/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;
import java.util.Random;

/**
 *
 * @author jo
 */
public class Plateau
{
    private static final String BORD = "B";
    public static boolean VISIBLE = false; // mode déboggage : si true, toutes les salles doivent afficher leur contenu
    private Jeu jeu;
    public Jeu getJeu(){return this.jeu;}
    private void setJeu(Jeu jeu){this.jeu = jeu;}

    private boolean visible;
    public boolean isVisible(){return this.visible||Plateau.VISIBLE;}
    public void setVisible(boolean visible){this.visible = visible;}

     private Salle sortie;
    
    private void setSortie (){
        int nb=(int)(1+4*Math.random());
        switch (nb){
            case 1 : 
                this.sortie= new Salle(new Position(1,1,this),this); this.placeSalle(sortie);break;
            case 2 : 
                this.sortie= new Salle(new Position (1,this.getNbCol(),this),this);this.placeSalle(sortie);break;
            case 3 : 
                this.sortie= new Salle(new Position (this.getNbLig(),1,this),this);this.placeSalle(sortie);break;
            case 4 : 
                this.sortie= new Salle(new Position (this.getNbLig(),this.getNbCol(),this),this);this.placeSalle(sortie);break;
                
        //On prend un nombre au hasard entre 1 et 4, et la sortie est choisie en fonction du nombre obtenu (la sortie est forcément un des 4 coins) 
        //J'ai mis setPosition(Position position) en protected pour que ça marche
        }
    }
    public Salle getSortie(){
        return this.sortie;
    }

    private Salle[][] grille;

    private void setGrille(Salle[][] grille) {
        this.grille = grille;
    }
    
    public int getNbLig(){return this.grille.length;}
    public int getNbCol(){return this.grille[0].length;}
    public int getNbSalles(){return this.getNbCol()*this.getNbLig();}
    public Salle getSalle(Position p)
    {
        
        if(p.isValide()){
            return this.grille[p.getLig()-1][p.getCol()-1];
        }else {
            return null;}
    }
    public Salle getSalle(int lig, int col){return this.getSalle(new Position(lig,col,this));}

    /**
     * Place une salle à une position donnée (Les positions en Lig et Col commencent à 1)
     * @param s Une salle
     */
    public void placeSalle(Salle s){
        Position p = s.getPosition();
       
        if(!p.isValide()) throw new RuntimeException("Affectation de la salle à une position non valide");
        this.grille[p.getLig()-1][p.getCol()-1] = s;       
    }

    /**
     * Crée une salle contenant un objet référencé par o (vide si o = null) et l'affecte au plateau
     * @param p la position dans le plateau
     * @param o l'objet que la salle doit contenir
     */
    private void setNouvelleSalle(Position p, Objet o)
    {
        placeSalle(new Salle(p,this,o));       
    }
    private void setNouvelleSalle(Position p){setNouvelleSalle(p, null);}
    
    private Joueur joueur;
    protected Joueur getJoueur(){return this.joueur;}
    private void setJoueur(Joueur joueur){this.joueur = joueur;}
    public Position getPosJoueur(){return this.getJoueur().getPosition();}
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getNbCol() + 2; i++) {
            sb.append(BORD+" "+BORD+"  ");
        }
            sb.append("\n");

            for (Salle[] grille1 : grille) {
                sb.append(BORD+" ");
                for (int j = 0; j < grille1.length; j++) {
                    sb.append(grille1[j]);
                    if (j < grille1.length - 1) {
                        sb.append(" "); // Ajoute un espace entre les éléments sur la même ligne
                    }
                }
                sb.append(" "+BORD);
                sb.append("\n");
                 // Ajoute un retour à la ligne à la fin de chaque ligne
            }
        
            for (int i = 0; i < this.getNbCol() + 2; i++) {
                sb.append(BORD+" "+BORD+"  ");
            }
            sb.append("\n");
        return sb.toString();
    }

    public Plateau(int nbLig, int nbCol, Jeu jeu) 
    {
        
        setJeu(jeu);
        Salle[][] grille1;
        grille1 = new Salle [nbLig][nbCol];
        setGrille(grille1);
        
        int Taille=nbLig*nbCol;
        
        Objet[] objets = new Objet[Taille];
        int nbTotal = jeu.getProportionVides();
        for(int i = 0 ; i<jeu.getListeCategories().length ; i++) // Parcours des catégories
        {
            nbTotal = nbTotal+jeu.getListeCategories()[i].getProportion();
        }
        
        // nbTotal contient désormais la somme des proportions des différents objets à créer
        /* crée autant d'objets qu'il y a de cases dans le tableau d'objets dans les proportions voulues */
      
        int indiceObjet = 0;
        for(int indiceCategorie = 0 ; indiceCategorie<jeu.getListeCategories().length ; indiceCategorie++)
        {
            int nbObjets = ((Taille*jeu.getListeCategories()[indiceCategorie].getProportion())/nbTotal); // calcule le nombre d'objets nbObjets de la catégorie courante à créer
                for(int compteurObjets = 1 ; compteurObjets<= nbObjets ; compteurObjets++,indiceObjet++){ // crée nbObjets instances de la catégorie courante
                    Objet o = jeu.getListeCategories()[indiceCategorie].getNouveau();
                    objets[indiceObjet] = o;
            }
        }
        Random rand = new Random();
        for (int i = Taille - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            
            Objet temp = objets[i];
            objets[i] = objets[index];
            objets[index] = temp;
        }
        int tmp=0;
        for(int i=1;i<=nbLig;i++) {
            for(int j=1;j<=nbCol;j++){
                this.setNouvelleSalle(new Position (i,j,this),objets[tmp]);
                tmp++;
            }
        }
        
        this.setSortie();
        this.setNouvelleSalle(new Position (Taille/2,this));
        this.setJoueur(new Joueur(new Position(((nbLig*nbCol)/2),this)));
        Joueur j = this.getJoueur();
        j.getSalle().setVisible(true);
        
        // Crée un joueur et initialise le plateau selon les spécifications du jeu (Gros boulot)
    }
}
