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
public class Offre {
     //var
    private int id_offre ;
    private int prc;
    private int id_prod;
    private String date_debut;
    private String date_fin;
    
    public Offre(){
        
    }
    
    public Offre ( int id_offre, int prc, int id_prod, String date_debut, String date_fin) {
        this.id_offre = id_offre;
        this.prc = prc;
        this.id_prod = id_prod;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    
    public Offre (int prc, int id_prod, String date_debut, String date_fin) {
        this.prc = prc;
        this.id_prod = id_prod;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    
    //Getters & Setters

    public int getId_offre() {
        return id_offre;
    }

    public int getPrc() {
        return prc;
    }

    public int getId_prod() {
        return id_prod;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setPrc(int prc) {
        this.prc = prc;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }
  //Affichage 
    public String toString(){
         return "Offres{" + "id_offre=" + id_offre + ", pourcentage=" + prc + ", id_produit=" + id_prod + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';    
    }
  
}
