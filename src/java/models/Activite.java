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
 * @author LA BOSS
 */
public class Activite {
    int idActivite;
    String nomActivite;
    double prix;

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws Exception {
        if(prix>0){
            this.prix = prix;
        }
        else{ throw new Exception("Le prix doit etre positif");}
    }
    
    

    public Activite() {
    }

    public Activite(int idActivite) {
        this.idActivite = idActivite;
    }

    public Activite(int idActivite, String nomActivite,double prix) {
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.prix = prix;
    }
    
    public ArrayList<Activite> selectAll() throws SQLException, Exception{
        ArrayList<Activite> valiny = new ArrayList<Activite>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from activite";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            int id = resultat.getInt(1);
            String nom = resultat.getString(2);
            double prix = resultat.getDouble(3);
            Activite vaovao = new Activite(id,nom,prix);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
    public Activite selectById(int id) throws SQLException, Exception{
        Activite valiny = new Activite();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from activite where idActivite="+id+"";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {    
            int ids = resultat.getInt(1);
            String nom = resultat.getString(2);
            double prix = resultat.getDouble("3");
            valiny.setIdActivite(ids);
            valiny.setNomActivite(nom);
            valiny.setPrix(prix);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    public void insertActivite(String nom,double prix)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into activite(nomActivite,prix) values('"+nom+"',"+ prix+")";
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
