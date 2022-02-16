/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rania
 */
public class Produit {
    //var
    private int id_produit;
    public String nom_produit;
    public int quantite;
    public float prix;
    public String categorie;
    
    
    
    
    //Constructor
    public Produit() {
    }

    public Produit(int id_produit, String nom_produit, int quantite, float prix, String categorie) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit(String nom_produit, int quantite, float prix, String categorie) {
        this.nom_produit = nom_produit;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId_produit() {   
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom) {
        this.nom_produit = nom_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    //Getters & Setters
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    //Affichage

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", quantite=" + quantite + ", prix=" + prix + ", categorie=" + categorie + '}';
    }
   
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}


