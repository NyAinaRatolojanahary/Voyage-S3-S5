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
public class VoyageActivite {
    
    String nomvoyage;     
    String nombouquet;  
    String nomtypeduree;  
    String nomactivite; 
    int nombreactivite;

    public String getNomvoyage() {
        return nomvoyage;
    }

    public void setNomvoyage(String nomvoyage) {
        this.nomvoyage = nomvoyage;
    }

    public String getNombouquet() {
        return nombouquet;
    }

    public void setNombouquet(String nombouquet) {
        this.nombouquet = nombouquet;
    }

    public String getNomtypeduree() {
        return nomtypeduree;
    }

    public void setNomtypeduree(String nomtypeduree) {
        this.nomtypeduree = nomtypeduree;
    }

    public String getNomactivite() {
        return nomactivite;
    }

    public void setNomactivite(String nomactivite) {
        this.nomactivite = nomactivite;
    }

    public int getNombreactivite() {
        return nombreactivite;
    }

    public void setNombreactivite(int nombreactivite) {
        this.nombreactivite = nombreactivite;
    }

    public VoyageActivite() {
    }

    public VoyageActivite(String nomvoyage, String nombouquet, String nomtypeduree, String nomactivite, int nombreactivite) {
        this.nomvoyage = nomvoyage;
        this.nombouquet = nombouquet;
        this.nomtypeduree = nomtypeduree;
        this.nomactivite = nomactivite;
        this.nombreactivite = nombreactivite;
    }
    
    
    public ArrayList<VoyageActivite> listeVoyageParIdActivite(int id) throws Exception{
        ArrayList<VoyageActivite> valiny = new ArrayList<VoyageActivite>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from v_listeVoyageParActivite where idActivite="+ id+";";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            String nomvoyage = resultat.getString(1);
            String nomBouquet = resultat.getString(2);
            String nomTypeDuree = resultat.getString(3);
            String nomActivite = resultat.getString(5);
            int nombreActivite = resultat.getInt(6);
            VoyageActivite vaovao = new VoyageActivite(nomvoyage,nomBouquet,nomTypeDuree,nomActivite,nombreActivite);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
}
