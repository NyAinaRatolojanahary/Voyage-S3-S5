package models;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.connectBase;


public class ActiviteBouquet{

    private int idActiviteBouquet;
    private int idActivite;
    private String nomActivite;
    private int idBouquet;
    private String nomBouquet;
    private double dureeActivite;


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

    public double getDureeActivite() {
        return dureeActivite;
    }

    public void setDureeActivite(double dureeActivite) {
        this.dureeActivite = dureeActivite;
    }

    public ActiviteBouquet(){}

    public ActiviteBouquet(int idActiviteBouquet,int idActivite,String nomActivite,int idBouquet,String nomBouquet,double duree){
        this.idActiviteBouquet = idActiviteBouquet;
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.idBouquet = idBouquet;
        this.nomBouquet = nomActivite;
        this.dureeActivite = duree;
    }

    public ActiviteBouquet(int idActivite,String nomActivite,int idBouquet,String nomBouquet,double duree){
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.idBouquet = idBouquet;
        this.nomBouquet = nomActivite;
        this.dureeActivite = duree;
    }

    public ArrayList<ActiviteBouquet> getActiviteByIdBouquet(int idBouquet) throws SQLException, Exception{
        ArrayList<ActiviteBouquet> valiny = new ArrayList<ActiviteBouquet>();
        String requete = "Select bouquet.nomBouquet,activite.nomActivite,activiteBouquet.dureeActivite from activiteBouquet join bouquet on bouquet.idBouquet=activiteBouquet.idBouquet join activite on activite.idActivite=activiteBouquet.idActivite where bouquet.idbouquet = "+idBouquet+";";
        Connection con = connectBase.connect();
        Statement state = (Statement) con.createStatement();
        ResultSet rs = state.executeQuery(requete);

        while (rs.next()) {
            ActiviteBouquet result = new ActiviteBouquet();
            result.setNomActivite(rs.getString("nomBouquet"));
            result.setNomBouquet(rs.getString("nomActivite"));
            result.setDureeActivite(rs.getDouble("dureeActivite"));
            valiny.add(result);
        }
        return valiny;
    }
    
    public ArrayList<ActiviteBouquet> getAllBouquetByIdActivite(int IdActivite) throws SQLException, Exception{
        ArrayList<ActiviteBouquet> valiny = new ArrayList<ActiviteBouquet>();
        String requete = "Select bouquet.nomBouquet,activite.nomActivite,activiteBouquet.dureeActivite from activiteBouquet join bouquet on bouquet.idBouquet=activiteBouquet.idBouquet join activite on activite.idActivite=activiteBouquet.idActivite where activite.idactivite = "+IdActivite+";";
        Connection con = connectBase.connect();
        Statement state = (Statement) con.createStatement();
        ResultSet rs = state.executeQuery(requete);

        while (rs.next()) {
            ActiviteBouquet result = new ActiviteBouquet();
            result.setNomActivite(rs.getString("nomBouquet"));
            result.setNomBouquet(rs.getString("nomActivite"));
            result.setDureeActivite(rs.getDouble("dureeActivite"));
            valiny.add(result);
        }
        return valiny;
    }
    public void insertActiviteBouquet(int idbouquet,int idactivite,int duree)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into activiteBouquet values(default,"+idactivite+","+idbouquet+","+duree+")";
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