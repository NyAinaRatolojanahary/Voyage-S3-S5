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
public class AchatBillet {
    
    int idAchat;
    int idActivite;
    String nomActivite;
    int nombre;

    public int getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(int idAchat) {
        this.idAchat = idAchat;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) throws Exception {
        if(nombre>0){
            this.nombre = nombre;
        }
        else{
            throw new Exception("Le nombre doit etre positif");
        }
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }
    
    

    public AchatBillet() {}
    

    public AchatBillet(int idActivite, int nombre) {
        this.idActivite = idActivite;
        this.nombre = nombre;
    }
    
    public void insertEntreeBillet(int idActivite, int nombre) throws Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into mouvementBillet(idMouvementBillet,idActivite,nombreBillet) values(default,"+idActivite+","+nombre+");";
        try{
            int resultat = state.executeUpdate(requete);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        se_connecter.close();
        state.close();
    }
    
    public boolean isBilletEnougth(ArrayList<ActiviteBouquet> ab,int nombre) throws Exception{
    
        boolean enought = false;
        Connection se_connecter = connectBase.connect();
        for (int i = 0; i < ab.size(); i++) {
            int nombreRestante = 0;
            Statement state = se_connecter.createStatement();
            String requete = "select idActivite,SUM(nombreBillet) as reste from mouvementBillet where idActivite =" + ab.get(i).getIdActivite()+" group by idActivite";
            ResultSet rs = state.executeQuery(requete);
            while (rs.next()) {
                nombreRestante = rs.getInt("reste");
            }
            if(nombre*ab.get(i).getNombre() > nombreRestante){
                throw new Exception("Le nombre de billet restant pour l'activite "+ ab.get(i).getNomBouquet() +" dans le bouquet: "+ ab.get(i).getNomActivite()+" est insuffisant");
            }
            else{ 
                i++;
                if(i== ab.size()){
                    enought = true;
                }
            }
        }
        return enought;
    }
    
    public ArrayList<AchatBillet> getBilletActiviteDispo() throws SQLException, Exception{
        ArrayList<AchatBillet> valiny = new ArrayList<AchatBillet>();
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "select * from v_billetActiviteDispo";
        ResultSet resultat = state.executeQuery(requete);
        while (resultat.next()) {            
            AchatBillet vaovao = new AchatBillet();
            vaovao.setNomActivite(resultat.getString("nomActivite"));
            vaovao.setNombre(resultat.getInt("billetsDisponibles"));
            valiny.add(vaovao);
        }
        se_connecter.close();
        state.close();
        return valiny;
    }
    
}
