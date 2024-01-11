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
public class Localisation {
    int idLocalisation;
    String nomLocalisation;
    int idTypeLocalisation;

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public void setIdLocalisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public String getNomLocalisation() {
        return nomLocalisation;
    }

    public void setNomLocalisation(String nomTypeLocalisation) {
        this.nomLocalisation = nomTypeLocalisation;
    }

    public int getIdTypeLocalisation() {
        return idTypeLocalisation;
    }

    public void setIdTypeLocalisation(int idTypeLocalisation) {
        this.idTypeLocalisation = idTypeLocalisation;
    }
    
    

    public Localisation() {
    }

    public Localisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public Localisation(int idLocalisation, String nomLocalisation, int idTypeLocalisation) {
        this.idLocalisation = idLocalisation;
        this.nomLocalisation = nomLocalisation;
        this.idTypeLocalisation = idTypeLocalisation;
    }

    public Localisation(String nomLocalisation, int idTypeLocalisation) {
        this.nomLocalisation = nomLocalisation;
        this.idTypeLocalisation = idTypeLocalisation;
    }

    public Localisation(int idLocalisation, String nomLocalisation) {
        this.idLocalisation = idLocalisation;
        this.nomLocalisation = nomLocalisation;
    }

    
    
    public ArrayList<Localisation> selectAll() throws SQLException, Exception{
        ArrayList<Localisation> valiny = new ArrayList<Localisation>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from localisation;";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            int id = resultat.getInt(1);
            String nom = resultat.getString(2);
            Localisation vaovao = new Localisation(id,nom);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
    public Localisation selectLocalisationById(int id) throws SQLException, Exception{
        Localisation valiny = new Localisation();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from localisation where idLocalisation="+id+";";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            String nom = resultat.getString(2);
            valiny.setIdLocalisation(id);
            valiny.setNomLocalisation(nom);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    public void insertLocalisation(String nom,int idTypeLocalisation)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into localisation(idLocalisation,nomLocalisation,idTypeLocalisation) values(default,'"+nom+"',"+ idTypeLocalisation+");";
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
