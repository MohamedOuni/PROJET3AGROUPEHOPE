/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rania
 */
public class Panier {
     private int id_produit;
     
    private int id_user;
     private int quantite;

    public Panier() {
    }

    public Panier(int id_produit, int id_user, int quantite) {
        this.id_produit = id_produit;
        this.id_user = id_user;
        this.quantite = quantite;
    }

    public Panier(int id_user, int quantite) {
        this.id_user = id_user;
        this.quantite = quantite;
    }

    public Panier(int quantite) {
        this.quantite = quantite;
    }

   

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_produit=" + id_produit + ", id_user=" + id_user + ", quantite=" + quantite + '}';
    }
     
     
     
     
}

