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
public class Bouquet {
    private int idBoutique;
    private String nomBouquet;

    public int getIdBoutique() {
        return idBoutique;
    }

    public void setIdBoutique(int idBoutique) {
        this.idBoutique = idBoutique;
    }

    public String getNomBouquet() {
        return nomBouquet;
    }

    public void setNomBouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }

    public Bouquet() {
    }

    public Bouquet(int idBoutique, String nomBouquet) {
        this.idBoutique = idBoutique;
        this.nomBouquet = nomBouquet;
    }

    public Bouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }
    
    public ArrayList<Bouquet> selectAll() throws SQLException, Exception{
        ArrayList<Bouquet> valiny = new ArrayList<Bouquet>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from bouquet";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            int id = resultat.getInt(1);
            String nom = resultat.getString(2);
            Bouquet vaovao = new Bouquet(id,nom);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
    public Bouquet selectById(int id) throws SQLException, Exception{
        Bouquet valiny = new Bouquet();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from bouquet where id="+id+"";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            String nom = resultat.getString(2);
            valiny.setIdBoutique(id);
            valiny.setNomBouquet(nom);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    public void insertBoutique(String nom)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into bouquet(nomBouquet) values('"+nom+"')";
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
