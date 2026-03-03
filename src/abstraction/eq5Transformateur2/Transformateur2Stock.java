package abstraction.eq5Transformateur2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.lang.Integer;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.filiere.IActeur;
import abstraction.eqXRomu.general.Journal;
import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.produits.Chocolat;
import abstraction.eqXRomu.produits.Feve;
import abstraction.eqXRomu.produits.IProduit;

public class Transformateur2Stock extends Transformateur2Acteur{

    // Attributs
    private ArrayList<Integer> stock_feve;
    private ArrayList<Integer> stock_chocolat;
    
    // Constructeur
    public Transformateur2Stock(){
        this.stock_chocolat = new HashMap <Chocolat, double>
    }

    // Méthodes

    public void add_feve(int n, Feve Q){
        if (Q == Feve.F_BQ){
            this.stock_feve.add(0, n);
        }
            
    }

    public void add_chocolat(double n, Chocolat Q){
        double qt = stock_Chocolat.C_BQ

        if (Q == Chocolat.C_BQ){
            this.stock_chocolat.add(0, n);
        }else if (Q == Chocolat.C_BQ_E){
            this.stock_chocolat.add(1, n);
        } else if (Q == Chocolat.C_MQ){
            this.stock_chocolat.add(2, n);
        } else if (Q == Chocolat.C_MQ_E){
            this.stock_chocolat.add(3, n);
        } else if (Q == Chocolat.C_HQ){
            this.stock_chocolat.add(4, n);
        } else { 
            this.stock_chocolat.add(5, n); 
            }
    }

}
