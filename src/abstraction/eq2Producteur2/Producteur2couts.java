package abstraction.eq2Producteur2;

import java.util.HashMap;
import java.util.List;

import abstraction.eqXRomu.general.Journal;
import abstraction.eqXRomu.produits.Feve;

/** @author Thomas */

public class Producteur2Couts extends Producteur2stock {
    protected HashMap<Feve, Double> cout_unit_t;
    private Journal JournalCout;

    public Producteur2Couts() {
        super();
        this.cout_unit_t = new HashMap<Feve, Double>();
        this.JournalCout = new Journal("Journal Cout Eq2",this);

        for (Feve f : Feve.values()) {
            this.cout_unit_t.put(f, 0.0);
        }
    }

    public void initialiser() {
        super.initialiser();
    }

    public void next() {
        super.next();
        calcul_cout_unit();
    }

    /** Calcul des couts unitaires de production de chaque tonne de feve */
    public void calcul_cout_unit() {

        for (Feve f : Feve.values()) {
            double prod = prodParStep.get(f);
            if (prod > 0) {
                double cout = cout_recolte.get(f) + cout_stockage * stock.get(f).getOrDefault(Filiere.LA_FILIERE.getEtape(), 0.0);
                cout_unit_t.put(f, cout / prod);
                JournalCout.ajouter("Step " + Filiere.LA_FILIERE.getEtape() + " : Coût unitaire de production pour " + f + " = " + cout_unit_t.get(f) + " €/t");
            } else {
                cout_unit_t.put(f, 0.0);
                JournalCout.ajouter("Step " + Filiere.LA_FILIERE.getEtape() + " : Pas de production pour " + f + ", coût unitaire = 0 €/t");
            }
        }
    }

    public List<Journal> getJournaux() {
        List<Journal> res = super.getJournaux();
        res.add(JournalCout);
        return res;
    }
}