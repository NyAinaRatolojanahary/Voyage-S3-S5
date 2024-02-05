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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import utils.connectBase;

/**
 *
 * @author Ny Aina Ratolo
 */
public class Employee {
    
    int idEmployee;
    String nom;
    double tjm;
    String nomEmployee;
    Date dateEmbauche;
    Date anciennete;
    
    int idTypeEmployee;
    String nomTypeEmployee;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTjm() {
        return tjm;
    }

    public void setTjm(double tjm) throws Exception {
        if(tjm>0){
            this.tjm = tjm;
        }
        else{ throw new Exception("Le TJM doit etre superieur a 0");}
    }

    public int getIdTypeEmployee() {
        return idTypeEmployee;
    }

    public void setIdTypeEmployee(int idTypeEmployee) {
        this.idTypeEmployee = idTypeEmployee;
    }

    public String getNomTypeEmployee() {
        return nomTypeEmployee;
    }

    public void setNomTypeEmployee(String nomTypeEmployee) {
        this.nomTypeEmployee = nomTypeEmployee;
    }

    public String getNomEmployee() {
        return nomEmployee;
    }

    public void setNomEmployee(String nomEmployee) {
        this.nomEmployee = nomEmployee;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    
    public void setDateEmbauche(String dateEmbauche){
//        LocalDate aujourdHui = LocalDate.now(); // Get current date

//        if (!dateSaisie.isBefore(aujourdHui)) {
            if (!dateEmbauche.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateSaisie = LocalDate.parse(dateEmbauche, formatter);
            this.dateEmbauche = Date.valueOf(dateSaisie);
        } else {
            System.out.println("La date d'embauche doit être aujourd'hui ou antérieure à aujourd'hui.");
        }
    }

    public Date getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Date anciennete) {
        this.anciennete = anciennete;
    }

    
    
    public Employee() {
    }

    public Employee(int idEmployee, String nom) {
        this.idEmployee = idEmployee;
        this.nom = nom;
    }

    public Employee(String nom) {
        this.nom = nom;
    }

    public Employee(double tjm, int idTypeEmployee, String nomTypeEmployee) {
        this.tjm = tjm;
        this.idTypeEmployee = idTypeEmployee;
        this.nomTypeEmployee = nomTypeEmployee;
    }

    public Employee(double tjm, String nomTypeEmployee) {
        this.tjm = tjm;
        this.nomTypeEmployee = nomTypeEmployee;
    }
    
    
    public void insertTypeEmployee(String nom,double tjm)throws SQLException, Exception{
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into typeEmployee(idTypeEmployee,nomTypeEmployee,tjm) values(default,'"+ nom+"',"+ tjm+")";
        try{
            int resultat = state.executeUpdate(requete);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        se_connecter.close();
        state.close();
    }
    
    public void insertEmployee(String nom,String date,double th)throws SQLException, Exception{
        Employee emp = new Employee();
        emp.setNomEmployee(nom);
        emp.setDateEmbauche(date);
        Connection se_connecter = connectBase.connect();
        Statement state = se_connecter.createStatement();
        String requete = "insert into employee(idEmploye,nomEmploye,dateEmbauche,th,idTypeEmployee) values(default,'"+ emp.getNomEmployee()+"','"+ emp.getDateEmbauche()+"',"+th+",1)";
        try{
            int resultat = state.executeUpdate(requete);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        se_connecter.close();
        state.close();
    }
    
    public ArrayList<Employee> getAllEmployee() throws SQLException, Exception{
        ArrayList<Employee> valiny = new ArrayList<Employee>();
        String requete = "Select idEmploye,nomEmploye from employee";
        Connection con = connectBase.connect();
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(requete);
        while (rs.next()) {
            Employee result = new Employee();
            result.setIdEmployee(rs.getInt("idEmploye"));
            result.setNomEmployee(rs.getString("nomEmploye"));
            valiny.add(result);
        }
        return valiny;
    }
    
    public ArrayList<Employee> getAllTypeEmployee() throws SQLException, Exception{
        ArrayList<Employee> valiny = new ArrayList<Employee>();
        String requete = "Select idTypeEmployee,nomTypeEmployee from typeEmployee";
        Connection con = connectBase.connect();
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(requete);
        while (rs.next()) {
            Employee result = new Employee();
            result.setIdTypeEmployee(rs.getInt("idTypeEmployee"));
            result.setNomTypeEmployee(rs.getString("nomTypeEmployee"));
            valiny.add(result);
        }
        return valiny;
    }
    
    public ArrayList<Employee> ListeEmployeePoste() throws SQLException, Exception{
        ArrayList<Employee> valiny = new ArrayList<Employee>();
        String requete = "Select * from v_listeEmployee";
        Connection con = connectBase.connect();
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(requete);
        while (rs.next()) {
            Employee result = new Employee();
            result.setNomEmployee(rs.getString("nomEmploye"));
            result.setDateEmbauche(rs.getDate("dateEmbauche"));
            result.setNomTypeEmployee(rs.getString("nomTypeEmployee"));
            result.setTjm(rs.getDouble("th"));
//            result.setAnciennete(rs.getDate("anciennete"));
            valiny.add(result);
        }
        return valiny;
    }
    
    
}
