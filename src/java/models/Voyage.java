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
public class Voyage {
    private int idVoyage;
    private int idLocalisation;
    private int idBouquet;
    private int dureeVoyage;

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
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

    public int getDureeVoyage() {
        return dureeVoyage;
    }

    public void setDureeVoyage(int dureeVoyage) {
        this.dureeVoyage = dureeVoyage;
    }

    public Voyage() {
    }

    public Voyage(int idVoyage, int idLocalisation, int idBouquet, int dureeVoyage) {
        this.idVoyage = idVoyage;
        this.idLocalisation = idLocalisation;
        this.idBouquet = idBouquet;
        this.dureeVoyage = dureeVoyage;
    }

    public Voyage(int idLocalisation, int idBouquet, int dureeVoyage) {
        this.idLocalisation = idLocalisation;
        this.idBouquet = idBouquet;
        this.dureeVoyage = dureeVoyage;
    }
    
    public void insertVoyage(int IdL,int IdB,int IdD)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into voyage values(defauls,"+IdL+","+IdB+","+IdD+")";
        try{
            int resultat = state.executeUpdate(requete);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        se_connecter.close();
        state.close();
    }
    public ArrayList<Voyage> selectAll() throws SQLException, Exception{
        ArrayList<Voyage> valiny = new ArrayList<Voyage>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from voyage";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            int id = resultat.getInt(1);
            int idL = resultat.getInt(2);
            int idB = resultat.getInt(3);
            int idD = resultat.getInt(4);
            
            Voyage vaovao = new Voyage(id,idL,idB,idD);
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
//    public Bouquet selectById(int id) throws SQLException, Exception{
//        Bouquet valiny = new Bouquet();
//        Connection se_connecter = connectBase.connect();
//        Statement state = se_connecter.createStatement();
//        String requete = "select * from bouquet where id="+id+"";
//        ResultSet resultat = state.executeQuery(requete);
//        while (resultat.next()) {            
//            String nom = resultat.getString(2);
//            valiny.setIdBoutique(id);
//            valiny.setNomBouquet(nom);
//        }
//        se_connecter.close();
//        state.close();
//        return valiny;
//    }
    
}
