package abstraction.eq3Producteur3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import abstraction.eqXRomu.filiere.Filiere;
import abstraction.eqXRomu.filiere.IActeur;
import abstraction.eqXRomu.general.Journal;
import abstraction.eqXRomu.general.Variable;
import abstraction.eqXRomu.general.VariableReadOnly;
import abstraction.eqXRomu.produits.Feve;
import abstraction.eqXRomu.produits.IProduit;

public class Producteur3Acteur implements IActeur {
	protected Journal journal_periode;
	protected Journal journal_stock_periode;
	protected Journal journal_des_ventes_en_bourses;
	protected int periode_act ;
	protected int cryptogramme;
	protected HashMap<Feve,Variable> stock;
	

	public Producteur3Acteur() {
		this.journal_periode = new Journal("Journal des périodes"+this.getNom(), this);
		this.journal_stock_periode= new Journal ("Journal du stock restant par période"+this.getNom(),this);
		this.periode_act=0;
		this.journal_des_ventes_en_bourses=new Journal ("Journal des ventes en bourse"+this.getNom(),this);
		this.stock = new HashMap<Feve, Variable>();
		for (Feve f : Feve.values()) {
    		this.stock.put(f, new VariableReadOnly(this + " Stock " + f, this, 0.0));
		}
		
	}
	
	public void initialiser() {
	}

	public String getNom() {// NE PAS MODIFIER
		return "EQ3";
	}
	
	public String toString() {// NE PAS MODIFIER
		return this.getNom();
	}

	////////////////////////////////////////////////////////
	//         En lien avec l'interface graphique         //
	////////////////////////////////////////////////////////

	public void next() {
		// défi 1 
		this.journal_periode.ajouter("période : "+ this.periode_act);
		//défi 3 
		double quantite= 120.0;
		Feve feve = Feve.F_MQ;
		if(this.stock.get(feve).getValeur()>=quantite){
			this.stock.get(feve).retirer(this, quantite, cryptogramme);
			this.journal_des_ventes_en_bourses.ajouter("vente en bourse de "+ quantite+" tonnes de "+ feve.getGamme());
		}
		//défi 2
		double totalStock=0.0;
		for (Feve f : Feve.values()) {
			totalStock+=this.stock.get(f).getValeur();
		}
		this.journal_stock_periode.ajouter("stock de la période "+this.periode_act +"="+ totalStock );
		this.periode_act++;
	}

	public Color getColor() {// NE PAS MODIFIER
		return new Color(249, 230, 151); 
	}

	public String getDescription() {
		return "Bla bla bla";
	}

	// Renvoie les indicateurs
	public List<Variable> getIndicateurs() {
		List<Variable> res = new ArrayList<Variable>();
		return res;
	}

	// Renvoie les parametres
	public List<Variable> getParametres() {
		List<Variable> res=new ArrayList<Variable>();
		return res;
	}

	// Renvoie les journaux
	public List<Journal> getJournaux() {
		List<Journal> res=new ArrayList<Journal>();
		return res;
	}

	////////////////////////////////////////////////////////
	//               En lien avec la Banque               //
	////////////////////////////////////////////////////////

	// Appelee en debut de simulation pour vous communiquer 
	// votre cryptogramme personnel, indispensable pour les
	// transactions.
	public void setCryptogramme(Integer crypto) {
		this.cryptogramme = crypto;
	}

	// Appelee lorsqu'un acteur fait faillite (potentiellement vous)
	// afin de vous en informer.
	public void notificationFaillite(IActeur acteur) {
	}

	// Apres chaque operation sur votre compte bancaire, cette
	// operation est appelee pour vous en informer
	public void notificationOperationBancaire(double montant) {
	}
	
	// Renvoie le solde actuel de l'acteur
	protected double getSolde() {
		return Filiere.LA_FILIERE.getBanque().getSolde(Filiere.LA_FILIERE.getActeur(getNom()), this.cryptogramme);
	}

	////////////////////////////////////////////////////////
	//        Pour la creation de filieres de test        //
	////////////////////////////////////////////////////////

	// Renvoie la liste des filieres proposees par l'acteur
	public List<String> getNomsFilieresProposees() {
		ArrayList<String> filieres = new ArrayList<String>();
		return(filieres);
	}

	// Renvoie une instance d'une filiere d'apres son nom
	public Filiere getFiliere(String nom) {
		return Filiere.LA_FILIERE;
	}

	public double getQuantiteEnStock(IProduit p, int cryptogramme) {
		if (this.cryptogramme==cryptogramme) { // c'est donc bien un acteur assermente qui demande a consulter la quantite en stock
			return 0; // A modifier
		} else {
			return 0; // Les acteurs non assermentes n'ont pas a connaitre notre stock
		}
	}
}
