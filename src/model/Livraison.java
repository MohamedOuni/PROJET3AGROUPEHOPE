/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Livraison {
    
  
     private int id;
     private String destination;
     
     private String date;
     private String etat;

    public Livraison() {
    }

    public Livraison(int id, String destination, String date,String etat) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    


    public void setId(int id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", destination=" + destination + ", date=" + date +  '}';
    }
    
    
}
