public class ProjetSécurité extends Projet {

    private  float coûtEquipementsSécurité;

    public ProjetSécurité(int codeProjet, String libelle, String type, float coutMiseEnplace, Responsable chefDeProjet,
            float coûtEquipementsSécurité) {
        super(codeProjet, libelle, type, coutMiseEnplace, chefDeProjet);
        this.coûtEquipementsSécurité = coûtEquipementsSécurité;
    }

    public float getCoûtEquipementsSécurité() {
        return coûtEquipementsSécurité;
    }

    public void setCoûtEquipementsSécurité(float coûtEquipementsSécurité) {
        this.coûtEquipementsSécurité = coûtEquipementsSécurité;
    }

    @Override
    public String toString() {
        return "ProjetSécurité [coûtEquipementsSécurité=" + coûtEquipementsSécurité + "]";
    }

    @Override
    float calculCoutProjet() {
        return coutMiseEnplace +this.coûtEquipementsSécurité;
    }

    
    
}
