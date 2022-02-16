/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author bureau
 */
public class Commande {
    
    private int id_cmd;
    private int tel;
    private double montant_tot;
    private String adresse;
    private String date_cmd;
    private String methode_pay;
    private String expidition;
    private int id_user;
    private int id_produit;

    public Commande(int id_cmd, int tel, double montant_tot, String adresse, String date_cmd, String methode_pay, String expidition, int id_user, int id_produit) {
        this.id_cmd = id_cmd;
        this.tel = tel;
        this.montant_tot = montant_tot;
        this.adresse = adresse;
        this.date_cmd = date_cmd;
        this.methode_pay = methode_pay;
        this.expidition = expidition;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    public Commande(int tel, double montant_tot, String adresse, String date_cmd, String methode_pay, String expidition, int id_user, int id_produit) {
        this.tel = tel;
        this.montant_tot = montant_tot;
        this.adresse = adresse;
        this.date_cmd = date_cmd;
        this.methode_pay = methode_pay;
        this.expidition = expidition;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    public Commande(int id_cmd, int tel, String adresse, String methode_pay) {
        this.id_cmd = id_cmd;
        this.tel = tel;
        this.adresse = adresse;
        this.methode_pay = methode_pay;
    }

    public Commande() {
    }

    public int getId_cmd() {
        return id_cmd;
    }

    public void setId_cmd(int id_cmd) {
        this.id_cmd = id_cmd;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getMontant_tot() {
        return montant_tot;
    }

    public void setMontant_tot(double montant_tot) {
        this.montant_tot = montant_tot;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate_cmd() {
        return date_cmd;
    }

    public void setDate_cmd(String date_cmd) {
        this.date_cmd = date_cmd;
    }

    public String getMethode_pay() {
        return methode_pay;
    }

    public void setMethode_pay(String methode_pay) {
        this.methode_pay = methode_pay;
    }

    public String getExpidition() {
        return expidition;
    }

    public void setExpidition(String expidition) {
        this.expidition = expidition;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_cmd=" + id_cmd + ", tel=" + tel + ", montant_tot=" + montant_tot + ", adresse=" + adresse + ", date_cmd=" + date_cmd + ", methode_pay=" + methode_pay + ", expidition=" + expidition + ", id_user=" + id_user + ", id_produit=" + id_produit + '}';
    }

   
}

