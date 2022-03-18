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
public class Payment {
    

private int id;
private int saleId;
private int num;
private double amount;
private String date;
private String type;

public Payment(int id, int saleId, int num, double amount,String date, String type){

    
this.id = id;
this.saleId = saleId;
this.num =num;
this.amount = amount;
this.date = date;
this.type = type;
        
}

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", saleId=" + saleId + ", num=" + num + ", amount=" + amount + ", date=" + date + ", type=" + type + '}';
    }

    public Payment(int saleId, int num, double amount, String date, String type) {
        this.saleId = saleId;
        this.num = num;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getNum() {
        return num;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }




    
}