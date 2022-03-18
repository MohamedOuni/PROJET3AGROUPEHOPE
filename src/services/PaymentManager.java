/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.maConnexion;
import model.Payment;

/**
 *
 * @author ouni
 */
public class PaymentManager {
    
Connection cnx = maConnexion.getInstance().getCnx();
    
    public PaymentManager(){
   Connection cnx = maConnexion.getInstance().getCnx();
    }
    
 
    public void insert(Payment payment){
    String sql;
    sql = "INSERT INTO payment(saleId,num,amount,date,type) values (?,?,?,?,?)";
    try{
           PreparedStatement st = cnx.prepareStatement(sql);
           st.setInt(1, payment.getSaleId());
           st.setInt(2, payment.getNum());
           st.setDouble(3, payment.getAmount());
           st.setString(4, payment.getDate());
           st.setString(5, payment.getType());
          
           st.execute();
           
       }catch(SQLException e){
       
       }
    
    }
    
    
    

    public int getLastNum(int saleId){
    ResultSet resultSet;
    int lastNum = 0;
    String sql = "SELECT * FROM payment where saleId = ?";
    try{
           PreparedStatement st = cnx.prepareStatement(sql);
        st.setInt(1, saleId);
        resultSet = st.executeQuery();
        while(resultSet.next()){
           lastNum = resultSet.getInt("num");    
           }
        
    }
    catch(SQLException e){
    
    }
    return lastNum;
    }
    
    

    public List<Payment> getAllBySaleId(int saleId){
    List<Payment> list = new ArrayList<>();
    ResultSet resultSet;
    
    String sql = "SELECT * FROM payment where saleId = "+saleId;
    try{
           PreparedStatement st = cnx.prepareStatement(sql);
           
      resultSet = st.executeQuery(sql);
      while(resultSet.next()){
      list.add(new Payment(resultSet.getInt("id"),resultSet.getInt("saleId"),resultSet.getInt("num"),resultSet.getDouble("amount"),resultSet.getString("date"),resultSet.getString("type")));
      }
    }catch(SQLException e){
    }
    
    
    return list;
}
    
  
    public double getTotalPayment(int saleId){
    double total = 0;     
    ResultSet resultSet;
    
    String sql = "SELECT * FROM payment where saleId = ?";
    try{
           PreparedStatement st = cnx.prepareStatement(sql);
      st.setInt(1, saleId);
      resultSet = st.executeQuery();
      while(resultSet.next()){
      total = total + resultSet.getDouble("amount"); 
      }
    }catch(SQLException e){
    }
    
    
    return total;
}
    
}
    

