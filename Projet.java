abstract class Projet implements IComparable{ 
    protected int codeProjet; 
    private String libelle ; 
    protected String type; 
    protected float coutMiseEnplace; 
    private Responsable chefDeProjet;

    public Projet(int codeProjet, String libelle, String type, float coutMiseEnplace, Responsable chefDeProjet) {
        this.codeProjet = codeProjet;
        this.libelle = libelle;
        this.type = type;
        this.coutMiseEnplace = coutMiseEnplace;
        this.chefDeProjet = chefDeProjet;
    }

    public float getCoutMiseEnplace() {
        return coutMiseEnplace;
    }

    public Responsable getChefDeProjet() {
        return chefDeProjet;
    }

    public void setCoutMiseEnplace(float coutMiseEnplace) {
        this.coutMiseEnplace = coutMiseEnplace;
    }

    abstract float calculCoutProjet() ;


    public  int comparer(Object o){ 
        Projet p; 
        if (o instanceof Projet)
        { p=(Projet)o;
        } 
        else { 
            return IComparable.ERR;
         } 
        if (this.calculCoutProjet()<(p.calculCoutProjet())) 

        return IComparable.INF; 

        if (this.calculCoutProjet()>(p.calculCoutProjet())) 

        return IComparable.SUP; 
        return IComparable.EGAL;
     }


    @Override
    public String toString() {
        return "Projet [codeProjet=" + codeProjet + ", libelle=" + libelle + ", type=" + type + ", coutMiseEnplace="
                + coutMiseEnplace + "]";
    }

    

    

    



}