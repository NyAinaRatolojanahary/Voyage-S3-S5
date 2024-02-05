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
public class TypeLocalisation {
    int idTypeLocalisation;
    String nomTypeLocalisation;

    public int getIdTypeLocalisation() {
        return idTypeLocalisation;
    }

    public void setIdTypeLocalisation(int idTypeLocalisation) {
        this.idTypeLocalisation = idTypeLocalisation;
    }

    public String getNomTypeLocalisation() {
        return nomTypeLocalisation;
    }

    public void setNomTypeLocalisation(String nomTypeLocalisation) {
        this.nomTypeLocalisation = nomTypeLocalisation;
    }

    public TypeLocalisation() {
    }

    public TypeLocalisation(int idTypeLocalisation) {
        this.idTypeLocalisation = idTypeLocalisation;
    }

    public TypeLocalisation(int idTypeLocalisation, String nomTypeLocalisation) {
        this.idTypeLocalisation = idTypeLocalisation;
        this.nomTypeLocalisation = nomTypeLocalisation;
    }
    
    public ArrayList<TypeLocalisation> selectAll() throws SQLException, Exception{
        ArrayList<TypeLocalisation> valiny = new ArrayList<TypeLocalisation>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from typeLocalisation";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            int id = resultat.getInt(1);
            String nom = resultat.getString(2);
            TypeLocalisation vaovao = new TypeLocalisation(id,nom);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
    public TypeLocalisation selectById(int id) throws SQLException, Exception{
        TypeLocalisation valiny = new TypeLocalisation();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from typeLocalisation where id="+id+"";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            String nom = resultat.getString(2);
            valiny.setIdTypeLocalisation(id);
            valiny.setNomTypeLocalisation(nom);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    public void insertTypeLocalisation(String nom)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into typeLocalisation(nomTypeLocalisation) values('"+nom+"')";
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
