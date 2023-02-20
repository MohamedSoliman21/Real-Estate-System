/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Youssef Abdulaziz
 */
public class PaymentContext {
    
    private PaymentMethod paymentMethod;
    
    private void setPaymentStrategy(PaymentMethod strategy)
    {
         this.paymentMethod = strategy;
    }
    public PaymentMethod getPaymentStrategy(){
        return paymentMethod;
    }
    public void pay(String amount)
    {
        paymentMethod.payment(amount);
        
    }
}
