/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.connectBase;

/**
 *
 * @author Ny Aina Ratolo
 */
public class FiltreVoyageParPrix {
    
    double prixMin;
    double prixMax;
    String nomVoyage;
    String nomBouquet;
    double prix;

    public double getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(double prixMin) {
        this.prixMin = prixMin;
    }

    public double getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(double prixMax) {
        this.prixMax = prixMax;
    }

    public String getNomVoyage() {
        return nomVoyage;
    }

    public void setNomVoyage(String nomVoyage) {
        this.nomVoyage = nomVoyage;
    }

    public String getNomBouquet() {
        return nomBouquet;
    }

    public void setNomBouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public FiltreVoyageParPrix() {
    }

    public FiltreVoyageParPrix(double prixMin, double prixMax, String nomVoyage, String nomBouquet, double prix) {
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.nomVoyage = nomVoyage;
        this.nomBouquet = nomBouquet;
        this.prix = prix;
    }

    
    
    public ArrayList<FiltreVoyageParPrix> listeFiltre(double min,double max) throws Exception{
        ArrayList<FiltreVoyageParPrix> valiny = new ArrayList<FiltreVoyageParPrix>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from v_prixVoyageFiltre WHERE prix BETWEEN "+min+" AND "+max+";";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            String voyage = resultat.getString("nomVoyage");
            String bouquet = resultat.getString("nomBouquet");
            double prix = resultat.getDouble("prix");
            FiltreVoyageParPrix vaovao = new FiltreVoyageParPrix(min,max,voyage,bouquet,prix);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
    public ArrayList<FiltreVoyageParPrix> getBenefice(double min,double max) throws Exception{
        ArrayList<FiltreVoyageParPrix> valiny = new ArrayList<FiltreVoyageParPrix>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from v_filtreVoyageBenefice WHERE difference BETWEEN "+min+" AND "+max+";";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            String voyage = resultat.getString(2);
            String bouquet = resultat.getString(3);
            double prix = resultat.getDouble(4);
            FiltreVoyageParPrix vaovao = new FiltreVoyageParPrix(min,max,voyage,bouquet,prix);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
}
