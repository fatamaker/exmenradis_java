public class BoîteDeDeveloppement {
    public Projet[] lesProjets ;
    private String nomBoîte; 
    private String adrBoîte;
    private int nb_projet ;


    public BoîteDeDeveloppement(String nomBoîte, String adrBoîte,int taille) {
        this.lesProjets = new Projet[taille];
        this.nomBoîte = nomBoîte;
        this.adrBoîte = adrBoîte;
        this.nb_projet=0;
    } 

    public void  ajouterProjet(Projet p){
        if (nb_projet < lesProjets.length) {
            lesProjets[nb_projet] = p;
            nb_projet++;
        }
        System.out.println("pas de posibilté de faire se projet");
    }
    public Projet[] projetSupCoûtProjet(float cout){
        Projet[] sup= new Projet[nb_projet];
        int nb_projet_new=0;
        for(int i=0 ;i<nb_projet;i++){
            if(lesProjets[i].getCoutMiseEnplace()>cout){
                sup[nb_projet_new]=lesProjets[i];
                nb_projet_new++;
            }
        }
        return sup ;

    }

    public String TypeProjetResp(int code){
        String res=""; 
        for(int i=0;i<nb_projet;i++) 
        { 
        if (lesProjets[i].getChefDeProjet().getCode()==code) 
        res+=lesProjets[i].type;
     } 
        return res; }
    

    public boolean modifierCoûtMiseEnPlace(int c,float nc) throws PasDeModifException{ 
        boolean res= false; 
        try{ 
             for(Projet p:this.lesProjets)
             { 
               if (p.codeProjet==c) {  p.setCoutMiseEnplace(nc);  res= true;  }           
               if(res==false){  throw new PasDeModifException("Impossible de modifier"); }
            }  
        }
        catch(PasDeModifException e) 
        {
             System.out.println(e.getMessage());
        
        } 
        return res; 
    }

    public class Main {
        public static void main(String[] args) {
           
            Responsable responsable1 = new Responsable( "John Doe",101);
            Responsable responsable2 = new Responsable( "Jane Smith",102);
    
           
            Projet projet1 = new Projet(1, "Projet Alpha", "Software", 5000.0f, responsable1);
            Projet projet2 = new Projet(2, "Projet Beta", "Hardware", 12000.0f, responsable2);
            Projet projet3 = new Projet(3, "Projet Gamma", "Software", 8000.0f, responsable1);
    

            BoîteDeDeveloppement boite = new BoîteDeDeveloppement("TechBox", "123 Tech St.", 5);
    
       
            boite.ajouterProjet(projet1);
            boite.ajouterProjet(projet2);
            boite.ajouterProjet(projet3);
    
     
            float costThreshold = 6000.0f;
            Projet[] expensiveProjects = boite.projetSupCoûtProjet(costThreshold);
            System.out.println("Projects with cost higher than " + costThreshold + ":");
            for (Projet p : expensiveProjects) {
                System.out.println(p);
            }
    
            
            try {
                boolean modified = boite.modifierCoûtMiseEnPlace(2, 15000.0f); // Try modifying Projet 2's cost
                if (modified) {
                    System.out.println("Project cost updated successfully.");
                }
            } catch (PasDeModifException e) {
                System.out.println("Error: " + e.getMessage());
            }
    
       
            String projectsByResp1 = boite.TypeProjetResp(101);
            System.out.println("Projects managed by Responsable 101 (John Doe): " + projectsByResp1);
        }
    }
    




    

    
}
