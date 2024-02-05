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
public class Statistique {
    
    private double nombreMale;
    private double nombreFemale;
    
    private String nomBouquet;


    public double getNombreMale() {
        return nombreMale;
    }

    public void setNombreMale(double nombreMale) {
        this.nombreMale = nombreMale;
    }

    public double getNombreFemale() {
        return nombreFemale;
    }

    public void setNombreFemale(double nombreFemale) {
        this.nombreFemale = nombreFemale;
    }

    

    public String getNomBouquet() {
        return nomBouquet;
    }

    public void setNomBouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }

    public Statistique() {
    }

    public Statistique(double nombreMale, double nombreFemale) {
        this.nombreMale = nombreMale;
        this.nombreFemale = nombreFemale;
    }

    public Statistique(double nombreMale, double nombreFemale, String nomBouquet) {
        this.nombreMale = nombreMale;
        this.nombreFemale = nombreFemale;
        this.nomBouquet = nomBouquet;
    }

         
    
    public String getNombreVenteParGenre() throws Exception {
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from v_venteParGenre;";
        ResultSet resultat = state.executeQuery(requete);

        int nombreFemale = 0;
        int nombreMale = 0;

        if (resultat.next()) {
            nombreFemale = resultat.getInt("totalFemale");
            nombreMale = resultat.getInt("totalMale");
        }

        se_connecter.close();
        state.close();

        // Création d'une chaîne JSON
        String json = "{ \"nombreFemale\": " + nombreFemale + ", \"nombreMale\": " + nombreMale + " }";

        return json;
    }

    
    public ArrayList<Statistique> getNombreVenteParGenreEtBouquet()throws Exception{
        ArrayList<Statistique> valiny = new ArrayList<Statistique>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from v_venteParGenreEtBouquet;";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
           Statistique stat = new Statistique();
           stat.setNombreFemale(resultat.getInt("totalFemale"));
          stat.setNombreMale(resultat.getInt("totalMale"));
           stat.setNomBouquet(resultat.getString("nomBouquet"));
           valiny.add(stat);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
}
