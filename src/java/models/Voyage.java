/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    int nombreBillet;
    String nomBouquet;
    int duree;

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    
    

    public String getNomBouquet() {
        return nomBouquet;
    }

    public void setNomBouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }
    
    

    public int getNombreBillet() {
        return nombreBillet;
    }

    public void setNombreBillet(int nombreBillet) {
        this.nombreBillet = nombreBillet;
    }
    
    

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
    
    public ArrayList<Voyage> getAllVoyage() throws SQLException, Exception{
        ArrayList<Voyage> valiny = new ArrayList<Voyage>();
        String requete = "Select idVoyage,nomVoyage from voyage";
        Connection con = connectBase.connect();
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(requete);
        while (rs.next()) {
            Voyage result = new Voyage();
            result.setIdVoyage(rs.getInt("idVoyage"));
            result.setNom(rs.getString("nomVoyage"));
            valiny.add(result);
        }
        return valiny;
    }
    
    public ArrayList<Voyage> getAllVoyageDispo() throws SQLException, Exception{
        ArrayList<Voyage> valiny = new ArrayList<Voyage>();
        String requete = "select * from v_billetDispo;";
        Connection con = connectBase.connect();
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(requete);
        while (rs.next()) {
            Voyage result = new Voyage();
            result.setIdVoyage(rs.getInt("idVoyage"));
            result.setNom(rs.getString("nomVoyage"));
            result.setNombreBillet(rs.getInt("reste"));
            result.setNomBouquet(rs.getString("nomBouquet"));
            result.setDuree(rs.getInt("duree"));
            valiny.add(result);
        }
        return valiny;
    }
    
    
}
