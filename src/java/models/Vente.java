/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.connectBase;

/**
 *
 * @author Ny Aina Ratolo
 */
public class Vente {
    
    private int idVente;
    private int idBouquet;
    private int idTypeDuree;
    private Date dateVente;
    private int nombre;
    private int idClient;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
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

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Vente() {
    }

    public Vente(int idBouquet, int idTypeDuree, Date dateVente, int nombre) {
        this.idBouquet = idBouquet;
        this.idTypeDuree = idTypeDuree;
        this.dateVente = dateVente;
        this.nombre = nombre;
    }

    public Vente(int idVente, int idBouquet, int idTypeDuree, Date dateVente, int nombre) {
        this.idVente = idVente;
        this.idBouquet = idBouquet;
        this.idTypeDuree = idTypeDuree;
        this.dateVente = dateVente;
        this.nombre = nombre;
    }
    
    public void insertVente(int idClient,int idVoyage,String dtn,int nombre)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into vente(idVente,idClient,idVoyage,dateVente,nombre) values(default,"+ idClient+","+idVoyage+",'"+dtn+"',"+nombre+");";
        try{
            state.executeUpdate(requete);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        se_connecter.close();
        state.close();
    }
    
    public boolean isBilletEnougth(int idVoyage,int nombre) throws Exception{
    
        boolean enought = false;
        Connection se_connecter = connectBase.connect();
       
            int nombreRestante = 0;
            Statement state = se_connecter.createStatement();
            String requete = "select v.idVoyage,v.nombreBillet-SUM(vt.nombre) as reste from voyage v join vente vt on vt.idVoyage = v.idVoyage where v.idVoyage ="+ idVoyage +" group by v.idVoyage;";
            ResultSet rs = state.executeQuery(requete);
            while (rs.next()) {
                nombreRestante = rs.getInt("reste");
            }
            if(nombre > nombreRestante){
                throw new Exception("Le nombre de billet restant pour cette voyage est insuffisant");
            }
            else{ enought = true;}
            
        
        return enought;
    }
    
}
