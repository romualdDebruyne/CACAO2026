package abstraction.eq5Transformateur2;

import java.awt.Color;
import java.util.List;

import abstraction.eqXRomu.encheres.Enchere;
import abstraction.eqXRomu.encheres.IVendeurAuxEncheres;
import abstraction.eqXRomu.encheres.SuperviseurVentesAuxEncheres;
import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.filiere.IActeur;
import abstraction.eqXRomu.general.Journal;
import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.produits.IProduit; 
/**
 * @author Maxence
 */
public class Transformateur2VendeurAuxEncheres extends Transformateur2AcheteurBourse implements IVendeurAuxEncheres{
    private SuperviseurVentesAuxEncheres superviseur =(SuperviseurVentesAuxEncheres)(Filiere.LA_FILIERE.getActeur("Sup.Encheres"));

    public Transformateur2VendeurAuxEncheres() {
        super();
    }


    public void VendreEncheres(){
    }

    public Enchere choisir(List<Enchere> propositions) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'choisir'");
    }
    
}