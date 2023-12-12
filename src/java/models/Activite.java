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
    int idAcivite;
    String nomActivite;

    public int getIdAcivite() {
        return idAcivite;
    }

    public void setIdAcivite(int idAcivite) {
        this.idAcivite = idAcivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public Activite() {
    }

    public Activite(int idAcivite) {
        this.idAcivite = idAcivite;
    }

    public Activite(int idAcivite, String nomActivite) {
        this.idAcivite = idAcivite;
        this.nomActivite = nomActivite;
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
            Activite vaovao = new Activite(id,nom);
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
        String requete = "select * from activite where id="+id+"";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            String nom = resultat.getString(2);
            valiny.setIdAcivite(id);
            valiny.setNomActivite(nom);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    public void insertActivite(String nom)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into activite(nomActivite) values('"+nom+"')";
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
