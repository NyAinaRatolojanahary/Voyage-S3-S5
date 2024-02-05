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
public class Affectation {
    
    int idAffectaion;
    int idVoyage;
    int idEmployee;

    public int getIdAffectaion() {
        return idAffectaion;
    }

    public void setIdAffectaion(int idAffectaion) {
        this.idAffectaion = idAffectaion;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Affectation() {
    }

    public Affectation(int idAffectaion, int idVoyage, int idEmployee) {
        this.idAffectaion = idAffectaion;
        this.idVoyage = idVoyage;
        this.idEmployee = idEmployee;
    }

    public Affectation(int idVoyage, int idEmployee) {
        this.idVoyage = idVoyage;
        this.idEmployee = idEmployee;
    }
    
    public void insertAffectation(int idVoyage,int idEmp)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into affectation(idAffectation,idVoyage,idEmploye) values(default,'"+ idVoyage+"',"+ idEmp+")";
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
