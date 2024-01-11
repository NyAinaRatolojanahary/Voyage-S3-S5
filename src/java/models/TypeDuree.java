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
public class TypeDuree {
    
    int idTypeDuree;
    String nomTypeDuree;
    int duree;

    public int getIdTypeDuree() {
        return idTypeDuree;
    }

    public void setIdTypeDuree(int idTypeDuree) {
        this.idTypeDuree = idTypeDuree;
    }

    public String getNomTypeDuree() {
        return nomTypeDuree;
    }

    public void setNomTypeDuree(String nomTypeDuree) {
        this.nomTypeDuree = nomTypeDuree;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public TypeDuree() {
    }

    public TypeDuree(int idTypeDuree, String nomTypeDuree, int duree) {
        this.idTypeDuree = idTypeDuree;
        this.nomTypeDuree = nomTypeDuree;
        this.duree = duree;
    }

    public TypeDuree(String nomTypeDuree, int duree) {
        this.nomTypeDuree = nomTypeDuree;
        this.duree = duree;
    }
    
    public ArrayList<TypeDuree> selectAll() throws SQLException, Exception{
        ArrayList<TypeDuree> valiny = new ArrayList<TypeDuree>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from typeDuree;";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            int id = resultat.getInt(1);
            String nom = resultat.getString(2);
            int duree = resultat.getInt(3);
            TypeDuree vaovao = new TypeDuree(id,nom,duree);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
    public TypeDuree selectTypeDureeById(int id) throws SQLException, Exception{
        TypeDuree valiny = new TypeDuree();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from typeDuree where idTypeDuree="+id+";";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {  
            int idtd = resultat.getInt(1);
            String nom = resultat.getString(2);
            int dr = resultat.getInt(3);
            valiny.setIdTypeDuree(idtd);
            valiny.setNomTypeDuree(nom);
            valiny.setDuree(dr);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
}
