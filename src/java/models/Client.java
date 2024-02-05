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
public class Client {
    
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private Date dateNaissance;
    private int genre;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public Client() {
    }

    public Client(String nomClient, String prenomClient, Date dateNaissance, int genre) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
    }

    public Client(int idClient, String nomClient, String prenomClient, Date dateNaissance, int genre) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
    }
    
    public void insertClient(String nomClient,String prenomClient,String dtn,int genre)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into client(idClient,nomClient,prenomClient,dateNaissance,genre) values(default,'"+ nomClient+"','"+ prenomClient+"','"+ dtn+"',"+genre+");";
        try{
            int resultat = state.executeUpdate(requete);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        se_connecter.close();
        state.close();
    }
    
    
    public ArrayList<Client> getAllClient() throws SQLException, Exception{
        ArrayList<Client> valiny = new ArrayList<Client>();
        String requete = "Select idClient,nomClient,prenomClient from client";
        Connection con = connectBase.connect();
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(requete);
        while (rs.next()) {
            Client result = new Client();
            result.setIdClient(rs.getInt("idClient"));
            result.setNomClient(rs.getString("nomClient"));
            result.setPrenomClient(rs.getString("prenomClient"));
            valiny.add(result);
        }
        return valiny;
    }
    
}
