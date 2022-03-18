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
public class Rate {
    private int rateValue;
    private int postId;
    private int rateId;

    public Rate(int rateValue, int postId, int rateId) {
        this.rateValue = rateValue;
        this.postId = postId;
        this.rateId = rateId;
    }

    public void setRateValue(int rateValue) {
        this.rateValue = rateValue;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getRateValue() {
        return rateValue;
    }

    public int getPostId() {
        return postId;
    }

    public int getRateId() {
        return rateId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.rateValue;
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
        final Rate other = (Rate) obj;
        if (this.rateValue != other.rateValue) {
            return false;
        }
        return true;
    }
    
    
    

    @Override
    public String toString() {
        return "Rate{" + "rateValue=" + rateValue + ", postId=" + postId + ", rateId=" + rateId + '}';
    }
    
    
    
    
    
}
