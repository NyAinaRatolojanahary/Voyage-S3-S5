/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.connectBase;

/**
 *
 * @author Ny Aina Ratolo
 */
public class Voyage {
    
    int idVoyage;
    String nom;
    int idLocalisation;
    int idBouquet;
    int idTypeDuree;

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public void setIdLocalisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public int getIdBouquet() {
        return idBouquet;
    }

    public void setIdBouquet(int idBouquet) {
        this.idBouquet = idBouquet;
    }

    public int getIdTypeDuree() {
        return idTypeDuree;
    }

    public void setIdTypeDuree(int idTypeDuree) {
        this.idTypeDuree = idTypeDuree;
    }

    public Voyage() {
    }

    public Voyage(int idVoyage, String nom, int idLocalisation, int idBouquet, int idTypeDuree) {
        this.idVoyage = idVoyage;
        this.nom = nom;
        this.idLocalisation = idLocalisation;
        this.idBouquet = idBouquet;
        this.idTypeDuree = idTypeDuree;
    }

    public Voyage(String nom, int idLocalisation, int idBouquet, int idTypeDuree) {
        this.nom = nom;
        this.idLocalisation = idLocalisation;
        this.idBouquet = idBouquet;
        this.idTypeDuree = idTypeDuree;
    }

    
    
    public void insertVoyage(String nom,int idLocalisation,int idBouquet,int idTypeDuree)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into voyage(idVoyage,nomVoyage,localisation,bouquet,typeDuree) values(default,'"+ nom+"',"+ idLocalisation+","+ idBouquet+","+ idTypeDuree+");";
        try{
            int resultat = state.executeUpdate(requete);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        se_connecter.close();
        state.close();
    }
    
}
