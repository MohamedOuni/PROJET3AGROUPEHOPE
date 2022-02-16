/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BEN CHEIKH RABIE
 */
public class Reclamation {
   //var
    private int id_rec;
    private String nom_client;
    private int id_user;
    private String msg;
    
     public Reclamation() {
    }

    
    public Reclamation ( String nom_client, int id_user, String msg) {
        this.nom_client = nom_client;
        this.id_user = id_user;
        this.msg = msg;
    }
    
    public Reclamation(int id_rec, String nom_client, int id_user, String msg) {
        this.id_rec = id_rec;
        this.nom_client = nom_client;
        this.id_user = id_user;
        this.msg = msg;
    }
    
    //Getters & Setters

    public int getId_rec() {
        return id_rec;
    }

    public String getNom_client() {
        return nom_client;
    }

    public int getId_user() {
        return id_user;
    }

    public String getMsg() {
        return msg;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    //Affichage
    @Override
    public String toString() {
        return "Reclamation{" + "id_rec=" + id_rec + ", nom_client=" + nom_client + ", id_user=" + id_user + ", msg=" + msg + '}';
    }
}
