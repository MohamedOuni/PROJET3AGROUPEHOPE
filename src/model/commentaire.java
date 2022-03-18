/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ouni
 */
public class commentaire {
    
  
    //var
    private int id_com;
    private String comment;
    private String date_comment;
    private int id_user;
    private int id_post;

    public commentaire() {
    }

    public commentaire(String comment, String date_comment, int id_user ,int id_post ) {
        this.comment = comment;
        this.date_comment = date_comment;
        this.id_user = id_user;
        this.id_post = id_post;
    }

    public commentaire(int id_com, String comment, int id_user , int id_post) {
        this.id_com = id_com;
        this.comment = comment;
      
        this.id_user = id_user;
        this.id_post = id_post;
    }

    public commentaire(int id_com, String comment, String date_comment) {
        this.id_com = id_com;
        this.comment = comment;
        this.date_comment = date_comment;
    }
    

    public int getId_com() {
        return id_com;
    }

    public String getComment() {
        return comment;
    }

    public String getDate_comment() {
        return date_comment;
    }

    public int getId_user() {
        return id_user;
    }
    
    public int getId_post() {
        return id_post;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate_comment(String date_comment) {
        this.date_comment = date_comment;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    @Override
    public String toString() {
        return "commentaire{" + "id_com=" + id_com + ", comment=" + comment + ", date_comment=" + date_comment + ", id_user=" + id_user + ", id_post=" + id_post + '}';
    }

   
}
