/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import model.Payment;


/**
 *
 * @author ouni
 */
    
public interface DaoPaymentManager {

    public void insert(Payment payment);
    public int getLastNum(int saleId);
    public List<Payment> getAllBySaleId(int saleId);
    public double getTotalPayment(int saleId);
    
    
}
