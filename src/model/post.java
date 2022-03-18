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
public class post {
    
 
    //var
    
    private int id_post;
    private String post;
    private String date_post;
    private int id_user;
    private int like_nbr;
    private user user ;
    private String image;
    public post() {
    }
    
    public post(int id_post,String post, String date_post, int id_user,String image ) {
       this.id_post = id_post;
        this.post = post;
        this.date_post = date_post;
        this.id_user = id_user;
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id_post;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final post other = (post) obj;
        if (this.id_post != other.id_post) {
            return false;
        }
        return true;
    }
    
  

    public user getUser() {
        
        return user;
    }
     public void setUser( user user) {
        this.user = user;
    }

    public void setImage(String image) {
        this.image = image;
    }
     
    public String getImage() {
        return image;
    }

    public int getId_post() {
        return id_post;
    }

    public String getPost() {
        return post;
    }

    public String getDate_post() {
        return date_post;
    }

    public int getId_user() {
        return id_user;
    }

    public int getLike_nbr() {
        return like_nbr;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public void setPost(String Post) {
        this.post = Post;
    }

    public void setDate_post(String date_post) {
        this.date_post = date_post;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setLike_nbr(int like_nbr) {
        this.like_nbr = like_nbr;
    }

    public post(int id_post, String post, String date_post) {
        this.id_post = id_post;
        this.post = post;
        this.date_post = date_post;
    }

    public post(int id_post, String post, String date_post, int like_nbr) {
        this.id_post = id_post;
        this.post = post;
        this.date_post = date_post;
        this.like_nbr = like_nbr;
    }

    @Override
    public String toString() {
        return "post{" + "id_post=" + id_post + ", post=" + post + ", date_post=" + date_post + ", id_user=" + id_user + ", like_nbr=" + like_nbr + '}';
    }

    }
    
    
