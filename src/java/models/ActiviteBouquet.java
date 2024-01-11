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
public class ActiviteBouquet {
    
    private int idActiviteBouquet;
    private int idActivite;
    private String nomActivite;
    private int idBouquet;
    private String nomBouquet;
    private int nombre;


    public int getIdActiviteBouquet() {
        return idActiviteBouquet;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public int getIdBouquet() {
        return idBouquet;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public String getNomBouquet() {
        return nomBouquet;
    }

    public void setIdActiviteBouquet(int idActiviteBouquet) {
        this.idActiviteBouquet = idActiviteBouquet;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public void setIdBouquet(int idBouquet) {
        this.idBouquet = idBouquet;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public void setNomBouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) throws Exception {
        if(nombre>0){
        this.nombre = nombre;
        }
        else{ throw new Exception("Le nombre doit etre positif");}
    }

    public ActiviteBouquet(){}

    public ActiviteBouquet(int idActiviteBouquet,int idActivite,String nomActivite,int idBouquet,String nomBouquet,int nombre){
        this.idActiviteBouquet = idActiviteBouquet;
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.idBouquet = idBouquet;
        this.nomBouquet = nomActivite;
        this.nombre = nombre;
    }

    public ActiviteBouquet(int idActivite,String nomActivite,int idBouquet,String nomBouquet,int duree){
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.idBouquet = idBouquet;
        this.nomBouquet = nomActivite;
        this.nombre = duree;
    }

    public ActiviteBouquet(int idActivite, int idBouquet, int nombre) {
        this.idActivite = idActivite;
        this.idBouquet = idBouquet;
        this.nombre = nombre;
    }
    
    

    public ArrayList<ActiviteBouquet> getActiviteByIdBouquet(int idBouquet) throws SQLException, Exception{
        ArrayList<ActiviteBouquet> valiny = new ArrayList<ActiviteBouquet>();
        String requete = "Select bouquet.nomBouquet,activite.nomActivite,activiteBouquet.nombreActivite from activiteBouquet join bouquet on bouquet.idBouquet=activiteBouquet.idBouquet join activite on activite.idActivite=activiteBouquet.idActivite where bouquet.idbouquet = "+idBouquet+";";
        Connection con = connectBase.connect();
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(requete);
        while (rs.next()) {
            ActiviteBouquet result = new ActiviteBouquet();
            result.setNomActivite(rs.getString("nomBouquet"));
            result.setNomBouquet(rs.getString("nomActivite"));
            result.setNombre(rs.getInt("nombreActivite"));
            valiny.add(result);
        }
        return valiny;
    }
    
    public void insertActiviteBouquet(int idActivite,int idBouquet,int nombre)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into activiteBouquet(idActiviteBouquet,idActivite,idBouquet,nombreActivite) values(default,"+ idActivite+","+ idBouquet+","+ nombre+")";
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
